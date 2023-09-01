/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.samples;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.opensearch.client.opensearch.indices.CreateDataStreamRequest;
import org.opensearch.client.opensearch.indices.DataStream;
import org.opensearch.client.opensearch.indices.DataStreamsStatsRequest;
import org.opensearch.client.opensearch.indices.DataStreamsStatsResponse;
import org.opensearch.client.opensearch.indices.DeleteDataStreamRequest;
import org.opensearch.client.opensearch.indices.GetDataStreamRequest;
import org.opensearch.client.opensearch.indices.GetDataStreamResponse;
import org.opensearch.client.opensearch.indices.PutIndexTemplateRequest;

/**
 * Run with: <c>./gradlew :samples:run -Dsamples.mainClass=DataStreamBasics</c>
 */
public class DataStreamBasics {
    private static final Logger LOGGER = LogManager.getLogger(DataStreamBasics.class);

    public static void main(String[] args) {
        try {
            var client = SampleClient.create();

            var version = client.info().version();
            LOGGER.info("Server: {}@{}", version.distribution(), version.number());

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
            client.indices().putIndexTemplate(putIndexTemplateRequest);
            
            // Create a data stream
            CreateDataStreamRequest createDataStreamRequest = new CreateDataStreamRequest.Builder().name(dataStreamName).build();
            client.indices().createDataStream(createDataStreamRequest);
            LOGGER.info("Created a data stream");

            GetDataStreamRequest getDataStreamRequest = new GetDataStreamRequest.Builder().name(dataStreamName).build();
            GetDataStreamResponse getDataStreamResponse = client.indices().getDataStream(getDataStreamRequest);
            LOGGER.info("Found {} data streams", getDataStreamResponse.dataStreams().size());

            DataStreamsStatsRequest dataStreamsStatsRequest = new DataStreamsStatsRequest.Builder().name(dataStreamName).build();
            DataStreamsStatsResponse dataStreamsStatsResponse = client.indices().dataStreamsStats(dataStreamsStatsRequest);
            LOGGER.info("Data stream stats:");
            LOGGER.info("Shards: {}", dataStreamsStatsResponse.shards());
            LOGGER.info("Data stream count: {}", dataStreamsStatsResponse.dataStreamCount());
            LOGGER.info("Backing indices: {}", dataStreamsStatsResponse.backingIndices());
            LOGGER.info("Total store size: {}", dataStreamsStatsResponse.totalStoreSize());
            LOGGER.info("Data stream name: {}", dataStreamsStatsResponse.dataStreams().get(0).dataStream());

            LOGGER.info("Deleting data stream");
            DeleteDataStreamRequest deleteDataStreamRequest = new DeleteDataStreamRequest.Builder().name(dataStreamName).build();
            client.indices().deleteDataStream(deleteDataStreamRequest);
        } catch (Exception e) {
            LOGGER.error("Unexpected exception", e);
        }
    }
}
