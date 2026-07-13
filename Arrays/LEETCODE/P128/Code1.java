 if(nums.length==0){
            return 0;
        }
                Arrays.sort(nums);

        int length = 1;
        int c = 1;

        for(int i = 1; i<nums.length; i++){
            if(nums[i]==nums[i-1]){
                continue;
            }
            if(nums[i]==nums[i-1]+1){
                c++;
            }else{
                length = Math.max(length,c);
                c= 1;
            }
        }
        return Math.max(length,c);
