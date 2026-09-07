package Arrays;

import java.util.HashSet;

public class Q12 {
    public static int countsum(int[] arr ,int target){

        HashSet<Integer>seen = new HashSet<>();
        HashSet<Integer>unseen = new HashSet<>();
        int count =0;

        for(int num: arr){
            unseen.add(num);
        }

        for (int i = 0; i <arr.length ; i++) {
            int current = arr[i];
            int need = target- current ;

            if(unseen.contains(current)) {
                if (seen.contains(need)) {
                    count++;
                }

                seen.add(current);
                unseen.remove(current);
            }


        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1,5,5,7,-1,7};
        int ans = countsum(arr,6);
        System.out.println(ans);
    }
}
