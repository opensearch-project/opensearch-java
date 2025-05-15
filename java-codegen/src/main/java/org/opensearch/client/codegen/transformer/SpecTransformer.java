/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.transformer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.Nonnull;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.opensearch.client.codegen.model.ArrayShape;
import org.opensearch.client.codegen.model.DelegatedShape;
import org.opensearch.client.codegen.model.Deprecation;
import org.opensearch.client.codegen.model.DictionaryResponseShape;
import org.opensearch.client.codegen.model.EnumShape;
import org.opensearch.client.codegen.model.Field;
import org.opensearch.client.codegen.model.HttpPath;
import org.opensearch.client.codegen.model.Namespace;
import org.opensearch.client.codegen.model.ObjectShape;
import org.opensearch.client.codegen.model.ObjectShapeBase;
import org.opensearch.client.codegen.model.OperationGroup;
import org.opensearch.client.codegen.model.RequestShape;
import org.opensearch.client.codegen.model.Shape;
import org.opensearch.client.codegen.model.TaggedUnionShape;
import org.opensearch.client.codegen.model.types.TypeRef;
import org.opensearch.client.codegen.model.types.Types;
import org.opensearch.client.codegen.openapi.In;
import org.opensearch.client.codegen.openapi.MimeType;
import org.opensearch.client.codegen.openapi.OpenApiMediaType;
import org.opensearch.client.codegen.openapi.OpenApiOperation;
import org.opensearch.client.codegen.openapi.OpenApiParameter;
import org.opensearch.client.codegen.openapi.OpenApiPath;
import org.opensearch.client.codegen.openapi.OpenApiRefElement;
import org.opensearch.client.codegen.openapi.OpenApiRequestBody;
import org.opensearch.client.codegen.openapi.OpenApiResponse;
import org.opensearch.client.codegen.openapi.OpenApiSchema;
import org.opensearch.client.codegen.openapi.OpenApiSchemaType;
import org.opensearch.client.codegen.openapi.OpenApiSpecification;
import org.opensearch.client.codegen.transformer.overrides.Overrides;
import org.opensearch.client.codegen.transformer.overrides.PathParameterOverride;
import org.opensearch.client.codegen.transformer.overrides.PropertyOverride;
import org.opensearch.client.codegen.transformer.overrides.QueryParameterOverride;
import org.opensearch.client.codegen.transformer.overrides.SchemaOverride;
import org.opensearch.client.codegen.transformer.overrides.ShouldGenerate;
import org.opensearch.client.codegen.utils.Maps;
import org.opensearch.client.codegen.utils.Versions;
import org.opensearch.client.codegen.utils.matcher.Matcher;

public class SpecTransformer {
    private static final Logger LOGGER = LogManager.getLogger();
    @Nonnull
    private final Matcher<OperationGroup> matcher;
    @Nonnull
    private final Overrides overrides;
    @Nonnull
    private final TypeMapper typeMapper;
    @Nonnull
    private final Namespace root = new Namespace();
    @Nonnull
    private final Map<OpenApiSchema, Shape> visitedSchemas = new ConcurrentHashMap<>();

    public SpecTransformer(@Nonnull Matcher<OperationGroup> matcher, @Nonnull Overrides overrides) {
        this.matcher = Objects.requireNonNull(matcher, "matcher must not be null");
        this.overrides = Objects.requireNonNull(overrides, "overrides must not be null");
        this.typeMapper = new TypeMapper(this, overrides);
    }

    @Nonnull
    public Namespace getRoot() {
        return root;
    }

    public void visit(@Nonnull OpenApiSpecification spec) {
        Objects.requireNonNull(spec, "spec must not be null");

        LOGGER.info("Visiting Specification: {}", spec);

        var groupedOperations = new HashMap<OperationGroup, List<Pair<OpenApiPath, OpenApiOperation>>>();

        spec.getPaths()
            .stream()
            .map(Map::values)
            .flatMap(Collection::stream)
            .flatMap(
                p -> p.getOperations()
                    .stream()
                    .flatMap(m -> m.values().stream())
                    .filter(o -> o.getDeprecation().map(d -> d.getVersion().isGreaterThan(Versions.V1_0_0)).orElse(true))
                    .map(o -> Pair.of(p, o))
            )
            .forEach(pair -> {
                var group = pair.getRight().getOperationGroup();
                if (!matcher.matches(group)) {
                    return;
                }
                groupedOperations.computeIfAbsent(group, k -> new ArrayList<>()).add(pair);
            });

        groupedOperations.forEach(this::visit);

        overrides.getSchemas().forEach((pointer, schemaOverride) -> {
            if (!pointer.isDirectChildOf(OpenApiSchema.COMPONENTS_SCHEMAS) || schemaOverride.getMappedType().isPresent()) {
                return;
            }
            var schema = (OpenApiSchema) spec.getElement(pointer)
                .orElseThrow(() -> new IllegalStateException("Schema not found: " + pointer));
            visit(schema);
        });
    }

