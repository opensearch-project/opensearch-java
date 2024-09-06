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
import java.util.function.Function;
import javax.annotation.Generated;
import javax.annotation.Nullable;
import org.opensearch.client.ApiClient;
import org.opensearch.client.opensearch._types.OpenSearchException;
import org.opensearch.client.transport.OpenSearchTransport;
import org.opensearch.client.transport.TransportOptions;
import org.opensearch.client.util.ObjectBuilder;

/**
 * Client for the ml namespace.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class OpenSearchMlClient extends ApiClient<OpenSearchTransport, OpenSearchMlClient> {
    public OpenSearchMlClient(OpenSearchTransport transport) {
        super(transport, null);
    }

    public OpenSearchMlClient(OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    @Override
    public OpenSearchMlClient withTransportOptions(@Nullable TransportOptions transportOptions) {
        return new OpenSearchMlClient(this.transport, transportOptions);
    }

    // ----- Endpoint: ml.delete_model

    /**
     * Deletes a model.
     */
    public DeleteModelResponse deleteModel(DeleteModelRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, DeleteModelRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Deletes a model.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteModelRequest}
     */
    public final DeleteModelResponse deleteModel(Function<DeleteModelRequest.Builder, ObjectBuilder<DeleteModelRequest>> fn)
        throws IOException, OpenSearchException {
        return deleteModel(fn.apply(new DeleteModelRequest.Builder()).build());
    }

    // ----- Endpoint: ml.delete_model_group

    /**
     * Deletes a model group.
     */
    public DeleteModelGroupResponse deleteModelGroup(DeleteModelGroupRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, DeleteModelGroupRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Deletes a model group.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteModelGroupRequest}
     */
    public final DeleteModelGroupResponse deleteModelGroup(
        Function<DeleteModelGroupRequest.Builder, ObjectBuilder<DeleteModelGroupRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteModelGroup(fn.apply(new DeleteModelGroupRequest.Builder()).build());
    }

    // ----- Endpoint: ml.delete_task

    /**
     * Deletes a task.
     */
    public DeleteTaskResponse deleteTask(DeleteTaskRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, DeleteTaskRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Deletes a task.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteTaskRequest}
     */
    public final DeleteTaskResponse deleteTask(Function<DeleteTaskRequest.Builder, ObjectBuilder<DeleteTaskRequest>> fn) throws IOException,
        OpenSearchException {
        return deleteTask(fn.apply(new DeleteTaskRequest.Builder()).build());
    }

    // ----- Endpoint: ml.deploy_model

    /**
     * Deploys a model.
     */
    public DeployModelResponse deployModel(DeployModelRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, DeployModelRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Deploys a model.
     *
     * @param fn a function that initializes a builder to create the {@link DeployModelRequest}
     */
    public final DeployModelResponse deployModel(Function<DeployModelRequest.Builder, ObjectBuilder<DeployModelRequest>> fn)
        throws IOException, OpenSearchException {
        return deployModel(fn.apply(new DeployModelRequest.Builder()).build());
    }

    // ----- Endpoint: ml.get_model_group

    /**
     * Retrieves a model group.
     */
    public GetModelGroupResponse getModelGroup(GetModelGroupRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetModelGroupRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Retrieves a model group.
     *
     * @param fn a function that initializes a builder to create the {@link GetModelGroupRequest}
     */
    public final GetModelGroupResponse getModelGroup(Function<GetModelGroupRequest.Builder, ObjectBuilder<GetModelGroupRequest>> fn)
        throws IOException, OpenSearchException {
        return getModelGroup(fn.apply(new GetModelGroupRequest.Builder()).build());
    }

    // ----- Endpoint: ml.get_task

    /**
     * Retrieves a task.
     */
    public GetTaskResponse getTask(GetTaskRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetTaskRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Retrieves a task.
     *
     * @param fn a function that initializes a builder to create the {@link GetTaskRequest}
     */
    public final GetTaskResponse getTask(Function<GetTaskRequest.Builder, ObjectBuilder<GetTaskRequest>> fn) throws IOException,
        OpenSearchException {
        return getTask(fn.apply(new GetTaskRequest.Builder()).build());
    }

    // ----- Endpoint: ml.register_model

    /**
     * Registers a model.
     */
    public RegisterModelResponse registerModel(RegisterModelRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, RegisterModelRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Registers a model.
     *
     * @param fn a function that initializes a builder to create the {@link RegisterModelRequest}
     */
    public final RegisterModelResponse registerModel(Function<RegisterModelRequest.Builder, ObjectBuilder<RegisterModelRequest>> fn)
        throws IOException, OpenSearchException {
        return registerModel(fn.apply(new RegisterModelRequest.Builder()).build());
    }

    // ----- Endpoint: ml.register_model_group

    /**
     * Registers a model group.
     */
    public RegisterModelGroupResponse registerModelGroup(RegisterModelGroupRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, RegisterModelGroupRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Registers a model group.
     *
     * @param fn a function that initializes a builder to create the {@link RegisterModelGroupRequest}
     */
    public final RegisterModelGroupResponse registerModelGroup(
        Function<RegisterModelGroupRequest.Builder, ObjectBuilder<RegisterModelGroupRequest>> fn
    ) throws IOException, OpenSearchException {
        return registerModelGroup(fn.apply(new RegisterModelGroupRequest.Builder()).build());
    }

    // ----- Endpoint: ml.undeploy_model

    /**
     * Undeploys a model.
     */
    public UndeployModelResponse undeployModel(UndeployModelRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, UndeployModelRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Undeploys a model.
     *
     * @param fn a function that initializes a builder to create the {@link UndeployModelRequest}
     */
    public final UndeployModelResponse undeployModel(Function<UndeployModelRequest.Builder, ObjectBuilder<UndeployModelRequest>> fn)
        throws IOException, OpenSearchException {
        return undeployModel(fn.apply(new UndeployModelRequest.Builder()).build());
    }
}
