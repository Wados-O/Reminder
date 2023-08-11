public enum Priority {
  HIGH(1,"HIGH"),
  MEDIUM(2,"MEDIUM"),
  LOW(3,"LOW"),
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
