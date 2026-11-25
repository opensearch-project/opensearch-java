/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.samples

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import kotlin.system.exitProcess

object Main {
    private val LOGGER: Logger = LogManager.getLogger(Main::class.java)

    @JvmStatic
    fun main(args: Array<String>) {
        var mainClass = System.getProperty("samples.mainClass")
        if (mainClass.isNullOrEmpty()) {
            LOGGER.error("Please specify the main class to run with -Dsamples.mainClass=<main class>")
            exitProcess(1)
        }

        if (!mainClass.startsWith("org.")) {
            mainClass = "${Main::class.java.packageName}.$mainClass"
        }

        LOGGER.info("Running main class: {}", mainClass)

        try {
            val clazz = Class.forName(mainClass)
            val mainMethod = clazz.getMethod("main", Array<String>::class.java)
            mainMethod.invoke(null, args as Any)
        } catch (e: Exception) {
            LOGGER.error("Failed to run main class", e)
            exitProcess(1)
        }
    }
}
