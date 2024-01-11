package intermediate.dec_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        ArrayList<Integer> result = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("Hello, World!"+result);

        List<Integer> arrlist2 = result.subList(2, 4);
        System.out.println("Hello, World!"+arrlist2);
        arrlist2.clear();
    }
}
