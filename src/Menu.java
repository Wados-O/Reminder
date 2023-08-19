import java.io.IOException;
import java.util.Scanner;

public class Menu extends Methods {
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
}
