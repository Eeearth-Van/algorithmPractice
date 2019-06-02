package GreatestCommonDivisorOfStrings_5076;

/**
 * @program: leetCode
 * @package:
 * @description:
 * @author: Kevin
 * @create: 2019-06-01 20:15
 **/
class Solution5076Test {
    public static void main(String[] args) {
        Solution5076 solution = new Solution5076();
        System.out.println(solution.gcdOfStrings("ababab", "abab"));
    }
}

public class Solution5076 {
    public String gcdOfStrings(String str1, String str2) {
        if ("".equals(str1) ||"".equals(str2)) return "";
        return judgeString(str1, str2);
    }

    public String judgeString(String str1, String str2) {
        String res = "", tempL = "", tempS = "";
        int len1, len2, min;
        while (true) {
            len1 = str1.length();
            len2 = str2.length();
            if (len1 > len2) {
                min = len2;
                tempS = str2;
                tempL = str1;
            } else {
                min = len1;
                tempS = str1;
                tempL = str2;
            }
            for (int i = 0; i < min; i++) {
                if (str1.charAt(i) != str2.charAt(i)) return "";
            }
            str1 = tempL.substring(min);
            str2 = tempS;
            if ("".equals(str1)) return str2;
        }
    }
}
