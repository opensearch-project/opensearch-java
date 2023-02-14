package org.opensearch.client.opensearch;

import org.opensearch.client.json.JsonEnum;
import org.opensearch.client.json.JsonpDeserializable;

@JsonpDeserializable
public enum ExpandWildcards implements JsonEnum {
    All("all"),
    Open("open"),
    Closed("closed"),
    Hidden("hidden"),
    None("none"),
    ;

    private final String jsonValue;
    private final String[] aliases;

    ExpandWildcards(String jsonValue, String... aliases) {
        this.jsonValue = jsonValue;
        this.aliases = aliases;
    }

    public String jsonValue() {
        return this.jsonValue;
    }

    public String[] aliases() {
        return this.aliases;
    }

    public static final JsonEnum.Deserializer<ExpandWildcards> _DESERIALIZER =
            new JsonEnum.Deserializer<>(ExpandWildcards.values());
}
