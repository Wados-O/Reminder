import java.util.Date;

public class Task {

 private int count = 0;
//  private final int id;
//  private final Category category;
  private String title;
  private String message;



  private final Date planeDate;
  private final Date createdDate;
//  private final Priority priority;
//  private final LocalDateTime expiredDate;

  public Task(String title, String message, Date planeDate, Date createdDate) {
    this.title = title;
    this.message = message;
    this.planeDate = planeDate;
    this.createdDate = createdDate;
  }

  public int getCount() {
    return count;
  }
//
//  public void setCount(int count) {
//    this.count = count;
//  }
//
//  public int getId() {
//    return id;
//  }

  public String getTitle() {
    return title;
  }

  public String getMessage() {
    return message;
  }

//  public LocalDateTime getExpiredDate() {
//    return expiredDate;
//  }
//
//  public Category getCategory() {
//    return category;
//  }
//
//  public Priority getPriority() {
//    return priority;
//  }
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

  @Override
  public String toString() {
    return "Наименование: '" + title + '\'' + " Описание: '" + message + "\'"+ " Добавлено " + createdDate;
  }
}