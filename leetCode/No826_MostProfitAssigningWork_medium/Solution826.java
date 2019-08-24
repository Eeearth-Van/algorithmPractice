package No826_MostProfitAssigningWork_medium;

/**
 * @program: wy
 * @package:
 * @description:
 * @author: Kevin
 * @create: 2019-05-29 09:02
 **/
class Solution826Test {
    public static void main(String[] args) {
        int[] difficulty = {68, 35, 52, 47, 86};
        int[] profit = {67, 17, 1, 81, 3};
        int[] workers = {92, 10, 85, 84, 82};
        Solution826 solution = new Solution826();
        System.out.println(solution.maxProfitAssignment(difficulty, profit, workers));
    }
}

public class Solution826 {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int len = difficulty.length;
        if (len == 0) {
            return 0;
        }
        int result = 0, workerLen = worker.length, temp = difficulty.length - 1;
        Sort sort = new Sort();
        sort.difficulty = difficulty;
        sort.profit = profit;
        sort.workers = worker;
        sort.quickSort(0, workerLen - 1);
        sort.quickSort2(0, len - 1);
        //从小到大排好，让厉害的人先干，能力越大责任越大~
        for (int i = workerLen - 1; i >= 0 && workerLen > 0; i--) {
            for (; temp >= 0; temp--) {
                if (sort.difficulty[temp] <=  sort.workers[i]) {
                    result +=  sort.profit[temp];
                    break;
                }
            }
        }
        return result;
    }

}

class Sort {
    int[] difficulty;
    int[] profit;
    int[] workers;

    /**
     * 一个数组的快速排序
     *
     * @param left
     * @param right
     */
    void quickSort(int left, int right) {
        int i, j, t, temp, temp2;
        if (left > right) {
            return;
        }
        temp = workers[left];
        i = left;
        j = right;
        while (i != j) {
            //从右向左
            while (workers[j] >= temp && i < j) {
                j--;
            }
            while (workers[i] <= temp && i < j) {
                i++;
            }
            if (i < j) {
                t = workers[i];
                workers[i] = workers[j];
                workers[j] = t;
            }
        }
        workers[left] = workers[i];
        workers[i] = temp;
        quickSort(left, i - 1);
        quickSort(i + 1, right);
    }

    /**
     * 俩数组的快速排序
     *
     * @param left
     * @param right
     */
    void quickSort2(int left, int right) {
        int i, j, t, temp, temp2;
        if (left > right) {
            return;
        }
        temp = profit[left];
        temp2 = difficulty[left];
        i = left;
        j = right;

        while (i != j) {
            //从右向左
            while (profit[j] >= temp && i < j) {
                j--;
            }
            while (profit[i] <= temp && i < j) {
                i++;
            }
            if (i < j) {
                t = profit[i];
                profit[i] = profit[j];
                profit[j] = t;
                t = difficulty[i];
                difficulty[i] = difficulty[j];
                difficulty[j] = t;
            }
        }
        profit[left] = profit[i];
        profit[i] = temp;
        difficulty[left] = difficulty[i];
        difficulty[i] = temp2;
        quickSort2(left, i - 1);
        quickSort2(i + 1, right);
    }
}
