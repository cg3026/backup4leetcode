package easy;

import java.util.ArrayList;
import java.util.List;

public class Day_9_1684 {

    //List方式
    public int countConsistentStrings_list(String allowed, String[] words) {
        List all = new ArrayList<>();
        int count = 0;
        for (char alloweds:allowed.toCharArray()){all.add(alloweds);}
        for (String word:words){
            boolean flag = true;
            for (int i=0;i<word.length();i++){
                if (!all.contains(word.charAt(i))){flag = false;break;}
            }
            if (flag){count++;}
        }
        return count;
    }

    // hash方式
    public int countConsistentStrings_hash(String allowed, String[] words) {
        int[] hash = new int[26];
        int count = 0;
        for(int i = 0; i < allowed.length(); i++){hash[allowed.charAt(i)-'a'] = 1;}
        for(String word : words){
            boolean flag = true;
            for(int i = 0; i < word.length(); i++){
                if(hash[word.charAt(i)-97] == 0){flag = false;break;}
            }
            if(flag){count++;}
        }
        return count;
    }

    // 位运算方法
    public int countConsistentStrings_bitcal(String allowed, String[] words) {
        int mask = f(allowed);
        int ans = 0;
        for (String w : words) {
            if ((mask | f(w)) == mask) {
                ++ans;
            }
        }
        return ans;
    }

    private int f(String w) {
        int mask = 0;
        for (int i = 0; i < w.length(); ++i) {
            // <<代表左移位运算
            // 例如字符d=>左移四位=>1000 与原有ab=>0011或运算，获得1011，最多需要26bit，第i个字母出现则第i位bit置1
            mask |= 1 << (w.charAt(i) - 'a');
        }
        return mask;
    }

    public static void main(String[] args) {
        Day_9_1684 d9 = new Day_9_1684();
        String allowed = "ab";
        String[] words = new String[]{"ad","bd","aaab","baa","badab"};
//        int res  = d9.countConsistentStrings_hash(allowed,words);
        int mask = d9.f(allowed);
        System.out.println(mask);
    }
}
