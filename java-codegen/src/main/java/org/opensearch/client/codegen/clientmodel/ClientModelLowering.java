/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.clientmodel;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.opensearch.client.codegen.openapi.OpenApiSpecification;
import org.yaml.snakeyaml.LoaderOptions;

/**
 * Rewrites a specification so that every type comes from the resolved client model of opensearch-api-specification instead of from the
 * specification's {@code allOf}/{@code oneOf}/{@code anyOf}. The model is written into the specification by {@code npm run merge} there
 * (opensearch-api-specification#1329): {@code components.x-model} gives its format and version, every component schema has its type as
 * {@code x-model}, and every response and request body component its body as {@code x-model}. {@link #assemble} gathers these into one
 * model, {@code {format, version, types, responses, request_bodies}}. The component schemas and the JSON bodies of the response and request
 * body components are replaced with schemas built from the model, in one canonical form the code generator reads:
 * <ul>
 * <li>an object is {@code allOf}: one {@code $ref} per base, then its own fields as one inline object, then one {@code oneOf}/{@code anyOf}
 * per container or other union constraint. Presence constraints ("exactly one of" / "at least one of" fields the object declares) are not
 * written: their fields are ordinary optional fields, and writing them as a {@code oneOf} would make the generator take the object for a
 * tagged union;</li>
 * <li>a union is a plain {@code oneOf}/{@code anyOf} of its members, with their titles;</li>
 * <li>an alias is its type.</li>
 * </ul>
 * Generic type parameters keep their schema, and the annotations of the original schemas and of their own properties (descriptions,
 * defaults, deprecation, discriminators, {@code x-*} extensions) are kept. Operations, paths and parameters are not changed.
 */
public final class ClientModelLowering {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String FORMAT = "opensearch-client-model";
    private static final Set<String> SUPPORTED_VERSIONS = Set.of("0.2.0");
    private static final String MODEL_KEY = "x-model";
    private static final String REF_PREFIX = "#/components/schemas/";
    private static final Set<String> ANNOTATIONS = Set.of(
        "description",
        "default",
        "deprecated",
        "title",
        "examples",
        "externalDocs",
        "readOnly",
        "writeOnly",
        "discriminator"
    );
    private static final JsonNodeFactory NODES = JsonNodeFactory.instance;

    private final JsonNode model;
    private final JsonNode types;

    ClientModelLowering(@Nonnull JsonNode model) {
        this.model = model;
        this.types = model.path("types");
    }

    /**
     * Writes the specification at {@code specLocation}, rewritten with the client model it carries in its {@code x-model} extensions, to a
     * temporary file and returns its location.
     */
    @Nonnull
    public static URI lower(@Nonnull URI specLocation) throws IOException {
        var spec = (ObjectNode) yamlMapper().readTree(specLocation.toURL());
        var model = assemble(spec, specLocation.toString());
        strip(spec);
        new ClientModelLowering(model).lower(spec);

        File lowered = File.createTempFile("opensearch-openapi-lowered", ".json");
        lowered.deleteOnExit();
        new ObjectMapper().writeValue(lowered, spec);
        LOGGER.info("Read the types from the client model of {} ({} types)", specLocation, model.path("types").size());
        return lowered.toURI();
    }

    // Reads YAML (and JSON) keeping the order of the keys, which is the order of the fields of the model.
    @Nonnull
    static ObjectMapper yamlMapper() {
        var options = new LoaderOptions();
        options.setCodePointLimit(OpenApiSpecification.MAX_YAML_CODE_POINTS);
        return new ObjectMapper(YAMLFactory.builder().loaderOptions(options).build());
    }

