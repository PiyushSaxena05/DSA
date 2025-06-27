package DSA.LinearSearch;

public class SearchInRange {
    public static void main(String[] args){
        int[] arr = {18,12,-7,3,14,28};

        int ans = search(1,4,arr,14);
        System.out.println(ans);

    }

    static int search(int start, int end, int[] arr , int target){
        if(arr.length == 0){
            return -1;
        }
        for (int i = start; i <= end ; i++) {
            if(arr[i] == target){
                return i;
            }


        }

        return -1;
    }
}
