package BASICS.Functions.questions;
//Create a function that
// returns the reverse of a given number.
public class q2 {

    static int swap(int num) {
        int reverse = 0;

        while (num > 0) {
            int rev = num % 10;
            reverse = rev + reverse * 10;
            num = num / 10;


        }
        return reverse;


    }


    public static void main(String[] args) {
        int n = 12345;
        int ans = swap(n);
        System.out.println(ans);
    }
}



