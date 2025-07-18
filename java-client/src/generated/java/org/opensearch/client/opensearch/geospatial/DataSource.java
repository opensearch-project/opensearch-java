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

package org.opensearch.client.opensearch.geospatial;

import jakarta.json.stream.JsonGenerator;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
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

// typedef: geospatial.DataSource

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class DataSource implements PlainJsonSerializable, ToCopyableBuilder<DataSource.Builder, DataSource> {

    @Nonnull
    private final Database database;

    @Nonnull
    private final String endpoint;

    @Nonnull
    private final String name;

    private final long nextUpdateAtInEpochMillis;

    @Nonnull
    private final DataSourceState state;

    private final int updateIntervalInDays;

    @Nonnull
    private final UpdateStats updateStats;

    // ---------------------------------------------------------------------------------------------

    private DataSource(Builder builder) {
        this.database = ApiTypeHelper.requireNonNull(builder.database, this, "database");
        this.endpoint = ApiTypeHelper.requireNonNull(builder.endpoint, this, "endpoint");
        this.name = ApiTypeHelper.requireNonNull(builder.name, this, "name");
        this.nextUpdateAtInEpochMillis = ApiTypeHelper.requireNonNull(builder.nextUpdateAtInEpochMillis, this, "nextUpdateAtInEpochMillis");
        this.state = ApiTypeHelper.requireNonNull(builder.state, this, "state");
        this.updateIntervalInDays = ApiTypeHelper.requireNonNull(builder.updateIntervalInDays, this, "updateIntervalInDays");
        this.updateStats = ApiTypeHelper.requireNonNull(builder.updateStats, this, "updateStats");
    }

    public static DataSource of(Function<DataSource.Builder, ObjectBuilder<DataSource>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - API name: {@code database}
     */
    @Nonnull
    public final Database database() {
        return this.database;
    }

    /**
     * Required - URL endpoint for the data source.
     * <p>
     * API name: {@code endpoint}
     * </p>
     */
    @Nonnull
    public final String endpoint() {
        return this.endpoint;
    }

    /**
     * Required - API name: {@code name}
     */
    @Nonnull
    public final String name() {
        return this.name;
    }

    /**
     * Required - API name: {@code next_update_at_in_epoch_millis}
     */
    public final long nextUpdateAtInEpochMillis() {
        return this.nextUpdateAtInEpochMillis;
    }

    /**
     * Required - State of the data source.
     * <p>
     * API name: {@code state}
     * </p>
     */
    @Nonnull
    public final DataSourceState state() {
        return this.state;
    }

    /**
     * Required - Update interval.
     * <p>
     * API name: {@code update_interval_in_days}
     * </p>
     */
    public final int updateIntervalInDays() {
        return this.updateIntervalInDays;
    }

    /**
     * Required - API name: {@code update_stats}
     */
    @Nonnull
    public final UpdateStats updateStats() {
        return this.updateStats;
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
        generator.writeKey("database");
        this.database.serialize(generator, mapper);

        generator.writeKey("endpoint");
        generator.write(this.endpoint);

        generator.writeKey("name");
        generator.write(this.name);

        generator.writeKey("next_update_at_in_epoch_millis");
        generator.write(this.nextUpdateAtInEpochMillis);

        generator.writeKey("state");
        this.state.serialize(generator, mapper);

        generator.writeKey("update_interval_in_days");
        generator.write(this.updateIntervalInDays);

        generator.writeKey("update_stats");
        this.updateStats.serialize(generator, mapper);
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
     * Builder for {@link DataSource}.
     */
    public static class Builder extends ObjectBuilderBase implements CopyableBuilder<Builder, DataSource> {
        private Database database;
        private String endpoint;
        private String name;
        private Long nextUpdateAtInEpochMillis;
        private DataSourceState state;
        private Integer updateIntervalInDays;
        private UpdateStats updateStats;

        public Builder() {}

        private Builder(DataSource o) {
            this.database = o.database;
            this.endpoint = o.endpoint;
            this.name = o.name;
            this.nextUpdateAtInEpochMillis = o.nextUpdateAtInEpochMillis;
            this.state = o.state;
            this.updateIntervalInDays = o.updateIntervalInDays;
            this.updateStats = o.updateStats;
        }

        private Builder(Builder o) {
            this.database = o.database;
            this.endpoint = o.endpoint;
            this.name = o.name;
            this.nextUpdateAtInEpochMillis = o.nextUpdateAtInEpochMillis;
            this.state = o.state;
            this.updateIntervalInDays = o.updateIntervalInDays;
            this.updateStats = o.updateStats;
        }

        @Override
        @Nonnull
        public Builder copy() {
            return new Builder(this);
        }

        /**
         * Required - API name: {@code database}
         */
        @Nonnull
        public final Builder database(Database value) {
            this.database = value;
            return this;
        }

        /**
         * Required - API name: {@code database}
         */
        @Nonnull
        public final Builder database(Function<Database.Builder, ObjectBuilder<Database>> fn) {
            return database(fn.apply(new Database.Builder()).build());
        }

        /**
         * Required - URL endpoint for the data source.
         * <p>
         * API name: {@code endpoint}
         * </p>
         */
        @Nonnull
        public final Builder endpoint(String value) {
            this.endpoint = value;
            return this;
        }

        /**
         * Required - API name: {@code name}
         */
        @Nonnull
        public final Builder name(String value) {
            this.name = value;
            return this;
        }

        /**
         * Required - API name: {@code next_update_at_in_epoch_millis}
         */
        @Nonnull
        public final Builder nextUpdateAtInEpochMillis(long value) {
            this.nextUpdateAtInEpochMillis = value;
            return this;
        }

        /**
         * Required - State of the data source.
         * <p>
         * API name: {@code state}
         * </p>
         */
        @Nonnull
        public final Builder state(DataSourceState value) {
            this.state = value;
            return this;
        }

        /**
         * Required - Update interval.
         * <p>
         * API name: {@code update_interval_in_days}
         * </p>
         */
        @Nonnull
        public final Builder updateIntervalInDays(int value) {
            this.updateIntervalInDays = value;
            return this;
        }

        /**
         * Required - API name: {@code update_stats}
         */
        @Nonnull
        public final Builder updateStats(UpdateStats value) {
            this.updateStats = value;
            return this;
        }

        /**
         * Required - API name: {@code update_stats}
         */
        @Nonnull
        public final Builder updateStats(Function<UpdateStats.Builder, ObjectBuilder<UpdateStats>> fn) {
            return updateStats(fn.apply(new UpdateStats.Builder()).build());
        }

        /**
         * Builds a {@link DataSource}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        @Override
        @Nonnull
        public DataSource build() {
            _checkSingleUse();

            return new DataSource(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link DataSource}
     */
    public static final JsonpDeserializer<DataSource> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        DataSource::setupDataSourceDeserializer
    );

    protected static void setupDataSourceDeserializer(ObjectDeserializer<DataSource.Builder> op) {
        op.add(Builder::database, Database._DESERIALIZER, "database");
        op.add(Builder::endpoint, JsonpDeserializer.stringDeserializer(), "endpoint");
        op.add(Builder::name, JsonpDeserializer.stringDeserializer(), "name");
        op.add(Builder::nextUpdateAtInEpochMillis, JsonpDeserializer.longDeserializer(), "next_update_at_in_epoch_millis");
        op.add(Builder::state, DataSourceState._DESERIALIZER, "state");
        op.add(Builder::updateIntervalInDays, JsonpDeserializer.integerDeserializer(), "update_interval_in_days");
        op.add(Builder::updateStats, UpdateStats._DESERIALIZER, "update_stats");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.database.hashCode();
        result = 31 * result + this.endpoint.hashCode();
        result = 31 * result + this.name.hashCode();
        result = 31 * result + Long.hashCode(this.nextUpdateAtInEpochMillis);
        result = 31 * result + this.state.hashCode();
        result = 31 * result + Integer.hashCode(this.updateIntervalInDays);
        result = 31 * result + this.updateStats.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        DataSource other = (DataSource) o;
        return this.database.equals(other.database)
            && this.endpoint.equals(other.endpoint)
            && this.name.equals(other.name)
            && this.nextUpdateAtInEpochMillis == other.nextUpdateAtInEpochMillis
            && this.state.equals(other.state)
            && this.updateIntervalInDays == other.updateIntervalInDays
            && this.updateStats.equals(other.updateStats);
    }
}
