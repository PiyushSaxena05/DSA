package Arrays;

import java.util.HashMap;

public class Q11 {
    public static int countPairs(int[] arr , int target){

        int count =0;
        for (int i = 0; i < arr.length ; i++) {

            for (int j = i+1; j <arr.length ; j++) {
                if(arr[i]+arr[j]==target){
                    count++;
                }

            }
        }
        return count;

    }
    public static void main(String[] args) {
        int[] arr = {1,5,7,-1,5};
        int ans = countPairs(arr,6);
        System.out.println(ans);
       

    }
}
