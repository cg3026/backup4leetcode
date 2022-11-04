package easy;

import java.util.Arrays;

public class Day_4_1668 {
    // 字符串滑动遍历
    public int maxRepeating_slide(String sequence, String word) {
        char[] words =  word.toCharArray();
        char[] sequences = sequence.toCharArray();
        int point;
        int point_begin = 0;
        int count = 0;
        int max_count = 0;
        boolean flag;
        boolean flag_0;
        while (sequence.length()- point_begin>=words.length) {
            flag = true;
            point = point_begin;
            count = 0;
            while (flag){
                flag_0 =true;
                for(char letter:words){
                    if (sequences[point] == letter){
                        if (point < sequences.length-1){
                            point++;
                        }else if (point == sequences.length-1 && (point- point_begin + 1)% words.length == 0){
                            count++;
                            flag_0 = false;
                            flag = false;
                            point_begin = sequences.length - 1;}
                        else {flag_0 = false;
                            flag = false;
                            point_begin = sequences.length - 1;}
                    } else {
                        flag_0 =false;break;}
                }
                if (flag_0){
                    count++;
                }else {
                    break;
                }
            }
            max_count = Math.max(count, max_count);
            point_begin++;}
        max_count = Math.max(count, max_count);
        return max_count;
    }

    public int maxRepeating_front(String sequence, String word) {
        int n = sequence.length(), m = word.length();
        if (n < m) {
            return 0;
        }
        int[] f = new int[n];
        for (int i = m - 1; i < n; ++i) {
            boolean valid = true;
            for (int j = 0; j < m; ++j) {
                if (sequence.charAt(i - (m-1) + j) != word.charAt(j)) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                f[i] = (i == m - 1 ? 0 : f[i - m]) + 1;
            }
        }

        return Arrays.stream(f).max().getAsInt();
    }
    public int maxRepeating_it(String sequence, String word) {
        int count = 0;
        String word_it = word;
        while (sequence.contains(word_it)){
            word_it = word_it+word ;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Day_4_1668 d4 = new Day_4_1668();
        String sequence = "aaaaa";
        String sequence_0 = "aaa";
        String word_0 = "";
        String word = "a";
        int count = 0;
        int m = d4.maxRepeating_it(sequence, word);
        System.out.println(m);

    }
}
