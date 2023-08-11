import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {

  private static String ourFile = "res/tasks.txt";
  protected static List<Task> arrayList = new ArrayList<>();

  public static void readTaskFromFile(List<Task> tasks, Scanner scanner) throws IOException {
  scanner = new Scanner(new File(ourFile));

  while (scanner.hasNextLine()) {
    String line = scanner.nextLine();
    arrayList.add(line);
    System.out.println(line);
  }
  scanner.close();
  }

  public static void closeFileWithSaving(List<String> tasks, File file, Scanner scanner) throws IOException {
    FileWriter outFile = new FileWriter(file);
    for (Task line : tasks) {
      outFile.write(String.valueOf(line));
      outFile.close();
    }
  }
}
