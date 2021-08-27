FROM amazon/opendistro-for-elasticsearch:latest

ARG elasticsearch_path=/usr/share/elasticsearch

ARG SECURE_INTEGRATION

RUN if [ "$SECURE_INTEGRATION" != "true" ] ; then $elasticsearch_path/bin/elasticsearch-plugin remove opendistro_security; fi

COPY --chown=elasticsearch:elasticsearch .ci/opendistro/elasticsearch.yml /usr/share/elasticsearch/config/
