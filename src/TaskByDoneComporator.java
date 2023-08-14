import java.util.Comparator;

public class TaskByDoneComporator implements Comparator<Task> {

  @Override
  public int compare(Task task1, Task task2) {
    if (task1.isDone() && !task2.isDone()) {
      return -1;
    } else if (!task1.isDone() && task2.isDone()) {
      return 1;
    }
      return 0;
  }
}
