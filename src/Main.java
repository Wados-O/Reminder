import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

  Map<String, Map<String, LocalDateTime>> tasks = new HashMap<>();

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);

    while (true) {
      System.out.println("Добро пожаловать в программу ");
      System.out.println("""
          1.Распечатать список из файла 
          2.Добавить новую задачу
          3.Выход из программы 
          """);
      int choice = sc.nextInt();
      switch (choice) {
        case 1:
          taskToPrint(sc);
          break;
        case 2:
          addTask(sc);
          break;
        case 3:
          System.out.println("До свидание!!!");
          System.exit(0);
      }
    }
  }

  public static void taskToPrint(Scanner sc) throws IOException {
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

  public static void remove(Scanner sc) {
    System.out.print("Введите задачу, которую хотите удалить: ");
  }

  public static void addTask(Scanner sc) throws IOException{
    taskToPrint(sc);
    System.out.print("Введите название: ");
    String name = sc.nextLine();
    sc.nextLine();
    System.out.print("Введите дату и время: ");
    String date = sc.nextLine();
    FileWriter fileWriter = new FileWriter("res/tasks.txt", true);
    fileWriter.write(name);
    fileWriter.close();
  }
}