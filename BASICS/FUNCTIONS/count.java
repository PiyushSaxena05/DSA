package BASICS.Functions.questions;

public class count {

    static int count( int n){
        int digits = 0;
        if(n==0){
            return 1;
        }

        for(; n>0; ){
           digits++;
           n=n/10;
        }

        return digits;
    }

    public static void main(String[] args) {
        int n = 123455;
        int ans = count(n);
        System.out.print("count is : "+ ans);
    }
}
