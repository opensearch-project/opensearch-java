package org.opensearch.client.codegen

import software.amazon.smithy.build.PluginContext
import software.amazon.smithy.build.SmithyBuildPlugin

class OpenSearchJavaCodegenPlugin : SmithyBuildPlugin {
    override fun getName(): String = "opensearch-java"

    override fun execute(context: PluginContext) {
        CodegenVisitor(context).execute()
    }
}