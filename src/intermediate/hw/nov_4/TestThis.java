package intermediate.hw.nov_4;


import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class TestThis {

    private static  int  solve(String A){
        int n = A.length();
        int count = 0;
        for(int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                count += n - i;
            }
        }
        System.out.println("I am here");
       // System.out.println(count % 10003);
       return count % 10003;
    }
    public static void main(String[] args) {
        List<String> wordsListVal = Arrays.asList("eu", "quero", "voltar", "para", "praia", "e", "comer", "queijo");
        List<String> wordsListKey = Arrays.asList("v.", "quero", "voltar", "para", "praia", "e", "c.");
      Map<String, String> wordsMap = Map.of("CP0004567_2022-01-01","FLIP: OTT/CTV January","CP0004568_2022-01-01","Display Retargeting - Look A Likes & RT January","CP0004567_2022-02-01", "FLIP: OTT/CTV February", "CP0004568_2022-02-01", "Display Retargeting - Look A Likes & RT January",
          "CP0004567_2022-03-01","FLIP: OTT/CTV March","CP0000735_2021-01-01","CP0000735",
          "CP0000735_2021-05-01","CP0000735",
          "CP0000735_2021-06-01","CP0000735", "CP0000735_2021-04-01","CP0000735AT" );
       //Map<String, String> wordsMap2 = Map.of("CP0004567_2022-01-01","FLIP: OTT/CTV January");
      List<KeyValue<? extends Number>> Mylist = new ArrayList<>();
      List<KeyValue<? extends Number>> flist = new ArrayList<>();
      Mylist.add( new KeyValue<>("CP0000735_2021-04-01",5908119.0));
      Mylist.add( new KeyValue<>("800000148_2021-04-01",1374801.0));
      Mylist.add( new KeyValue<>("800000095_2021-04-01",1151116.0));
      Mylist.add( new KeyValue<>("800000155_2021-05-01",690869.0));
      Mylist.add( new KeyValue<>("800000155_2021-05-01",84442.0));
      Mylist.add( new KeyValue<>("800000155_2021-05-01",18315.0));
//      Mylist.add( new KeyValue<>("800000095_2021-05-01",84442.0));
//      Mylist.add( new KeyValue<>("800000156_2021-05-01",18315.0));

//        wordsMap.values().stream()
//            // If the list contains the map value
//            .filter(wordsListKey::contains)
//            .forEach(value -> {
//                // Find the corresponding map key
//                String mapKey = wordsMap.entrySet()
//                    .stream()
//                    .filter(entry -> Objects.equals(entry.getValue(), value))
//                    .map(Map.Entry::getKey) // It could find several keys if you have the same value for different keys
//                    .findFirst()
//                    .orElseThrow(); // It should never happen as we are looping in the map values
//                System.out.println("mapKey-->"+mapKey);
//                System.out.println("value-->"+value);
//                // Find the index and update the list with the map key
//                int index = wordsListKey.indexOf(value);
//              wordsListKey.set(index, mapKey);
//            });
//
//        System.out.println(wordsListKey);
//1
      Mylist.stream().forEach(list->{

        System.out.println("list-->"+list.getKey());
       if(wordsMap.containsKey(list.getKey())){
         System.out.println("In side the wordsMap-->"+wordsMap.get(list.getKey()));
         list.setKey(wordsMap.get(list.getKey()));

       }
      });
//print
//Map<BlogPostType, Integer> likesPerType = posts.stream()
//  .collect(groupingBy(BlogPost::getType, summingInt(BlogPost::getLikes)));
      Mylist.stream().forEach(list-> {

        System.out.println("updated list-->" + list.getKey());
      });


  // 2
    Map<String, Double> map= Mylist.stream()
          .collect(Collectors.groupingBy(keyValue -> keyValue.getKey(),
              Collectors.summingDouble(keyValue -> (double) keyValue.getValue())));



      System.out.println("map--"+map);
        map.forEach((k, v) -> System.out.println(" What-->"+(k + ":" + v)));



        // 3
      map.forEach((k, v) -> {
        flist.add(new KeyValue<>(k,v));
        System.out.println(" What-->"+(k + ":" + v));
      });


      flist.stream().forEach(list-> {

        System.out.println(list.getKey()+"updated flist-->" + list.getValue());
      });
         // .forEach((key,sumValue)->System.out.println(key+"\t"+sumValue));
     // List<KeyValue<? extends Number>>  newList = Mylist.stream().collect(groupingBy(list->list.getKey(),summingDouble(list->list.getValue)));
      //Map<String, Integer> likesPerType =
    //  List<Double> numbers = Arrays.asList(3.0, 5.5, 11.3, 40.3, 21.1);
    //  Double sum = numbers.stream().collect(Collectors.summingDouble(Double::doubleValue));
    //  System.out.println(sum);

    }
}
