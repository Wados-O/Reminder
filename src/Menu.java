import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Menu extends ColorsSet{

public static final String EXIT_BUTTON = ""
    +  GREEN + "СОХРАНИТЬ И ВЫЙТИ:    "
    + GREEN_BACKGROUND + WHITE_BOLD_BRIGHT + "6 - EXIT " + RESET;
  public static final String SHOW_FIRST_MENU = ""
      + YELLOW+ "ОСНОВНОЕ МЕНЮ:     "
      + WHITE_BOLD_BRIGHT + YELLOW_BACKGROUND + "  1 - ИЗМЕНИТЬ СОСТОЯНИЯ " + RESET + "      "
      + WHITE_BOLD_BRIGHT + YELLOW_BACKGROUND + "  2 -  ДОБАВИТЬ  ЗАДАЧУ  " + RESET + "      "
      + WHITE_BOLD_BRIGHT + YELLOW_BACKGROUND + "  3 -  МЕНЮ   СОРТИРОВКИ " + RESET + "      "
      + WHITE_BOLD_BRIGHT + YELLOW_BACKGROUND + "  4 -  ИЗМЕНИТЬ   ЗАДАЧУ " + RESET + "      "
      + WHITE_BOLD_BRIGHT + YELLOW_BACKGROUND + "  5 -  УДАЛИТЬ  ЗАДАЧУ   " + RESET + "      ";

  public static final String SHOW_SORT_MENU = ""
      + BLUE + "МЕНЮ СОРТИРОВКИ:     " + RESET 
      + WHITE_BOLD_BRIGHT + YELLOW_BACKGROUND + "  1 -   ПО  ДАТЕ    " + RESET + "      "
      + WHITE_BOLD_BRIGHT + YELLOW_BACKGROUND + "  2 - ПО ПРИОРИТЕТУ " + RESET + "      "
      + WHITE_BOLD_BRIGHT + YELLOW_BACKGROUND + "  3 - ПО КАТЕГОРИЯМ " + RESET + "      "
      + WHITE_BOLD_BRIGHT + YELLOW_BACKGROUND + "  4 -  ПО СТАТУСУ   " + RESET + "      "
      + WHITE_BOLD_BRIGHT + YELLOW_BACKGROUND + "  5 - ОСНОВНОЕ МЕНЮ " + RESET + "      ";
}