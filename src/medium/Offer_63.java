package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Offer_63 {

    public int maxProfit(int[] prices) {
        int[] profits = new int[prices.length];
        int max = 0;
        for (int i=0;i<prices.length;i++){
            profits[i]=-prices[i];
            for (int j=i;j<prices.length;j++){
                profits[i] = Math.max(prices[j]-prices[i],profits[i]);
            }
        }
        for (int profit:profits){
            max = Math.max(profit,max);
        }
        return max;
    }
// 找到顺序差值最大的一对
    public int maxProfit_dp(int[] prices) {
        int cost = Integer.MAX_VALUE;
        int profit = 0;
        for (int price:prices){
            cost = Math.min(cost,price);
            profit = Math.max(profit,price-cost);
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] trend = new int[]{7,6,4,3,1};
        Offer_63 o63 = new Offer_63();
        System.out.println(o63.maxProfit(trend));
    }
}
