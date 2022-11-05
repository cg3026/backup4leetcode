package hard;

import java.util.Queue;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day_6_1106 {

    // 暴力破解方式 时延和内存占用都很高
    public boolean parseBoolExpr_it(String expression){
        if (expression.length() == 1){
            return expression.equals("t");
        }
        String[] expr = getexpr(expression);
        String operator = expr[0];
        boolean mid = true;
        switch (operator) {
            case "!":
                for (int i = 1; i < expr.length; i++) {
                    return !parseBoolExpr_it(expr[i]);
                }
                break;
            case "&":
                for (int i = 1; i < expr.length; i++) {
                    mid = mid & parseBoolExpr_it(expr[i]);
                }
                break;
            case "|":
                mid = false;
                for (int i = 1; i < expr.length; i++) {
                    mid = mid | parseBoolExpr_it(expr[i]);
                }
                break;
        }
        return mid;

    }

    public boolean parseBoolExpr_stack(String expression){
        Stack cal = new Stack();
        Stack cal_0 = new Stack();
        for(int i = 0;i< expression.length();i++){
            if (expression.charAt(i) == ','){
                continue;
            }
            if (expression.charAt(i) == ')'){
                while(!cal.peek().toString().equals("(")){
                    cal_0.push(cal.pop());
                }
                cal.pop();
                char mid = 't';
                String operator = cal.pop().toString();
                if (operator.equals("!")){
                    cal.push(cal_0.pop().toString().equals("t")?'f':'t');
                    continue;
                }else if (operator.equals("&")){
                    mid = cal_0.contains('f')?'f':'t';
                    cal_0.clear();
                }else if(operator.equals("|")){
                    mid = cal_0.contains('t')?'t':'f';
                    cal_0.clear();
                }
                cal.push(mid);
            }else {
                cal.push(expression.charAt(i));
            }
        }
        if (!cal.empty()){
            return cal.pop().toString().equals("t")?true:false;
        }
        return false;
    }
    // 函数递归向后，顺序计算每一个子问题和子问题的子问题
    public boolean parseBoolExpr_loop(String expression){
        if (expression.length() == 1) {return expression.equals("t");}
        char operator = expression.charAt(0);
        int pre = 2;
        int count = 0;
        for (int i = 2; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') {count++;}
            else if (i != expression.length() - 1 && expression.charAt(i) == ')') {count--;}
            if (count == 0 && (expression.charAt(i) == ',' || i == expression.length() - 1)) {
                boolean mid = parseBoolExpr_loop(expression.substring(pre, i));
                if (operator == '!') {return !mid;}
                if (operator == '|' && mid) {return true;}
                if (operator == '&' && !mid) {return false;}
                pre = i + 1;
            }
        }
        return operator == '|';
    }
    public String[] getexpr(String expression){
        String pattern = "(.)\\((.*)\\)";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(expression);
        boolean flag = m.find();
        String pattern_0 = "\\(.*\\)";
        Pattern r_0 = Pattern.compile(pattern_0);
        Matcher m_0 = r_0.matcher(m.group(2));
        boolean flag_0 = m_0.find();
        StringBuffer sb = new StringBuffer();
        sb.append(m.group(1) + '_');
        if (!flag_0){
            String[] exprs = m.group(2).split(",");
            for (String expr:exprs){
                sb.append(expr + '_');
            }
            String[] expr = sb.toString().split("_");
            return expr;
        }
        int left = 0;
        if (flag){
            String expr_last = m.group(2);
            for (int i = 0;i<expr_last.length();i++){
                if (expr_last.charAt(i) == '('){
                    sb.append(expr_last.charAt(i));
                    left++;
                }else if (expr_last.charAt(i) == ')'){
                    sb.append(expr_last.charAt(i));
                    left--;
                }else if (expr_last.charAt(i) == ',' && left == 0){
                    sb.append('_');
                }else {
                    sb.append(expr_last.charAt(i));
                }
            }
        }
        String[] res = sb.toString().split("_");
        return res;
    }
    public static void main(String[] args) {
        Day_6_1106 d6 = new Day_6_1106();
        String expression = "|(&(t,!(f),!(t),f))";
        String expression_1 = "!(&(!(&(f)),&(t),|(f,f,t)))";
        String expression_p = "|(&(t,f,t),!(t))";

        boolean res = d6.parseBoolExpr_loop(expression_p);
        System.out.println(res);

//        Stack stack = new Stack();
//        String[] st = new String[]{"t","f","t","f"};
//        for (String s:st){
//            stack.push(s);
//        }
//        char mid = stack.contains("f")?'f':'t';
//        System.out.println(mid);
    }
}
