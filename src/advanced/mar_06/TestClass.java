package advanced.mar_06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class TestClass {

  public static void main(String[] args) {
    Map<String, List<Map<String,Integer>>> lhm= new LinkedHashMap<>();
    Map<String,Integer> map= new HashMap<>();
    map.put("newaccountcreated",12);
    map.put("newaccountcreated CPA",39);
    List<Map<String,Integer>> myList =new ArrayList<>();
    myList.add(map);
    //myList.add();

    lhm.put("Leads", myList);

    //lhm.values().stream();
    Stream.of(map.keySet().toString())
        .forEach(System.out::println);


  }

}
