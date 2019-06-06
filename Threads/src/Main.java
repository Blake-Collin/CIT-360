import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

  private static Random random = new Random();
  private static volatile AtomicInteger counter = new AtomicInteger(0);


  public static void main(String args[]) {
    //Start two threads.

    //Create new runnable
    OddCountRunnable r1 = new OddCountRunnable();

    //Create new thread and start it
    Thread thread1 = new Thread(r1, "Thread 1");
    thread1.start();

    //Create new runnable
    EvenCountRunnable r2 = new EvenCountRunnable();

    //Create new thread and start it
    Thread thread2 = new Thread(r2, "Thread 2");
    thread2.start();

    while(thread2.isAlive() && thread1.isAlive())
    {
      try {
        System.out.println("Waiting...");
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    //Executor service
    ExecutorService executorService = Executors.newFixedThreadPool(10);

    Runnable task = new Runnable() {
      @Override
      public void run() {
        for (int i = 10; i > 0; i--)
        {
          addRandom();
          System.out.println("Current Counter Value: " + getValue());
        }
      }
    };

    executorService.execute(task);
    executorService.execute(task);
    executorService.execute(task);
    executorService.execute(task);
    executorService.execute(task);
    executorService.execute(task);

    executorService.shutdown();
  }

  public static int getValue() {
    return counter.get();
  }

  public static void addRandom() {
    while (true){
      int currentValue = getValue();
      int newValue = currentValue + random.nextInt(50);
      if(counter.compareAndSet(currentValue, newValue))
        return;
    }
  }

}
