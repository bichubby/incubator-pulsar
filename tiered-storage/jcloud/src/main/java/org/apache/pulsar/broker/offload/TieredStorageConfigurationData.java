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
package org.apache.pulsar.broker.offload;

import java.io.Serializable;
import lombok.Data;

/**
 * Configuration for tiered storage.
 */
@Data
public class TieredStorageConfigurationData implements Serializable, Cloneable{

    /**** --- Ledger Offloading --- ****/
    // Driver to use to offload old data to long term storage
    private String managedLedgerOffloadDriver = null;

    // Maximum number of thread pool threads for ledger offloading
    private int managedLedgerOffloadMaxThreads = 2;

    // For Amazon S3 ledger offload, AWS region
    private String s3ManagedLedgerOffloadRegion = null;

    // For Amazon S3 ledger offload, Bucket to place offloaded ledger into
    private String s3ManagedLedgerOffloadBucket = null;

    // For Amazon S3 ledger offload, Alternative endpoint to connect to (useful for testing)
    private String s3ManagedLedgerOffloadServiceEndpoint = null;

    // For Amazon S3 ledger offload, Max block size in bytes.
    private int s3ManagedLedgerOffloadMaxBlockSizeInBytes = 64 * 1024 * 1024; // 64MB

    // For Amazon S3 ledger offload, Read buffer size in bytes.
    private int s3ManagedLedgerOffloadReadBufferSizeInBytes = 1024 * 1024; // 1MB

    // For Google Cloud Storage ledger offload, region where offload bucket is located.
    // reference this page for more details: https://cloud.google.com/storage/docs/bucket-locations
    private String gcsManagedLedgerOffloadRegion = null;

    // For Google Cloud Storage ledger offload, Bucket to place offloaded ledger into
    private String gcsManagedLedgerOffloadBucket = null;

    // For Google Cloud Storage ledger offload, Max block size in bytes.
    private int gcsManagedLedgerOffloadMaxBlockSizeInBytes = 64 * 1024 * 1024; // 64MB

    // For Google Cloud Storage ledger offload, Read buffer size in bytes.
    private int gcsManagedLedgerOffloadReadBufferSizeInBytes = 1024 * 1024; // 1MB

    // For Google Cloud Storage, path to json file containing service account credentials.
    // For more details, see the "Service Accounts" section of https://support.google.com/googleapi/answer/6158849
    private String gcsManagedLedgerOffloadServiceAccountKeyFile = null;

}
