import java.util.Comparator;
import models.Task;

public class TaskByCategoryComparator implements Comparator<Task> {

  @Override
  public int compare(Task task1, Task task2) {
    int category = task1.getCategory().getNum() - task2.getCategory().getNum();
    if (category != 0) {
      return category;
    }
    return task1.getPlaneDate().compareTo(task2.getPlaneDate());
  }
}
