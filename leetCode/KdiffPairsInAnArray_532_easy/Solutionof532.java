package KdiffPairsInAnArray_532_easy;

import java.util.HashMap;

/**
 * @program: leetCode
 * @package:
 * @description:
 * @author: Kevin
 * @create: 2019-06-04 19:46
 **/
class Solution532Test {
    public static void main(String[] args) {
        int[] nums = {6,3,5,7,2,3,3,8,2,4};
        int k = 2;
        Solutionof532 solution532 = new Solutionof532();
        System.out.println(solution532.findPairs(nums, k));
    }
}

public class Solutionof532 {
    public int findPairs(int[] nums, int k) {
        if (k < 0 || nums.length < 2) return 0;
        int count = 0, temp;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            temp = nums[i];
            //只对新来的做判断，避免重复
            if (!map.containsKey(temp)) {
                if (map.containsKey(temp + k) && map.get(temp + k) == 1) {
                    count++;
                }
                if (map.containsKey(temp - k) && map.get(temp - k) == 1) {
                    count++;
                }
                map.put(temp, 1);
            }else{
                if (k==0){
                    if (map.get(temp) ==1){
                        count++;
                        map.put(temp,2);
                    }
                }
            }

        }
        return count;
    }
}
