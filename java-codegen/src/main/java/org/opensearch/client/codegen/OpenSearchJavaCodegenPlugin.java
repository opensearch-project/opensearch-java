package org.opensearch.client.codegen;

import software.amazon.smithy.build.PluginContext;
import software.amazon.smithy.build.SmithyBuildPlugin;

public class OpenSearchJavaCodegenPlugin implements SmithyBuildPlugin {
    @Override
    public String getName() {
        return "opensearch-java";
    }

    @Override
    public void execute(PluginContext context) {
        new CodegenVisitor(context).execute();
    }
}
