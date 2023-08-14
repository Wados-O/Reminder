import java.util.Date;
import java.util.Objects;

public class Task implements Comparable<Task> {

  private int count = 0;
  private Category category;
  private String title;
  private String message;
  private Priority priority;

  private final Date planeDate;
  private final Date createdDate;
private boolean isDone;

  public Task(String title, String message, Category category, Priority priority, Date planeDate,
      Date createdDate, boolean isDone) {
    this.title = title;
    this.message = message;
    this.category = category;
    this.priority = priority;
    this.planeDate = planeDate;
    this.createdDate = createdDate;
    this.isDone = isDone;
  }

  public int getCount() {
    return count;
  }
  public String getTitle() {
    return title;
  }

  public String getMessage() {
    return message;
  }

  public Category getCategory() {
    return category;
  }

  public Priority getPriority() {
    return priority;
  }

  public Date getPlaneDate() {
    return planeDate;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public void setPriority(Priority priority) {
    this.priority = priority;
  }

  public boolean isDone() {
    return isDone;
  }
public void markAsDone(){
    this.isDone = true;
}
  public void setDone(boolean done) {
    isDone = done;
  }
  @Override
  public String toString() {
    return "Наименование: '" + title + '\'' + " Описание: '" + message + "\'"  + " Категория: '"
        + category + "\'" + " Приоритет: '" + priority + "\'" + " Добавлено "
        + createdDate + "\'" + planeDate;
  }

  @Override
  public int compareTo(Task task) {
    if (!title.equals(task.title)) {
      return title.compareTo(task.title);
    }

    if (!message.equals(task.message)) {
      return message.compareTo(task.message);
    }

    return createdDate.compareTo(task.getCreatedDate());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Task task = (Task) o;
    return count == task.count && category == task.category && Objects.equals(title,
        task.title) && Objects.equals(message, task.message) && priority == task.priority
        && Objects.equals(planeDate, task.planeDate) && Objects.equals(
        createdDate, task.createdDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(count, category, title, message, priority, planeDate, createdDate);
  }
}