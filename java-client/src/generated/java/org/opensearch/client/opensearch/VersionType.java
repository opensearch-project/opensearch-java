package org.opensearch.client.opensearch;

import org.opensearch.client.json.JsonEnum;
import org.opensearch.client.json.JsonpDeserializable;

@JsonpDeserializable
public enum VersionType implements JsonEnum {
    Internal("internal"),
    External("external"),
    ExternalGte("external_gte"),
    ;

    private final String jsonValue;
    private final String[] aliases;

    VersionType(String jsonValue, String... aliases) {
        this.jsonValue = jsonValue;
        this.aliases = aliases;
    }

    public String jsonValue() {
        return this.jsonValue;
    }

    public String[] aliases() {
        return this.aliases;
    }

    public static final JsonEnum.Deserializer<VersionType> _DESERIALIZER =
            new JsonEnum.Deserializer<>(VersionType.values());
}
