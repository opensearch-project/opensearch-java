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
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: ism.Metadata

@Generated("org.opensearch.client.codegen.CodeGenerator")
public abstract class Metadata implements PlainJsonSerializable {

    @Nullable
    private final String id;

    @Nullable
    private final Number primaryTerm;

    @Nullable
    private final Long seqNo;

    @Nullable
    private final Long version;

    // ---------------------------------------------------------------------------------------------

    protected Metadata(AbstractBuilder<?> builder) {
        this.id = builder.id;
        this.primaryTerm = builder.primaryTerm;
        this.seqNo = builder.seqNo;
        this.version = builder.version;
    }

    /**
     * API name: {@code _id}
     */
    @Nullable
    public final String id() {
        return this.id;
    }

    /**
     * The primary term of the document.
     * <p>
     * API name: {@code _primary_term}
     * </p>
     */
    @Nullable
    public final Number primaryTerm() {
        return this.primaryTerm;
    }

    /**
     * API name: {@code _seq_no}
     */
    @Nullable
    public final Long seqNo() {
        return this.seqNo;
    }

    /**
     * API name: {@code _version}
     */
    @Nullable
    public final Long version() {
        return this.version;
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
        if (this.id != null) {
            generator.writeKey("_id");
            generator.write(this.id);
        }

        if (this.primaryTerm != null) {
            generator.writeKey("_primary_term");
            generator.write(this.primaryTerm.doubleValue());
        }

        if (this.seqNo != null) {
            generator.writeKey("_seq_no");
            generator.write(this.seqNo);
        }

        if (this.version != null) {
            generator.writeKey("_version");
            generator.write(this.version);
        }
    }

    // ---------------------------------------------------------------------------------------------

    public abstract static class AbstractBuilder<BuilderT extends AbstractBuilder<BuilderT>> extends ObjectBuilderBase {
        @Nullable
        private String id;
        @Nullable
        private Number primaryTerm;
        @Nullable
        private Long seqNo;
        @Nullable
        private Long version;

        protected AbstractBuilder() {}

        protected AbstractBuilder(Metadata o) {
            this.id = o.id;
            this.primaryTerm = o.primaryTerm;
            this.seqNo = o.seqNo;
            this.version = o.version;
        }

        protected AbstractBuilder(AbstractBuilder<BuilderT> o) {
            this.id = o.id;
            this.primaryTerm = o.primaryTerm;
            this.seqNo = o.seqNo;
            this.version = o.version;
        }

        @Nonnull
        protected abstract BuilderT self();

        /**
         * API name: {@code _id}
         */
        @Nonnull
        public final BuilderT id(@Nullable String value) {
            this.id = value;
            return self();
        }

        /**
         * The primary term of the document.
         * <p>
         * API name: {@code _primary_term}
         * </p>
         */
        @Nonnull
        public final BuilderT primaryTerm(@Nullable Number value) {
            this.primaryTerm = value;
            return self();
        }

        /**
         * API name: {@code _seq_no}
         */
        @Nonnull
        public final BuilderT seqNo(@Nullable Long value) {
            this.seqNo = value;
            return self();
        }

        /**
         * API name: {@code _version}
         */
        @Nonnull
        public final BuilderT version(@Nullable Long value) {
            this.version = value;
            return self();
        }
    }

    // ---------------------------------------------------------------------------------------------

    protected static <BuilderT extends AbstractBuilder<BuilderT>> void setupMetadataDeserializer(ObjectDeserializer<BuilderT> op) {
        op.add(AbstractBuilder::id, JsonpDeserializer.stringDeserializer(), "_id");
        op.add(AbstractBuilder::primaryTerm, JsonpDeserializer.numberDeserializer(), "_primary_term");
        op.add(AbstractBuilder::seqNo, JsonpDeserializer.longDeserializer(), "_seq_no");
        op.add(AbstractBuilder::version, JsonpDeserializer.longDeserializer(), "_version");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.id);
        result = 31 * result + Objects.hashCode(this.primaryTerm);
        result = 31 * result + Objects.hashCode(this.seqNo);
        result = 31 * result + Objects.hashCode(this.version);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Metadata other = (Metadata) o;
        return Objects.equals(this.id, other.id)
            && Objects.equals(this.primaryTerm, other.primaryTerm)
            && Objects.equals(this.seqNo, other.seqNo)
            && Objects.equals(this.version, other.version);
    }
}
