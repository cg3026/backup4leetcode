package medium;

import java.util.HashMap;
import java.util.Stack;

//TODO:具体的时延影响原因未知，初步判断是占位数组计算导致。


/**
 * 树状下降回溯优先考虑递归方法
 */


public class Offer_12 {

    // 高时延解法  区别在于没有引入新的占位数组
    public boolean exist_my(char[][] board, String word) {
        int col = board.length;
        int row = board[0].length;
        boolean[][] read = new boolean[col][row];
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                boolean flag = check(board, read, i, j, word, 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check(char[][] board, boolean[][] read, int i, int j, String word, int n){
        if (board[i][j]!=word.charAt(n)){
            return false;
        }else if (n==word.length()-1){
            return true;
        }
        read[i][j] = true;
        boolean res = false;
        int[][] dires = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] dire:dires){
            int new_i = i + dire[0];int new_j = j + dire[1];
            if (new_i>=0 && new_i<board.length && new_j>=0 &&new_j<board[0].length){
                if (!read[new_i][new_j]){
                    boolean mid_res = check(board, read, new_i, new_j, word, n+1);
                    if (mid_res){
                        res = true;
                        break;
                    }
                }
            }
        }
        read[i][j]=false;
        return res;
    }

    /**低时延解法
     * 区别在于dfs的迭代计算过程里面的循环计算过程导致时延加长*/
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(board, words, i, j, 0)) return true;
            }
        }
        return false;
    }
    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) return false; // 当前点越界
        if(k == word.length - 1) return true;// 匹配结束
        board[i][j] = '\0';  // 占位表示当前已读
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i , j - 1, k + 1);  // 四个方向只要有一个走通就可以
        board[i][j] = word[k]; // 删除占位
        return res;
    }

    public static void main(String[] args) {
        Offer_12 o12 = new Offer_12();
        String word = "ABCED";
        char[][] board = new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        System.out.println(o12.exist(board, word));
    }
}
