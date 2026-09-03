import java.util.PriorityQueue;

public class N {

    public static int klargest(int [] nums, int k){
        PriorityQueue<Integer>pq = new PriorityQueue<>();
        int largest = 0;
        for (int i = 0; i < nums.length ; i++) {
            pq.offer(nums[i]);
            if(pq.size()>k){
                pq.poll();
            }

            largest = pq.peek();

        }
        return largest;
    }
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int ans = klargest(nums,2);
        System.out.println(ans);

    }
}
