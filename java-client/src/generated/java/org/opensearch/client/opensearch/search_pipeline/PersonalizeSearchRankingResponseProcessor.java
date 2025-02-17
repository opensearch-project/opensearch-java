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

package org.opensearch.client.opensearch.search_pipeline;

import jakarta.json.stream.JsonGenerator;
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

// typedef: search_pipeline.PersonalizeSearchRankingResponseProcessor

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class PersonalizeSearchRankingResponseProcessor
    implements
        ResponseProcessorVariant,
        PlainJsonSerializable,
        ToCopyableBuilder<PersonalizeSearchRankingResponseProcessor.Builder, PersonalizeSearchRankingResponseProcessor> {

    @Nonnull
    private final String campaignArn;

    @Nullable
    private final String description;

    @Nullable
    private final String iamRoleArn;

    @Nullable
    private final Boolean ignoreFailure;

    @Nullable
    private final String itemIdField;

    @Nonnull
    private final String recipe;

    @Nullable
    private final String tag;

    private final float weight;

    // ---------------------------------------------------------------------------------------------

    private PersonalizeSearchRankingResponseProcessor(Builder builder) {
        this.campaignArn = ApiTypeHelper.requireNonNull(builder.campaignArn, this, "campaignArn");
        this.description = builder.description;
        this.iamRoleArn = builder.iamRoleArn;
        this.ignoreFailure = builder.ignoreFailure;
        this.itemIdField = builder.itemIdField;
        this.recipe = ApiTypeHelper.requireNonNull(builder.recipe, this, "recipe");
        this.tag = builder.tag;
        this.weight = ApiTypeHelper.requireNonNull(builder.weight, this, "weight");
    }

    public static PersonalizeSearchRankingResponseProcessor of(
        Function<PersonalizeSearchRankingResponseProcessor.Builder, ObjectBuilder<PersonalizeSearchRankingResponseProcessor>> fn
    ) {
        return fn.apply(new Builder()).build();
    }

    /**
     * {@link ResponseProcessor} variant kind.
     */
    @Override
    public ResponseProcessor.Kind _responseProcessorKind() {
        return ResponseProcessor.Kind.PersonalizeSearchRanking;
    }

    /**
     * Required - API name: {@code campaign_arn}
     */
    @Nonnull
    public final String campaignArn() {
        return this.campaignArn;
    }

    /**
     * API name: {@code description}
     */
    @Nullable
    public final String description() {
        return this.description;
    }

    /**
     * API name: {@code iam_role_arn}
     */
    @Nullable
    public final String iamRoleArn() {
        return this.iamRoleArn;
    }

    /**
     * API name: {@code ignore_failure}
     */
    @Nullable
    public final Boolean ignoreFailure() {
        return this.ignoreFailure;
    }

    /**
     * API name: {@code item_id_field}
     */
    @Nullable
    public final String itemIdField() {
        return this.itemIdField;
    }

    /**
     * Required - API name: {@code recipe}
     */
    @Nonnull
    public final String recipe() {
        return this.recipe;
    }

    /**
     * API name: {@code tag}
     */
    @Nullable
    public final String tag() {
        return this.tag;
    }

    /**
     * Required - API name: {@code weight}
     */
    public final float weight() {
        return this.weight;
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
        generator.writeKey("campaign_arn");
        generator.write(this.campaignArn);

        if (this.description != null) {
            generator.writeKey("description");
            generator.write(this.description);
        }

        if (this.iamRoleArn != null) {
            generator.writeKey("iam_role_arn");
            generator.write(this.iamRoleArn);
        }

        if (this.ignoreFailure != null) {
            generator.writeKey("ignore_failure");
            generator.write(this.ignoreFailure);
        }

        if (this.itemIdField != null) {
            generator.writeKey("item_id_field");
            generator.write(this.itemIdField);
        }

        generator.writeKey("recipe");
        generator.write(this.recipe);

        if (this.tag != null) {
            generator.writeKey("tag");
            generator.write(this.tag);
        }

        generator.writeKey("weight");
        generator.write(this.weight);
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
     * Builder for {@link PersonalizeSearchRankingResponseProcessor}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, PersonalizeSearchRankingResponseProcessor> {
        private String campaignArn;
        @Nullable
        private String description;
        @Nullable
        private String iamRoleArn;
        @Nullable
        private Boolean ignoreFailure;
        @Nullable
        private String itemIdField;
        private String recipe;
        @Nullable
        private String tag;
        private Float weight;

        public Builder() {}

        private Builder(PersonalizeSearchRankingResponseProcessor o) {
            this.campaignArn = o.campaignArn;
            this.description = o.description;
            this.iamRoleArn = o.iamRoleArn;
            this.ignoreFailure = o.ignoreFailure;
            this.itemIdField = o.itemIdField;
            this.recipe = o.recipe;
            this.tag = o.tag;
            this.weight = o.weight;
        }

        private Builder(Builder o) {
            this.campaignArn = o.campaignArn;
            this.description = o.description;
            this.iamRoleArn = o.iamRoleArn;
            this.ignoreFailure = o.ignoreFailure;
            this.itemIdField = o.itemIdField;
            this.recipe = o.recipe;
            this.tag = o.tag;
            this.weight = o.weight;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code campaign_arn}
         */
        @Nonnull
        public final Builder campaignArn(String value) {
            this.campaignArn = value;
            return this;
        }

        /**
         * API name: {@code description}
         */
        @Nonnull
        public final Builder description(@Nullable String value) {
            this.description = value;
            return this;
        }

        /**
         * API name: {@code iam_role_arn}
         */
        @Nonnull
        public final Builder iamRoleArn(@Nullable String value) {
            this.iamRoleArn = value;
            return this;
        }

        /**
         * API name: {@code ignore_failure}
         */
        @Nonnull
        public final Builder ignoreFailure(@Nullable Boolean value) {
            this.ignoreFailure = value;
            return this;
        }

        /**
         * API name: {@code item_id_field}
         */
        @Nonnull
        public final Builder itemIdField(@Nullable String value) {
            this.itemIdField = value;
            return this;
        }

        /**
         * Required - API name: {@code recipe}
         */
        @Nonnull
        public final Builder recipe(String value) {
            this.recipe = value;
            return this;
        }

        /**
         * API name: {@code tag}
         */
        @Nonnull
        public final Builder tag(@Nullable String value) {
            this.tag = value;
            return this;
        }

        /**
         * Required - API name: {@code weight}
         */
        @Nonnull
        public final Builder weight(float value) {
            this.weight = value;
            return this;
        }

        /**
         * Builds a {@link PersonalizeSearchRankingResponseProcessor}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PersonalizeSearchRankingResponseProcessor build() {
            _checkSingleUse();

            return new PersonalizeSearchRankingResponseProcessor(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PersonalizeSearchRankingResponseProcessor}
     */
    public static final JsonpDeserializer<PersonalizeSearchRankingResponseProcessor> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PersonalizeSearchRankingResponseProcessor::setupPersonalizeSearchRankingResponseProcessorDeserializer
    );

    protected static void setupPersonalizeSearchRankingResponseProcessorDeserializer(
        ObjectDeserializer<PersonalizeSearchRankingResponseProcessor.Builder> op
    ) {
        op.add(Builder::campaignArn, JsonpDeserializer.stringDeserializer(), "campaign_arn");
        op.add(Builder::description, JsonpDeserializer.stringDeserializer(), "description");
        op.add(Builder::iamRoleArn, JsonpDeserializer.stringDeserializer(), "iam_role_arn");
        op.add(Builder::ignoreFailure, JsonpDeserializer.booleanDeserializer(), "ignore_failure");
        op.add(Builder::itemIdField, JsonpDeserializer.stringDeserializer(), "item_id_field");
        op.add(Builder::recipe, JsonpDeserializer.stringDeserializer(), "recipe");
        op.add(Builder::tag, JsonpDeserializer.stringDeserializer(), "tag");
        op.add(Builder::weight, JsonpDeserializer.floatDeserializer(), "weight");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.campaignArn.hashCode();
        result = 31 * result + Objects.hashCode(this.description);
        result = 31 * result + Objects.hashCode(this.iamRoleArn);
        result = 31 * result + Objects.hashCode(this.ignoreFailure);
        result = 31 * result + Objects.hashCode(this.itemIdField);
        result = 31 * result + this.recipe.hashCode();
        result = 31 * result + Objects.hashCode(this.tag);
        result = 31 * result + Float.hashCode(this.weight);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PersonalizeSearchRankingResponseProcessor other = (PersonalizeSearchRankingResponseProcessor) o;
        return this.campaignArn.equals(other.campaignArn)
            && Objects.equals(this.description, other.description)
            && Objects.equals(this.iamRoleArn, other.iamRoleArn)
            && Objects.equals(this.ignoreFailure, other.ignoreFailure)
            && Objects.equals(this.itemIdField, other.itemIdField)
            && this.recipe.equals(other.recipe)
            && Objects.equals(this.tag, other.tag)
            && this.weight == other.weight;
    }
}
