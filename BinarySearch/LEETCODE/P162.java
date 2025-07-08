package DSA.BinarySearch.LEETCODE;
//162. Find Peak Element
public class P162 {
    static int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length -1;
        while(start<end){
            int mid  = start +(end - start)/2;
            if(nums[mid]>nums[mid+1]){
                end = mid;
            }else{
                start = mid +1;
            }
        }
        return start;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,1};
        System.out.println(findPeakElement(arr));

    }
}
