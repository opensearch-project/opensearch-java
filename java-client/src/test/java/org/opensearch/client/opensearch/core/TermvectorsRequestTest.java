package org.opensearch.client.opensearch.core;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class TermvectorsRequestTest extends ModelTestCase {

    @Test
    public void toBuilder() {
        TermvectorsRequest<MyDoc> origin = new TermvectorsRequest.Builder<MyDoc>().index("index").build();
        TermvectorsRequest<MyDoc> copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }

    static class MyDoc { }
}
