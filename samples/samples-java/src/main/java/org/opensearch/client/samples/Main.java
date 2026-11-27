/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.samples;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        var mainClass = System.getProperty("samples.mainClass");
        if (mainClass == null || mainClass.isEmpty()) {
            LOGGER.error("Please specify the main class to run with -Dsamples.mainClass=<main class>");
            System.exit(1);
        }

        if (!mainClass.startsWith("org.")) {
            mainClass = Main.class.getPackageName() + "." + mainClass;
        }

        LOGGER.info("Running main class: {}", mainClass);

        try {
            final var clazz = Class.forName(mainClass);
            final var mainMethod = clazz.getMethod("main", String[].class);
            mainMethod.invoke(null, (Object) args);
        } catch (Exception e) {
            LOGGER.error("Failed to run main class", e);
            System.exit(1);
        }
    }
}