    /**
     * The client model written into {@code spec} by {@code npm run merge} of opensearch-api-specification: {@code format} and
     * {@code version} from {@code components.x-model}, {@code types} from the {@code x-model} of the component schemas, and
     * {@code responses} and {@code request_bodies} from the {@code x-model} of the response and request body components, in the order of
     * the specification.
     */
    @Nonnull
    static ObjectNode assemble(@Nonnull JsonNode spec, @Nonnull String source) throws IOException {
        var components = spec.path("components");
        var header = components.get(MODEL_KEY);
        if (header == null || !header.isObject()) {
            throw new IOException(
                source
                    + " has no client model (components."
                    + MODEL_KEY
                    + "): it must be a specification merged by opensearch-api-specification#1329 or later"
            );
        }
        if (!FORMAT.equals(header.path("format").asText())) {
            throw new IOException(source + " has a components." + MODEL_KEY + " that is not an OpenSearch client model");
        }
        var version = header.path("version").asText();
        if (!SUPPORTED_VERSIONS.contains(version)) {
            throw new IOException("Unsupported client model version " + version + " (supported: " + SUPPORTED_VERSIONS + ")");
        }
        var model = NODES.objectNode().put("format", FORMAT).put("version", version);
        model.set("types", collect(components.path("schemas")));
        model.set("responses", collect(components.path("responses")));
        model.set("request_bodies", collect(components.path("requestBodies")));
        return model;
    }

    @Nonnull
    private static ObjectNode collect(@Nonnull JsonNode section) {
        var entries = NODES.objectNode();
        section.fields().forEachRemaining(e -> {
            var entry = e.getValue().get(MODEL_KEY);
            if (entry != null) entries.set(e.getKey(), entry);
        });
        return entries;
    }

    // Removes the model from the specification, so that it is not read as part of a schema.
    static void strip(@Nonnull ObjectNode spec) {
        var components = spec.path("components");
        if (!(components instanceof ObjectNode)) return;
        ((ObjectNode) components).remove(MODEL_KEY);
        for (var section : List.of("schemas", "responses", "requestBodies")) {
            components.path(section)
                .forEach(component -> { if (component instanceof ObjectNode) ((ObjectNode) component).remove(MODEL_KEY); });
        }
    }

    void lower(@Nonnull ObjectNode spec) {
        var components = (ObjectNode) spec.path("components");
        var schemas = (ObjectNode) components.path("schemas");
        Iterator<Map.Entry<String, JsonNode>> entries = types.fields();
        while (entries.hasNext()) {
            var entry = entries.next();
            var name = entry.getKey();
            var type = entry.getValue();
            if (type.path("generic_parameter").asBoolean(false)) {
                continue; // the generator recognizes generic parameters by x-is-generic-type-parameter
            }
            var lowered = entry(type);
            mergeAnnotations(lowered, schemas.get(name));
            schemas.set(name, lowered);
        }
        lowerBodies(components.get("responses"), model.path("responses"));
        lowerBodies(components.get("requestBodies"), model.path("request_bodies"));
    }

    private void lowerBodies(@Nullable JsonNode components, @Nonnull JsonNode bodies) {
        if (!(components instanceof ObjectNode)) return;
        Iterator<Map.Entry<String, JsonNode>> entries = bodies.fields();
        while (entries.hasNext()) {
            var entry = entries.next();
            var mediaType = entry.getValue().path("media_type").asText();
            var media = components.path(entry.getKey()).path("content").path(mediaType);
            if (media instanceof ObjectNode && media.has("schema")) {
                var lowered = expr(entry.getValue().path("type"));
                mergeAnnotations(lowered, media.get("schema"));
                ((ObjectNode) media).set("schema", lowered);
            }
        }
    }

    @Nonnull
    ObjectNode entry(@Nonnull JsonNode type) {
        switch (type.path("type_kind").asText()) {
            case "object":
                return object(type, true);
            case "union": {
                var members = new ArrayList<JsonNode>();
                if (type.has("variants")) type.get("variants").forEach(members::add);
                else type.path("members").forEach(members::add);
                var union = union(members, type.path("exclusive").asBoolean(true), type.get("titles"));
                if (type.has("discriminator")) {
                    union.set("discriminator", NODES.objectNode().put("propertyName", type.get("discriminator").asText()));
                }
                return union;
            }
            default:
                return expr(type.path("type"));
        }
    }

