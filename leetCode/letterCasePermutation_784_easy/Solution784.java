package letterCasePermutation_784_easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetCode
 * @package:
 * @description:
 * @author: Kevin
 * @create: 2019-06-15 19:52
 **/
class Solution784Test {
    public static void main(String[] args) {
        String string = "";
        Solution784 solution784 = new Solution784();
        List<String> stringList = solution784.letterCasePermutation(string);
        for (String s : stringList) {
            System.out.println(s);
        }
    }
}

public class Solution784 {
    List<String> result=new ArrayList<>();

    public List<String> letterCasePermutation(String S) {
        dfs(new StringBuilder(S), 0);
        return result;
    }

    void dfs(StringBuilder sb, int index) {
        if (index == sb.length()) {
            result.add(sb.toString());
            return;
        }
        if (Character.isDigit(sb.charAt(index))) {
            dfs(sb, index + 1);
        } else {
            sb.setCharAt(index, Character.toUpperCase(sb.charAt(index)));
            dfs(sb, index + 1);
            sb.setCharAt(index, Character.toLowerCase(sb.charAt(index)));
            dfs(sb, index + 1);
        }

    }
}
