import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import input.DataConvert;
import java.time.LocalDate;
import models.Category;
import models.Priority;
import models.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tasks.TasksService;

class TasksServiceTest {

  private TasksService tasksService;

  @BeforeEach
  public void setUp() {
    tasksService = new TasksService();
  }

  @Test
  void taskIndex() {
    int number = 1;
    int result = tasksService.taskIndex(number);
    assertEquals(0, result);
  }

  @Test
  void taskCorrectIndex() {
    int number = 10;
    int result = tasksService.taskIndex(number);
    assertEquals(9, result);
  }

  @Test
  void changeThreeTasksStatus() {
    Task task1 = new Task("title", "message", Category.PERSONAL, Priority.HIGH,
        DataConvert.parseDate("15/09/2023"), DataConvert.parseDate(String.valueOf(
        LocalDate.now())), true);

    Task task2 = new Task("title2", "message2", Category.HEALTH, Priority.MEDIUM,
        DataConvert.parseDate("21/12/2023"), DataConvert.parseDate(String.valueOf(
        LocalDate.now())), false);

    Task task3 = new Task("title3", "message3", Category.HOME, Priority.LOW,
        DataConvert.parseDate("14/10/2023"), DataConvert.parseDate(String.valueOf(
        LocalDate.now())), true);

    tasksService.add(task1);
    tasksService.add(task2);
    tasksService.add(task3);

    int indexTask = 2;
    int choiceStatus = 1;
    tasksService.changeStatus(indexTask, choiceStatus);

    assertTrue(tasksService.getTasks().get(2).isDone());

    tasksService.getTasks().clear();
    assertTrue(tasksService.getTasks().isEmpty());
  }

  @Test
  void changeTwoTasksStatus() {
    Task task1 = new Task("title", "message", Category.PERSONAL, Priority.HIGH,
        DataConvert.parseDate("15/09/2023"), DataConvert.parseDate(String.valueOf(
        LocalDate.now())), true);

    Task task2 = new Task("title2", "message2", Category.HEALTH, Priority.MEDIUM,
        DataConvert.parseDate("21/12/2023"), DataConvert.parseDate(String.valueOf(
        LocalDate.now())), false);

    tasksService.add(task1);
    tasksService.add(task2);

    int indexTask = 1;
    int choiceStatus = 1;
    tasksService.changeStatus(indexTask, choiceStatus);

    assertTrue(tasksService.getTasks().get(1).isDone());

    tasksService.getTasks().clear();
    assertTrue(tasksService.getTasks().isEmpty());
  }

  @Test
  void removeThreeTask() {
    Task task1 = new Task("title", "message", Category.PERSONAL, Priority.HIGH,
        DataConvert.parseDate("15/09/2023"), DataConvert.parseDate(String.valueOf(
        LocalDate.now())), true);

    Task task2 = new Task("title2", "message2", Category.HEALTH, Priority.MEDIUM,
        DataConvert.parseDate("21/12/2023"), DataConvert.parseDate(String.valueOf(
        LocalDate.now())), false);

    Task task3 = new Task("title3", "message3", Category.HOME, Priority.LOW,
        DataConvert.parseDate("14/10/2023"), DataConvert.parseDate(String.valueOf(
        LocalDate.now())), true);

    tasksService.add(task1);
    tasksService.add(task2);
    tasksService.add(task3);

    int indexTask = 1;

    tasksService.removeTask(indexTask);

    assertEquals(2, tasksService.getTasksCount());
    assertEquals(task3, tasksService.getTasks().get(1));

    tasksService.getTasks().clear();
    assertTrue(tasksService.getTasks().isEmpty());
  }

  @Test
  void removeTwoTask() {
    Task task1 = new Task("title", "message", Category.PERSONAL, Priority.HIGH,
        DataConvert.parseDate("15/09/2023"), DataConvert.parseDate(String.valueOf(
        LocalDate.now())), true);

    Task task2 = new Task("title2", "message2", Category.HEALTH, Priority.MEDIUM,
        DataConvert.parseDate("21/12/2023"), DataConvert.parseDate(String.valueOf(
        LocalDate.now())), false);

    tasksService.add(task1);
    tasksService.add(task2);

    int indexTask = 0;

    tasksService.removeTask(indexTask);

    assertEquals(1, tasksService.getTasksCount());
    assertEquals(task2, tasksService.getTasks().get(0));

    tasksService.getTasks().clear();
    assertTrue(tasksService.getTasks().isEmpty());
  }

