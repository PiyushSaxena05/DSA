package BASICS.Functions.questions;

public class Fibonacci {

    static int fibonacci(int n){
        if ( n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        int a = 0; int b = 1;
        for(int i = 2; i<=n; i++ ){
            int temp = a+b;
            System.out.println(temp);
            a =b;
            b = temp;




        }
        return b;


    }

    static int fibonaccis(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        int n = 6;
        int ans = fibonacci(n);
        int ans1 = fibonaccis(n);
        System.out.println(ans);
        System.out.println(ans1);
    }
}
