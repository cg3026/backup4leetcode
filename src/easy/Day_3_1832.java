package easy;

public class Day_3_1832 {

    // 大内存占用
    public boolean checkIfPangram_bm(String sentence){
        boolean flag = true;
        int[] count = new int[26];
        int len = sentence.length();
        for (int l=0; l < len; l++){
            count[sentence.charAt(l)-'a']++;
        }
        for(int letter:count){
            if (letter == 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }
    public boolean checkIfPangram_lowm(String sentence) {
        boolean[] cache = new boolean[26];
        char[] ss = sentence.toCharArray();
        for (char c : ss) cache[c - 'a'] = true;
        for (boolean b : cache) if (!b) return false;
        return true;
    }

    public boolean checkIfPangram_fast(String sentence){
        for (int l=97; l < 123; l++){
            if(sentence.indexOf((char)l) == -1){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String str = "thequickbrownfoxjumpsoverthelazydog";
        Day_3_1832 dt = new Day_3_1832();
        boolean flagg = dt.checkIfPangram_fast(str);
        System.out.println(flagg);
    }
}
