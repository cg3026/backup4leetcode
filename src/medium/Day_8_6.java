package medium;

import java.util.ArrayList;
import java.util.List;

public class Day_8_6 {

        public String convert_list(String s, int numRows) {
            if(numRows < 2) return s;
            List<StringBuilder> rows = new ArrayList<StringBuilder>();
            for(int i = 0; i < numRows; i++) rows.add(new StringBuilder());
            int i = 0, flag = -1;
            for(char c : s.toCharArray()) {
                rows.get(i).append(c);
                if(i == 0 || i == numRows -1) flag = - flag;
                i += flag;
            }
            StringBuilder res = new StringBuilder();
            for(StringBuilder row : rows) res.append(row);
            return res.toString();
        }
    public String convert(String s, int numRows) {
        if(numRows < 2 || s.length() < numRows) return s;
        StringBuilder[] str = new StringBuilder[numRows];
        int num=0;
        while (num<s.length()) {
            for (int i = 0; i < numRows; i++) {
                if (str[i]==null){
                    StringBuilder sb = new StringBuilder();
                    str[i] = sb;
                }
                if (num >= s.length()){
                    break;
                }
                str[i].append(s.charAt(num));
                num++;
            }
            for (int j = numRows-2;j>0;j--){
                if (num >= s.length()){
                    break;
                }
                str[j].append(s.charAt(num));
                num++;
            }
        }
        StringBuilder res =new StringBuilder();
        for (StringBuilder sb:str){
            res.append(sb.toString());
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Day_8_6 d8 = new Day_8_6();
        String str = "A";
        String re = d8.convert(str, 3);
        System.out.println(re);

    }
}
