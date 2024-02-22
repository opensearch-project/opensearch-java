/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.openapi;

import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.parameters.Parameter;
import java.util.Optional;
import java.util.function.Function;

public class OpenApiParameter extends OpenApiRefObject<OpenApiParameter, Parameter> {
    protected OpenApiParameter(OpenApiSpec parent, JsonPointer jsonPtr, Parameter parameter) {
        super(parent, jsonPtr, parameter, OpenApiParameter::new, api -> api.getComponents().getParameters(), Parameter::get$ref);
    }

    public String getName() {
        return getInner().getName();
    }

    public String getDescription() {
        return getInner().getDescription();
    }

    public In getIn() {
        return In.from(getInner().getIn());
    }

    public boolean getRequired() {
        return getInner().getRequired();
    }

    public Optional<OpenApiSchema> getSchema() {
        return childOpt("schema", (Function<Parameter, Schema<?>>) Parameter::getSchema, OpenApiSchema::new);
    }

    @Override
    protected OpenApiParameter getSelf() {
        return this;
    }

    public enum In {
        QUERY,
        PATH;

        public static In from(String s) {
            return valueOf(s.toUpperCase());
        }
    }
}
