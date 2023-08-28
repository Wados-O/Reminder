package input;

import static view.ColorsSet.PURPLE;
import static view.ColorsSet.RESET;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import models.Category;
import models.Priority;
import models.Task;

public class InputFile {

  private static String ourFile = "res/tasks.csv";
  private static List<Task> arrayList = new ArrayList<>();
  private static final String SEP = ";;;";

  public static void readTaskFromFile() throws IOException {
    File file = new File(ourFile);
    if (!file.exists() || file.length() == 0) {
      return;
    }

    Scanner scanner = new Scanner(file);
    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      String[] cells = line.split(SEP);
      if (cells.length >= 7) { // Проверка на наличие всех необходимых элементов
        String title = cells[0];
        String message = cells[1];
        Category category = Category.valueOf(cells[2]);
        Priority priority = Priority.valueOf(cells[3]);
        Date planeDate = DataConvert.parseDate(cells[4]);
        Date createdDate = DataConvert.parseDate(cells[5]);
        boolean isDone = Boolean.parseBoolean(cells[6]);
        if (planeDate != null && createdDate != null) { // Проверка на корректность дат
          Task task = new Task(title, message, category, priority, planeDate, createdDate, isDone);
          arrayList.add(task);
        }
      }
    }
    scanner.close();
  }

  public static void closeFileWithSaving() throws IOException {
    FileWriter outFile = new FileWriter(ourFile);

    for (Task task : arrayList) {
      String result = task.getTitle() + SEP + task.getMessage() + SEP + task.getCategory() + SEP
          + task.getPriority() + SEP + DataConvert.formatDate(task.getPlaneDate()) + SEP
          + DataConvert.formatDate(task.getCreatedDate()) + SEP + task.isDone();
      outFile.write(result + "\n");
    }
    outFile.close();
  }

  public static void setOurFile(String ourFile) {
    InputFile.ourFile = ourFile;
  }

  public static  List<Task> getArrayList() {
    return arrayList;
  }
}
