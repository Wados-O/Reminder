import java.time.LocalDateTime;

public class Task {

  private int count = 0;
  private final int id;
  private final Category category;
  private final String title;
  private final String message;
  private final Priority priority;
  private final LocalDateTime expiredDate;

  public Task(Priority priority, Category category, String title, String message, LocalDateTime expiredDate) {
    this.category = category;
    this.title = title;
    this.message = message;
    this.priority = priority;
    this.expiredDate = expiredDate;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public int getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getMessage() {
    return message;
  }

  public LocalDateTime getExpiredDate() {
    return expiredDate;
  }

  public Category getCategory() {
    return category;
  }

  public Priority getPriority() {
    return priority;
  }
}