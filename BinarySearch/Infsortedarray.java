package DSA.BinarySearch;
//Find position of an element in a sorted array of infinite numbers
public class Infsortedarray {
    public static void main(String[] args) {
        int[] arr ={3,5,7,9,10,100,130,140,160,170};
        System.out.println(ans(arr,10));

    }

    static int ans(int [] arr, int target){
        int start = 0;
        int end = 1;
        while(target>arr[end]){
            int temp = end+1;
            end = end + (end - start + 1) *2;
            start = temp;

        }

        return binarySearch(arr,target,start,end);
    }
    static int binarySearch(int[] arr , int target, int start , int end){
        while(start<=end){
            int mid = start+ (end - start)/2;

            if(target<arr[mid]){
                end = mid -1;
            } else if (target>arr[mid]) {
                start = mid +1;
            }else{
                return mid;
            }
        }

        return -1;

    }
}

