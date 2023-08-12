import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataConvert {
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
