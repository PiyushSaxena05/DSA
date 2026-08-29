import java.util.Arrays;
import java.util.Stack;

public class H {
    public static void main(String[] args) {
        int[] nums={4,8,5,2,7};
        int[] ans = stackarr(nums);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] stackarr(int[] nums){
        Stack<Integer> stack = new Stack<>();

        int[] ans = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {

            while (!stack.isEmpty() && stack.peek()>=nums[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                ans[i] = stack.peek();
            } else {
                ans[i] = -1;
            }

            stack.push(nums[i]);
        }

        return ans;
    }
}
