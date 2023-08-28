package input;

import static view.ColorsSet.PURPLE;
import static view.ColorsSet.RESET;


import java.util.Scanner;


public class InputConsole {
  /**
   * проверка неправильного ввода только цифры
   *
   * @param min
   * @param max
   * @return
   */
  public static int readIntLimited(int min, int max) {
    Scanner sc = new Scanner(System.in);
    int num = 0;
    do {
      try {
        num = Integer.parseInt(sc.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("Вводите только цифры");
        System.out.println();
      }
      if (!(num >= min && num <= max)) {
        System.out.println(PURPLE);
        System.out.printf("Введите число от %d до %d:", min, max);
        System.out.println(RESET);
      }
    } while (!(num >= min && num <= max));
    return num;
  }

  /**
   * проверка на длину строки
   *
   * @param minLength
   * @param maxLength
   * @return
   */
  public static String readStringLimited(int minLength, int maxLength) {
    Scanner sc = new Scanner(System.in);
    String input;

    while (true) {
      input = sc.nextLine();
      if (input.length() >= minLength && input.length() <= maxLength && !containsNumbers(input)) {
        break;
      } else {
        System.out.println(PURPLE);
        System.out.printf("Введите строку длиной от %d до %d символов без чисел: ", minLength,
            maxLength);
        System.out.println(RESET);
      }
    }

    return input;
  }

  /**
   * Проверка на содержания символов
   *
   * @param input
   * @return
   */
  private static boolean containsNumbers(String input) {
    return input.matches(".*\\d+.*");
  }


}
