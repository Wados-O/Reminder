import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Menu {

  private static boolean isRun = true;


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("""
        1. просмотреть список задач
        2.добавить задачу
        3.удалить задачу
        4.редактировать задачу
        5.отсортировать список
        """);
    while (isRun) {
      int choice = Integer.parseInt(br.readLine());

      switch (choice) {
        case 1 -> showTask(br); //ToDo  просмотреть список задач
        case 2 -> sortMenu(br); //ToDo добавить задачу
        case 3 -> sortMenu(br);//ToDo удалить задачу
        case 4 -> sortMenu(br);//ToDo редактировать задачу
        case 5 -> sortMenu(br);//ToDo отсортировать список

      }
    }
  }

  public static void sortMenu(BufferedReader br) throws IOException {
    System.out.println("""
        отсортировать по дате
        отсортировать по приоритету
        отсортировать по категориям
        отсортировать выполненные
        отсортировать не выполненные
        """);
    while (isRun) {
      int choice = Integer.parseInt(br.readLine());

      switch (choice) {
        case 1 -> sortMenu(br); //ToDo отсортировать по дате
        case 2 -> sortMenu(br);//ToDo отсортировать по приоритету
        case 3 -> sortMenu(br);//ToDo отсортировать по категориям
        case 4 -> sortMenu(br);//ToDo отсортировать выполненные
        case 5 -> sortMenu(br);//ToDo отсортировать не выполненные

      }
    }
  }

  public static void showTask(BufferedReader br) throws IOException {
    File file = new File("res/tasks.txt");

    try {
      br = new BufferedReader(new FileReader(file));

      String line;
      while ((line = br.readLine()) != null) {
        // Process the line as needed
        // Обрабатывайте строку по мере необходимости
        System.out.println(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (br != null) {
        try {
          br.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}