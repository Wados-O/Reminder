import java.io.IOException;
import java.util.Scanner;

public class Runner {

  public static void main(String[] args) throws IOException {

//Intro.logoTeam();
//Intro.logoPresents();
//Intro.emptyPlace();
//Intro.stringLoading();
//Intro.speedJump();
//Intro.logoProject();
//Intro.emptyPlace();
//Intro.stringDownload();
//Suspend.longSuspend();
//Intro.speedJump();
//Intro.speedJump();
    Input.readTaskFromFile();
//    System.out.println(Menu.SHOW_MENU_REFACTOR);
//    System.out.println(Menu.SHOW_CATEGORY_MENU);
//    System.out.println(Menu.SHOW_PRIORITY_CHOICE);
//    System.out.println(Menu.SHOW_SORT_MENU);

Methods.firstMenu(new Scanner(System.in));
  }
}
