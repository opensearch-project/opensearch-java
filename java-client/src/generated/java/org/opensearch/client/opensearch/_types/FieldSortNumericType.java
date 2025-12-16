/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

/*
 * Licensed to Elasticsearch B.V. under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch B.V. licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

/*
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
 */

//----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------

package org.opensearch.client.opensearch._types;

import javax.annotation.Generated;
import org.opensearch.client.json.JsonEnum;
import org.opensearch.client.json.JsonpDeserializable;

// typedef: _types.FieldSortNumericType

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public enum FieldSortNumericType implements JsonEnum {
    /**
     * The field contains date values.
     */
    Date("date"),

    /**
     * The field contains date values with nanosecond precision.
     */
    DateNanos("date_nanos"),

    /**
     * The field contains double-precision floating-point values.
     */
    Double("double"),

    /**
     * The field contains long integer values.
     */
    Long("long");

    private final String jsonValue;

    FieldSortNumericType(String jsonValue) {
        this.jsonValue = jsonValue;
    }

    public String jsonValue() {
        return this.jsonValue;
    }

    public static final JsonEnum.Deserializer<FieldSortNumericType> _DESERIALIZER = new JsonEnum.Deserializer<>(
        FieldSortNumericType.values()
    );
}
