package org.opensearch.client.codegen.core;

import org.opensearch.client.codegen.model.Symbols;
import software.amazon.smithy.codegen.core.ReservedWordSymbolProvider;
import software.amazon.smithy.codegen.core.Symbol;
import software.amazon.smithy.codegen.core.SymbolProvider;
import software.amazon.smithy.model.Model;
import software.amazon.smithy.model.knowledge.NullableIndex;
import software.amazon.smithy.model.shapes.*;

import java.util.logging.Logger;

public class JavaSymbolProvider implements ShapeVisitor<Symbol>, SymbolProvider {
    private static final String ROOT_NAMESPACE = "org.opensearch.client";
    private static final Logger LOGGER = Logger.getLogger(JavaSymbolProvider.class.getName());
    private final Model model;
    private final ReservedWordSymbolProvider.Escaper escaper;
    private final NullableIndex nullableIndex;
    private int depth = 0;

    public JavaSymbolProvider(Model model) {
        this.model = model;
        this.escaper = ReservedWordSymbolProvider
                .builder()
                .nameReservedWords(JavaReservedWords.instance())
                .memberReservedWords(JavaReservedWords.instance())
                .escapePredicate((shape, symbol) -> !symbol.getDefinitionFile().isEmpty())
                .buildEscaper();
        this.nullableIndex = new NullableIndex(model);
    }

    @Override
    public Symbol toSymbol(Shape shape) {
        ++depth;
        Symbol symbol = shape.accept(this);
        --depth;
        LOGGER.fine("Creating symbol from " + shape + ": " + symbol);
        return escaper.escapeSymbol(shape, symbol);
    }

    @Override
    public String toMemberName(MemberShape shape) {
        return escaper.escapeMemberName(Naming.defaultName(shape));
    }

    @Override
    public Symbol blobShape(BlobShape shape) {
        return null;
    }

    @Override
    public Symbol booleanShape(BooleanShape shape) {
        return Symbols.forShape(shape, "boolean").build();
    }

    @Override
    public Symbol listShape(ListShape shape) {
        Symbol reference = Symbols.boxed(toSymbol(shape.getMember()).toBuilder()).build();
        return Symbols.forShape(shape, "List<" + reference.getName() + ">")
                .addReference(RuntimeTypes.JavaUtil.List)
                .addReference(reference)
                .build();
    }

    @Override
    public Symbol mapShape(MapShape shape) {
        Symbol reference = Symbols.boxed(toSymbol(shape.getValue()).toBuilder()).build();
        return Symbols.forShape(shape, "Map<String, " + reference.getName() + ">")
                .addReference(RuntimeTypes.JavaUtil.Map)
                .addReference(reference)
                .build();
    }

    @Override
    public Symbol byteShape(ByteShape shape) {
        return null;
    }

    @Override
    public Symbol shortShape(ShortShape shape) {
        return null;
    }

    @Override
    public Symbol integerShape(IntegerShape shape) {
        return Symbols.forShape(shape, "int").build();
    }

    @Override
    public Symbol longShape(LongShape shape) {
        return null;
    }

    @Override
    public Symbol floatShape(FloatShape shape) {
        return null;
    }

    @Override
    public Symbol documentShape(DocumentShape shape) {
        return null;
    }

    @Override
    public Symbol doubleShape(DoubleShape shape) {
        return null;
    }

    @Override
    public Symbol bigIntegerShape(BigIntegerShape shape) {
        return null;
    }

    @Override
    public Symbol bigDecimalShape(BigDecimalShape shape) {
        return null;
    }

    @Override
    public Symbol operationShape(OperationShape shape) {
        String name = Naming.defaultName(shape);
        return Symbols.forShape(shape, name)
                .namespace(ROOT_NAMESPACE, ".")
                .definitionFile(name + ".java")
                .build();
    }

    @Override
    public Symbol resourceShape(ResourceShape shape) {
        return null;
    }

    @Override
    public Symbol serviceShape(ServiceShape shape) {
        String name = Naming.defaultName(shape);
        return Symbols.forShape(shape, name)
                .namespace(ROOT_NAMESPACE, ".")
                .definitionFile(name + ".java")
                .build();
    }

    public Symbol serviceAsyncSymbol(ServiceShape shape) {
        String name = Naming.asyncName(shape);
        return Symbols.forShape(shape, name)
                .namespace(ROOT_NAMESPACE, ".")
                .definitionFile(name + ".java")
                .build();
    }

    @Override
    public Symbol stringShape(StringShape shape) {
        return Symbols.forShape(shape, "String").build();
    }

    @Override
    public Symbol structureShape(StructureShape shape) {
        String name = Naming.defaultName(shape);
        return Symbols.forShape(shape, name)
                .namespace(ROOT_NAMESPACE, ".")
                .definitionFile(name + ".java")
                .build();
    }

    @Override
    public Symbol unionShape(UnionShape shape) {
        return null;
    }

    @Override
    public Symbol memberShape(MemberShape shape) {
        Shape targetShape = model.expectShape(shape.getTarget());
        Symbol targetSymbol = toSymbol(targetShape);
        return nullableIndex.isMemberNullable(shape, NullableIndex.CheckMode.CLIENT)
                ? Symbols.nullable(targetSymbol.toBuilder()).build()
                : targetSymbol;
    }

    @Override
    public Symbol timestampShape(TimestampShape shape) {
        return null;
    }
}
