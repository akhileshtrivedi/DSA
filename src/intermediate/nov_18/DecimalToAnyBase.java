package intermediate.nov_18;

import java.lang.*;

class DecimalToAnyBase
{

   private static char reVal(int num)
    {
        if (num >= 0 && num <= 9)
            return (char)(num + 48);
        else
            return (char)(num - 10 + 65);
    }

    // Function to convert a given decimal number
// to a base 'base' and
   private  static int fromDeci( int A, int B)
    {
        if(A<=0)
            return 0;
        String s = "";

        while (A > 0)
        {
            s += reVal(A % B);
            A /= B;
        }
        StringBuilder ix = new StringBuilder();

        ix.append(s);

        return Integer.parseInt(new String(ix.reverse()));
    }

    public static void main (String[] args)
    {
        int inputNum = 0, base1 = 7;
        System.out.println("Equivalent of " + inputNum +
                " in base "+base1+" is " +
                fromDeci(inputNum, base1));
    }
}


