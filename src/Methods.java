import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;
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
    System.out.print("Введите дату планируемого выполнения задачи (гггг-мм-дд): ");
    String planeDateStr = sc.nextLine();
    Date planeDate = parseDate(planeDateStr);

   Date createdDate = new Date(); // Текущая дата и время
    Task task = new Task(name, definition, planeDate, createdDate);
    tasks.add(task);
    System.out.println("Задача добавлена.");
  }

  public static void correctingTask(Scanner sc) {
    System.out.println("Введите номер задачи, которую хотите изменить:");
    printNumberedList();
  }

  public static List<Task> printNumberedList() {
    for (int i = 0; i < tasks.size(); i++) {
      int index = i + 1;
      Task task = tasks.get(i);
      String dateString = task.getPlaneDate() != null ? formatDate(task.getPlaneDate()) : "Без даты";
      System.out.println(index + ". " + tasks.get(i).toString()  + " Выполнить: " + dateString);
    }
    return new ArrayList<>();
  }

  public static Date parseDate(String dateStr) {
    SimpleDateFormat dateFormatDash = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat dateFormatDot = new SimpleDateFormat("yyyy.MM.dd");

    try {
      if (dateStr.contains("-")) {
        return dateFormatDash.parse(dateStr);
      } else if (dateStr.contains(".")) {
        return dateFormatDot.parse(dateStr);
      } else {
        System.out.println("Неверный формат даты. Используйте [гггг-мм-дд] или [гггг.мм.дд].");
        return null;
      }
    } catch (ParseException e) {
      e.printStackTrace();
      return null;
    }
  }
  public static String formatDate(Date date) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    return dateFormat.format(date);
  }
}