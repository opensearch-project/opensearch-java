/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.model;

import java.util.Collection;
import java.util.List;
import org.opensearch.client.codegen.model.types.TypeRef;
import org.opensearch.client.codegen.model.types.Types;
import org.opensearch.client.codegen.transformer.overrides.ShouldGenerate;

public class DictionaryResponseShape extends Shape {
    private final TypeRef keyType;
    private final TypeRef valueType;

    public DictionaryResponseShape(
        Namespace parent,
        String className,
        String typedefName,
        String description,
        TypeRef keyType,
        TypeRef valueType,
        ShouldGenerate shouldGenerate
    ) {
        super(parent, className, typedefName, description, shouldGenerate);
        this.keyType = keyType;
        this.valueType = valueType;
        setExtendsType(Types.Client.Transport.Endpoints.DictionaryResponse(keyType, valueType));
    }

    @Override
    public Collection<TypeRef> getAnnotations() {
        return List.of(Types.Client.Json.JsonpDeserializable);
    }

    @Override
    public boolean extendsOtherShape() {
        return true;
    }

    public boolean superImplementsJsonSerializable() {
        return true;
    }
}
