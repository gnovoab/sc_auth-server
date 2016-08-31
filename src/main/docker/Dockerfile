FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD auth-server.jar app.jar
RUN sh -c 'touch /app.jar'
EXPOSE 8899
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]