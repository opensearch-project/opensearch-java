#!/bin/bash
# ─────────────────────────────────────────────────────────────────────────────
# gRPC Integration Test Validation Script
#
# Runs an OpenSearch 3.5+ container with gRPC enabled, then executes the
# integration tests against it.
#
# Usage:
#   ./validate-grpc-integration.sh
#
# Requirements:
#   - Docker running
#   - Java 21+ (for integration tests)
#   - Gradle wrapper in project root
#
# Environment variables (optional):
#   OPENSEARCH_VERSION  — OpenSearch version to test (default: 3.5.0)
#   GRPC_PORT           — gRPC port to expose (default: 9400)
#   REST_PORT           — REST port to expose (default: 9200)
#   KEEP_CONTAINER      — set to "true" to keep container running after tests
# ─────────────────────────────────────────────────────────────────────────────

set -e

OPENSEARCH_VERSION="${OPENSEARCH_VERSION:-3.5.0}"
GRPC_PORT="${GRPC_PORT:-9400}"
REST_PORT="${REST_PORT:-9200}"
CONTAINER_NAME="opensearch-grpc-test"
IMAGE="opensearchproject/opensearch:${OPENSEARCH_VERSION}"

echo "═══════════════════════════════════════════════════════════════"
echo "  gRPC Integration Test Validation"
echo "  OpenSearch Version: ${OPENSEARCH_VERSION}"
echo "  REST Port: ${REST_PORT}"
echo "  gRPC Port: ${GRPC_PORT}"
echo "═══════════════════════════════════════════════════════════════"

# ─── Cleanup any existing container ──────────────────────────────────────────
echo ""
echo "▶ Cleaning up any existing container..."
docker rm -f ${CONTAINER_NAME} 2>/dev/null || true

# ─── Start OpenSearch with gRPC enabled ──────────────────────────────────────
echo ""
echo "▶ Starting OpenSearch ${OPENSEARCH_VERSION} with gRPC transport..."
docker run -d \
  --name ${CONTAINER_NAME} \
  -p ${REST_PORT}:9200 \
  -p ${GRPC_PORT}:9400 \
  -e "discovery.type=single-node" \
  -e "plugins.security.disabled=true" \
  -e "aux.transport.types=transport-grpc" \
  -e "aux.transport.transport-grpc.port=9400" \
  -e "OPENSEARCH_INITIAL_ADMIN_PASSWORD=admin" \
  -e "cluster.routing.allocation.disk.threshold_enabled=false" \
  ${IMAGE}

# ─── Wait for cluster to be ready ────────────────────────────────────────────
echo ""
echo "▶ Waiting for OpenSearch to be ready..."
MAX_RETRIES=30
RETRY_INTERVAL=3
for i in $(seq 1 $MAX_RETRIES); do
  if curl -s "http://localhost:${REST_PORT}/_cluster/health" | grep -q '"status"'; then
    echo "  ✓ OpenSearch is ready!"
    break
  fi
  if [ $i -eq $MAX_RETRIES ]; then
    echo "  ✗ OpenSearch failed to start after ${MAX_RETRIES} attempts"
    docker logs ${CONTAINER_NAME} | tail -30
    docker rm -f ${CONTAINER_NAME}
    exit 1
  fi
  echo "  Waiting... (attempt $i/$MAX_RETRIES)"
  sleep $RETRY_INTERVAL
done

# ─── Verify gRPC port is listening ───────────────────────────────────────────
echo ""
echo "▶ Verifying gRPC port ${GRPC_PORT} is open..."
if nc -z localhost ${GRPC_PORT} 2>/dev/null; then
  echo "  ✓ gRPC port is open!"
else
  echo "  ⚠ gRPC port not responding (nc check failed, may still work)"
fi

# ─── Show cluster info ────────────────────────────────────────────────────────
echo ""
echo "▶ Cluster info:"
curl -s "http://localhost:${REST_PORT}" | python3 -m json.tool 2>/dev/null || curl -s "http://localhost:${REST_PORT}"
echo ""

# ─── Run integration tests ───────────────────────────────────────────────────
echo ""
echo "═══════════════════════════════════════════════════════════════"
echo "  Running Integration Tests"
echo "═══════════════════════════════════════════════════════════════"
echo ""

# Run the gRPC integration tests
./gradlew :java-client:integrationTest \
  --tests "org.opensearch.client.opensearch.integTest.grpc.*" \
  -Dtests.rest.cluster=localhost:${REST_PORT} \
  -Dtests.grpc.cluster=localhost:${GRPC_PORT} \
  -Dtests.opensearch.version=${OPENSEARCH_VERSION} \
  -Dtests.opensearch.testcontainers.enabled=false \
  -Dhttps=false \
  -Duser=admin \
  -Dpassword=admin \
  --info 2>&1 | tee /tmp/grpc-integration-test.log

TEST_EXIT_CODE=${PIPESTATUS[0]}

# ─── Results ──────────────────────────────────────────────────────────────────
echo ""
echo "═══════════════════════════════════════════════════════════════"
if [ $TEST_EXIT_CODE -eq 0 ]; then
  echo "  ✓ ALL INTEGRATION TESTS PASSED"
else
  echo "  ✗ INTEGRATION TESTS FAILED (exit code: ${TEST_EXIT_CODE})"
  echo ""
  echo "  Test report: java-client/build/reports/tests/integrationTest/index.html"
  echo "  Full log: /tmp/grpc-integration-test.log"
fi
echo "═══════════════════════════════════════════════════════════════"

# ─── Also run unit tests for sanity ──────────────────────────────────────────
echo ""
echo "▶ Running unit tests (sanity check)..."
./gradlew :java-client:test --tests "org.opensearch.client.transport.grpc.*" 2>&1 | tail -5

# ─── Cleanup ──────────────────────────────────────────────────────────────────
if [ "${KEEP_CONTAINER}" != "true" ]; then
  echo ""
  echo "▶ Stopping container..."
  docker rm -f ${CONTAINER_NAME}
  echo "  ✓ Container removed"
else
  echo ""
  echo "▶ Container left running (KEEP_CONTAINER=true)"
  echo "  REST: http://localhost:${REST_PORT}"
  echo "  gRPC: localhost:${GRPC_PORT}"
  echo "  Stop with: docker rm -f ${CONTAINER_NAME}"
fi

echo ""
exit $TEST_EXIT_CODE
