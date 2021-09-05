FROM openjdk:12-jdk-alpine
LABEL maintainer=raman257<257ramanrb@gmail.com>
ADD ./out/artifacts/the_game_of_dice_jar/the-game-of-dice.jar the-game-of-dice.jar
ENTRYPOINT ["java", "-jar", "the-game-of-dice.jar"]
