FROM maven AS build
COPY . /build/
WORKDIR /build/
RUN ["mvn", "package", "-DskipTests"]

FROM adoptopenjdk/openjdk11:alpine-jre
COPY --from=build /build/target/*.jar /var/visits/Application.jar
WORKDIR /var/visits/
CMD ["java", "-jar", "-Dspring.profiles.active=docker", "Application.jar"]
EXPOSE 8080
