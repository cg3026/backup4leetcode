package easy;

public class Offer_53 {

    public int search(int[] nums, int target) {
        int count = 0;
        for (int num:nums){
            if (num == target){
                count++;
            }
        }
        return count;
    }
    public int search_2split(int[] nums, int target) {
        int count = 0,head = 0,mid = -1;
        int i = 1;
        int end = nums.length-1;
        boolean flag = false;
        if (nums.length==0){
            return 0;
        }
        while(head<=end){
            mid = (head + end)/2;
            if (nums[mid]<target){head = mid +1;}
            else if(nums[mid]>target){end = mid - 1;}
            else if (nums[mid]==target){count++;flag = true;break;}
        }
        if (flag) {
            while (mid + i < nums.length) {
                if (nums[mid + i] != target) {
                    break;
                }
                count++;
                i++;
            }
            i = 1;
            while (mid - i >= 0) {
                if (nums[mid - i] != target) {
                    break;
                }
                count++;
                i++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        int target = 1;
        Offer_53 o53 = new Offer_53();
        int res = o53.search_2split(nums,target);
        System.out.println(res);
    }
}
