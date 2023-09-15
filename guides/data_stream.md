- [Data Stream API](#data-stream-api)
  - [Create a data stream](#create-a-data-stream)
  - [Get data stream](#get-data-stream)
  - [Data stream stats](#data-stream-stats)
  - [Delete data stream and backing indices](#delete-data-stream-and-backing-indices)

# Data Stream API

## Create a data stream
Before creating a data stream, you need to create an index template which configures a set of indices as a data stream.
A data stream must have a timestamp field. If not specified, OpenSearch uses `@timestamp` as the default timestamp field name. 

The following sample code creates an index template for data stream with a custom timestamp field, and creates a data stream 
which matches the name pattern specified in the index template. 
```java
String dataStreamIndexTemplateName = "sample-data-stream-template";
String timestampFieldName = "my_timestamp_field";
String namePattern = "sample-data-stream-*";
String dataStreamName = "sample-data-stream-1";

// Create an index template which configures data stream
PutIndexTemplateRequest putIndexTemplateRequest = new PutIndexTemplateRequest.Builder()
        .name(dataStreamIndexTemplateName)
        .indexPatterns(namePattern)
        .dataStream(new DataStream.Builder()
                .timestampField(t -> t.name(timestampFieldName))
                .build())
        .build();
PutIndexTemplateResponse putIndexTemplateResponse = client.indices().putIndexTemplate(putIndexTemplateRequest);

// Create a data stream
CreateDataStreamRequest createDataStreamRequest = new CreateDataStreamRequest.Builder().name(dataStreamName).build();
CreateDataStreamResponse createDataStreamResponse = client.indices().createDataStream(createDataStreamRequest);
```

## Get data stream
```java
GetDataStreamRequest getDataStreamRequest = new GetDataStreamRequest.Builder().name(dataStreamName).build();
GetDataStreamResponse getDataStreamResponse = client.indices().getDataStream(getDataStreamRequest);
```

## Data stream stats
```java
DataStreamsStatsRequest dataStreamsStatsRequest = new DataStreamsStatsRequest.Builder().name(dataStreamName).build();
DataStreamsStatsResponse dataStreamsStatsResponse = client.indices().dataStreamsStats(dataStreamsStatsRequest);
```

## Delete data stream and backing indices
```java
DeleteDataStreamRequest deleteDataStreamRequest = new DeleteDataStreamRequest.Builder().name(dataStreamName).build();
DeleteDataStreamResponse deleteDataStreamResponse = client.indices().deleteDataStream(deleteDataStreamRequest);
```

You can find a working sample of the above code in [DataStreamBasics.java](../samples/src/main/java/org/opensearch/client/samples/DataStreamBasics.java).