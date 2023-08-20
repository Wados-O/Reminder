import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.junit.jupiter.api.Test;

import java.util.Date;

class TaskOperationTests {

  Scanner scanner = new Scanner(System.in);

  List<Task> tasks = new ArrayList<>();

  @Test
  public void remove() {
    Task task = new Task("Title", "Message", Category.PERSONAL, Priority.HIGH,
        DataConvert.parseDate(scanner.nextLine()), new Date(), false);

    Task task2 = new Task("Title2", "Message2", Category.HEALTH, Priority.MEDIUM,
        DataConvert.parseDate(scanner.nextLine()), new Date(), true);

    tasks.add(task);
    tasks.add(task2);

    int number = 1;
    int indexTasks = number - 1;
    tasks.remove(indexTasks);
  }
}



