import java.time.LocalDateTime;

public class Task {

  private int count = 0;
  private final int id;
  private final String title;
  private final String message;
  private final LocalDateTime expiredDate;

  public Task(int id, String title, String message, LocalDateTime expiredDate) {
    this.id = id;
    this.title = title;
    this.message = message;
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
}