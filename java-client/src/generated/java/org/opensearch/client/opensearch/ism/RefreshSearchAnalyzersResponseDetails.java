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

package org.opensearch.client.opensearch.ism;

import jakarta.json.stream.JsonGenerator;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: ism.RefreshSearchAnalyzersResponseDetails

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class RefreshSearchAnalyzersResponseDetails
    implements
        PlainJsonSerializable,
        ToCopyableBuilder<RefreshSearchAnalyzersResponseDetails.Builder, RefreshSearchAnalyzersResponseDetails> {

    @Nullable
    private final String index;

    @Nonnull
    private final List<String> refreshedAnalyzers;

    // ---------------------------------------------------------------------------------------------

    private RefreshSearchAnalyzersResponseDetails(Builder builder) {
        this.index = builder.index;
        this.refreshedAnalyzers = ApiTypeHelper.unmodifiable(builder.refreshedAnalyzers);
    }

    public static RefreshSearchAnalyzersResponseDetails of(
        Function<RefreshSearchAnalyzersResponseDetails.Builder, ObjectBuilder<RefreshSearchAnalyzersResponseDetails>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The name of the index.
     * <p>
     * API name: {@code index}
     * </p>
     */
    @Nullable
    public final String index() {
        return this.index;
    }

    /**
     * The list of refreshed analyzers.
     * <p>
     * API name: {@code refreshed_analyzers}
     * </p>
     */
    @Nonnull
    public final List<String> refreshedAnalyzers() {
        return this.refreshedAnalyzers;
    }

    /**
     * Serialize this object to JSON.
     */
    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        if (this.index != null) {
            generator.writeKey("index");
            generator.write(this.index);
        }

        if (ApiTypeHelper.isDefined(this.refreshedAnalyzers)) {
            generator.writeKey("refreshed_analyzers");
            generator.writeStartArray();
            for (String item0 : this.refreshedAnalyzers) {
                generator.write(item0);
            }
            generator.writeEnd();
        }
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    @Nonnull
    public Builder toBuilder() {
        return new Builder(this);
    }

    @Nonnull
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builder for {@link RefreshSearchAnalyzersResponseDetails}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, RefreshSearchAnalyzersResponseDetails> {
        @Nullable
        private String index;
        @Nullable
        private List<String> refreshedAnalyzers;

        public Builder() {}

        private Builder(RefreshSearchAnalyzersResponseDetails o) {
            this.index = o.index;
            this.refreshedAnalyzers = _listCopy(o.refreshedAnalyzers);
        }

        private Builder(Builder o) {
            this.index = o.index;
            this.refreshedAnalyzers = _listCopy(o.refreshedAnalyzers);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The name of the index.
         * <p>
         * API name: {@code index}
         * </p>
         */
        @Nonnull
        public final Builder index(@Nullable String value) {
            this.index = value;
            return this;
        }

        /**
         * The list of refreshed analyzers.
         * <p>
         * API name: {@code refreshed_analyzers}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>refreshedAnalyzers</code>.
         * </p>
         */
        @Nonnull
        public final Builder refreshedAnalyzers(List<String> list) {
            this.refreshedAnalyzers = _listAddAll(this.refreshedAnalyzers, list);
            return this;
        }

        /**
         * The list of refreshed analyzers.
         * <p>
         * API name: {@code refreshed_analyzers}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>refreshedAnalyzers</code>.
         * </p>
         */
        @Nonnull
        public final Builder refreshedAnalyzers(String value, String... values) {
            this.refreshedAnalyzers = _listAdd(this.refreshedAnalyzers, value, values);
            return this;
        }

        /**
         * Builds a {@link RefreshSearchAnalyzersResponseDetails}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public RefreshSearchAnalyzersResponseDetails build() {
            _checkSingleUse();

            return new RefreshSearchAnalyzersResponseDetails(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link RefreshSearchAnalyzersResponseDetails}
     */
    public static final JsonpDeserializer<RefreshSearchAnalyzersResponseDetails> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        RefreshSearchAnalyzersResponseDetails::setupRefreshSearchAnalyzersResponseDetailsDeserializer
    );

    protected static void setupRefreshSearchAnalyzersResponseDetailsDeserializer(
        ObjectDeserializer<RefreshSearchAnalyzersResponseDetails.Builder> op
    ) {
        op.add(Builder::index, JsonpDeserializer.stringDeserializer(), "index");
        op.add(
            Builder::refreshedAnalyzers,
            JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()),
            "refreshed_analyzers"
        );
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.index);
        result = 31 * result + Objects.hashCode(this.refreshedAnalyzers);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        RefreshSearchAnalyzersResponseDetails other = (RefreshSearchAnalyzersResponseDetails) o;
        return Objects.equals(this.index, other.index) && Objects.equals(this.refreshedAnalyzers, other.refreshedAnalyzers);
    }
}
