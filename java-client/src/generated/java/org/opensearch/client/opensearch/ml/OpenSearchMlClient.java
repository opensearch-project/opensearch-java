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

    // ----- Endpoint: ml.create_connector

    /**
     * Creates a standalone connector.
     */
    public CreateConnectorResponse createConnector(CreateConnectorRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, CreateConnectorRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Creates a standalone connector.
     *
     * @param fn a function that initializes a builder to create the {@link CreateConnectorRequest}
     */
    public final CreateConnectorResponse createConnector(Function<CreateConnectorRequest.Builder, ObjectBuilder<CreateConnectorRequest>> fn)
        throws IOException, OpenSearchException {
        return createConnector(fn.apply(new CreateConnectorRequest.Builder()).build());
    }

    // ----- Endpoint: ml.create_controller

    /**
     * Creates a controller.
     */
    public CreateControllerResponse createController(CreateControllerRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, CreateControllerRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Creates a controller.
     *
     * @param fn a function that initializes a builder to create the {@link CreateControllerRequest}
     */
    public final CreateControllerResponse createController(
        Function<CreateControllerRequest.Builder, ObjectBuilder<CreateControllerRequest>> fn
    ) throws IOException, OpenSearchException {
        return createController(fn.apply(new CreateControllerRequest.Builder()).build());
    }

    // ----- Endpoint: ml.create_memory

    /**
     * Create a memory.
     */
    public CreateMemoryResponse createMemory(CreateMemoryRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, CreateMemoryRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Create a memory.
     *
     * @param fn a function that initializes a builder to create the {@link CreateMemoryRequest}
     */
    public final CreateMemoryResponse createMemory(Function<CreateMemoryRequest.Builder, ObjectBuilder<CreateMemoryRequest>> fn)
        throws IOException, OpenSearchException {
        return createMemory(fn.apply(new CreateMemoryRequest.Builder()).build());
    }

    /**
     * Create a memory.
     */
    public final CreateMemoryResponse createMemory() throws IOException, OpenSearchException {
        return createMemory(new CreateMemoryRequest.Builder().build());
    }

    // ----- Endpoint: ml.create_message

    /**
     * Create a message.
     */
    public CreateMessageResponse createMessage(CreateMessageRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, CreateMessageRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Create a message.
     *
     * @param fn a function that initializes a builder to create the {@link CreateMessageRequest}
     */
    public final CreateMessageResponse createMessage(Function<CreateMessageRequest.Builder, ObjectBuilder<CreateMessageRequest>> fn)
        throws IOException, OpenSearchException {
        return createMessage(fn.apply(new CreateMessageRequest.Builder()).build());
    }

    // ----- Endpoint: ml.create_model_meta

    /**
     * Registers model metadata.
     */
    @Deprecated
    public CreateModelMetaResponse createModelMeta(CreateModelMetaRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, CreateModelMetaRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Registers model metadata.
     *
     * @param fn a function that initializes a builder to create the {@link CreateModelMetaRequest}
     */
    @Deprecated
    public final CreateModelMetaResponse createModelMeta(Function<CreateModelMetaRequest.Builder, ObjectBuilder<CreateModelMetaRequest>> fn)
        throws IOException, OpenSearchException {
        return createModelMeta(fn.apply(new CreateModelMetaRequest.Builder()).build());
    }

    // ----- Endpoint: ml.delete_agent

    /**
     * Delete an agent.
     */
    public DeleteAgentResponse deleteAgent(DeleteAgentRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, DeleteAgentRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Delete an agent.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteAgentRequest}
     */
    public final DeleteAgentResponse deleteAgent(Function<DeleteAgentRequest.Builder, ObjectBuilder<DeleteAgentRequest>> fn)
        throws IOException, OpenSearchException {
        return deleteAgent(fn.apply(new DeleteAgentRequest.Builder()).build());
    }

    // ----- Endpoint: ml.delete_connector

    /**
     * Deletes a standalone connector.
     */
    public DeleteConnectorResponse deleteConnector(DeleteConnectorRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, DeleteConnectorRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Deletes a standalone connector.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteConnectorRequest}
     */
    public final DeleteConnectorResponse deleteConnector(Function<DeleteConnectorRequest.Builder, ObjectBuilder<DeleteConnectorRequest>> fn)
        throws IOException, OpenSearchException {
        return deleteConnector(fn.apply(new DeleteConnectorRequest.Builder()).build());
    }

    // ----- Endpoint: ml.delete_controller

    /**
     * Deletes a controller.
     */
    public DeleteControllerResponse deleteController(DeleteControllerRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, DeleteControllerRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Deletes a controller.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteControllerRequest}
     */
    public final DeleteControllerResponse deleteController(
        Function<DeleteControllerRequest.Builder, ObjectBuilder<DeleteControllerRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteController(fn.apply(new DeleteControllerRequest.Builder()).build());
    }

    // ----- Endpoint: ml.delete_memory

    /**
     * Delete a memory.
     */
    public DeleteMemoryResponse deleteMemory(DeleteMemoryRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, DeleteMemoryRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Delete a memory.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteMemoryRequest}
     */
    public final DeleteMemoryResponse deleteMemory(Function<DeleteMemoryRequest.Builder, ObjectBuilder<DeleteMemoryRequest>> fn)
        throws IOException, OpenSearchException {
        return deleteMemory(fn.apply(new DeleteMemoryRequest.Builder()).build());
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

    // ----- Endpoint: ml.get_all_memories

    /**
     * Get all memories.
     */
    public GetAllMemoriesResponse getAllMemories(GetAllMemoriesRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetAllMemoriesRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Get all memories.
     *
     * @param fn a function that initializes a builder to create the {@link GetAllMemoriesRequest}
     */
    public final GetAllMemoriesResponse getAllMemories(Function<GetAllMemoriesRequest.Builder, ObjectBuilder<GetAllMemoriesRequest>> fn)
        throws IOException, OpenSearchException {
        return getAllMemories(fn.apply(new GetAllMemoriesRequest.Builder()).build());
    }

    /**
     * Get all memories.
     */
    public final GetAllMemoriesResponse getAllMemories() throws IOException, OpenSearchException {
        return getAllMemories(new GetAllMemoriesRequest.Builder().build());
    }

    // ----- Endpoint: ml.get_all_messages

    /**
     * Get all messages in a memory.
     */
    public GetAllMessagesResponse getAllMessages(GetAllMessagesRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetAllMessagesRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Get all messages in a memory.
     *
     * @param fn a function that initializes a builder to create the {@link GetAllMessagesRequest}
     */
    public final GetAllMessagesResponse getAllMessages(Function<GetAllMessagesRequest.Builder, ObjectBuilder<GetAllMessagesRequest>> fn)
        throws IOException, OpenSearchException {
        return getAllMessages(fn.apply(new GetAllMessagesRequest.Builder()).build());
    }

    // ----- Endpoint: ml.get_connector

    /**
     * Retrieves a standalone connector.
     */
    public GetConnectorResponse getConnector(GetConnectorRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetConnectorRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Retrieves a standalone connector.
     *
     * @param fn a function that initializes a builder to create the {@link GetConnectorRequest}
     */
    public final GetConnectorResponse getConnector(Function<GetConnectorRequest.Builder, ObjectBuilder<GetConnectorRequest>> fn)
        throws IOException, OpenSearchException {
        return getConnector(fn.apply(new GetConnectorRequest.Builder()).build());
    }

    // ----- Endpoint: ml.get_controller

    /**
     * Retrieves a controller.
     */
    public GetControllerResponse getController(GetControllerRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetControllerRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Retrieves a controller.
     *
     * @param fn a function that initializes a builder to create the {@link GetControllerRequest}
     */
    public final GetControllerResponse getController(Function<GetControllerRequest.Builder, ObjectBuilder<GetControllerRequest>> fn)
        throws IOException, OpenSearchException {
        return getController(fn.apply(new GetControllerRequest.Builder()).build());
    }

    // ----- Endpoint: ml.get_memory

    /**
     * Get a memory.
     */
    public GetMemoryResponse getMemory(GetMemoryRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetMemoryRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Get a memory.
     *
     * @param fn a function that initializes a builder to create the {@link GetMemoryRequest}
     */
    public final GetMemoryResponse getMemory(Function<GetMemoryRequest.Builder, ObjectBuilder<GetMemoryRequest>> fn) throws IOException,
        OpenSearchException {
        return getMemory(fn.apply(new GetMemoryRequest.Builder()).build());
    }

    // ----- Endpoint: ml.get_message

    /**
     * Get a message.
     */
    public GetMessageResponse getMessage(GetMessageRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetMessageRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Get a message.
     *
     * @param fn a function that initializes a builder to create the {@link GetMessageRequest}
     */
    public final GetMessageResponse getMessage(Function<GetMessageRequest.Builder, ObjectBuilder<GetMessageRequest>> fn) throws IOException,
        OpenSearchException {
        return getMessage(fn.apply(new GetMessageRequest.Builder()).build());
    }

    // ----- Endpoint: ml.get_message_traces

    /**
     * Get a message traces.
     */
    public GetMessageTracesResponse getMessageTraces(GetMessageTracesRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetMessageTracesRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Get a message traces.
     *
     * @param fn a function that initializes a builder to create the {@link GetMessageTracesRequest}
     */
    public final GetMessageTracesResponse getMessageTraces(
        Function<GetMessageTracesRequest.Builder, ObjectBuilder<GetMessageTracesRequest>> fn
    ) throws IOException, OpenSearchException {
        return getMessageTraces(fn.apply(new GetMessageTracesRequest.Builder()).build());
    }

    // ----- Endpoint: ml.get_model

    /**
     * Retrieves a model.
     */
    public GetModelResponse getModel(GetModelRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetModelRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Retrieves a model.
     *
     * @param fn a function that initializes a builder to create the {@link GetModelRequest}
     */
    public final GetModelResponse getModel(Function<GetModelRequest.Builder, ObjectBuilder<GetModelRequest>> fn) throws IOException,
        OpenSearchException {
        return getModel(fn.apply(new GetModelRequest.Builder()).build());
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

    // ----- Endpoint: ml.get_profile

    /**
     * Get a profile.
     */
    public GetProfileResponse getProfile(GetProfileRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetProfileRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Get a profile.
     *
     * @param fn a function that initializes a builder to create the {@link GetProfileRequest}
     */
    public final GetProfileResponse getProfile(Function<GetProfileRequest.Builder, ObjectBuilder<GetProfileRequest>> fn) throws IOException,
        OpenSearchException {
        return getProfile(fn.apply(new GetProfileRequest.Builder()).build());
    }

    /**
     * Get a profile.
     */
    public final GetProfileResponse getProfile() throws IOException, OpenSearchException {
        return getProfile(new GetProfileRequest.Builder().build());
    }

    // ----- Endpoint: ml.get_profile_models

    /**
     * Get a profile models.
     */
    public GetProfileModelsResponse getProfileModels(GetProfileModelsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetProfileModelsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Get a profile models.
     *
     * @param fn a function that initializes a builder to create the {@link GetProfileModelsRequest}
     */
    public final GetProfileModelsResponse getProfileModels(
        Function<GetProfileModelsRequest.Builder, ObjectBuilder<GetProfileModelsRequest>> fn
    ) throws IOException, OpenSearchException {
        return getProfileModels(fn.apply(new GetProfileModelsRequest.Builder()).build());
    }

    /**
     * Get a profile models.
     */
    public final GetProfileModelsResponse getProfileModels() throws IOException, OpenSearchException {
        return getProfileModels(new GetProfileModelsRequest.Builder().build());
    }

    // ----- Endpoint: ml.get_profile_tasks

    /**
     * Get a profile tasks.
     */
    public GetProfileTasksResponse getProfileTasks(GetProfileTasksRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetProfileTasksRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Get a profile tasks.
     *
     * @param fn a function that initializes a builder to create the {@link GetProfileTasksRequest}
     */
    public final GetProfileTasksResponse getProfileTasks(Function<GetProfileTasksRequest.Builder, ObjectBuilder<GetProfileTasksRequest>> fn)
        throws IOException, OpenSearchException {
        return getProfileTasks(fn.apply(new GetProfileTasksRequest.Builder()).build());
    }

    /**
     * Get a profile tasks.
     */
    public final GetProfileTasksResponse getProfileTasks() throws IOException, OpenSearchException {
        return getProfileTasks(new GetProfileTasksRequest.Builder().build());
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

    // ----- Endpoint: ml.load_model

    /**
     * Deploys a model.
     */
    @Deprecated
    public LoadModelResponse loadModel(LoadModelRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, LoadModelRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Deploys a model.
     *
     * @param fn a function that initializes a builder to create the {@link LoadModelRequest}
     */
    @Deprecated
    public final LoadModelResponse loadModel(Function<LoadModelRequest.Builder, ObjectBuilder<LoadModelRequest>> fn) throws IOException,
        OpenSearchException {
        return loadModel(fn.apply(new LoadModelRequest.Builder()).build());
    }

    // ----- Endpoint: ml.register_agents

    /**
     * Register an agent.
     */
    public RegisterAgentsResponse registerAgents(RegisterAgentsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, RegisterAgentsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Register an agent.
     *
     * @param fn a function that initializes a builder to create the {@link RegisterAgentsRequest}
     */
    public final RegisterAgentsResponse registerAgents(Function<RegisterAgentsRequest.Builder, ObjectBuilder<RegisterAgentsRequest>> fn)
        throws IOException, OpenSearchException {
        return registerAgents(fn.apply(new RegisterAgentsRequest.Builder()).build());
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

    // ----- Endpoint: ml.register_model_meta

    /**
     * Registers model metadata.
     */
    public RegisterModelMetaResponse registerModelMeta(RegisterModelMetaRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, RegisterModelMetaRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Registers model metadata.
     *
     * @param fn a function that initializes a builder to create the {@link RegisterModelMetaRequest}
     */
    public final RegisterModelMetaResponse registerModelMeta(
        Function<RegisterModelMetaRequest.Builder, ObjectBuilder<RegisterModelMetaRequest>> fn
    ) throws IOException, OpenSearchException {
        return registerModelMeta(fn.apply(new RegisterModelMetaRequest.Builder()).build());
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

    /**
     * Undeploys a model.
     */
    public final UndeployModelResponse undeployModel() throws IOException, OpenSearchException {
        return undeployModel(new UndeployModelRequest.Builder().build());
    }

    // ----- Endpoint: ml.unload_model

    /**
     * Unloads a model.
     */
    @Deprecated
    public UnloadModelResponse unloadModel(UnloadModelRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, UnloadModelRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Unloads a model.
     *
     * @param fn a function that initializes a builder to create the {@link UnloadModelRequest}
     */
    @Deprecated
    public final UnloadModelResponse unloadModel(Function<UnloadModelRequest.Builder, ObjectBuilder<UnloadModelRequest>> fn)
        throws IOException, OpenSearchException {
        return unloadModel(fn.apply(new UnloadModelRequest.Builder()).build());
    }

    /**
     * Unloads a model.
     */
    @Deprecated
    public final UnloadModelResponse unloadModel() throws IOException, OpenSearchException {
        return unloadModel(new UnloadModelRequest.Builder().build());
    }

    // ----- Endpoint: ml.update_connector

    /**
     * Updates a standalone connector.
     */
    public UpdateConnectorResponse updateConnector(UpdateConnectorRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, UpdateConnectorRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Updates a standalone connector.
     *
     * @param fn a function that initializes a builder to create the {@link UpdateConnectorRequest}
     */
    public final UpdateConnectorResponse updateConnector(Function<UpdateConnectorRequest.Builder, ObjectBuilder<UpdateConnectorRequest>> fn)
        throws IOException, OpenSearchException {
        return updateConnector(fn.apply(new UpdateConnectorRequest.Builder()).build());
    }

    // ----- Endpoint: ml.update_controller

    /**
     * Updates a controller.
     */
    public UpdateControllerResponse updateController(UpdateControllerRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, UpdateControllerRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Updates a controller.
     *
     * @param fn a function that initializes a builder to create the {@link UpdateControllerRequest}
     */
    public final UpdateControllerResponse updateController(
        Function<UpdateControllerRequest.Builder, ObjectBuilder<UpdateControllerRequest>> fn
    ) throws IOException, OpenSearchException {
        return updateController(fn.apply(new UpdateControllerRequest.Builder()).build());
    }

    // ----- Endpoint: ml.update_memory

    /**
     * Update a memory.
     */
    public UpdateMemoryResponse updateMemory(UpdateMemoryRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, UpdateMemoryRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Update a memory.
     *
     * @param fn a function that initializes a builder to create the {@link UpdateMemoryRequest}
     */
    public final UpdateMemoryResponse updateMemory(Function<UpdateMemoryRequest.Builder, ObjectBuilder<UpdateMemoryRequest>> fn)
        throws IOException, OpenSearchException {
        return updateMemory(fn.apply(new UpdateMemoryRequest.Builder()).build());
    }

    // ----- Endpoint: ml.update_message

    /**
     * Update a message.
     */
    public UpdateMessageResponse updateMessage(UpdateMessageRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, UpdateMessageRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Update a message.
     *
     * @param fn a function that initializes a builder to create the {@link UpdateMessageRequest}
     */
    public final UpdateMessageResponse updateMessage(Function<UpdateMessageRequest.Builder, ObjectBuilder<UpdateMessageRequest>> fn)
        throws IOException, OpenSearchException {
        return updateMessage(fn.apply(new UpdateMessageRequest.Builder()).build());
    }

    // ----- Endpoint: ml.update_model

    /**
     * Updates a model.
     */
    public UpdateModelResponse updateModel(UpdateModelRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, UpdateModelRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Updates a model.
     *
     * @param fn a function that initializes a builder to create the {@link UpdateModelRequest}
     */
    public final UpdateModelResponse updateModel(Function<UpdateModelRequest.Builder, ObjectBuilder<UpdateModelRequest>> fn)
        throws IOException, OpenSearchException {
        return updateModel(fn.apply(new UpdateModelRequest.Builder()).build());
    }

    // ----- Endpoint: ml.update_model_group

    /**
     * Updates a model group.
     */
    public UpdateModelGroupResponse updateModelGroup(UpdateModelGroupRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, UpdateModelGroupRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Updates a model group.
     *
     * @param fn a function that initializes a builder to create the {@link UpdateModelGroupRequest}
     */
    public final UpdateModelGroupResponse updateModelGroup(
        Function<UpdateModelGroupRequest.Builder, ObjectBuilder<UpdateModelGroupRequest>> fn
    ) throws IOException, OpenSearchException {
        return updateModelGroup(fn.apply(new UpdateModelGroupRequest.Builder()).build());
    }

    // ----- Endpoint: ml.upload_chunk

    /**
     * Uploads model chunk.
     */
    public UploadChunkResponse uploadChunk(UploadChunkRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, UploadChunkRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Uploads model chunk.
     *
     * @param fn a function that initializes a builder to create the {@link UploadChunkRequest}
     */
    public final UploadChunkResponse uploadChunk(Function<UploadChunkRequest.Builder, ObjectBuilder<UploadChunkRequest>> fn)
        throws IOException, OpenSearchException {
        return uploadChunk(fn.apply(new UploadChunkRequest.Builder()).build());
    }

    // ----- Endpoint: ml.upload_model

    /**
     * Registers a model.
     */
    @Deprecated
    public UploadModelResponse uploadModel(UploadModelRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, UploadModelRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Registers a model.
     *
     * @param fn a function that initializes a builder to create the {@link UploadModelRequest}
     */
    @Deprecated
    public final UploadModelResponse uploadModel(Function<UploadModelRequest.Builder, ObjectBuilder<UploadModelRequest>> fn)
        throws IOException, OpenSearchException {
        return uploadModel(fn.apply(new UploadModelRequest.Builder()).build());
    }
}
