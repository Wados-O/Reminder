package comparators;

import java.util.Comparator;
import models.Task;

public class TaskByPriorityComparator implements Comparator<Task> {

  @Override
  public int compare(Task task1, Task task2) {
    int priority = task1.getPriority().getNum() - task2.getPriority().getNum();
    if (priority != 0) {
      return priority;
    }
    return task1.getPlaneDate().compareTo(task2.getPlaneDate());
  }
}
