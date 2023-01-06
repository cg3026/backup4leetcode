package medium;

import java.util.Stack;

public class Offer_46 {

    // 用树来找符合要求的叶节点数
    public int translateNum_tree(int num) {
        Stack<Integer> count = new Stack<>();
        count.push(num%10);
        num/=10;
        while(num!=0){
            Stack<Integer> mid = new Stack<>();
            while(!count.isEmpty()){
                int cur = count.pop();
                if (cur<10){
                    int mid_m = cur+num%10*10;
                    if (mid_m <=25 && mid_m != cur) {
                        mid.push(mid_m);
                    }
                }
                mid.push(num%10);
                }
            while (!mid.isEmpty()){
                count.push(mid.pop());
            }
            num/=10;
        }
        return count.size();
    }

    //状态方程为f(i)=f(i-1)+f(i+1) [i-1>=0 && 10<=x<=25]
    public int translateNum_dp_my(int num) {
        int r = 1, p = 1, last, cur = num%10;
        num/=10;
        while(num!=0){
            last = cur;
            cur = num % 10;
            int x = cur * 10 + last;
            if (x<=25 && x>=10){
                int mid = p;
                p = r;
                r = mid + p;
            }
            else {p=r;}
            num/=10;
        }
        return r;
    }

    public int translateNum_dp_leetcode(int num) {
        String src = String.valueOf(num);
        int p, q = 0, r = 1;
        for (int i = 0; i < src.length(); ++i) {
            p = q;
            q = r;
            if (i == 0) {
                continue;
            }
            String pre = src.substring(i - 1, i + 1);
            if (pre.compareTo("25") <= 0 && pre.compareTo("10") >= 0) {
                r += p;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        Offer_46 o46 = new Offer_46();
        int input = 12258;
        System.out.println(o46.translateNum_dp_leetcode(input));
    }
}
