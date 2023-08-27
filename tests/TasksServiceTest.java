import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TasksServiceTest {
  private TasksService tasksService = new TasksService();

  @Test
  void taskIndex() {
    int number = 1;
    int result = tasksService.taskIndex(number);
    assertEquals(0, result);
  }

  @Test
  void taskIncorrectIndex() {
    int number = 0;
    int result = tasksService.taskIndex(number);
//    assertThrows(IndexOutOfBoundsException.class, () -> )
  }

  @Test
  void changeStatus() {
  }

  @Test
  void removeTask() {
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