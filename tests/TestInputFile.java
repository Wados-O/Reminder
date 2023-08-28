import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import input.DataConvert;
import input.InputFile;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import models.Category;
import models.Priority;
import models.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestInputFile {

  private static String file = "testFile.txt";
  private List<Task> testTasks;
  private static final String SEP = ";;;";

  @BeforeEach
  public void setUp() {
    testTasks = new ArrayList<>();
  }

  @Test
  public void readTaskFromEmptyFile() throws IOException {
    String input = "";
    InputFile.setOurFile(input);
    InputFile.readTaskFromFile();
    assertTrue(testTasks.isEmpty());
  }

  @Test
  public void readTaskFromNonexistentFile() {
    assertThrows(NoSuchFileException.class, () -> {
      File file2 = new File(file);
      if(!file2.exists()) {
        throw new NoSuchFileException(file2.getPath());
      }
    });
  }

  @Test
  public void readTaskCorrectFromFile() throws IOException {
    File testFile = new File(file);
    FileWriter writer = new FileWriter(testFile);
    String title = "title";
    String message = "message";
    Category category = Category.PERSONAL;
    Priority priority = Priority.HIGH;
    Date planeDate = DataConvert.parseDate("15/09/2023");
    Date createdDate = DataConvert.parseDate(String.valueOf(LocalDate.now()));
    Boolean isDone = false;

    Task task  = new Task(title, message, category, priority,planeDate, createdDate, isDone);
    testTasks.add(task);

    for (Task task1 : testTasks) {
      String result = task.getTitle() + SEP + task.getMessage() + SEP + task.getCategory() + SEP
          + task.getPriority() + SEP + DataConvert.formatDate(task.getPlaneDate()) + SEP
          + DataConvert.formatDate(task.getCreatedDate()) + SEP + task.isDone();
      writer.write(result + "\n");
    }
    writer.flush();
    writer.close();

    InputFile.setOurFile(file);
    InputFile.readTaskFromFile();

    assertFalse(testTasks.isEmpty());
    assertEquals("title", task.getTitle());
    assertEquals("message", task.getMessage());
    assertEquals(Category.PERSONAL, task.getCategory());
    assertEquals(Priority.HIGH, task.getPriority());
    assertEquals(DataConvert.parseDate("15/09/2023"), task.getPlaneDate());
    assertEquals(DataConvert.parseDate(String.valueOf(LocalDate.now())), task.getCreatedDate());
    assertFalse(task.isDone());

    assertTrue(testFile.delete());
  }
}
