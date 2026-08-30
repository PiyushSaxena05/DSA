import java.util.Stack;

public class K {
 

    public static void main(String[] args) {
       int[] nums = {10,20,30};
       Stack<Integer>stack1 = new Stack<>();
       Stack<Integer>stack2= new Stack<>();
      

       for(int i : nums){
          stack1.push(i);
     }
    while(!stack1.isEmpty()){
         stack2.push(stack1.pop());
     }
       System.out.println(stack2.peek());



    }
}
