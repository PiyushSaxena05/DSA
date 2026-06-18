package BASICS.Functions.questions;

public class Happy {
    static int squareSum(int n){
        int sum = 0;
        while(n>0){
            int rem = n%10;
            sum+=rem * rem;
            n/=10;
        }
        return sum;
    }
    static boolean happy(int n){
        while(n!=1 && n!=4){
            n = squareSum(n);
        }
        if(n==1){
            return true;
        }
        return false;
        /*
        or we can write return n==1;
         */
    }

    public static void main(String[] args) {
        int n = 82 ;
        boolean ans = happy(n);
        System.out.println(ans);
    }
}
