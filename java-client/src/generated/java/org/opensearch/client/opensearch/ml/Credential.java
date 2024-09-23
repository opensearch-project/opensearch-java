/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

//----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------

package org.opensearch.client.opensearch.ml;

import jakarta.json.stream.JsonGenerator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import org.opensearch.client.json.JsonData;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: ml.Credential

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class Credential implements PlainJsonSerializable {

    @Nullable
    private final String accessKey;

    @Nullable
    private final String secretKey;

    @Nullable
    private final String sessionToken;

    private final Map<String, JsonData> metadata;

    // ---------------------------------------------------------------------------------------------

    private Credential(Builder builder) {
        this.accessKey = builder.accessKey;
        this.secretKey = builder.secretKey;
        this.sessionToken = builder.sessionToken;
        this.metadata = ApiTypeHelper.unmodifiable(builder.metadata);
    }

    public static Credential of(Function<Credential.Builder, ObjectBuilder<Credential>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code access_key}
     */
    @Nullable
    public final String accessKey() {
        return this.accessKey;
    }

    /**
     * API name: {@code secret_key}
     */
    @Nullable
    public final String secretKey() {
        return this.secretKey;
    }

    /**
     * API name: {@code session_token}
     */
    @Nullable
    public final String sessionToken() {
        return this.sessionToken;
    }

    /**
                                    */
    public final Map<String, JsonData> metadata() {
        return this.metadata;
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
        if (this.accessKey != null) {
            generator.writeKey("access_key");
            generator.write(this.accessKey);
        }

        if (this.secretKey != null) {
            generator.writeKey("secret_key");
            generator.write(this.secretKey);
        }

        if (this.sessionToken != null) {
            generator.writeKey("session_token");
            generator.write(this.sessionToken);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link Credential}.
     */
    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<Credential> {
        @Nullable
        private String accessKey;
        @Nullable
        private String secretKey;
        @Nullable
        private String sessionToken;
        @Nullable
        private Map<String, JsonData> metadata;

        /**
         * API name: {@code access_key}
         */
        public final Builder accessKey(@Nullable String value) {
            this.accessKey = value;
            return this;
        }

        /**
         * API name: {@code secret_key}
         */
        public final Builder secretKey(@Nullable String value) {
            this.secretKey = value;
            return this;
        }

        /**
         * API name: {@code session_token}
         */
        public final Builder sessionToken(@Nullable String value) {
            this.sessionToken = value;
            return this;
        }

        /**
         *
         * <p>
         * Adds all elements of <code>map</code> to <code>metadata</code>.
         * </p>
         */
        public final Builder metadata(Map<String, JsonData> map) {
            this.metadata = _mapPutAll(this.metadata, map);
            return this;
        }

        /**
         *
         * <p>
         * Adds an entry to <code>metadata</code>.
         * </p>
         */
        public final Builder metadata(String key, JsonData value) {
            this.metadata = _mapPut(this.metadata, key, value);
            return this;
        }

        /**
         * Builds a {@link Credential}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public Credential build() {
            _checkSingleUse();

            return new Credential(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link Credential}
     */
    public static final JsonpDeserializer<Credential> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        Credential::setupCredentialDeserializer
    );

    protected static void setupCredentialDeserializer(ObjectDeserializer<Credential.Builder> op) {
        op.add(Builder::accessKey, JsonpDeserializer.stringDeserializer(), "access_key");
        op.add(Builder::secretKey, JsonpDeserializer.stringDeserializer(), "secret_key");
        op.add(Builder::sessionToken, JsonpDeserializer.stringDeserializer(), "session_token");
        op.setUnknownFieldHandler((builder, name, parser, mapper) -> {
            if (builder.metadata == null) {
                builder.metadata = new HashMap<>();
            }
            builder.metadata.put(name, JsonData._DESERIALIZER.deserialize(parser, mapper));
        });
    }

    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.accessKey);
        result = 31 * result + Objects.hashCode(this.secretKey);
        result = 31 * result + Objects.hashCode(this.sessionToken);
        result = 31 * result + Objects.hashCode(this.metadata);
        return result;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (this.getClass() != o.getClass()) return false;
        Credential other = (Credential) o;
        return Objects.equals(this.accessKey, other.accessKey)
            && Objects.equals(this.secretKey, other.secretKey)
            && Objects.equals(this.sessionToken, other.sessionToken)
            && Objects.equals(this.metadata, other.metadata);
    }
}
