public interface Table {
  String HEADER = """
┌──────┬────────────────────┬──────────────────────────────────────────────────────────────┬─────────────────────┬────────────────────┬──────────────────┬───────────────┐
│   #  │     Наименование   │                           Описание                           │      Категория      │    Приоритет       │       Дата       │    Статус     │
├──────┼────────────────────┼──────────────────────────────────────────────────────────────┼─────────────────────┼────────────────────┼──────────────────┼───────────────┤  """;

String MIDDLE = "├──────┼────────────────────┼──────────────────────────────────────────────────────────────┼─────────────────────┼────────────────────┼──────────────────┼───────────────┤";
String FOOTER = "└──────┴────────────────────┴──────────────────────────────────────────────────────────────┴─────────────────────┴────────────────────┴──────────────────┴───────────────┘";
}
