package Arrays.LEETCODE;

import java.util.Arrays;

public class P73 {
    static void setZeroes(int[][] matrix){
        int rows = matrix.length;
        int col = matrix[0].length;

        boolean f_Row = false;
        boolean f_col = false;

        for (int j = 0; j < col; j++) {
            if (matrix[0][j] == 0) {
                f_Row = true;
                break;
            }
        }
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                f_col = true;
                break;
            }
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }

            }

        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;

                }

            }

        }
        if (f_Row) {
            for (int j = 0; j < col; j++) {
                matrix[0][j] = 0;

            }
        }
        if (f_col) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;

            }
        }
    }
    public static void main(String[] args) {

        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setZeroes(matrix);
//        for(int[] i:matrix){
//            for(int j: i){
//                System.out.println(j);
//            }
//            System.out.println();
//        }
        System.out.println(Arrays.deepToString(matrix));



        }
    }

