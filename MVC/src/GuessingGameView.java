import java.util.Scanner;

public class GuessingGameView {
  protected static final Scanner keyboard = new Scanner(System.in);
  String menu = "Main Menu:\n1) Start Game\n2) Exit Game\n";
  GuessingGameControl gameControl;

  public GuessingGameView(GuessingGameControl gameControl) {
    this.gameControl = gameControl;
  }

  public void displayMenu() {
    int menuOption = 0;
    do {
      System.out.println(menu);
      menuOption = getMenuOption();
      doAction(menuOption);
    } while (menuOption != 2);
  }

  public int getMenuOption() {
    int inputValue = 0;
    do {
      System.out.format("Please enter an option(1 - %d):", 2);
      inputValue = keyboard.nextInt();
      if (inputValue < 1 || inputValue > 2) {
        System.out.format("Error: input value must be between 1 and %d.", 2);
      }
    } while (inputValue < 1 || inputValue > 2);
    return inputValue;
  }

  public void doAction(int option) {
    switch (option) {
        // if the option is 1, call startNewGame( )
      case 1:
        startNewGame();
        break;
        // if the option is 2, call startExistingGame( )
      case 2:
        System.out.println("Thanks for playing... goodbye.");
    }
  }

  public void startNewGame() {
    System.out.println("Welcome you are to guess a the number between 1 and 1000. Good luck!");

    mainGameLoop();
  }

  public void mainGameLoop() {
    int userGuess = 0;
    do {
      System.out.print("Please Enter your Guess: ");
      userGuess = keyboard.nextInt();
      if (userGuess < 1 || userGuess > 1000) {
        System.out.format("Error: input value must be between 1 and %d.", 1000);
      }
      else{
        System.out.println(gameControl.hotCold(userGuess));
      }

    } while (!gameControl.correctAnwser(userGuess));
  }
}
