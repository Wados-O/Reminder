import java.util.List;
import models.Task;

public class TasksService {
  private List<Task> tasks = Input.getArrayList();

  public void changeStatus(int indexTask, int statusChoice) {
    boolean newStatus = (statusChoice == 1);
    tasks.get(indexTask).setDone(newStatus);
  }
}
