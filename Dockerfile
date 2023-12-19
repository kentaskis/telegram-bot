FROM adoptopenjdk/openjdk16
ARG JAR_FILE=target/*.jar
ENV BOT_NAME=test_333_tg_bot
ENV BOT_TOKEN=6909399004:AAEPd9ATHHkuE__HIUvfMK5SMnQU4KBGsmM
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Dbot.username=${BOT_NAME}", "-Dbot.token=${BOT_TOKEN}","-jar","/app.jar"]