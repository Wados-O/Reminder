import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {

  private static String ourFile = "res/tasks.csv";
  protected static List<Task> arrayList = new ArrayList<>();
  private static final String SEP = ";;;";

  public static void readTaskFromFile() throws IOException {
    File file = new File(ourFile);
    if (ourFile.length() == 0) {
      return;
    }
    Scanner scanner = new Scanner(file);

    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      String[] cells = line.split(SEP);
//      Priority priority = Priority.valueOf(cells[0]);
//      Category category = Category.valueOf(cells[1]);
      String tiile = cells[0];
      String message = cells[1];
      Task task = new Task(tiile, message);
      arrayList.add(task);
//      System.out.println(task);
    }
    scanner.close();
  }

  public static void closeFileWithSaving() throws IOException {
    FileWriter outFile = new FileWriter(ourFile);

    for (Task task : arrayList) {
      String result = task.getTitle()
          + SEP + task.getMessage();
      outFile.write(result + "\n");
    }
    outFile.close();
    System.out.println();
  }
}
