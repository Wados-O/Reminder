import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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
      String title = cells[0];
      String message = cells[1];
      Category category = Category.valueOf(cells[2]);
      Priority priority = Priority.valueOf(cells[3]);
      Task task = new Task(title, message, category, priority);
      arrayList.add(task);
    }
    scanner.close();
  }

  public static void closeFileWithSaving() throws IOException {
    FileWriter outFile = new FileWriter(ourFile);

    for (Task task : arrayList) {
      String result = task.getTitle() + SEP + task.getMessage() + SEP + task.getCategory() + SEP
          + task.getPriority();
      outFile.write(result + "\n");
    }
    outFile.close();
  }
}