    private void visit(@Nonnull OperationGroup group, @Nonnull List<Pair<OpenApiPath, OpenApiOperation>> variants) {
        LOGGER.info("Visiting Operation Group: {} [{} variants]", group, variants.size());

        var parent = root.child(group.getNamespace().orElse("core"));

        var requestShape = visit(parent, group, variants);
        parent.addOperation(requestShape);

        var responseSchema = variants.stream()
            .map(Pair::getRight)
            .map(OpenApiOperation::getResponses)
            .flatMap(Optional::stream)
            .findFirst()
            .flatMap(r -> r.entries().filter(e -> e.getKey().isSuccessful()).map(Map.Entry::getValue).findFirst())
            .map(OpenApiResponse::resolve)
            .flatMap(OpenApiResponse::getContent)
            .flatMap(c -> c.get(MimeType.Json))
            .flatMap(OpenApiMediaType::getSchema)
            .map(OpenApiRefElement::resolve);

        TypeRef responseType;

        if (responseSchema.isEmpty() && !requestShape.hasRequestBody()) {
            responseType = Types.Client.Transport.Endpoints.BooleanResponse;
        } else {
            responseType = visit(
                parent,
                RequestShape.responseClassName(group),
                group.asTypedefPrefix() + ".Response",
                responseSchema.orElse(OpenApiSchema.emptyObject()),
                ShouldGenerate.Always,
                true
            ).getType();
        }

        requestShape.setResponseType(responseType);
    }

    private static Stream<OpenApiParameter> getAllRelevantParameters(OpenApiPath path, OpenApiOperation operation, In in) {
        return Stream.of(path.getParameters(), operation.getParameters())
            .flatMap(Optional::stream)
            .flatMap(List::stream)
            .map(OpenApiRefElement::resolve)
            .filter(p -> p.getIn().equals(Optional.of(in)));
    }

