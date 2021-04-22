FROM azul/zulu-openjdk-alpine:11 as builder

WORKDIR /app

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

RUN java -Djarmode=layertools -jar app.jar extract

FROM azul/zulu-openjdk-alpine:11
WORKDIR /app

COPY --from=builder app/dependencies/ ./
COPY --from=builder app/snapshot-dependencies/ ./
COPY --from=builder app/spring-boot-loader/ ./
COPY --from=builder app/application/ ./
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]
