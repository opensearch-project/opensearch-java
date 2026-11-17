# Node sniffing

The sniffer keeps the client's node list in sync with the cluster by periodically calling
`GET /_nodes/http` **through the client's own authenticated transport** and updating the transport's
node set.

> **When _not_ to use it:** if the client reaches the cluster through a load balancer, proxy, or
> managed endpoint, the addresses published by `_nodes/http` are usually unreachable from the client.
> Only enable sniffing when the client has direct network access to every node.

```java
SniffOnFailureListener sniffListener = new SniffOnFailureListener();

ApacheHttpClient5Transport transport = ApacheHttpClient5TransportBuilder
    .builder(new HttpHost("https", "seed-node", 9200))
    .setFailureListener(sniffListener)          // re-sniff on failure
    .build();

Sniffer sniffer = new SnifferBuilder(transport) // discover via + publish into this transport
    .setSniffIntervalMillis(TimeUnit.MINUTES.toMillis(5))
    .build();
sniffListener.setSniffer(sniffer);              // wire the listener to the sniffer
sniffer.start();

OpenSearchClient client = new OpenSearchClient(transport);
// ... use the client; the sniffer refreshes nodes in the background ...

sniffer.close();                                // stops the background thread
```

The transport-wired builder infers the scheme (`http`/`https`) from the transport's own nodes, so you
normally don't call `setScheme(...)`; use it only to override the inferred value. If the transport's
nodes have mixed schemes, the inferred scheme defaults to `https` and a warning is logged — call
`setScheme(...)` explicitly to silence the ambiguity.

## How it works

- `Sniffer` runs a background daemon thread that calls `NodesSniffer.sniff()` on a fixed interval
  (default 5 minutes) and on demand after a request failure.
- The default `OpenSearchNodesSniffer` issues `GET /_nodes/http` through the supplied
  `OpenSearchTransport` (reusing its TLS, credentials, and default headers) and parses each node's
  `http.publish_address`, roles, version, name, and bound addresses. A node with a usable
  `publish_address` is kept even if an individual metadata field (name, version, a role entry) is
  malformed — the bad field simply degrades to `null`.
- Discovered nodes are handed to a `NodeSetConsumer` **only when cluster membership actually
  changes**; an unchanged node set is not republished. The transport-wired builder uses
  `ApacheHttpClient5Transport::setNodes`, which publishes the live node list and clears the per-host
  failure denylist — so skipping the no-op republish preserves the exponential backoff for hosts
  that are still registered but unreachable.
- `SniffOnFailureListener` bridges the transport's `FailureListener` to `Sniffer.sniffOnFailure()`
  so a failed request triggers an immediate re-discovery. Repeated failures only ever move the next
  sniff *sooner* (never further out), so a burst of failures can't starve the periodic sniff.
