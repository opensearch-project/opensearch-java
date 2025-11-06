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

package org.opensearch.client.opensearch.ism;

import org.junit.Test;
import org.opensearch.client.opensearch.model.ModelTestCase;

public class PolicyRequestTest extends ModelTestCase {

    @Test
    public void testPolicySerialization() {
        Policy policy = fromJson(jsonWithoutIsmTemplateAndErrorNotification, Policy.class);
        assertEquals("ism-test-policy", policy.policyId());
        assertNotNull(policy.lastUpdatedTime());
        assertEquals(1762418442921L, policy.lastUpdatedTime().longValue());
        assertEquals(2, policy.states().size());
        assertNull(policy.errorNotification());
    }

    String jsonWithoutIsmTemplateAndErrorNotification = """
{
    "policy_id": "ism-test-policy",
    "description": "Test Policy",
    "last_updated_time": 1762418442921,
    "schema_version": 21,
    "error_notification": null,
    "default_state": "transition",
    "states": [
      {
        "name": "transition",
        "actions": [],
        "transitions": [
          {
            "state_name": "delete",
            "conditions": {
              "min_index_age": "1d"
            }
          }
        ]
      },
      {
        "name": "delete",
        "actions": [
          {
            "retry": {
              "count": 3,
              "backoff": "exponential",
              "delay": "1s"
            },
            "delete": {}
          }
        ],
        "transitions": []
      }
    ],
    "ism_template": null
}
      """;


}
