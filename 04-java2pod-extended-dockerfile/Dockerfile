FROM registry.access.redhat.com/ubi8/openjdk-17:1.14
COPY target/*-runner.jar /deployments/quarkus-run.jar
EXPOSE 8080
USER 185
ENV JAVA_OPTS="-Dquarkus.http.host=0.0.0.0 -Djava.util.logging.manager=org.jboss.logmanager.LogManager"
ENV JAVA_APP_JAR="/deployments/java2pod-1.0.0-SNAPSHOT-runner.jar"