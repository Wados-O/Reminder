import java.io.IOException;
import java.util.Scanner;

public class Menu extends Methods {
    /**
     * FistMenu has choice what
     * need to do
     * @param sc
     * @throws IOException
     */
    public static void firstMenu(Scanner sc) throws IOException {
        Intro.speedJump();
        Methods.printTaskList();
        while (true) {
            System.out.println(Panel.SHOW_FIRST_MENU);
            System.out.println();
            System.out.println(Panel.EXIT_BUTTON);
            int choice = Input.readIntLimited(1,6);
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
                case 6 :
                    System.out.println("До свидания!!!");
                    Input.closeFileWithSaving();
                    System.exit(0);
            }
        }
    }

    /**
     *This method cals sorts of Tasks
     * @param sc
     * @throws IOException
     */
    public static void sortMenu(Scanner sc) throws IOException {
        while (true){
            Intro.speedJump();
            Methods.printTaskList();
            System.out.println(Panel.SHOW_SORT_MENU);
            System.out.println();
            System.out.println(Panel.EXIT_BUTTON);

            int choice = Input.readIntLimited(1,6);
            switch (choice){
                case 1:
                    sortDate();
                    break;
                case 2:
                    sortOnPriority();
                    break;
                case 3:
                    sortOnCategory();
                    break;
                case 4:
                    sortIsDone();
                    break;
                case 5:
                    firstMenu(sc);
                    break;
                case 6 :
                    System.out.println("До свидания!!!");
                    Input.closeFileWithSaving();
                    System.exit(0);
            }
        }
    }
}
