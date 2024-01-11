package lb_recursion;

import java.util.ArrayList;

public class DayEight {

  private static void solve(String digits, String output, int index, ArrayList<String> ans,
      String[] mapping) {
    //Base Case
    if (index >= digits.length()) {
      ans.add(output);
      return;
    }
    //get char into number
    int number = digits.charAt(index) - '0';
    //Get set of chars for a particular number
    String value = mapping[number];
    //Here recursive call for every single char
    for (int i = 0; i < value.length(); i++) {
      output = output + value.charAt(i);
      solve(digits, output, index + 1, ans, mapping);
      output = output.substring(0, output.length() - 1);

    }
  }

  private static ArrayList<String> letterCombinations(String digits) {
    ArrayList<String> ans = new ArrayList<>();
    String output = "";
    int index = 0;
    if(digits.length()<1)
      return ans;
    String mapping[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    solve(digits, output, index, ans, mapping);
    return ans;
  }

  public static void main(String[] args) {
    System.out.println("" + letterCombinations("23"));
  }


}
