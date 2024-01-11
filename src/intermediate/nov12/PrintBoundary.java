package intermediate.nov12;

import java.util.ArrayList;
import java.util.Arrays;

public class PrintBoundary {
    private static int getPrintBoundary(ArrayList<ArrayList<Integer>> at,int N, int i, int j, int lastNum) {
        int num=lastNum;
        System.out.println(N+"<---N-- I->"+i+" J-->"+j);
        System.out.println("at--->"+at);
        for(int k=1;k<=N-1;k++){
            System.out.println("For first row -->-->"+num);
            at.get(i).set(j,num);
num++;
           // System.out.println("  For first row -->"+at.get(i).get(j));
            j++;
        }
        for(int k=1;k<=N-1;k++){
            System.out.println("  For last col -->"+num);
            at.get(i).set(j,num);
           // System.out.println("  For last col -->"+at.get(i).get(j));
            i++;
            num++;
        }
        for(int k=1;k<=N-1;k++){
            System.out.println("  For last row -->"+num);
            at.get(i).set(j,num);
            //System.out.println("  For last row -->"+at.get(i).get(j));
            j--;
            num++;
        }
        for(int k=1;k<=N-1;k++){
            System.out.println("  For first col -->"+num);
            at.get(i).set(j,num);
            //System.out.println("  For first col -->"+at.get(i).get(j));
            i--;
            num++;
        }
       return num;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> print1 = new ArrayList<>();
       // ArrayList<ArrayList<Integer>> print = new ArrayList<>();
        ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
        ArrayList<Integer> al = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        ArrayList<Integer> al2 = new ArrayList<>(Arrays.asList(6, 7, 8, 9, 10));
        ArrayList<Integer> al3 = new ArrayList<>(Arrays.asList(11, 12, 13, 14, 15));
        ArrayList<Integer> al4 = new ArrayList<>(Arrays.asList(16, 17, 18, 19, 20));
        ArrayList<Integer> al5 = new ArrayList<>(Arrays.asList(21, 22, 23, 24, 25));
        mat.add(al);
        mat.add(al2);
        mat.add(al3);
        mat.add(al4);
        mat.add(al5);

        int i=0,j=0,N=3;
//        if (n>0){
//              int element=1;
//            for(int ii=0;ii<n;ii++){
//                for(int jj=0;jj<n;jj++){
//                    System.out.println("index i is "+ii+" Index j is "+jj);
//                    System.out.println(element);
//                    element++;
//                }
//            }
//        }
        ArrayList<ArrayList<Integer>> print = new ArrayList<>();
        if (N>0){
            int element=1;
            for(int x=0;x<N;x++){
                ArrayList<Integer> col = new ArrayList<>();
                for(int y=0;y<N;y++){
                    col.add(element);
                    element++;
                }
                print.add(col);
            }
        }
       int lastNum =1;
        while(N>1){
            lastNum =getPrintBoundary(print,N,i, j,lastNum);
            i++;
            j++;
            N-=2;
        }
        if(N==1){
            System.out.println(N+"<---for N lastNum "+lastNum);
            print.get(print.size()/2).set(print.size()/2,lastNum);
        }
        System.out.println("Final list-->"+print);


    }
}
