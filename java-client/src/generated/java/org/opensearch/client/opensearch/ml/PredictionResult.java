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

// typedef: ml.PredictionResult

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class PredictionResult implements PlainJsonSerializable, ToCopyableBuilder<PredictionResult.Builder, PredictionResult> {

    @Nonnull
    private final List<ColumnMeta> columnMetas;

    @Nonnull
    private final List<Rows> rows;

    // ---------------------------------------------------------------------------------------------

    private PredictionResult(Builder builder) {
        this.columnMetas = ApiTypeHelper.unmodifiable(builder.columnMetas);
        this.rows = ApiTypeHelper.unmodifiable(builder.rows);
    }

    public static PredictionResult of(Function<PredictionResult.Builder, ObjectBuilder<PredictionResult>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * API name: {@code column_metas}
     */
    @Nonnull
    public final List<ColumnMeta> columnMetas() {
        return this.columnMetas;
    }

    /**
     * API name: {@code rows}
     */
    @Nonnull
    public final List<Rows> rows() {
        return this.rows;
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
        if (ApiTypeHelper.isDefined(this.columnMetas)) {
            generator.writeKey("column_metas");
            generator.writeStartArray();
            for (ColumnMeta item0 : this.columnMetas) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.rows)) {
            generator.writeKey("rows");
            generator.writeStartArray();
            for (Rows item0 : this.rows) {
                item0.serialize(generator, mapper);
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
     * Builder for {@link PredictionResult}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, PredictionResult> {
        @Nullable
        private List<ColumnMeta> columnMetas;
        @Nullable
        private List<Rows> rows;

        public Builder() {}

        private Builder(PredictionResult o) {
            this.columnMetas = _listCopy(o.columnMetas);
            this.rows = _listCopy(o.rows);
        }

        private Builder(Builder o) {
            this.columnMetas = _listCopy(o.columnMetas);
            this.rows = _listCopy(o.rows);
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * API name: {@code column_metas}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>columnMetas</code>.
         * </p>
         */
        @Nonnull
        public final Builder columnMetas(List<ColumnMeta> list) {
            this.columnMetas = _listAddAll(this.columnMetas, list);
            return this;
        }

        /**
         * API name: {@code column_metas}
         *
         * <p>
         * Adds one or more values to <code>columnMetas</code>.
         * </p>
         */
        @Nonnull
        public final Builder columnMetas(ColumnMeta value, ColumnMeta... values) {
            this.columnMetas = _listAdd(this.columnMetas, value, values);
            return this;
        }

        /**
         * API name: {@code column_metas}
         *
         * <p>
         * Adds a value to <code>columnMetas</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder columnMetas(Function<ColumnMeta.Builder, ObjectBuilder<ColumnMeta>> fn) {
            return columnMetas(fn.apply(new ColumnMeta.Builder()).build());
        }

        /**
         * API name: {@code rows}
         *
         * <p>
         * Adds all elements of <code>list</code> to <code>rows</code>.
         * </p>
         */
        @Nonnull
        public final Builder rows(List<Rows> list) {
            this.rows = _listAddAll(this.rows, list);
            return this;
        }

        /**
         * API name: {@code rows}
         *
         * <p>
         * Adds one or more values to <code>rows</code>.
         * </p>
         */
        @Nonnull
        public final Builder rows(Rows value, Rows... values) {
            this.rows = _listAdd(this.rows, value, values);
            return this;
        }

        /**
         * API name: {@code rows}
         *
         * <p>
         * Adds a value to <code>rows</code> using a builder lambda.
         * </p>
         */
        @Nonnull
        public final Builder rows(Function<Rows.Builder, ObjectBuilder<Rows>> fn) {
            return rows(fn.apply(new Rows.Builder()).build());
        }

        /**
         * Builds a {@link PredictionResult}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public PredictionResult build() {
            _checkSingleUse();

            return new PredictionResult(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link PredictionResult}
     */
    public static final JsonpDeserializer<PredictionResult> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        PredictionResult::setupPredictionResultDeserializer
    );

    protected static void setupPredictionResultDeserializer(ObjectDeserializer<PredictionResult.Builder> op) {
        op.add(Builder::columnMetas, JsonpDeserializer.arrayDeserializer(ColumnMeta._DESERIALIZER), "column_metas");
        op.add(Builder::rows, JsonpDeserializer.arrayDeserializer(Rows._DESERIALIZER), "rows");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Objects.hashCode(this.columnMetas);
        result = 31 * result + Objects.hashCode(this.rows);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        PredictionResult other = (PredictionResult) o;
        return Objects.equals(this.columnMetas, other.columnMetas) && Objects.equals(this.rows, other.rows);
    }
}
