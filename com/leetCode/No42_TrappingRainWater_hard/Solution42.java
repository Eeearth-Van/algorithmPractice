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
//        答案是14
//        int[] height = {8, 5, 4, 1, 8, 9, 3, 0, 0};
        int[] height = {8, 5, 4, 1, 8, 9, 3, 0, 0};
        System.out.println(solution42.trap(height));
    }
}

/**
 * 从左到右填坑，如果右边没有比左边高的就给左边降低高度
 */
/*public class Solution42 {
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
}*/

/**
 * 找到最高峰，两端向中间靠拢
 */
/*public class Solution42 {
    public int trap(int[] height) {
        int length = height.length;
        if (length < 2) return 0;
        int res = 0, maxIndex = 0, temp = 0, border = 0;
        for (int i = 0; i < length; i++) {
            if (height[i] > temp) {
                temp = height[i];
                maxIndex = i;
            }
        }
        for (int i = 0; i < maxIndex + 1; i++) {
            temp = height[i];
            if (border > temp) {
                res += border - temp;
                continue;
            }
            border=temp;
        }
        border=0;
        for (int i = length - 1; i > maxIndex; i--) {
            temp = height[i];
            if (border > temp) {
                res += border - temp;
                continue;
            }
            border=temp;
        }
        return res;
    }

}*/

/**
 * 两端向中间靠拢
 */
public class Solution42 {
    public int trap(int[] height) {
        int length = height.length;
        if (length < 2) return 0;
        int leftIndex = 0, rightIndex = length - 1, res = 0, temp;
        int leftMax = height[0], rightMax = height[rightIndex];
        while (leftIndex < rightIndex) {
            if (height[leftIndex] < height[rightIndex]) {
                temp = height[leftIndex];
                leftMax = leftMax > temp ? leftMax : temp;
                res += leftMax - temp;
                leftIndex++;
            } else {
                temp = height[rightIndex];
                rightMax = rightMax > temp ? rightMax : temp;
                res += rightMax - temp;
                rightIndex--;
            }
        }
        return res;
    }
}