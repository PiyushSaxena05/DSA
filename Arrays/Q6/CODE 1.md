package Arrays;

import java.util.Arrays;

public class Q8 {
   public static int[] arr(int[] arr,int k){
    int newlength = 0;
    int length = 0;
    int s = -1;
    int e = -1;
       int[] subarr = new int[arr.length-1];
       for (int i = 0; i <arr.length ; i++) {
           int sum = 0;

           for (int j = i; j <arr.length ; j++) {
               sum+= arr[j];
               if(sum==k){
                   length = j-i+1;

                   if(length>newlength){
                       newlength = length;
                       s = i;
                       e = j;
                   }
               }


           }
       }
       return new int[]{s,e};

   }
    public static int arr1(int[] arr,int k) {
        int newlength = 0;
        int length = 0;
        int s = -1;
        int e = -1;
        int[] subarr = new int[arr.length - 1];
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;

            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == k) {
                    length = j - i + 1;

                    if (length > newlength) {
                        newlength = length;

                        e = j;
                    }
                }


            }
        }
        return e;
    }
        public static void main (String[]args){
            int[] nums = {10, 5, 2, 7, 1, 9};

            System.out.println(Arrays.toString(arr(nums, 15)));
            System.out.println(arr1(nums,15));

        }

}
