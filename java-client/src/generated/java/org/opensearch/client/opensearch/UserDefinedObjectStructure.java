package org.opensearch.client.opensearch;

import org.opensearch.client.opensearch._types.*;
import org.opensearch.client.json.*;
import org.opensearch.client.transport.*;
import org.opensearch.client.transport.endpoints.*;
import org.opensearch.client.util.*;
import jakarta.json.stream.JsonGenerator;
import java.util.*;
import java.util.function.Function;
import javax.annotation.*;

@JsonpDeserializable
public class UserDefinedObjectStructure implements JsonpSerializable {
    private final JsonData bool;
    private final JsonData boosting;
    private final JsonData combinedFields;
    private final JsonData constantScore;
    private final JsonData disMax;
    private final JsonData distanceFeature;
    private final JsonData exists;
    private final JsonData fieldMaskingSpan;
    private final JsonData functionScore;
    private final Map<String, JsonData> fuzzy;
    private final JsonData geoBoundingBox;
    private final JsonData geoDistance;
    private final JsonData geoPolygon;
    private final JsonData geoShape;
    private final JsonData hasChild;
    private final JsonData hasParent;
    private final JsonData ids;
    private final Map<String, JsonData> intervals;
    private final JsonData knn;
    private final Map<String, JsonData> match;
    private final JsonData matchAll;
    private final Map<String, JsonData> matchBoolPrefix;
    private final JsonData matchNone;
    private final Map<String, JsonData> matchPhrase;
    private final Map<String, JsonData> matchPhrasePrefix;
    private final JsonData moreLikeThis;
    private final JsonData multiMatch;
    private final JsonData nested;
    private final JsonData parentId;
    private final JsonData percolate;
    private final JsonData pinned;
    private final Map<String, JsonData> prefix;
    private final JsonData queryString;
    private final Map<String, JsonData> range;
    private final JsonData rankFeature;
    private final Map<String, JsonData> regexp;
    private final JsonData script;
    private final JsonData scriptScore;
    private final JsonData shape;
    private final JsonData simpleQueryString;
    private final JsonData spanContaining;
    private final JsonData spanFirst;
    private final JsonData spanMulti;
    private final JsonData spanNear;
    private final JsonData spanNot;
    private final JsonData spanOr;
    private final Map<String, JsonData> spanTerm;
    private final JsonData spanWithin;
    private final Map<String, JsonData> term;
    private final JsonData terms;
    private final Map<String, JsonData> termsSet;
    private final Map<String, JsonData> wildcard;
    private final JsonData wrapper;

    public UserDefinedObjectStructure(Builder builder) {
        this.bool = builder.bool;
        this.boosting = builder.boosting;
        this.combinedFields = builder.combinedFields;
        this.constantScore = builder.constantScore;
        this.disMax = builder.disMax;
        this.distanceFeature = builder.distanceFeature;
        this.exists = builder.exists;
        this.fieldMaskingSpan = builder.fieldMaskingSpan;
        this.functionScore = builder.functionScore;
        this.fuzzy = ApiTypeHelper.unmodifiable(builder.fuzzy);
        this.geoBoundingBox = builder.geoBoundingBox;
        this.geoDistance = builder.geoDistance;
        this.geoPolygon = builder.geoPolygon;
        this.geoShape = builder.geoShape;
        this.hasChild = builder.hasChild;
        this.hasParent = builder.hasParent;
        this.ids = builder.ids;
        this.intervals = ApiTypeHelper.unmodifiable(builder.intervals);
        this.knn = builder.knn;
        this.match = ApiTypeHelper.unmodifiable(builder.match);
        this.matchAll = builder.matchAll;
        this.matchBoolPrefix = ApiTypeHelper.unmodifiable(builder.matchBoolPrefix);
        this.matchNone = builder.matchNone;
        this.matchPhrase = ApiTypeHelper.unmodifiable(builder.matchPhrase);
        this.matchPhrasePrefix = ApiTypeHelper.unmodifiable(builder.matchPhrasePrefix);
        this.moreLikeThis = builder.moreLikeThis;
        this.multiMatch = builder.multiMatch;
        this.nested = builder.nested;
        this.parentId = builder.parentId;
        this.percolate = builder.percolate;
        this.pinned = builder.pinned;
        this.prefix = ApiTypeHelper.unmodifiable(builder.prefix);
        this.queryString = builder.queryString;
        this.range = ApiTypeHelper.unmodifiable(builder.range);
        this.rankFeature = builder.rankFeature;
        this.regexp = ApiTypeHelper.unmodifiable(builder.regexp);
        this.script = builder.script;
        this.scriptScore = builder.scriptScore;
        this.shape = builder.shape;
        this.simpleQueryString = builder.simpleQueryString;
        this.spanContaining = builder.spanContaining;
        this.spanFirst = builder.spanFirst;
        this.spanMulti = builder.spanMulti;
        this.spanNear = builder.spanNear;
        this.spanNot = builder.spanNot;
        this.spanOr = builder.spanOr;
        this.spanTerm = ApiTypeHelper.unmodifiable(builder.spanTerm);
        this.spanWithin = builder.spanWithin;
        this.term = ApiTypeHelper.unmodifiable(builder.term);
        this.terms = builder.terms;
        this.termsSet = ApiTypeHelper.unmodifiable(builder.termsSet);
        this.wildcard = ApiTypeHelper.unmodifiable(builder.wildcard);
        this.wrapper = builder.wrapper;
    }

