import java.util.HashMap;

public class B {


    public static int slide2(int[] nums,int k){
        HashMap<Integer,Integer>map = new HashMap<>();
        int left =0;
        int maxlength = 0;

        for (int right = 0; right <nums.length ; right++) {
            map.put(nums[right],map.getOrDefault((nums[right]),0)+1);

            while(map.size()>k){
                map.put(nums[left],map.get(nums[left])-1);

                if(map.get(nums[left])==0){
                    map.remove(nums[left]);
                }
                left++;
            }
            maxlength = Math.max(maxlength,right-left+1);

        }
        return maxlength;
    }
    public static void main(String[] args) {
        int[] nums ={1,2,1,3};
        int k =2;
        int ans = slide2(nums,k);
        System.out.println(ans);

    }
}
