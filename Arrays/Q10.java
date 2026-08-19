package Arrays;

public class Q10 {

    public static boolean isPalindrome(String s){
        int l = 0;
        int r = s.length()-1;

        while(l<r){
            char leftChar = s.charAt(l);
            char rightChar = s.charAt(r);

            if(!Character.isLetterOrDigit(leftChar)){
                l++;
                continue;
            }
            if(!Character.isLetterOrDigit(rightChar)){
                r--;
                continue;
            }
            if(Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)){
                return false;
            }

            l++;
            r--;
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "race a car";
        String s1 = "A man, a plan, a canal: Panama";
        Boolean ans = isPalindrome(s);
        Boolean ans2 = isPalindrome(s1);
        System.out.println(ans);
        System.out.println(ans2);
    }
}
