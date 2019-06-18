public class Power implements MathFunctions {

  @Override
  public double execute(double pNum1, double pNum2) {
    double temp = Math.pow(pNum1, pNum2);
    return temp;
  }
}
