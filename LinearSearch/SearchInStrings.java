package DSA.LinearSearch;


import java.util.Arrays;

public class SearchInStrings {
    public static void main(String[] args){
        String str = "Kunal";
        boolean ans = search(str,'K');
        System.out.println(ans);
        System.out.println(Arrays.toString(str.toCharArray()));

    }
    static boolean search(String str , char target){

        if(str.length() == 0){
            return false;
        }

        char[] arr = str.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == target){
                return true;
            }

        }
        return false;

    }
}



/*
for (char ch: str.toCharArray()){
if(ch == target){
return true;
  }
}

return false;
}

 */