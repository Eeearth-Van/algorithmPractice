package SearchInRotatedSortedArray;

class Solution33Test {
    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 0, 1};
        int target = 0;
        Solution33 solution = new Solution33();
        System.out.println(solution.search(nums,target));
    }
}

public class Solution33 {

    int key;
    int[] arr;

    public int search(int[] nums, int target) {
        arr = nums;
        key = target;
        return binarySearch(0, arr.length - 1);
    }

    public int binarySearch(int hi, int ti) {
        if (hi > ti) return -1;
        int middle = (hi + ti) / 2;
        if (hi == middle) {
            if (arr[hi] == key) return hi;
            if (arr[ti] == key) return ti;
            return -1;
        }
        //head is bigger
        if (arr[hi] > arr[ti]) {
            if (arr[hi] < arr[middle]) {
                if (arr[hi] <= key && key <= arr[middle]) return binarySearch(hi, middle);
                return binarySearch(middle + 1, ti);
            } else {
                if (arr[middle] <= key && key <= arr[ti]) return binarySearch(middle, ti);
                return binarySearch(hi, middle - 1);
            }
        } else {
            if (arr[hi] > key || arr[ti] < key) return -1;
            if (arr[middle] > key) return binarySearch(hi, middle - 1);
            if (arr[middle] < key) return binarySearch(middle + 1, ti);
            return middle;
        }
    }
}