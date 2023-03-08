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

package org.opensearch.client.opensearch.cat;

import org.opensearch.client.opensearch._types.RequestBase;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

// typedef: cat._types.CatRequestBase


public abstract class CatRequestBase extends RequestBase {

    @Nullable
    private final String columnNames;

    @Deprecated
    public CatRequestBase() {
        this.columnNames = null;
    }

    public CatRequestBase(CatRequestBaseBuilder<?> builder) {
        this.columnNames = builder.columnNames;
    }

    protected final Map<String, String> queryParameters() {
        Map<String, String> params = new HashMap<>();
        if (columnNames != null && !columnNames.isBlank()) {
            params.put("h", columnNames);
        }
        return params;
    }


    /**
     * A comma-separated list of column names to limit the returned information
     * <p>
     * API name: {@code h}
     */
    public final String columnNames() {
        return this.columnNames;
    }

    protected abstract static class CatRequestBaseBuilder<BuilderT extends CatRequestBaseBuilder> extends ObjectBuilderBase implements ObjectBuilder {

        @Nullable
        protected String columnNames;

        protected abstract BuilderT self();

        public final BuilderT columnNames(String columns) {
            this.columnNames = columns;
            return self();
        }

    }

}
