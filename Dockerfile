FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8080
ADD target/chordcharter-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
HEALTHCHECK --interval=5s --timeout=2s --retries=12 \
  CMD curl --silent --fail localhost:8080/actuator/health || exit 1