    public static UserDefinedObjectStructure of(
            Function<Builder, ObjectBuilder<UserDefinedObjectStructure>> fn) {
        return fn.apply(new Builder()).build();
    }

    public final JsonData bool() {
        return this.bool;
    }

    public final JsonData boosting() {
        return this.boosting;
    }

    public final JsonData combinedFields() {
        return this.combinedFields;
    }

    public final JsonData constantScore() {
        return this.constantScore;
    }

    public final JsonData disMax() {
        return this.disMax;
    }

    public final JsonData distanceFeature() {
        return this.distanceFeature;
    }

    public final JsonData exists() {
        return this.exists;
    }

    public final JsonData fieldMaskingSpan() {
        return this.fieldMaskingSpan;
    }

    public final JsonData functionScore() {
        return this.functionScore;
    }

    public final Map<String, JsonData> fuzzy() {
        return this.fuzzy;
    }

    public final JsonData geoBoundingBox() {
        return this.geoBoundingBox;
    }

    public final JsonData geoDistance() {
        return this.geoDistance;
    }

    public final JsonData geoPolygon() {
        return this.geoPolygon;
    }

    public final JsonData geoShape() {
        return this.geoShape;
    }

    public final JsonData hasChild() {
        return this.hasChild;
    }

    public final JsonData hasParent() {
        return this.hasParent;
    }

    public final JsonData ids() {
        return this.ids;
    }

    public final Map<String, JsonData> intervals() {
        return this.intervals;
    }

    public final JsonData knn() {
        return this.knn;
    }

    public final Map<String, JsonData> match() {
        return this.match;
    }

    public final JsonData matchAll() {
        return this.matchAll;
    }

    public final Map<String, JsonData> matchBoolPrefix() {
        return this.matchBoolPrefix;
    }

    public final JsonData matchNone() {
        return this.matchNone;
    }

    public final Map<String, JsonData> matchPhrase() {
        return this.matchPhrase;
    }

    public final Map<String, JsonData> matchPhrasePrefix() {
        return this.matchPhrasePrefix;
    }

    public final JsonData moreLikeThis() {
        return this.moreLikeThis;
    }

    public final JsonData multiMatch() {
        return this.multiMatch;
    }

    public final JsonData nested() {
        return this.nested;
    }

    public final JsonData parentId() {
        return this.parentId;
    }

    public final JsonData percolate() {
        return this.percolate;
    }

    public final JsonData pinned() {
        return this.pinned;
    }

    public final Map<String, JsonData> prefix() {
        return this.prefix;
    }

    public final JsonData queryString() {
        return this.queryString;
    }

    public final Map<String, JsonData> range() {
        return this.range;
    }

    public final JsonData rankFeature() {
        return this.rankFeature;
    }

    public final Map<String, JsonData> regexp() {
        return this.regexp;
    }

    public final JsonData script() {
        return this.script;
    }

    public final JsonData scriptScore() {
        return this.scriptScore;
    }

    public final JsonData shape() {
        return this.shape;
    }

    public final JsonData simpleQueryString() {
        return this.simpleQueryString;
    }

    public final JsonData spanContaining() {
        return this.spanContaining;
    }

    public final JsonData spanFirst() {
        return this.spanFirst;
    }

