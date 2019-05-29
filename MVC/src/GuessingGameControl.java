public class GuessingGameControl {

  public boolean correctAnswser(int userInput, GuessingGameModel game) {
    return userInput == game.getAnswer();
  }

  public String hotCold(int userInput, GuessingGameModel game) {
    String returnString = "";
    if (userInput == game.getAnswer()) {
      returnString = "You Win! It was " + game.getAnswer() + "!";
    } else if (getDistance(userInput, game.getAnswer()) > (getDistance(game.getLastGuess(), game.getAnswer()))) {
      returnString = "Colder";
    } else if(getDistance(userInput, game.getAnswer()) < (getDistance(game.getLastGuess(), game.getAnswer()))){
      returnString = "Warmer";
    }

    game.setLastGuess(userInput);
    return returnString;
  }

  private int getDistance(int a, int b) {
    return Math.abs(a-b);
  }
}
