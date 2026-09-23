/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.core;

import org.junit.Test;
import org.opensearch.client.opensearch.core.bulk.BulkResponseItem;
import org.opensearch.client.opensearch.core.bulk.OperationType;
import org.opensearch.client.opensearch.model.ModelTestCase;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.MissingRequiredPropertyException;

public class BulkResponseTest extends ModelTestCase {
    // filter_path=items.*.error keeps only the errors of failed items, and prunes the required errors, took, _index and
    // status properties.
    private static final String FILTERED_ERRORS_RESPONSE = "{\"items\":[{\"index\":{\"error\":"
        + "{\"type\":\"mapper_parsing_exception\",\"reason\":\"failed to parse\"}}}]}";

    @Test
    public void filteredResponseFailsByDefault() {
        assertThrows(MissingRequiredPropertyException.class, () -> fromJson(FILTERED_ERRORS_RESPONSE, BulkResponse._DESERIALIZER));
    }

    @Test
    public void filteredResponseReadsMissingPrimitivesAsDefaultsWhenRequiredChecksAreDisabled() {
        try (ApiTypeHelper.DisabledChecksHandle h = ApiTypeHelper.DANGEROUS_disableRequiredPropertiesCheck(true)) {
            BulkResponse response = fromJson(FILTERED_ERRORS_RESPONSE, BulkResponse._DESERIALIZER);

            // errors() reads as false although an item failed: a missing primitive cannot be told apart from a real value
            assertFalse(response.errors());
            assertEquals(0L, response.took());

            BulkResponseItem item = response.items().get(0);
            assertEquals(OperationType.Index, item.operationType());
            assertEquals(0, item.status());
            assertNull(item.index());
            assertEquals("mapper_parsing_exception", item.error().type());
        }
    }
}
