package BASICS.Functions.questions;
//Write a function that checks whether a
// number is a palindrome or not.
public class Palindrome {

    static boolean Palindrome(int n){
        int reverse = 0;
        int num = n;
        while(n>0){
            int rev = n%10;
            reverse = rev + reverse * 10;
            n = n/10;
        }

        if(reverse == num){
            return true;
        }
        else
       return false;
    }

    public static void main(String[] args) {
        int n = 121;

        boolean ans = Palindrome(n);
        System.out.println(ans);
    }
}
