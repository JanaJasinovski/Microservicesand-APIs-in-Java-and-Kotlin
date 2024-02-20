#!/bin/bash
docker run -it --name currency-rate-service-2 -p 8087:8085 -h currency-rate-service-2 \
    -e EUREKA_HOST="172.17.0.1" -e LOGSTASH_HOST="172.17.0.1" -e ZIPKIN_HOST="172.17.0.2" -e CFG_HOST="172.17.0.1" \
    -d currency-rate-service
