public enum Category {
 HOME(1,"HOME"),
  WORK(2,"WORK"),
  SHOPPING(3,"SHOPPING"),
  PERSONAL(4,"PERSONAL"),
  HEALTH(5,"HEALTH");

  private final int num;
private String nameCategory;
  Category(int num, String nameCategory) {
  this.num = num;
   this.nameCategory = nameCategory;
  }

  public int getNum() {
    return num;
  }

 public String getNameCategory() {
  return nameCategory;
 }

// @Override
// public String toString() {
//  return "Category{" +
//         "num=" + num +
//         ", nameCategory='" + nameCategory + '\'' +
//         '}';
// }
}
