package hard;

import java.util.Stack;
//TODO:没做完。
public class Day_11_10 {

    public boolean isMatch(String s, String p) {
        int start = 0;
        int current = 0;
        String[] cal = p.split("(?<=\\*)|(?=\\*)");
        for (int i=0;i<s.length();i++){
            if (s.charAt(i) == cal[start].charAt(current)){
                if (current == cal[start].length()){
                    start++;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Day_11_10 d11 = new Day_11_10();
        boolean a = d11.isMatch("aa","aa");
    }
}
