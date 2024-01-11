package sat;

import java.util.*;

public class FindCommonElement {
  /*  public Set getCommonElements(int a[], int b[]) {
        Set<Integer> firstSet = new HashSet();
        Set<Integer> secondSet = new HashSet();
        for (int i : a) {
            firstSet.add(i);
        }
        System.out.println(firstSet);
        for (int i : b) {
            secondSet.add(i);
        }
        firstSet.retainAll(secondSet);
        System.out.println(firstSet + "---" + secondSet);
        return firstSet;
    } */

    public List  getCommonElementsNew(int a[], int b[]) {
        Arrays.sort(a);
        Arrays.sort(b);
        List<Integer> finalList = new ArrayList();
        int k=0;
        for (int i=0; i<a.length;i++) {
            for (int j=k;j<b.length; j++) {
                if (a[i] == b[j]) {
                    finalList.add(a[i]);
                    k++;
                    break;
                }
            }
        }
        return finalList;
    }

    public static void main(String[] args) {
        int a[] = {1, 2, 2, 1};
        int b[] = {2, 3, 1, 2}; //1,2,2
        int a2[] = {2, 1, 4, 10};
        int b2[] = {3, 6, 2, 10, 10};// 2,10
        FindCommonElement e = new FindCommonElement();
       // System.out.println("--->" + e.getCommonElements(a, b));
       // System.out.println("--->"+e.getCommonElements(a2,b2));
        System.out.println("Second way");
        System.out.println("--->" + e.getCommonElementsNew(a, b));
        System.out.println("--->"+e.getCommonElementsNew(a2,b2));
    }
}
