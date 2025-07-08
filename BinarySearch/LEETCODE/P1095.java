package DSA.BinarySearch.LEETCODE;
//1095. Find in Mountain Array

interface MountainArray{
    int get(int index);
    int length();
}
class Test implements MountainArray{
    private int[] arr;
    public Test(int[] arr){
        this.arr = arr;
    }
    public int get(int index){
        return arr[index];
    }
    public int length(){
        return arr.length;

    }

}

public class P1095{
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,3,1};
        MountainArray arr1 = new Test(arr) ;
        System.out.println(findInMountainArray(3,arr1));

    }

    static int  findInMountainArray(int target, MountainArray mountainArr){
        int peak = peak(mountainArr);
        int i = orderAgnosticBinarySearch(mountainArr,target,0,peak);

        if(i!=-1){
            return i;
        }
        return orderAgnosticBinarySearch(mountainArr,target,peak+1,mountainArr.length()-1);
    }

    static int peak(MountainArray arr){
        int start = 0;
        int end = arr.length()-1;
        while(start<=end){
            int mid = start + (end - start)/2;
            if(arr.get(mid) <  arr.get(mid+1)){
                start = mid +1;
            }
            else{
                end = mid -1;
            }
        }
        return start;
    }

    static int orderAgnosticBinarySearch(MountainArray mountainArr, int target, int start, int end){

        boolean isAsc = mountainArr.get(start)< mountainArr.get(end);
        while(start<=end){
            int mid = start+(end - start)/2;
            if(target == mountainArr.get(mid)){
                return mid;
            }
            if(isAsc){
                if(target<mountainArr.get(mid)){
                    end = mid -1;
                }else{
                    start = mid +1;
                }
            }else{
               if(target<mountainArr.get(mid)) {
                   start = mid +1;
               }else{
                   end = mid -1;
               }
            }
        }

        return -1;
    }





    }
/*

find peak element
  int start = 0;
        int end = nums.length -1;
        while(start<end){
            int mid  = start +(end - start)/2;
            if(nums[mid]>nums[mid+1]){
                end = mid;
            }else{
                start = mid +1;
            }
        }
        return start;
 */
