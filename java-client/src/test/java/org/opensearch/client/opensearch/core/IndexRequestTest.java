package org.opensearch.client.opensearch.core;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class IndexRequestTest extends ModelTestCase {

    @Test
    public void toBuilder() {
        IndexRequest<MyDoc> origin = new IndexRequest.Builder<MyDoc>()
            .id("id")
            .index("index")
            .document(new MyDoc("1"))
            .build();
        IndexRequest<MyDoc> copied = origin.toBuilder().build();

        assertEquals(toJson(copied), toJson(origin));
    }

    static class MyDoc {
        String key;
        MyDoc(String key) {
            this.key = key;
        }
    }
}
