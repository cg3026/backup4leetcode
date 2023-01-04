package easy;

import java.util.HashMap;

public class Offer_10_1 {
    HashMap<Integer,Integer> map = new HashMap<>();

    public int fib_dp(int n) {
        final int MOD = 1000000007;
        if (n<2){
            return n;
        }
        int p,q=0,r=1;
        for (int i =2;i<=n;++i){
            p=q;
            q=r;
            r=(p+q)%MOD;
        }
        return r;
    }
    public int fib_loop(int n){
        final int MOD = 1000000007;
        if (n<2){return n;}
        if (map.containsKey(n)){return map.get(n);}
        int res = (fib_loop(n-1)+fib_loop(n-2))%MOD;
        map.put(n,res);
        return res;
    }

    public static void main(String[] args) {
        Offer_10_1 o101 = new Offer_10_1();
        int n = 45;
        System.out.println(o101.fib_loop(n));
        System.out.println(o101.fib_dp(n));
    }
}
