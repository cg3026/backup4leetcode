import easy.Offer_30_MinStack;
public class runTest {
    public static void main(String[] args) {
        Offer_30_MinStack o3m = new Offer_30_MinStack();
        o3m.push(2147483646);
        o3m.push(2147483646);
        o3m.push(2147483647);
        System.out.println(o3m.top());
        o3m.pop();
        System.out.println(o3m.min());
        o3m.pop();
        System.out.println(o3m.min());
        o3m.pop();
        o3m.push(2147483647);
        System.out.println(o3m.top());
        System.out.println(o3m.min());
        o3m.push(-2147483648);
        System.out.println(o3m.top());
        System.out.println(o3m.min());
        o3m.pop();
        System.out.println(o3m.min());
    }
}