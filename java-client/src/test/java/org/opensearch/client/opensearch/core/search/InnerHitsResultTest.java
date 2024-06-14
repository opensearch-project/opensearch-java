/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.core.search;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.StringReader;
import org.junit.Test;
import org.opensearch.client.json.JsonData;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.jsonb.JsonbJsonpMapper;

public class InnerHitsResultTest {
    private final JsonpMapper mapper = new JsonbJsonpMapper();
    private final String storedSalary = "details.salary";
    private final String storedJobId = "details.jobId";

    /**
     * test if the InnerHitsResult will build the Hit<JsonData>
     */
    @Test
    public void testInnerHits() {

        String classString = String.valueOf(hitResultWithIdIndex.innerHits().get("test_child").getClass());
        assertEquals(classString, InnerHitsResult.class.toString());
        // take hitResult and get the InnerHit
        InnerHitsResult innerHitsResult = hitResultWithIdIndex.innerHits().get("test_child");
        Hit<JsonData> innerHitResult = innerHitsResult.hits().hits().get(0);
        assertNotNull(innerHitResult.index());
        assertEquals(innerHitResult.index(), "_index");
        assertNotNull(innerHitResult.id());
        assertEquals(innerHitResult.id(), "child_id");
    }

    /**
     * test if the InnerHitsResult will still build the Hit<JsonData> even if id and index is not specified
     */
    @Test
    public void testInnerHitWithoutIdIndex() {

        String classString = String.valueOf(hitResultNoIdIndex.innerHits().get("test_child").getClass());
        assertEquals(classString, InnerHitsResult.class.toString());
        // take hitResult and get the InnerHit
        InnerHitsResult innerHitsResult = hitResultNoIdIndex.innerHits().get("test_child");
        Hit<JsonData> innerHitResult = innerHitsResult.hits().hits().get(0);
        // Id and index are now nullable.
        assertNull(innerHitResult.index());
        assertNull(innerHitResult.id());
    }

    private final String innerHitJsonWithNoIdOrIndex = "{\"key\":\"value\"}";
    private final String innerHitJsonWithIdOrIndex = "{\"id\":\"value\",\"index\":\"value\"}";

    private final Hit<JsonData> hitResultNoIdIndex = Hit.of(
        it -> it.id("test_parent")
            .index("_index")
            .innerHits(
                "test_child",
                innerHitsResultBuilder -> innerHitsResultBuilder.hits(
                    innerHitsMetadataBuilder -> innerHitsMetadataBuilder.total(total -> total.value(1).relation(TotalHitsRelation.Eq))
                        .hits(
                            innerHitsListMemberBuilder -> innerHitsListMemberBuilder.source(
                                JsonData.from(mapper.jsonProvider().createParser(new StringReader(innerHitJsonWithNoIdOrIndex)), mapper)
                            )
                        )
                )
            )
    );
    private final Hit<JsonData> hitResultWithIdIndex = Hit.of(
        it -> it.id("test_parent")
            .index("_index")
            .innerHits(
                "test_child",
                innerHitsResultBuilder -> innerHitsResultBuilder.hits(
                    innerHitsMetadataBuilder -> innerHitsMetadataBuilder.total(total -> total.value(1).relation(TotalHitsRelation.Eq))
                        .hits(
                            innerHitsListMemberBuilder -> innerHitsListMemberBuilder.id("child_id")
                                .index("_index")
                                .source(
                                    JsonData.from(mapper.jsonProvider().createParser(new StringReader(innerHitJsonWithIdOrIndex)), mapper)
                                )
                        )
                )
            )
    );
}
