FROM openjdk:21
ADD target/*.jar app.jar

ENV EUREKA_HOST=localhost
ENV LOGSTASH_HOST=localhost
ENV ZIPKIN_HOST=localhost
ENV CFG_HOST=localhost

ENV JAVA_OPTS="-Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8787,suspend=n"

EXPOSE 8085 8787

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Duser.country=RU -Duser.language=ru -Dspring.profiles.active=cloud \
    -jar /app.jar \
    --cloud.eureka-host=$EUREKA_HOST --cloud.logstash-host=$LOGSTASH_HOST \
    --cloud.zipkin-host=$ZIPKIN_HOST --cloud.config-host = $CFG_HOST\
    " ]