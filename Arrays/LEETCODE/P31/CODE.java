class Solution {
    static void reverse(int[] arr, int s, int e){
        while(s<e) {
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;
            e--;
        }
        
    }
    public void nextPermutation(int[] nums) {
         int pivot = -1;
        for(int i = nums.length-2; i>=0; i--){
            if(nums[i]<nums[i+1]) {
                pivot = i;
                break;
            }
        }
        if(pivot ==-1){
            reverse(nums,0,nums.length-1);
            return;
        }
        for(int i = nums.length-1; i>pivot; i--){
            if(nums[i]>nums[pivot]){
                int temp = nums[i];
                nums[i] = nums[pivot];
                nums[pivot] = temp;
                break;
            }
        }
        reverse(nums,pivot+1,nums.length-1);
    }
}
