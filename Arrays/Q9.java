package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q9 {
    public static int[] twoSum(int[] nums, int target){
        Map<Integer,Integer>map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target-nums[i];

            if(map.containsKey(complement)){
                return new int[]{map.get(complement),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int[] ans = twoSum(arr,9);
        System.out.println(Arrays.toString(ans));


    }



}


