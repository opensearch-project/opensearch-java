/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

package org.opensearch.client.opensearch.types;

import jakarta.json.stream.JsonGenerator;
import org.junit.Assert;
import org.junit.Test;
import org.opensearch.client.json.JsonData;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.JsonpSerializable;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.ErrorStringResponse;
import org.opensearch.client.opensearch._types.OpenSearchException;
import org.opensearch.client.opensearch._types.OpenSearchExceptionFactory;

import java.util.Map;

public class OpenSearchExceptionFactoryTest extends Assert {

	@Test
	public void shouldCreateExceptionWithErrorResponseDetails() {
		ErrorResponse errorResponse = ErrorResponse.of(builder -> builder.status(404)
				.error(error -> error.type("exception_type")
						.reason("exception_reason")
						.metadata(Map.of("meta", JsonData.of("data")))
				)
		);
		OpenSearchException exception = OpenSearchExceptionFactory.createException(errorResponse);
		assertEquals(404, exception.status());
		assertEquals("exception_type", exception.error().type());
		assertEquals("exception_reason", exception.error().reason());
		assertTrue(exception.error().metadata().containsKey("meta"));
		assertEquals("data", exception.error().metadata().get("meta").toString());
	}

	@Test
	public void shouldCreateExceptionWithErrorStringResponseDetails() {
		ErrorStringResponse errorResponse = ErrorStringResponse.of(builder -> builder.status(404).error("exception_string_reason"));

		OpenSearchException exception = OpenSearchExceptionFactory.createException(errorResponse);
		assertEquals(404, exception.status());
		assertEquals("string_error", exception.error().type());
		assertEquals("exception_string_reason", exception.error().reason());
	}

	@Test
	public void shouldThrowExceptionWhenErrorTypeCannotBeHandled() {
		FakeErrorResponse fakeErrorResponse = new FakeErrorResponse();
		try {
			OpenSearchExceptionFactory.createException(fakeErrorResponse);
			fail();
		} catch (OpenSearchException ex) {
			assertEquals(500, ex.status());
			assertEquals("error_type", ex.error().type());
			assertEquals("Unknown error type: " + fakeErrorResponse.getClass(), ex.error().reason());
		}
	}

	private class FakeErrorResponse implements JsonpSerializable {
		@Override
		public void serialize(JsonGenerator generator, JsonpMapper mapper) {
			generator.writeStartObject();
			generator.writeKey("error");
			generator.write("fakeError");
			generator.writeEnd();
		}
	}
}
