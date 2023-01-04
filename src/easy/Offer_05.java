package easy;

public class Offer_05 {


    public String replaceSpace_replace(String s) {
        String s_20;
        s_20 = s.replace(" ","%20");
        return s_20;
    }

    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<s.length();i++){
            sb.append(s.charAt(i)== ' '?"%20":s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "We are happy.";
        Offer_05 o05 = new Offer_05();
        System.out.println(o05.replaceSpace(s));
    }
}
