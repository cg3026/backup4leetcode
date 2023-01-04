package easy;

public class Offer_53_2 {

    public int missingNumber(int[] nums) {
        for (int i=0;i<nums.length;i++){
            if (nums[i]!=i){
                return i;
            }
        }
        return 0;
    }
    public int missingNumber_2sp(int[] nums) {
        int head=0,end=nums.length-1,mid;
        while(head<=end){
            mid = (head+end)/2;
            if (nums[mid]==mid){
                head = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Offer_53_2 o53_2 = new Offer_53_2();
        int[] input = new int[]{0,2};
        System.out.println(o53_2.missingNumber_2sp(input));
    }
}
