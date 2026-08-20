class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] right = new int[n];

        int pro = 1;

        for (int i = n - 1; i >= 0; i--) {
            pro = pro * nums[i];
            right[i] = pro;
        }

        int[] ans = new int[n];

        int left = 1;

        for (int i = 0; i < n; i++) {
            int val = left * (i + 1 < n ? right[i + 1] : 1);
            ans[i] = val;
            left = left * nums[i];
        }

        return ans;
    }
}



Pseudocode
answer[] = new array of size n

prod = 1
for i = 0 to n-1:
    answer[i] = prod        
    prod = prod * nums[i]   
prod = 1
for i = n-1 to 0:
    answer[i] = answer[i] * prod   
    prod = prod * nums[i]
prod = 1
for i = n-1 to 0:
    answer[i] = answer[i] * prod   
    prod = prod * nums[i]

return answer

    Dry Run — nums = [1,2,3,4]

Pass 1 (prefix):

i	answer[i]	prod after
0	1	           1
1	1	           2
2	2	           6
3	6	           24

    
