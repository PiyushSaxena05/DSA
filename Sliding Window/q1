import java.util.HashSet;

public class A {

    public static int slide(String s) {
        HashSet<Character> hs = new HashSet<>();
        int left = 0;
        int maxlength = 0;
        char[] ch = s.toCharArray();

        for (int right = 0; right < ch.length; right++) {
            while (hs.contains(ch[right])) {
                hs.remove(ch[left]);
                left++;
            }
            hs.add(ch[right]);
            maxlength = Math.max(maxlength,hs.size());
        }
        return maxlength;
    }
    public static void main(String[] args) {
        String s = "abcabbb";
        int ans = slide(s);
        System.out.println(ans);
    }
}
