import java.time.LocalDateTime;

public class Task {

  private String name;
  private String message;
  private LocalDateTime expiredDate;

  public Task(String name, String message, LocalDateTime expiredDate) {
    this.name = name;
    this.message = message;
    this.expiredDate = expiredDate;
  }

  public String getName() {
    return name;
  }

  public String getMessage() {
    return message;
  }

  public LocalDateTime getExpiredDate() {
    return expiredDate;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public void setExpiredDate(LocalDateTime expiredDate) {
    this.expiredDate = expiredDate;
  }
}
