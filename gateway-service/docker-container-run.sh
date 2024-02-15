#!/bin/bash
docker run -it --name gateway-service -p 8080:8080 \
  --link currency-1:currency-1 --link currency-2:currency-2 \
  -e EUREKA_HOST="172.17.0.1" \
  -e PROCESSING_URL="http://172.17.0.1:8090" \
  -e HISTORY_URL="http://172.17.0.1:8010" \
  -e CURRENCY_URL="lb://currency" \
  -e AUTH_URL="http://172.17.0.1:9000" \
  -d gateway-service
