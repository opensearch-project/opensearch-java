ARG OPENSEARCH_VERSION
FROM opensearchproject/opensearch:$OPENSEARCH_VERSION

ARG opensearch_path=/usr/share/opensearch
ARG opensearch_yml=$opensearch_path/config/opensearch.yml

ARG SECURE_INTEGRATION
ENV OPENSEARCH_INITIAL_ADMIN_PASSWORD=0_aD^min_0

# Copy custom opensearch.yml with gRPC transport configuration
COPY opensearch.yml $opensearch_yml

RUN if [ "$SECURE_INTEGRATION" != "true" ] ; then echo "plugins.security.disabled: true" >> $opensearch_yml; fi
