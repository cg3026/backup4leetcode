package easy;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

//给你一个非递减的 有序 整数数组，已知这个数组中恰好有一个整数，它的出现次数超过数组元素总数的 25%。
//请你找到并返回这个整数

public class Day_one_1287 {

    public static int findSpecialInteger_2A(int[] arr){
        int[] count = new int[arr[arr.length - 1] + 1];
        int num = 0;
        int len = arr.length;
        for(int i = 0; i<len; i++){
            count[arr[i]]++;
            if (count[arr[i]] > ((float)arr.length/(float)4)){
                num = arr[i];
                break;
            }
        }
        return num;
    }
    public static int right(int[] arr, int mid_left, int right, int mid){
        if(mid_left < right){
            if (arr[(right + mid_left)/2 + 1] == mid){
                return right(arr, (right + mid_left)/2 + 1, right, mid);
            }else {
                return right(arr, mid_left, (right + mid_left)/2, mid);
            }
        }
        return right;
    }
    public static int left(int[] arr, int left, int mid_right, int mid){
        if(left < mid_right){
            if (arr[(mid_right + left)/2] == mid){
                return left(arr, left, (mid_right + left)/2, mid);
            }else {
                return left(arr, (mid_right + left)/2 + 1, mid_right, mid);
            }
        }
        return left;
    }

    public static int findSpecialInteger_2D(int[] arr) {
        int len = arr.length;
        int span = len / 4 + 1;
        int number = 0;
        for (int i = 0; i < len; i += span) {
            int left = 0;
            int mid_right = i;
            int right = arr.length - 1;
            int mid_left = i;
            int mid = arr[i];
            while (left < mid_right) {
                if (arr[(mid_right + left) / 2] == mid) {
                    mid_right = (mid_right + left) / 2;
                } else {
                    left = (mid_right + left) / 2 + 1;
                }
            }
            while (mid_left < right) {
                if (arr[(right + mid_left) / 2 + 1] == mid) {
                    mid_left = (right + mid_left) / 2 + 1;
                } else {
                    right = (right + mid_left) / 2;
                }
            }
            if (right - left + 1 > arr.length / 4) {
                number = arr[i];
                break;
            }
        }
        return number;
    }

    public static int findSpecialInteger_2D_it(int[] arr){
        int len = arr.length;
        int span = len/4 + 1;
        int number = 0;
        for (int i=0; i<len; i+=span){
            int left = 0;
            int mid_right = i;
            int right = arr.length - 1;
            int mid_left = i;
            int mid = arr[i];
            right = right(arr, mid_left, right, mid);
            left = left(arr, left, mid_right, mid);
            if (right - left + 1 >arr.length/4){
                number = arr[i];
                break;
            }
        }
        return number;
    }

    public static int findSpecialInteger_hash(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.merge(i, 1, Integer::sum);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() * 4 > arr.length) {
                return entry.getKey();
            }
        }
            return 0;
    }


    public static void main(String[] args){
        int[] arr ;
        arr = new  int[]{1, 1};
        int number = findSpecialInteger_2D_it(arr);
        System.out.println(number);
    }
}
