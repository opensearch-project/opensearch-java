package org.opensearch.client.codegen.core

import org.opensearch.client.codegen.OpenSearchJavaSettings
import org.opensearch.client.codegen.model.SymbolProperty
import org.opensearch.client.codegen.model.boxed
import org.opensearch.client.codegen.model.nullable
import software.amazon.smithy.codegen.core.ReservedWordSymbolProvider
import software.amazon.smithy.codegen.core.Symbol
import software.amazon.smithy.codegen.core.SymbolProvider
import software.amazon.smithy.model.Model
import software.amazon.smithy.model.knowledge.NullableIndex
import software.amazon.smithy.model.shapes.*
import java.util.logging.Logger

class JavaSymbolProvider(
    private val model: Model,
    private val settings: OpenSearchJavaSettings
) : SymbolProvider, ShapeVisitor<Symbol> {
    private val rootNamespace = "org.opensearch.client"
    private val service = settings.getService(model)
    private val logger = Logger.getLogger(javaClass.name)
    private val escaper: ReservedWordSymbolProvider.Escaper
    private val nullableIndex = NullableIndex(model)

    private var depth = 0

    init {
        val reservedWords = javaReservedWords()
        escaper = ReservedWordSymbolProvider.builder()
            .nameReservedWords(reservedWords)
            .memberReservedWords(reservedWords)
            .escapePredicate { _, symbol -> symbol.definitionFile.isNotEmpty() }
            .buildEscaper()
    }

    companion object {
        fun isTypeGeneratedForShape(shape: Shape): Boolean = when {
            shape.isEnumShape || shape.isIntEnumShape || shape.isStructureShape || shape.isUnionShape -> true
            else -> false
        }
    }

    override fun toSymbol(shape: Shape): Symbol {
        depth++
        val symbol: Symbol = shape.accept(this)
        depth--
        logger.fine("creating symbol from $shape: $symbol")
        return escaper.escapeSymbol(shape, symbol)
    }

    override fun toMemberName(shape: MemberShape): String = escaper.escapeMemberName(shape.defaultName())

    override fun blobShape(shape: BlobShape?): Symbol {
        TODO("Not yet implemented")
    }

    override fun booleanShape(shape: BooleanShape?): Symbol =
        createSymbolBuilder(shape, "boolean").build()

    override fun listShape(shape: ListShape): Symbol {
        val reference = toSymbol(shape.member).toBuilder().boxed().build()
        return createSymbolBuilder(shape, "List<${reference.name}>")
            .namespace("java.util", ".")
            .addReference(reference)
            .build()
    }

    override fun mapShape(shape: MapShape): Symbol {
        val reference = toSymbol(shape.value).toBuilder().boxed().build()
        return createSymbolBuilder(shape, "Map<String, ${reference.name}>")
            .namespace("java.util", ".")
            .addReference(reference)
            .build()
    }

    override fun byteShape(shape: ByteShape?): Symbol {
        TODO("Not yet implemented")
    }

    override fun shortShape(shape: ShortShape?): Symbol {
        TODO("Not yet implemented")
    }

    override fun integerShape(shape: IntegerShape?): Symbol =
        createSymbolBuilder(shape, "int").build()

    override fun longShape(shape: LongShape?): Symbol {
        TODO("Not yet implemented")
    }

    override fun floatShape(shape: FloatShape?): Symbol {
        TODO("Not yet implemented")
    }

    override fun documentShape(shape: DocumentShape?): Symbol {
        TODO("Not yet implemented")
    }

    override fun doubleShape(shape: DoubleShape?): Symbol {
        TODO("Not yet implemented")
    }

    override fun bigIntegerShape(shape: BigIntegerShape?): Symbol {
        TODO("Not yet implemented")
    }

    override fun bigDecimalShape(shape: BigDecimalShape?): Symbol {
        TODO("Not yet implemented")
    }

    override fun operationShape(shape: OperationShape): Symbol {
        val name = shape.defaultName()
        return createSymbolBuilder(shape, name)
            .namespace(rootNamespace, ".")
            .definitionFile("$name.java")
            .build()
    }

    override fun resourceShape(shape: ResourceShape?): Symbol {
        TODO("Not yet implemented")
    }

    override fun serviceShape(shape: ServiceShape): Symbol {
        val name = shape.defaultName()
        return createSymbolBuilder(shape, name)
            .namespace(rootNamespace, ".")
            .definitionFile("$name.java")
            .build()
    }

    public fun serviceAsyncSymbol(shape: ServiceShape): Symbol {
        val name = shape.asyncName()
        return createSymbolBuilder(shape, name)
            .namespace(rootNamespace, ".")
            .definitionFile("$name.java")
            .build()
    }

    override fun stringShape(shape: StringShape?): Symbol =
        createSymbolBuilder(shape, "String").build()

    override fun structureShape(shape: StructureShape): Symbol {
        val name = shape.defaultName()
        return createSymbolBuilder(shape, name)
            .namespace(rootNamespace, ".")
            .definitionFile("$name.java")
            .build()
    }

    override fun unionShape(shape: UnionShape?): Symbol {
        TODO("Not yet implemented")
    }

    override fun memberShape(shape: MemberShape): Symbol {
        val targetShape = model.expectShape(shape.target)

        val targetSymbol = if (nullableIndex.isMemberNullable(shape, NullableIndex.CheckMode.CLIENT)) {
            toSymbol(targetShape).toBuilder().nullable().build()
        } else {
            toSymbol(targetShape)
        }

        return targetSymbol
    }

    override fun timestampShape(shape: TimestampShape?): Symbol {
        TODO("Not yet implemented")
    }

    private fun createSymbolBuilder(shape: Shape?, typeName: String): Symbol.Builder {
        val builder = Symbol.builder()
            .putProperty(SymbolProperty.SHAPE_KEY, shape)
            .name(typeName)
        return builder
    }
}