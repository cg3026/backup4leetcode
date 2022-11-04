package hard;

// TODO: 时间复杂度不达标，时间复杂度需要收缩到O(log(m+n))

public class Day_5_4 {

    // 复杂度不达标 O(n+m)
    public double findMedianSortedArrays_high_complex(int[] nums1, int[] nums2) {
        int i = 0,j = 0,m=0;
        int length =  nums1.length+nums2.length;
        int[] nums = new int[length];
        while(m<length){
            if (i<nums1.length&&j<nums2.length){
                nums[m] = nums1[i]<nums2[j]?nums1[i]:nums2[j];
                if(nums1[i]<nums2[j]){i++;}else {j++;}
            }else {
                if (i>= nums1.length){
                    nums[m] = nums2[j];
                    j++;
                }else {
                    nums[m] = nums1[i];
                    i++;
                }
            }
            m++;
        }
        double mid = length%2==0?(double)(nums[length/2]+nums[length/2-1])/2 : (double)nums[length/2];
        return mid;
    }
    // 时间复杂度为O(log(m+n)),题解示意需要用二分法来达成log数量级
//    public double findMedianSortedArrays_low_complex(int[] nums1, int[] nums2) {
//
//    }


    public static void main(String[] args) {
        Day_5_4 d5 = new Day_5_4();
        int[] nums1 =new int[] {1,2};
        int[] nums2 =new int[] {3,4};
        double mid = d5.findMedianSortedArrays_high_complex(nums1,nums2);
        System.out.println(mid);
    }
}
