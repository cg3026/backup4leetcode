package easy;

import java.util.Stack;

public class Offer_09_CQueue {
    public Stack<Integer> m_stack;
    public Stack<Integer> c_stack;
    public Offer_09_CQueue(){
        c_stack = new Stack();
        m_stack = new Stack();
    }

    public void appendTail(int value) {
        m_stack.push(value);
    }
    public int deleteHead() {
        if(!c_stack.isEmpty()){
            return c_stack.pop();
        }else{
            while(!m_stack.isEmpty()){
                c_stack.push(m_stack.pop());
            }
            return c_stack.isEmpty() ? -1 : c_stack.pop();
        }
    }
}
