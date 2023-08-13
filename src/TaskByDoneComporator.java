import java.util.Comparator;

public class TaskByDoneComporator implements Comparator<Task> {

  @Override
  public int compare(Task task1, Task task2) {
    if (Boolean.compare(task1.isDone(), task2.isDone()) != 0) {
      return Boolean.compare(task1.isDone(), task2.isDone());
    }
    return task1.getPlaneDate().compareTo(task2.getPlaneDate());
  }
}
