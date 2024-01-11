package intermediate.nov_30;

import java.util.ArrayList;
import java.util.List;

public class ColorfulNumberHW {
//    public int colorful(int A) {
//
//    }
    private static int getProduct(int digits) {
        if(digits < 10) return digits;
        int num = digits;
        int product = 1;
        while(num > 0){
            product = product * (num % 10);
            num = num / 10;
        }
        return product;
    }
    public static int colorful(int A) {
        if(A < 10) return 1;

        String colorString = String.valueOf(A);
        int length = colorString.length();

        List<Integer> colorMap = new ArrayList<Integer>();

        for(int i =  1; i <= length; i++){
            for (int j = 0;  j+i <= length; j++){
                String sub = colorString.substring(j, j+i);
                int product = getProduct(Integer.parseInt(sub));
                if(colorMap.contains(product)) return 0;
                else{
                    colorMap.add(product);
                }
            }
        }
        return 1;
    }
    public static void main(String[] args) {
        System.out.println(""+colorful(23));
        System.out.println(""+colorful(236));
        System.out.println(""+colorful(12));

    }
}
