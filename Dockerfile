FROM openjdk:1.8.0-skywalking
ADD target/*.jar app.jar
COPY docker-entrypoint.sh /
RUN mkdir -p /var/logs/xian && chmod 777 /docker-entrypoint.sh
ENTRYPOINT ["sh","/docker-entrypoint.sh"]