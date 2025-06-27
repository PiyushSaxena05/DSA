package DSA.LinearSearch;

public class Main {
    public static void main(String[] args){

        int[] arr = {23,45,1,2,8,19,-3,16,-11,28};
        int ans  = linearSearch(arr,19);
        System.out.println(ans);

    }

    static int linearSearch(int[] arr, int target){

        if(arr.length == 0){
            return -1;
        }

        for (int i = 0; i <arr.length ; i++) {

            if(arr[i] == target){
                return i;
            }

        }
        return -1;
    }
}

/*
for(int element : arr){
if(element == target){
return element;
}

for every element in an array
if element is equal to the target then return
element
 */
