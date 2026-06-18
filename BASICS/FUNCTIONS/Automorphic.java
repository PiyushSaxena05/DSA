package BASICS.Functions.questions;

public class Automorphic {

    static boolean automorphic(int n){
       int s = n *n;
       int original = n;
       int countdigit = 0;

       while(original>0){
           countdigit++;
           original/=10;
       }
       int x = (int)Math.pow(10,countdigit);
       return s%x==n;

    }
    public static void main(String[] args) {
int n = 625;
boolean ans = automorphic(n);
        System.out.println(ans);

    }
}
