package BASICS.Functions.questions;
//Create a function to determine whether
// a number is an Armstrong number.
public class ArmstrongNumber {
    static boolean armstrong(int number){
        int sum = 0;
        int n = number;
        while(number>0){
            int num = number%10;
            sum = (int) (Math.pow(num,3)+sum);
            number = number /10;
        }

        if(sum== n){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        int n = 153;
        boolean ans = armstrong(n);
        System.out.println(ans);
    }
}
