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

import javax.annotation.Generated;

/**
 * <p>
 * Builders for {@link XyLocation} variants.
 * </p>
 * <p>
 * Variants <code>coords</code>, <code>text</code> are not available here as they don't have a dedicated class. Use {@link XyLocation}'s
 * builder for these.
 * </p>
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class XyLocationBuilders {
    private XyLocationBuilders() {}

    /**
     * Creates a builder for the {@link XyCartesianCoordinates cartesian} {@code XyLocation} variant.
     */
    public static XyCartesianCoordinates.Builder cartesian() {
        return new XyCartesianCoordinates.Builder();
    }
}
