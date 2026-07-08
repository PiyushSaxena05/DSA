class Solution {
    public int maxSubArray(int[] nums) {
      
       /* int max = Integer.MIN_VALUE;


        for(int i = 0; i<nums.length; i++){
          
            for(int j = i; j<nums.length; j++){
             int sum = 0;
           for(int x = i; x<=j; x++){
            sum+=nums[x];
           }
           max = Math.max(sum,max);
            }
        }
        return max;*/
        /*int max = Integer.MIN_VALUE;


        for(int i = 0; i<nums.length; i++){
           int sum = 0;
            for(int j = i; j<nums.length; j++){
            
          
            sum+=nums[j];
           
           max = Math.max(sum,max);
            }
        }
        return max;*/

        int max = Integer.MIN_VALUE ;
        int sum =0;
        for(int i: nums){
           /* sum += i;
            max = Math.max(sum,max);
            if(sum<0){
                sum =0;
            }*/
             sum+=i;
            max=max<sum?sum:max;
            sum=sum<0?0:sum;

        }
        return max;

       
            
        
    }
}
