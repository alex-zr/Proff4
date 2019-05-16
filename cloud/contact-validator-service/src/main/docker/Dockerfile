# mvn package docker:build

# Start with a base image containing Java runtime
FROM java:8
# Add a volume pointing to /tmp
VOLUME /tmp
# Make port 8080 available to the world outside this container
EXPOSE 8080
WORKDIR /tmp

# The application's jar file
ARG JAR_FILE=contact-validator-1.0-SNAPSHOT.jar
# Add the application's jar to the container
ADD ${JAR_FILE} app.jar
# Run the jar file
ENTRYPOINT ["java","-jar","app.jar"]