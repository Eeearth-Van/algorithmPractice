package No42_TrappingRainWater_hard;

/**
 * @program: wy
 * @package:
 * @description:
 * @author: Kevin
 * @create: 2019-05-29 09:02
 **/
class Solution42Test {
    public static void main(String[] args) {
        Solution42 solution42 = new Solution42();
        //答案是14
        int[] height = {8, 5, 4, 1, 8, 9, 3, 0, 0};
        System.out.println(solution42.trap(height));
    }
}

public class Solution42 {
    public int trap(int[] height) {
        int length = height.length;
        if (length < 2) return 0;
        int tempCount = 0, leftHeight = 0, leftIndex = 0, res = 0;

        for (int i = 0; i < length; i++) {
            if (leftIndex == 0 && height[i] == 0) {
                continue;
            }
            leftIndex = i;
            leftHeight = height[leftIndex];
            for (int j = i + 1; j < length; j++) {
                if (leftHeight <= height[j]) {
                    i = j - 1;
                    res += tempCount;
                    tempCount = 0;
                    break;
                } else {
                    if (j == length - 1) {
                        j = leftIndex;
                        leftHeight -= 1;
                        tempCount = 0;
                        //这一行可以提高运行效率
                        if (leftHeight == 0) break;
                        continue;
                    }
                    tempCount += leftHeight - height[j];
                }
            }

        }
        return res;
    }
}

