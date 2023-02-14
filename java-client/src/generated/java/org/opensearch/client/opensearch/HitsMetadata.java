package org.opensearch.client.opensearch;

import org.opensearch.client.json.*;
import org.opensearch.client.util.*;
import jakarta.json.stream.JsonGenerator;
import java.util.*;
import java.util.function.Function;
import javax.annotation.*;

@JsonpDeserializable
public class HitsMetadata implements JsonpSerializable {

    @Nullable private final List<Hits> hits;

    @Nullable private final Double maxScore;

    @Nullable private final Total total;

    public HitsMetadata(Builder builder) {
        this.hits = ApiTypeHelper.unmodifiable(builder.hits);
        this.maxScore = builder.maxScore;
        this.total = builder.total;
    }

    public static HitsMetadata of(Function<Builder, ObjectBuilder<HitsMetadata>> fn) {
        return fn.apply(new Builder()).build();
    }

    public final List<Hits> hits() {
        return this.hits;
    }

    public final Double maxScore() {
        return this.maxScore;
    }

    public final Total total() {
        return this.total;
    }

    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        if (ApiTypeHelper.isDefined(this.hits)) {
            generator.writeKey("hits");
            generator.writeStartArray();
            for (Hits item0 : this.hits) {
                item0.serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.maxScore != null) {
            generator.writeKey("max_score");
            generator.write(this.maxScore);
        }

        if (this.total != null) {
            generator.writeKey("total");
            this.total.serialize(generator, mapper);
        }
    }

    /** Builder for {@link HitsMetadata}. */
    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<HitsMetadata> {
        private List<Hits> hits;
        private Double maxScore;
        private Total total;

        public final Builder hits(List<Hits> list) {
            this.hits = _listAddAll(this.hits, list);
            return this;
        }

        public final Builder hits(Hits value, Hits... values) {
            this.hits = _listAdd(this.hits, value, values);
            return this;
        }

        public final Builder hits(Function<Hits.Builder, ObjectBuilder<Hits>> fn) {
            return hits(fn.apply(new Hits.Builder()).build());
        }

        public final Builder maxScore(Double value) {
            this.maxScore = value;
            return this;
        }

        public final Builder total(Total value) {
            this.total = value;
            return this;
        }

        public final Builder total(Function<Total.Builder, ObjectBuilder<Total>> fn) {
            return total(fn.apply(new Total.Builder()).build());
        }

        /**
         * Builds a {@link HitsMetadata}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public HitsMetadata build() {
            _checkSingleUse();

            return new HitsMetadata(this);
        }
    }

    public static final JsonpDeserializer<HitsMetadata> _DESERIALIZER =
            ObjectBuilderDeserializer.lazy(
                    Builder::new, HitsMetadata::setupHitsMetadataDeserializer);

    protected static void setupHitsMetadataDeserializer(
            ObjectDeserializer<HitsMetadata.Builder> op) {
        op.add(Builder::hits, JsonpDeserializer.arrayDeserializer(Hits._DESERIALIZER), "hits");
        op.add(Builder::maxScore, JsonpDeserializer.doubleDeserializer(), "max_score");
        op.add(Builder::total, Total._DESERIALIZER, "total");
    }
}
