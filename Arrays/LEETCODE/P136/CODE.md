package Arrays.LEETCODE;

import java.util.Arrays;

public class P136 {
    public static int singleNumber(int[] nums) {

//        if(nums.length==1){
//            return nums[0];
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//           int number = nums[i];
//            int count = 0;
//            for (int j = 0; j < nums.length; j++) {
//                if(nums[j]==number){
//                    count++;
//                }
//
//
//            }
//            if(count==1){
//                return number;
//            }
//
//        }
//        return -1;

        int xor = 0;
        for(int num:nums){
            xor^= num;
        }
        return xor;
    }
    public static void main(String[] args) {
        int[] arr1 = {4,1,2,1,2};
        int[] arr2 = {2,2,1};
        int[] arr3 ={1};
        int ans1 = singleNumber(arr1);
        int ans2 = singleNumber(arr2);
        int ans3 = singleNumber(arr3);
        System.out.println(ans1);
        System.out.println(ans2);
        System.out.println(ans3);



    }

}
