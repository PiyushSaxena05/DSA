package DSA.LinearSearch;

public class SearchInStrings2 {
    public static void main(String[] args) {
        String str = "Kunal";
        boolean ans = search(str,'K');
        System.out.println(ans);

    }

    static boolean search(String str , char target){

        if(str.length() == 0){
            return false;
        }


        for (int i = 0; i < str.length(); i++) {
            if(target == str.charAt(i)){
                return true;
            }

        }
        return false;

    }
}
