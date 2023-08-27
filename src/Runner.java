import java.io.IOException;
import java.util.Scanner;
import view.AnimationOnProject;

public class Runner extends Menu {

  public static void main(String[] args) throws IOException {
    AnimationOnProject.playAnimation();
    Input.readTaskFromFile();
    firstMenu(new Scanner(System.in));
  }
}
