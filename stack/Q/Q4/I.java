import java.util.Stack;

public class I {

    public static int maxAreastack(int[] nums){
        Stack<Integer>stack = new Stack<>();
        int poppedindex = 0;
        int width;
ight<=nums[stack.peek()]){
                poppedindex= stack.pop();
                if(stack.isEmpty()){
                    width =i;
                }else{
                    width = i-stack.peek()-1;
                }
                int height= nums[poppedindex];

                 area = height * width;
                Maxarea = Math.max(Maxarea,area);


            }

            if(i<nums.length){
            stack.push(i);
            }



        }


        return Maxarea;
    }
    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 6, 2, 3};
        int ans = maxAreastack(nums);
        System.out.println(ans);

    }
}