  @Test
  void correctingTitle() {
    Task task1 = new Task("title", "message", Category.PERSONAL, Priority.HIGH,
        DataConvert.parseDate("15/09/2023"), DataConvert.parseDate(String.valueOf(
        LocalDate.now())), true);

    Task task2 = new Task("title2", "message2", Category.HEALTH, Priority.MEDIUM,
        DataConvert.parseDate("21/12/2023"), DataConvert.parseDate(String.valueOf(
        LocalDate.now())), false);

    Task task3 = new Task("title3", "message3", Category.HOME, Priority.LOW,
        DataConvert.parseDate("14/10/2023"), DataConvert.parseDate(String.valueOf(
        LocalDate.now())), true);

    tasksService.add(task1);
    tasksService.add(task2);
    tasksService.add(task3);

    int indexTask = 1;
    String title = "changeTitle";

    tasksService.correctingTitle(indexTask, title);

    assertEquals("changeTitle", tasksService.getTasks().get(1).getTitle());

    tasksService.getTasks().clear();
    assertTrue(tasksService.getTasks().isEmpty());
  }

  @Test
  void correctingMessage() {
    Task task1 = new Task("title", "message", Category.PERSONAL, Priority.HIGH,
        DataConvert.parseDate("15/09/2023"), DataConvert.parseDate(String.valueOf(
        LocalDate.now())), true);

    Task task2 = new Task("title2", "message2", Category.HEALTH, Priority.MEDIUM,
        DataConvert.parseDate("21/12/2023"), DataConvert.parseDate(String.valueOf(
        LocalDate.now())), false);

    Task task3 = new Task("title3", "message3", Category.HOME, Priority.LOW,
        DataConvert.parseDate("14/10/2023"), DataConvert.parseDate(String.valueOf(
        LocalDate.now())), true);

    tasksService.add(task1);
    tasksService.add(task2);
    tasksService.add(task3);

    int indexTask = 2;
    String message = "changeMessage";

    tasksService.correctingMessage(indexTask, message);

    assertEquals("changeMessage", tasksService.getTasks().get(2).getMessage());

    tasksService.getTasks().clear();
    assertTrue(tasksService.getTasks().isEmpty());
  }

  @Test
  void correctingCategory() {
    Task task1 = new Task("title", "message", Category.PERSONAL, Priority.HIGH,
        DataConvert.parseDate("15/09/2023"), DataConvert.parseDate(String.valueOf(
        LocalDate.now())), true);

    Task task2 = new Task("title2", "message2", Category.HEALTH, Priority.MEDIUM,
        DataConvert.parseDate("21/12/2023"), DataConvert.parseDate(String.valueOf(
        LocalDate.now())), false);

    Task task3 = new Task("title3", "message3", Category.HOME, Priority.LOW,
        DataConvert.parseDate("14/10/2023"), DataConvert.parseDate(String.valueOf(
        LocalDate.now())), true);

    tasksService.add(task1);
    tasksService.add(task2);
    tasksService.add(task3);

    int indexTask = 0;
    Category category = Category.HEALTH;

    tasksService.correctingCategory(indexTask, category);

    assertEquals(
        "Здоровье", tasksService.getTasks().get(0).getCategory().getNameCategory());

    tasksService.getTasks().clear();
    assertTrue(tasksService.getTasks().isEmpty());
  }

