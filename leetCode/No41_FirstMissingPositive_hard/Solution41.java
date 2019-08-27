package No41_FirstMissingPositive_hard;

/**
 * @ClassName：
 * @description:
 * @author: wangyao
 * @create: 2019-08-27 14:54
 **/
public class Solution41 {
    public int firstMissingPositive(int[] nums) {
        //nums[0]=1
        int len = nums.length;
        if (len == 0) return 1;
        int temp;
        boolean flag = false;
        //为了吃冰棍 多做几组O（n）吧！
        for (int i = 0; i < len; i++) {
            if (nums[i] < 0) continue;
            if (nums[i] == len) flag = true;
            if (nums[i] < len) {
                temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] < 0) continue;
            if (nums[i] < len) {
                temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] < 0) continue;
            if (nums[i] == len) flag = true;
            if (nums[i] < len) {
                temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] < 0) continue;
            if (nums[i] == len) flag = true;
            if (nums[i] < len) {
                temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] < 0) continue;
            if (nums[i] == len) flag = true;
            if (nums[i] < len) {
                temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] < 0) continue;
            if (nums[i] < len) {
                temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] < 0) continue;
            if (nums[i] < len) {
                temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 1; i < len; i++) {
            if (nums[i] != i) {
                return i;
            }
            if (i == len - 1) {
                if (flag) return i + 1 + 1;
                return i + 1;
            }
        }
        //只有一个数时
        if (nums[0] == 1) {
            return 2;
        } else {
            return 1;
        }
    }
}

class Solution41Test {
    public static void main(String[] args) {
        int[] ints = {12,34,41,9,14,9,26,13,13,4,19,5,19,18,-1,6,5,32,-9,8,35,-6,41,-2,11,41,-6,13,17,-8,41,34,-2,40,2,24,21,36,1,22,1,3};
        Solution41 solution41 = new Solution41();
        System.out.println(solution41.firstMissingPositive(ints));
    }
}

