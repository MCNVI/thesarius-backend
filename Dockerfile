# creates build image with only dependencies,
# it relies on caching for pom.xml won't be changed often
FROM maven:3.6-jdk-11-slim AS build-deps
# copy pom
RUN mkdir -p /usr/src/app
COPY pom.xml /usr/src/app/pom.xml
WORKDIR /usr/src/app
# download dependencies
# RUN mvn -T 1C dependency:resolve dependency:resolve-plugins
# RUN mvn versions:commit

# creates build image and builds target
FROM build-deps AS build
# copy sources
COPY src /usr/src/app/src
WORKDIR /usr/src/app
ARG VERSION
ENV VERSION=$VERSION
RUN mvn versions:set -DnewVersion=$VERSION
RUN mvn -T 1C package -Dmaven.test.skip=true

# creates runtime
FROM adoptopenjdk/openjdk11:alpine-jre
COPY --from=build /usr/src/app/target/greekthesarius*.jar /app.jar
CMD ["java", "-jar", "/app.jar"]

