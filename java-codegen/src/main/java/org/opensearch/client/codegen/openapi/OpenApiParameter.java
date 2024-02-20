/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.openapi;

import io.swagger.v3.oas.models.parameters.Parameter;

public class OpenApiParameter extends OpenApiRefObject<OpenApiParameter, Parameter> {
    protected OpenApiParameter(OpenApiSpec parent, Parameter parameter) {
        super(parent, parameter, OpenApiParameter::new, api -> api.getComponents().getParameters(), Parameter::get$ref);
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

    public OpenApiSchema getSchema() {
        return new OpenApiSchema(getParent(), getInner().getSchema());
    }

    public enum In {
        QUERY, PATH;

        public static In from(String s) {
            return valueOf(s.toUpperCase());
        }
    }
}
