import java.io.IOException;
import java.util.Scanner;

public class Runner extends Menu{

  public static void main(String[] args) throws IOException {

    Intro.logoTeam();
    Intro.logoPresents();
    Intro.emptyPlace();
    Intro.stringLoading();
    Intro.speedJump();
    Intro.logoProject();
    Intro.emptyPlace();
    Intro.stringDownload();
    Suspend.longSuspend();
    Intro.speedJump();
    Intro.speedJump();
    Input.readTaskFromFile();
    firstMenu(new Scanner(System.in));
  }
}
