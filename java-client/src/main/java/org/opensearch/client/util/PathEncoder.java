package org.opensearch.client.util;

/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collections;

public class PathEncoder {

    private final static String httpClient4UtilClassName = "org.apache.http.client.utils.URLEncodedUtils";
    private final static String httpClient5UtilClassName = "org.apache.hc.core5.net.URLEncodedUtils";
    private static final boolean isHttpClient5UtilPresent = isPresent(httpClient5UtilClassName);

    public static String encode(String uri) {
        if (isHttpClient5UtilPresent) {
            return encodeByUtilClass(uri, httpClient5UtilClassName);
        } else {
            return encodeByUtilClass(uri, httpClient4UtilClassName);
        }
    }

    private static String encodeByUtilClass(String uri, String className) {
        try {
            Method formatSegments = Class.forName(className).getMethod("formatSegments", Iterable.class, Charset.class);
            String invoke = (String) formatSegments.invoke(null, Collections.singletonList(uri), StandardCharsets.UTF_8);
            return invoke.substring(1);
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Failed to encode URI using " + className, e);
        }
    }

    private static boolean isPresent(String className) {
        try {
            Class.forName(className);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

}
