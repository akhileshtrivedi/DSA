package intermediate.dec_21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SubsetIntArr1 {

    // method that displays all the subsets with the help of the method getSubsets
    public void displayAllSubsets(int s, ArrayList<Integer> inputArrList)
    {
// 2D vector for storing the final array list
        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<Integer>());
        for (int val = 1; val <= Math.pow(2, s) - 1; val++)
        {
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int j = 0; j <= s - 1; j++) {
                if ((val & (1 << j)) == (1 << j))
                {
                    System.out.println(val+"Test-->"+inputArrList.get(j));
                    tmp.add(inputArrList.get(j));
                }

            }
            answer.add(tmp);
        }

        System.out.println("answer-->"+answer);
// Printing the final answer
        for (int i = 0; i < answer.size(); i++)
        {
// Sorting and printing each subset
            Collections.sort(answer.get(i));
            System.out.print("[ ");
            for (int j = 0; j < answer.get(i).size(); j++)
            {
                System.out.print(answer.get(i).get(j) + " ");
            }
            System.out.print("]");
            System.out.println( );
        }



    }



    // a method that generates all the subsets of the input list
    private void getSubsets(int i, ArrayList<Integer> tmp, ArrayList<ArrayList<Integer>> answer, ArrayList<Integer> inputArrList)
    {

// handling the base case
        if (i == inputArrList.size())
        {
// including the generated current subset (which is non empty) to the 2D list answer
            if (tmp.size() > 0)
            {
                answer.add(tmp);
            }
            return;
        }

// Invoking the subset that has the ith array element inside it
        ArrayList<Integer> tmp1 = new ArrayList<>(tmp);
        tmp1.add(inputArrList.get(i));
        getSubsets(i + 1, tmp1, answer, inputArrList);

// Generating the subset that will not contain the ith array element
        getSubsets(i + 1, tmp, answer, inputArrList);
    }

    // main method
    public static void main(String argvs[])
    {

// creating an object of the class SubsetIntArr1
        SubsetIntArr1 obj = new SubsetIntArr1();

// creating an object of the class ArrayList
        ArrayList<Integer> arrList = new ArrayList<Integer>(Arrays.asList(12,13));

// input 1
      /*  for (int j = 1; j <= 3; j++)
        {
            arrList.add(j);
        }*/

        System.out.println("For the array list: " + arrList + " \n");

        System.out.println("The subsets are: ");

        obj.displayAllSubsets(arrList.size(), arrList );

        System.out.println();

     /*   arrList.clear();

// input 2
        for (int j = 1; j <= 5; j++)
        {
            arrList.add(j);
        }

        System.out.println("For the array list: " + arrList + " \n");

        System.out.println("The subsets are: ");

        obj.displayAllSubsets(arrList.size(), arrList );*/



    }
}
