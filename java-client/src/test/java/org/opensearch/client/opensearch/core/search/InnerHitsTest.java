/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.core.search;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import jakarta.json.stream.JsonGenerator;
import jakarta.json.stream.JsonParser;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;
import org.junit.Test;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.JsonpSerializable;
import org.opensearch.client.json.jsonb.JsonbJsonpMapper;
import org.opensearch.client.opensearch.core.SearchRequest;

public class InnerHitsTest {
    private final JsonpMapper mapper = new JsonbJsonpMapper();
    private final String storedSalary = "details.salary";
    private final String storedJobId = "details.jobId";

    /**
     * test if the json field for storedFields is generated with the correct name "stored_fields"
     */
    @Test
    public void testInnerHitStoredFields() {
        InnerHits hits = InnerHits.of((it) -> it.storedFields(Arrays.asList("field1", "field2")));
        assertTrue(toJson(hits).contains("stored_fields"));
    }

    /**
     * test if the field "stored_fields" is present after deserialization/serialization
     * of InnerHits
     */
    @Test
    public void testInnerHitFromParsed() {
        JsonParser parser = mapper.jsonProvider().createParser(new StringReader(innerHitsJson));
        InnerHits innerHits = InnerHits._DESERIALIZER.deserialize(parser, mapper);
        assertThat(innerHits.storedFields(), containsInAnyOrder(storedJobId, storedSalary));
        String actualJson = toJson(innerHits);
        assertEquals(innerHitsJson, actualJson);

    }

    /**
     * We test if the field "stored_fields" is present in the InnerHits after deserialization/serialization
     * of a SearchRequest
     */
    @Test
    public void testRequestWithInnerHitFromParsed() {
        JsonParser parser = mapper.jsonProvider().createParser(new StringReader(searchRequestJson));
        SearchRequest searchRequest = SearchRequest._DESERIALIZER.deserialize(parser, mapper);
        InnerHits innerHits = searchRequest.query().bool().must().get(1).nested().innerHits();
        assertThat(innerHits.storedFields(), containsInAnyOrder(storedJobId, storedSalary));
        String actualJson = toJson(searchRequest);
        assertEquals(searchRequestJson, actualJson);
    }

    private String toJson(JsonpSerializable obj) {
        StringWriter stringWriter = new StringWriter();
        try (JsonGenerator generator = mapper.jsonProvider().createGenerator(stringWriter)) {
            mapper.serialize(obj, generator);
        }
        return stringWriter.toString();
    }

    private final String innerHitsJson = String.format("{\"_source\":false,\"stored_fields\":[\"%s\",\"%s\"]}", storedJobId, storedSalary);
    private final String searchRequestJson = String.format(
        "{\"_source\":false,\"query\":{\"bool\":{\"must\":[{\"match_all\":{}},{\"nested\":{\"inner_hits\":%s,\"path\":\"details\","
            + "\"query\":{\"match_all\":{}}}}]}},\"stored_fields\":[\"title\",\"companyName\"]}",
        innerHitsJson
    );
}
