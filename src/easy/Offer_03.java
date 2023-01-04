package easy;

import java.util.HashMap;

public class Offer_03 {

    public int findRepeatNumber(int[] nums) {
        HashMap<Integer,Boolean> record = new HashMap<>();
        if (nums.length!=0){
            for (int num:nums){
                if (record.containsKey(num)){
                    return num;
                }
                record.put(num,true);
            }
        }
        return 0;
    }
    public int findRepeatNumber_index(int[] nums){
        int i = 0;
        int mid;
        if (nums.length!=0){
            while (i<nums.length){
                if (nums[i]==i){
                    i++;
                    continue;
                }
                if (nums[nums[i]]==nums[i]){
                    return nums[i];
                }
                mid = nums[nums[i]];
                nums[nums[i]]=nums[i];
                nums[i]=mid;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] datain = new int[]{3,4,2,1,1,0};
        Offer_03 o03 = new Offer_03();
        int res = o03.findRepeatNumber_index(datain);
        System.out.println(res);
    }
}
