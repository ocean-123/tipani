# Use an official OpenJDK runtime as a parent image
FROM openjdk:19-jdk

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container at /app
COPY target/tipani-0.0.1-SNAPSHOT.jar /app/tipani.jar

# Make port 8080 available to the world outside this container
EXPOSE 8088

# Run the JAR file
ENTRYPOINT ["java", "-jar", "tipani.jar"]
