import java.util.HashMap;

public class  : map.keySet()) {
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
