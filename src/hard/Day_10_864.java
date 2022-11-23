package hard;

import java.util.*;

public class Day_10_864 {

    public int shortestPathAllKeys(String[] grids) {
        int rows = grids.length;
        int cols = grids[0].length();
        char[][] map = new char[rows][cols];
        int lock = 0;
        Queue<int[]> walk = new ArrayDeque();
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                map[i][j] = grids[i].charAt(j);
                if (map[i][j]=='@'){
                    walk.offer(new int[]{i,j,0});
                }else if(Character.isLowerCase(map[i][j])){
                    lock++;
                }
            }
        }
        int[][][] state = new int[rows][cols][1<<lock];
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                Arrays.fill(state[i][j], -1);
            }
        }
        state[walk.peek()[0]][walk.peek()[1]][walk.peek()[2]] = 0;
        while (!walk.isEmpty()){
            int[] arr = walk.poll();
            int x=arr[0],y=arr[1],st=arr[2];
            int[][] next = new int[][]{{x+1,y},{x,y+1},{x-1,y},{x,y-1}};
            for (int[] coor:next){
                int n_x = coor[0],n_y = coor[1];
                if (n_x>=0 && n_y>=0 && n_x<rows && n_y<cols && map[n_x][n_y] !='#'){
                    if (map[n_x][n_y] == '.' || map[n_x][n_y]== '@'){
                        if (state[n_x][n_y][st] == -1){
                            state[n_x][n_y][st] = state[x][y][st] +1;
                            walk.offer(new int[]{n_x,n_y,st});
                        }
                    }else if (Character.isLowerCase(map[n_x][n_y])){
                        if (state[n_x][n_y][st |1<<(map[n_x][n_y]-'a')] == -1){
                            state[n_x][n_y][st |1<<(map[n_x][n_y]-'a')] = state[x][y][st] +1;
                            if ((st |1<<(map[n_x][n_y]-'a')) == ((1<<lock)-1)){
                                return state[n_x][n_y][st |1<<(map[n_x][n_y]-'a')];
                            }
                            walk.offer(new int[]{n_x,n_y,st|1<<(map[n_x][n_y]-'a')});
                        }
                    }else {
                        int locky = Character.toLowerCase(map[n_x][n_y]) - 'a';
                        if ((st & 1<<locky)!=0 && state[n_x][n_y][st]==-1){
                            state[n_x][n_y][st] = state[x][y][st] +1;
                            walk.offer(new int[]{n_x,n_y,st});
                        }
                    }
                }
            }
        }


        return -1;
    }

    public static void main(String[] args) {
        Day_10_864 d10 = new Day_10_864();
        String[] grid = new String[]{"@.a.#","###.#","b.A.B"};
        String[] grid_0 = new String[]{"@..aA","..B#.","....b"};
        String[] grid_1 = new String[]{"@Aa"};
        int res  = d10.shortestPathAllKeys(grid_1);
        System.out.println(res);
    }
}
