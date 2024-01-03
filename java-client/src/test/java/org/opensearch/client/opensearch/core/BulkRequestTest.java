package org.opensearch.client.opensearch.core;

import java.util.Collections;
import org.junit.Assert;
import org.junit.Test;
import org.opensearch.client.opensearch.core.bulk.BulkOperation;
import org.opensearch.client.opensearch.core.bulk.DeleteOperation;

public class BulkRequestTest extends Assert {

    @Test
    public void toBuilder() {
        BulkRequest origin = new BulkRequest.Builder().index("index")
            .operations(
                Collections.singletonList(new BulkOperation.Builder().delete(new DeleteOperation.Builder().id("id").build()).build())
            )
            .build();
        BulkRequest copied = origin.toBuilder().build();

        assertEquals(copied.index(), origin.index());
    }
}
