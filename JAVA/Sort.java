import java.util.Arrays;
import java.util.Random;

class Solution {
    public void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    public void quickSort(int[] nums, int start, int end) {
        if (start >= end) return;
        Random random = new Random();
        int rand = random.nextInt(end - start + 1) + start;
        swap(nums, rand, end);

        int left = start;
        for (int right = start; right <= end; right++) {
            if (nums[right] < nums[end]) {
                swap(nums, left, right);
                left++;
            }
        }
        swap(nums, left, end);

        quickSort(nums, start, left - 1);
        quickSort(nums, left + 1, end);
    }

    public void radixSort(int[] nums) {
        int len = nums.length;
        if (len == 0) return;

        int maxNum = nums[0];
        for (int n : nums) maxNum = Math.max(n, maxNum);
        int bits = 0;
        while (maxNum > 0) {
            bits++;
            maxNum /= 10;
        }
        
        int radix = 1;
        int[] bukets = new int[10];
        int[] tmp = new int[len];

        for (int i = 0; i < bits; i++) {
            for (int j = 0; j < 10; j++) {
                bukets[j] = 0;
            }
            for (int n : nums) {
                bukets[(n / radix) % 10]++;
            }
            for (int j = 1; j < 10; j++) {
                bukets[j] += bukets[j-1];
            }
            for (int j = len - 1; j >= 0; j--) {
                int index = (nums[j] / radix) % 10;
                bukets[index]--;
                tmp[bukets[index]] = nums[j];
            }
            for (int j = 0; j < len; j++) {
                nums[j] = tmp[j];
            }
            radix *= 10;
        }
    }

    public void sinkDown(int[] nums, int start, int end) {
        while (start * 2 + 1 <= end) {
            int large = start * 2 + 1;
            if (large + 1 <= end && nums[large] < nums[large + 1]) {
                large++;
            }
            if (nums[start] > nums[large]) {
                return;
            }
            swap(nums, start, large);
            start = large;
        }
    }

    public void heapSort(int[] nums) {
        int len = nums.length;
        for (int i = len / 2 - 1; i >= 0; i--) {
            sinkDown(nums, i, len - 1);
        }
        for (int i = len - 1; i > 0; i--) {
            swap(nums, 0, i);
            sinkDown(nums, 0, i - 1);
        }
    }
    
}

public class Sort {
    public static void main(String[] args) {
        int[] arr = new int[]{9, 5, 3, 13, 4, 12, 42, 2, 0, 1};
        
        Solution solution = new Solution();
        solution.heapSort(arr);

        System.out.println(Arrays.toString(arr));

    }
}
