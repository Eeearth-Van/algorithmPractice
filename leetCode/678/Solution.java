/**
 * @program: ttt
 * @description:leetCode678
 * @author: Kevin
 * @create: 2019-05-28 13:21
 **/
class Solution1 {

    public boolean checkValidString(String s) {
        int l = 0, star = 0, len = s.length();
        if (len == 0) return true;
        for (int i = 0; i < len; i++) {
            if ('(' == (s.charAt(i))) {
                l++;
            } else if ('*' == (s.charAt(i))) {
                star++;
            } else {
                l--;
                //右括号太多
                if (l + star < 0) return false;
            }
        }
        l = 0;
        star = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (')' == (s.charAt(i))) {
                l++;
            } else if ('*' == (s.charAt(i))) {
                star++;
            } else {
                l--;
                //左括号太多
                if (l + star < 0) return false;
            }
        }
        return true;
    }
}

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution1().checkValidString(""));
    }
}
