package advanced.april_12;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapTest {

  static class User{
 private  int id;
  private String name;

   public User(int id, String name) {
     this.id = id;
     this.name = name;
   }

   public int getId() {
     return id;
   }

   public void setId(int id) {
     this.id = id;
   }

   public String getName() {
     return name;
   }

   public void setName(String name) {
     this.name = name;
   }
    // Overriding toString() method of String class
    @Override
    public String toString() {
      return this.id + " + " + this.name + " ";
    }

 }



  // Main method
  public static void main(String[] args) {
    HashMap<String, String> keyVal
        = new HashMap<>();
    keyVal.put("a", "Apple");
    keyVal.put("b", "Banana");
    keyVal.put("c", "Citus");
    keyVal.put("d", "Drink");
    // Create a HashMap and add some values
    HashMap<String, Integer> map
        = new HashMap<>();
    map.put("a", 100);
    map.put("b", 300);
    map.put("c", 300);
    map.put("d", 400);

    // print map details
   /* Map<Integer, Integer> keyVal = Map.of(1,11,
        2,22,
        3,33,
        4,44,
        5,55,
        6,66,
        7,77,
        8,88,
        9,99);
    Map<Integer, User> usersMap = Map.of(
        1, new User(1, "Alex"),
        2, new User(2, "Allen"),
        3, new User(3, "Brian"),
        4, new User(4, "Bob"),
        5, new User(5, "Charles"),
        6, new User(6, "David"),
        8, new User(7, "Don"),
        9, new User(8, "Dave"));

    List<Integer> idList = List.of(1, 3, 5, 7);
    Map<Integer, User> filteredMap = usersMap.entrySet()
        .stream()
        .filter(entry -> idList.contains(entry.getKey()))
        .collect(Collectors.toUnmodifiableMap(Map.Entry::getKey, Map.Entry::getValue));

    System.out.println(filteredMap);
    filteredMap = filteredMap.entrySet().stream()
        .collect(Collectors.toMap(e -> keyVal.containsKey(e.getKey())., Map.Entry::getValue));
*/
//    System.out.println(map);
//    map.forEach((K,V) -> { if(keyVal.containsKey(K){
//      map.replace("a", "Apple");
//    })
    //  System.out.println(K + ", Stock : " + V)});
   // map.entrySet()
    //    .stream().forEach()
    //    .allMatch(e - > e.getValue().equals(second.get(e.getKey())));
   // map.computeIfPresent(keyVal.containsKey("a", (key,value) -> value + 1);

    // If key absent assigns a default value
   // map.compute("Angel", (key,value) -> (value == null) ? 1 : value + 1);

   // System.out.println("HashMap after Update : "+map);
  }
}
