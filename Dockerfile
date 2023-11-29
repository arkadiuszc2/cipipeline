FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
EXPOSE 8080
COPY cipipeline-app.jar cipipeline-app.jar
ENTRYPOINT ["java","-jar","/cipipeline-app.jar"]