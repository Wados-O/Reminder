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
      }  else if (dateStr.contains(",")) {
        return dateFormatComa.parse(dateStr);
      } else if (dateStr.contains("/")) {
        return dateFormatSlash.parse(dateStr);
      }else {
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

}
