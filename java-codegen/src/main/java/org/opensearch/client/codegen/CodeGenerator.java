/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen;

import static org.opensearch.client.codegen.model.OperationGroupMatcher.name;
import static org.opensearch.client.codegen.model.OperationGroupMatcher.namespace;
import static org.opensearch.client.codegen.utils.matcher.Matcher.and;
import static org.opensearch.client.codegen.utils.matcher.Matcher.is;
import static org.opensearch.client.codegen.utils.matcher.Matcher.isNot;
import static org.opensearch.client.codegen.utils.matcher.Matcher.isNull;
import static org.opensearch.client.codegen.utils.matcher.Matcher.isOneOf;
import static org.opensearch.client.codegen.utils.matcher.Matcher.not;
import static org.opensearch.client.codegen.utils.matcher.Matcher.or;
import static org.opensearch.client.codegen.utils.matcher.StringMatcher.contains;

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
import org.opensearch.client.codegen.model.OperationGroup;
import org.opensearch.client.codegen.openapi.OpenApiSpecification;
import org.opensearch.client.codegen.openapi.rewriter.SpecificationRewriter;
import org.opensearch.client.codegen.renderer.ShapeRenderingContext;
import org.opensearch.client.codegen.transformer.SpecTransformer;
import org.opensearch.client.codegen.transformer.overrides.Overrides;
import org.opensearch.client.codegen.utils.matcher.Matcher;

public class CodeGenerator {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final Matcher<OperationGroup> OPERATION_MATCHER = or(
        and(
            namespace(isNull()),
            name(
                or(
                    isOneOf(
                        "clear_scroll",
                        "count",
                        "delete",
                        "field_caps",
                        "info",
                        "mtermvectors",
                        "ping",
                        "rank_eval",
                        "render_search_template",
                        "search_shards"
                    ),
                    contains("_by_query"),
                    contains("exists"),
                    contains("_pit"),
                    contains("reindex"),
                    and(contains("script"), isNot("scripts_painless_execute"))
                )
            )
        ),
        and(namespace(is("cat")), name(isNot("help"))),
        and(
            namespace(is("cluster")),
            name(
                or(
                    isOneOf("allocation_explain", "health", "pending_tasks", "remote_info", "reroute", "state", "stats"),
                    contains("component_template"),
                    contains("settings"),
                    contains("voting_config_exclusions")
                )
            )
        ),
        namespace(is("dangling_indices")),
        and(namespace(is("indices")), name(isNot("get_field_mapping"))),
        and(namespace(is("ingest"))),
        and(namespace(is("ingestion"))),
        and(namespace(is("ism"))),
        and(
            namespace(is("ml")),
            name(
                // TODO: search_models is complex and ideally should re-use the search structures
                not(or(contains("predict"), contains("search"), contains("train"), isOneOf("chunk_model", "execute_algorithm")))
            )
        ),
        and(
            namespace(is("nodes")),
            name(
                // TODO: hot_threads is a plain text response and should be handled differently
                isNot("hot_threads")
            )
        ),
        namespace(is("search_pipeline")),
        namespace(is("security")),
        namespace(is("snapshot")),
        namespace(is("tasks"))
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
        spec = SpecificationRewriter.rewrite(spec, Overrides.OVERRIDES);
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
