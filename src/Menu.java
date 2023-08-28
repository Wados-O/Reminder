import java.io.IOException;
import java.util.Scanner;
import sorts.SortsSource;
import view.Intro;
import view.Panel;

public class Menu {

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
          TaskOperation.changeTaskStatus(sc);
          Input.closeFileWithSaving();
          break;
        case 2:
          TaskOperation.addTask(sc);
          Input.closeFileWithSaving();
          break;
        case 3:
          sortMenu(sc);
          break;
        case 4:
          TaskOperation.correctingTask(sc);
          Input.closeFileWithSaving();
          break;
        case 5:
          TaskOperation.remove(sc);
          Input.closeFileWithSaving();
          break;
        case 6:
          System.out.println("До свидания!!!");
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
          Input.closeFileWithSaving();
          break;
        case 2:
          SortsSource.sortOnPriority();
          Input.closeFileWithSaving();
          break;
        case 3:
          SortsSource.sortOnCategory();
          Input.closeFileWithSaving();
          break;
        case 4:
          SortsSource.sortIsDone();
          Input.closeFileWithSaving();
          break;
        case 5:
          firstMenu(sc);
          break;
        case 6:
          System.out.println("До свидания!!!");
          System.exit(0);
      }
    }
  }
}
