public class Suspend {
  /**
   * Here are tools to delay presentation in project!!!
   */

  public static void longSuspend (){
    int suspend = 2000;
    long start = System.currentTimeMillis();
    while (start >= System.currentTimeMillis() - suspend){
      longSuspend();
    }
  }

}
