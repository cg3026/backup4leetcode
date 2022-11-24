package easy;

public class Day_11_1742 {


    public int countBalls(int lowLimit, int highLimit) {
        int len = count(highLimit) * 9;
        int max = 0;
        int[] box = new int[len];
        for (int i = lowLimit;i <= highLimit;i++){
            box[sum(i)]++;
            max = Math.max(box[sum(i)], max);
        }
        return max;
    }
    public int count(int number){
        int i = 1;
        while(number != 0){
            number/=10;
            i++;
        }
        return i;
    }
    public int sum(int number){
        int cot = 0;
        while(number != 0){
            cot += number%10;
            number /= 10;
        }
        return cot;
    }

    public static void main(String[] args) {
        Day_11_1742 d11 = new Day_11_1742();
        System.out.println(d11.countBalls(19, 28));
    }
}
