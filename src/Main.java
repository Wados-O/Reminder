import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    while (true) {
      System.out.println("Добро пожаловать в программу ");
      System.out.println("""
          1.Распечатать список из файла 
          2.Выход из программы 
          """);
      int choice = sc.nextInt();
      switch (choice) {
        case 1:
          taskToPrint(sc);
          break;
        case 2:
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
}