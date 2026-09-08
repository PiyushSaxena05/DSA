import java.util.HashMap;
import java.util.Arrays;
public class Main
{
	public static void main(String[] args) {
		int[] nums = {2,7,11,15};
		int[] ans = twoSum(nums,9);
		System.out.println(Arrays.toString(ans));
		
	}
	public static int[] twoSum(int[] arr, int target){
	    HashMap<Integer,Integer>Hs = new HashMap<>();
	    for(int i =0; i< arr.length; i++){
	        int need = target- arr[i];
	        if(Hs.containsKey(need)){
	            return new int[]{Hs.get(need),i};
	               
	            }
	            Hs.put(arr[i],i);
	        
	    }
	    return new int[]{-1,-1};
	}
}