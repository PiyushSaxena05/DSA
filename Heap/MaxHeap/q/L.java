import java.util.Collections;
import java.util.PriorityQueue;

public class L {
        public static int kSmallest(int[] nums, int k) {

            PriorityQueue<Integer> pq =
                    new PriorityQueue<>(Collections.reverseOrder());

            for (int num : nums) {

                pq.offer(num);

                if (pq.size() > k) {
                    pq.poll();
                }
            }

            return pq.peek();
        }

        public static void main(String[] args) {

            int[] nums = {3, 2, 1, 5, 6, 4};

            int ans = kSmallest(nums, 2);

            System.out.println(ans);
        }
    }