  @Test
  void correctingPriority() {
    Task task1 = new Task("title", "message", Category.PERSONAL, Priority.HIGH,
        DataConvert.parseDate("15/09/2023"), DataConvert.parseDate(String.valueOf(
        LocalDate.now())), true);

    Task task2 = new Task("title2", "message2", Category.HEALTH, Priority.MEDIUM,
        DataConvert.parseDate("21/12/2023"), DataConvert.parseDate(String.valueOf(
        LocalDate.now())), false);

    Task task3 = new Task("title3", "message3", Category.HOME, Priority.LOW,
        DataConvert.parseDate("14/10/2023"), DataConvert.parseDate(String.valueOf(
        LocalDate.now())), true);

    tasksService.add(task1);
    tasksService.add(task2);
    tasksService.add(task3);

    int indexTask = 2;
    Priority priority = Priority.MEDIUM;

    tasksService.correctingPriority(indexTask, priority);

    assertEquals(
        2, tasksService.getTasks().get(2).getPriority().getNum());

    tasksService.getTasks().clear();
    assertTrue(tasksService.getTasks().isEmpty());
  }

  @Test
  void correctingDate() {
    Task task1 = new Task("title", "message", Category.PERSONAL, Priority.HIGH,
        DataConvert.parseDate("15/09/2023"), DataConvert.parseDate(String.valueOf(
        LocalDate.now())), true);

    Task task2 = new Task("title2", "message2", Category.HEALTH, Priority.MEDIUM,
        DataConvert.parseDate("21/12/2023"), DataConvert.parseDate(String.valueOf(
        LocalDate.now())), false);

    Task task3 = new Task("title3", "message3", Category.HOME, Priority.LOW,
        DataConvert.parseDate("14/10/2023"), DataConvert.parseDate(String.valueOf(
        LocalDate.now())), true);

    tasksService.add(task1);
    tasksService.add(task2);
    tasksService.add(task3);

    int indexTask = 0;
    DataConvert.parseDate("16/10/2023");
  }

  @Test
  void correctingStatus() {
    Task task1 = new Task("title", "message", Category.PERSONAL, Priority.HIGH,
        DataConvert.parseDate("15/09/2023"), DataConvert.parseDate(String.valueOf(
        LocalDate.now())), true);

    Task task2 = new Task("title2", "message2", Category.HEALTH, Priority.MEDIUM,
        DataConvert.parseDate("21/12/2023"), DataConvert.parseDate(String.valueOf(
        LocalDate.now())), false);

    Task task3 = new Task("title3", "message3", Category.HOME, Priority.LOW,
        DataConvert.parseDate("14/10/2023"), DataConvert.parseDate(String.valueOf(
        LocalDate.now())), true);

    tasksService.add(task1);
    tasksService.add(task2);
    tasksService.add(task3);

    int indexTask = 1;
    int choiceStatus = 2;
    tasksService.correctingStatus(indexTask, choiceStatus);

    assertFalse(tasksService.getTasks().get(1).isDone());

    tasksService.getTasks().clear();
    assertTrue(tasksService.getTasks().isEmpty());
  }

  @Test
  void addTwoTasks() {
    Task task1 = new Task("title", "message", Category.PERSONAL, Priority.HIGH,
        DataConvert.parseDate("15/09/2023"), DataConvert.parseDate(String.valueOf(
        LocalDate.now())), true);

    Task task2 = new Task("title2", "message2", Category.HEALTH, Priority.MEDIUM,
        DataConvert.parseDate("21/12/2023"), DataConvert.parseDate(String.valueOf(
        LocalDate.now())), false);

    tasksService.add(task1);
    tasksService.add(task2);

    assertEquals(2, tasksService.getTasksCount());
    assertEquals(task2, tasksService.getTasks().get(1));

    tasksService.getTasks().clear();
    assertTrue(tasksService.getTasks().isEmpty());
  }

  @Test
  void addOneTasks() {
    Task task1 = new Task("title", "message", Category.PERSONAL, Priority.HIGH,
        DataConvert.parseDate("15/09/2023"), DataConvert.parseDate(String.valueOf(
        LocalDate.now())), true);

    tasksService.add(task1);

    assertEquals(1, tasksService.getTasksCount());
    assertEquals(task1, tasksService.getTasks().get(0));

    tasksService.getTasks().clear();
    assertTrue(tasksService.getTasks().isEmpty());
  }

  @Test
  void addZeroTasks() {
    assertTrue(tasksService.getTasks().isEmpty());
  }

  @Test
  void choiceCategory() {
  }

  @Test
  void choicePriority() {
  }
}