package org.opensearch.client.opensearch.integTest.aws;

import org.junit.Test;
import org.opensearch.client.opensearch.OpenSearchClient;
import org.opensearch.client.opensearch._types.OpenSearchException;
import org.opensearch.client.opensearch.cluster.GetClusterSettingsRequest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;

public class AwsSdk2SecurityIT extends AwsSdk2TransportTestCase {
    private static final String DEFAULT_MESSAGE = "authentication/authorization failure";
    @Test
    public void testUnAuthorizedException() {
        final OpenSearchClient client = getClient(false, null, null);
        final GetClusterSettingsRequest request = new GetClusterSettingsRequest.Builder()
                .includeDefaults(true)
                .build();
        final OpenSearchException ex = assertThrows(
                OpenSearchException.class, () -> client.cluster().getSettings(request));
        assertFalse(ex.getMessage().contains(DEFAULT_MESSAGE));
    }
}
