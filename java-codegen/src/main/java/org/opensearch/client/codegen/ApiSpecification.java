package org.opensearch.client.codegen;

import org.openapi4j.core.exception.DecodeException;
import org.openapi4j.core.exception.ResolutionException;
import org.openapi4j.core.model.OAIContext;
import org.openapi4j.core.model.reference.Reference;
import org.openapi4j.core.validation.ValidationException;
import org.openapi4j.parser.OpenApi3Parser;
import org.openapi4j.parser.model.AbsRefOpenApiSchema;
import org.openapi4j.parser.model.v3.*;
import org.opensearch.client.codegen.exceptions.ApiSpecificationParseException;
import org.opensearch.client.codegen.model.EnumShape;
import org.opensearch.client.codegen.model.Field;
import org.opensearch.client.codegen.model.ObjectShape;
import org.opensearch.client.codegen.model.OperationRequest;
import org.opensearch.client.codegen.utils.Schemas;

import java.io.File;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ApiSpecification {
    private final OAIContext context;
    private final Set<String> visitedReferencedSchemas;
    private final List<OperationRequest> operationRequests;
    private final List<ObjectShape> objectShapes;
    private final List<EnumShape> enumShapes;
    private final TypeMapper typeMapper;

    private ApiSpecification(OpenApi3 api) throws ApiSpecificationParseException {
        context = api.getContext();
        visitedReferencedSchemas = new HashSet<>();
        operationRequests = new ArrayList<>();
        objectShapes = new ArrayList<>();
        enumShapes = new ArrayList<>();
        typeMapper = new TypeMapper(context, this::visitReferencedSchema);
        visit(api);
    }

    public static ApiSpecification parse(File schemaFile) throws ApiSpecificationParseException {
        try {
            OpenApi3 api = new OpenApi3Parser().parse(schemaFile, true);
            return new ApiSpecification(api);
        } catch (ResolutionException | ValidationException e) {
            throw new ApiSpecificationParseException("Failed to parse schema: " + schemaFile, e);
        }
    }

    public List<OperationRequest> getOperationRequests() {
        return Collections.unmodifiableList(operationRequests);
    }

    public List<ObjectShape> getObjectShapes() {
        return Collections.unmodifiableList(objectShapes);
    }

    public List<EnumShape> getEnumShapes() {
        return Collections.unmodifiableList(enumShapes);
    }

    private void visit(OpenApi3 api) throws ApiSpecificationParseException {
        for (Map.Entry<String, Path> entry : api.getPaths().entrySet()) {
            visit(entry.getKey(), entry.getValue());
        }
    }

    private void visit(String httpPath, Path path) throws ApiSpecificationParseException {
        for (Map.Entry<String, Operation> entry : path.getOperations().entrySet()) {
            visit(httpPath, path, entry.getKey(), entry.getValue());
        }
    }

    private void visit(String httpPath, Path path, String httpMethod, Operation operation) throws ApiSpecificationParseException {
        OperationRequest operationRequest = new OperationRequest(
                operation.getOperationId(),
                operation.getDescription(),
                httpMethod,
                httpPath
        );

        RequestBody requestBody = resolve(operation.getRequestBody());

        if (requestBody != null) {
            Schema requestBodySchema = resolve(requestBody.getContentMediaType("application/json").getSchema());
            visitFields(requestBodySchema, operationRequest::addBodyField);
        }

        Stream.of(path.getParametersIn(context, "query"), operation.getParametersIn(context, "query"))
                .flatMap(List::stream)
                .map(p -> new Field(p.getName(), typeMapper.mapType(p.getSchema()), p.isRequired()))
                .forEach(operationRequest::addQueryParam);

        Stream.of(path.getParametersIn(context, "path"), operation.getParametersIn(context, "path"))
                .flatMap(List::stream)
                .map(p -> new Field(p.getName(), typeMapper.mapType(p.getSchema()), p.isRequired()))
                .forEach(operationRequest::addPathParam);

        operationRequests.add(operationRequest);

        MediaType responseMediaType = operation.getResponse("200").getContentMediaType("application/json");
        Schema responseSchema = responseMediaType != null ? resolve(responseMediaType.getSchema()) : new Schema();
        visitObjectShape(operation.getOperationId() + "Response", responseSchema);
    }

    private void visitReferencedSchema(String ref, Schema schema) {
        if (!visitedReferencedSchemas.add(ref)) return;

        String[] refParts = ref.split("/");
        String name = refParts[refParts.length - 1];

        if (Schemas.isObject(schema)) {
            visitObjectShape(name, schema);
        } else if (Schemas.isString(schema) && schema.hasEnums()) {
            enumShapes.add(new EnumShape(name, schema.getEnums().stream().map(Object::toString).collect(Collectors.toList())));
        }
    }

    private void visitObjectShape(String name, Schema schema) {
        ObjectShape shape = new ObjectShape(name);
        visitFields(schema, shape::addBodyField);
        objectShapes.add(shape);
    }

    private void visitFields(Schema schema, Consumer<Field> fieldVisitor) {
        Map<String, Schema> properties = schema.getProperties();

        if (properties == null) return;

        Set<String> requiredFields = new HashSet<>(schema.hasRequiredFields() ? schema.getRequiredFields() : new ArrayList<>(0));

        properties.forEach((name, propertySchema) -> fieldVisitor.accept(new Field(
                name,
                typeMapper.mapType(propertySchema),
                requiredFields.contains(name)
        )));
    }

    private RequestBody resolve(RequestBody body) throws ApiSpecificationParseException {
        return resolve(body, RequestBody.class);
    }

    private Schema resolve(Schema schema) throws ApiSpecificationParseException {
        return resolve(schema, Schema.class);
    }

    private <S extends AbsRefOpenApiSchema<S>> S resolve(S schema, Class<S> clazz) throws ApiSpecificationParseException {
        while (schema != null && schema.isRef()) {
            Reference ref = schema.getReference(context);
            try {
                schema = ref.getMappedContent(clazz);
            } catch (DecodeException e) {
                throw new ApiSpecificationParseException("Failed to decode reference as " + clazz + ": " + ref, e);
            }
        }
        return schema;
    }
}
