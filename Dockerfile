FROM openjdk:17
EXPOSE 8080
ADD target/Task-Tracker.jar Task-Tracker.jar 
ENTRYPOINT ["java","-jar","/Task-Tracker.jar"]
