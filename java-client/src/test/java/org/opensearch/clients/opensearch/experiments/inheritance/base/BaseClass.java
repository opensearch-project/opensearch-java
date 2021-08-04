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

package org.opensearch.clients.opensearch.experiments.inheritance.base;

import jakarta.json.stream.JsonGenerator;
import org.opensearch.clients.json.DelegatingDeserializer;
import org.opensearch.clients.json.JsonpDeserializer;
import org.opensearch.clients.json.JsonpMapper;
import org.opensearch.clients.json.ToJsonp;

import java.util.Objects;

/**
 * An abstract base class
 */
public abstract class BaseClass implements ToJsonp {

    private final String baseField;

    public BaseClass(AbstractBuilder<?> builder) {
        this.baseField = Objects.requireNonNull(builder.baseField, "baseField");
    }

    public String baseField() {
        return this.baseField;
    }

    @Override
    public void toJsonp(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        toJsonpInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void toJsonpInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.write("baseField", this.baseField);
    }

    //---------------------------------------------------------------------------------------------

    // This is class protected as it's only of interest to subclasses. Yet public members are visible
    // from the outside on public subclasses.
    protected abstract static class AbstractBuilder<T extends AbstractBuilder<T>> {

        private String baseField;

        public T baseField(String value) {
            this.baseField = value;
            return self();
        }

        protected abstract T self();
    }

    //---------------------------------------------------------------------------------------------

    protected static <T extends AbstractBuilder<T>> void setupBaseClassParser(DelegatingDeserializer<T> op) {
        op.add(AbstractBuilder::baseField, JsonpDeserializer.stringDeserializer(), "baseField");
    }
}
