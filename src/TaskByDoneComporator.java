import java.util.Comparator;
import models.Task;

public class TaskByDoneComporator implements Comparator<Task> {

  @Override
  public int compare(Task task1, Task task2) {
    if (task2.isDone() && !task1.isDone()) {
      return -1;
    } else if (!task2.isDone() && task1.isDone()) {
      return 1;
    }
      return 0;
  }
}
