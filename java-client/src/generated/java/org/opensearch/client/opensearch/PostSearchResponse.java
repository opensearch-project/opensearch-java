package org.opensearch.client.opensearch;

import org.opensearch.client.json.*;
import org.opensearch.client.util.*;
import jakarta.json.stream.JsonGenerator;
import java.util.*;
import java.util.function.Function;
import javax.annotation.*;

@JsonpDeserializable
public class PostSearchResponse implements JsonpSerializable {
    @Nullable private final String scrollId;
    @Nullable private final ShardStatistics shards;
    @Nullable private final HitsMetadata hits;
    @Nullable private final Boolean timedOut;
    @Nullable private final Long took;

    public PostSearchResponse(Builder builder) {
        this.scrollId = builder.scrollId;
        this.shards = builder.shards;
        this.hits = builder.hits;
        this.timedOut = builder.timedOut;
        this.took = builder.took;
    }

    public static PostSearchResponse of(Function<Builder, ObjectBuilder<PostSearchResponse>> fn) {
        return fn.apply(new Builder()).build();
    }

    public final String scrollId() {
        return this.scrollId;
    }

    public final ShardStatistics shards() {
        return this.shards;
    }

    public final HitsMetadata hits() {
        return this.hits;
    }

    public final Boolean timedOut() {
        return this.timedOut;
    }

    public final Long took() {
        return this.took;
    }

    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        if (this.scrollId != null) {
            generator.writeKey("_scroll_id");
            generator.write(this.scrollId);
        }

        if (this.shards != null) {
            generator.writeKey("_shards");
            this.shards.serialize(generator, mapper);
        }

        if (this.hits != null) {
            generator.writeKey("hits");
            this.hits.serialize(generator, mapper);
        }

        if (this.timedOut != null) {
            generator.writeKey("timed_out");
            generator.write(this.timedOut);
        }

        if (this.took != null) {
            generator.writeKey("took");
            generator.write(this.took);
        }
    }

    /** Builder for {@link PostSearchResponse}. */
    public static class Builder extends ObjectBuilderBase
            implements ObjectBuilder<PostSearchResponse> {
        private String scrollId;
        private ShardStatistics shards;
        private HitsMetadata hits;
        private Boolean timedOut;
        private Long took;

        public final Builder scrollId(String value) {
            this.scrollId = value;
            return this;
        }

        public final Builder shards(ShardStatistics value) {
            this.shards = value;
            return this;
        }

        public final Builder shards(
                Function<ShardStatistics.Builder, ObjectBuilder<ShardStatistics>> fn) {
            return shards(fn.apply(new ShardStatistics.Builder()).build());
        }

        public final Builder hits(HitsMetadata value) {
            this.hits = value;
            return this;
        }

        public final Builder hits(Function<HitsMetadata.Builder, ObjectBuilder<HitsMetadata>> fn) {
            return hits(fn.apply(new HitsMetadata.Builder()).build());
        }

        public final Builder timedOut(Boolean value) {
            this.timedOut = value;
            return this;
        }

        public final Builder took(Long value) {
            this.took = value;
            return this;
        }

        /**
         * Builds a {@link PostSearchResponse}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public PostSearchResponse build() {
            _checkSingleUse();

            return new PostSearchResponse(this);
        }
    }

    public static final JsonpDeserializer<PostSearchResponse> _DESERIALIZER =
            ObjectBuilderDeserializer.lazy(
                    Builder::new, PostSearchResponse::setupPostSearchResponseDeserializer);

    protected static void setupPostSearchResponseDeserializer(
            ObjectDeserializer<PostSearchResponse.Builder> op) {
        op.add(Builder::scrollId, JsonpDeserializer.stringDeserializer(), "_scroll_id");
        op.add(Builder::shards, ShardStatistics._DESERIALIZER, "_shards");
        op.add(Builder::hits, HitsMetadata._DESERIALIZER, "hits");
        op.add(Builder::timedOut, JsonpDeserializer.booleanDeserializer(), "timed_out");
        op.add(Builder::took, JsonpDeserializer.longDeserializer(), "took");
    }
}
