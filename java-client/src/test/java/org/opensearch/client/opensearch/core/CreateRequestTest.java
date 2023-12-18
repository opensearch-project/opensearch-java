package org.opensearch.client.opensearch.core;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class CreateRequestTest extends ModelTestCase {

    @Test
    public void toBuilder() {
        CreateRequest<MyDoc> origin = new CreateRequest.Builder<MyDoc>()
            .id("id")
            .document(new MyDoc("1"))
            .index("index")
            .build();
        CreateRequest<MyDoc> copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }

    static class MyDoc {
        String key;
        MyDoc(String key) {
            this.key = key;
        }
    }
}
