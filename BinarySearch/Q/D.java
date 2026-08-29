public class E {

    public static long binarySearch(int[] nums, int target, long left , long right){
        while(left<=right){
            long mid = left + (right-left)/2;
            long products =0;
            for(int i: nums){
                products += mid/i;
            }

            if(products>=target){
                right = mid -1;
            }else{
                left = mid+1;
            }
        }
        return left;


    }
    public static void main(String[] args) {
        int[] time = {2,3,7};
        long ans = binarySearch(time,10,0,21);
        System.out.println(ans);

    }
}
