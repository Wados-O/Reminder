package input;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import view.ColorsSet;

public class DataConvert {

  public static Date parseDate(String dateStr) {
    SimpleDateFormat dateFormatDash = new SimpleDateFormat("dd-MM-yyyy");
    SimpleDateFormat dateFormatComa = new SimpleDateFormat("dd,MM,yyyy");
    SimpleDateFormat dateFormatSlash = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat dateFormatDot = new SimpleDateFormat("dd.MM.yyyy");

    try {
      if (dateStr.contains("-")) {
        return dateFormatDash.parse(dateStr);
      } else if (dateStr.contains(".")) {
        return dateFormatDot.parse(dateStr);
      } else if (dateStr.contains(",")) {
        return dateFormatComa.parse(dateStr);
      } else if (dateStr.contains("/")) {
        return dateFormatSlash.parse(dateStr);
      } else {
        System.out.println(
            ColorsSet.YELLOW + "Неверный формат даты. Используйте [dd.MM.yyyy]." + ColorsSet.RESET);
        return null;
      }
    } catch (ParseException e) {
      e.printStackTrace();
      return null;
    }
  }

  public static Date choicePlaneDate(Scanner sc) {
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
    return planeDate;
  }

  public static String formatDate(Date date) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    return dateFormat.format(date);
  }
}
