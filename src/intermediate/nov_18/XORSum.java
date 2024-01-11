package intermediate.nov_18;

import java.util.ArrayList;
import java.util.Arrays;

public class XORSum {
    private static int sum(int A, int B) {


        return A ^ B;

    }

    private static String interestingArray(ArrayList<Integer> A) {
        System.out.println("A size "+A.size());
        System.out.println("A size "+ (1088 ^ 1088));
        if(A.size()<=1){
            return "No";
        }
        int xor = A.get(0) ^ A.get(1);
        System.out.println("xor--->"+xor);
        int firstPart = xor / 2;
        int secondPart = firstPart;
        int merge = firstPart ^ secondPart;
        if (merge == 0) {
            return "Yes";
        } else {
            return "No";
        }
    }

    public static void main(String[] args) {

//        System.out.println("Here is XOR sum of A and b --->" + sum(6, 12));
//        System.out.println("Here is XOR sum of A and b --->" + sum(4, 9));

        System.out.println(""+interestingArray(new ArrayList<Integer>(Arrays.asList(9,17))));
        System.out.println(""+interestingArray(new ArrayList<Integer>(Arrays.asList(5030, 7120, 5995, 237, 7582, 8476, 2174, 8787, 7611, 6616, 4640, 8907, 2164, 2753, 8246, 3858, 8795, 2762, 3378, 1527, 4725, 8119, 4447, 4834, 8465, 3253, 5664, 4404, 3114, 8380, 7844, 7975, 8413, 8338, 1682, 6535, 5500, 5400, 4160, 1849, 9472, 3114, 8330, 1255, 753, 4995, 4090, 7392, 4297, 65, 384, 2354, 847, 3906, 4016, 4424, 3316, 709, 6140, 5437, 2440, 2189, 130, 5699, 9506, 1243, 2862, 1141, 6659, 964, 7918, 5976, 5490, 9903, 9106, 2042, 2676, 3231, 3580, 299, 9134, 8663, 5389, 3268, 6394, 3092, 5235, 5109, 6224, 3314, 4611, 5381, 6032, 230, 5363, 3807, 3176, 4085, 966, 2880, 2591, 9157, 2971, 8330, 692, 5620, 7286, 665, 7865, 6799, 1393, 4977, 3075, 2960, 5979, 9158, 7903, 4771, 8390, 5238, 9661, 9410, 4020, 9300, 2499, 6477, 6404, 8553, 6809, 2659, 1930, 2559, 763, 2818, 9021, 5318, 9321, 286, 4721, 8026, 8236, 7179, 5207, 6036, 5518, 3781, 4672, 4357, 1274, 2218, 2158, 3079, 6340, 8790, 7674, 4099, 9847, 424, 3323, 7658, 2716, 2036, 6562, 1319, 5228, 433, 1287, 6290, 5199, 2479, 770, 5397, 6168, 1824, 1119, 7176, 8299, 3045, 6480, 7447, 764, 3381, 1095, 1318, 8162, 4862, 6442, 3061, 6213, 9495, 9439, 5961, 7153, 2888, 7218, 4371, 7009, 6645, 3701, 8882, 666, 9485, 8833, 3391, 4508, 1982, 4984, 6911, 711, 1902, 9143, 7240, 5051, 1199, 7843, 3519, 9739, 7046, 4694, 4537, 1014, 5507, 6184, 3731, 9066, 2129, 3345, 145, 5094, 4371, 7354, 6262, 9790, 8190))));
        System.out.println(""+interestingArray(new ArrayList<Integer>(Arrays.asList(5030, 7120, 5995, 237, 7582, 8476, 2174, 8787, 7611, 6616, 4640, 8907, 2164, 2753, 8246, 3858, 8795, 2762, 3378, 1527, 4725, 8119, 4447, 4834, 8465, 3253, 5664, 4404, 3114, 8380, 7844, 7975, 8413, 8338, 1682, 6535, 5500, 5400, 4160, 1849, 9472, 3114, 8330, 1255, 753, 4995, 4090, 7392, 4297, 65, 384, 2354, 847, 3906, 4016, 4424, 3316, 709, 6140, 5437, 2440, 2189, 130, 5699, 9506, 1243, 2862, 1141, 6659, 964, 7918, 5976, 5490, 9903, 9106, 2042, 2676, 3231, 3580, 299, 9134, 8663, 5389, 3268, 6394, 3092, 5235, 5109, 6224, 3314, 4611, 5381, 6032, 230, 5363, 3807, 3176, 4085, 966, 2880, 2591, 9157, 2971, 8330, 692, 5620, 7286, 665, 7865, 6799, 1393, 4977, 3075, 2960, 5979, 9158, 7903, 4771, 8390, 5238, 9661, 9410, 4020, 9300, 2499, 6477, 6404, 8553, 6809, 2659, 1930, 2559, 763, 2818, 9021, 5318, 9321, 286, 4721, 8026, 8236, 7179, 5207, 6036, 5518, 3781, 4672, 4357, 1274, 2218, 2158, 3079, 6340, 8790, 7674, 4099, 9847, 424, 3323, 7658, 2716, 2036, 6562, 1319, 5228, 433, 1287, 6290, 5199, 2479, 770, 5397, 6168, 1824, 1119, 7176, 8299, 3045, 6480, 7447, 764, 3381, 1095, 1318, 8162, 4862, 6442, 3061, 6213, 9495, 9439, 5961, 7153, 2888, 7218, 4371, 7009, 6645, 3701, 8882, 666, 9485, 8833, 3391, 4508, 1982, 4984, 6911, 711, 1902, 9143, 7240, 5051, 1199, 7843, 3519, 9739, 7046, 4694, 4537, 1014, 5507, 6184, 3731, 9066, 2129, 3345, 145, 5094, 4371, 7354, 6262, 9790, 8190))));
      // System.out.println(""+interestingArray(new ArrayList<Integer>(Arrays.asList(3003, 3030, 228, 9856, 8173, 2480, 1799, 6404, 518, 2738, 8169, 4429, 1783, 4619, 9782, 7419, 1674, 6404, 1214, 6976, 5010, 5743, 9664, 3957, 1644, 1129, 1497, 8429, 3068, 2287, 5059, 2325, 2426, 2655, 2418, 6542, 4141, 5899, 2659, 8630))));

    }
}
