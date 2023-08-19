import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Methods implements Table {

  private Input input;
  static List<Task> tasks = Input.arrayList;
  Scanner sc = new Scanner(System.in);




  public static void changeTaskStatus(Scanner sc) {
    Intro.speedJump();
    printTaskList();
    System.out.println(ColorsSet.CYAN + "Введите номер задачи, состояние которой вы хотите изменить:" + ColorsSet.RESET);
    int numberTask = Input.readIntLimited(1, tasks.size());
    int indexTask = numberTask - 1;
    System.out.println("Выберите новое состояние задачи:");
    System.out.println(ColorsSet.GREEN + "1. Выполнена" + ColorsSet.RESET);
    System.out.println(ColorsSet.RED + "2. Не выполнена" + ColorsSet.RESET);
    int statusChoice = Input.readIntLimited(1, 2);

    boolean newStatus = (statusChoice == 1);
    tasks.get(indexTask).setDone(newStatus);
    Intro.speedJump();
    System.out.println(ColorsSet.YELLOW + "Состояние задачи успешно изменено." + ColorsSet.RESET);

    printTaskList();
  }

  public static void remove(Scanner sc) {
    printTaskList();
    System.out.println("Введите номер задачи, которую хотите удалить:");
    int numberTask =  Input.readIntLimited(1, tasks.size());
    int indexTask = numberTask  - 1;
    tasks.remove(indexTask);
    printTaskList();
    System.out.println();
  }

  public static void correctingTask(Scanner sc) {
    Intro.speedJump();
    printTaskList();
    System.out.println(ColorsSet.GREEN + "Введите номер задачи, которую хотите изменить:" + ColorsSet.RESET);

    int numberTask =  Input.readIntLimited(1, tasks.size());
    int indexTask = numberTask - 1;

    while (true) {
      System.out.println();
      printCurrentTask(numberTask);
      System.out.println();
      choiceYesOrNo();
      int choice = Input.readIntLimited(1, 2);
      if (choice == 1) {
        System.out.println(Panel.SHOW_MENU_REFACTOR);
        int number = Input.readIntLimited(1, 6);

        switch (number) {
          case 1:
            System.out.println("Введите новое название задачи:");
            String title = sc.nextLine();
            tasks.get(indexTask).setTitle(title);
            break;
          case 2:
            System.out.println("Введите новое описание задачи:");
            String message = sc.nextLine();
            tasks.get(indexTask).setMessage(message);
            break;
          case 3:
            Category categoryNewTask = assigningValueCategory(sc);
            tasks.get(indexTask).setCategory(categoryNewTask);
            break;
          case 4:
            Priority priorityNewTask = assigningValuePriority(sc);
            tasks.get(indexTask).setPriority(priorityNewTask);
            break;
          case 5:
            Date correctingDate = DataConvert.choicePlaneDate(sc);
            tasks.get(indexTask).setPlaneDate(correctingDate);
            break;
          case 6:
            System.out.println("Выберите статус задачи:");
            System.out.println(ColorsSet.GREEN + "1. Выполнена" + ColorsSet.RESET);
            System.out.println(ColorsSet.RED + "2. Не выполнена" + ColorsSet.RESET);
            int statusChoice = Input.readIntLimited(1, 2);

            boolean isDone = (statusChoice == 1);
            tasks.get(indexTask).setDone(isDone);
            break;
          default:
            printTaskList();
            break;
        }
      }

      if (choice == 2) {
        printTaskList();
        break;
      }
    }
  }

  public static void printCurrentTask(int index) {


    Task task = tasks.get(index -1);
    String format = "│%6s│%-20s│%-62s│%-21s│%-31s│%-18s│%-7s│%n";
    System.out.println(HEADER);

    String title = truncateString(task.getTitle(), 20);
    String message = truncateString(task.getMessage(), 58);
    String categoryName = truncateString(task.getCategory().getNameCategory(), 24);
    String priority = truncateString(task.getPriority().getPriority(), 24);
    String dateString = task.getPlaneDate() != null ? DataConvert.formatDate(task.getPlaneDate()) : "Без даты";
    String status = task.isDone() ? "      ✔️       " : "      ❌       ";

    System.out.printf(format, index , title, message, categoryName, priority, dateString, status);
    System.out.println(FOOTER);
    System.out.println();
  }
  public static void addTask(Scanner sc) throws IOException {
//    System.out.print("Выберите приоритет задачи: ");
//    int number = sc.nextInt();
//    sc.nextLine();
//    System.out.print("Выберите номер приоритета: ");
//    int priority = Integer.parseInt(sc.nextLine());
//    sc.nextLine();
    //todo добавить проверку на актуальность даты
    Priority priorityNewTask = assigningValuePriority(sc);
    Category categoryNewTask = assigningValueCategory(sc);

    System.out.print("Введите название новой задачи: ");
    String name = Input.readStringLimited(3, 22);
    System.out.print("Введите краткое содержание задачи: ");
    String definition = sc.nextLine();

    Date createdDate = new Date(); // Текущая дата и время

    Date planeDate = DataConvert.choicePlaneDate(sc);

    boolean isDone = false;
    Task task = new Task(name, definition, categoryNewTask, priorityNewTask, planeDate, createdDate,
        isDone);
    tasks.add(task);
    printTaskList();
    System.out.println(ColorsSet.CYAN + "Задача добавлена." +ColorsSet.RESET);
  }

  public static void printTaskList() {
    System.out.println(HEADER);
    String format = "│%6s│%-20s│%-62s│%-21s│%-31s│%-18s│%-7s│%n";

    for (int i = 0; i < tasks.size(); i++) {
      int index = i + 1;
      Task task = tasks.get(i);
      String title = truncateString(task.getTitle(), 20);
      String message = truncateString(task.getMessage(), 58);
      String categoryName = truncateString(task.getCategory().getNameCategory(), 24);
      String priority = truncateString(task.getPriority().getPriority(), 24);
      String dateString =
          task.getPlaneDate() != null ? DataConvert.formatDate(task.getPlaneDate()) : "Без даты";
      String status = task.isDone() ? "      ✔️       " : "      ❌       ";
      System.out.printf(format, index, title, message, categoryName, priority, dateString, status);
      if (i < tasks.size() - 1) {
        System.out.println(MIDDLE);
      }
    }
    System.out.println(FOOTER);
    System.out.println("  ");
  }

  public static String truncateString(String str, int maxLength) {
    if (str.length() > maxLength) {
      return str.substring(0, maxLength);
    }
    return str;
  }


  public static void choiceYesOrNo() {
    List<String> list = new ArrayList<>();
    System.out.println(ColorsSet.BLACK_BOLD+ ColorsSet.WHITE_BACKGROUND +  "      ПРОДОЛЖИТЬ ИЗМЕНЕНИЯ ?       " + ColorsSet.RESET);

    list.add(ColorsSet.WHITE_BOLD_BRIGHT + ColorsSet.YELLOW_BACKGROUND + "   -  ДА     " + ColorsSet.RESET + "      ");
    list.add(ColorsSet.WHITE_BOLD_BRIGHT + ColorsSet.PURPLE_BACKGROUND + "   -  НЕТ    " + ColorsSet.RESET + "      ");
    for (int i = 0; i < list.size(); i++) {
      int index = i + 1;
      System.out.println(index + ". " + list.get(i));
    }
    System.out.println();
  }

  public static Priority assigningValuePriority(Scanner sc) {

    System.out.println(Panel.SHOW_PRIORITY_CHOICE);
    int choiceForPriority = Input.readIntLimited(1, 3);
    Priority priorityNewTask = null;
    for (Priority priority : Priority.values()) {
      if (priority.getNum() == choiceForPriority) {
        priorityNewTask = priority;
      }
    }
    return priorityNewTask;
  }

  public static Category assigningValueCategory(Scanner sc) {
    System.out.println(Panel.SHOW_CATEGORY_MENU);
    int choiceFromCategory = Input.readIntLimited(1, 5);
    Category categoryNewTask = null;
    for (Category category : Category.values()) {
      if (category.getNum() == choiceFromCategory) {
        categoryNewTask = category;
      }
    }
    return categoryNewTask;
  }

  public static void sortOnCategory() {
    tasks.sort(new TaskByCategoryComparator());

  }

  public static void sortOnPriority() {
    tasks.sort(new TaskByPriorityComparator());

  }

  public static void sortDate() {
    tasks.sort(new TaskByPlaneDateComparator());

  }

  public static void sortIsDone() {
    tasks.sort(new TaskByDoneComporator());
    printTaskList();
  }


}
