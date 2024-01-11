package recursion;

import java.util.Collections;

public class ReverseString {
//    private String getReverse(String name ){
//        char [] nameArr = name.toCharArray();
//        int i=0;
//        int size = nameArr.length
//        while(i<size){
//            Collections.swap(nameArr[i], nameArr[size-1])
//
//        }
//        return name;
//    }

    private static String reverse(String str)

    {

        // base case: if the string is null or empty
        if (str == null || str.equals("")) {
            return str;
        }
        // last character + recur for the remaining string
        return str.charAt(str.length() - 1) +
                reverse(str.substring(0, str.length() - 1));
    }

    public static void main(String[] args) {
        String name ="Akhilesh";
        ReverseString rs = new ReverseString();
        // #1
        StringBuilder sb =new StringBuilder();
        sb.append(name);
        System.out.println(name+" reverse is "+sb.reverse());

        // #2
        StringBuffer sb1 =new StringBuffer();
        sb1.append(name);
        System.out.println(name+" reverse is "+sb1.reverse());

        // #3
        char[] resultarray = name.toCharArray();
        System.out.print(name+" reverse is ");
        for (int i = resultarray.length - 1; i >= 0; i--){
            // print reversed String
            System.out.print(""+resultarray[i]);
    }
        System.out.println();
         // #4
        int iStrLength=name.length();

        //Using While loop
        System.out.print(name+" reverse is ");
        while(iStrLength >0)

        {

            System.out.print(name.charAt(iStrLength -1));

            iStrLength--;

        }

        // #5

        System.out.println();
        System.out.print(name+" reverse is ");
        //Using For loop

        for(iStrLength=name.length();iStrLength >0;-- iStrLength)

        {

            System.out.print(name.charAt(iStrLength -1));

        }
     // # 6
        System.out.println();
        byte[] strAsByteArray = name.getBytes();

        byte[] resultoutput = new byte[strAsByteArray.length];

        // Store result in reverse order into the

        // result byte[]

        for (int i = 0; i < strAsByteArray.length; i++) {

            resultoutput[i] = strAsByteArray[strAsByteArray.length - i - 1];
        }
        System.out.println( name+ " reverse is " +new String(resultoutput));

    //}

        System.out.println(name+" reverse is "+ reverse(name));
        // System.out.println(name+" reverse is "+rs.getReverse());

    }
}
