/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.util;

import java.util.StringJoiner;

/**
 * Thrown by {@link ObjectBuilder#build()} when one of the required properties is missing.
 * <p>
 * If you think this is an error and that the reported property is actually optional, a workaround is
 * available in {@link ApiTypeHelper} to disable checks. Use with caution.
 */
public class MissingRequiredPropertiesException extends RuntimeException {
    private Class<?> clazz;
    private String[] properties;

    public MissingRequiredPropertiesException(Object obj, String... properties) {
        super(
            "Missing at least one required property between "
                + buildPropertiesMsg(properties)
                + " in '"
                + obj.getClass().getSimpleName()
                + "'"
        );
        this.clazz = obj.getClass();
        this.properties = properties;
    }

    /**
     * The class where the missing property was found
     */
    public Class<?> getObjectClass() {
        return clazz;
    }

    public String[] getPropertiesName() {
        return properties;
    }

    private static String buildPropertiesMsg(String[] properties) {
        final StringJoiner sj = new StringJoiner(",", "'", "'");
        for (final String property : properties) {
            sj.add(property);
        }
        return sj.toString();
    }
}
