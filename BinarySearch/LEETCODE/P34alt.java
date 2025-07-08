package DSA.BinarySearch.LEETCODE;

import java.util.Arrays;

////34. Find First and Last Position of Element in Sorted Array
public class P34alt {

    public static void main(String[] args){
        int[] arr = {5,7,7,8,8,10};
        System.out.println(Arrays.toString(searchRange(arr, 8)));

    }

    static int[] searchRange(int[] nums, int target) {
        int[]  ans = {-1,-1};

        int start = binarySearch(nums,target,true);
        int end = binarySearch(nums,target,false);
        /*
        ans[0] =binarySearch(nums,target,true);
        if(ans[0] != -1){
        ans[1] = binarySearch(nums,target,false);
        }

         */

        ans[0] = start;
        ans[1] = end;

        return ans;


    }

    static int binarySearch(int[]nums, int target, boolean findsearch){
        int ans = -1;

        int s = 0;
        int e = nums.length-1;
        while(s<=e){
            int mid = s+(e-s)/2;

            if (target<nums[mid]){
                e = mid -1;
            } else if (target>nums[mid]) {
                s = mid +1;
            }else{
                ans = mid;
                if(findsearch){
                    e= mid-1;
                }else{

                    s = mid+1;
                }
            }
        }
        return ans;
    }
}
