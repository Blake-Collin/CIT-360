import java.util.Random;

public class GuessingGameModel {

  private int lastGuess;
  private int answer;

  private static Random random = new Random();

  public GuessingGameModel() {
    answer = random.nextInt(1000);
    lastGuess = 0;
    //For showing answer for testing purposes
    //System.out.println(answer);
  }

  public int getLastGuess() {
    return lastGuess;
  }

  public int getAnswer() {
    return answer;
  }

  public void setLastGuess(int lastGuess) {
    this.lastGuess = lastGuess;
  }

  public void setAnswer(int answer) {
    this.answer = answer;
  }
}
