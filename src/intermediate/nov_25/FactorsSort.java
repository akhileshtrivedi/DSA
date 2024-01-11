package intermediate.nov_25;

import java.util.ArrayList;

// Java implementation to sort numbers on
// the basis of factors

import java.util.Arrays;
import java.util.Comparator;

class FactorsSort {
    int index, no_of_fact;

    public FactorsSort(int i, int countFactors) {
        index = i;
        no_of_fact = countFactors;
    }

    private static int countFactors(int n) {
        int count = 0;
        int sq = (int) Math.sqrt(n);
        if (sq * sq == n)
            count++;

        for (int i = 1; i < Math.sqrt(n); i++) {
            if (n % i == 0)
                count += 2;
        }

        return count;
    }
    private static void printOnBasisOfFactorsOLD(int arr[], int n) {
        FactorsSort num[] = new FactorsSort[n];
        for (int i = 0; i < n; i++) {
            num[i] = new FactorsSort(i, countFactors(arr[i]));
        }
        Arrays.sort(num, new Comparator<FactorsSort>() {
            @Override
            public int compare(FactorsSort e1, FactorsSort e2) {
                if (e1.no_of_fact == e2.no_of_fact)
                    return e1.index < e2.index ? -1 : 1;

                // sort in decreasing order of number of factors
                return e1.no_of_fact > e2.no_of_fact ? -1 : 1;
            }
        });
        for (int i = 0; i < n; i++)
            System.out.print(arr[num[i].index] + " ");
    }
    private static ArrayList<Integer>  printOnBasisOfFactors(ArrayList<Integer> A) {
        int n = A.size();
        FactorsSort num[] = new FactorsSort[n];
        for (int i = 0; i < n; i++) {
            num[i] = new FactorsSort(i, countFactors(A.get(i)));
        }
        Arrays.sort(num, new Comparator<FactorsSort>() {
            @Override
            public int compare(FactorsSort e1, FactorsSort e2) {
                if (e1.no_of_fact == e2.no_of_fact)
                    return e1.index < e2.index ? -1 : 1;

                // sort in decreasing order of number of factors
                return e1.no_of_fact > e2.no_of_fact ? -1 : 1;
            }
        });
        for (int i=0; i<n; i++)
            System.out.print(A.get(i)+" ");

return A;
    }
    public static void main(String[] args) {
        ArrayList<Integer> A =new ArrayList<>(Arrays.asList(5, 11, 10, 20, 9, 16, 23));
       // int arr[] = {5, 11, 10, 20, 9, 16, 23};
        System.out.println("printOnBasisOfFactors--->"+printOnBasisOfFactors(A));
       // printOnBasisOfFactors(A);

    }
}
// This code is contributed by Gaurav Miglani
