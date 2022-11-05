package medium;


public class Day_3_1620 {

    public double o_distance(int[] coordinate_0, int[] coordinate_1){
        return Math.sqrt(Math.pow((coordinate_0[0]-coordinate_1[0]), 2) + Math.pow((coordinate_0[1]-coordinate_1[1]), 2));
    }
    public int[] radius_range(int[][] towers, int radius){
        int[] range = new int[4];
        for (int[] tower: towers){
            range[0] = Math.min(range[0], Math.max(tower[0]- radius, 0) );
            range[1] = Math.max(range[1], tower[0] + radius);
            range[2] = Math.min(range[2], Math.max(tower[1] - radius, 0));
            range[3] = Math.max(range[3], tower[1] + radius);
        }
        return range;
    }
    // 暴力破解，嘎嘎慢
    public int[] bestCoordinate(int[][] towers, int radius) {
        int[] range = radius_range(towers, radius);
        int[] point = new int[2];
        int max_radius = 0;
        for (int i=0;i<range[1]-range[0]+1;i++){
            for (int j=0;j<range[3]-range[2]+1;j++){
                int radius_m = 0;
                for(int[] tower:towers){
                    double d =o_distance(new int[]{i + range[0], j + range[2]}, new int[]{tower[0],tower[1]});
                    if (d <= radius) {
                        radius_m = radius_m + (int)(tower[2]/(1+d));
                    }
                }
                if (radius_m > max_radius){
                    max_radius = radius_m;
                    point[0] = i + range[0];
                    point[1] = j + range[2];
                }
            }
        }
        return point;
    }

    public static void main(String[] args) {
        int[] co_1 = new int[]{0,0,0};
        int[] co_2 = new int[]{1,1,1};
        Day_3_1620 dt = new Day_3_1620();
        int [][] towers = new int[][]{{1,2,5},{2,1,7},{3,1,9}};
        int radius = 2;
        int[] pp = dt.bestCoordinate(towers, radius);
        System.out.println(pp[0]);
        System.out.println(pp[1]);
    }
}
