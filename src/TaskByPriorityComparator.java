import java.util.Comparator;

public class TaskByPriorityComparator implements Comparator<Task> {

  @Override
  public int compare(Task task1, Task task2) {
    return task1.getPriority().getNum() - task2.getPriority().getNum();
  }
}
