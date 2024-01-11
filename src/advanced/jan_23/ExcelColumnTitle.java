package advanced.jan_23;

public class ExcelColumnTitle {

  static String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

  static String num_hash(int num) {
    if (num < 26) {
      return Character.toString(alpha.charAt(num - 1));
    } else {

      int q = Math.floorDiv(num, 26);
      System.out.println(q + " num " + num);
      int r = num % 26;
      System.out.println(r + " num " + num);
      if (r == 0) {
        if (q == 1) {
          return Character.toString(alpha.charAt((26 + r - 1) % 26));
        } else {
          return num_hash(q - 1) + alpha.charAt((26 + r - 1) % 26);
        }
      } else {
        return num_hash(q) + alpha.charAt((26 + r - 1) % 26);
      }

    }
  }

  public static void main(String[] args) {
    System.out.println(num_hash(26));
   /* System.out.println(num_hash(26));
    System.out.println(num_hash(51));
    System.out.println(num_hash(52));
    System.out.println(num_hash(80));
    System.out.println(num_hash(676));
    System.out.println(num_hash(702));
    System.out.println(num_hash(705));*/

  }
}
