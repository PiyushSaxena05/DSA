package DSA.BinarySearch;

public class Ceiling {
    public static void main(String[] args){
        int[] arr = {2,3,5,9,14,16,18};
        System.out.println(binarySearch(arr,15));

    }

    static int binarySearch(int[] arr , int target){
        int start = 0;
        int end = arr.length -1;
        /*
        if the target is > the greatest number in an array
         */
        if(target>arr[arr.length-1]){
            return -1;
        }

        while(start<=end){
            int mid = start+ (end-start)/2;

            if(arr[mid]>target){
                end = mid -1;
            } else if (arr[mid]<target) {
                start = mid +1;

            }else{
                return mid;
            }


        }
        return start;
    }
}
/*
Ceiling => the smallest number greater than or equal to the target

 */
