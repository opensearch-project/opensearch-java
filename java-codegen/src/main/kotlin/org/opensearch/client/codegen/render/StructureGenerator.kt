package org.opensearch.client.codegen.render

import org.opensearch.client.codegen.core.*
import org.opensearch.client.codegen.core.traits.SyntheticInputTrait
import org.opensearch.client.codegen.model.*
import org.opensearch.client.codegen.utils.dq
import software.amazon.smithy.codegen.core.Symbol
import software.amazon.smithy.model.knowledge.HttpBinding
import software.amazon.smithy.model.shapes.*
import software.amazon.smithy.model.traits.HttpQueryTrait
import software.amazon.smithy.model.traits.HttpTrait

class StructureGenerator(
    private val ctx: RenderingContext<StructureShape>
) {
    private val shape = requireNotNull(ctx.shape)
    private val writer = ctx.writer
    private val symbolProvider = ctx.symbolProvider
    private val model = ctx.model
    private val symbol = ctx.symbolProvider.toSymbol(ctx.shape)
    private val isInput = shape.hasTrait<SyntheticInputTrait>()

    private val sortedMembers: List<MemberShape> = shape.allMembers.values.sortedBy { it.defaultName() }
    private val memberNameSymbolIndex: Map<MemberShape, Pair<String, Symbol>> =
        sortedMembers.associateWith { member ->
            Pair(symbolProvider.toMemberName(member), symbolProvider.toSymbol(member))
        }

    fun render() {
        writer.javaClass(
            JavaVisibility.PUBLIC,
            symbol.name,
            annotations = listOf(RuntimeTypes.Json.JsonpDeserializable),
            extends = if (isInput) RuntimeTypes.OpenSearch.Types.RequestBase else null,
            implements = listOf(RuntimeTypes.Json.JsonpSerializable)
        ) {
            renderFields()
            renderConstructor()
            renderGetters()
            renderSerialize()
            renderBuilder()
            renderDeserialize()
            if (isInput) {
                renderEndpoint()
            }
        }
    }

    private fun forEachMember(op: (memberShape: MemberShape, memberName: String, memberSymbol: Symbol) -> Unit) =
        forEachMember(sortedMembers, op)

    private fun forEachMember(
        members: List<MemberShape>,
        op: (memberShape: MemberShape, memberName: String, memberSymbol: Symbol) -> Unit
    ) =
        members.forEach {
            val (memberName, memberSymbol) = memberNameSymbolIndex[it]!!

            op(it, memberName, memberSymbol)
        }

    private fun renderFields(final: Boolean = true) {
        forEachMember { _, memberName, memberSymbol ->
            if (memberSymbol.isNullable && !(final && memberSymbol.shape.isListOrMap)) {
                writer.write("@#T", RuntimeTypes.Javax.Nullable)
            }
            writer.write(
                "private #L#T #L;",
                if (final) "final " else "",
                memberSymbol, memberName
            )
            writer.write("")
        }
    }

    private fun renderConstructor() {
        writer.block("private #T(Builder builder)", symbol) {
            forEachMember { _, memberName, memberSymbol ->
                var builderField = format("builder.#L", memberName)

                if (memberSymbol.shape.isListOrMap) {
                    builderField = if (memberSymbol.isNullable) {
                        format("#T.unmodifiable(#L)", RuntimeTypes.Util.ApiTypeHelper, builderField)
                    } else {
                        format(
                            "#T.unmodifiableRequired(#L, this, #L)",
                            RuntimeTypes.Util.ApiTypeHelper, builderField, memberName.dq()
                        )
                    }
                } else if (!memberSymbol.isNullable) {
                    builderField = format(
                        "#T.requireNonNull(#L, this, #L)",
                        RuntimeTypes.Util.ApiTypeHelper, builderField, memberName.dq()
                    )
                }

                write("this.#L = #L;", memberName, builderField)
            }
        }
        writer.write("")

        writer.block(
            "public static #1T of(#2T<Builder, #3T<#1T>> fn)",
            symbol, RuntimeTypes.JavaUtil.Function, RuntimeTypes.Util.ObjectBuilder
        ) {
            write("return fn.apply(new Builder()).build();")
        }
        writer.write("")
    }

    private fun renderGetters() {
        forEachMember { _, memberName, memberSymbol ->
            if (memberSymbol.isNullable && !memberSymbol.shape.isListOrMap) {
                writer.write("@#T", RuntimeTypes.Javax.Nullable)
            }

            writer.block("public final #T #L()", memberSymbol, memberName) {
                write("return this.#L;", memberName)
            }
            writer.write("")
        }
    }

    private fun renderSerialize() {
        writer.block(
            "public void serialize(#T generator, #T mapper)",
            RuntimeTypes.Jakarta.JsonGenerator, RuntimeTypes.Json.JsonpMapper
        ) {
            write(
                """
                generator.writeStartObject();
                serializeInternal(generator, mapper);
                generator.writeEnd();
            """.trimIndent()
            )
        }
        writer.write("")

        writer.block(
            "protected void serializeInternal(#T generator, #T mapper)",
            RuntimeTypes.Jakarta.JsonGenerator, RuntimeTypes.Json.JsonpMapper
        ) {
            forEachMember(getDocumentFields(), ::renderSerializeField)
        }
        writer.write("")
    }

    private fun getDocumentFields(): List<MemberShape> =
        if (!isInput) {
            sortedMembers
        } else {
            ctx.httpBindingIndex.getRequestBindings(
                shape.expectTrait<SyntheticInputTrait>().operation,
                HttpBinding.Location.DOCUMENT
            )
                .map { it.member }
                .sortedBy { it.memberName }
        }

    private fun renderSerializeField(memberShape: MemberShape, memberName: String, memberSymbol: Symbol) {
        writer.ifValueDefined("this.${memberName}", memberSymbol) {
            write("generator.writeKey(${memberShape.memberName.dq()});")
            renderSerializeValue("this.${memberName}", memberSymbol.shape)
        }
    }

    private fun renderSerializeValue(value: String, valueShape: Shape) {
        when (valueShape) {
            is StructureShape -> writer.write("${value}.serialize(generator, mapper);")
            is ListShape -> {
                val elementSymbol = symbolProvider.toSymbol(valueShape.elementShape).toBuilder().boxed().build()
                writer.write("generator.writeStartArray();")
                writer.block("for (#T item : #L)", elementSymbol, value) {
                    renderSerializeValue("item", valueShape.elementShape)
                }
                writer.write("generator.writeEnd();")
            }

            is MapShape -> {
                val elementSymbol = symbolProvider.toSymbol(valueShape.elementShape).toBuilder().boxed().build()
                writer.write("generator.writeStartObject();")
                writer.block(
                    "for (#T.Entry<String, #T> item : #L.entrySet())",
                    RuntimeTypes.JavaUtil.Map,
                    elementSymbol,
                    value
                ) {
                    write("generator.writeKey(item.getKey());")
                    renderSerializeValue("item.getValue()", valueShape.elementShape)
                }
                writer.write("generator.writeEnd();")
            }

            else -> writer.write("generator.write(${value});")
        }
    }

    private fun JavaWriter.ifValueDefined(value: String, valueSymbol: Symbol, block: JavaWriter.() -> Unit) {
        if (!valueSymbol.isNullable) {
            this.block()
            return
        }

        val check = if (valueSymbol.shape.isListOrMap) {
            format("#T.isDefined($value)", RuntimeTypes.Util.ApiTypeHelper)
        } else {
            "$value != null"
        }

        this.block("if (${check})", block = block)
    }

    private fun renderBuilder() {
        writer.block(
            "public static class Builder extends #T implements #T<#T>",
            RuntimeTypes.Util.ObjectBuilderBase, RuntimeTypes.Util.ObjectBuilder, symbol
        ) {
            renderFields(false)

            forEachMember { memberShape, memberName, memberSymbol ->
                when (val valueShape = memberShape.targetShape) {
                    is ListShape -> {
                        block("public final Builder #L(#T list)", memberName, memberSymbol) {
                            write(
                                """
                                this.#1L = _listAddAll(this.#1L, list);
                                return this;
                                """.trimIndent(), memberName
                            )
                        }
                        write("")

                        val elementSymbol = symbolProvider.toSymbol(valueShape.elementShape)
                        block("public final Builder #1L(#2T value, #2T... values)", memberName, elementSymbol) {
                            write(
                                """
                                this.#1L = _listAdd(this.#1L, value, values);
                                return this;
                                """.trimIndent(), memberName
                            )
                        }
                    }

                    is MapShape -> {
                        block("public final Builder #L(#T map)", memberName, memberSymbol) {
                            write(
                                """
                                this.#1L = _mapPutAll(this.#1L, map);
                                return this;
                                """.trimIndent(), memberName
                            )
                        }
                        write("")

                        val elementSymbol = symbolProvider.toSymbol(valueShape.elementShape)
                        block("public final Builder #L(String key, #T value)", memberName, elementSymbol) {
                            write(
                                """
                                this.#1L = _mapPut(this.#1L, key, value);
                                return this;
                                """.trimIndent(), memberName
                            )
                        }
                    }

                    else -> {
                        block("public final Builder #L(#T value)", memberName, memberSymbol) {
                            write(
                                """
                                this.#L = value;
                                return this;
                                """.trimIndent(), memberName
                            )
                        }
                    }
                }

                write("")
            }

            block("public #T build()", symbol) {
                write(
                    """
                    _checkSingleUse();
                    return new #T(this);
                """.trimIndent(), symbol
                )
            }
        }
        writer.write("")
    }

    private fun renderDeserialize() {
        val setupDeserializer = writer.format("setup#LDeserializer", symbol.name)

        writer.write(
            "public static final #1T<#2T> _DESERIALIZER = #3T.lazy(Builder::new, #2T::#4L);",
            RuntimeTypes.Json.JsonpDeserializer,
            symbol,
            RuntimeTypes.Json.ObjectBuilderDeserializer,
            setupDeserializer
        )
        writer.write("")

        writer.block(
            "protected static void #L(#T<#T.Builder> op)",
            setupDeserializer, RuntimeTypes.Json.ObjectDeserializer, symbol
        ) {
            forEachMember(getDocumentFields()) { memberShape, memberName, memberSymbol ->
                write("op.add(Builder::${memberName}, ${valueDeserializer(memberSymbol.shape)}, ${memberShape.memberName.dq()});")
            }
        }
        writer.write("")
    }

    private fun valueDeserializer(valueShape: Shape): String =
        when (valueShape) {
            is StructureShape -> writer.format("#T._DESERIALIZER", symbolProvider.toSymbol(valueShape))
            is ListShape -> {
                writer.format(
                    "#T.arrayDeserializer(#L)",
                    RuntimeTypes.Json.JsonpDeserializer,
                    valueDeserializer(valueShape.elementShape)
                )
            }

            is MapShape -> {
                writer.format(
                    "#T.stringMapDeserializer(#L)",
                    RuntimeTypes.Json.JsonpDeserializer,
                    valueDeserializer(valueShape.elementShape)
                )
            }

            is BooleanShape -> writer.format("#T.booleanDeserializer()", RuntimeTypes.Json.JsonpDeserializer)
            is StringShape -> writer.format("#T.stringDeserializer()", RuntimeTypes.Json.JsonpDeserializer)
            is IntegerShape -> writer.format("#T.integerDeserializer()", RuntimeTypes.Json.JsonpDeserializer)
            else -> TODO("Output correct deserializer for $valueShape")
        }

    private val MemberShape.targetShape: Shape
        get() = model.expectShape(target)

    private val ListShape.elementShape: Shape
        get() = member.targetShape

    private val MapShape.elementShape: Shape
        get() = value.targetShape

    private fun renderEndpoint() {
        val inputTrait = shape.expectTrait<SyntheticInputTrait>()
        val operation = model.expectShape<OperationShape>(inputTrait.operation)
        val httpTrait = operation.expectTrait<HttpTrait>()
        val outputShape = model.expectShape<Shape>(operation.outputShape)
        val outputSymbol = symbolProvider.toSymbol(outputShape)

        writer.openBlock(
            "public static final #T<#T, #T, #T> _ENDPOINT = new #T<>(",
            RuntimeTypes.Transport.Endpoint,
            symbol,
            outputSymbol,
            RuntimeTypes.OpenSearch.Types.ErrorResponse,
            RuntimeTypes.Transport.Endpoints.SimpleEndpoint
        )

        writer.write(
            """
            // Request method
            request -> ${httpTrait.method.dq()},
            
            """.trimIndent()
        )

        writer.write("// Request path")
        writer.openBlock("request -> {")
        writer.write("StringBuilder buf = new StringBuilder();")
        val labelMembers = ctx.httpBindingIndex.getRequestBindings(operation, HttpBinding.Location.LABEL)
            .map { it.member }
            .associateBy { it.memberName }
        httpTrait.uri.segments.forEach { segment ->
            writer.write("buf.append('/');")
            if (segment.isLabel || segment.isGreedyLabel) {
                writer.write(
                    "#T.pathEncode(request.#L, buf);",
                    RuntimeTypes.Transport.Endpoints.SimpleEndpoint,
                    symbolProvider.toMemberName(labelMembers[segment.content])
                )
            } else {
                writer.write("buf.append(${segment.content.dq()});")
            }
        }
        writer.write("return buf.toString();")
        writer.closeBlock("},\n")

        writer.write("// Request parameters")
        writer.openBlock("request -> {")
        writer.write(
            "#T<String, String> params = new #T<>();",
            RuntimeTypes.JavaUtil.Map,
            RuntimeTypes.JavaUtil.HashMap
        )
        val paramMembers = ctx.httpBindingIndex.getRequestBindings(operation, HttpBinding.Location.QUERY)
            .map { it.member }
            .sortedBy { it.memberName }
        forEachMember(paramMembers, ::renderQueryParam)
        writer.write("return params;")
        writer.closeBlock("},\n")

        // TODO: headers?
        writer.write(
            """
            // Request headers
            #T.emptyMap(),
        """.trimIndent(), RuntimeTypes.Transport.Endpoints.SimpleEndpoint
        )

        // TODO: maybe no requestbody?
        writer.write(
            """
            // Has request body
            true,
        """.trimIndent()
        )

        writer.write(
            """
            // Response deserializer
            #T._DESERIALIZER
        """.trimIndent(), outputSymbol
        )

        writer.closeBlock(");")
    }

    private fun renderQueryParam(memberShape: MemberShape, memberName: String, memberSymbol: Symbol) {
        val queryTrait = memberShape.expectTrait<HttpQueryTrait>()

        val value = "request.${memberName}"
        writer.ifValueDefined(value, memberSymbol) {
            write("params.put(${queryTrait.value.dq()}, ${queryParamValueOf(value, memberSymbol.shape)});")
        }
    }

    private fun queryParamValueOf(value: String, valueShape: Shape): String =
        when (valueShape) {
            is StringShape -> value
            is BooleanShape -> "String.valueOf($value)"
            else -> TODO("Output query param value getter for $valueShape")
        }
}