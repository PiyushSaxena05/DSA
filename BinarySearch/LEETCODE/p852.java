package DSA.BinarySearch.LEETCODE;
//852. Peak Index in a Mountain Array
//task is to solve it in O(log(n)) time complexity.
public class p852 {
    public static void main(String[] args) {

        int[] arr = {0,1,0};
        System.out.println(peakIndexInMountainArray(arr));

    }

    static int peakIndexInMountainArray(int[] arr){

        int start = 0;
        int end = arr.length-1;


        while(start<=end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] < arr[mid + 1]) {
                start = mid + 1;

            } else {
                end = mid - 1;
            }
        }

        return start;

    }
}

/*

If the problem did not ask for optimal time complexity
int start = 0;
int end = arr.length - 1;
int max = 0;

while (start <= end) {
    int mid = start + (end - start) / 2;

    // This loop finds the max value in the array
    for (int i = 0; i < arr.length; i++) {
        int num = arr[i];
        max = Math.max(max, num);
    }

    int target = max;

    if (target < arr[mid]) {
        end = mid - 1;
    } else if (target > arr[mid]) {
        start = mid + 1;
    } else {
        return mid;
    }
}
return max;

 */
/*
FIND PEAK
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
 */