    @Nonnull
    ObjectNode expr(@Nonnull JsonNode type) {
        if (type.has("ref")) return NODES.objectNode().put("$ref", REF_PREFIX + type.get("ref").asText());
        if (type.has("scalar")) {
            var scalar = NODES.objectNode().put("type", type.get("scalar").asText());
            if (type.has("format")) scalar.put("format", type.get("format").asText());
            return scalar;
        }
        if (type.has("enum")) {
            var values = (ArrayNode) type.get("enum");
            var node = NODES.objectNode();
            if (values.size() > 0 && values.get(0).isTextual()) node.put("type", "string");
            node.set("enum", values.deepCopy());
            return node;
        }
        if (type.has("array")) {
            var array = NODES.objectNode().put("type", "array");
            if (!type.get("array").has("any")) array.set("items", expr(type.get("array")));
            return array;
        }
        if (type.has("map")) {
            var map = NODES.objectNode().put("type", "object");
            if (type.get("map").has("any")) map.put("additionalProperties", true);
            else map.set("additionalProperties", expr(type.get("map")));
            return map;
        }
        if (type.has("union")) {
            var members = new ArrayList<JsonNode>();
            type.get("union").forEach(members::add);
            return union(members, type.path("exclusive").asBoolean(true), type.get("titles"));
        }
        if (type.has("object")) {
            var object = object(type.get("object"), false);
            if (type.has("description")) object.put("description", type.get("description").asText());
            return object;
        }
        return NODES.objectNode();
    }

    @Nonnull
    private ObjectNode union(@Nonnull List<JsonNode> members, boolean exclusive, @Nullable JsonNode titles) {
        var branches = NODES.arrayNode();
        for (int i = 0; i < members.size(); i++) {
            var branch = expr(members.get(i));
            if (titles != null && titles.has(i) && titles.get(i).isTextual()) branch.put("title", titles.get(i).asText());
            branches.add(branch);
        }
        var union = NODES.objectNode();
        union.set(exclusive ? "oneOf" : "anyOf", branches);
        return union;
    }

    // `named`: a component type, which stays an allOf when it has bases so that it remains its own class.
    @Nonnull
    private ObjectNode object(@Nonnull JsonNode shape, boolean named) {
        var bases = new ArrayList<String>();
        shape.path("bases").forEach(b -> bases.add(b.asText()));
        var own = NODES.objectNode().put("type", "object");
        var properties = NODES.objectNode();
        var required = NODES.arrayNode();
        Iterator<Map.Entry<String, JsonNode>> fields = shape.path("fields").fields();
        while (fields.hasNext()) {
            var field = fields.next();
            var declaredIn = field.getValue().path("declared_in");
            var inherited = declaredIn.isTextual();
            if (!inherited) properties.set(field.getKey(), field(field.getValue()));
            // An inherited field that this type makes required is required here too.
            if (field.getValue().path("required").asBoolean(false) && (!inherited || !baseRequires(declaredIn.asText(), field.getKey()))) {
                required.add(field.getKey());
            }
        }
        if (!properties.isEmpty()) own.set("properties", properties);
        if (!required.isEmpty()) own.set("required", required);
        var additional = shape.get("additional_fields");
        if (additional != null && bases.stream().noneMatch(b -> Objects.equals(baseShape(b).get("additional_fields"), additional))) {
            if (additional.has("any")) own.put("additionalProperties", true);
            else own.set("additionalProperties", expr(additional));
        }

        var constraints = new ArrayList<ObjectNode>();
        for (var constraint : shape.path("constraints")) {
            var lowered = constraint(constraint);
            if (lowered != null) constraints.add(lowered);
        }
        if (bases.isEmpty() && constraints.isEmpty()) return own;
        var allOf = NODES.arrayNode();
        bases.forEach(b -> allOf.add(NODES.objectNode().put("$ref", REF_PREFIX + b)));
        if (own.size() > 1 || named) allOf.add(own);
        constraints.forEach(allOf::add);
        if (allOf.size() == 1) return (ObjectNode) allOf.get(0);
        var object = NODES.objectNode();
        object.set("allOf", allOf);
        return object;
    }

