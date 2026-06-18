package BASICS.Functions.questions;

public class Gcd {
    static int gcd(int n1, int n2){
        while(n2!=0){
            int temp = n1%n2;
            n1= n2;
            n2 = temp;
        }
        return n1;
    }
    static int lcm(int n1,int n2){
        int lcm = (n1*n2)/gcd(n1,n2);
        return lcm;
    }
    public static void main(String[] args) {

        int num1 = 24;
        int num2 = 36;

        int ans = gcd(num1,num2);
        int ans2 = lcm(num1,num2);
        System.out.println(ans);
        System.out.println(ans2);
    }
}
