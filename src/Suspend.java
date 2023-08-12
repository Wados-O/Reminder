public class Suspend {

  /**
   * Here are tools to delay presentation in project!!!
   */

  public static void longSuspend() {
    int suspend = 2000;
    long start = System.currentTimeMillis();
    while (start >= System.currentTimeMillis() - suspend) {
      longSuspend();
    }
  }

  public static void secondSuspend() {
    int suspend = 500;
    long start = System.currentTimeMillis();
    while (start >= System.currentTimeMillis() - suspend) {
      secondSuspend();
    }
  }

  public static void thirdSuspend() {
    int suspend = 100;
    long start = System.currentTimeMillis();
    while (start >= System.currentTimeMillis() - suspend) {
      thirdSuspend();
    }
  }

  public static void forthSuspend() {
    int suspend = 500;
    long start = System.currentTimeMillis();
    while (start >= System.currentTimeMillis() - suspend) {
      forthSuspend();
    }

  }
}
