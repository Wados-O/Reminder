import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import models.Category;
import models.Priority;
import models.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TasksServiceTest {

  private TasksService tasksService;
//  static List<Task> taskList = List.copyOf(Input.getArrayList());

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
  void changeStatus() {
//    List<Task> tasks = new ArrayList<>();
//    Task task1 = new Task("title", "message", Category.PERSONAL, Priority.HIGH,
//        DataConvert.parseDate("15/09/2023"), DataConvert.parseDate(String.valueOf(
//        LocalDate.now())), true);
//
//    Task task2 = new Task("title2", "message2", Category.HEALTH, Priority.MEDIUM,
//        DataConvert.parseDate("21/12/2023"), DataConvert.parseDate(String.valueOf(
//        LocalDate.now())), false);
//
//    Task task3 = new Task("title3", "message3", Category.HOME, Priority.LOW,
//        DataConvert.parseDate("14/10/2023"), DataConvert.parseDate(String.valueOf(
//        LocalDate.now())), true);
//
//    tasks.add(task1);
//    tasks.add(task2);
//    tasks.add(task3);
//
//    int indexTask = 2;
//    int choiceStatus = 1;
//    taskList.changeStatus(indexTask, choiceStatus);
  }

  @Test
  void removeTask() {
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
  }

  @Test
  void correctingTitle() {
  }

  @Test
  void correctingMessage() {
  }

  @Test
  void correctingCategory() {
  }

  @Test
  void correctingPriority() {
  }

  @Test
  void correctingDate() {
  }

  @Test
  void correctingStatus() {
  }

  @Test
  void add() {
  }

  @Test
  void choiceCategory() {
  }

  @Test
  void choicePriority() {
  }
}