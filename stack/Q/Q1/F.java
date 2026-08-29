import java.util.Stack;

public class F {
    public static boolean stackq (String s){
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch=='('||ch=='{'||ch=='[' ) {
                stack.push(ch);
            }


            else {

                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();


                if ((ch == ')' && top != '(') ||
                        (ch == '}' && top != '{') ||
                        (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
    public static void main(String[] args) {
        String s ="({[]})";
        boolean ans = stackq(s);
        System.out.println(ans);

    }
}
