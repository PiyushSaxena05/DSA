import java.util.HashMap;

public class C {

    public static int slide3(String s, int k){
        HashMap<Character,Integer>Hs = new HashMap<>();
        int left =0;
        int maxlength = 0;
        int maxfrequency = 0;

        char[] ch = s.toCharArray();
        for (int right = 0; right <ch.length ; right++) {
            Hs.put(ch[right],Hs.getOrDefault(ch[right],0)+1);
            maxfrequency = Math.max(maxfrequency,Hs.get(ch[right]));
            while((right-left+1)-maxfrequency>k){
                char leftchar = ch[left];
                Hs.put(leftchar,Hs.get(leftchar)-1);
                left++;

            }
            maxlength = Math.max(maxlength,right-left+1);


        }
        return maxlength;

    }
    public static void main(String[] args) {
        String s ="AABAABBA";
        int k =1;
        int ans = slide3(s,k);
        System.out.println(ans);

    }
}
