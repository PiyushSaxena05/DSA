package DSA.LinearSearch.LEETCODE;

// problem 1295
//Given an array nums of integers. return how many of them contain an even number of digits.


public class Problem1 {
    public static void main(String[] args){
        int[] arr = { 555,901,482,1771};
        int[] arr2 = {12,345,2,6,7896};
        System.out.println(num(arr));
    }

    static int num(int[] arr){
        int maincount = 0 ;


        for (int i = 0; i < arr.length ; i++) {
            int  count =0;

            int num = arr[i];

            while (num > 0) {
                num = num/ 10;
                count++;

            }
            if(count%2==0){
                maincount++;
            }


        }

        return maincount;

        }


}

/*
nums = [555,501,82,1771]
 */
