package medium;

import java.util.ArrayList;
import java.util.List;

public class Day_8_816 {

    public boolean legal(String s){
        String[] ss = s.split("\\.");
        String decimal = "";
        String integer = "";
        if (ss.length ==1){
            integer = s;
        }else {
            integer = ss[0];
            decimal = ss[1];
        }
        if (decimal.length()>0){
            if (Integer.parseInt(decimal) == 0 || decimal.substring(decimal.length()-1).equals("0")){
                return false;
            }
        }
        if ((int)(Integer.parseInt(integer)/Math.pow(10,integer.length()-1)) == 0 && integer.length()!=1){
            return false;
        }
        return true;
    }
    // 遍历方式暴力破解，生成全部可能判断
    public List<String> ambiguousCoordinates_high_memory(String s){
        int length = s.length();
        List<String> coordinate = new ArrayList<String>();
        for (int i = 2;i<length-1;i++){
            String left = s.substring(1,i);
            String right = s.substring(i,length-1);
            for (int j=1;j<=left.length();j++){
                String point = ".";
                String left_coor = j == left.length() ? left: left.substring(0, j) + point + left.substring(j);
                if (!legal(left_coor)){
                    continue;
                }
                for (int m=1;m<=right.length();m++){
                    String right_coor = m == right.length() ? right: right.substring(0, m) + point + right.substring(m);
                    if (!legal(right_coor)){
                        continue;
                    }
                    coordinate.add(String.format("(%s, %s)",left_coor,right_coor));
                }
            }
        }
        return coordinate;
    }
    // 并非生成全部字符串，只生成合法的
    public List<String> ambiguousCoordinates_low_memory(String s) {
        List<String> res =new ArrayList<>();
        for(int i=2;i<s.length()-1;i++){
            String left = s.substring(1, i);
            String right = s.substring(i, s.length()-1);

            List<String> ls = split(left);
            List<String> rs = split(right);
            for(int j=0;j<ls.size();j++){
                for(int k=0;k<rs.size();k++){
                    res.add("("+ls.get(j) + ", " + rs.get(k)+")");
                }
            }
        }
        return res;
    }
    List<String> split(String s){
        List<String> sp =new ArrayList<>();
        if(s.charAt(0)=='0'){
            if(s.length()>1 && s.charAt(s.length()-1)=='0') return sp;
            else if(s.length()==1){
                sp.add(s);
                return sp;
            } else {
                sp.add("0."+s.substring(1));
                return sp;
            }
        } else {
            sp.add(s);
            if(s.charAt(s.length()-1)!='0'){
                for(int i=1;i<s.length();i++){
                    sp.add(s.substring(0, i)+"."+s.substring(i));
                }
            }
            return sp;
        }
    }

    public static void main(String[] args) {
        Day_8_816 d8 = new Day_8_816();
        String str = "(0010)";
        List<String> coor = d8.ambiguousCoordinates_high_memory(str);
        System.out.println(coor);
    }
}
