# The Game of Dice

[![Language](https://img.shields.io/badge/Made_with-Java-orange.svg?style=flat-square&logo=java)](#)
[![Linkedin](https://img.shields.io/badge/Contact-@257ramanrb-blue.svg?style=flat-square&logo=linkedin)](https://www.linkedin.com/in/257ramanrb/)

The "Game of Dice" is a multiplayer game where N players roll a 6 faced dice in a round-robin fashion. Each time a player rolls the dice their points increase by the number (1 to 6) achieved by the roll. As soon as a player accumulates M points they complete the game and are assigned a rank. Remaining players continue to play the game till they accumulate at least M points.

## Steps to run

### Using Docker
``` 
docker run -it raman257/the-game-of-dice:0.1.0 <num-of-players> <target-score> 
```

Example:
``` 
docker run -it raman257/the-game-of-dice:0.1.0 3 10 
```

### Using JAR
 1. Go to [Releases](https://github.com/257ramanrb/the-game-of-dice/releases) section of this repository 
 2. Select latest release
 3. Under Assets, download `the-game-of-dice.jar`
 4. Execute below command on CMD in the directory containing downloaded JAR:
 
 ``` 
 java -jar the-game-of-dice.jar <num-of-players> <target-score> 
 ``` 
 
 Example: 
 ``` 
 java -jar the-game-of-dice.jar 3 10 
 ``` 
 
 ### Using IDE
 1. Clone the repository
 2. Run the main class: `BoardGames`

## Contributors
[![Contributors Display](https://badges.pufler.dev/contributors/257ramanrb/dsa?size=50&padding=5&bots=true)](https://badges.pufler.dev)
