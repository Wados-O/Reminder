import input.InputFile;
import java.io.IOException;
import java.util.Scanner;
import models.Menu;
import view.AnimationOnProject;

public class Runner extends Menu {

  public static void main(String[] args) throws IOException {
    //AnimationOnProject.playAnimation();
    InputFile.readTaskFromFile();
    firstMenu(new Scanner(System.in));
  }
}
