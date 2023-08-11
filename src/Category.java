public enum Category {
HOME(1),
  WORK(2),
  SHOPPING(3),
  PERSONAL(4),
  HEALTH(5);

  private final int num;
  Category(int num) {
  this.num = num;
  }

  public int getNum() {
    return num;
  }
}
