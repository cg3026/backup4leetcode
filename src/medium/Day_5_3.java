package medium;

import java.util.Stack;

public class Day_5_3 {
    // 时延上天了,滑动窗口，记录窗口内容
    public int lengthOfLongestSubstring_slow(String s){
        Stack stack = new Stack();
        int begin = 0;
        int point = 0;
        int max_len = 0;
        while (begin < s.length() && point < s.length()){
            if (!stack.contains(s.charAt(point))){
                stack.push(s.charAt(point));
                point++;
            }else{
                max_len = Math.max(stack.size(),max_len);
                stack.clear();
                begin++;
                point = begin;
            }
        }
        max_len = Math.max(stack.size(),max_len);
        return max_len;
    }
    //滑动窗口但数组，不记录窗口内容，只记录窗口始末
    public int lengthOfLongestSubstring_fast(String s){
        // 上一次该字符出现的位置=>last[char]=int
        int[] last = new int[128];
        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;
        int start = 0;
        for(int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            res   = Math.max(res, i - start + 1);
            last[index] = i;
        }

        return res;
    }

    public static void main(String[] args) {
        Day_5_3 d5 = new Day_5_3();
        String s = "1234";
        int len = d5.lengthOfLongestSubstring_fast(s);
        System.out.println(len);
    }
}
