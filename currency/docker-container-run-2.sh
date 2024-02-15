#!/bin/bash
docker run -it --name currency-2 -p 8087:8085 -h currency-2 \
    -e EUREKA_HOST="172.17.0.1" \
    -d currency
