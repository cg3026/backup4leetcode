package medium;

import java.util.Locale;

public class MS_45 {

    // 自己的方法，是自定义一种比谁在前面的判断方式然后冒泡排序
    public String minNumber_my(int[] nums) {

        // 冒泡排序
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] <= nums[j]) {
                    boolean flag = judge(nums[i], nums[j]);
                    if (!flag) {int mid = nums[j];nums[j] = nums[i];nums[i] = mid;}}
                else {
                    boolean flag = judge(nums[j], nums[i]);
                    if (flag) {int mid = nums[j];nums[j] = nums[i];nums[i] = mid;}}
            }
        }
        StringBuilder s = new StringBuilder();
        for (int num:nums){
            s.append(num);
        }
        return s.toString();
    }

    public boolean judge(int a, int b){
        String s_a = String.valueOf(a);
        String s_b = String.valueOf(b);
        int len_a = s_a.length();
        int len_b = s_b.length();
        if (len_a!=len_b) {
            int len = Math.min(len_a, len_b);
            int res_0 = judege_apart(len, s_a, s_b);
            if (res_0==0){
                return true;
            }else if (res_0==1){
                return false;
            }
            int mid = Math.abs(len_b-len_a);
            int res_1 = judege_apart(mid, s_b.substring(0,mid), s_b.substring(len_a,len_b));
            if (res_1==0){
                return true;
            }else if (res_1==1){
                return false;
            }
            int res_2 = judege_apart(len, s_b.substring(len_b-len_a,len_b), s_a);
            if (res_2==0){
                return true;
            }else if (res_2==1){
                return false;
            }
            return false;
        }else {
            int res_3 = judege_apart(len_a, s_a, s_b);
            if (res_3==0){
                return true;
            }else if (res_3==1){
                return false;
            }
            return false;
        }
    }

    public int judege_apart(int length, String a, String b){
        for (int i=0; i<length; i++) {
            int b_i = Integer.parseInt(String.valueOf(b.charAt(i)));
            int a_i = Integer.parseInt(String.valueOf(a.charAt(i)));
            if (a_i < b_i){
                return 0;
            }else if (a_i > b_i){
                return 1;
            }
        }
        return 2;
    }

    // 力扣官方给出的自定义排序方法是，x+y>y+x,则x大于y，反之小于。
    // 需数学证明
    public String minNumber_leetcode(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        quickSort(strs, 0, strs.length - 1);
        StringBuilder res = new StringBuilder();
        for(String s : strs)
            res.append(s);
        return res.toString();
    }
    // 快速排序
    void quickSort(String[] strs, int l, int r) {
        if(l >= r) return;
        int i = l, j = r;
        String tmp = strs[i];
        while(i < j) {
            while((strs[j] + strs[l]).compareTo(strs[l] + strs[j]) >= 0 && i < j) j--;
            while((strs[i] + strs[l]).compareTo(strs[l] + strs[i]) <= 0 && i < j) i++;
            tmp = strs[i];
            strs[i] = strs[j];
            strs[j] = tmp;
        }
        strs[i] = strs[l];
        strs[l] = tmp;
        quickSort(strs, l, i - 1);
        quickSort(strs, i + 1, r);
    }


    public static void main(String[] args) {
        int[] input = new int[]{121,12};
        MS_45 ms45 =new MS_45();
        System.out.println(ms45.minNumber_my(input));
    }
}
