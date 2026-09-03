package Arrays;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

public class Q6 {
    public static void main(String[] args) {
        int[] arr ={1,2,3,4,5};
        int[] arr2 ={2,3,4,4,5};
        union(arr,arr2,5,5);

    }

    static void union(int[] arr1, int[] arr2,int n, int m ){

        HashSet<Integer>un = new HashSet<>();
        for(int i = 0; i<n; i++){
            un.add(arr1[i]);
        }
        for(int i = 0; i<m; i++){
            un.add(arr2[i]);
        }
        System.out.println(un);



        }

    static void union2(int[] arr1, int[] arr2,int n, int m ){

        TreeSet<Integer>un = new TreeSet<>();
       for(int num: arr1){
           un.add(num);
       }
       for(int num : arr2){
           un.add(num);
       }

        System.out.println(un);



    }

    }


OUTPUT:
[1, 2, 3, 4, 5]




