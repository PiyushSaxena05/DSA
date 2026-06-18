package BASICS.Functions.questions;

public class fibonacci1 {
    static void fibonacci(int n){

        int a = 0; int b = 1;
        System.out.print(a+" ");

        if(n>=1){
            System.out.print(b+ " ");
        }
        for(int i = 2; i<=n; i++ ){
            int temp = a+b;
            System.out.print(temp+ " ");
            a =b;
            b = temp;




        }



    }

    public static void main(String[] args) {
        int n = 6;
         fibonacci(n);
    }
}
