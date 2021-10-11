/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

/*
 * Licensed to Elasticsearch B.V. under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch B.V. licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

/*
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
 */

//----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------

package org.opensearch.client.opensearch.api.tasks;

import org.opensearch.client.RequestOptions;
import org.opensearch.client.base.ApiClient;
import org.opensearch.client.base.Transport;
import org.opensearch.client.opensearch.task.CancelRequest;
import org.opensearch.client.opensearch.task.CancelResponse;
import org.opensearch.client.opensearch.task.GetRequest;
import org.opensearch.client.opensearch.task.GetResponse;
import org.opensearch.client.opensearch.task.ListRequest;
import org.opensearch.client.opensearch.task.ListResponse;
import org.opensearch.client.util.ObjectBuilder;

import javax.annotation.Nullable;
import java.io.IOException;
import java.util.function.Function;

/**
 * Client for the tasks namespace.
 */
public class TasksClient extends ApiClient<TasksClient> {

	public TasksClient(Transport transport) {
		super(transport, null);
	}

	public TasksClient(Transport transport, RequestOptions options) {
		super(transport, options);
	}

	// ----- Endpoint: tasks.cancel

	/**
	 * Cancels a task, if it can be cancelled through an API.
	 *
	 */

	public CancelResponse cancel(CancelRequest request) throws IOException {
		return this.transport.performRequest(request, CancelRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Cancels a task, if it can be cancelled through an API.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final CancelResponse cancel(Function<CancelRequest.Builder, ObjectBuilder<CancelRequest>> fn)
			throws IOException {
		return cancel(fn.apply(new CancelRequest.Builder()).build());
	}

	// ----- Endpoint: tasks.get

	/**
	 * Returns information about a task.
	 *
	 */

	public GetResponse get(GetRequest request) throws IOException {
		return this.transport.performRequest(request, GetRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Returns information about a task.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final GetResponse get(Function<GetRequest.Builder, ObjectBuilder<GetRequest>> fn) throws IOException {
		return get(fn.apply(new GetRequest.Builder()).build());
	}

	// ----- Endpoint: tasks.list

	/**
	 * Returns a list of tasks.
	 *
	 */

	public ListResponse list(ListRequest request) throws IOException {
		return this.transport.performRequest(request, ListRequest.ENDPOINT, this.requestOptions);
	}

	/**
	 * Returns a list of tasks.
	 *
	 * @param fn
	 *            a function that initializes a freshly created builder. This
	 *            function can either return its builder argument after having set
	 *            its properties or return another builder.
	 */

	public final ListResponse list(Function<ListRequest.Builder, ObjectBuilder<ListRequest>> fn) throws IOException {
		return list(fn.apply(new ListRequest.Builder()).build());
	}

	// ----- Misc

	/**
	 * Creates a new {@link #TasksClient} with specific request options.
	 */
	@Override
	public TasksClient withRequestOptions(@Nullable RequestOptions options) {
		return new TasksClient(transport, options);
	}

	/**
	 * Creates a new {@link #TasksClient} with specific request options, inheriting
	 * existing options.
	 *
	 * @param fn
	 *            a function taking an options builder initialized with the current
	 *            request options, or initialized with default values.
	 */
	public TasksClient withRequestOptions(Function<RequestOptions.Builder, RequestOptions.Builder> fn) {
		RequestOptions.Builder builder = requestOptions == null
				? RequestOptions.DEFAULT.toBuilder()
				: requestOptions.toBuilder();

		return withRequestOptions(fn.apply(builder).build());
	}
}
