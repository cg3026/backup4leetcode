package medium;

public class Day_10_8 {

    public int myAtoi(String s) {

        boolean flag = true;
        int sy_c = 0;
        String mid_s = s.replace(" ","");
        if (mid_s.length() == 0 || mid_s.equals("-") || mid_s.equals("+")){return 0;}
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<mid_s.length();i++){
            if (mid_s.charAt(i)-'0'>=0&& ('9'-mid_s.charAt(i))>=0){
                sb.append(mid_s.charAt(i));
                if (Long.parseLong(sb.toString())>Integer.MAX_VALUE || Long.parseLong(sb.toString())<Integer.MIN_VALUE ){
                    return flag?Integer.MAX_VALUE:Integer.MIN_VALUE;
                }
            } else if ((mid_s.charAt(i) == '-' || mid_s.charAt(i)== '+') && sb.isEmpty()){
                flag=(mid_s.charAt(i)=='-')?false:true;
                sy_c++;
                if (sy_c>1 && sb.isEmpty()){return 0;}
            }
            else {
                if (sb.isEmpty()){return 0;}
                return flag?Integer.parseInt(sb.toString()):-Integer.parseInt(sb.toString());
                }
            }
        return flag?Integer.parseInt(sb.toString()):-Integer.parseInt(sb.toString());
    }
    public static void main(String[] args) {
        Day_10_8 d10 = new Day_10_8();
        String s = "00000-42a1234";
        int res = d10.myAtoi(s);
        System.out.println(res);
    }
}
