package easy;

public class Day_2_1662 {

    public boolean arrayStringsAreEqual_slow(String[] word1, String[] word2) {
        StringBuilder wd = new StringBuilder();
        StringBuilder wd1 = new StringBuilder();
        for(String word: word1){
            wd.append(word);
        }
        for (String word: word2){
            wd1.append(word);
        }
        return wd.toString().equals(wd1.toString());
    }
    public boolean arrayStringsAreEqual_fast(String[] word1, String[] word2){
        return join(word1).equals(join(word2));
    }

    public String join(String[] words){
        StringBuilder ret = new StringBuilder();
        for (String s : words) {
            ret.append(s);
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        Day_2_1662 dt1662 = new Day_2_1662();
        String[] word1 = {"ab", "c"};
        String[] word2 = {"a", "bc"};
        System.out.println(dt1662.arrayStringsAreEqual_fast(word1, word2));
    }
}
