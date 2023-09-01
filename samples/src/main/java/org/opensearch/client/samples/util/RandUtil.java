/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.samples.util;

public class RandUtil {
    public static float[] rand2SfArray(int n) {
        var arr = new float[n];
        for (var i = 0; i < n; ++i) {
            arr[i] = Math.round(Math.random() * 100.0) / 100.0f;
        }
        return arr;
    }

    public static <T> T choice(T[] arr) {
        return arr[(int)Math.floor(Math.random() * arr.length)];
    }
}
