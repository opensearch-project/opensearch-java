package org.opensearch.client.opensearch.core;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class TermsEnumRequestTest extends ModelTestCase {

    @Test
    public void toBuilder() {
        TermsEnumRequest origin = new TermsEnumRequest.Builder().index("index").field("field").build();
        TermsEnumRequest copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
