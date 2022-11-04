package medium;

import java.util.Stack;


// 首先是正负对称
// 其次是目标在于尽可能的向右走靠近目标值也就是不断地+numMoves
// 当超过目标值时，调整前面累加中部分数值的正负号，可以向target收缩
// 当超出值为偶数t时，将累加中t/2的改为负号即可，
// 当超出值为奇数k时，必有k<numMoves，numMoves+1-k必定在累加的数值在内,
// 因此，加上numMoves+1后再把numMoves+1-k的符号变负，则到达target。
public class Day_5_754 {
    public int reachNumber(int target) {
        int target_abs = Math.abs(target);
        int total = 0;
        int numMoves = 0;
        while (total < target_abs){
            numMoves++;
            total+=numMoves;

        }
        return (total-target_abs%2==0 ? numMoves : numMoves + 1 + numMoves%2);
    }
    public static void main(String[] args) {
        int target = 5;
        Day_5_754 d5 = new Day_5_754();
        int m = d5.reachNumber(target);
        System.out.println(m);

    }
}
