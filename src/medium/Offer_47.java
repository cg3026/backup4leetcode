package medium;

public class Offer_47 {

    // 状态转移方程price(i,j) = Max(price(i-1,j),price(i,j-1))+grid(i,j)
    public int maxValue(int[][] grid) {
        int m = grid.length,n = grid[0].length;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (i==0&&j==0){continue;}
                if (i==0){grid[i][j] = grid[i][j-1] + grid[i][j];}
                else if (j==0){grid[i][j] = grid[i-1][j] + grid[i][j];}
                else {grid[i][j] = grid[i][j] + Math.max(grid[i-1][j],grid[i][j-1]);}
            }
        }
        return grid[m-1][n-1];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        Offer_47 o47 = new Offer_47();
        System.out.println(o47.maxValue(grid));
    }
}
