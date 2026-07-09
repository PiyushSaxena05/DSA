class Solution {
    public int[] rearrangeArray(int[] nums) {
       /*  List<Integer> positive = new ArrayList<>();
          List<Integer> negative = new ArrayList<>();
          for(int i = 0; i< nums.length; i++){
            if(nums[i]>0){
                positive.add(nums[i]);
            }else{
                negative.add(nums[i]);
            }
          }
          for(int i = 0; i<nums.length/2; i++){
            nums[2*i]= positive.get(i);
            nums[2*i+1]= negative.get(i);
          }

          return nums;*/

          int[] ans = new int[nums.length];
          int posindex = 0;
          int negindex = 1;
          for(int i =  0; i<nums.length; i++){
            if(nums[i]<0){
                ans[negindex] = nums[i];
                negindex+=2;
            }else{
                ans[posindex]=nums[i];
                posindex+=2;
            }
          }
          return ans;

    }
}
