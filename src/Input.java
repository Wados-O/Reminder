import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Input extends ColorsSet {

  private static String ourFile = "res/tasks.csv";
  protected static List<Task> arrayList = new ArrayList<>();
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
        // тестовая строка
        System.out.println(
            "Read task: " + title + ", " + message + ", " + category + ", " + priority + ", "
                + planeDate + ", " + createdDate + ", " + isDone);
        if (planeDate != null && createdDate != null) { // Проверка на корректность дат
          Task task = new Task(title, message, category, priority, planeDate, createdDate, isDone);
          arrayList.add(task);
        }
      }
    }
    scanner.close();
  }

  /**
   * проверка неправильного вода только цифры
   *
   * @param min
   * @param max
   * @return
   */
  public static int readIntLimited(int min, int max) {
    Scanner sc = new Scanner(System.in);
    int num = 0;
    do {
      try {
        num = Integer.parseInt(sc.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("Вводите только цифры");
        System.out.println();
      }
      if (!(num >= min && num <= max)) {
        System.out.println(PURPLE);
        System.out.printf("Введите число от %d до %d:", min, max);
        System.out.println(RESET);
      }

    } while (!(num >= min && num <= max));
    return num;
  }

  /**
   * проверка на длину строки
   *
   * @param minLength
   * @param maxLength
   * @return
   */
  public static String readStringLimited(int minLength, int maxLength) {
    Scanner sc = new Scanner(System.in);
    String input;

    while (true) {
      input = sc.nextLine();
      if (input.length() >= minLength && input.length() <= maxLength && !containsNumbers(input)) {
        break;
      } else {
        System.out.println(PURPLE);
        System.out.printf("Введите строку длиной от %d до %d символов без чисел: ", minLength,
            maxLength);
        System.out.println(RESET);
      }
    }

    return input;
  }

  /**
   * Проверка на содержания символов
   *
   * @param input
   * @return
   */
  private static boolean containsNumbers(String input) {
    return input.matches(".*\\d+.*");
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
}