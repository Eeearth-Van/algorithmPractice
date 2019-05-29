/**
 * @program: ttt
 * @description:leetCode678
 * @author: Kevin
 * @create: 2019-05-28 13:21
 **/
public class Solution {

    public static void main(String[] args) {
        System.out.println(checkValidString(""));
    }
    
    public static boolean checkValidString(String s) {
        int l = 0, len = s.length();
        if (len == 0) return true;
        for (int i = 0; i < len; i++) {
            if ('(' == (s.charAt(i)) || '*' == (s.charAt(i))) {
                l++;
            } else {
                l--;
                //右括号太多
                if (l < 0) return false;
            }
        }
        l = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (')' == (s.charAt(i)) || '*' == (s.charAt(i))) {
                l++;
            } else {
                l--;
                //左括号太多
                if (l < 0) return false;
            }
        }
        return true;
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> fe81447c3bdc12b9a16d59a894acede332af0927
