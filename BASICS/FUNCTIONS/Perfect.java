package BASICS.Functions.questions;

public class Perfect {

    static boolean perfect(int n){
        int sum = 0;
        int real = n;
        for(int i = 1; i<n; i++){
            if(n%i==0){
                sum+= i;
            }
        }
        if(real==sum){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int n = 28;
        boolean ans = perfect(n);
        System.out.println(ans);

    }
}
