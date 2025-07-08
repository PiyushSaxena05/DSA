package DSA.BinarySearch.LEETCODE;
//744. Find Smallest Letter Greater Than Target
public class P744 {
    public static void main(String[] args){
        char[] letters = {'c','f','j'};
        System.out.println(nextGreatestLetter(letters,'a'));

    }
    static char nextGreatestLetter(char[] letters, char target) {
        if(target>= letters[letters.length-1]){
            return letters[0];
        }
        int start = 0;
        int end =  letters.length-1;
        while(start<=end){
            int mid = start + (end - start)/2;

            if(target<letters[mid]){
                end = mid -1 ;
            } else {
                start = mid +1 ;

            }


        }
        return letters[start];
        /*
        return letters[start % letters.length];
         */

    }

}
