package org.opensearch.client.opensearch;

import org.opensearch.client.json.JsonEnum;
import org.opensearch.client.json.JsonpDeserializable;

@JsonpDeserializable
public enum HealthStatus implements JsonEnum {
    Green("green"),
    Yellow("yellow"),
    Red("red"),
    ;

    private final String jsonValue;
    private final String[] aliases;

    HealthStatus(String jsonValue, String... aliases) {
        this.jsonValue = jsonValue;
        this.aliases = aliases;
    }

    public String jsonValue() {
        return this.jsonValue;
    }

    public String[] aliases() {
        return this.aliases;
    }

    public static final JsonEnum.Deserializer<HealthStatus> _DESERIALIZER =
            new JsonEnum.Deserializer<>(HealthStatus.values());
}
