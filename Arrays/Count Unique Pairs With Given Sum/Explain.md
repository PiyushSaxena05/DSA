# Q12 — Count Unique Pairs With Given Sum

Given an integer array `arr` and a `target`, count the number of **unique value-pairs** whose sum equals `target`. Each pair is counted only once, even if duplicate elements exist.

## Example

```
arr    = [1, 5, 5, 7, -1, 7]
target = 6

Unique pairs: (1, 5), (7, -1)
Answer: 2
```

## Q11 vs Q12

| | Q11 — All Index Pairs | Q12 — Unique Value Pairs |
|---|---|---|
| Duplicates | Every valid index pair counted | Counted only once |
| Example | `[1,5,5]`, target=6 → **2** | `[1,5,5]`, target=6 → **1** |
| Data structure | HashMap (frequency) | HashSet (existence check) |

## Approach 1 — HashSet + Complement

**Idea:** Keep two sets —
- `unseen`: all unique values not yet processed
- `seen`: values already processed

For each element, compute `need = target - current`. If `need` is in `seen`, it's a valid unique pair. Process each unique value only once (guarded by `unseen`).

```java
import java.util.HashSet;

public class Q12 {

    public static int countsum(int[] arr, int target) {
        HashSet<Integer> seen = new HashSet<>();
        HashSet<Integer> unseen = new HashSet<>();
        int count = 0;

        for (int num : arr) unseen.add(num);

        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];
            int need = target - current;

            if (unseen.contains(current)) {
                if (seen.contains(need)) count++;
                seen.add(current);
                unseen.remove(current);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 5, 7, -1, 7};
        System.out.println(countsum(arr, 6)); // 2
    }
}
```

### Dry Run

```
arr = [1, 5, 5, 7, -1, 7], target = 6

unseen = {1, 5, 7, -1}, seen = {}, count = 0

current=1, need=5  → not in seen        → seen={1}
current=5, need=1  → in seen, count=1   → seen={1,5}
current=5 (dup)    → skip (removed from unseen)
current=7, need=-1 → not in seen        → seen={1,5,7}
current=-1, need=7 → in seen, count=2
current=7 (dup)    → skip

Final answer: 2
```

## Approach 2 — HashMap Frequency

Store frequency of each value, then for each unique key check `need = target - current`, counting only when `current < need` (avoids double-counting the same pair).

```java
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
```

### Why `current < need`?

Without this check, `(1,5)` would be counted twice — once as `current=1, need=5` and again as `current=5, need=1`. The condition `current < need` ensures only the first direction is counted.

## HashSet vs HashMap

| Approach | Stores | Best Use |
|---|---|---|
| HashSet | Unique values | Unique pair problems |
| HashMap | Value + frequency | Counting occurrences / all index pairs |

```
Q11: Count ALL pairs    → HashMap → number → frequency
Q12: Count UNIQUE pairs → HashSet → existence check
```

HashMap *can* solve Q12 too, but HashSet is more natural since we only care about existence, not counts.

## Complexity

Both approaches:
- **Time:** O(n) average
- **Space:** O(n)

## Common Mistakes

1. **Checking only `seen.contains(current)`** instead of `seen.contains(need)` — this checks for duplicates, not sum pairs.
2. **Not guarding against duplicate values** — without the `unseen` set, `[1,5,5]` with target `6` would wrongly give `2` instead of `1`.
3. **Confusing Q11 and Q12** —
   - Q11 → Count ALL index pairs → HashMap frequency
   - Q12 → Count UNIQUE value pairs → HashSet + complement

## Pattern Recognition

Whenever the problem is **"find pairs whose sum = target"**:

```
need = target - current
```

Then ask what's actually being asked:
- **All pairs / index pairs** → HashMap + frequency
- **Unique pairs** → HashSet + existence

## Key Takeaway

```
Same Pair-Sum Pattern
        ↓
What does the question want?
        ↓
   ALL pairs?          UNIQUE pairs?
        ↓                    ↓
HashMap + frequency    HashSet + existence
```

Core formula to remember: `need = target - current`
