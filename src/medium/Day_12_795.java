package medium;

import java.util.Stack;

public class Day_12_795 {

    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        return numSubarrayBoundedMax(A, R) - numSubarrayBoundedMax(A, L - 1);
    }

    private int numSubarrayBoundedMax(int[] A, int Max) {
        int res = 0;
        int numSubarry = 0;
        for (int num : A) {
            if (num <= Max) {
                numSubarry++;
                res += numSubarry;
            } else {
                numSubarry = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Day_12_795 d12 = new Day_12_795();
        int[] nums = new int[]{2,1,4,3};
        int[] nums_0 = new int[]{2,9,2,5,6};
        int left = 2, right = 3;
        System.out.println(d12.numSubarrayBoundedMax(nums, left, right));
    }
}