    public final JsonData spanMulti() {
        return this.spanMulti;
    }

    public final JsonData spanNear() {
        return this.spanNear;
    }

    public final JsonData spanNot() {
        return this.spanNot;
    }

    public final JsonData spanOr() {
        return this.spanOr;
    }

    public final Map<String, JsonData> spanTerm() {
        return this.spanTerm;
    }

    public final JsonData spanWithin() {
        return this.spanWithin;
    }

    public final Map<String, JsonData> term() {
        return this.term;
    }

    public final JsonData terms() {
        return this.terms;
    }

    public final Map<String, JsonData> termsSet() {
        return this.termsSet;
    }

    public final Map<String, JsonData> wildcard() {
        return this.wildcard;
    }

    public final JsonData wrapper() {
        return this.wrapper;
    }

    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        if (this.bool != null) {
            generator.writeKey("bool");
            this.bool.serialize(generator, mapper);
        }

        if (this.boosting != null) {
            generator.writeKey("boosting");
            this.boosting.serialize(generator, mapper);
        }

        if (this.combinedFields != null) {
            generator.writeKey("combined_fields");
            this.combinedFields.serialize(generator, mapper);
        }

        if (this.constantScore != null) {
            generator.writeKey("constant_score");
            this.constantScore.serialize(generator, mapper);
        }

        if (this.disMax != null) {
            generator.writeKey("dis_max");
            this.disMax.serialize(generator, mapper);
        }

        if (this.distanceFeature != null) {
            generator.writeKey("distance_feature");
            this.distanceFeature.serialize(generator, mapper);
        }

        if (this.exists != null) {
            generator.writeKey("exists");
            this.exists.serialize(generator, mapper);
        }

        if (this.fieldMaskingSpan != null) {
            generator.writeKey("field_masking_span");
            this.fieldMaskingSpan.serialize(generator, mapper);
        }

