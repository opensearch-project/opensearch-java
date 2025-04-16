/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.codegen.openapi.rewriter;

import java.util.ArrayList;
import java.util.function.Function;
import javax.annotation.Nonnull;
import org.opensearch.client.codegen.openapi.OpenApiSpecification;
import org.opensearch.client.codegen.openapi.walker.OpenApiVisitor;
import org.opensearch.client.codegen.openapi.walker.OpenApiWalker;
import org.opensearch.client.codegen.transformer.overrides.Overrides;

public final class SpecificationRewriter {
    @Nonnull
    public static OpenApiSpecification rewrite(@Nonnull OpenApiSpecification specification, @Nonnull Overrides overrides) {
        var visitorChain = new ArrayList<Function<OpenApiWalker, OpenApiVisitor>>();

        visitorChain.add(w -> new ExtendsAllOfRewritingVisitor());
        visitorChain.add(w -> new OneOfAllExtendsInvertingVisitor());
        visitorChain.add(TypeDeterminingVisitor::new);
        visitorChain.add(w -> new ObjectFlatteningVisitor(overrides, w));
        visitorChain.add(w -> new ResponseSchemaVisitor());
        visitorChain.add(GenericLabelingVisitor::new);

        for (var visitorFactory : visitorChain) {
            var walker = new OpenApiWalker();
            var visitor = visitorFactory.apply(walker);
            specification = walker.walkSpecification(specification, visitor);
        }

        return specification;
    }
}
