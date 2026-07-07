class Solution {
    public int majorityElement(int[] nums) {
      
       
      /*  for(int i = 0; i<nums.length; i++){
            int c= 0;
            for(int j = 0; j<nums.length; j++){
                if(nums[j]==nums[i]){
                    c++;
                }

                if(c>nums.length/2){
                    return nums[i];
                }
            }
        }
        return -1;*/
     /*   HashMap<Integer,Integer>map = new HashMap<>();
        for(int n: nums){
            map.put(n,map.getOrDefault(n,0)+1);
            if(map.get(n)>nums.length/2){
                return n;
            }
        }
        return -1;*/
int c = 0;
int count = 0;

for(int num:nums){
    if(count==0){
        c = num;
    }
    if(c==num){
        count++;
    }else{
        count--;
    }
}
return c;
    }
}
