FROM openjdk

WORKDIR /app

COPY target/sorteio-mega-0.0.1-SNAPSHOT.jar /app/sorteio-mega.jar

ENTRYPOINT ["java", "-jar", "sorteio-mega.jar"]
