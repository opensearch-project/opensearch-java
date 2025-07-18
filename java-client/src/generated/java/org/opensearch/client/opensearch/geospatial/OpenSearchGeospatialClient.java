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

package org.opensearch.client.opensearch.geospatial;

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
 * Client for the geospatial namespace.
 */
@Generated("org.opensearch.client.codegen.CodeGenerator")
public class OpenSearchGeospatialClient extends ApiClient<OpenSearchTransport, OpenSearchGeospatialClient> {
    public OpenSearchGeospatialClient(OpenSearchTransport transport) {
        super(transport, null);
    }

    public OpenSearchGeospatialClient(OpenSearchTransport transport, @Nullable TransportOptions transportOptions) {
        super(transport, transportOptions);
    }

    @Override
    public OpenSearchGeospatialClient withTransportOptions(@Nullable TransportOptions transportOptions) {
        return new OpenSearchGeospatialClient(this.transport, transportOptions);
    }

    // ----- Endpoint: geospatial.delete_ip2geo_datasource

    /**
     * Delete a specific IP2Geo data source.
     */
    public DeleteIp2geoDatasourceResponse deleteIp2geoDatasource(DeleteIp2geoDatasourceRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequest(request, DeleteIp2geoDatasourceRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Delete a specific IP2Geo data source.
     *
     * @param fn a function that initializes a builder to create the {@link DeleteIp2geoDatasourceRequest}
     */
    public final DeleteIp2geoDatasourceResponse deleteIp2geoDatasource(
        Function<DeleteIp2geoDatasourceRequest.Builder, ObjectBuilder<DeleteIp2geoDatasourceRequest>> fn
    ) throws IOException, OpenSearchException {
        return deleteIp2geoDatasource(fn.apply(new DeleteIp2geoDatasourceRequest.Builder()).build());
    }

    // ----- Endpoint: geospatial.geojson_upload_post

    /**
     * <p>
     * Use an OpenSearch query to upload <code>GeoJSON</code>, operation will fail if index exists.
     * </p>
     * <ul>
     * <li>When type is <code>geo_point</code>, only Point geometry is allowed</li>
     * <li>When type is <code>geo_shape</code>, all geometry types are allowed (Point, MultiPoint, LineString, MultiLineString, Polygon,
     * MultiPolygon, GeometryCollection, Envelope).</li>
     * </ul>
     */
    public GeojsonUploadPostResponse geojsonUploadPost(GeojsonUploadPostRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GeojsonUploadPostRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Use an OpenSearch query to upload <code>GeoJSON</code>, operation will fail if index exists.
     * </p>
     * <ul>
     * <li>When type is <code>geo_point</code>, only Point geometry is allowed</li>
     * <li>When type is <code>geo_shape</code>, all geometry types are allowed (Point, MultiPoint, LineString, MultiLineString, Polygon,
     * MultiPolygon, GeometryCollection, Envelope).</li>
     * </ul>
     *
     * @param fn a function that initializes a builder to create the {@link GeojsonUploadPostRequest}
     */
    public final GeojsonUploadPostResponse geojsonUploadPost(
        Function<GeojsonUploadPostRequest.Builder, ObjectBuilder<GeojsonUploadPostRequest>> fn
    ) throws IOException, OpenSearchException {
        return geojsonUploadPost(fn.apply(new GeojsonUploadPostRequest.Builder()).build());
    }

    // ----- Endpoint: geospatial.geojson_upload_put

    /**
     * <p>
     * Use an OpenSearch query to upload <code>GeoJSON</code> regardless if index exists.
     * </p>
     * <ul>
     * <li>When type is <code>geo_point</code>, only Point geometry is allowed</li>
     * <li>When type is <code>geo_shape</code>, all geometry types are allowed (Point, MultiPoint, LineString, MultiLineString, Polygon,
     * MultiPolygon, GeometryCollection, Envelope).</li>
     * </ul>
     */
    public GeojsonUploadPutResponse geojsonUploadPut(GeojsonUploadPutRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GeojsonUploadPutRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Use an OpenSearch query to upload <code>GeoJSON</code> regardless if index exists.
     * </p>
     * <ul>
     * <li>When type is <code>geo_point</code>, only Point geometry is allowed</li>
     * <li>When type is <code>geo_shape</code>, all geometry types are allowed (Point, MultiPoint, LineString, MultiLineString, Polygon,
     * MultiPolygon, GeometryCollection, Envelope).</li>
     * </ul>
     *
     * @param fn a function that initializes a builder to create the {@link GeojsonUploadPutRequest}
     */
    public final GeojsonUploadPutResponse geojsonUploadPut(
        Function<GeojsonUploadPutRequest.Builder, ObjectBuilder<GeojsonUploadPutRequest>> fn
    ) throws IOException, OpenSearchException {
        return geojsonUploadPut(fn.apply(new GeojsonUploadPutRequest.Builder()).build());
    }

    // ----- Endpoint: geospatial.get_ip2geo_datasource

    /**
     * Get one or more IP2Geo data sources, defaulting to returning all if no names specified.
     */
    public GetIp2geoDatasourceResponse getIp2geoDatasource(GetIp2geoDatasourceRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetIp2geoDatasourceRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Get one or more IP2Geo data sources, defaulting to returning all if no names specified.
     *
     * @param fn a function that initializes a builder to create the {@link GetIp2geoDatasourceRequest}
     */
    public final GetIp2geoDatasourceResponse getIp2geoDatasource(
        Function<GetIp2geoDatasourceRequest.Builder, ObjectBuilder<GetIp2geoDatasourceRequest>> fn
    ) throws IOException, OpenSearchException {
        return getIp2geoDatasource(fn.apply(new GetIp2geoDatasourceRequest.Builder()).build());
    }

    /**
     * Get one or more IP2Geo data sources, defaulting to returning all if no names specified.
     */
    public final GetIp2geoDatasourceResponse getIp2geoDatasource() throws IOException, OpenSearchException {
        return getIp2geoDatasource(new GetIp2geoDatasourceRequest.Builder().build());
    }

    // ----- Endpoint: geospatial.get_upload_stats

    /**
     * Retrieves statistics for all geospatial uploads.
     */
    public GetUploadStatsResponse getUploadStats(GetUploadStatsRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, GetUploadStatsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Retrieves statistics for all geospatial uploads.
     *
     * @param fn a function that initializes a builder to create the {@link GetUploadStatsRequest}
     */
    public final GetUploadStatsResponse getUploadStats(Function<GetUploadStatsRequest.Builder, ObjectBuilder<GetUploadStatsRequest>> fn)
        throws IOException, OpenSearchException {
        return getUploadStats(fn.apply(new GetUploadStatsRequest.Builder()).build());
    }

    /**
     * Retrieves statistics for all geospatial uploads.
     */
    public final GetUploadStatsResponse getUploadStats() throws IOException, OpenSearchException {
        return getUploadStats(new GetUploadStatsRequest.Builder().build());
    }

    // ----- Endpoint: geospatial.put_ip2geo_datasource

    /**
     * <p>
     * Create a specific IP2Geo data source. Default values:
     * </p>
     * <ul>
     * <li><code>endpoint</code>: <code>&quot;https://geoip.maps.opensearch.org/v1/geolite2-city/manifest.json&quot;</code></li>
     * <li><code>update_interval_in_days</code>: 3.</li>
     * </ul>
     */
    public PutIp2geoDatasourceResponse putIp2geoDatasource(PutIp2geoDatasourceRequest request) throws IOException, OpenSearchException {
        return this.transport.performRequest(request, PutIp2geoDatasourceRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * <p>
     * Create a specific IP2Geo data source. Default values:
     * </p>
     * <ul>
     * <li><code>endpoint</code>: <code>&quot;https://geoip.maps.opensearch.org/v1/geolite2-city/manifest.json&quot;</code></li>
     * <li><code>update_interval_in_days</code>: 3.</li>
     * </ul>
     *
     * @param fn a function that initializes a builder to create the {@link PutIp2geoDatasourceRequest}
     */
    public final PutIp2geoDatasourceResponse putIp2geoDatasource(
        Function<PutIp2geoDatasourceRequest.Builder, ObjectBuilder<PutIp2geoDatasourceRequest>> fn
    ) throws IOException, OpenSearchException {
        return putIp2geoDatasource(fn.apply(new PutIp2geoDatasourceRequest.Builder()).build());
    }

    // ----- Endpoint: geospatial.put_ip2geo_datasource_settings

    /**
     * Update a specific IP2Geo data source.
     */
    public PutIp2geoDatasourceSettingsResponse putIp2geoDatasourceSettings(PutIp2geoDatasourceSettingsRequest request) throws IOException,
        OpenSearchException {
        return this.transport.performRequest(request, PutIp2geoDatasourceSettingsRequest._ENDPOINT, this.transportOptions);
    }

    /**
     * Update a specific IP2Geo data source.
     *
     * @param fn a function that initializes a builder to create the {@link PutIp2geoDatasourceSettingsRequest}
     */
    public final PutIp2geoDatasourceSettingsResponse putIp2geoDatasourceSettings(
        Function<PutIp2geoDatasourceSettingsRequest.Builder, ObjectBuilder<PutIp2geoDatasourceSettingsRequest>> fn
    ) throws IOException, OpenSearchException {
        return putIp2geoDatasourceSettings(fn.apply(new PutIp2geoDatasourceSettingsRequest.Builder()).build());
    }
}
