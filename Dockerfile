FROM maven AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -e -f /usr/src/app/pom.xml clean package

FROM openjdk
COPY --from=build /usr/src/app/target/iot-0.0.1-SNAPSHOT.jar /usr/app/iot-0.0.1-SNAPSHOT.jar 
EXPOSE 80
ENTRYPOINT ["java","-jar","/usr/app/iot-0.0.1-SNAPSHOT.jar"]