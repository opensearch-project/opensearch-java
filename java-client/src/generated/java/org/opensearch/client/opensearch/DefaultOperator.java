package org.opensearch.client.opensearch;

import org.opensearch.client.json.JsonEnum;
import org.opensearch.client.json.JsonpDeserializable;

@JsonpDeserializable
public enum DefaultOperator implements JsonEnum {
    And("AND"),
    Or("OR"),
    ;

    private final String jsonValue;
    private final String[] aliases;

    DefaultOperator(String jsonValue, String... aliases) {
        this.jsonValue = jsonValue;
        this.aliases = aliases;
    }

    public String jsonValue() {
        return this.jsonValue;
    }

    public String[] aliases() {
        return this.aliases;
    }

    public static final JsonEnum.Deserializer<DefaultOperator> _DESERIALIZER =
            new JsonEnum.Deserializer<>(DefaultOperator.values());
}
