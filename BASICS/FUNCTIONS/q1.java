package BASICS.Functions.questions;
//Write a function that takes an integer and
//returns the sum of its digits.
public class q1 {
    static int add(int n){
        int sum =0;
        for(; n>0; n/=10){
            sum+= n%10;



        }
        return sum;
    }

    /*
    static int add(int n) {
        int sum = 0;

        while (n > 0) {
            int digit = n % 10;
            sum += digit;
            n = n / 10;
        }

        return sum;
    }
     */
    public static void main(String[] args) {
        int n = 1234;
        int ans = add(n);
        System.out.println(ans);

    }
}
