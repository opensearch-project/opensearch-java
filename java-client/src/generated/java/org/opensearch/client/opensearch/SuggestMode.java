package org.opensearch.client.opensearch;

import org.opensearch.client.json.JsonEnum;
import org.opensearch.client.json.JsonpDeserializable;

@JsonpDeserializable
public enum SuggestMode implements JsonEnum {
    Missing("missing"),
    Popular("popular"),
    Always("always"),
    ;

    private final String jsonValue;
    private final String[] aliases;

    SuggestMode(String jsonValue, String... aliases) {
        this.jsonValue = jsonValue;
        this.aliases = aliases;
    }

    public String jsonValue() {
        return this.jsonValue;
    }

    public String[] aliases() {
        return this.aliases;
    }

    public static final JsonEnum.Deserializer<SuggestMode> _DESERIALIZER =
            new JsonEnum.Deserializer<>(SuggestMode.values());
}
