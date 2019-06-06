public class EvenCountRunnable implements Runnable {

  @Override
  public void run() {
    int count = -2;
    while (count < 100) {
      count += 2;
      System.out.println("Even Count: " + count);
      try {
        Thread.sleep(250);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
