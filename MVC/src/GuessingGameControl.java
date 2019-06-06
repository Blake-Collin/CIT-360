public class GuessingGameControl {

  GuessingGameModel gameModel = new GuessingGameModel();
  GuessingGameView gameView = new GuessingGameView(this);

  public GuessingGameControl() {
    gameView.displayMenu();
  }

  public boolean correctAnwser(int userInput) {
    return userInput == gameModel.getAnswer();
  }

  public String hotCold(int userInput) {
    String returnString;
    if (userInput == gameModel.getAnswer()) {
      returnString = "You Win! It was " + gameModel.getAnswer() + "!";
    } else if (getDistance(userInput, gameModel.getAnswer()) > (getDistance(gameModel.getLastGuess(), gameModel.getAnswer()))) {
      returnString = "Colder";
    } else if(getDistance(userInput, gameModel.getAnswer()) < (getDistance(gameModel.getLastGuess(), gameModel.getAnswer()))){
      returnString = "Warmer";
    } else {
      returnString = "About the Same";
    }

    gameModel.setLastGuess(userInput);
    return returnString;
  }

  private int getDistance(int a, int b) {
    return Math.abs(a-b);
  }
}
