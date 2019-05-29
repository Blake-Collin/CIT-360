public class GuessingGame {

  private static GuessingGameModel game = null;

  public static void main(String[] args) {
    GuessingGameView main = new GuessingGameView();

    main.displayMenu();
  }

  public static GuessingGameModel getGame() {
    return game;
  }

  public static void setGame(GuessingGameModel pGame) {
    game = pGame;
  }

}
