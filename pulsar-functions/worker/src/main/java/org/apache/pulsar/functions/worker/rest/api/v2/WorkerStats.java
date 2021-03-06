/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.pulsar.functions.worker.rest.api.v2;

import java.io.IOException;
import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.pulsar.functions.proto.InstanceCommunication.Metrics;
import org.apache.pulsar.functions.worker.rest.FunctionApiResource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Path("/worker-stats")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Api(value = "/worker-stats", description = "Workers admin api", tags = "workers")
public class WorkerStats extends FunctionApiResource {

    @GET
    @Path("/functions")
    @ApiOperation(value = "Get stats for all functions owned by worker", notes = "Request should be executed by Monitoring agent on each worker to fetch the function-metrics", response = Metrics.class)
    @ApiResponses(value = { @ApiResponse(code = 401, message = "Don't have admin permission"),
            @ApiResponse(code = 503, message = "Worker service is not running") })
    public Response getStats() throws IOException {
        return functions.getFunctionsMetrcis(clientAppId());
    }
    
    @GET
    @Path("/metrics")
    @ApiOperation(value = "Gets the metrics for Monitoring", notes = "Request should be executed by Monitoring agent on each worker to fetch the worker-metrics", response = org.apache.pulsar.common.stats.Metrics.class, responseContainer = "List")
    @ApiResponses(value = { @ApiResponse(code = 401, message = "Don't have admin permission") })
    public Collection<org.apache.pulsar.common.stats.Metrics> getMetrics() throws Exception {
        return functions.getWorkerMetrcis(clientAppId());
    }
}
