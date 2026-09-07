import java.util.HashMap;

public class Q12HashMap {

    public static int countUniquePairs(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) map.put(num, map.getOrDefault(num, 0) + 1);

        int count = 0;
        for (int current : map.keySet()) {
            int need = target - current;
            if (map.containsKey(need) && current < need) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 5, 7, -1, 7};
        System.out.println(countUniquePairs(arr, 6)); // 2
    }
}
