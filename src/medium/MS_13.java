package medium;

public class MS_13 {

    public int movingCount_my(int m, int n, int k) {
        boolean[][] mark = new boolean[m][n];
        return moving(0, 0, mark, k);
    }

    public int moving(int i, int j, boolean[][] mark, int k){
        if(i >= mark.length || i < 0 || j >= mark[0].length || j < 0 || mark[i][j] || (i/10 + i%10 + j/10 + j%10) > k) return 0;
        mark[i][j]=true;
        return moving(i+1, j, mark, k)+moving(i, j+1, mark, k)+moving(i-1, j, mark, k)+moving(i, j-1, mark, k)+1;
    }


    public boolean move(int i, int j, int k){
        int res = 0;
        while(i!=0){res+=i%10;i/=10;}
        while (j!=0){res+=j%10;j/=10;}
        return res <= k;
    }


    public static void main(String[] args) {
        MS_13 ms13 = new MS_13();
        System.out.println(ms13.movingCount_my(3,1,0));
    }
}
