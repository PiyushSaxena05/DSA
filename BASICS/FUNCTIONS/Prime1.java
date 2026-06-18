package BASICS.Functions.questions;

import java.util.Scanner;

public class Prime1 {


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
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n1: ");
        int n1 = sc.nextInt();
        System.out.print("Enter n2: ");
        int n2 =sc.nextInt();
        for (int i = n1; i <n2; i++) {
            if(prime(i)){
                System.out.println(i);
            }

        }

    }
}



