package DSA.LinearSearch;

import java.util.Arrays;

public class Maximum2d {
    public static void main(String[] args) {
        int[][] arr = {
                {23,4,1},
                {18,12,3,9},
                {78,99,34,56},
                {18,12}
        };

        int ans = max(arr);
        System.out.println(ans);
    }

    static int max(int[][] arr){

        int max = Integer.MIN_VALUE;

        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j <arr[i].length ; j++) {
                if(arr[i][j]>max){
                  max = arr[i][j];


                }
            }

        }
        return max;
    }
}
