# Start with a base image containing Java runtime (Here we are using OpenJDK)
FROM openjdk:17-alpine

# Add Maintainer Info
LABEL maintainer="akin@pdvlx.com"

# Add a volume pointing to /tmp (Optional)
VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8080

# The application's jar file (Change the path accordingly based on your Maven build)
ARG JAR_FILE=target/masraftakip.jar

# Add the application's jar to the container
#ADD ${JAR_FILE} masraftakip.jar
ADD target/masraftakip.jar masraftakip.jar
#COPY db/migration/ /db/migration/
# Run the jar file 
#ENTRYPOINT ["java","-jar","/masraftakip.jar"]
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/masraftakip.jar"]

