package medium;

public class Day_10_7 {

    public int reverse_slow(int x) {
        StringBuilder str = new StringBuilder(String.valueOf(Math.abs(x) < 0 ? 0 : Math.abs(x)));
        str.reverse();
        if(x < 0) str.insert(0,"-");
        long num = Long.parseLong(str.toString());
        return (num > Integer.MAX_VALUE) ||
                (num < Integer.MIN_VALUE) ? 0 : (int)num;
    }
    public int reverse_fast(int x){
        long n = 0;
        while(x != 0) {
            n = n*10 + x%10;
            x = x/10;
        }
        return (int)n==n? (int)n:0;
    }
    public static void main(String[] args) {
        Day_10_7 d10 = new Day_10_7();
        int x = 1534236469;
        int res = d10.reverse_fast(x);
        System.out.println(res);
    }
}