    @Nonnull
    private RequestShape visit(
        @Nonnull Namespace parent,
        @Nonnull OperationGroup group,
        @Nonnull List<Pair<OpenApiPath, OpenApiOperation>> variants
    ) {
        var overrides = this.overrides.getOperation(group);
        var seenHttpPaths = new HashSet<String>();
        HashSet<String> requiredPathParams = null;
        var allPathParams = new HashMap<String, Field>();
        var canonicalPaths = new HashMap<Set<String>, HttpPath>();
        var deprecatedPaths = new HashMap<Set<String>, HttpPath>();

        var description = variants.stream()
            .map(Pair::getRight)
            .map(OpenApiOperation::getDescription)
            .flatMap(Optional::stream)
            .findFirst()
            .orElse(null);

        var shape = new RequestShape(parent, group, description, ShouldGenerate.Always);

        var pathCombos = new ArrayList<Triple<String, OpenApiOperation, List<PathParam>>>();

        for (var variant : variants) {
            var path = variant.getLeft();
            var op = variant.getRight();

            shape.addSupportedHttpMethod(op.getHttpMethod().toString().toUpperCase());

            var httpPathStr = path.getHttpPath();
            if (!seenHttpPaths.add(httpPathStr)) {
                continue;
            }

            getOverloadedPathVariants(httpPathStr, path, op, pathCombos);
        }

        for (var combo : pathCombos) {
            var httpPathStr = combo.getLeft();
            var operation = combo.getMiddle();
            var pathParams = combo.getRight();

            pathParams.forEach(parameter -> {
                if (!allPathParams.containsKey(parameter.name)) {
                    var paramOverrides = overrides.flatMap(o -> o.getPathParameter(parameter.name));
                    var paramBuilder = visit(parameter).toBuilder();
                    paramOverrides.flatMap(PathParameterOverride::getName).ifPresent(paramBuilder::withName);
                    allPathParams.put(parameter.name, paramBuilder.build());
                }
            });

            var httpPath = HttpPath.from(httpPathStr, operation, allPathParams);

            (httpPath.getDeprecation() == null ? canonicalPaths : deprecatedPaths).put(httpPath.getParamWireNameSet(), httpPath);

            if (requiredPathParams != null) {
                requiredPathParams.retainAll(httpPath.getParamWireNameSet());
            } else {
                requiredPathParams = new HashSet<>(httpPath.getParamWireNameSet());
            }
        }

        Stream.of(
            canonicalPaths.values().stream(),
            deprecatedPaths.entrySet().stream().filter(p -> !canonicalPaths.containsKey(p.getKey())).map(Map.Entry::getValue)
        ).flatMap(Function.identity()).sorted((p1, p2) -> {
            var params1 = p1.getParams();
            var p1Size = params1.size();
            var params2 = p2.getParams();
            var p2Size = params2.size();
            var len = Math.max(p1Size, p2Size);

            for (int i = 0; i < len; i++) {
                if (i >= p1Size) {
                    return -1;
                }
                if (i >= p2Size) {
                    return 1;
                }
                var cmp = params1.get(i).getName().compareTo(params2.get(i).getName());
                if (cmp != 0) {
                    return cmp;
                }
            }

            return 0;
        }).forEachOrdered(shape::addHttpPath);

        for (var entry : allPathParams.entrySet()) {
            shape.addPathParam(entry.getValue().toBuilder().withRequired(requiredPathParams.contains(entry.getKey())).build());
        }

        variants.stream()
            .map(Pair::getRight)
            .map(OpenApiOperation::getRequestBody)
            .flatMap(Optional::stream)
            .findFirst()
            .map(OpenApiRefElement::resolve)
            .flatMap(OpenApiRequestBody::getContent)
            .flatMap(c -> c.get(MimeType.Json))
            .flatMap(OpenApiMediaType::getSchema)
            .ifPresent(s -> {
                if ((s.has$ref() && s.hasTitle()) || !s.getSingleType().map(OpenApiSchemaType.Object::equals).orElse(false)) {
                    var name = s.getTitle().orElse("body");
                    shape.setDelegatedBodyField(name, typeMapper.mapType(s));
                } else {
                    visitInto(s.resolve(), shape);
                }
            });

        var seenQueryParams = new HashSet<String>();

        var isCatNs = group.getNamespace().orElse("").equals("cat");

        variants.stream().flatMap(v -> getAllRelevantParameters(v.getLeft(), v.getRight(), In.Query)).filter(p -> {
            var name = p.getName().orElseThrow();
            if (!seenQueryParams.add(name)) {
                return false;
            }
            if (p.isGlobal()) {
                return false;
            }
            if (isCatNs && p.isGlobalCatParameter()) {
                return false;
            }
            var shouldIgnore = overrides.flatMap(oo -> oo.getQueryParameter(name)).map(QueryParameterOverride::shouldIgnore).orElse(false);
            return !shouldIgnore;
        }).map(this::visit).forEachOrdered(shape::addQueryParam);

        if (shape.getExtendsType() == null) {
            shape.setExtendsType(isCatNs ? Types.Client.OpenSearch.Cat.CatRequestBase : Types.Client.OpenSearch._Types.RequestBase);
        }

        return shape;
    }

    private static void getOverloadedPathVariants(
        String originalHttpPath,
        OpenApiPath path,
        OpenApiOperation operation,
        List<Triple<String, OpenApiOperation, List<PathParam>>> variants
    ) {
        getOverloadedPathVariants(
            originalHttpPath,
            getAllRelevantParameters(path, operation, In.Path).collect(Collectors.toList()),
            0,
            new ArrayList<>(),
            (httpPath, pathParams) -> variants.add(Triple.of(httpPath, operation, pathParams))
        );
    }

