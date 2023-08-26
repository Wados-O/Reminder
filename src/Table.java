public interface Table {

  String HEADER = """
      ┌──────┬────────────────────┬──────────────────────────────────────────────────────────────┬─────────────────────┬────────────────────┬──────────────────┬───────────────┐
      │  id  │     Наименование   │                           Описание                           │      Категория      │    Приоритет       │       Дата       │    Статус     │
      ├──────┼────────────────────┼──────────────────────────────────────────────────────────────┼─────────────────────┼────────────────────┼──────────────────┼───────────────┤  """;

  String MIDDLE = "├──────┼────────────────────┼──────────────────────────────────────────────────────────────┼─────────────────────┼────────────────────┼──────────────────┼───────────────┤";
  String FOOTER = "└──────┴────────────────────┴──────────────────────────────────────────────────────────────┴─────────────────────┴────────────────────┴──────────────────┴───────────────┘";
}
