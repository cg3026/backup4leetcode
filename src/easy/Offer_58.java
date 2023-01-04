package easy;

public class Offer_58 {

    public String reverseLeftWords(String s, int n) {
        return s.substring(n) +
                s.substring(0, n);
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        int k=2;
        Offer_58 o58 = new Offer_58();
        System.out.println(o58.reverseLeftWords(s,k));
    }
}
