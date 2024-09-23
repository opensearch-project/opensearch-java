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

package org.opensearch.client.opensearch.ml;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import org.opensearch.client.ApiClient;
import org.opensearch.client.opensearch._types.ErrorResponse;
import org.opensearch.client.opensearch._types.OpenSearchException;
import org.opensearch.client.transport.JsonEndpoint;
import org.opensearch.client.transport.OpenSearchTransport;
import org.opensearch.client.transport.TransportOptions;
import org.opensearch.client.util.ObjectBuilder;

/**
 * Client for the ml namespace.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class OpenSearchMlAsyncClient extends ApiClient<OpenSearchTransport, OpenSearchMlAsyncClient> {
    public OpenSearchMlAsyncClient(OpenSearchTransport transport) {
        super(transport, null);
    }

    public OpenSearchMlAsyncClient(OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    @Override
    public OpenSearchMlAsyncClient withTransportOptions(@Nullable TransportOptions transportOptions) {
        return new OpenSearchMlAsyncClient(this.transport, transportOptions);
    }

    // ----- Endpoint: ml.create_connector

    /**
     * Creates a standalone connector.
     */
    public CompletableFuture<CreateConnectorResponse> createConnector(CreateConnectorRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, CreateConnectorRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Creates a standalone connector.
     *
     * @param fn a function that initializes a builder to create the {@link CreateConnectorRequest}
     */
    public final CompletableFuture<CreateConnectorResponse> createConnector(
        Function<CreateConnectorRequest.Builder, ObjectBuilder<CreateConnectorRequest>> fn
    ) throws IOException, OpenSearchException {
        return createConnector(fn.apply(new CreateConnectorRequest.Builder()).build());
    }

    // ----- Endpoint: ml.delete_agent

    /**
     * Delete an agent.
     */
    public CompletableFuture<DeleteAgentResponse> deleteAgent(DeleteAgentRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, DeleteAgentRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Delete an agent.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteAgentRequest}
     */
    public final CompletableFuture<DeleteAgentResponse> deleteAgent(
        Function<DeleteAgentRequest.Builder, ObjectBuilder<DeleteAgentRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteAgent(fn.apply(new DeleteAgentRequest.Builder()).build());
    }

    // ----- Endpoint: ml.delete_connector

    /**
     * Deletes a standalone connector.
     */
    public CompletableFuture<DeleteConnectorResponse> deleteConnector(DeleteConnectorRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequestAsync(request, DeleteConnectorRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Deletes a standalone connector.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteConnectorRequest}
     */
    public final CompletableFuture<DeleteConnectorResponse> deleteConnector(
        Function<DeleteConnectorRequest.Builder, ObjectBuilder<DeleteConnectorRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteConnector(fn.apply(new DeleteConnectorRequest.Builder()).build());
    }

    // ----- Endpoint: ml.delete_model

    /**
     * Deletes a model.
     */
    public CompletableFuture<DeleteModelResponse> deleteModel(DeleteModelRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<DeleteModelRequest, DeleteModelResponse, ErrorResponse> endpoint = (JsonEndpoint<
            DeleteModelRequest,
            DeleteModelResponse,
            ErrorResponse>) DeleteModelRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Deletes a model.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteModelRequest}
     */
    public final CompletableFuture<DeleteModelResponse> deleteModel(
        Function<DeleteModelRequest.Builder, ObjectBuilder<DeleteModelRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteModel(fn.apply(new DeleteModelRequest.Builder()).build());
    }

    // ----- Endpoint: ml.delete_model_group

    /**
     * Deletes a model group.
     */
    public CompletableFuture<DeleteModelGroupResponse> deleteModelGroup(DeleteModelGroupRequest request) throws IOException,
        OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<DeleteModelGroupRequest, DeleteModelGroupResponse, ErrorResponse> endpoint = (JsonEndpoint<
            DeleteModelGroupRequest,
            DeleteModelGroupResponse,
            ErrorResponse>) DeleteModelGroupRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Deletes a model group.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteModelGroupRequest}
     */
    public final CompletableFuture<DeleteModelGroupResponse> deleteModelGroup(
        Function<DeleteModelGroupRequest.Builder, ObjectBuilder<DeleteModelGroupRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteModelGroup(fn.apply(new DeleteModelGroupRequest.Builder()).build());
    }

    // ----- Endpoint: ml.delete_task

    /**
     * Deletes a task.
     */
    public CompletableFuture<DeleteTaskResponse> deleteTask(DeleteTaskRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<DeleteTaskRequest, DeleteTaskResponse, ErrorResponse> endpoint = (JsonEndpoint<
            DeleteTaskRequest,
            DeleteTaskResponse,
            ErrorResponse>) DeleteTaskRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Deletes a task.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteTaskRequest}
     */
    public final CompletableFuture<DeleteTaskResponse> deleteTask(Function<DeleteTaskRequest.Builder, ObjectBuilder<DeleteTaskRequest>> fn)
        throws IOException, OpenSearchException {
        return deleteTask(fn.apply(new DeleteTaskRequest.Builder()).build());
    }

    // ----- Endpoint: ml.deploy_model

    /**
     * Deploys a model.
     */
    public CompletableFuture<DeployModelResponse> deployModel(DeployModelRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<DeployModelRequest, DeployModelResponse, ErrorResponse> endpoint = (JsonEndpoint<
            DeployModelRequest,
            DeployModelResponse,
            ErrorResponse>) DeployModelRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Deploys a model.
     *
     * @param fn a function that initializes a builder to create the {@link DeployModelRequest}
     */
    public final CompletableFuture<DeployModelResponse> deployModel(
        Function<DeployModelRequest.Builder, ObjectBuilder<DeployModelRequest>> fn
    ) throws IOException, OpenSearchException {
        return deployModel(fn.apply(new DeployModelRequest.Builder()).build());
    }

    // ----- Endpoint: ml.get_model_group

    /**
     * Retrieves a model group.
     */
    public CompletableFuture<GetModelGroupResponse> getModelGroup(GetModelGroupRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<GetModelGroupRequest, GetModelGroupResponse, ErrorResponse> endpoint = (JsonEndpoint<
            GetModelGroupRequest,
            GetModelGroupResponse,
            ErrorResponse>) GetModelGroupRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Retrieves a model group.
     *
     * @param fn a function that initializes a builder to create the {@link GetModelGroupRequest}
     */
    public final CompletableFuture<GetModelGroupResponse> getModelGroup(
        Function<GetModelGroupRequest.Builder, ObjectBuilder<GetModelGroupRequest>> fn
    ) throws IOException, OpenSearchException {
        return getModelGroup(fn.apply(new GetModelGroupRequest.Builder()).build());
    }

    // ----- Endpoint: ml.get_task

    /**
     * Retrieves a task.
     */
    public CompletableFuture<GetTaskResponse> getTask(GetTaskRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<GetTaskRequest, GetTaskResponse, ErrorResponse> endpoint = (JsonEndpoint<
            GetTaskRequest,
            GetTaskResponse,
            ErrorResponse>) GetTaskRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Retrieves a task.
     *
     * @param fn a function that initializes a builder to create the {@link GetTaskRequest}
     */
    public final CompletableFuture<GetTaskResponse> getTask(Function<GetTaskRequest.Builder, ObjectBuilder<GetTaskRequest>> fn)
        throws IOException, OpenSearchException {
        return getTask(fn.apply(new GetTaskRequest.Builder()).build());
    }

    // ----- Endpoint: ml.register_agents

    /**
     * Register an agent.
     */
    public CompletableFuture<RegisterAgentsResponse> registerAgents(RegisterAgentsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequestAsync(request, RegisterAgentsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Register an agent.
     *
     * @param fn a function that initializes a builder to create the {@link RegisterAgentsRequest}
     */
    public final CompletableFuture<RegisterAgentsResponse> registerAgents(
        Function<RegisterAgentsRequest.Builder, ObjectBuilder<RegisterAgentsRequest>> fn
    ) throws IOException, OpenSearchException {
        return registerAgents(fn.apply(new RegisterAgentsRequest.Builder()).build());
    }

    // ----- Endpoint: ml.register_model

    /**
     * Registers a model.
     */
    public CompletableFuture<RegisterModelResponse> registerModel(RegisterModelRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<RegisterModelRequest, RegisterModelResponse, ErrorResponse> endpoint = (JsonEndpoint<
            RegisterModelRequest,
            RegisterModelResponse,
            ErrorResponse>) RegisterModelRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Registers a model.
     *
     * @param fn a function that initializes a builder to create the {@link RegisterModelRequest}
     */
    public final CompletableFuture<RegisterModelResponse> registerModel(
        Function<RegisterModelRequest.Builder, ObjectBuilder<RegisterModelRequest>> fn
    ) throws IOException, OpenSearchException {
        return registerModel(fn.apply(new RegisterModelRequest.Builder()).build());
    }

    // ----- Endpoint: ml.register_model_group

    /**
     * Registers a model group.
     */
    public CompletableFuture<RegisterModelGroupResponse> registerModelGroup(RegisterModelGroupRequest request) throws IOException,
        OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<RegisterModelGroupRequest, RegisterModelGroupResponse, ErrorResponse> endpoint = (JsonEndpoint<
            RegisterModelGroupRequest,
            RegisterModelGroupResponse,
            ErrorResponse>) RegisterModelGroupRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Registers a model group.
     *
     * @param fn a function that initializes a builder to create the {@link RegisterModelGroupRequest}
     */
    public final CompletableFuture<RegisterModelGroupResponse> registerModelGroup(
        Function<RegisterModelGroupRequest.Builder, ObjectBuilder<RegisterModelGroupRequest>> fn
    ) throws IOException, OpenSearchException {
        return registerModelGroup(fn.apply(new RegisterModelGroupRequest.Builder()).build());
    }

    // ----- Endpoint: ml.undeploy_model

    /**
     * Undeploys a model.
     */
    public CompletableFuture<UndeployModelResponse> undeployModel(UndeployModelRequest request) throws IOException, OpenSearchException {
        @SuppressWarnings("unchecked")
        JsonEndpoint<UndeployModelRequest, UndeployModelResponse, ErrorResponse> endpoint = (JsonEndpoint<
            UndeployModelRequest,
            UndeployModelResponse,
            ErrorResponse>) UndeployModelRequest._ENDPOINT;

        return this.transport.performRequestAsync(request, endpoint, this.transportOptions);
    }

    /**
     * Undeploys a model.
     *
     * @param fn a function that initializes a builder to create the {@link UndeployModelRequest}
     */
    public final CompletableFuture<UndeployModelResponse> undeployModel(
        Function<UndeployModelRequest.Builder, ObjectBuilder<UndeployModelRequest>> fn
    ) throws IOException, OpenSearchException {
        return undeployModel(fn.apply(new UndeployModelRequest.Builder()).build());
    }
}
