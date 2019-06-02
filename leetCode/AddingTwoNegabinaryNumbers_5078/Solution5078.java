package GreatestCommonDivisorOfStrings_5076;

import java.util.Arrays;

/**
 * @program: leetCode
 * @package:
 * @description:
 * @author: Kevin
 * @create: 2019-06-01 20:15
 **/
class Solution5078Test {
    public static void main(String[] args) {
        Solution5078 solution = new Solution5078();
        int[] arr1 = {1};
        int[] arr2 = {1};
        int[] result = solution.addNegabinary(arr1, arr2);
        System.out.println(Arrays.toString(result));
    }
}

public class Solution5078 {
    public int[] addNegabinary(int[] arr1, int[] arr2) {

        int len1 = arr1.length,len2 = arr2.length;
        int a1,a2,temp = 0;
        int max = Math.max(len1, len2);
        int[] result = new int[max + 2];
        for (int i = 0; i < max + 2; i++) {
            if (i < len1) a1 = arr1[len1 - 1 - i];
            else a1 = 0;
            if (i < len2) a2 = arr2[len2 - 1 - i];
            else a2 = 0;
            if (a1 + a2 + temp == 0) {
                result[max + 1 - i] = 0;
                temp = 0;
            } else if (a1 + a2 + temp == 1) {
                result[max + 1 - i] = 1;
                temp = 0;
            } else if (a1 + a2 + temp == 2) {
                result[max + 1 - i] = 0;
                temp = -1;
            } else if (a1 + a2 + temp == -1) {
                result[max + 1 - i] = 1;
                temp = 1;
            } else if (a1 + a2 + temp == 3) {
                result[max + 1 - i] = 1;
                temp = -1;
            }
        }

        int m = 0;
        for (int j = 0; j < result.length; j++) {
            if (result[j] == 0) m++;
            else break;
        }
        int[] res = new int[result.length - m];
        for (int i = 0; i < res.length; i++) {
            res[i] = result[i + m];
        }
        if (res.length == 0) return new int[]{0};
        return res;
    }
}