    @Nonnull
    private ObjectNode field(@Nonnull JsonNode field) {
        var schema = expr(field.path("type"));
        if (field.has("description")) schema.put("description", field.get("description").asText());
        var versions = field.path("versions");
        if (versions.has("added")) schema.put("x-version-added", versions.get("added").asText());
        if (versions.has("removed")) schema.put("x-version-removed", versions.get("removed").asText());
        if (versions.has("deprecated")) schema.put("x-version-deprecated", versions.get("deprecated").asText());
        if (versions.has("deprecation_message")) schema.put("x-deprecation-message", versions.get("deprecation_message").asText());
        return schema;
    }

    // Containers and other unions inside an object: a oneOf/anyOf member of its allOf.
    @Nullable
    private ObjectNode constraint(@Nonnull JsonNode constraint) {
        if (constraint.has("variants")) {
            var branches = NODES.arrayNode();
            Iterator<Map.Entry<String, JsonNode>> variants = constraint.get("variants").fields();
            while (variants.hasNext()) {
                var variant = variants.next();
                var properties = NODES.objectNode();
                properties.set(variant.getKey(), expr(variant.getValue().path("value")));
                Iterator<Map.Entry<String, JsonNode>> extra = variant.getValue().path("extra_fields").fields();
                while (extra.hasNext()) {
                    var field = extra.next();
                    properties.set(field.getKey(), field(field.getValue()));
                }
                var branch = NODES.objectNode().put("type", "object");
                branch.set("properties", properties);
                branch.set("required", NODES.arrayNode().add(variant.getKey()));
                branches.add(branch);
            }
            var union = NODES.objectNode().put("type", "object");
            union.set("oneOf", branches);
            return union;
        }
        if (constraint.has("matches")) {
            var members = new ArrayList<JsonNode>();
            constraint.get("types").forEach(members::add);
            return union(members, "one_of".equals(constraint.get("matches").asText()), null);
        }
        return null; // presence and not_all: the fields stay ordinary fields
    }

    @Nonnull
    private JsonNode baseShape(@Nonnull String base) {
        return types.path(base);
    }

    private boolean baseRequires(@Nonnull String base, @Nonnull String field) {
        return baseShape(base).path("fields").path(field).path("required").asBoolean(false);
    }

