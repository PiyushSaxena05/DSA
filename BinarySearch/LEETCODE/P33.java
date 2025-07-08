package DSA.BinarySearch.LEETCODE;
//33. Search in Rotated Sorted Array
public class P33 {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(binarysearch(arr,0));



    }
    static int binarysearch(int [] arr , int target){
        int start = 0;
        int end = arr.length-1;
        
        while(start<=end) {
            int mid = start + (end - start) / 2;

            if (target == arr[mid]) {
                return mid;
            }

            if(arr[start]<=arr[mid]){
                if(target>=arr[start] && target<arr[mid]){
                    end = mid -1;
                }else{
                    start = mid +1;
                }
            }else{
                if(target>=arr[mid]&& target<arr[end]){
                    start = mid +1;
                }else{
                    end = mid-1;
                }
            }

        }

        return -1;

    }
    static int finPivotwithduplicates(int[] arr){
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            int mid = start +(end - start)/2;
           if(mid<end && arr[mid]>arr[mid+1]){
               return mid;
           }
            if(mid>start && arr[mid]<arr[mid-1]){
                return mid-1;
            }
            if(arr[mid]==arr[start] && arr[mid] == arr[end]){
                if(arr[start]> arr[start+1]){
                    return start;
                }
                start++;

                if(arr[end]<arr[end-1]){
                    return end-1;
                }
                end--;
                //left side is sorted, so pivot should be in right
            } else if (arr[start]<arr[mid] ||(arr[start]==arr[mid] &&arr[mid]>arr[end])) {
                start = mid+1;

            }else{
                end = mid-1;
            }

        }
return -1;
    }


    }
    /*

    static int search(int[] arr , int target){
    int pivot = pivot(arr);
    if(pivot == -1){
    return binarsearch(arr,target,0,arr.length-1);
    }
    if(arr[pivot] == target{
    return pivot;
    }
    if(target>= arr[0]){
    return binarySearch(arr,target,0,pivot-1);
    }
    return binarysearch(arr,target,pivot+1,arr.lnegth-1);
    }



    static int pivot(int[] arr)  {
     int start = 0;
        int end = arr.length-1;

        while(start<=end) {
            int mid = start + (end - start) / 2;

            if(mid<end && arr[mid] >arr[mid+1]){
            return mid;
            }
             if(mid>start && arr[mid]<arr[mid-1]){
            return mid-1;
            }
            if(arr[mid]<=arr[start]){
            end = mid-1;
            }else{
            start = mid+1;
            }
            }
            return -1;
            }
            static int binarysearch(int[] arr , int target, int start, int end){


        while(start <= end){
            int mid = start +(end - start)/2;
            if(target>arr[mid]){
                start = mid +1;
            } else if (target<arr[mid]) {
                end = mid -1;

            }
            else{
                return mid;
            }
        }
        return -1;
    }




       */