    private static void getOverloadedPathVariants(
        String httpPath,
        List<OpenApiParameter> pathParams,
        int i,
        List<PathParam> combo,
        BiConsumer<String, List<PathParam>> callback
    ) {
        if (i == pathParams.size()) {
            callback.accept(httpPath, combo);
            return;
        }

        var originalParameter = pathParams.get(i);
        var originalName = originalParameter.getName().orElseThrow();
        var overloads = !originalParameter.isOverloaded()
            ? Stream.of(Pair.of(httpPath, new PathParam(originalParameter)))
            : originalParameter.getSchema().flatMap(OpenApiSchema::getAnyOf).orElseThrow().stream().map(o -> {
                var overloadedName = o.getTitle().orElseThrow();
                return Pair.of(
                    httpPath.replace("{" + originalName + "}", "{" + overloadedName + "}"),
                    new PathParam(overloadedName, o, originalParameter)
                );
            });

        overloads.forEach(o -> getOverloadedPathVariants(o.getKey(), pathParams, i + 1, new ArrayList<>(combo) {
            {
                add(o.getValue());
            }
        }, callback));
    }

    private static class PathParam {
        private final String name;
        private final OpenApiSchema schema;
        private final String description;
        private final Deprecation deprecation;

        public PathParam(String name, OpenApiSchema schema, OpenApiParameter original) {
            this.name = name;
            this.schema = schema;
            this.description = original.getResolvedDescription().orElse(null);
            this.deprecation = original.getDeprecation().orElse(null);
        }

