public class OddCountRunnable implements Runnable {

  @Override
  public void run() {
    int count = 1;
    while (count < 100) {
      System.out.println("Odd Count: " + count);
      try {
        Thread.sleep(250);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      count += 2;
    }
  }
}
