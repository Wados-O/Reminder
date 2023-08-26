import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import models.Task;
import org.junit.jupiter.api.Test;

class TaskOperationTests {

  Scanner scanner = new Scanner(System.in);
  List<Task> tasks = new ArrayList<>();

  @Test
  public void removeWithFirstTask() {
    String title = "title";
    String message = "message";
    Category category = Category.PERSONAL;
    Priority priority = Priority.HIGH;
    Date planeDate = DataConvert.parseDate("15/09/2023");
    Date createdDate = DataConvert.parseDate(String.valueOf(LocalDate.now()));
    Boolean isDone = false;

    Task task = new Task(title, message, category, priority, planeDate, createdDate, isDone);
    tasks.add(task);

    String title2 = "title2";
    String message2 = "message2";
    Category category2 = Category.HOME;
    Priority priority2 = Priority.MEDIUM;
    Date planeDate2 = DataConvert.parseDate("20/09/2023");
    Date createdDate2 = DataConvert.parseDate(String.valueOf(LocalDate.now()));
    Boolean isDone2 = true;

    Task task2 = new Task(title2, message2, category2, priority2, planeDate2, createdDate2,
        isDone2);
    tasks.add(task2);

    int number = 1;
    int indexTasks = number - 1;
    TaskOperation.remove(scanner);

    assertEquals(1, tasks.size());
    assertFalse(tasks.isEmpty());
  }

  @Test
  public void removeWithSecondTask() {
    String title = "title";
    String message = "message";
    Category category = Category.PERSONAL;
    Priority priority = Priority.HIGH;
    Date planeDate = DataConvert.parseDate("15/09/2023");
    Date createdDate = DataConvert.parseDate(String.valueOf(LocalDate.now()));
    Boolean isDone = false;

    Task task = new Task(title, message, category, priority, planeDate, createdDate, isDone);
    tasks.add(task);

    String title2 = "title2";
    String message2 = "message2";
    Category category2 = Category.HOME;
    Priority priority2 = Priority.MEDIUM;
    Date planeDate2 = DataConvert.parseDate("20/09/2023");
    Date createdDate2 = DataConvert.parseDate(String.valueOf(LocalDate.now()));
    Boolean isDone2 = true;

    Task task2 = new Task(title2, message2, category2, priority2, planeDate2, createdDate2,
        isDone2);
    tasks.add(task2);

    int number = 2;
    int indexTasks = number - 1;
    tasks.remove(indexTasks);

    assertEquals(1, tasks.size());
    assertFalse(tasks.isEmpty());
  }

  @Test
  public void removeWithIncorrectInput() {
    String title = "title";
    String message = "message";
    Category category = Category.PERSONAL;
    Priority priority = Priority.HIGH;
    Date planeDate = DataConvert.parseDate("15/09/2023");
    Date createdDate = DataConvert.parseDate(String.valueOf(LocalDate.now()));
    Boolean isDone = false;

    Task task = new Task(title, message, category, priority, planeDate, createdDate, isDone);
    tasks.add(task);

    String title2 = "title2";
    String message2 = "message2";
    Category category2 = Category.HOME;
    Priority priority2 = Priority.MEDIUM;
    Date planeDate2 = DataConvert.parseDate("20/09/2023");
    Date createdDate2 = DataConvert.parseDate(String.valueOf(LocalDate.now()));
    Boolean isDone2 = true;

    Task task2 = new Task(title2, message2, category2, priority2, planeDate2, createdDate2,
        isDone2);
    tasks.add(task2);

    int number = 3;
    int indexTasks = number - 1;
    try {
      tasks.remove(indexTasks);
      assertTrue(
          false, "Ожидаемое исключение IndexOutOfBoundsException, "
              + "которое будет выброшено");
    } catch (IndexOutOfBoundsException e) {
      assertEquals("Index " + indexTasks + " out of bounds for length " + tasks.size(),
          e.getMessage());
    }
  }
}
