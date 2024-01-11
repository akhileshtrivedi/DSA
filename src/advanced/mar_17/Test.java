package advanced.mar_17;
/*
import java.util.HashMap;
import java.util.Map;

public class Test {
  private static Map<Integer, String> map
      = new HashMap<>() {
              map.put(1, "GFG");
              map.put(2, "Geek");
              map.put(3, "GeeksForGeeks");
  }
  public static void main(String[] args) {

  }

}*/
// Java program to create a static map

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

class Test {

  // Declaring the static map


  // Driver code
  public static void main(String[] args) {
    Map<Integer, Integer> names = new LinkedHashMap<>();
    names.put(176, 995);
    names.put(182, 1001);
    names.put(116, 674);

    names.forEach((k, v) -> {
      System.out.println("Key = "
          + k + ", Value = " + v);
    });

    Optional<Integer> demoKey = names.entrySet().stream()
        .filter(entry -> Objects.equals(entry.getValue(), 1001))
        .map(Map.Entry::getKey).findFirst();

    if (demoKey.isPresent()) {
      System.out.println(demoKey.get());
    }
  }
}
