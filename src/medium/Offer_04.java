package medium;

import easy.Offer_53_2;

public class Offer_04 {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int[] arr:matrix){
            if (exit(arr,target)){
                return true;
            }
        }
        return false;
    }
    boolean exit(int[] arr, int target){
        int head=0,end= arr.length-1,mid;
        while(head<=end){
            mid = (head+end)/2;
            if (arr[mid]>target){end = mid -1;}
            else if (arr[mid]<target){head = mid+1;}
            else {return true;}
        }
        return false;
    }
    public boolean findNumberIn2DArray_fast(int[][] matrix, int target) {
        for (int[] ints : matrix) {
            for (int j = ints.length - 1; j >= 0; j--) {
                if (ints[j] <= target) {
                    if (ints[j] == target) {
                        return true;
                    } else {
                        break;
                    }
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Offer_04 o04 = new Offer_04();
        int target = 5;
        int[][] input = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(o04.findNumberIn2DArray_fast(input,target));
    }
}
