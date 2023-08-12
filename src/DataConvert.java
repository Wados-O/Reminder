import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        System.out.println("Неверный формат даты. Используйте [dd.MM.yyyy].");
        return null;
      }


    } catch (ParseException e) {
      e.printStackTrace();
      return null;
    }
  }

  public static String formatDate(Date date) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    return dateFormat.format(date);
  }

  public static boolean checkFormatDate(String dateStr) {
    boolean result = false;
    if (dateStr != null) {
      int day = Integer.parseInt(dateStr.substring(0, 2));
      int month = Integer.parseInt(dateStr.substring(3, 5));
      if (month >= 1 && month <= 12) {
        if (day >= 1 && day <= 31) {
          return true;
        }
      }
    }
    return false;
  }
}
