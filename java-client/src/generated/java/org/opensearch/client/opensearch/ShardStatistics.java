package org.opensearch.client.opensearch;

import org.opensearch.client.json.*;
import org.opensearch.client.util.*;
import jakarta.json.stream.JsonGenerator;
import java.util.*;
import java.util.function.Function;
import javax.annotation.*;

@JsonpDeserializable
public class ShardStatistics implements JsonpSerializable {
    @Nullable private final Integer failed;
    @Nullable private final Integer skipped;
    @Nullable private final Integer successful;
    @Nullable private final Integer total;

    public ShardStatistics(Builder builder) {
        this.failed = builder.failed;
        this.skipped = builder.skipped;
        this.successful = builder.successful;
        this.total = builder.total;
    }

    public static ShardStatistics of(Function<Builder, ObjectBuilder<ShardStatistics>> fn) {
        return fn.apply(new Builder()).build();
    }

    public final Integer failed() {
        return this.failed;
    }

    public final Integer skipped() {
        return this.skipped;
    }

    public final Integer successful() {
        return this.successful;
    }

    public final Integer total() {
        return this.total;
    }

    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        if (this.failed != null) {
            generator.writeKey("failed");
            generator.write(this.failed);
        }

        if (this.skipped != null) {
            generator.writeKey("skipped");
            generator.write(this.skipped);
        }

        if (this.successful != null) {
            generator.writeKey("successful");
            generator.write(this.successful);
        }

        if (this.total != null) {
            generator.writeKey("total");
            generator.write(this.total);
        }
    }

    /** Builder for {@link ShardStatistics}. */
    public static class Builder extends ObjectBuilderBase
            implements ObjectBuilder<ShardStatistics> {
        private Integer failed;
        private Integer skipped;
        private Integer successful;
        private Integer total;

        public final Builder failed(Integer value) {
            this.failed = value;
            return this;
        }

        public final Builder skipped(Integer value) {
            this.skipped = value;
            return this;
        }

        public final Builder successful(Integer value) {
            this.successful = value;
            return this;
        }

        public final Builder total(Integer value) {
            this.total = value;
            return this;
        }

        /**
         * Builds a {@link ShardStatistics}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public ShardStatistics build() {
            _checkSingleUse();

            return new ShardStatistics(this);
        }
    }

    public static final JsonpDeserializer<ShardStatistics> _DESERIALIZER =
            ObjectBuilderDeserializer.lazy(
                    Builder::new, ShardStatistics::setupShardStatisticsDeserializer);

    protected static void setupShardStatisticsDeserializer(
            ObjectDeserializer<ShardStatistics.Builder> op) {
        op.add(Builder::failed, JsonpDeserializer.integerDeserializer(), "failed");
        op.add(Builder::skipped, JsonpDeserializer.integerDeserializer(), "skipped");
        op.add(Builder::successful, JsonpDeserializer.integerDeserializer(), "successful");
        op.add(Builder::total, JsonpDeserializer.integerDeserializer(), "total");
    }
}
