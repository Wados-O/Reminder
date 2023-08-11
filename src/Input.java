import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Input {
public static void readTaskFromFile(List<Task> taskList)throws IOException{
  Scanner sc;
  sc = new Scanner(System.in);
  File file = new File("res/tasks.txt");
  sc = new Scanner(file);

  while (sc.hasNextLine()) {
    String line = sc.nextLine();
    // Process the line as needed
    // Обрабатывайте строку по мере необходимости
    System.out.println(line);
  }
}
}
