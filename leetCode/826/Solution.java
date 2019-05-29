
 /**
 * @program: ttt
 * @description:leetCode826
 * @author: Kevin
 * @create: 2019-05-29 09:02
 **/
class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int len = difficulty.length;
        if (len == 0) {
            return 0;
        }
        int result = 0, workerLen = worker.length, temp = difficulty.length - 1;
        //从小到大
        quickSort(worker, 0, workerLen - 1);
        quickSort2(profit, difficulty, 0, len - 1);
        //牛逼的人先带着你的活上路吧
        for (int i = workerLen - 1; i >= 0 && workerLen > 0; i--) {
            for (; temp >= 0; temp--) {
                if (difficulty[temp] <= worker[i]){
                    result += profit[temp];
                    break;
                }
            }
        }
        return result;
    }


    /**
     * 一个数组快速排序
     *
     * @param arrays
     * @param left
     * @param right
     */
    void quickSort(int[] arrays, int left, int right) {
        int i, j, t, temp, temp2;
        if (left > right) {
            return;
        }
        temp = arrays[left];
        i = left;
        j = right;
        while (i != j) {
            //先，从右向左
            while (arrays[j] >= temp && i < j) {
                j--;
            }
            while (arrays[i] <= temp && i < j) {
                i++;
            }
            if (i < j) {
                t = arrays[i];
                arrays[i] = arrays[j];
                arrays[j] = t;
            }
        }
        arrays[left] = arrays[i];
        arrays[i] = temp;
        quickSort(arrays, left, i - 1);
        quickSort(arrays, i + 1, right);
    }

    /**
     * 俩数组快速排序
     *
     * @param arrays
     * @param arrays2
     * @param left
     * @param right
     */
    void quickSort2(int[] arrays, int[] arrays2, int left, int right) {
        int i, j, t, temp, temp2;
        if (left > right) {
            return;
        }
        temp = arrays[left];
        temp2 = arrays2[left];
        i = left;
        j = right;

        while (i != j) {
            //先，从右向左
            while (arrays[j] >= temp && i < j) {
                j--;
            }
            while (arrays[i] <= temp && i < j) {
                i++;
            }
            if (i < j) {
                t = arrays[i];
                arrays[i] = arrays[j];
                arrays[j] = t;
                t = arrays2[i];
                arrays2[i] = arrays2[j];
                arrays2[j] = t;
            }
        }
        arrays[left] = arrays[i];
        arrays[i] = temp;
        arrays2[left] = arrays2[i];
        arrays2[i] = temp2;
        quickSort2(arrays, arrays2, left, i - 1);
        quickSort2(arrays, arrays2, i + 1, right);
    }
}
