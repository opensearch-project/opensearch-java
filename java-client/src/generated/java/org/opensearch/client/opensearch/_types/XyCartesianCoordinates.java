/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

//----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------

package org.opensearch.client.opensearch._types;

import jakarta.json.stream.JsonGenerator;
import java.util.function.Function;
import javax.annotation.Generated;
import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.ObjectBuilderDeserializer;
import org.opensearch.client.json.ObjectDeserializer;
import org.opensearch.client.json.PlainJsonSerializable;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;

// typedef: _types.XyCartesianCoordinates

@JsonpDeserializable
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class XyCartesianCoordinates implements PlainJsonSerializable {

    private final double x;

    private final double y;

    // ---------------------------------------------------------------------------------------------

    private XyCartesianCoordinates(Builder builder) {
        this.x = ApiTypeHelper.requireNonNull(builder.x, this, "x");
        this.y = ApiTypeHelper.requireNonNull(builder.y, this, "y");
    }

    public static XyCartesianCoordinates of(Function<XyCartesianCoordinates.Builder, ObjectBuilder<XyCartesianCoordinates>> fn) {
        return fn.apply(new Builder()).build();
    }

    /**
     * Required - The x coordinate.
     * <p>
     * API name: {@code x}
     * </p>
     */
    public final double x() {
        return this.x;
    }

    /**
     * Required - The y coordinate.
     * <p>
     * API name: {@code y}
     * </p>
     */
    public final double y() {
        return this.y;
    }

    /**
     * Serialize this object to JSON.
     */
    @Override
    public void serialize(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeStartObject();
        serializeInternal(generator, mapper);
        generator.writeEnd();
    }

    protected void serializeInternal(JsonGenerator generator, JsonpMapper mapper) {
        generator.writeKey("x");
        generator.write(this.x);

        generator.writeKey("y");
        generator.write(this.y);
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Builder for {@link XyCartesianCoordinates}.
     */
    public static class Builder extends ObjectBuilderBase implements ObjectBuilder<XyCartesianCoordinates> {
        private Double x;
        private Double y;

        /**
         * Required - The x coordinate.
         * <p>
         * API name: {@code x}
         * </p>
         */
        public final Builder x(double value) {
            this.x = value;
            return this;
        }

        /**
         * Required - The y coordinate.
         * <p>
         * API name: {@code y}
         * </p>
         */
        public final Builder y(double value) {
            this.y = value;
            return this;
        }

        /**
         * Builds a {@link XyCartesianCoordinates}.
         *
         * @throws NullPointerException if some of the required fields are null.
         */
        public XyCartesianCoordinates build() {
            _checkSingleUse();

            return new XyCartesianCoordinates(this);
        }
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Json deserializer for {@link XyCartesianCoordinates}
     */
    public static final JsonpDeserializer<XyCartesianCoordinates> _DESERIALIZER = ObjectBuilderDeserializer.lazy(
        Builder::new,
        XyCartesianCoordinates::setupXyCartesianCoordinatesDeserializer
    );

    protected static void setupXyCartesianCoordinatesDeserializer(ObjectDeserializer<XyCartesianCoordinates.Builder> op) {
        op.add(Builder::x, JsonpDeserializer.doubleDeserializer(), "x");
        op.add(Builder::y, JsonpDeserializer.doubleDeserializer(), "y");
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Double.hashCode(this.x);
        result = 31 * result + Double.hashCode(this.y);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        XyCartesianCoordinates other = (XyCartesianCoordinates) o;
        return this.x == other.x && this.y == other.y;
    }
}
