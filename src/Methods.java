import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Methods implements Table {

  private Input input;
  static List<Task> tasks = Input.arrayList;
  Scanner sc = new Scanner(System.in);

  public static void firstMenu(Scanner sc) throws IOException {
    Intro.speedJump();
    Methods.printTaskList();
    while (true) {
      System.out.println(Menu.SHOW_FIRST_MENU);
      System.out.println();
      System.out.println(Menu.EXIT_BUTTON);
      int choice = Input.readIntLimited(1,5);
      switch (choice) {
        case 1:
          changeTaskStatus(sc);
          break;
        case 2:
          addTask(sc);
          break;
        case 3:
          sortMenu(sc);
          break;
        case 4:
        correctingTask(sc);
          break;
        case 5:
          remove(sc);
          break;
        case 6 :
          System.out.println("До свидания!!!");
          Input.closeFileWithSaving();
          System.exit(0);
      }
    }

  }
  public static void sortMenu(Scanner sc) throws IOException {
    while (true){
      Intro.speedJump();
      Methods.printTaskList();
      System.out.println(Menu.SHOW_SORT_MENU);
      System.out.println();
      System.out.println(Menu.EXIT_BUTTON);
      int choice = Input.readIntLimited(1,6);
      switch (choice){
        case 1:
          sortDate();
          break;
        case 2:
          sortOnPriority();
          break;
        case 3:
          sortOnCategory();
          break;
        case 4:
          sortIsDone();
        break;
        case 5:
          firstMenu(sc);
          break;
        case 6 :
          System.out.println("До свидания!!!");
          Input.closeFileWithSaving();
          System.exit(0);
      }
    }
  }

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
    System.out.println("Введите номер задачи, которую хотите удалить:");
    printTaskList();
    int numberTask =  Input.readIntLimited(1, tasks.size());
    int indexTask = numberTask - 1;
    tasks.remove(indexTask);
    System.out.println();
  }

  public static void correctingTask(Scanner sc) {
    Intro.speedJump();
    printTaskList();
    System.out.println("Введите номер задачи, которую хотите изменить:");

    int numberTask =  Input.readIntLimited(1, tasks.size());
    int indexTask = numberTask - 1;

    while (true) {
      System.out.print("Ваша задача: " + tasks.get(indexTask).toString()
          + "\nВы хотите что-либо изменить в задаче? Выберите нужный пункт: \n");
      System.out.println();
      choiceYesOrNo();
      int choice = Input.readIntLimited(1, 2);
      if (choice == 1) {
        System.out.print("Что вы хотите изменить в задаче, выберите номер из списка: \n");
        System.out.println("""
            1. Название задачи
                    2. Описание задачи
                    3. Категория задачи
                    4. Приоритет задачи
                    5. Статус задачи
                """);
        int number = Input.readIntLimited(1, 5);

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
            System.out.println("Выберите статус задачи:");
            System.out.println("1. Выполнено");
            System.out.println("2. Не выполнено");
            int statusChoice = Input.readIntLimited(1, 2);

            boolean isDone = (statusChoice == 1);
            tasks.get(indexTask).setDone(isDone);
            break;
          default:
            break;
        }
      }

      if (choice == 2) {
        break;
      }
    }
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

    Date planeDate = null;
    boolean validDate = false;

    while (!validDate) {
      System.out.print("Введите дату планируемого выполнения задачи [dd.MM.yyyy] : ");
      String planeDateStr = sc.nextLine();

      if (planeDateStr.matches("[0-9.,/-]+")) {
        try {
          planeDate = DataConvert.parseDate(planeDateStr);
          Date currentDate = new Date();

          if (planeDate != null && !planeDate.before(currentDate)) {
            validDate = true;
          } else if (planeDate != null) {
            System.out.println(
                ColorsSet.YELLOW + "Дата не может быть раньше текущей даты." + ColorsSet.RESET);
          }
        } catch (NumberFormatException e) {
          System.out.println(ColorsSet.YELLOW + "Неверный формат даты. Используйте [dd.MM.yyyy]."
              + ColorsSet.RESET);
        }
      } else {
        System.out.println(ColorsSet.RED_BRIGHT
            + "Неверный формат даты.Пожалуйста введите время в формате [dd.MM.yyyy]"
            + ColorsSet.RESET);
      }
    }
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
  }

  public static String truncateString(String str, int maxLength) {
    if (str.length() > maxLength) {
      return str.substring(0, maxLength);
    }
    return str;
  }


  public static void choiceYesOrNo() {
    List<String> list = new ArrayList<>();
    list.add("Да");
    list.add("Нет");
    for (int i = 0; i < list.size(); i++) {
      int index = i + 1;
      System.out.println(index + ". " + list.get(i));
    }
    System.out.println();
  }

  public static Priority assigningValuePriority(Scanner sc) {

    System.out.println(Menu.SHOW_PRIORITY_CHOICE);
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
    System.out.println(Menu.SHOW_CATEGORY_MENU);
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
