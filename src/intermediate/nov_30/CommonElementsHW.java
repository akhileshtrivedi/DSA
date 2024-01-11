package intermediate.nov_30;

import java.util.*;

public class CommonElementsHW {
    private static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer, Integer> firstHM = new HashMap<>();
        Map<Integer, Integer> secondtHM = new HashMap<>();
        for (int i = 0; i < A.size(); i++) {
            firstHM.put(A.get(i), firstHM.get(A.get(i)) == null ? 1 : firstHM.get(A.get(i)) + 1);
        }
        for (int i = 0; i < B.size(); i++) {

            secondtHM.put(B.get(i), secondtHM.get(B.get(i)) == null ? 1 : secondtHM.get(B.get(i)) + 1);
            }
        secondtHM.forEach((k,v) -> {
            if (firstHM.containsKey(k)) {
                int o = firstHM.get(k);
                int n = (o <= v) ? o : v;
                for (int j = 0; j < n; j++) {
                    result.add(k);
                }
            }
        });
        return result;
    }
    private  static void findCommonElements(ArrayList<Integer> A, ArrayList<Integer> B)
    {ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> firstHM = new HashMap<>();
        HashMap<Integer, Integer> secondtHM = new HashMap<>();
        for (int i = 0; i < A.size(); i++) {
            if (firstHM.containsKey(A.get(i))) {
                firstHM.put(A.get(i),
                        firstHM.get(A.get(i)) + 1);
            }
            else {
                firstHM.put(A.get(i), 1);
            }
        }

        for (int i = 0; i < B.size(); i++) {
            secondtHM.put(B.get(i), secondtHM.get(B.get(i)) == null ? 1 : secondtHM.get(B.get(i)) + 1);
            }
        System.out.println("firstHM-->"+firstHM);
        System.out.println("secondtHM-->"+secondtHM);
        secondtHM.forEach((k,v) ->{
            if( firstHM.containsKey(k)){
              Object o=  firstHM.get(k);
              int n = (o==v)?(int)o:v;
                System.out.println("firstHM Object-->"+o);
               for(int j=0;j<n;j++){
                   result.add(k);
               }
                System.out.println("result--->"+result);
            System.out.println("Key = "
                + k + ", Value = " + v);}});
    }


    public static void main(String[] args) {
       // findCommonElements(new ArrayList<Integer>(Arrays.asList(1, 2, 2, 1)), new ArrayList<Integer>(Arrays.asList(2, 3, 1, 2)));
       System.out.println(""+solve(new ArrayList<Integer>(Arrays.asList(1, 2, 2, 1)), new ArrayList<Integer>(Arrays.asList(2, 3, 1, 2))));
        System.out.println(""+solve(new ArrayList<Integer>(Arrays.asList(2, 1, 4, 10)), new ArrayList<Integer>(Arrays.asList(3, 6, 2, 10, 10))));
      //  findCommonElements(new ArrayList<Integer>(Arrays.asList(2, 1, 4, 10)), new ArrayList<Integer>(Arrays.asList(3, 6, 2, 10, 10)));

    }

}
