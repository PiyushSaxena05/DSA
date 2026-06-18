package BASICS.Functions.questions;

public class Prime {

    static boolean prime(int n){
        if(n ==0  || n==1){
            return false;
        }
        int num =2;
        while(num*num<=n){
            if(n%num==0){
                return false;

            }else{
                num++;
            }
        }
       return true;

    }

    public static void main(String[] args) {
        int n = 25;
        boolean ans = prime(n);
        System.out.println(ans);
    }
}
