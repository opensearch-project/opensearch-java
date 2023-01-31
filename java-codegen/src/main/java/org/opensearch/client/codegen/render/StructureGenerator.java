package org.opensearch.client.codegen.render;

import org.opensearch.client.codegen.core.*;
import org.opensearch.client.codegen.core.traits.SyntheticInputTrait;
import org.opensearch.client.codegen.model.Shapes;
import org.opensearch.client.codegen.model.Symbols;
import org.opensearch.client.codegen.utils.Strings;
import software.amazon.smithy.codegen.core.Symbol;
import software.amazon.smithy.codegen.core.SymbolProvider;
import software.amazon.smithy.model.Model;
import software.amazon.smithy.model.knowledge.HttpBinding;
import software.amazon.smithy.model.knowledge.HttpBindingIndex;
import software.amazon.smithy.model.shapes.*;
import software.amazon.smithy.model.traits.HttpQueryTrait;
import software.amazon.smithy.model.traits.HttpTrait;
import software.amazon.smithy.utils.Pair;
import software.amazon.smithy.utils.TriConsumer;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class StructureGenerator {
    private final Shape shape;
    private final JavaWriter writer;
    private final SymbolProvider symbolProvider;
    private final Model model;
    private final Symbol symbol;
    private final HttpBindingIndex httpBindingIndex;
    private final boolean isInput;
    private final List<MemberShape> sortedMembers;
    private final Map<MemberShape, Pair<String, Symbol>> memberNameSymbolIndex;

    public StructureGenerator(RenderingContext<StructureShape> ctx) {
        shape = ctx.getShape().orElseThrow(() -> new NoSuchElementException("Missing shape on rendering context"));
        writer = ctx.getWriter();
        symbolProvider = ctx.getSymbolProvider();
        model = ctx.getModel();
        symbol = symbolProvider.toSymbol(shape);
        httpBindingIndex = ctx.getHttpBindingIndex();
        isInput = shape.hasTrait(SyntheticInputTrait.class);
        sortedMembers = shape
                .getAllMembers()
                .values()
                .stream()
                .sorted(Comparator.comparing(Naming::defaultName))
                .collect(Collectors.toList());
        memberNameSymbolIndex = new HashMap<>();
        sortedMembers.forEach(m -> memberNameSymbolIndex.put(m, new Pair<>(symbolProvider.toMemberName(m), symbolProvider.toSymbol(m))));
    }

    public void render() {
        writer.javaClass(
                JavaVisibility.PUBLIC,
                symbol.getName(),
                Collections.singletonList(RuntimeTypes.Json.JsonpDeserializable),
                isInput ? RuntimeTypes.OpenSearch.Types.RequestBase : null,
                Collections.singletonList(RuntimeTypes.Json.JsonpSerializable),
                w -> {
                    renderFields();
                    renderConstructor();
                    renderGetters();
                    renderSerialize();
                    renderBuilder();
                    renderDeserialize();
                    if (isInput) {
                        renderEndpoint();
                    }
                }
        );
    }

    private void renderFields() {
        renderFields(true);
    }

    private void renderFields(boolean _final) {
        forEachMember((member, memberName, memberSymbol) -> {
            if (Symbols.isNullable(memberSymbol) && !(_final && Shapes.isListOrMap(Symbols.getShape(memberSymbol)))) {
                writer.write("@#T", RuntimeTypes.Javax.Nullable);
            }
            writer.write(
                    "private #L#T #L;\n",
                    _final ? "final " : "",
                    memberSymbol,
                    memberName
            );
        });
    }

    private void renderConstructor() {
        writer.block(
                "private #T(Builder builder)",
                new Object[]{symbol},
                w -> forEachMember((member, memberName, memberSymbol) -> {
                    String builderField = w.format("builder.#L", memberName);

                    if (Shapes.isListOrMap(Symbols.getShape(memberSymbol))) {
                        builderField = Symbols.isNullable(memberSymbol)
                                ? w.format(
                                "#T.unmodifiable(#L)",
                                RuntimeTypes.Util.ApiTypeHelper, builderField)
                                : w.format(
                                "#T.unmodifiableRequired(#L, this, #L)",
                                RuntimeTypes.Util.ApiTypeHelper, builderField, Strings.dq(memberName));
                    } else if (!Symbols.isNullable(memberSymbol)) {
                        builderField = w.format(
                                "#T.requireNonNull(#L, this, #L)",
                                RuntimeTypes.Util.ApiTypeHelper, builderField, Strings.dq(memberName)
                        );
                    }

                    w.write("this.#L = #L;", memberName, builderField);
                }));
        writer.write("");

        writer.block(
                "public static #1T of(#2T<Builder, #3T<#1T>> fn)",
                new Object[]{symbol, RuntimeTypes.JavaUtil.Function, RuntimeTypes.Util.ObjectBuilder},
                w -> w.write("return fn.apply(new Builder()).build();"));
        writer.write("");
    }

    private void renderGetters() {
        forEachMember((member, memberName, memberSymbol) -> {
            if (Symbols.isNullable(memberSymbol) && !Shapes.isListOrMap(Symbols.getShape(memberSymbol))) {
                writer.write("@#T", RuntimeTypes.Javax.Nullable);
            }

            writer.block(
                    "public final #T #L()",
                    new Object[]{memberSymbol, memberName},
                    w -> w.write("return this.#L;", memberName));
            writer.write("");
        });
    }

    private void renderSerialize() {
        writer.block(
                "public void serialize(#T generator, #T mapper)",
                new Object[]{RuntimeTypes.Jakarta.JsonGenerator, RuntimeTypes.Json.JsonpMapper},
                w -> {
                    w.write("generator.writeStartObject();");
                    w.write("serializeInternal(generator, mapper);");
                    w.write("generator.writeEnd();");
                });
        writer.write("");

        writer.block(
                "protected void serializeInternal(#T generator, #T mapper)",
                new Object[]{RuntimeTypes.Jakarta.JsonGenerator, RuntimeTypes.Json.JsonpMapper},
                w -> forEachMember(getDocumentFields(), this::renderSerializeField));
        writer.write("");
    }

    private Iterable<MemberShape> getDocumentFields() {
        if (!isInput) {
            return sortedMembers;
        }

        ShapeId operation = shape.expectTrait(SyntheticInputTrait.class).getOperation();

        return httpBindingIndex.getRequestBindings(operation, HttpBinding.Location.DOCUMENT)
                .stream()
                .map(HttpBinding::getMember)
                .sorted(Comparator.comparing(MemberShape::getMemberName))
                .collect(Collectors.toList());
    }

    private void renderSerializeField(MemberShape member, String memberName, Symbol memberSymbol) {
        ifValueDefined("this." + memberName, memberSymbol, w -> {
            w.write("generator.writeKey(#L);", Strings.dq(member.getMemberName()));
            renderSerializeValue("this." + memberName, Symbols.getShape(memberSymbol), 0);
        });
    }

    private void renderSerializeValue(String value, Shape valueShape, int depth) {
        if (valueShape.isStructureShape()) {
            writer.write("#L.serialize(generator, mapper);", value);
        } else if (valueShape.isListShape()) {
            Shape elementShape = Shapes.getElementShape((ListShape) valueShape, model);
            Symbol elementSymbol = Symbols.boxed(symbolProvider.toSymbol(elementShape));
            String item = "item" + depth;
            writer.write("generator.writeStartArray();");
            writer.block(
                    "for (#T #L : #L)",
                    new Object[]{elementSymbol, item, value},
                    w -> renderSerializeValue(item, elementShape, depth + 1));
            writer.write("generator.writeEnd();");
        } else if (valueShape.isMapShape()) {
            Shape elementShape = Shapes.getElementShape((MapShape) valueShape, model);
            Symbol elementSymbol = Symbols.boxed(symbolProvider.toSymbol(elementShape));
            String item = "item" + depth;
            writer.write("generator.writeStartObject();");
            writer.block(
                    "for (#T.Entry<String, #T> #L : #L.entrySet())",
                    new Object[]{RuntimeTypes.JavaUtil.Map, elementSymbol, item, value},
                    w -> {
                        w.write("generator.writeKey(#L.getKey());", item);
                        renderSerializeValue(item + ".getValue()", elementShape, depth + 1);
                    });
            writer.write("generator.writeEnd();");
        } else {
            writer.write("generator.write(#L);", value);
        }
    }

    private void renderBuilder() {
        writer.block(
                "public static class Builder extends #T implements #T<#T>",
                new Object[]{RuntimeTypes.Util.ObjectBuilderBase, RuntimeTypes.Util.ObjectBuilder, symbol},
                w -> {
                    renderFields(false);

                    forEachMember(this::renderBuilderSetter);

                    w.block(
                            "public #T build()",
                            new Object[]{symbol},
                            w2 -> {
                                w2.write("_checkSingleUse();");
                                w2.write("return new #T(this);", symbol);
                            });
                });
        writer.write("");
    }

    private void renderBuilderSetter(MemberShape member, String memberName, Symbol memberSymbol) {
        Shape valueShape = Shapes.getTargetShape(member, model);

        if (valueShape.isListShape()) {
            writer.block(
                    "public final Builder #L(#T list)",
                    new Object[]{memberName, memberSymbol},
                    w -> {
                        w.write("this.#1L = _listAddAll(this.#1L, list);", memberName);
                        w.write("return this;");
                    });
            writer.write("");

            Symbol elementSymbol = symbolProvider.toSymbol(Shapes.getElementShape((ListShape) valueShape, model));
            writer.block(
                    "public final Builder #1L(#2T value, #2T... values)",
                    new Object[]{memberName, elementSymbol},
                    w -> {
                        w.write("this.#1L = _listAdd(this.#1L, value, values);", memberName);
                        w.write("return this;");
                    });
        } else if (valueShape.isMapShape()) {
            writer.block(
                    "public final Builder #L(#T map)",
                    new Object[]{memberName, memberSymbol},
                    w -> {
                        w.write("this.#1L = _mapPutAll(this.#1L, map);", memberName);
                        w.write("return this;");
                    });
            writer.write("");

            Symbol elementSymbol = symbolProvider.toSymbol(Shapes.getElementShape((MapShape) valueShape, model));
            writer.block(
                    "public final Builder #L(String key, #T value)",
                    new Object[]{memberName, elementSymbol},
                    w -> {
                        w.write("this.#1L = _mapPut(this.#1L, key, value);", memberName);
                        w.write("return this;");
                    });
        } else {
            writer.block(
                    "public final Builder #L(#T value)",
                    new Object[]{memberName, memberSymbol},
                    w -> {
                        w.write("this.#L = value;", memberName);
                        w.write("return this;");
                    });
        }

        writer.write("");
    }

    private void renderDeserialize() {
        String setupDeserialize = writer.format("setup#LDeserializer", symbol.getName());

        writer.write(
                "public static final #1T<#2T> _DESERIALIZER = #3T.lazy(Builder::new, #2T::#4L);",
                RuntimeTypes.Json.JsonpDeserializer, symbol, RuntimeTypes.Json.ObjectBuilderDeserializer, setupDeserialize);
        writer.write("");

        writer.block(
                "protected static void #L(#T<#T.Builder> op)",
                new Object[]{setupDeserialize, RuntimeTypes.Json.ObjectDeserializer, symbol},
                w -> forEachMember(getDocumentFields(), (member, memberName, memberSymbol) -> {
                    w.write(
                            "op.add(Builder::#L, #L, #L);",
                            memberName, valueDeserializer(Symbols.getShape(memberSymbol)), Strings.dq(member.getMemberName()));
                }));
        writer.write("");
    }

    private String valueDeserializer(Shape valueShape) {
        if (valueShape.isStructureShape()) {
            return writer.format("#T._DESERIALIZER", symbolProvider.toSymbol(valueShape));
        } else if (valueShape.isListShape()) {
            return writer.format("#T.arrayDeserializer(#L)", RuntimeTypes.Json.JsonpDeserializer, valueDeserializer(Shapes.getElementShape((ListShape) valueShape, model)));
        } else if (valueShape.isMapShape()) {
            return writer.format("#T.stringMapDeserializer(#L)", RuntimeTypes.Json.JsonpDeserializer, valueDeserializer(Shapes.getElementShape((MapShape) valueShape, model)));
        } else if (valueShape.isBooleanShape()) {
            return writer.format("#T.booleanDeserializer()", RuntimeTypes.Json.JsonpDeserializer);
        } else if (valueShape.isStringShape()) {
            return writer.format("#T.stringDeserializer()", RuntimeTypes.Json.JsonpDeserializer);
        } else if (valueShape.isIntegerShape()) {
            return writer.format("#T.integerDeserializer()", RuntimeTypes.Json.JsonpDeserializer);
        } else {
            throw new UnsupportedOperationException("TODO: Output correct deserializer for " + valueShape);
        }
    }

    private void renderEndpoint() {
        SyntheticInputTrait inputTrait = shape.expectTrait(SyntheticInputTrait.class);
        OperationShape operation = model.expectShape(inputTrait.getOperation(), OperationShape.class);
        HttpTrait httpTrait = operation.expectTrait(HttpTrait.class);
        Shape ouputShape = model.expectShape(operation.getOutputShape());
        Symbol outputSymbol = symbolProvider.toSymbol(ouputShape);

        writer.openBlock(
                "public static final #T<#T, #T, #T> _ENDPOINT = new #T<>(",
                RuntimeTypes.Transport.Endpoint,
                symbol,
                outputSymbol,
                RuntimeTypes.OpenSearch.Types.ErrorResponse,
                RuntimeTypes.Transport.Endpoints.SimpleEndpoint);

        writer.write("// Request method\nrequest -> #L,\n", Strings.dq(httpTrait.getMethod()));

        renderPathBuilder(operation, httpTrait);

        renderQueryParamsBuilder(operation);

        // TODO: headers?
        writer.write("// Request headers\n#T.emptyMap(),\n", RuntimeTypes.Transport.Endpoints.SimpleEndpoint);

        // TODO: maybe no requestbody?
        writer.write("// Has request body\ntrue,\n");

        writer.write("// Response deserializer\n#T._DESERIALIZER", outputSymbol);

        writer.closeBlock(");");
    }

    private void renderPathBuilder(OperationShape operation, HttpTrait httpTrait) {
        writer.openBlock("// Request path\nrequest -> {");
        writer.write("StringBuilder buf = new StringBuilder();");

        Map<String, MemberShape> labelMembers = new HashMap<>();
        httpBindingIndex.getRequestBindings(operation, HttpBinding.Location.LABEL)
                .stream()
                .map(HttpBinding::getMember)
                .forEach(m -> labelMembers.put(m.getMemberName(), m));

        httpTrait.getUri().getSegments().forEach(segment -> {
            writer.write("buf.append('/');");
            if (segment.isLabel() || segment.isGreedyLabel()) {
                writer.write(
                        "#T.pathEncode(request.#L, buf);",
                        RuntimeTypes.Transport.Endpoints.SimpleEndpoint,
                        symbolProvider.toMemberName(labelMembers.get(segment.getContent())));
            } else {
                writer.write("buf.append(#L);", Strings.dq(segment.getContent()));
            }
        });

        writer.write("return buf.toString();");
        writer.closeBlock("},\n");
    }

    private void renderQueryParamsBuilder(OperationShape operation) {
        writer.openBlock("// Request parameters\nrequest -> {");
        writer.write(
                "#T<String, String> params = new #T<>();",
                RuntimeTypes.JavaUtil.Map,
                RuntimeTypes.JavaUtil.HashMap
        );

        List<MemberShape> paramMembers = httpBindingIndex
                .getRequestBindings(operation, HttpBinding.Location.QUERY)
                .stream()
                .map(HttpBinding::getMember)
                .sorted(Comparator.comparing(MemberShape::getMemberName))
                .collect(Collectors.toList());

        forEachMember(paramMembers, (member, memberName, memberSymbol) -> {
            HttpQueryTrait queryTrait = member.expectTrait(HttpQueryTrait.class);
            String value = "request." + memberName;

            ifValueDefined(value, memberSymbol, w -> {
                w.write(
                        "params.put(#L, #L);",
                        Strings.dq(queryTrait.getValue()),
                        queryParamValueOf(value, Symbols.getShape(memberSymbol)));
            });
        });

        writer.write("return params;");
        writer.closeBlock("},\n");
    }

    private String queryParamValueOf(String value, Shape valueShape) {
        if (valueShape.isStringShape()) {
            return value;
        } else if (valueShape.isBooleanShape()) {
            return "String.valueOf(" + value + ")";
        } else {
            throw new UnsupportedOperationException("TODO: Output query param value getter for " + valueShape);
        }
    }

    private void ifValueDefined(String value, Symbol valueSymbol, Consumer<JavaWriter> block) {
        if (!Symbols.isNullable(valueSymbol)) {
            block.accept(writer);
            return;
        }

        String check = Shapes.isListOrMap(Symbols.getShape(valueSymbol))
                ? writer.format("#T.isDefined(#L)", RuntimeTypes.Util.ApiTypeHelper, value)
                : writer.format("#L != null", value);

        writer.block("if (#L)", new Object[]{check}, block);
    }

    private void forEachMember(TriConsumer<MemberShape, String, Symbol> op) {
        forEachMember(sortedMembers, op);
    }

    private void forEachMember(Iterable<MemberShape> members, TriConsumer<MemberShape, String, Symbol> op) {
        members.forEach(m -> {
            Pair<String, Symbol> nameAndSymbol = memberNameSymbolIndex.get(m);
            op.accept(m, nameAndSymbol.left, nameAndSymbol.right);
        });
    }
}
