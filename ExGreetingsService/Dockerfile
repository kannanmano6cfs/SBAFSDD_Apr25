#Open JDk for Container Image
From openjdk:21-slim

#Set intermediate working directory
WORKDIR /app


#Copy the Source and dependency
COPY target/ExGreetingsService-0.0.1-SNAPSHOT.jar app.jar

#Expose the port number
EXPOSE 8080

#Run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]
