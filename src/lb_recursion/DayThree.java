package lb_recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class DayThree {
private static boolean isSorted(ArrayList<Integer> arr,int  size){
  boolean flag;
  if(size==0|| size==1){
    return true;
  }
  if(arr.get(0)>arr.get(1)){
    return false;
  }else{
    arr.remove(0);
    flag=isSorted( arr, size-1);

  }
  return flag;
}


  public static void main(String[] args) {
    int[] arr = new int[]{1,2,3,4,5};
    int[] arr_new = new int[arr.length-1];

    ArrayList<Integer> list= new ArrayList<Integer>(Arrays.asList(1,2,6,4,5));
    System.out.println("Before deletion :" + isSorted(list, list.size()));
    //System.out.println("After deletion :" + Arrays.toString(arr_new));

  }


}
