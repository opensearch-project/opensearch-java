package org.opensearch.client.opensearch;

import org.opensearch.client.json.JsonEnum;
import org.opensearch.client.json.JsonpDeserializable;

@JsonpDeserializable
public enum Relation implements JsonEnum {
    Eq("eq"),
    Gte("gte"),
    ;

    private final String jsonValue;
    private final String[] aliases;

    Relation(String jsonValue, String... aliases) {
        this.jsonValue = jsonValue;
        this.aliases = aliases;
    }

    public String jsonValue() {
        return this.jsonValue;
    }

    public String[] aliases() {
        return this.aliases;
    }

    public static final JsonEnum.Deserializer<Relation> _DESERIALIZER =
            new JsonEnum.Deserializer<>(Relation.values());
}
