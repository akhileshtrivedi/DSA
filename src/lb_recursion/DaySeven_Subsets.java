package lb_recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DaySeven_Subsets {
  public static void
  findSubsets(List<List<Integer>> subset, ArrayList<Integer> nums, ArrayList<Integer> output, int index)
  {
    // Base Condition
    if (index == nums.size()) {
      subset.add(output);
      return;
    }

    // Excluding Value which is at Index
    findSubsets(subset, nums, new ArrayList<>(output), index + 1);

    // Including Value which is at Index
    output.add(nums.get(index));
    findSubsets(subset, nums, new ArrayList<>(output), index + 1);
  }
private static List<List<Integer>> solve(ArrayList<Integer> input){
  List<List<Integer> > subset = new ArrayList<>();
  findSubsets(subset, input, new ArrayList<>(), 0);
  return subset;
}
private static void findSequences(ArrayList<String> sequence, String input, String output, int index){
    if(index>=input.length()){
      sequence.add(output);
      return;
    }
  //excluding
  findSequences(sequence,input,output,index+1);
   //including
  output=output+input.charAt(index);
  findSequences(sequence,input,output,index+1);
}
private static ArrayList<String> solve(String input) {
  ArrayList<String> sequence = new ArrayList<>();
  String output="";
  findSequences(sequence, input, output, 0);
  return  sequence;
}
  public static void main(String[] args) {
    //Sequence of String
   //
    String strInput="abc";
    ArrayList<String> sequence = solve(strInput);
    System.out.println(sequence);
    //Subsets
    int[] arr = {1, 2, 3};
  //  System.out.println(""+subsets(arr));

    //Second way
    // Input ArrayList
    ArrayList<Integer> input = new ArrayList<>();
    input.add(1);
    input.add(2);
    input.add(3);
    List<List<Integer> > subset=solve(input);
   // System.out.println(""+subset);
    //findSubsets(subset, input, new ArrayList<>(), 0);

    Collections.sort(subset, (o1, o2) -> {
      int n = Math.min(o1.size(), o2.size());
      for (int i = 0; i < n; i++) {
        if (o1.get(i) == o2.get(i)) {
          continue;
        }
        else {
          // sort based on the unequal elements value
          return o1.get(i) - o2.get(i);
        }
      }
      // sort based on size
      return o1.size() - o2.size();
    });
   // System.out.println(""+subset);



  }

}
