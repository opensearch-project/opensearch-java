package org.opensearch.client.opensearch._types.query_dsl;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class FunctionScoreQueryTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        FunctionScoreQuery origin = new FunctionScoreQuery.Builder().build();
        FunctionScoreQuery copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }

    @Test
    public void canSupportWeightFunction() {
        Query functionScoreQuery = FunctionScoreQuery.of(fs -> fs.functions(f -> f.weight(5d)))._toQuery();

        String json = "{\"function_score\":{\"functions\":[{\"weight\":5.0}]}}";

        assertEquals(json, toJson(functionScoreQuery));

        Query roundtripQuery = checkJsonRoundtrip(functionScoreQuery, json);

        assertNull(roundtripQuery.functionScore().functions().get(0)._kind());
        assertEquals(5.0, roundtripQuery.functionScore().functions().get(0).weight(), 0.001);
    }

    @Test
    public void canSupportFunctionVariant() {
        Query functionScoreQuery = FunctionScoreQuery.of(
            fs -> fs.functions(f -> f.weight(3d).linear(l -> l.field("field").placement(p -> p.decay(8.0))))
        )._toQuery();

        String json = "{\"function_score\":{\"functions\":[{\"weight\":3.0,\"linear\":{\"field\":{\"decay\":8.0}}}]}}";

        assertEquals(json, toJson(functionScoreQuery));

        Query roundtripQuery = checkJsonRoundtrip(functionScoreQuery, json);

        assertEquals(FunctionScore.Kind.Linear, roundtripQuery.functionScore().functions().get(0)._kind());
        assertEquals(3.0, roundtripQuery.functionScore().functions().get(0).weight(), 0.001);
        assertEquals(8.0, roundtripQuery.functionScore().functions().get(0).linear().placement().decay(), 0.001);
    }
}
