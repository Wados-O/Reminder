package view;

public class Panel extends ColorsSet {

  public static final String EXIT_BUTTON = ""
      + GREEN + "СОХРАНИТЬ И ВЫЙТИ:    "
      + GREEN_BACKGROUND + WHITE_BOLD_BRIGHT + "  6 - EXIT   " + RESET;
  public static final String SHOW_FIRST_MENU = ""
      + YELLOW + "ОСНОВНОЕ МЕНЮ:  "
      + WHITE_BOLD_BRIGHT + YELLOW_BACKGROUND + " 1 - ИЗМЕНИТЬ СОСТОЯНИЯ " + RESET + "   "
      + WHITE_BOLD_BRIGHT + YELLOW_BACKGROUND + " 2 -  ДОБАВИТЬ  ЗАДАЧУ  " + RESET + "   "
      + WHITE_BOLD_BRIGHT + YELLOW_BACKGROUND + " 3 -  МЕНЮ   СОРТИРОВКИ " + RESET + "   "
      + WHITE_BOLD_BRIGHT + YELLOW_BACKGROUND + " 4 -  ИЗМЕНИТЬ   ЗАДАЧУ " + RESET + "   "
      + WHITE_BOLD_BRIGHT + YELLOW_BACKGROUND + " 5 -  УДАЛИТЬ  ЗАДАЧУ   " + RESET + "   ";
  public static final String SHOW_CATEGORY_MENU = ""
      + YELLOW + "ВЫБИРЕТЕ КАТЕГОРИЮ:  "
      + WHITE_BOLD_BRIGHT + GREEN_BACKGROUND + "   1  -   ДОМ       " + RESET + "      "
      + WHITE_BOLD_BRIGHT + YELLOW_BACKGROUND + "   2  -  РАБОТА     " + RESET + "      "
      + WHITE_BOLD_BRIGHT + PURPLE_BACKGROUND + "   3  -  ПОКУПКИ    " + RESET + "      "
      + WHITE_BOLD_BRIGHT + CYAN_BACKGROUND + "   4  -  ЛИЧНОЕ     " + RESET + "      "
      + WHITE_BOLD_BRIGHT + BLUE_BACKGROUND + "   5  - ЗДОРОВЬЕ    " + RESET + "     ";
  public static final String SHOW_PRIORITY_CHOICE = " "
      + YELLOW + "УКАЖИТЕ ПРИОРИТЕТ ЗАДАЧИ:     " + RESET
      + WHITE_BOLD_BRIGHT + RED_BACKGROUND + "   1 - ВЫСОКИЙ    " + RESET + "      "
      + WHITE_BOLD_BRIGHT + YELLOW_BACKGROUND + "   2 - СРЕДНИЙ    " + RESET + "      "
      + WHITE_BOLD_BRIGHT + GREEN_BACKGROUND + "   3 - ОБЫЧНЫЙ    " + RESET + "      ";
  public static final String SHOW_SORT_MENU = ""
      + PURPLE + " МЕНЮ СОРТИРОВКИ:      " + RESET
      + WHITE_BOLD_BRIGHT + YELLOW_BACKGROUND + "   1 -   ПО  ДАТЕ     " + RESET + "         "
      + WHITE_BOLD_BRIGHT + YELLOW_BACKGROUND + "   2 - ПО ПРИОРИТЕТУ  " + RESET + "         "
      + WHITE_BOLD_BRIGHT + YELLOW_BACKGROUND + "   3 - ПО КАТЕГОРИЯМ  " + RESET + "         "
      + WHITE_BOLD_BRIGHT + YELLOW_BACKGROUND + "   4 -  ПО СТАТУСУ    " + RESET + "         "
      + WHITE_BOLD_BRIGHT + YELLOW_BACKGROUND + "   5 - ОСНОВНОЕ МЕНЮ  " + RESET + "         ";

  public static final String SHOW_MENU_REFACTOR = " "
      + BLACK_BOLD + WHITE_BACKGROUND + "  ЧТО ВЫ ХОТИТЕ ИЗМЕНИТЬ?        " + RESET
      + WHITE_BOLD_BRIGHT + GREEN_BACKGROUND + "  1 - НАЗВАНИЯ  " + RESET + "        "
      + WHITE_BOLD_BRIGHT + YELLOW_BACKGROUND + "  2 - ОПИСАНИЯ  " + RESET + "        "
      + WHITE_BOLD_BRIGHT + PURPLE_BACKGROUND + "  3 - КАТИГОРИЮ " + RESET + "      "
      + WHITE_BOLD_BRIGHT + CYAN_BACKGROUND + "  4 - ПРИОРИТЕТ " + RESET + "       "
      + WHITE_BOLD_BRIGHT + BLUE_BACKGROUND + " 5 - ДАТУ ИСПОЛНЕНИЯ " + RESET + "     "
      + WHITE_BOLD_BRIGHT + GREEN_BACKGROUND + "  6 -  СТАТУС   " + RESET + "        ";
  public static final String SHOW_CHOICE_YES_NO = " "
      + BLACK_BOLD + WHITE_BACKGROUND + "      ПРОДОЛЖИТЬ ИЗМЕНЕНИЯ ?       " + RESET
      + "           "
      + WHITE_BOLD_BRIGHT + YELLOW_BACKGROUND + "   1  -  ДА     " + RESET + "      "
      + WHITE_BOLD_BRIGHT + PURPLE_BACKGROUND + "   3  -  НЕТ    " + RESET + "      ";
}
