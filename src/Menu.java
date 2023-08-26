import java.io.IOException;
import java.util.Scanner;
import models.Input;
import view.Intro;
import view.Panel;

public class Menu extends TaskOperation {

  /**
   * FistMenu has choice what need to do
   *
   * @param sc
   * @throws IOException
   */
  public static void firstMenu(Scanner sc) throws IOException {
    Intro.clear();
    TaskOperation.printTaskList();
    while (true) {
      System.out.println(Panel.SHOW_FIRST_MENU);
      System.out.println();
      System.out.println(Panel.EXIT_BUTTON);

      int choice = Input.readIntLimited(1, 6);
      switch (choice) {
        case 1:
          changeTaskStatus(sc);
          break;
        case 2:
          addTask(sc);
          break;
        case 3:
          sortMenu(sc);
          break;
        case 4:
          correctingTask(sc);
          break;
        case 5:
          remove(sc);
          break;
        case 6:
          System.out.println("До свидания!!!");
          Input.closeFileWithSaving();
          System.exit(0);
      }
    }
  }

  /**
   * This method cals sorts of Tasks
   *
   * @param sc
   * @throws IOException
   */
  public static void sortMenu(Scanner sc) throws IOException {
    while (true) {
      Intro.clear();
      TaskOperation.printTaskList();
      System.out.println(Panel.SHOW_SORT_MENU);
      System.out.println();
      System.out.println(Panel.EXIT_BUTTON);

      int choice = Input.readIntLimited(1, 6);
      switch (choice) {
        case 1:
          SortsSource.sortDate();
          break;
        case 2:
          SortsSource.sortOnPriority();
          break;
        case 3:
          SortsSource.sortOnCategory();
          break;
        case 4:
          SortsSource.sortIsDone();
          break;
        case 5:
          firstMenu(sc);
          break;
        case 6:
          System.out.println("До свидания!!!");
          Input.closeFileWithSaving();
          System.exit(0);
      }
    }
  }
}
