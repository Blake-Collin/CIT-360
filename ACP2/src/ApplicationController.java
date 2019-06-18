import java.util.HashMap;

public class ApplicationController {

  public static HashMap<String, MathFunctions> commands = createMap();

  private static HashMap<String, MathFunctions> createMap() {
    HashMap<String, MathFunctions> tempMap = new HashMap<>();
    tempMap.put("+", new Add());
    tempMap.put("-", new Subtract());
    tempMap.put("*", new Muttiply());
    tempMap.put("/", new Divide());
    tempMap.put("^", new Power());
    return tempMap;
  }

  public ApplicationController() {}

  public static double executeCommand(String command, double pNum1, double pNum2){
    MathFunctions function = commands.get(command);
    double temp = function.execute(pNum1,pNum2);
    return temp;
  }
}
