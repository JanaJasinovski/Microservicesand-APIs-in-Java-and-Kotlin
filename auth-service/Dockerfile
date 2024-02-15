FROM openjdk:21
ADD target/*.jar app.jar

ENV EUREKA_HOST=localhost
ENV ZIPKIN_HOST=localhost
ENV LOGSTASH_HOST=localhost

ENV JAVA_OPTS="-Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8797,suspend=n"

EXPOSE 9000

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Dspring.profiles.active=cloud \
    -jar /app.jar -jar /app.jar \
    --cloud.eureka-host=$EUREKA_HOST --cloud.zipkin-host=$ZIPKIN_HOST --cloud.logstash-host=$LOGSTASH_HOST \
    "]
