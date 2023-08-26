import view.ColorsSet;

public enum Priority {

  HIGH(1, ColorsSet.RED + "ВЫСОКИЙ " + ColorsSet.RESET),
  MEDIUM(2, ColorsSet.YELLOW + "СРЕДНИЙ" + ColorsSet.RESET),
  LOW(3, ColorsSet.GREEN + "НИЗКИЙ" + ColorsSet.RESET);

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
