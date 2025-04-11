#Open JDK for container Image
From openjdk:21-slim

#Set intermediate working directory
WORKDIR /app

#Copy the Source code and dependency (from and to different name(app.war))
COPY target/otpapi-0.0.1-SNAPSHOT.jar otpapi.jar

#Expose the port number
EXPOSE 8080

#Run the jar file
ENTRYPOINT ["java","-jar","otpapi.jar"]