package DSA.BinarySearch.LEETCODE;
//34. Find First and Last Position of Element in Sorted Array

import java.util.Arrays;

public class P34 {
    public static void main(String[] args) {
        int[] arr = {5,7,7,8,8,10};
        System.out.println(Arrays.toString(searchRange(arr, 8)));


    }
    static int[] searchRange(int[] nums, int target) {

        int start = 0;
        int end = nums.length-1;

        while(start<=end){
            int mid = start + (end - start)/2;

            if(target<nums[mid]){
                end = mid -1;
            } else if (target>nums[mid]) {
                start = mid +1;

            }else{
                return new int[]{start(nums,target),end(nums,target)};
            }
        }
        return new int[]{-1,-1};
    }
    static int start(int[] nums, int target) {

        int start = 0;
        int end = nums.length-1;
        int ans = -1;

        while(start<=end){
            int mid = start + (end - start)/2;

            if(target<nums[mid]){
                end = mid -1;
            } else if (target>nums[mid]) {
                start = mid +1;

            }else{
                ans = mid;
                end = mid-1;
            }
        }
        return ans;
    }
    static int end(int[] nums, int target) {

        int start = 0;
        int end = nums.length-1;
        int ans = -1;

        while(start<=end){
            int mid = start + (end - start)/2;

            if(target<nums[mid]){
                end = mid -1;
            } else if (target>nums[mid]) {
                start = mid +1;

            }else{
                ans = mid;
                start = mid +1;
            }
        }
        return ans;
    }
}
