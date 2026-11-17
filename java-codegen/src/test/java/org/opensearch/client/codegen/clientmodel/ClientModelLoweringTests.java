/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.clientmodel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.Test;

public class ClientModelLoweringTests {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    private static JsonNode json(String text) throws Exception {
        return MAPPER.readTree(text.replace('\'', '"'));
    }

    private static ObjectNode lowered() throws Exception {
        var model = json(
            "{'format':'opensearch-client-model','version':'0.2.0','types':{"
                + "'a___Id':{'type_kind':'alias','type':{'scalar':'string'}},"
                + "'a___Lookup':{'type_kind':'object','fields':{"
                + "'index':{'type':{'scalar':'string'},'required':true},'id':{'type':{'ref':'a___Id'},'required':false},"
                + "'query':{'type':{'scalar':'string'},'required':false}},"
                + "'constraints':[{'union_kind':'presence','one_of':[['id'],['query']]}]},"
                + "'a___Container':{'type_kind':'object','fields':{},'constraints':[{'union_kind':'container','variants':{"
                + "'avg':{'value':{'ref':'a___Id'},'extra_fields':{},'extra_constraints':[]}}}]},"
                + "'a___Hits':{'type_kind':'object','fields':{'meta':{'type':{'map':{'any':true}},'required':false},"
                + "'total':{'type':{'ref':'a___Total'},'required':false}},'additional_fields':{'any':true},'constraints':[]},"
                + "'a___Total':{'type_kind':'object','fields':{},'constraints':[]}"
                + "},'responses':{},'request_bodies':{}}"
        );
        var spec = (ObjectNode) json(
            "{'components':{'schemas':{"
                + "'a___Id':{'type':'string','description':'An id.'},"
                + "'a___Hits':{'type':'object','properties':{"
                + "'meta':{'type':'object','propertyNames':{'title':'key'},'additionalProperties':{'title':'value'}},"
                + "'total':{'allOf':[{'$ref':'#/components/schemas/a___Total'},{'type':'object','properties':{}}]}},"
                + "'additionalProperties':{'title':'meta_fields'}}"
                + "}}}"
        );
        new ClientModelLowering(model).lower(spec);
        return (ObjectNode) spec.path("components").path("schemas");
    }

    @Test
    void presenceConstraintsAreNotWritten() throws Exception {
        var lookup = lowered().get("a___Lookup");
        assertFalse(lookup.has("allOf"), "a presence constraint would make the generator see a tagged union");
        assertEquals(json("['index']"), lookup.get("required"));
    }

    @Test
    void aContainerIsAUnionOfSingleKeyObjects() throws Exception {
        var union = lowered().get("a___Container").get("allOf").get(1);
        assertEquals(
            json("[{'type':'object','properties':{'avg':{'$ref':'#/components/schemas/a___Id'}},'required':['avg']}]"),
            union.get("oneOf")
        );
    }

    @Test
    void annotationsPropertyNamesAndMapTitlesAreKept() throws Exception {
        var schemas = lowered();
        assertEquals("An id.", schemas.get("a___Id").get("description").asText());
        var hits = schemas.get("a___Hits");
        assertEquals("meta_fields", hits.get("additionalProperties").get("title").asText());
        var meta = hits.get("properties").get("meta");
        assertEquals("key", meta.get("propertyNames").get("title").asText());
        assertEquals("value", meta.get("additionalProperties").get("title").asText());
    }

    @Test
    void genericInstantiationSitesAreKept() throws Exception {
        var total = lowered().get("a___Hits").get("properties").get("total");
        assertEquals("#/components/schemas/a___Total", total.get("allOf").get(0).get("$ref").asText());
    }
}
