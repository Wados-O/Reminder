import java.util.Comparator;

public class TaskByPlaneDateComparator implements Comparator<Task> {

  @Override
  public int compare(Task task1, Task task2) {
    return task1.getPlaneDate().compareTo(task2.getPlaneDate());
  }
}
