import java.util.Comparator;

public class TaskByCategoryComparator implements Comparator<Task> {

  @Override
  public int compare(Task task1, Task task2) {
    return task1.getCategory().getNum() - task2.getCategory().getNum();
  }
}
