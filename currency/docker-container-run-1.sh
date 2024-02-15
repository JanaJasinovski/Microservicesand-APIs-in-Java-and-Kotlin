#!/bin/bash
docker run -it --name currency-1 -p 8086:8085 -h currency-1 \
    -e EUREKA_HOST="172.17.0.1" \
    -d currency
