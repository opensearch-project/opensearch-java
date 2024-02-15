/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.samples;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.opensearch.client.opensearch.OpenSearchClient;
import org.opensearch.client.transport.OpenSearchTransport;

public class OpenSearchClientProxy implements MethodInterceptor {

    private static final Logger LOGGER = LogManager.getLogger(OpenSearchClientProxy.class);

    public static OpenSearchClient create(OpenSearchTransport transport) throws Exception {
        if (transport == null) {
            throw new Exception("Cannot build OpenSearchClient without a transport.");
        }

        LOGGER.info("Using {} transport", transport.getClass().getName());

        final var interceptor = new OpenSearchClientProxy();
        final var enhancer = new Enhancer();

        enhancer.setSuperclass(OpenSearchClient.class);
        enhancer.setCallback(interceptor);

        final var argTypes = new Class[] { OpenSearchTransport.class };
        final var args = new Object[] { transport };
        return (OpenSearchClient) enhancer.create(argTypes, args);
    }

    @Override
    public Object intercept(final Object obj, final Method method, final Object[] args, final MethodProxy proxy) throws Throwable {
        LOGGER.info("Invoking method: {}", method.getName());
        final Object result;

        try {
            LOGGER.info("Entering method: {}", method.getName());
            result = proxy.invokeSuper(obj, args);
        } catch (final InvocationTargetException e) {
            throw e.getTargetException();
        } finally {
            LOGGER.info("Exiting method: {}", method.getName());
        }
        return result;
    }
}
