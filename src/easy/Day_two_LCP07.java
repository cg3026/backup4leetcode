package easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Day_two_LCP07 {

    int ways, n, k;
    List<List<Integer>> edges;

    public int numWays_dfs(int n, int[][] relation, int k) {
        ways = 0;
        this.n = n;
        this.k = k;
        edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] edge : relation) {
            int src = edge[0], dst = edge[1];
            edges.get(src).add(dst);
        }
        dfs(0, 0);
        return ways;
    }

    public void dfs(int index, int steps) {
        if (steps == k) {
            if (index == n - 1) {
                ways++;
            }
            return;
        }
        List<Integer> list = edges.get(index);
        for (int nextIndex : list) {
            dfs(nextIndex, steps + 1);
        }
    }
    // 复杂度太高了,属于非递归方式，用堆栈实现的dfs
    public int numWays(int n, int[][] relation, int k){
        int count = 0;
        Stack stack = new Stack();
        if (stack.empty()){
            stack.push(0);
        }
        int step = 0;
        int point = 0;
        int level_n = 1;
        int level_n_i = 0;
        while(step < k) {
            for (int i = 0; i < level_n; i++) {
                int node = (int) stack.get(point);
                for (int[] ints : relation) {
                    if (ints[0] == node) {
                        stack.push(ints[1]);
                        level_n_i++;
                    }
                }
                point++;
            }
            level_n = level_n_i;
            level_n_i = 0;
            step++;
        }
        for (int h = point; h < stack.size();h++){
            int nod = (int)stack.get(h);
            if (nod == n-1){
                count++;
            }
        }
        return count;
    }
    // 动态规划递归计算第i轮到各个点的方案数
    public int numWays_dp(int n, int[][] relation, int k) {
        int[][] dp = new int[k + 1][n];
        dp[0][0] = 1; // 表示第0轮传递到编号为0的小朋友的总方案数
        for (int i = 1; i <= k; i++) {
            for (int[] r : relation) {
                dp[i][r[1]] += dp[i - 1][r[0]];
            }
        }
        return dp[k][n - 1];
    }
    public static void main(String[] args) {
        int n = 5;
        Day_two_LCP07 dt7 = new Day_two_LCP07();
        int[][] relation = new int[][]{{0,2},{2,1},{3,4},{2,3},{1,4},{2,0},{0,4}};
        int[][] relation_0 = new int[][]{{0,2},{2,1}};
        int[][] relation_1 = new int[][]{{0,1},{0,2},{2,1},{1,2},{1,0},{2,0}};
        int k = 3;

        int c = dt7.numWays_dfs(3, relation_1, 5);
        System.out.println(c);


    }
}
