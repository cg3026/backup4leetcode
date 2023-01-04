package easy;



import java.util.Stack;
// 辅助栈方法
/*******************************
public class Offer_30_MinStack {

    Stack<Integer> stack;
    Stack<Integer> min;
    public Offer_30_MinStack(){
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x){
        if (stack.isEmpty()){
            min.push(x);
            stack.push(x);
            return;
        }
        min.push(min.peek()>x?x: min.peek());
        stack.push(x);
    }
    public void pop(){
        stack.pop();
        min.pop();
    }
    public int top(){
        return stack.peek();
    }
    public int min(){
        return min.peek();
    }
}
***************************/
// 非辅助栈方法
public class Offer_30_MinStack {
    Stack<Long> stack;
    // MAX_VALUE - MIN_VALUE > MAX_VALUE
    Long min;
    public Offer_30_MinStack(){
        stack = new Stack<>();
    }
    // 堆栈保存的是当前最小值与数值的差值，大于零意味着该时刻新插入值比最小值大，小于零意味着该时刻新插入值是下一个最小值。
    public void push(int x){
        if (stack.isEmpty()){
            stack.push(0L);
            min = (long) x;
        }
        else {
            stack.push(x - min);
            min = Math.min(x, min);
        }
    }
    public void pop(){
        if (stack.peek()<0){
            min = min - stack.pop();
            return;
        }
        stack.pop();
    }
    public int top(){
        if (stack.peek()>0){return (int)(min + stack.peek());}
        return Math.toIntExact(min);
    }
    public int min(){
        return Math.toIntExact(min);
    }
}
