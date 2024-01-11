package advanced.jan_27;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestJava {

  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>(Collections.nCopies(10, 0));
    ArrayList<Integer> myList=new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
    System.out.println(list);
    for(int i=0;i<myList.size();i++){
      list.set(i, myList.get(i));
    }
    System.out.println(list);
  }

}
