import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Menu extends ColorsSet{

  // TODO: 14.08.2023 доделать кнопку выхода
  public static final String SHOW_FIRST_MENU = ""
      + GREEN_BRIGHT + "ОСНОВНОЕ МЕНЮ:     "
      + WHITE_BOLD_BRIGHT + YELLOW_BACKGROUND + "  1 - ИЗМЕНИТЬ СОСТОЯНИЯ " + RESET + "      "
      + WHITE_BOLD_BRIGHT + YELLOW_BACKGROUND + "  2 -  ДОБАВИТЬ  ЗАДАЧУ  " + RESET + "      "
      + WHITE_BOLD_BRIGHT + YELLOW_BACKGROUND + "  3 -  МЕНЮ   СОРТИРОВКИ " + RESET + "      "
      + WHITE_BOLD_BRIGHT + YELLOW_BACKGROUND + "  4 -  ИЗМЕНИТЬ   ЗАДАЧУ " + RESET + "      "
      + WHITE_BOLD_BRIGHT + YELLOW_BACKGROUND + "  5 -  УДАЛИТЬ  ЗАДАЧУ   " + RESET + "      ";

  public static final String SHOW_SORT_MENU = ""
      + GREEN_BRIGHT + "МЕНЮ СОРТИРОВКИ:     "
      + WHITE_BOLD_BRIGHT + YELLOW_BACKGROUND_BRIGHT + "  1 -   ПО  ДАТЕ    " + RESET + "      "
      + WHITE_BOLD_BRIGHT + YELLOW_BACKGROUND_BRIGHT + "  2 - ПО ПРИОРИТЕТУ " + RESET + "      "
      + WHITE_BOLD_BRIGHT + YELLOW_BACKGROUND_BRIGHT + "  3 - ПО КАТЕГОРИЯМ " + RESET + "      "
      + WHITE_BOLD_BRIGHT + YELLOW_BACKGROUND_BRIGHT + "  4 -  ПО СТАТУСУ   " + RESET + "      "
      + WHITE_BOLD_BRIGHT + YELLOW_BACKGROUND_BRIGHT + "  5 - ОСНОВНОЕ МЕНЮ " + RESET + "      ";
}