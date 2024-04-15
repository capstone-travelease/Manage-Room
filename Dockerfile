FROM openjdk:21

VOLUME /tmp

COPY target/*.jar manage-room-0.0.1-SNAPSHOT.jar

EXPOSE 2301
ENTRYPOINT ["java","-jar","/manage-room-0.0.1-SNAPSHOT.jar"]