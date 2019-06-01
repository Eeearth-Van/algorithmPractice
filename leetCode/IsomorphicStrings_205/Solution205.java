package IsomorphicStrings_205;

import java.util.HashMap;

/**
 * @program: leetCode
 * @package:
 * @description:
 * @author: Kevin
 * @create: 2019-06-01 20:15
 **/
class Solution205Test {
    public static void main(String[] args) {
        Solution205 solution205 = new Solution205();
        System.out.println(solution205.isIsomorphic("ab", "aa"));
    }
}
public class Solution205 {

    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map1 = new HashMap<Character, Character>();
        HashMap<Character, Character> map2 = new HashMap<Character, Character>();
        Character temp1, temp2;
        for (int i = 0; i < s.length(); i++) {
            temp1 = s.charAt(i);
            temp2 = t.charAt(i);
            if (!map1.containsKey(temp1) && !map2.containsKey(temp2)) {
                map1.put(temp1, temp2);
                map2.put(temp2, temp1);
                continue;
            }
            if (temp1.equals(map2.get(temp2)) && temp2.equals(map1.get(temp1))) {
                continue;
            }
            return false;
        }
        return true;
    }
}
