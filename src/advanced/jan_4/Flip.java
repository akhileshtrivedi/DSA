package advanced.jan_4;

import java.util.ArrayList;
import java.util.Arrays;

public class Flip {
  private static ArrayList<Integer> flip(String A) {
    ArrayList<Integer> ans = new ArrayList<Integer>();
    int n = A.length();
    int arr[] = new int[n];
    for(int i=0;i<n;i++){
      if(A.charAt(i)=='0') arr[i] = 1;
      else arr[i] = -1;
    }
    System.out.println(" arr-->"+ Arrays.toString(arr));
    int temp_start = 0, temp_end = 0, start = -1, end = -1, move_start = 0;
    for(int i = 0;i<n;i++){
      if(temp_end+arr[i]<0){
        move_start = i+1;
        temp_end = 0;
      }else temp_end += arr[i];
      if(temp_end > temp_start){
        temp_start = temp_end;
        start = move_start;
        end = i;
      }
    }
    if(start == -1) return ans;
    ans.add(start+1);
    ans.add(end+1);
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(" flip--->"+flip("010"));
    System.out.println(" flip--->"+flip("111"));
  }
}
