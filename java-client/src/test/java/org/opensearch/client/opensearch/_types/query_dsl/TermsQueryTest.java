package org.opensearch.client.opensearch._types.query_dsl;

import java.util.List;
import org.junit.Test;
import org.opensearch.client.opensearch._types.FieldValue;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class TermsQueryTest extends ModelTestCase {
    @Test
    public void toBuilder() {
        TermsQuery origin = new TermsQuery.Builder()
            .field("field")
            .terms(new TermsQueryField.Builder().value(List.of(FieldValue.of("1"))).build())
            .build();
        TermsQuery copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }
}
