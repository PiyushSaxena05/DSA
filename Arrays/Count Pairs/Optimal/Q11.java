package Arrays;

import java.util.HashMap;

public class Q11 {

    public static int countPairs2(int[] arr , int target){
        HashMap<Integer,Integer>Hs = new HashMap<>();
        int count =0;
        for (int i = 0; i < arr.length ; i++) {
            int currentelement = arr[i];
            int need = target - currentelement;
            if(Hs.containsKey(need)){
                count+=Hs.get(need);
            }
                Hs.put(currentelement,Hs.getOrDefault(currentelement,0)+1);

        }
        return count;

    }
    public static void main(String[] args) {
        int[] arr = {1,5,7,-1,5};
        int ans2 = countPairs2(arr,6);
        System.out.println(ans2);

    }
}
