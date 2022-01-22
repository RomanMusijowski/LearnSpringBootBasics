FROM adoptopenjdk/openjdk11

ENV JAVA_OPTS=""

COPY target/LearnSpringBasics-0.0.1-SNAPSHOT.jar /opt/lib/

EXPOSE 8080
CMD ["java", "-jar", "/opt/lib/LearnSpringBasics-0.0.1-SNAPSHOT.jar"]
