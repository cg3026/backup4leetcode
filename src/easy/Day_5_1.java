package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Day_5_1 {
    public int[] twoSum(int[] nums, int target) {
        int[] indexs = new int[2];
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(nums[i])) {
                indexs[0] = hash.get(nums[i]);
                indexs[1] = i;
                break;
            }
            hash.put(target - nums[i], i);
        }
        return indexs;
    }

    public static void main(String[] args) {
        Day_5_1 d5 = new Day_5_1();
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        int[] ind = d5.twoSum(nums,target);
    }
}