        if (this.functionScore != null) {
            generator.writeKey("function_score");
            this.functionScore.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.fuzzy)) {
            generator.writeKey("fuzzy");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.fuzzy.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.geoBoundingBox != null) {
            generator.writeKey("geo_bounding_box");
            this.geoBoundingBox.serialize(generator, mapper);
        }

        if (this.geoDistance != null) {
            generator.writeKey("geo_distance");
            this.geoDistance.serialize(generator, mapper);
        }

        if (this.geoPolygon != null) {
            generator.writeKey("geo_polygon");
            this.geoPolygon.serialize(generator, mapper);
        }

        if (this.geoShape != null) {
            generator.writeKey("geo_shape");
            this.geoShape.serialize(generator, mapper);
        }

        if (this.hasChild != null) {
            generator.writeKey("has_child");
            this.hasChild.serialize(generator, mapper);
        }

        if (this.hasParent != null) {
            generator.writeKey("has_parent");
            this.hasParent.serialize(generator, mapper);
        }

        if (this.ids != null) {
            generator.writeKey("ids");
            this.ids.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.intervals)) {
            generator.writeKey("intervals");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.intervals.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.knn != null) {
            generator.writeKey("knn");
            this.knn.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.match)) {
            generator.writeKey("match");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.match.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.matchAll != null) {
            generator.writeKey("match_all");
            this.matchAll.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.matchBoolPrefix)) {
            generator.writeKey("match_bool_prefix");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.matchBoolPrefix.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.matchNone != null) {
            generator.writeKey("match_none");
            this.matchNone.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.matchPhrase)) {
            generator.writeKey("match_phrase");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.matchPhrase.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.matchPhrasePrefix)) {
            generator.writeKey("match_phrase_prefix");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.matchPhrasePrefix.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.moreLikeThis != null) {
            generator.writeKey("more_like_this");
            this.moreLikeThis.serialize(generator, mapper);
        }

        if (this.multiMatch != null) {
            generator.writeKey("multi_match");
            this.multiMatch.serialize(generator, mapper);
        }

        if (this.nested != null) {
            generator.writeKey("nested");
            this.nested.serialize(generator, mapper);
        }

        if (this.parentId != null) {
            generator.writeKey("parent_id");
            this.parentId.serialize(generator, mapper);
        }

        if (this.percolate != null) {
            generator.writeKey("percolate");
            this.percolate.serialize(generator, mapper);
        }

        if (this.pinned != null) {
            generator.writeKey("pinned");
            this.pinned.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.prefix)) {
            generator.writeKey("prefix");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.prefix.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.queryString != null) {
            generator.writeKey("query_string");
            this.queryString.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.range)) {
            generator.writeKey("range");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.range.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.rankFeature != null) {
            generator.writeKey("rank_feature");
            this.rankFeature.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.regexp)) {
            generator.writeKey("regexp");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.regexp.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.script != null) {
            generator.writeKey("script");
            this.script.serialize(generator, mapper);
        }

        if (this.scriptScore != null) {
            generator.writeKey("script_score");
            this.scriptScore.serialize(generator, mapper);
        }

        if (this.shape != null) {
            generator.writeKey("shape");
            this.shape.serialize(generator, mapper);
        }

        if (this.simpleQueryString != null) {
            generator.writeKey("simple_query_string");
            this.simpleQueryString.serialize(generator, mapper);
        }

        if (this.spanContaining != null) {
            generator.writeKey("span_containing");
            this.spanContaining.serialize(generator, mapper);
        }

        if (this.spanFirst != null) {
            generator.writeKey("span_first");
            this.spanFirst.serialize(generator, mapper);
        }

        if (this.spanMulti != null) {
            generator.writeKey("span_multi");
            this.spanMulti.serialize(generator, mapper);
        }

        if (this.spanNear != null) {
            generator.writeKey("span_near");
            this.spanNear.serialize(generator, mapper);
        }

        if (this.spanNot != null) {
            generator.writeKey("span_not");
            this.spanNot.serialize(generator, mapper);
        }

        if (this.spanOr != null) {
            generator.writeKey("span_or");
            this.spanOr.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.spanTerm)) {
            generator.writeKey("span_term");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.spanTerm.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.spanWithin != null) {
            generator.writeKey("span_within");
            this.spanWithin.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.term)) {
            generator.writeKey("term");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.term.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.terms != null) {
            generator.writeKey("terms");
            this.terms.serialize(generator, mapper);
        }

        if (ApiTypeHelper.isDefined(this.termsSet)) {
            generator.writeKey("terms_set");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.termsSet.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (ApiTypeHelper.isDefined(this.wildcard)) {
            generator.writeKey("wildcard");
            generator.writeStartObject();
            for (Map.Entry<String, JsonData> item0 : this.wildcard.entrySet()) {
                generator.writeKey(item0.getKey());
                item0.getValue().serialize(generator, mapper);
            }
            generator.writeEnd();
        }

        if (this.wrapper != null) {
            generator.writeKey("wrapper");
            this.wrapper.serialize(generator, mapper);
        }
    }

    /** Builder for {@link UserDefinedObjectStructure}. */
    public static class Builder extends ObjectBuilderBase
            implements ObjectBuilder<UserDefinedObjectStructure> {
        private JsonData bool;
        private JsonData boosting;
        private JsonData combinedFields;
        private JsonData constantScore;
        private JsonData disMax;
        private JsonData distanceFeature;
        private JsonData exists;
        private JsonData fieldMaskingSpan;
        private JsonData functionScore;
        private Map<String, JsonData> fuzzy;
        private JsonData geoBoundingBox;
        private JsonData geoDistance;
        private JsonData geoPolygon;
        private JsonData geoShape;
        private JsonData hasChild;
        private JsonData hasParent;
        private JsonData ids;
        private Map<String, JsonData> intervals;
        private JsonData knn;
        private Map<String, JsonData> match;
        private JsonData matchAll;
        private Map<String, JsonData> matchBoolPrefix;
        private JsonData matchNone;
        private Map<String, JsonData> matchPhrase;
        private Map<String, JsonData> matchPhrasePrefix;
        private JsonData moreLikeThis;
        private JsonData multiMatch;
        private JsonData nested;
        private JsonData parentId;
        private JsonData percolate;
        private JsonData pinned;
        private Map<String, JsonData> prefix;
        private JsonData queryString;
        private Map<String, JsonData> range;
        private JsonData rankFeature;
        private Map<String, JsonData> regexp;
        private JsonData script;
        private JsonData scriptScore;
        private JsonData shape;
        private JsonData simpleQueryString;
        private JsonData spanContaining;
        private JsonData spanFirst;
        private JsonData spanMulti;
        private JsonData spanNear;
        private JsonData spanNot;
        private JsonData spanOr;
        private Map<String, JsonData> spanTerm;
        private JsonData spanWithin;
        private Map<String, JsonData> term;
        private JsonData terms;
        private Map<String, JsonData> termsSet;
        private Map<String, JsonData> wildcard;
        private JsonData wrapper;

        public final Builder bool(JsonData value) {
            this.bool = value;
            return this;
        }

        public final Builder boosting(JsonData value) {
            this.boosting = value;
            return this;
        }

        public final Builder combinedFields(JsonData value) {
            this.combinedFields = value;
            return this;
        }

        public final Builder constantScore(JsonData value) {
            this.constantScore = value;
            return this;
        }

        public final Builder disMax(JsonData value) {
            this.disMax = value;
            return this;
        }

        public final Builder distanceFeature(JsonData value) {
            this.distanceFeature = value;
            return this;
        }

        public final Builder exists(JsonData value) {
            this.exists = value;
            return this;
        }

        public final Builder fieldMaskingSpan(JsonData value) {
            this.fieldMaskingSpan = value;
            return this;
        }

        public final Builder functionScore(JsonData value) {
            this.functionScore = value;
            return this;
        }

        public final Builder fuzzy(Map<String, JsonData> map) {
            this.fuzzy = _mapPutAll(this.fuzzy, map);
            return this;
        }

        public final Builder fuzzy(String key, JsonData value) {
            this.fuzzy = _mapPut(this.fuzzy, key, value);
            return this;
        }

        public final Builder geoBoundingBox(JsonData value) {
            this.geoBoundingBox = value;
            return this;
        }

        public final Builder geoDistance(JsonData value) {
            this.geoDistance = value;
            return this;
        }

        public final Builder geoPolygon(JsonData value) {
            this.geoPolygon = value;
            return this;
        }

        public final Builder geoShape(JsonData value) {
            this.geoShape = value;
            return this;
        }

        public final Builder hasChild(JsonData value) {
            this.hasChild = value;
            return this;
        }

        public final Builder hasParent(JsonData value) {
            this.hasParent = value;
            return this;
        }

        public final Builder ids(JsonData value) {
            this.ids = value;
            return this;
        }

        public final Builder intervals(Map<String, JsonData> map) {
            this.intervals = _mapPutAll(this.intervals, map);
            return this;
        }

        public final Builder intervals(String key, JsonData value) {
            this.intervals = _mapPut(this.intervals, key, value);
            return this;
        }

        public final Builder knn(JsonData value) {
            this.knn = value;
            return this;
        }

        public final Builder match(Map<String, JsonData> map) {
            this.match = _mapPutAll(this.match, map);
            return this;
        }

        public final Builder match(String key, JsonData value) {
            this.match = _mapPut(this.match, key, value);
            return this;
        }

        public final Builder matchAll(JsonData value) {
            this.matchAll = value;
            return this;
        }

        public final Builder matchBoolPrefix(Map<String, JsonData> map) {
            this.matchBoolPrefix = _mapPutAll(this.matchBoolPrefix, map);
            return this;
        }

        public final Builder matchBoolPrefix(String key, JsonData value) {
            this.matchBoolPrefix = _mapPut(this.matchBoolPrefix, key, value);
            return this;
        }

        public final Builder matchNone(JsonData value) {
            this.matchNone = value;
            return this;
        }

        public final Builder matchPhrase(Map<String, JsonData> map) {
            this.matchPhrase = _mapPutAll(this.matchPhrase, map);
            return this;
        }

        public final Builder matchPhrase(String key, JsonData value) {
            this.matchPhrase = _mapPut(this.matchPhrase, key, value);
            return this;
        }

        public final Builder matchPhrasePrefix(Map<String, JsonData> map) {
            this.matchPhrasePrefix = _mapPutAll(this.matchPhrasePrefix, map);
            return this;
        }

        public final Builder matchPhrasePrefix(String key, JsonData value) {
            this.matchPhrasePrefix = _mapPut(this.matchPhrasePrefix, key, value);
            return this;
        }

        public final Builder moreLikeThis(JsonData value) {
            this.moreLikeThis = value;
            return this;
        }

        public final Builder multiMatch(JsonData value) {
            this.multiMatch = value;
            return this;
        }

        public final Builder nested(JsonData value) {
            this.nested = value;
            return this;
        }

        public final Builder parentId(JsonData value) {
            this.parentId = value;
            return this;
        }

        public final Builder percolate(JsonData value) {
            this.percolate = value;
            return this;
        }

        public final Builder pinned(JsonData value) {
            this.pinned = value;
            return this;
        }

        public final Builder prefix(Map<String, JsonData> map) {
            this.prefix = _mapPutAll(this.prefix, map);
            return this;
        }

        public final Builder prefix(String key, JsonData value) {
            this.prefix = _mapPut(this.prefix, key, value);
            return this;
        }

        public final Builder queryString(JsonData value) {
            this.queryString = value;
            return this;
        }

        public final Builder range(Map<String, JsonData> map) {
            this.range = _mapPutAll(this.range, map);
            return this;
        }

        public final Builder range(String key, JsonData value) {
            this.range = _mapPut(this.range, key, value);
            return this;
        }

        public final Builder rankFeature(JsonData value) {
            this.rankFeature = value;
            return this;
        }

        public final Builder regexp(Map<String, JsonData> map) {
            this.regexp = _mapPutAll(this.regexp, map);
            return this;
        }

        public final Builder regexp(String key, JsonData value) {
            this.regexp = _mapPut(this.regexp, key, value);
            return this;
        }

        public final Builder script(JsonData value) {
            this.script = value;
            return this;
        }

        public final Builder scriptScore(JsonData value) {
            this.scriptScore = value;
            return this;
        }

        public final Builder shape(JsonData value) {
            this.shape = value;
            return this;
        }

        public final Builder simpleQueryString(JsonData value) {
            this.simpleQueryString = value;
            return this;
        }

        public final Builder spanContaining(JsonData value) {
            this.spanContaining = value;
            return this;
        }

        public final Builder spanFirst(JsonData value) {
            this.spanFirst = value;
            return this;
        }

        public final Builder spanMulti(JsonData value) {
            this.spanMulti = value;
            return this;
        }

        public final Builder spanNear(JsonData value) {
            this.spanNear = value;
            return this;
        }

        public final Builder spanNot(JsonData value) {
            this.spanNot = value;
            return this;
        }

        public final Builder spanOr(JsonData value) {
            this.spanOr = value;
            return this;
        }

        public final Builder spanTerm(Map<String, JsonData> map) {
            this.spanTerm = _mapPutAll(this.spanTerm, map);
            return this;
        }

        public final Builder spanTerm(String key, JsonData value) {
            this.spanTerm = _mapPut(this.spanTerm, key, value);
            return this;
        }

        public final Builder spanWithin(JsonData value) {
            this.spanWithin = value;
            return this;
        }

        public final Builder term(Map<String, JsonData> map) {
            this.term = _mapPutAll(this.term, map);
            return this;
        }

        public final Builder term(String key, JsonData value) {
            this.term = _mapPut(this.term, key, value);
            return this;
        }

        public final Builder terms(JsonData value) {
            this.terms = value;
            return this;
        }

        public final Builder termsSet(Map<String, JsonData> map) {
            this.termsSet = _mapPutAll(this.termsSet, map);
            return this;
        }

        public final Builder termsSet(String key, JsonData value) {
            this.termsSet = _mapPut(this.termsSet, key, value);
            return this;
        }

        public final Builder wildcard(Map<String, JsonData> map) {
            this.wildcard = _mapPutAll(this.wildcard, map);
            return this;
        }

        public final Builder wildcard(String key, JsonData value) {
            this.wildcard = _mapPut(this.wildcard, key, value);
            return this;
        }

        public final Builder wrapper(JsonData value) {
            this.wrapper = value;
            return this;
        }

        /**
         * Builds a {@link UserDefinedObjectStructure}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public UserDefinedObjectStructure build() {
            _checkSingleUse();

            return new UserDefinedObjectStructure(this);
        }
    }

    public static final JsonpDeserializer<UserDefinedObjectStructure> _DESERIALIZER =
            ObjectBuilderDeserializer.lazy(
                    Builder::new,
                    UserDefinedObjectStructure::setupUserDefinedObjectStructureDeserializer);

    protected static void setupUserDefinedObjectStructureDeserializer(
            ObjectDeserializer<UserDefinedObjectStructure.Builder> op) {
        op.add(Builder::bool, JsonData._DESERIALIZER, "bool");
        op.add(Builder::boosting, JsonData._DESERIALIZER, "boosting");
        op.add(Builder::combinedFields, JsonData._DESERIALIZER, "combined_fields");
        op.add(Builder::constantScore, JsonData._DESERIALIZER, "constant_score");
        op.add(Builder::disMax, JsonData._DESERIALIZER, "dis_max");
        op.add(Builder::distanceFeature, JsonData._DESERIALIZER, "distance_feature");
        op.add(Builder::exists, JsonData._DESERIALIZER, "exists");
        op.add(Builder::fieldMaskingSpan, JsonData._DESERIALIZER, "field_masking_span");
        op.add(Builder::functionScore, JsonData._DESERIALIZER, "function_score");
        op.add(
                Builder::fuzzy,
                JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER),
                "fuzzy");
        op.add(Builder::geoBoundingBox, JsonData._DESERIALIZER, "geo_bounding_box");
        op.add(Builder::geoDistance, JsonData._DESERIALIZER, "geo_distance");
        op.add(Builder::geoPolygon, JsonData._DESERIALIZER, "geo_polygon");
        op.add(Builder::geoShape, JsonData._DESERIALIZER, "geo_shape");
        op.add(Builder::hasChild, JsonData._DESERIALIZER, "has_child");
        op.add(Builder::hasParent, JsonData._DESERIALIZER, "has_parent");
        op.add(Builder::ids, JsonData._DESERIALIZER, "ids");
        op.add(
                Builder::intervals,
                JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER),
                "intervals");
        op.add(Builder::knn, JsonData._DESERIALIZER, "knn");
        op.add(
                Builder::match,
                JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER),
                "match");
        op.add(Builder::matchAll, JsonData._DESERIALIZER, "match_all");
        op.add(
                Builder::matchBoolPrefix,
                JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER),
                "match_bool_prefix");
        op.add(Builder::matchNone, JsonData._DESERIALIZER, "match_none");
        op.add(
                Builder::matchPhrase,
                JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER),
                "match_phrase");
        op.add(
                Builder::matchPhrasePrefix,
                JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER),
                "match_phrase_prefix");
        op.add(Builder::moreLikeThis, JsonData._DESERIALIZER, "more_like_this");
        op.add(Builder::multiMatch, JsonData._DESERIALIZER, "multi_match");
        op.add(Builder::nested, JsonData._DESERIALIZER, "nested");
        op.add(Builder::parentId, JsonData._DESERIALIZER, "parent_id");
        op.add(Builder::percolate, JsonData._DESERIALIZER, "percolate");
        op.add(Builder::pinned, JsonData._DESERIALIZER, "pinned");
        op.add(
                Builder::prefix,
                JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER),
                "prefix");
        op.add(Builder::queryString, JsonData._DESERIALIZER, "query_string");
        op.add(
                Builder::range,
                JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER),
                "range");
        op.add(Builder::rankFeature, JsonData._DESERIALIZER, "rank_feature");
        op.add(
                Builder::regexp,
                JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER),
                "regexp");
        op.add(Builder::script, JsonData._DESERIALIZER, "script");
        op.add(Builder::scriptScore, JsonData._DESERIALIZER, "script_score");
        op.add(Builder::shape, JsonData._DESERIALIZER, "shape");
        op.add(Builder::simpleQueryString, JsonData._DESERIALIZER, "simple_query_string");
        op.add(Builder::spanContaining, JsonData._DESERIALIZER, "span_containing");
        op.add(Builder::spanFirst, JsonData._DESERIALIZER, "span_first");
        op.add(Builder::spanMulti, JsonData._DESERIALIZER, "span_multi");
        op.add(Builder::spanNear, JsonData._DESERIALIZER, "span_near");
        op.add(Builder::spanNot, JsonData._DESERIALIZER, "span_not");
        op.add(Builder::spanOr, JsonData._DESERIALIZER, "span_or");
        op.add(
                Builder::spanTerm,
                JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER),
                "span_term");
        op.add(Builder::spanWithin, JsonData._DESERIALIZER, "span_within");
        op.add(
                Builder::term,
                JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER),
                "term");
        op.add(Builder::terms, JsonData._DESERIALIZER, "terms");
        op.add(
                Builder::termsSet,
                JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER),
                "terms_set");
        op.add(
                Builder::wildcard,
                JsonpDeserializer.stringMapDeserializer(JsonData._DESERIALIZER),
                "wildcard");
        op.add(Builder::wrapper, JsonData._DESERIALIZER, "wrapper");
    }
}
