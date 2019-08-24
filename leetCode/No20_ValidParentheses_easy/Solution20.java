package No20_ValidParentheses_easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: wy
 * @package:
 * @description:
 * @author: Kevin
 * @create: 2019-05-29 09:02
 **/
class Solution20Test {
    public static void main(String[] args) {
        Solution20 solution = new Solution20();
        String string = "()[](}";
        System.out.println(solution.isValid(string));
    }
}

public class Solution20 {
    public boolean isValid(String s) {
        if (s == null||s.length()==0) return true;
        if (s.length() % 2 != 0 || s.charAt(0) == ')' || s.charAt(0) == '}' || s.charAt(0) == ']') return false;
        List<Character> stringList = new ArrayList<>();
        int lastIndexOf = -1;
        char tool = 0;
        for (int i = 0; i < s.length(); i++) {
            if ('(' == s.charAt(i) || '{' == s.charAt(i) || '[' == s.charAt(i)) {
                stringList.add(s.charAt(i));
                lastIndexOf++;
                continue;
            }
            if (']' == s.charAt(i)) {
                tool = '[';
            }
            if ('}' == s.charAt(i)) {
                tool = '{';
            }
            if (')' == s.charAt(i)) {
                tool = '(';
            }
            if (stringList.lastIndexOf(tool) != stringList.size() - 1) {
                return false;
            }
            stringList.remove(lastIndexOf);
            lastIndexOf--;
        }
        if (lastIndexOf != -1) return false;
        return true;
    }
}
