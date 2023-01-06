package medium;

import java.util.HashMap;
import java.util.Map;

public class Offer_48 {

    public int lengthOfLongestSubstring_arr(String s) {
        HashMap<Character,Integer> dic = new HashMap<>();
        int head = -1, max = 0;
        for (int i = 0; i < s.length(); i++){
            if (dic.containsKey(s.charAt(i))){
                head = Math.max(head, dic.get(s.charAt(i)));
            }
            dic.put(s.charAt(i),i);
            max = Math.max(max, i-head);
        }
        return max;
    }
    public int lengthOfLongestSubstring_arr_my(String s) {
        char[] ss = s.toCharArray();
        int head = 0, max = 0;
        for (int i = 0; i < ss.length; i++){
            String cur = String.valueOf(ss[i]);
            if (s.substring(head, i).contains(cur)){
                int index = s.substring(head, i).indexOf(cur);
                head = index + head + 1;
            }
            max = Math.max(max, i-head + 1);
        }
        return max;
    }
    // 动态规划的状态转移方程，假设dp[j]是第以字符s[j]为结尾的最长不重复子串的长度,j为第j个字符，
    // 那么假设s[i]是s[j]左边距离s[j]最近的相同字符，即s[j]=s[i],当i<0时，说明左侧没有相同字符，长度为dp[j]=dp[j-1]+1
    // 当dp[j-1]<j-i, 说明s[i]不在当前最短字符串中,不需要调整字符串头，长度为dp[j]=dp[j-1]+1
    // 当dp[j-1]>=j-i, 说明s[i]在当前最短字符串中,需要调整串头,长度为dp[j]=j-i;
    public int lengthOfLongestSubstring_dp_my(String s) {
        int len = s.length();
        int q = 0, max=0;
        for (int j = 0;j < len;j++){
            // 此处字符串计算相当耗时
            int index = s.substring(0, j).lastIndexOf(s.charAt(j));
            q = q >= j - index ? j - index : q + 1;
            max = Math.max(max, q);
        }
        return max;
    }

    public int lengthOfLongestSubstring_dp_leetcode(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0, tmp = 0;
        for(int j = 0; j < s.length(); j++) {
            int i = dic.getOrDefault(s.charAt(j), -1); // 获取索引 i
            dic.put(s.charAt(j), j); // 更新哈希表
            tmp = tmp < j - i ? tmp + 1 : j - i; // dp[j - 1] -> dp[j]
            res = Math.max(res, tmp); // max(dp[j - 1], dp[j])
        }
        return res;
    }


    public static void main(String[] args) {
        Offer_48 o48 = new Offer_48();
        String input = " ";
        System.out.println(o48.lengthOfLongestSubstring_arr(input));
    }
}
