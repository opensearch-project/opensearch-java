/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

/*
 * Licensed to Elasticsearch B.V. under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch B.V. licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

/*
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
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
