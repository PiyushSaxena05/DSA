package BASICS.Functions.questions;

public class Strong
{

    static void strongnumber(int n){
        int newnumber = 0;
        int original = n;
        while(n>0){
            int rem = n%10;
            int fact = 1;
            for(int i = 1; i<=rem; i++){
                fact = fact*i;
            }
            newnumber+=fact;
            n=n/10;
        }
        if(newnumber==original){
            System.out.println("It is a strong number");
        }else{
            System.out.println("It is not a strong number");
        }
    }
    public static void main(String[] args) {
        int n = 143;
        strongnumber(n);

    }
}
