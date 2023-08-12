import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Methods {

  private Input input;
  static List<Task> tasks = Input.arrayList;

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    Input.readTaskFromFile();
    System.out.println("Добро пожаловать в программу ");

    while (true) {
      System.out.println("""
          1.Распечатать список задач 
          2.Добавить новую задачу
          3.Редактировать задачу
          4.Удалить задачу
          5.Выход из программы 
          """);
      int choice = sc.nextInt();
      sc.nextLine();
      switch (choice) {
        case 1:
          printNumberedList();
          System.out.println();
          break;
        case 2:
          addTask(sc);
          break;
        case 3:
          break;
        case 4:
          remove(sc);
          break;
        case 5:
          System.out.println("До свидания!!!");
          Input.closeFileWithSaving();
          System.exit(0);
      }
    }
  }

  public static void remove(Scanner sc) {
    System.out.println("Введите номер задачи, которую хотите удалить:");
    printNumberedList();
    int numberTask = sc.nextInt();
    int indexTask = numberTask - 1;
    tasks.remove(indexTask);
    System.out.println();
  }

  public static void addTask(Scanner sc) throws IOException {
//    System.out.print("Выберите приоритет задачи: ");
//    int number = sc.nextInt();
//    sc.nextLine();
//    System.out.print("Выберите номер приоритета: ");
//    int priority = Integer.parseInt(sc.nextLine());
//    sc.nextLine();
    System.out.print("Введите название новой задачи: ");
    String name = sc.nextLine();
    System.out.print("Введите краткое содержание задачи: ");
    String definition = sc.nextLine();
    Task task = new Task(name, definition);
//    tasks.setMessage(definition);
    tasks.add(task);
    System.out.println();
  }

  public static void correctingTask(Scanner sc) {
    System.out.println("Введите номер задачи, которую хотите изменить:");
    printNumberedList();
  }

  public static List<Task> printNumberedList() {
    for (int i = 0; i < tasks.size(); i++) {
      int index = i + 1;
      System.out.println(index + ". " + tasks.get(i).toString());
    }
    return new ArrayList<>();
  }
}