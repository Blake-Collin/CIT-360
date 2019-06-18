import java.util.Locale;
import java.util.Scanner;

public class Application {


  /**
   * @author Collin Blake
   *
   * Basic ACP program.
   *
   * @param args
   */
  public static void main(String[] args) {

    ApplicationController appCon = new ApplicationController();
    double num1;
    double num2;
    String command = null;

    //Scanner
    Scanner in = new Scanner(System.in);
    in.useLocale(Locale.US);

    do {
      System.out.print("Enter the first number: ");
      num1 = in.nextDouble();


      System.out.print("Enter Command (+, -, /, *, ^, or exit):");
      command = in.next();

      if (command.equals("+") || command.equals("-") || command.equals("/") || command.equals("*") || command.equals("^")){
        //Do Nothing
      } else if (command.equalsIgnoreCase("exit")) {
        continue;
      }else {
        System.out.println("This is an unknown command lets start over!");
        continue;
      }

      System.out.print("Enter the second number: ");
      num2 = in.nextDouble();

      //Catch divide by 0;
      if(num2 == 0 && command.equals("/")) {
        System.out.println("Cannot divide by zero lets start over!");
        continue;
      }

      System.out.println(num1 + " " + command + " " + num2 + " = " + appCon.executeCommand(command, num1, num2));

    } while(!command.equalsIgnoreCase("exit"));

    System.out.println("Thanks for using this Application Control Pattern Calculator");

  }
}
