package medium;

//  神奇字符串 s 的神奇之处在于，串联字符串中 '1' 和 '2' 的连续出现次数可以生成该字符串。
//  s的前几个元素是 s = "1221121221221121122……" 。如果将 s 中连续的若干 1 和 2 进行分组，可以得到 "1 22 11 2 1 22 1 22 11 2 11 22 ......" 。
//  每组中 1 或者 2 的出现次数分别是 "1 2 2 1 1 2 1 2 2 1 2 2 ......" 。上面的出现次数正是 s 自身。
//  给你一个整数 n ，返回在神奇字符串 s 的前 n 个数字中 1 的数目。
//

public class Day_1_481 {

    public static int magicalString_my(int n){
        int i = 2;
        int j = 3;
        int num = 0;
        int[] s = new int[Math.max(n+1, 3)];
        s[0] = 1;
        s[1] = 2;
        s[2] = 2;
        while (Math.max(i,j) < n) {
            if (s[i] == 1) {s[j] = 3-s[j-1];i++;j++;}
            else if (s[i] == 2){s[j] = s[j+1] = 3 - s[j-1];i++;j = j + 2;}
        }
        for(int number = 0;number < n;number++){
            if (s[number] == 1){num++;}
        }
        return num;
    }
// 内存40.5M 时间3ms
    public static int magicalString_fast(int n){
        int i = 2;
        int j = 3;
        int num = 1;
        int[] s = new int[Math.max(n+1, 3)];
        s[0] = 1;
        s[1] = 2;
        s[2] = 2;
        while (Math.max(i,j) < n) {
            int size = s[i];
            int number = 3 - s[j-1];
            while(size > 0 && j<n){
                s[j] = number;
                if (s[j]==1){num++;}
                size--;
                j++;
            }
            i++;
        }
        return num;
    }


    public static void main(String[] args){
        int a = magicalString_my(14);
        System.out.println(a);
    }
}
