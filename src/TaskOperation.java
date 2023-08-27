import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import models.Category;
import models.Priority;
import models.Task;
import view.ColorsSet;
import view.Intro;
import view.Panel;
import view.Table;

public class TaskOperation {

  static List<Task> tasks = Input.getArrayList();
  private static TasksService tasksService = new TasksService();

  public static void changeTaskStatus(Scanner sc) {
    Intro.clear();
    printTaskList();

    System.out.println(
        ColorsSet.CYAN + "Введите номер задачи, состояние которой вы хотите изменить:"
            + ColorsSet.RESET);

    int numberTask = Input.readIntLimited(1, tasks.size());
    int indexTask = tasksService.taskIndex(numberTask);

    System.out.println("Выберите новое состояние задачи:");
    System.out.println(ColorsSet.GREEN + "1. Выполнена" + ColorsSet.RESET);
    System.out.println(ColorsSet.RED + "2. Не выполнена" + ColorsSet.RESET);
    int statusChoice = Input.readIntLimited(1, 2);

    tasksService.changeStatus(indexTask, statusChoice);

    Intro.clear();
    System.out.println(ColorsSet.YELLOW + "Состояние задачи успешно изменено." + ColorsSet.RESET);
    printTaskList();
  }

  public static void remove(Scanner sc) {
    printTaskList();

    System.out.println("Введите номер задачи, которую хотите удалить:");

    int numberTask = Input.readIntLimited(1, tasks.size());
    int indexTask = tasksService.taskIndex(numberTask);

    tasksService.removeTask(indexTask);

    printTaskList();
    System.out.println();
  }

  public static void correctingTask(Scanner sc) {
    Intro.clear();
    printTaskList();

    System.out.println(
        ColorsSet.GREEN + "Введите номер задачи, которую хотите изменить:" + ColorsSet.RESET);

    int numberTask = Input.readIntLimited(1, tasks.size());
    int indexTask = tasksService.taskIndex(numberTask);

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
            tasksService.correctingTitle(indexTask, title);
            break;
          case 2:
            System.out.println("Введите новое описание задачи:");
            String message = sc.nextLine();
            tasksService.correctingMessage(indexTask, message);
            break;
          case 3:
            Category categoryNewTask = assigningValueCategory(sc);
            tasksService.correctingCategory(indexTask, categoryNewTask);
            break;
          case 4:
            Priority priorityNewTask = assigningValuePriority(sc);
            tasksService.correctingPriority(indexTask, priorityNewTask);
            break;
          case 5:
            Date correctingDate = DataConvert.choicePlaneDate(sc);
            tasksService.correctingDate(indexTask, correctingDate);
            break;
          case 6:
            System.out.println("Выберите статус задачи:");
            System.out.println(ColorsSet.GREEN + "1. Выполнена" + ColorsSet.RESET);
            System.out.println(ColorsSet.RED + "2. Не выполнена" + ColorsSet.RESET);
            int statusChoice = Input.readIntLimited(1, 2);

            tasksService.correctingStatus(indexTask, statusChoice);
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

  public static void addTask(Scanner sc) throws IOException {
    Priority priorityNewTask = assigningValuePriority(sc);

    Category categoryNewTask = assigningValueCategory(sc);

    System.out.print("Введите название новой задачи: ");
    String name = Input.readStringLimited(3, 22);

    System.out.print("Введите краткое содержание задачи: ");
    String definition = sc.nextLine();

    Date createdDate = new Date();
    Date planeDate = DataConvert.choicePlaneDate(sc);

    boolean isDone = false;

    Task task = new Task(name, definition, categoryNewTask, priorityNewTask, planeDate, createdDate,
        isDone);
    tasksService.add(task);

    printTaskList();
    System.out.println(ColorsSet.CYAN + "Задача добавлена." + ColorsSet.RESET);
  }

  /**
   * Print current task use if need get task for delete or change
   *
   * @param index
   */
  public static void printCurrentTask(int index) {

    Task task = tasks.get(index - 1);
    String format = "│%6s│%-20s│%-62s│%-21s│%-31s│%-18s│%-7s│%n";
    System.out.println();

    String title = truncateString(task.getTitle(), 20);
    String message = truncateString(task.getMessage(), 58);
    String categoryName = truncateString(task.getCategory().getNameCategory(), 24);
    String priority = truncateString(task.getPriority().getPriority(), 24);
    String dateString =
        task.getPlaneDate() != null ? DataConvert.formatDate(task.getPlaneDate()) : "Без даты";
    String status = task.isDone() ? "      ✔️       " : "      ❌       ";

    System.out.printf(format, index, title, message, categoryName, priority, dateString, status);
    System.out.println(Table.FOOTER);
    System.out.println();
  }

  /**
   * this method use to print all tasks in task list
   */
  public static void printTaskList() {
    System.out.println(Table.HEADER);
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
        System.out.println(Table.MIDDLE);
      }
    }
    System.out.println(Table.FOOTER);
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
    System.out.println(
        ColorsSet.BLACK_BOLD + ColorsSet.WHITE_BACKGROUND + "      ПРОДОЛЖИТЬ ИЗМЕНЕНИЯ ?       "
            + ColorsSet.RESET);

    list.add(ColorsSet.WHITE_BOLD_BRIGHT + ColorsSet.YELLOW_BACKGROUND + "   -  ДА     "
        + ColorsSet.RESET + "      ");
    list.add(ColorsSet.WHITE_BOLD_BRIGHT + ColorsSet.PURPLE_BACKGROUND + "   -  НЕТ    "
        + ColorsSet.RESET + "      ");

    printListChoiceYesOrNo(list);
    System.out.println();
  }

  public static void printListChoiceYesOrNo(List<String> list) {
    for (int i = 0; i < list.size(); i++) {
      int index = i + 1;
      System.out.println(index + ". " + list.get(i));
    }
  }

  public static Priority assigningValuePriority(Scanner sc) {
    System.out.println(Panel.SHOW_PRIORITY_CHOICE);

    int choiceForPriority = Input.readIntLimited(1, 3);

    Priority priorityNewTask = tasksService.choicePriority(choiceForPriority);
    return priorityNewTask;
  }

  public static Category assigningValueCategory(Scanner sc) {
    System.out.println(Panel.SHOW_CATEGORY_MENU);

    int choiceFromCategory = Input.readIntLimited(1, 5);

    Category categoryNewTask = tasksService.choiceCategory(choiceFromCategory);
    return categoryNewTask;
  }
}
