package org.opensearch.client.opensearch;

import org.opensearch.client.json.JsonEnum;
import org.opensearch.client.json.JsonpDeserializable;

@JsonpDeserializable
public enum SearchType implements JsonEnum {
    QueryThenFetch("query_then_fetch"),
    DfsQueryThenFetch("dfs_query_then_fetch"),
    ;

    private final String jsonValue;
    private final String[] aliases;

    SearchType(String jsonValue, String... aliases) {
        this.jsonValue = jsonValue;
        this.aliases = aliases;
    }

    public String jsonValue() {
        return this.jsonValue;
    }

    public String[] aliases() {
        return this.aliases;
    }

    public static final JsonEnum.Deserializer<SearchType> _DESERIALIZER =
            new JsonEnum.Deserializer<>(SearchType.values());
}
