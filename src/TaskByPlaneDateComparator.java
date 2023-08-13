import java.util.Comparator;

public class TaskByPlaneDateComparator implements Comparator<Task> {

  @Override
  public int compare(Task task1, Task task2) {
    int date = task1.getPlaneDate().compareTo(task2.getPlaneDate());
    if (date != 0) {
      return date;
    }
    return task1.getPriority().getNum() - task2.getPriority().getNum();
  }
}
