package intermediate.nov_21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Element
{

    int index, no_of_fact;

    public Element(int i, int countFactors)
    {
        index = i;
        no_of_fact = countFactors;
    }

   private  static int countFactors(int n)
    {
        int count = 0;
        int sq = (int)Math.sqrt(n);

        if (sq * sq == n)
            count++;

        for (int i=1; i<Math.sqrt(n); i++)
        {

            if (n % i == 0)
                count += 2;
        }

        return count;
    }
    private static ArrayList<Integer> printOnBasisOfFactors(ArrayList<Integer> A )

    {
        ArrayList<Integer> ans = new ArrayList<>(0);
        int n=A.size();
        Element num[] = new Element[n];

        for (int i=0; i<n; i++)
        {
            num[i] = new Element(i,countFactors(A.get(i)));
        }

        Arrays.sort(num,new Comparator<Element>() {

            @Override
            public int compare(Element e1, Element e2) {
                if (e1.no_of_fact == e2.no_of_fact)
                    return e1.index < e2.index ? -1 : 1;
                return e1.no_of_fact > e2.no_of_fact ? -1 : 1;
            }

        });
        for (int i=0; i<n; i++)
            ans.add(A.get(num[i].index));
        return ans;

//        for (int i=0; i<n; i++)
//            System.out.print(arr[num[i].index]+" ");
    }
    public static void main(String[] args)
    {

      //  int arr[] = {5, 11, 10, 20, 9, 16, 23};
        ArrayList<Integer> A =new ArrayList<>(Arrays.asList(5, 11, 10, 20, 9, 16, 23));
        // int arr[] = {5, 11, 10, 20, 9, 16, 23};
        System.out.println("printOnBasisOfFactors--->"+printOnBasisOfFactors(A));

       // printOnBasisOfFactors(arr, arr.length);

    }
}