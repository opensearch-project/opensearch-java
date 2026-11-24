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
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
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

    private static final String ANNOTATED = String.join(
        "\n",
        "components:",
        "  x-model: {format: opensearch-client-model, version: 0.2.0}",
        "  schemas:",
        "    a___Lookup:",
        "      type: object",
        "      properties: {index: {type: string}, id: {type: string}, path: {type: string}}",
        "      required: [index]",
        "      x-model:",
        "        type_kind: object",
        "        fields:",
        "          index: {type: {scalar: string}, required: true}",
        "          id: {type: {scalar: string}, required: false}",
        "          path: {type: {scalar: string}, required: false}",
        "        constraints: []",
        "  responses:",
        "    a.get___200:",
        "      content: {application/json: {schema: {$ref: '#/components/schemas/a___Lookup'}}}",
        "      x-model: {media_type: application/json, type: {ref: a___Lookup}}",
        "  requestBodies:",
        "    a.put:",
        "      content: {application/json: {schema: {$ref: '#/components/schemas/a___Lookup'}}}",
        "      x-model: {media_type: application/json, type: {ref: a___Lookup}}",
        ""
    );

    @Test
    void theModelIsAssembledFromTheXModelExtensions() throws Exception {
        var model = ClientModelLowering.assemble(ClientModelLowering.yamlMapper().readTree(ANNOTATED), "test");
        assertEquals("opensearch-client-model", model.get("format").asText());
        assertEquals("0.2.0", model.get("version").asText());
        assertEquals(json("{'ref':'a___Lookup'}"), model.get("responses").get("a.get___200").get("type"));
        assertEquals(json("{'ref':'a___Lookup'}"), model.get("request_bodies").get("a.put").get("type"));
        var fields = new ArrayList<String>();
        model.get("types").get("a___Lookup").get("fields").fieldNames().forEachRemaining(fields::add);
        assertEquals(List.of("index", "id", "path"), fields, "the fields keep the order of the specification");
    }

    @Test
    void aSpecificationWithoutAClientModelIsRejected() throws Exception {
        var spec = ClientModelLowering.yamlMapper().readTree("components: {schemas: {a___Id: {type: string}}}");
        var e = assertThrows(IOException.class, () -> ClientModelLowering.assemble(spec, "spec.yaml"));
        assertTrue(e.getMessage().contains("components.x-model"), e.getMessage());
    }

    @Test
    void theModelDoesNotLeakIntoTheLoweredSpecification() throws Exception {
        var spec = (ObjectNode) ClientModelLowering.yamlMapper().readTree(ANNOTATED);
        var model = ClientModelLowering.assemble(spec, "test");
        ClientModelLowering.strip(spec);
        new ClientModelLowering(model).lower(spec);
        assertFalse(spec.toString().contains("x-model"), spec.toString());

        // and mergeAnnotations doesn't copy it from an original schema that still has it
        var lowered = new ClientModelLowering(model).entry(model.get("types").get("a___Lookup"));
        ClientModelLowering.mergeAnnotations(
            lowered,
            ClientModelLowering.yamlMapper().readTree(ANNOTATED).path("components").path("schemas").path("a___Lookup")
        );
        assertFalse(lowered.has("x-model"));
    }

    @Test
    void theVendoredSpecificationCarriesTheModelInItsOrder() throws Exception {
        var spec = ClientModelLowering.yamlMapper().readTree(Path.of("opensearch-openapi.yaml").toFile());
        var model = ClientModelLowering.assemble(spec, "opensearch-openapi.yaml");
        var fields = new ArrayList<String>();
        model.get("types").get("_common.query_dsl___TermsLookup").get("fields").fieldNames().forEachRemaining(fields::add);
        assertEquals(List.of("index", "id", "path", "routing", "query", "store"), fields);
    }
}
