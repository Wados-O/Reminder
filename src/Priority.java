public enum Priority {
  HIGH(1,Style.RED + "ВЫСОКИЙ " + Style.RESET),
  MEDIUM(2, Style.YELLOW+ "СРЕДНИЙ" + Style.RESET),
  LOW(3,Style.GREEN + "НИЗКИЙ" + Style.RESET),
      ;
private int num;
private String priority;

  Priority(int num, String priority) {
    this.num = num;
    this.priority = priority;
  }

  public int getNum() {
    return num;
  }

  public String getPriority() {
    return priority;
  }


}
