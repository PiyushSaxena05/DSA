public class D {

    public static int binarSearch(int[] arr, int target){
        int s=0;
        int e = arr.length-1;
        while(s<=e){
            int mid = s+(e-s)/2;
            if(target>arr[mid]){
                s = mid+1;
            } else if (target<arr[mid]) {
                e = mid -1;
            }else{
                return mid;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {2,5,8,12,16,23,38,56};
        int ans = binarSearch(arr,56);
        System.out.println(ans);

    }
}