        public PathParam(OpenApiParameter parameter) {
            this.name = parameter.getName().orElseThrow();
            this.schema = parameter.getSchema().orElseThrow();
            this.description = parameter.getResolvedDescription().orElse(null);
            this.deprecation = parameter.getDeprecation().orElse(null);
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this).append("name", name).append("schema", schema).append("description", description).toString();
        }
    }

    private Field visit(PathParam parameter) {
        LOGGER.info("Visiting Parameter: {}", parameter);
        return Field.builder()
            .withWireName(parameter.name)
            .withType(typeMapper.mapType(parameter.schema))
            .withDescription(parameter.description)
            .withDeprecation(parameter.deprecation)
            .build();
    }

    private Field visit(OpenApiParameter parameter) {
        LOGGER.info("Visiting Parameter: {}", parameter);
        return Field.builder()
            .withWireName(parameter.getName().orElseThrow())
            .withType(typeMapper.mapType(parameter.getSchema().orElseThrow()))
            .withRequired(parameter.getRequired())
            .withDescription(parameter.getResolvedDescription().orElse(null))
            .withDeprecation(parameter.getDeprecation().orElse(null))
            .build();
    }

    public Shape visit(OpenApiSchema schema) {
        var namespace = schema.getNamespace().orElseThrow();
        var name = schema.getName().orElseThrow();
        var schemaOverrides = overrides.getSchema(schema.getPointer());
        var className = schemaOverrides.flatMap(SchemaOverride::getClassName).orElse(name);
        var shouldGenerate = schemaOverrides.map(SchemaOverride::shouldGenerate).orElse(ShouldGenerate.IfNeeded);
        return visit(root.child(namespace), className, namespace + "." + name, schema, shouldGenerate);
    }

    private Shape visit(Namespace parent, String className, String typedefName, OpenApiSchema schema, ShouldGenerate shouldGenerate) {
        return visit(parent, className, typedefName, schema, shouldGenerate, false);
    }

    private Shape visit(
        Namespace parent,
        String className,
        String typedefName,
        final OpenApiSchema schema,
        ShouldGenerate shouldGenerate,
        final boolean uncached
    ) {
        Shape shape;

        if (!uncached && (shape = visitedSchemas.get(schema)) != null) {
            return shape;
        }

        Consumer<Shape> cache = s -> {
            if (!uncached) {
                visitedSchemas.putIfAbsent(schema, s);
            }
        };

        LOGGER.info("Visiting Schema: {}", schema);

        var description = schema.getResolvedDescription().orElse(null);

        if (schema.isArray()) {
            shape = new ArrayShape(parent, className, typeMapper.mapType(schema), typedefName, description, shouldGenerate);
            cache.accept(shape);
        } else if (schema.isEnum()) {
            var enumShape = new EnumShape(parent, className, typedefName, description, shouldGenerate);
            shape = enumShape;
            cache.accept(shape);

            visitInto(schema, enumShape);
        } else if (schema.isTaggedUnion()) {
            var taggedUnion = new TaggedUnionShape(parent, className, typedefName, description, shouldGenerate);
            shape = taggedUnion;
            cache.accept(shape);

            if (schema.has$extends()) {
                taggedUnion.setExtendsType(typeMapper.mapType(schema.get$extends().orElseThrow()));
            }

            var unionSchema = schema;
            while (unionSchema.hasAllOf()) {
                var allOf = unionSchema.getAllOf().orElseThrow();
                var first = allOf.get(0);
                var second = allOf.get(1);

                if (first.isTaggedUnion()) {
                    unionSchema = first;
                    visitInto(second, taggedUnion);
                } else if (second.isTaggedUnion()) {
                    unionSchema = second;
                    visitInto(first, taggedUnion);
                } else {
                    throw new IllegalStateException("allOf is not a tagged union: " + unionSchema.getPointer());
                }
            }

            String discriminatingField;
            var discriminator = unionSchema.getDiscriminator().orElse(null);

            if (discriminator != null) {
                discriminatingField = discriminator.getPropertyName().orElse(null);
                taggedUnion.setDiscriminatingField(discriminatingField);
                taggedUnion.setDefaultVariant(discriminator.getDefaultValue().orElse(null));
            } else {
                discriminatingField = null;
            }

            var oneOrAnyOf = unionSchema.getOneOf().or(unionSchema::getAnyOf).orElse(null);
            if (!unionSchema.isExternallyTaggedUnion()) {
                oneOrAnyOf.forEach(s -> {
                    String name;
                    if (discriminatingField != null) {
                        name = Maps.tryGet(s.resolve().getProperties().orElseThrow(), discriminatingField)
                            .flatMap(OpenApiSchema::getEnums)
                            .flatMap(enums -> enums.stream().findFirst())
                            .orElseThrow(
                                () -> new IllegalStateException(
                                    "oneOf variant ["
                                        + s.getPointer()
                                        + "] is missing the `"
                                        + discriminatingField
                                        + "` property as a single value enum"
                                )
                            );
                    } else {
                        name = s.getTitle()
                            .orElseThrow(
                                () -> new IllegalStateException("oneOf variant [" + s.getPointer() + "] is missing a `title` tag")
                            );
                    }
                    taggedUnion.addVariant(name, typeMapper.mapType(s));
                });
            } else {
                if (unionSchema.supportsTypedKeys()) {
                    taggedUnion.setExternallyDiscriminated(TaggedUnionShape.ExternallyDiscriminated.TYPED_KEYS);
                    oneOrAnyOf.forEach(s -> taggedUnion.addVariant(s.getTitle().orElseThrow(), typeMapper.mapType(s)));
                } else if (oneOrAnyOf != null) {
                    taggedUnion.setExternallyDiscriminated(TaggedUnionShape.ExternallyDiscriminated.REQUIRED);
                    oneOrAnyOf.forEach(s -> {
                        var prop = s.getProperties().flatMap(m -> m.entrySet().stream().findFirst()).orElseThrow();

                        taggedUnion.addVariant(prop.getKey(), typeMapper.mapType(prop.getValue()));
                    });
                } else {
                    taggedUnion.setExternallyDiscriminated(
                        unionSchema.getMinProperties().orElse(0) == 1
                            ? TaggedUnionShape.ExternallyDiscriminated.REQUIRED
                            : TaggedUnionShape.ExternallyDiscriminated.OPTIONAL
                    );
                    unionSchema.getProperties()
                        .ifPresent(props -> props.forEach((k, v) -> taggedUnion.addVariant(k, typeMapper.mapType(v))));
                }
            }
        } else if (schema.isShortcutPropertyObject() || schema.getSingleType().orElse(null) == OpenApiSchemaType.Object) {
            if (!schema.has$extends()
                && !schema.hasProperties()
                && schema.hasAdditionalProperties()
                && schema.getMaxProperties().orElse(Integer.MAX_VALUE) > 1) {
                shape = new DictionaryResponseShape(
                    parent,
                    className,
                    typedefName,
                    description,
                    Types.Java.Lang.String,
                    typeMapper.mapType(schema.getAdditionalProperties().orElseThrow()),
                    shouldGenerate
                );
                cache.accept(shape);
            } else {
                var objShape = new ObjectShape(parent, className, typedefName, description, shouldGenerate);
                shape = objShape;
                cache.accept(shape);

                var objSchema = schema;
                if (schema.isShortcutPropertyObject()) {
                    var oneOf = schema.getOneOf().orElseThrow();
                    var shortcutProperty = oneOf.get(0).getTitle().orElseThrow();
                    objShape.setShortcutProperty(shortcutProperty);
                    objSchema = oneOf.get(1);
                }

                visitInto(objSchema, objShape);
            }
        } else {
            shape = new DelegatedShape(parent, className, typedefName, description, shouldGenerate, typeMapper.mapType(schema));
            cache.accept(shape);
        }

        parent.addShape(shape);

        return shape;
    }

    private void visitInto(OpenApiSchema schema, ObjectShapeBase shape) {
        while (schema.has$ref()) {
            schema = schema.resolve();
        }

        if (schema.has$extends()) {
            shape.setExtendsType(typeMapper.mapType(schema.get$extends().orElseThrow()));
        }

        var superShape = shape.extendsOtherShape() ? (ObjectShapeBase) shape.getExtendsType().getTargetShape().orElseThrow() : null;

        final var properties = schema.getProperties().orElseThrow();
        final var required = schema.getRequired().orElseThrow();

        final var overrides = this.overrides.getSchema(schema.getPointer());

        properties.forEach((k, v) -> {
            if (superShape != null && superShape.hasBodyFieldWithWireName(k)) {
                return;
            }

            var propOverrides = overrides.map(so -> so.getProperty(k));

            var type = propOverrides.flatMap(PropertyOverride::getMappedType).orElseGet(() -> typeMapper.mapType(v));

            var isRequired = propOverrides.flatMap(PropertyOverride::getRequired).orElseGet(() -> required.contains(k));

            var canBeNull = !isRequired
                || (!type.getName().equals("FieldValue")
                    && v.getTypes()
                        .filter(t -> !t.equals(OpenApiSchemaType.ALL_TYPES))
                        .map(t -> t.contains(OpenApiSchemaType.Null))
                        .orElse(false));

            var field = Field.builder()
                .withWireName(k)
                .withName(propOverrides.flatMap(PropertyOverride::getName).orElse(null))
                .withType(type)
                .withRequired(!canBeNull)
                .withDescription(v.getDescription().orElse(null))
                .whenPresent(propOverrides.flatMap(PropertyOverride::getAliases), (b, aliases) -> b.withAliases(a -> a.with(aliases)))
                .build();

            shape.addBodyField(field);
        });

        if (schema.hasAdditionalProperties()) {
            var keySchema = schema.getPropertyNames().orElseGet(OpenApiSchema::string);
            var resolvedKeySchema = keySchema.resolve();
            var keyName = keySchema.getTitle().or(resolvedKeySchema::getName).orElse("key");
            var valueSchema = schema.getAdditionalProperties().orElseThrow();

            shape.setAdditionalProperties(
                new ObjectShapeBase.AdditionalProperties(
                    keyName,
                    typeMapper.mapType(keySchema),
                    keySchema.getResolvedDescription().orElse(null),
                    valueSchema.getTitle().orElse("metadata"),
                    typeMapper.mapType(valueSchema),
                    valueSchema.getResolvedDescription().orElse(null),
                    schema.isAdditionalPropertiesSingleton()
                )
            );
        }
    }

    private void visitInto(OpenApiSchema schema, EnumShape shape) {
        var title = schema.getTitle();
        var isDeprecated = schema.getVersionDeprecated().isPresent();

        if (schema.hasOneOf()) {
            schema.getOneOf().orElseThrow().forEach(s -> visitInto(s, shape));
        } else if (schema.hasEnums()) {
            var enums = schema.getEnums().orElseThrow();
            var description = title.isPresent() || enums.stream().map(String::toLowerCase).distinct().count() == 1
                ? schema.getResolvedDescription().orElse(null)
                : null;
            enums.forEach(v -> shape.addVariant(title.orElse(v), v, description, isDeprecated));
        } else if (schema.hasConst()) {
            var value = (String) schema.getConst().orElseThrow();
            shape.addVariant(title.orElse(value), value, schema.getResolvedDescription().orElse(null), isDeprecated);
        } else if (schema.isBoolean()) {
            var description = schema.getResolvedDescription().orElse(null);
            shape.addVariant(title.orElse("true"), "true", description, isDeprecated);
            shape.addVariant(title.orElse("false"), "false", description, isDeprecated);
        }
    }
}
