FROM registry.access.redhat.com/ubi8/openjdk-17-runtime:latest
COPY target/*-runner.jar /deployments/quarkus-run.jar
EXPOSE 8080
USER 185
ENV JAVA_OPTS="-Dquarkus.http.host=0.0.0.0 -Djava.util.logging.manager=org.jboss.logmanager.LogManager"
ENV JAVA_APP_JAR="/deployments/quarkus-run.jar"