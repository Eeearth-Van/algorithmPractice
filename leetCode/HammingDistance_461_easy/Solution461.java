package HammingDistance_461_easy;

/**
 * @program: leetCode
 * @package:
 * @description:
 * @author: Kevin
 * @create: 2019-06-10 19:37
 **/
class Solution461Test {
    public static void main(String[] args) {
        int x = 0, y = 0;
        Solution461 solution461 = new Solution461();
        System.out.println(solution461.hammingDistance(x, y));
    }
}

public class Solution461 {
    public int hammingDistance(int x, int y) {
        int result = x ^ y;
        int count = 0;
        while (result != 0) {
            if ((result & 1) == 1) {
                count++;
            }
            result = result >> 1;
        }
        return count;
    }
}