    /**
     * Keeps what the original schema says beyond its shape: annotations (descriptions, defaults, deprecation, discriminators, {@code x-*})
     * and {@code propertyNames}, here and recursively in its properties, the value schema of its additional properties (whose {@code title}
     * names the map field) and its items. The model has the shape only.
     */
    static void mergeAnnotations(@Nonnull ObjectNode lowered, @Nullable JsonNode original) {
        if (original == null || !original.isObject()) return;
        Iterator<Map.Entry<String, JsonNode>> fields = original.fields();
        while (fields.hasNext()) {
            var field = fields.next();
            var key = field.getKey();
            if (MODEL_KEY.equals(key)) continue; // the model itself, not an annotation
            if ("propertyNames".equals(key) || ANNOTATIONS.contains(key) || key.startsWith("x-")) {
                if (!lowered.has(key) || "propertyNames".equals(key)) lowered.set(key, field.getValue());
            }
        }

        var originalProperties = new HashMap<String, JsonNode>();
        collectProperties(original, originalProperties);
        var loweredProperties = new HashMap<String, JsonNode>();
        collectProperties(lowered, loweredProperties);
        loweredProperties.forEach((name, property) -> {
            var originalProperty = originalProperties.get(name);
            if (isInstantiationOf(originalProperty, property)) {
                // The model resolves `allOf: [$ref Generic, { binding its type parameters }]` to the generic type itself;
                // the generator needs the instantiation to bind the parameters (SearchResult.hits: HitsMetadata<TDocument>).
                replaceProperty(lowered, name, originalProperty);
            } else if (property instanceof ObjectNode) {
                mergeAnnotations((ObjectNode) property, originalProperty);
            }
        });

        var originalAdditional = findObjectMember(original, "additionalProperties");
        var loweredHolder = findHolder(lowered, "additionalProperties");
        if (originalAdditional != null && originalAdditional.isObject() && loweredHolder != null) {
            var loweredAdditional = loweredHolder.get("additionalProperties");
            if (loweredAdditional.isBoolean()) loweredHolder.set("additionalProperties", originalAdditional);
            else if (loweredAdditional instanceof ObjectNode) mergeAnnotations((ObjectNode) loweredAdditional, originalAdditional);
        }
        var originalPropertyNames = findObjectMember(original, "propertyNames");
        var loweredOwn = findHolder(lowered, "additionalProperties");
        if (originalPropertyNames != null && loweredOwn != null && !loweredOwn.has("propertyNames")) {
            loweredOwn.set("propertyNames", originalPropertyNames);
        }

        if (original.has("items") && lowered.get("items") instanceof ObjectNode) {
            mergeAnnotations((ObjectNode) lowered.get("items"), original.get("items"));
        }
    }

    // Whether an original property is a generic instantiation, `allOf: [$ref X, { specialization }]`, that the model
    // resolved to `$ref X` itself or, for a generic union (Buckets), to the specialized union alone.
    private static boolean isInstantiationOf(@Nullable JsonNode original, @Nonnull JsonNode lowered) {
        if (original == null) return false;
        var allOf = original.path("allOf");
        if (allOf.size() < 2 || !allOf.get(0).has("$ref")) return false;
        if (lowered.has("$ref")) return lowered.get("$ref").equals(allOf.get(0).get("$ref"));
        return (lowered.has("oneOf") || lowered.has("anyOf")) && (allOf.get(1).has("oneOf") || allOf.get(1).has("anyOf"));
    }

    private static void replaceProperty(@Nonnull ObjectNode schema, @Nonnull String name, @Nonnull JsonNode value) {
        if (schema.path("properties").has(name)) {
            ((ObjectNode) schema.get("properties")).set(name, value);
            return;
        }
        for (var member : schema.path("allOf")) {
            if (member instanceof ObjectNode && !member.has("$ref")) replaceProperty((ObjectNode) member, name, value);
        }
    }

    // The properties declared by a schema and its inline allOf members (not those of referenced schemas).
    private static void collectProperties(@Nonnull JsonNode schema, @Nonnull Map<String, JsonNode> out) {
        schema.path("properties").fields().forEachRemaining(e -> out.putIfAbsent(e.getKey(), e.getValue()));
        for (var member : schema.path("allOf")) {
            if (!member.has("$ref")) collectProperties(member, out);
        }
    }

    // A keyword of a schema or of one of its inline allOf members.
    @Nullable
    private static JsonNode findObjectMember(@Nonnull JsonNode schema, @Nonnull String keyword) {
        if (schema.has(keyword)) return schema.get(keyword);
        for (var member : schema.path("allOf")) {
            if (!member.has("$ref")) {
                var found = findObjectMember(member, keyword);
                if (found != null) return found;
            }
        }
        return null;
    }

    // The schema node, itself or an inline allOf member, that holds a keyword.
    @Nullable
    private static ObjectNode findHolder(@Nonnull ObjectNode schema, @Nonnull String keyword) {
        if (schema.has(keyword)) return schema;
        for (var member : schema.path("allOf")) {
            if (member instanceof ObjectNode && !member.has("$ref")) {
                var found = findHolder((ObjectNode) member, keyword);
                if (found != null) return found;
            }
        }
        return null;
    }
}
