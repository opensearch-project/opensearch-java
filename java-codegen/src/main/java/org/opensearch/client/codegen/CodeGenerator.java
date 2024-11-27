/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen;

import static org.opensearch.client.codegen.model.OperationGroupMatcher.and;
import static org.opensearch.client.codegen.model.OperationGroupMatcher.named;
import static org.opensearch.client.codegen.model.OperationGroupMatcher.namespace;
import static org.opensearch.client.codegen.model.OperationGroupMatcher.not;
import static org.opensearch.client.codegen.model.OperationGroupMatcher.or;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.stream.Stream;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.opensearch.client.codegen.exceptions.ApiSpecificationParseException;
import org.opensearch.client.codegen.exceptions.RenderException;
import org.opensearch.client.codegen.model.Namespace;
import org.opensearch.client.codegen.model.OperationGroupMatcher;
import org.opensearch.client.codegen.model.ShapeRenderingContext;
import org.opensearch.client.codegen.model.SpecTransformer;
import org.opensearch.client.codegen.model.overrides.Overrides;
import org.opensearch.client.codegen.openapi.OpenApiSpecification;

public class CodeGenerator {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final OperationGroupMatcher OPERATION_MATCHER = or(
        and(namespace(""), named("info")),
        namespace("dangling_indices"),
        and(
            namespace("indices"),
            named(
                "create",
                "delete",
                "delete_index_template",
                "exists",
                "exists_index_template",
                "get",
                "get_index_template",
                "put_index_template",
                "simulate_index_template"
            )
        ),
        and(namespace("ml"), not(named("search_models"))), // TODO: search_models is complex and ideally should re-use the search structures
        and(namespace("snapshot"), named("cleanup_repository", "clone", "create", "get", "verify_repository")),
        and(namespace("tasks"))
    );

    public static void main(String[] args) {
        var inputOpt = Option.builder("i")
            .longOpt("input")
            .desc("The URI or path of the OpenAPI specification")
            .argName("INPUT")
            .hasArg()
            .required()
            .build();
        var eclipseConfigOpt = Option.builder()
            .longOpt("eclipse-config")
            .desc("The path of the Eclipse formatting config file")
            .argName("ECLIPSE_CONFIG")
            .hasArg()
            .required()
            .build();
        var outputOpt = Option.builder("o")
            .longOpt("output")
            .desc("The path to the output directory to generate code into")
            .argName("OUTPUT")
            .hasArg()
            .required()
            .build();
        var helpOpt = Option.builder("h").longOpt("help").desc("Print this help information").build();
        final var usageString =
            "CodeGenerator.class --input https://.../opensearch-openapi.yaml --eclipse-config ./buildSrc/formatterConfig.xml --output ./java-client/src/generated/java";

        var options = new Options().addOption(inputOpt).addOption(eclipseConfigOpt).addOption(outputOpt).addOption(helpOpt);

        var cliParser = new DefaultParser();

        try {
            var cli = cliParser.parse(options, args);

            if (cli.hasOption(helpOpt)) {
                var helpFormatter = HelpFormatter.builder().get();
                helpFormatter.printHelp(usageString, options);
                return;
            }

            var specLocation = new URI(cli.getOptionValue(inputOpt));
            var eclipseConfig = new File(cli.getOptionValue(eclipseConfigOpt));
            var outputDir = new File(cli.getOptionValue(outputOpt));
            LOGGER.info("Specification Location: {}", specLocation);
            LOGGER.info("Eclipse Configuration: {}", eclipseConfig);
            LOGGER.info("Output Directory: {}", outputDir);

            Namespace root = parseSpec(specLocation);

            cleanDirectory(outputDir);

            final var rootPackageOutputDir = new File(outputDir, root.getPackageName().replace('.', '/'));

            try (
                var ctx = ShapeRenderingContext.builder()
                    .withOutputDir(rootPackageOutputDir)
                    .withJavaCodeFormatter(b -> b.withRootDir(rootPackageOutputDir.toPath()).withEclipseFormatterConfig(eclipseConfig))
                    .withTemplateLoader(b -> b.withTemplatesResourceSubPath("/org/opensearch/client/codegen/templates"))
                    .build()
            ) {
                root.render(ctx);
            }
        } catch (ParseException e) {
            LOGGER.error("Argument Parsing Failed. Reason: {}", e.getMessage());

            var helpFormatter = HelpFormatter.builder().setPrintWriter(new PrintWriter(System.err)).get();
            helpFormatter.printHelp(usageString, options);

            System.exit(1);
        } catch (Throwable e) {
            LOGGER.fatal("Unexpected Error", e);
            System.exit(1);
        }
    }

    private static Namespace parseSpec(URI location) throws ApiSpecificationParseException {
        var spec = OpenApiSpecification.retrieve(location);
        var transformer = new SpecTransformer(OPERATION_MATCHER, Overrides.OVERRIDES);
        transformer.visit(spec);
        return transformer.getRoot();
    }

    private static void cleanDirectory(File dir) throws RenderException {
        if (!dir.exists()) {
            return;
        }
        try (Stream<Path> walker = Files.walk(dir.toPath())) {
            walker.sorted(Comparator.reverseOrder()).map(Path::toFile).forEach(File::delete);
        } catch (IOException e) {
            throw new RenderException("Unable to cleanup output directory: " + dir, e);
        }
    }
}
