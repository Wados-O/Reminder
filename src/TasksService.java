import java.util.Date;
import java.util.List;
import models.Category;
import models.Priority;
import models.Task;

public class TasksService {
  static List<Task> tasks = Input.getArrayList();

  public void changeStatus(int indexTask, int statusChoice) {
    boolean newStatus = (statusChoice == 1);
    tasks.get(indexTask).setDone(newStatus);
  }

  public void removeTask(int indexTask) {
    tasks.remove(indexTask);
  }

  public void correctingTitle(int indexTask, String title) {
    tasks.get(indexTask).setTitle(title);
  }

  public void correctingMessage(int indexTask, String message) {
    tasks.get(indexTask).setMessage(message);
  }

  public void correctingCategory(int indexTask, Category category) {
    tasks.get(indexTask).setCategory(category);
  }

  public void correctingPriority(int indexTask, Priority priority) {
    tasks.get(indexTask).setPriority(priority);
  }

  public void correctingDate(int indexTask, Date date) {
    tasks.get(indexTask).setPlaneDate(date);
  }

  public void correctingStatus(int indexTask, int statusChoice) {
    boolean isDone = (statusChoice == 1);
    tasks.get(indexTask).setDone(isDone);
  }
}
