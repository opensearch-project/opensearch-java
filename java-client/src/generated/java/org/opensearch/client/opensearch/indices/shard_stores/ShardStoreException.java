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

package org.opensearch.client.opensearch.indices.shard_stores;

import jakarta.json.stream.JsonGenerator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonData;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.opensearch._types.CircuitBreakerDurability;
import org.opensearch.client.opensearch._types.ErrorCause;
import org.opensearch.client.opensearch._types.ResponseLimitEntity;
import org.opensearch.client.opensearch._types.ScriptExceptionPosition;
import org.opensearch.client.opensearch._types.ShardSearchFailure;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.CopyableBuilder;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.ToCopyableBuilder;

// typedef: indices.shard_stores.ShardStoreException

/**
 * The exception raised when the node failed to open the shard's on-disk index.
 */
@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class ShardStoreException implements PlainJsonSerializable, ToCopyableBuilder<ShardStoreException.Builder, ShardStoreException> {

    @Nullable
    private final Long bytesLimit;

    @Nullable
    private final Long bytesWanted;

    @Nullable
    private final ErrorCause causedBy;

    @Nullable
    private final Integer col;

    @Nullable
    private final CircuitBreakerDurability durability;

    @Nonnull
    private final List<ShardSearchFailure> failedShards;

    @Nullable
    private final Boolean grouped;

    @Nonnull
    private final Map<String, List<String>> header;

    @Nullable
    private final String index;

    @Nullable
    private final String indexUuid;

    @Nullable
    private final String lang;

    @Nullable
    private final ResponseLimitEntity limitEntity;

    @Nullable
    private final Integer line;

    @Nullable
    private final Integer maxBuckets;

    @Nonnull
    private final Map<String, JsonData> metadata;

    @Nullable
    private final String nodeId;

    @Nullable
    private final String phase;

    @Nullable
    private final ScriptExceptionPosition position;

    @Nullable
    private final String processorTag;

    @Nullable
    private final String processorType;

    @Nullable
    private final String propertyName;

    @Nullable
    private final String reason;

    @Nonnull
    private final List<String> resourceId;

    @Nullable
    private final String resourceType;

    @Nullable
    private final Integer responseLimit;

    @Nonnull
    private final List<ErrorCause> rootCause;

    @Nullable
    private final String script;

    @Nonnull
    private final List<String> scriptStack;

    @Nullable
    private final String shard;

    @Nullable
    private final String stackTrace;

    @Nonnull
    private final List<ErrorCause> suppressed;

    @Nonnull
    private final String type;

    // ---------------------------------------------------------------------------------------------

    private ShardStoreException(Builder builder) {
        this.bytesLimit = builder.bytesLimit;
        this.bytesWanted = builder.bytesWanted;
        this.causedBy = builder.causedBy;
        this.col = builder.col;
        this.durability = builder.durability;
        this.failedShards = ApiTypeHelper.unmodifiable(builder.failedShards);
        this.grouped = builder.grouped;
        this.header = ApiTypeHelper.unmodifiable(builder.header);
        this.index = builder.index;
        this.indexUuid = builder.indexUuid;
        this.lang = builder.lang;
        this.limitEntity = builder.limitEntity;
        this.line = builder.line;
        this.maxBuckets = builder.maxBuckets;
        this.metadata = ApiTypeHelper.unmodifiable(builder.metadata);
        this.nodeId = builder.nodeId;
        this.phase = builder.phase;
        this.position = builder.position;
        this.processorTag = builder.processorTag;
        this.processorType = builder.processorType;
        this.propertyName = builder.propertyName;
        this.reason = builder.reason;
        this.resourceId = ApiTypeHelper.unmodifiable(builder.resourceId);
        this.resourceType = builder.resourceType;
        this.responseLimit = builder.responseLimit;
        this.rootCause = ApiTypeHelper.unmodifiable(builder.rootCause);
        this.script = builder.script;
        this.scriptStack = ApiTypeHelper.unmodifiable(builder.scriptStack);
        this.shard = builder.shard;
        this.stackTrace = builder.stackTrace;
        this.suppressed = ApiTypeHelper.unmodifiable(builder.suppressed);
        this.type = ApiTypeHelper.requireNonNull(builder.type, this, "type");
    }

    public static ShardStoreException of(Function<ShardStoreException.Builder, ObjectBuilder<ShardStoreException>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * The circuit breaker memory limit. Present in <code>circuit_breaking_exception</code> responses.
     * <p>
     * API name: {@code bytes_limit}
     * </p>
     */
    @Nullable
    public final Long bytesLimit() {
        return this.bytesLimit;
    }

    /**
     * The number of bytes that were requested. Present in <code>circuit_breaking_exception</code> responses.
     * <p>
     * API name: {@code bytes_wanted}
     * </p>
     */
    @Nullable
    public final Long bytesWanted() {
        return this.bytesWanted;
    }

    /**
     * API name: {@code caused_by}
     */
    @Nullable
    public final ErrorCause causedBy() {
        return this.causedBy;
    }

    /**
     * The column number of the parsing error. Present in <code>parsing_exception</code> and <code>search_parse_exception</code> responses.
     * <p>
     * API name: {@code col}
     * </p>
     */
    @Nullable
    public final Integer col() {
        return this.col;
    }

    /**
     * The circuit breaker durability. Present in <code>circuit_breaking_exception</code> responses.
     * <p>
     * API name: {@code durability}
     * </p>
     */
    @Nullable
    public final CircuitBreakerDurability durability() {
        return this.durability;
    }

    /**
     * The shard failures. Present in <code>search_phase_execution_exception</code> responses.
     * <p>
     * API name: {@code failed_shards}
     * </p>
     */
    @Nonnull
    public final List<ShardSearchFailure> failedShards() {
        return this.failedShards;
    }

    /**
     * Whether shard failures are grouped. Present in <code>search_phase_execution_exception</code> responses.
     * <p>
     * API name: {@code grouped}
     * </p>
     */
    @Nullable
    public final Boolean grouped() {
        return this.grouped;
    }

    /**
     * API name: {@code header}
     */
    @Nonnull
    public final Map<String, List<String>> header() {
        return this.header;
    }

    /**
     * The name of the index associated with the error. Present when the exception is associated with a specific index or shard.
     * <p>
     * API name: {@code index}
     * </p>
     */
    @Nullable
    public final String index() {
        return this.index;
    }

    /**
     * The UUID of the index associated with the error, or <code>_na_</code> when the UUID is unknown. Present when the exception is
     * associated with a specific index or shard.
     * <p>
     * API name: {@code index_uuid}
     * </p>
     */
    @Nullable
    public final String indexUuid() {
        return this.indexUuid;
    }

    /**
     * The scripting language. Present in <code>script_exception</code> responses.
     * <p>
     * API name: {@code lang}
     * </p>
     */
    @Nullable
    public final String lang() {
        return this.lang;
    }

    /**
     * The type of entity that breached the response limit. Present in <code>response_limit_breached_exception</code> responses.
     * <p>
     * API name: {@code limit_entity}
     * </p>
     */
    @Nullable
    public final ResponseLimitEntity limitEntity() {
        return this.limitEntity;
    }

    /**
     * The line number of the parsing error. Present in <code>parsing_exception</code> and <code>search_parse_exception</code> responses.
     * <p>
     * API name: {@code line}
     * </p>
     */
    @Nullable
    public final Integer line() {
        return this.line;
    }

    /**
     * The maximum number of buckets allowed. Present in <code>too_many_buckets_exception</code> responses.
     * <p>
     * API name: {@code max_buckets}
     * </p>
     */
    @Nullable
    public final Integer maxBuckets() {
        return this.maxBuckets;
    }

    /**
     * Any additional information about the error.
     */
    @Nonnull
    public final Map<String, JsonData> metadata() {
        return this.metadata;
    }

    /**
     * The node ID where the error occurred. Present in <code>failed_node_exception</code> responses.
     * <p>
     * API name: {@code node_id}
     * </p>
     */
    @Nullable
    public final String nodeId() {
        return this.nodeId;
    }

    /**
     * The search phase that failed. Present in <code>search_phase_execution_exception</code> responses.
     * <p>
     * API name: {@code phase}
     * </p>
     */
    @Nullable
    public final String phase() {
        return this.phase;
    }

    /**
     * The position of the error in the script. Present in <code>script_exception</code> responses.
     * <p>
     * API name: {@code position}
     * </p>
     */
    @Nullable
    public final ScriptExceptionPosition position() {
        return this.position;
    }

    /**
     * The tag of the processor whose configuration is invalid. Present in ingest or search pipeline configuration errors when the processor
     * has a tag.
     * <p>
     * API name: {@code processor_tag}
     * </p>
     */
    @Nullable
    public final String processorTag() {
        return this.processorTag;
    }

    /**
     * The type of the processor whose configuration is invalid, such as <code>set</code>. Present in ingest or search pipeline
     * configuration errors when known.
     * <p>
     * API name: {@code processor_type}
     * </p>
     */
    @Nullable
    public final String processorType() {
        return this.processorType;
    }

    /**
     * The name of the processor property that is missing or invalid. Present in ingest or search pipeline configuration errors when known.
     * <p>
     * API name: {@code property_name}
     * </p>
     */
    @Nullable
    public final String propertyName() {
        return this.propertyName;
    }

    /**
     * A human-readable explanation of the error, in English.
     * <p>
     * API name: {@code reason}
     * </p>
     */
    @Nullable
    public final String reason() {
        return this.reason;
    }

    /**
     * The identifiers of the resources associated with the error, such as the index expression that could not be resolved. A single
     * identifier is returned as a string. Present in <code>index_not_found_exception</code> and <code>aliases_not_found_exception</code>
     * responses.
     * <p>
     * API name: {@code resource.id}
     * </p>
     */
    @Nonnull
    public final List<String> resourceId() {
        return this.resourceId;
    }

    /**
     * The type of resource identified by <code>resource.id</code>, such as <code>index_or_alias</code>, <code>index_expression</code>, or
     * <code>aliases</code>. Present in <code>index_not_found_exception</code> and <code>aliases_not_found_exception</code> responses.
     * <p>
     * API name: {@code resource.type}
     * </p>
     */
    @Nullable
    public final String resourceType() {
        return this.resourceType;
    }

    /**
     * The response limit that was breached. Present in <code>response_limit_breached_exception</code> responses.
     * <p>
     * API name: {@code response_limit}
     * </p>
     */
    @Nullable
    public final Integer responseLimit() {
        return this.responseLimit;
    }

    /**
     * API name: {@code root_cause}
     */
    @Nonnull
    public final List<ErrorCause> rootCause() {
        return this.rootCause;
    }

    /**
     * The script that caused the error. Present in <code>script_exception</code> responses.
     * <p>
     * API name: {@code script}
     * </p>
     */
    @Nullable
    public final String script() {
        return this.script;
    }

    /**
     * The script stack trace. Present in <code>script_exception</code> responses.
     * <p>
     * API name: {@code script_stack}
     * </p>
     */
    @Nonnull
    public final List<String> scriptStack() {
        return this.scriptStack;
    }

    /**
     * The shard number associated with the error, serialized as a string. Present when the exception is associated with a specific shard.
     * <p>
     * API name: {@code shard}
     * </p>
     */
    @Nullable
    public final String shard() {
        return this.shard;
    }

    /**
     * The server stack trace, present only if the <code>error_trace=true</code> parameter was sent with the request.
     * <p>
     * API name: {@code stack_trace}
     * </p>
     */
    @Nullable
    public final String stackTrace() {
        return this.stackTrace;
    }

    /**
     * API name: {@code suppressed}
     */
    @Nonnull
    public final List<ErrorCause> suppressed() {
        return this.suppressed;
    }

    /**
     * Required - The type of error.
     * <p>
     * API name: {@code type}
     * </p>
     */
    @Nonnull
    public final String type() {
        return this.type;
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
        for (Map.Entry<String, JsonData> item0 : this.metadata.entrySet()) {
            generator.writeKey(item0.getKey());
            item0.getValue().serialize(generator, mapper);
        }
        if (this.bytesLimit != null) {
            generator.writeKey("bytes_limit");
            generator.write(this.bytesLimit);
        }

        if (this.bytesWanted != null) {
            generator.writeKey("bytes_wanted");
            generator.write(this.bytesWanted);
        }

        if (this.causedBy != null) {
            generator.writeKey("caused_by");
            this.causedBy.serialize(generator, mapper);
        }

        if (this.col != null) {
            generator.writeKey("col");
            generator.write(this.col);
        }

        if (this.durability != null) {
            generator.writeKey("durability");
            this.durability.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.failedShards)) {
            generator.writeKey("failed_shards");
            generator.writeStartArray();
            for (ShardSearchFailure item0 : this.failedShards) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.grouped != null) {
            generator.writeKey("grouped");
            generator.write(this.grouped);
        }

        if (ApiTypeHelper.isDefined(this.header)) {
            generator.writeKey("header");
            generator.writeStartObject();
            for (Map.Entry<String, List<String>> item0 : this.header.entrySet()) {
                generator.writeKey(item0.getKey());
                generator.writeStartArray();
                if (item0.getValue() != null) {
                    for (String item1 : item0.getValue()) {
                        generator.write(item1);
                    }
                }
                generator.writeEnd();
            }
            generator.writeEnd();
        }

        if (this.index != null) {
            generator.writeKey("index");
            generator.write(this.index);
        }

        if (this.indexUuid != null) {
            generator.writeKey("index_uuid");
            generator.write(this.indexUuid);
        }

        if (this.lang != null) {
            generator.writeKey("lang");
            generator.write(this.lang);
        }

        if (this.limitEntity != null) {
            generator.writeKey("limit_entity");
            this.limitEntity.serialize(generator, mapper);
        }

        if (this.line != null) {
            generator.writeKey("line");
            generator.write(this.line);
        }

        if (this.maxBuckets != null) {
            generator.writeKey("max_buckets");
            generator.write(this.maxBuckets);
        }

        if (this.nodeId != null) {
            generator.writeKey("node_id");
            generator.write(this.nodeId);
        }

        if (this.phase != null) {
            generator.writeKey("phase");
            generator.write(this.phase);
        }

        if (this.position != null) {
            generator.writeKey("position");
            this.position.serialize(generator, mapper);
        }

        if (this.processorTag != null) {
            generator.writeKey("processor_tag");
            generator.write(this.processorTag);
        }

        if (this.processorType != null) {
            generator.writeKey("processor_type");
            generator.write(this.processorType);
        }

        if (this.propertyName != null) {
            generator.writeKey("property_name");
            generator.write(this.propertyName);
        }

        if (this.reason != null) {
            generator.writeKey("reason");
            generator.write(this.reason);
        }

        if (ApiTypeHelper.isDefined(this.resourceId)) {
            generator.writeKey("resource.id");
            generator.writeStartArray();
            for (String item0 : this.resourceId) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.resourceType != null) {
            generator.writeKey("resource.type");
            generator.write(this.resourceType);
        }

        if (this.responseLimit != null) {
            generator.writeKey("response_limit");
            generator.write(this.responseLimit);
        }

        if (ApiTypeHelper.isDefined(this.rootCause)) {
            generator.writeKey("root_cause");
            generator.writeStartArray();
            for (ErrorCause item0 : this.rootCause) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.script != null) {
            generator.writeKey("script");
            generator.write(this.script);
        }

        if (ApiTypeHelper.isDefined(this.scriptStack)) {
            generator.writeKey("script_stack");
            generator.writeStartArray();
            for (String item0 : this.scriptStack) {
                generator.write(item0);
            }
            generator.writeEnd();
        }

        if (this.shard != null) {
            generator.writeKey("shard");
            generator.write(this.shard);
        }

        if (this.stackTrace != null) {
            generator.writeKey("stack_trace");
            generator.write(this.stackTrace);
        }

        if (ApiTypeHelper.isDefined(this.suppressed)) {
            generator.writeKey("suppressed");
            generator.writeStartArray();
            for (ErrorCause item0 : this.suppressed) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        generator.writeKey("type");
        generator.write(this.type);
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
     * Builder for {@link ShardStoreException}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, ShardStoreException> {
        @Nullable
        private Long bytesLimit;
        @Nullable
        private Long bytesWanted;
        @Nullable
        private ErrorCause causedBy;
        @Nullable
        private Integer col;
        @Nullable
        private CircuitBreakerDurability durability;
        @Nullable
        private List<ShardSearchFailure> failedShards;
        @Nullable
        private Boolean grouped;
        @Nullable
        private Map<String, List<String>> header;
        @Nullable
        private String index;
        @Nullable
        private String indexUuid;
        @Nullable
        private String lang;
        @Nullable
        private ResponseLimitEntity limitEntity;
        @Nullable
        private Integer line;
        @Nullable
        private Integer maxBuckets;
        @Nullable
        private Map<String, JsonData> metadata;
        @Nullable
        private String nodeId;
        @Nullable
        private String phase;
        @Nullable
        private ScriptExceptionPosition position;
        @Nullable
        private String processorTag;
        @Nullable
        private String processorType;
        @Nullable
        private String propertyName;
        @Nullable
        private String reason;
        @Nullable
        private List<String> resourceId;
        @Nullable
        private String resourceType;
        @Nullable
        private Integer responseLimit;
        @Nullable
        private List<ErrorCause> rootCause;
        @Nullable
        private String script;
        @Nullable
        private List<String> scriptStack;
        @Nullable
        private String shard;
        @Nullable
        private String stackTrace;
        @Nullable
        private List<ErrorCause> suppressed;
        private String type;

        public Builder() {}

        private Builder(ShardStoreException o) {
            this.bytesLimit = o.bytesLimit;
            this.bytesWanted = o.bytesWanted;
            this.causedBy = o.causedBy;
            this.col = o.col;
            this.durability = o.durability;
            this.failedShards = _listCopy(o.failedShards);
            this.grouped = o.grouped;
            this.header = _mapCopy(o.header);
            this.index = o.index;
            this.indexUuid = o.indexUuid;
            this.lang = o.lang;
            this.limitEntity = o.limitEntity;
            this.line = o.line;
            this.maxBuckets = o.maxBuckets;
            this.metadata = _mapCopy(o.metadata);
            this.nodeId = o.nodeId;
            this.phase = o.phase;
            this.position = o.position;
            this.processorTag = o.processorTag;
            this.processorType = o.processorType;
            this.propertyName = o.propertyName;
            this.reason = o.reason;
            this.resourceId = _listCopy(o.resourceId);
            this.resourceType = o.resourceType;
            this.responseLimit = o.responseLimit;
            this.rootCause = _listCopy(o.rootCause);
            this.script = o.script;
            this.scriptStack = _listCopy(o.scriptStack);
            this.shard = o.shard;
            this.stackTrace = o.stackTrace;
            this.suppressed = _listCopy(o.suppressed);
            this.type = o.type;
        }

        private Builder(Builder o) {
            this.bytesLimit = o.bytesLimit;
            this.bytesWanted = o.bytesWanted;
            this.causedBy = o.causedBy;
            this.col = o.col;
            this.durability = o.durability;
            this.failedShards = _listCopy(o.failedShards);
            this.grouped = o.grouped;
            this.header = _mapCopy(o.header);
            this.index = o.index;
            this.indexUuid = o.indexUuid;
            this.lang = o.lang;
            this.limitEntity = o.limitEntity;
            this.line = o.line;
            this.maxBuckets = o.maxBuckets;
            this.metadata = _mapCopy(o.metadata);
            this.nodeId = o.nodeId;
            this.phase = o.phase;
            this.position = o.position;
            this.processorTag = o.processorTag;
            this.processorType = o.processorType;
            this.propertyName = o.propertyName;
            this.reason = o.reason;
            this.resourceId = _listCopy(o.resourceId);
            this.resourceType = o.resourceType;
            this.responseLimit = o.responseLimit;
            this.rootCause = _listCopy(o.rootCause);
            this.script = o.script;
            this.scriptStack = _listCopy(o.scriptStack);
            this.shard = o.shard;
            this.stackTrace = o.stackTrace;
            this.suppressed = _listCopy(o.suppressed);
            this.type = o.type;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * The circuit breaker memory limit. Present in <code>circuit_breaking_exception</code> responses.
         * <p>
         * API name: {@code bytes_limit}
         * </p>
         */
        @Nonnull
        public final Builder bytesLimit(@Nullable Long value) {
            this.bytesLimit = value;
            return this;
        }

        /**
         * The number of bytes that were requested. Present in <code>circuit_breaking_exception</code> responses.
         * <p>
         * API name: {@code bytes_wanted}
         * </p>
         */
        @Nonnull
        public final Builder bytesWanted(@Nullable Long value) {
            this.bytesWanted = value;
            return this;
        }

        /**
         * API name: {@code caused_by}
         */
        @Nonnull
        public final Builder causedBy(@Nullable ErrorCause value) {
            this.causedBy = value;
            return this;
        }

        /**
         * API name: {@code caused_by}
         */
        @Nonnull
        public final Builder causedBy(Function<ErrorCause.Builder, ObjectBuilder<ErrorCause>> fn) {
            return causedBy(fn.apply(new ErrorCause.Builder()).build());
        }

        /**
         * The column number of the parsing error. Present in <code>parsing_exception</code> and <code>search_parse_exception</code>
         * responses.
         * <p>
         * API name: {@code col}
         * </p>
         */
        @Nonnull
        public final Builder col(@Nullable Integer value) {
            this.col = value;
            return this;
        }

        /**
         * The circuit breaker durability. Present in <code>circuit_breaking_exception</code> responses.
         * <p>
         * API name: {@code durability}
         * </p>
         */
        @Nonnull
        public final Builder durability(@Nullable CircuitBreakerDurability value) {
            this.durability = value;
            return this;
        }

        /**
         * The shard failures. Present in <code>search_phase_execution_exception</code> responses.
         * <p>
         * API name: {@code failed_shards}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>failedShards</code>.
         * </p>
         */
        @Nonnull
        public final Builder failedShards(List<ShardSearchFailure> list) {
            this.failedShards = _listAddAll(this.failedShards, list);
            return this;
        }

        /**
         * The shard failures. Present in <code>search_phase_execution_exception</code> responses.
         * <p>
         * API name: {@code failed_shards}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>failedShards</code>.
         * </p>
         */
        @Nonnull
        public final Builder failedShards(ShardSearchFailure value, ShardSearchFailure... values) {
            this.failedShards = _listAdd(this.failedShards, value, values);
            return this;
        }

        /**
         * The shard failures. Present in <code>search_phase_execution_exception</code> responses.
         * <p>
         * API name: {@code failed_shards}
         * </p>
         *
         * <p>
         * Adds a value to <code>failedShards</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder failedShards(Function<ShardSearchFailure.Builder, ObjectBuilder<ShardSearchFailure>> fn) {
            return failedShards(fn.apply(new ShardSearchFailure.Builder()).build());
        }

        /**
         * Whether shard failures are grouped. Present in <code>search_phase_execution_exception</code> responses.
         * <p>
         * API name: {@code grouped}
         * </p>
         */
        @Nonnull
        public final Builder grouped(@Nullable Boolean value) {
            this.grouped = value;
            return this;
        }

        /**
         * API name: {@code header}
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>header</code>.
         * </p>
         */
        @Nonnull
        public final Builder header(Map<String, List<String>> map) {
            this.header = _mapPutAll(this.header, map);
            return this;
        }

        /**
         * API name: {@code header}
         *
         * <p>
         * Adds an entry to <code>header</code>.
         * </p>
         */
        @Nonnull
        public final Builder header(String key, List<String> value) {
            this.header = _mapPut(this.header, key, value);
            return this;
        }

        /**
         * The name of the index associated with the error. Present when the exception is associated with a specific index or shard.
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
         * The UUID of the index associated with the error, or <code>_na_</code> when the UUID is unknown. Present when the exception is
         * associated with a specific index or shard.
         * <p>
         * API name: {@code index_uuid}
         * </p>
         */
        @Nonnull
        public final Builder indexUuid(@Nullable String value) {
            this.indexUuid = value;
            return this;
        }

        /**
         * The scripting language. Present in <code>script_exception</code> responses.
         * <p>
         * API name: {@code lang}
         * </p>
         */
        @Nonnull
        public final Builder lang(@Nullable String value) {
            this.lang = value;
            return this;
        }

        /**
         * The type of entity that breached the response limit. Present in <code>response_limit_breached_exception</code> responses.
         * <p>
         * API name: {@code limit_entity}
         * </p>
         */
        @Nonnull
        public final Builder limitEntity(@Nullable ResponseLimitEntity value) {
            this.limitEntity = value;
            return this;
        }

        /**
         * The line number of the parsing error. Present in <code>parsing_exception</code> and <code>search_parse_exception</code>
         * responses.
         * <p>
         * API name: {@code line}
         * </p>
         */
        @Nonnull
        public final Builder line(@Nullable Integer value) {
            this.line = value;
            return this;
        }

        /**
         * The maximum number of buckets allowed. Present in <code>too_many_buckets_exception</code> responses.
         * <p>
         * API name: {@code max_buckets}
         * </p>
         */
        @Nonnull
        public final Builder maxBuckets(@Nullable Integer value) {
            this.maxBuckets = value;
            return this;
        }

        /**
         * Any additional information about the error.
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>metadata</code>.
         * </p>
         */
        @Nonnull
        public final Builder metadata(Map<String, JsonData> map) {
            this.metadata = _mapPutAll(this.metadata, map);
            return this;
        }

        /**
         * Any additional information about the error.
         *
         * <p>
         * Adds an entry to <code>metadata</code>.
         * </p>
         */
        @Nonnull
        public final Builder metadata(String key, JsonData value) {
            this.metadata = _mapPut(this.metadata, key, value);
            return this;
        }

        /**
         * The node ID where the error occurred. Present in <code>failed_node_exception</code> responses.
         * <p>
         * API name: {@code node_id}
         * </p>
         */
        @Nonnull
        public final Builder nodeId(@Nullable String value) {
            this.nodeId = value;
            return this;
        }

        /**
         * The search phase that failed. Present in <code>search_phase_execution_exception</code> responses.
         * <p>
         * API name: {@code phase}
         * </p>
         */
        @Nonnull
        public final Builder phase(@Nullable String value) {
            this.phase = value;
            return this;
        }

        /**
         * The position of the error in the script. Present in <code>script_exception</code> responses.
         * <p>
         * API name: {@code position}
         * </p>
         */
        @Nonnull
        public final Builder position(@Nullable ScriptExceptionPosition value) {
            this.position = value;
            return this;
        }

        /**
         * The position of the error in the script. Present in <code>script_exception</code> responses.
         * <p>
         * API name: {@code position}
         * </p>
         */
        @Nonnull
        public final Builder position(Function<ScriptExceptionPosition.Builder, ObjectBuilder<ScriptExceptionPosition>> fn) {
            return position(fn.apply(new ScriptExceptionPosition.Builder()).build());
        }

        /**
         * The tag of the processor whose configuration is invalid. Present in ingest or search pipeline configuration errors when the
         * processor has a tag.
         * <p>
         * API name: {@code processor_tag}
         * </p>
         */
        @Nonnull
        public final Builder processorTag(@Nullable String value) {
            this.processorTag = value;
            return this;
        }

        /**
         * The type of the processor whose configuration is invalid, such as <code>set</code>. Present in ingest or search pipeline
         * configuration errors when known.
         * <p>
         * API name: {@code processor_type}
         * </p>
         */
        @Nonnull
        public final Builder processorType(@Nullable String value) {
            this.processorType = value;
            return this;
        }

        /**
         * The name of the processor property that is missing or invalid. Present in ingest or search pipeline configuration errors when
         * known.
         * <p>
         * API name: {@code property_name}
         * </p>
         */
        @Nonnull
        public final Builder propertyName(@Nullable String value) {
            this.propertyName = value;
            return this;
        }

        /**
         * A human-readable explanation of the error, in English.
         * <p>
         * API name: {@code reason}
         * </p>
         */
        @Nonnull
        public final Builder reason(@Nullable String value) {
            this.reason = value;
            return this;
        }

        /**
         * The identifiers of the resources associated with the error, such as the index expression that could not be resolved. A single
         * identifier is returned as a string. Present in <code>index_not_found_exception</code> and
         * <code>aliases_not_found_exception</code> responses.
         * <p>
         * API name: {@code resource.id}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>resourceId</code>.
         * </p>
         */
        @Nonnull
        public final Builder resourceId(List<String> list) {
            this.resourceId = _listAddAll(this.resourceId, list);
            return this;
        }

        /**
         * The identifiers of the resources associated with the error, such as the index expression that could not be resolved. A single
         * identifier is returned as a string. Present in <code>index_not_found_exception</code> and
         * <code>aliases_not_found_exception</code> responses.
         * <p>
         * API name: {@code resource.id}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>resourceId</code>.
         * </p>
         */
        @Nonnull
        public final Builder resourceId(String value, String... values) {
            this.resourceId = _listAdd(this.resourceId, value, values);
            return this;
        }

        /**
         * The type of resource identified by <code>resource.id</code>, such as <code>index_or_alias</code>, <code>index_expression</code>,
         * or <code>aliases</code>. Present in <code>index_not_found_exception</code> and <code>aliases_not_found_exception</code>
         * responses.
         * <p>
         * API name: {@code resource.type}
         * </p>
         */
        @Nonnull
        public final Builder resourceType(@Nullable String value) {
            this.resourceType = value;
            return this;
        }

        /**
         * The response limit that was breached. Present in <code>response_limit_breached_exception</code> responses.
         * <p>
         * API name: {@code response_limit}
         * </p>
         */
        @Nonnull
        public final Builder responseLimit(@Nullable Integer value) {
            this.responseLimit = value;
            return this;
        }

        /**
         * API name: {@code root_cause}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>rootCause</code>.
         * </p>
         */
        @Nonnull
        public final Builder rootCause(List<ErrorCause> list) {
            this.rootCause = _listAddAll(this.rootCause, list);
            return this;
        }

        /**
         * API name: {@code root_cause}
         *
         * <p>
         * Adds one or more values to <code>rootCause</code>.
         * </p>
         */
        @Nonnull
        public final Builder rootCause(ErrorCause value, ErrorCause... values) {
            this.rootCause = _listAdd(this.rootCause, value, values);
            return this;
        }

        /**
         * API name: {@code root_cause}
         *
         * <p>
         * Adds a value to <code>rootCause</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder rootCause(Function<ErrorCause.Builder, ObjectBuilder<ErrorCause>> fn) {
            return rootCause(fn.apply(new ErrorCause.Builder()).build());
        }

        /**
         * The script that caused the error. Present in <code>script_exception</code> responses.
         * <p>
         * API name: {@code script}
         * </p>
         */
        @Nonnull
        public final Builder script(@Nullable String value) {
            this.script = value;
            return this;
        }

        /**
         * The script stack trace. Present in <code>script_exception</code> responses.
         * <p>
         * API name: {@code script_stack}
         * </p>
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>scriptStack</code>.
         * </p>
         */
        @Nonnull
        public final Builder scriptStack(List<String> list) {
            this.scriptStack = _listAddAll(this.scriptStack, list);
            return this;
        }

        /**
         * The script stack trace. Present in <code>script_exception</code> responses.
         * <p>
         * API name: {@code script_stack}
         * </p>
         *
         * <p>
         * Adds one or more values to <code>scriptStack</code>.
         * </p>
         */
        @Nonnull
        public final Builder scriptStack(String value, String... values) {
            this.scriptStack = _listAdd(this.scriptStack, value, values);
            return this;
        }

        /**
         * The shard number associated with the error, serialized as a string. Present when the exception is associated with a specific
         * shard.
         * <p>
         * API name: {@code shard}
         * </p>
         */
        @Nonnull
        public final Builder shard(@Nullable String value) {
            this.shard = value;
            return this;
        }

        /**
         * The server stack trace, present only if the <code>error_trace=true</code> parameter was sent with the request.
         * <p>
         * API name: {@code stack_trace}
         * </p>
         */
        @Nonnull
        public final Builder stackTrace(@Nullable String value) {
            this.stackTrace = value;
            return this;
        }

        /**
         * API name: {@code suppressed}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>suppressed</code>.
         * </p>
         */
        @Nonnull
        public final Builder suppressed(List<ErrorCause> list) {
            this.suppressed = _listAddAll(this.suppressed, list);
            return this;
        }

        /**
         * API name: {@code suppressed}
         *
         * <p>
         * Adds one or more values to <code>suppressed</code>.
         * </p>
         */
        @Nonnull
        public final Builder suppressed(ErrorCause value, ErrorCause... values) {
            this.suppressed = _listAdd(this.suppressed, value, values);
            return this;
        }

        /**
         * API name: {@code suppressed}
         *
         * <p>
         * Adds a value to <code>suppressed</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder suppressed(Function<ErrorCause.Builder, ObjectBuilder<ErrorCause>> fn) {
            return suppressed(fn.apply(new ErrorCause.Builder()).build());
        }

        /**
         * Required - The type of error.
         * <p>
         * API name: {@code type}
         * </p>
         */
        @Nonnull
        public final Builder type(String value) {
            this.type = value;
            return this;
        }

        /**
         * Builds a {@link ShardStoreException}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public ShardStoreException build() {
            _checkSingleUse();

            return new ShardStoreException(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link ShardStoreException}
     */
    public static final JsonpDeserializer<ShardStoreException> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        ShardStoreException::setupShardStoreExceptionDeserializer
    );

    protected static void setupShardStoreExceptionDeserializer(ObjectDeserializer<ShardStoreException.Builder> op) {
        op.add(Builder::bytesLimit, JsonpDeserializer.longDeserializer(), "bytes_limit");
        op.add(Builder::bytesWanted, JsonpDeserializer.longDeserializer(), "bytes_wanted");
        op.add(Builder::causedBy, ErrorCause._DESERIALIZER, "caused_by");
        op.add(Builder::col, JsonpDeserializer.integerDeserializer(), "col");
        op.add(Builder::durability, CircuitBreakerDurability._DESERIALIZER, "durability");
        op.add(Builder::failedShards, JsonpDeserializer.arrayDeserializer(ShardSearchFailure._DESERIALIZER), "failed_shards");
        op.add(Builder::grouped, JsonpDeserializer.booleanDeserializer(), "grouped");
        op.add(
            Builder::header,
            JsonpDeserializer.stringMapDeserializer(JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer())),
            "header"
        );
        op.add(Builder::index, JsonpDeserializer.stringDeserializer(), "index");
        op.add(Builder::indexUuid, JsonpDeserializer.stringDeserializer(), "index_uuid");
        op.add(Builder::lang, JsonpDeserializer.stringDeserializer(), "lang");
        op.add(Builder::limitEntity, ResponseLimitEntity._DESERIALIZER, "limit_entity");
        op.add(Builder::line, JsonpDeserializer.integerDeserializer(), "line");
        op.add(Builder::maxBuckets, JsonpDeserializer.integerDeserializer(), "max_buckets");
        op.add(Builder::nodeId, JsonpDeserializer.stringDeserializer(), "node_id");
        op.add(Builder::phase, JsonpDeserializer.stringDeserializer(), "phase");
        op.add(Builder::position, ScriptExceptionPosition._DESERIALIZER, "position");
        op.add(Builder::processorTag, JsonpDeserializer.stringDeserializer(), "processor_tag");
        op.add(Builder::processorType, JsonpDeserializer.stringDeserializer(), "processor_type");
        op.add(Builder::propertyName, JsonpDeserializer.stringDeserializer(), "property_name");
        op.add(Builder::reason, JsonpDeserializer.stringDeserializer(), "reason");
        op.add(Builder::resourceId, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "resource.id");
        op.add(Builder::resourceType, JsonpDeserializer.stringDeserializer(), "resource.type");
        op.add(Builder::responseLimit, JsonpDeserializer.integerDeserializer(), "response_limit");
        op.add(Builder::rootCause, JsonpDeserializer.arrayDeserializer(ErrorCause._DESERIALIZER), "root_cause");
        op.add(Builder::script, JsonpDeserializer.stringDeserializer(), "script");
        op.add(Builder::scriptStack, JsonpDeserializer.arrayDeserializer(JsonpDeserializer.stringDeserializer()), "script_stack");
        op.add(Builder::shard, JsonpDeserializer.stringDeserializer(), "shard");
        op.add(Builder::stackTrace, JsonpDeserializer.stringDeserializer(), "stack_trace");
        op.add(Builder::suppressed, JsonpDeserializer.arrayDeserializer(ErrorCause._DESERIALIZER), "suppressed");
        op.add(Builder::type, JsonpDeserializer.stringDeserializer(), "type");
        op.setUnknownFieldHandler((builder, name, parser, mapper) -> {
            if (builder.metadata == null) {
                builder.metadata = new HashMap<>();
            }
            builder.metadata.put(name, JsonData._DESERIALIZER.deserialize(parser, mapper));
        });
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.bytesLimit);
        result = 31 * result + Objects.hashCode(this.bytesWanted);
        result = 31 * result + Objects.hashCode(this.causedBy);
        result = 31 * result + Objects.hashCode(this.col);
        result = 31 * result + Objects.hashCode(this.durability);
        result = 31 * result + Objects.hashCode(this.failedShards);
        result = 31 * result + Objects.hashCode(this.grouped);
        result = 31 * result + Objects.hashCode(this.header);
        result = 31 * result + Objects.hashCode(this.index);
        result = 31 * result + Objects.hashCode(this.indexUuid);
        result = 31 * result + Objects.hashCode(this.lang);
        result = 31 * result + Objects.hashCode(this.limitEntity);
        result = 31 * result + Objects.hashCode(this.line);
        result = 31 * result + Objects.hashCode(this.maxBuckets);
        result = 31 * result + Objects.hashCode(this.metadata);
        result = 31 * result + Objects.hashCode(this.nodeId);
        result = 31 * result + Objects.hashCode(this.phase);
        result = 31 * result + Objects.hashCode(this.position);
        result = 31 * result + Objects.hashCode(this.processorTag);
        result = 31 * result + Objects.hashCode(this.processorType);
        result = 31 * result + Objects.hashCode(this.propertyName);
        result = 31 * result + Objects.hashCode(this.reason);
        result = 31 * result + Objects.hashCode(this.resourceId);
        result = 31 * result + Objects.hashCode(this.resourceType);
        result = 31 * result + Objects.hashCode(this.responseLimit);
        result = 31 * result + Objects.hashCode(this.rootCause);
        result = 31 * result + Objects.hashCode(this.script);
        result = 31 * result + Objects.hashCode(this.scriptStack);
        result = 31 * result + Objects.hashCode(this.shard);
        result = 31 * result + Objects.hashCode(this.stackTrace);
        result = 31 * result + Objects.hashCode(this.suppressed);
        result = 31 * result + this.type.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        ShardStoreException other = (ShardStoreException) o;
        return Objects.equals(this.bytesLimit, other.bytesLimit)
            && Objects.equals(this.bytesWanted, other.bytesWanted)
            && Objects.equals(this.causedBy, other.causedBy)
            && Objects.equals(this.col, other.col)
            && Objects.equals(this.durability, other.durability)
            && Objects.equals(this.failedShards, other.failedShards)
            && Objects.equals(this.grouped, other.grouped)
            && Objects.equals(this.header, other.header)
            && Objects.equals(this.index, other.index)
            && Objects.equals(this.indexUuid, other.indexUuid)
            && Objects.equals(this.lang, other.lang)
            && Objects.equals(this.limitEntity, other.limitEntity)
            && Objects.equals(this.line, other.line)
            && Objects.equals(this.maxBuckets, other.maxBuckets)
            && Objects.equals(this.metadata, other.metadata)
            && Objects.equals(this.nodeId, other.nodeId)
            && Objects.equals(this.phase, other.phase)
            && Objects.equals(this.position, other.position)
            && Objects.equals(this.processorTag, other.processorTag)
            && Objects.equals(this.processorType, other.processorType)
            && Objects.equals(this.propertyName, other.propertyName)
            && Objects.equals(this.reason, other.reason)
            && Objects.equals(this.resourceId, other.resourceId)
            && Objects.equals(this.resourceType, other.resourceType)
            && Objects.equals(this.responseLimit, other.responseLimit)
            && Objects.equals(this.rootCause, other.rootCause)
            && Objects.equals(this.script, other.script)
            && Objects.equals(this.scriptStack, other.scriptStack)
            && Objects.equals(this.shard, other.shard)
            && Objects.equals(this.stackTrace, other.stackTrace)
            && Objects.equals(this.suppressed, other.suppressed)
            && this.type.equals(other.type);
    }
}
