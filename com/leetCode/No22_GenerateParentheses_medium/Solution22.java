package No22_GenerateParentheses_medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetCode
 * @package:
 * @description:
 * @author: Kevin
 * @create: 2019-06-11 14:27
 **/

class Solution22Test {
    public static void main(String[] args) {
        Solution22 solution22 = new Solution22();
        int n = 1;
        List<String> strings = solution22.generateParenthesis(n);
        for (String s : strings) {
            System.out.println(s);
        }
    }
}

public class Solution22 {

    public List<String> generateParenthesis(int n) {
        if (n <= 0) return new ArrayList<>();
        List<String> stringList = new ArrayList<String>();
        generate("", stringList, n, n);
        return stringList;
    }

    void generate(String string, List<String> stringList, int left, int right) {
        if (left < 0 || right < 0) return;
        if (left == 0 && right == 0) {
            stringList.add(string);
            return;
        }
        if (left <= right) {
            String s = new String(string);
            generate(string + "(", stringList, left-1, right);
            generate(string + ")", stringList, left, right-1);
        }
    }
}
