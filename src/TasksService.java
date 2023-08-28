import java.util.Date;
import java.util.List;
import models.Category;
import models.Priority;
import models.Task;

public class TasksService {
  static List<Task> tasks = Input.getArrayList();

  public int taskIndex(int numberTask) {
    return numberTask - 1;
  }

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

  public void add(Task task) {
    tasks.add(task);
  }

  public Category choiceCategory(int choiceForCategory) {
    Category categoryNewTask = null;
    for (Category category : Category.values()) {
      if (category.getNum() == choiceForCategory) {
        categoryNewTask = category;
      }
    }
    return categoryNewTask;
  }

  public Priority choicePriority(int choiceForPriority) {
    Priority priorityNewTask = null;
    for (Priority priority : Priority.values()) {
      if (priority.getNum() == choiceForPriority) {
        priorityNewTask = priority;
      }
    }
    return priorityNewTask;
  }

  public int getTasksCount() {
    return tasks.size();
  }

  public List<Task> getTasks() {
    return tasks;
  }
}
