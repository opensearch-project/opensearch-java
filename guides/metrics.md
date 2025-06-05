- [SDK Metrics](#SDK-Metrics)
    - [How to enable metrics](#get-client)
    - [Metrics Collected](#metrics-collected)

# SDK Metrics

We've integrated a robust metrics solution into the OpenSearch Java client to provide comprehensive insights into its API usage and performance. This includes the collection of vital operational metrics, such as overall throughput, request latency, and error rate. Furthermore, we're capturing more granular details like request and response payload sizes, distinct success and failure rates for operations, and real-time OpenSearch node status to provide a holistic view of client behavior and cluster health.

The implementation utilizes [Micrometer](https://mvnrepository.com/artifact/io.micrometer/micrometer-core), which supports integrations with various popular monitoring systems ([see their overview](https://docs.micrometer.io/micrometer/reference/implementations.html)). This enables seamless collection and export of metrics to tools like Prometheus and Grafana, allowing real-time monitoring of the OpenSearch client's performance and health.

## How to enable metrics

We should create a `MetricOptions` instance and set it in the `ApacheHttpClient5TransportBuilder` when creating the client. Take a look at below code snippet for an example of how to create a client with metrics enabled:

```java
public class CreateClient {
  public static OpenSearchClient createClientWithMetrics() throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
    var env = System.getenv();
    var https = Boolean.parseBoolean(env.getOrDefault("HTTPS", "true"));
    var hostname = env.getOrDefault("HOST", "localhost");
    var port = Integer.parseInt(env.getOrDefault("PORT", "9200"));
    var user = env.getOrDefault("USERNAME", "admin");
    var pass = env.getOrDefault("PASSWORD", "admin");
    var metricsEnabled = true;
    double PERCENTILE_99 = 0.99;
    double PERCENTILE_95 = 0.95;
    var meterRegistry =  new SimpleMeterRegistry();

    final var hosts = new HttpHost[]{new HttpHost(https ? "https" : "http", hostname, port)};

    final var sslContext = SSLContextBuilder.create().loadTrustMaterial(null, (chains, authType) -> true).build();

    MetricOptions metricOptions = MetricOptions.builder()
            .setMetricsEnabled(metricEnabled) // required to turn metrics on/off
            .setMeterRegistry(meterRegistry) 
            .setPercentiles(PERCENTILE_99, PERCENTILE_95)
            .setAdditionalMetricGroups(MetricGroup.NETWORK_DETAILS)
            .setExcludedTags(MetricTag.HOST_CONTACTED)
            .build();

    final var transport = ApacheHttpClient5TransportBuilder.builder(hosts)
            .setMapper(new JacksonJsonpMapper())
            .setMetricOptions(metricOptions)
            .setHttpClientConfigCallback(httpClientBuilder -> {
              final var credentialsProvider = new BasicCredentialsProvider();
              for (final var host : hosts) {
                credentialsProvider.setCredentials(new AuthScope(host), new UsernamePasswordCredentials(user, pass.toCharArray()));
              }

// Disable SSL/TLS verification as our local testing clusters use self-signed certificates
              final var tlsStrategy = ClientTlsStrategyBuilder.create()
                      .setSslContext(sslContext)
                      .setHostnameVerifier(NoopHostnameVerifier.INSTANCE)
                      .build();

              final var connectionManager = PoolingAsyncClientConnectionManagerBuilder.create().setTlsStrategy(tlsStrategy).build();

              return httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider).setConnectionManager(connectionManager);
            })
            .build();
    return new OpenSearchClient(transport);
  }
}
```

## Metrics Collected

The OpenSearch Java client collects a variety of metrics to provide insights into its operations. Below is a summary of the key metrics collected, along with their descriptions and important dimensions, such as status code and request type, that can be used for filtering and analysis.

| Metric                                  | Description                                                     | Important Dimensions(tags)         |
|-----------------------------------------|-----------------------------------------------------------------|------------------------------------|
| `os.client.request.seconds`             | End-to-end request execution latency                            | `StatusCodeOrException`, `Request` |
| `os.client.request.seconds.count`       | request throughput and error rate based on status tags          | `StatusCodeOrException`, `Request` |
| `os.client.request.payload.size.bytes`  | Request payload size in bytes                                   | `Request`                          |
| `os.client.response.payload.size.bytes` | Response payload size in bytes                                  | `Request`                          |
| `os.client.active.nodes`                | Number of OpenSearch active nodes from a client's perspective   |                                    |
| `os.client.inactive.nodes`              | Number of OpenSearch inactive nodes from a client's perspective |                                    |