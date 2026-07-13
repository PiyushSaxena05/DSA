# Longest Consecutive Sequence (LeetCode 128)

## Problem Statement

Given an unsorted array of integers `nums`, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in **O(n)** time.

### Example 1

```java
Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation:
The longest consecutive sequence is [1,2,3,4].
```

### Example 2

```java
Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
```

---

# Approach 1 : Sorting Approach

## Idea

1. Sort the array.
2. Traverse the sorted array.
3. Ignore duplicate elements.
4. If the current element is exactly one greater than the previous element, increase the current sequence length.
5. Otherwise, update the answer and start a new sequence.

---

## Algorithm

```text
1. If array is empty, return 0.
2. Sort the array.
3. Initialize:
      longest = 1
      count = 1
4. Traverse from index 1.
5. If duplicate -> continue.
6. If consecutive -> count++
7. Else:
      longest = max(longest, count)
      count = 1
8. Return max(longest, count).
```

---

## Code

```java
class Solution {
    public int longestConsecutive(int[] nums) {

        if (nums.length == 0)
            return 0;

        Arrays.sort(nums);

        int longest = 1;
        int count = 1;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == nums[i - 1]) {
                continue;
            }

            if (nums[i] == nums[i - 1] + 1) {
                count++;
            } else {
                longest = Math.max(longest, count);
                count = 1;
            }
        }

        return Math.max(longest, count);
    }
}
```

---

## Dry Run

```java
nums = [100,4,200,1,3,2]
```

After sorting:

```java
[1,2,3,4,100,200]
```

Sequence:

```text
1 -> 2 -> 3 -> 4
Length = 4
```

Answer:

```java
4
```

---

## Complexity Analysis

### Time Complexity

Sorting:

```text
O(n log n)
```

Traversal:

```text
O(n)
```

Overall:

```text
O(n log n)
```

### Space Complexity

```text
O(1)
```

(ignoring sorting internal space)

---

## Important Trick

Duplicates should not break the sequence.

Example:

```java
[1,2,2,3]
```

If duplicates are not skipped, the sequence length will become incorrect.

---

---

# Approach 2 : HashSet Approach (Optimal)

## Idea

Store all numbers inside a `HashSet`.

A number can start a sequence only if its previous number does not exist.

Example:

```text
1 2 3 4

1 can start a sequence.
2 cannot because 1 already exists.
3 cannot because 2 exists.
4 cannot because 3 exists.
```

This prevents processing the same sequence multiple times.

---

## Main Trick 

```java
if (!set.contains(num - 1))
```

Only start counting from the beginning of a sequence.

---

## Algorithm

```text
1. Insert all elements into HashSet.
2. Traverse every element in the set.
3. If num-1 is not present:
       Start a new sequence.
4. Keep checking current+1.
5. Count the sequence length.
6. Update answer.
```

---

## Code

```java
class Solution {
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> hs = new HashSet<>();

        for (int num : nums) {
            hs.add(num);
        }

        int longest = 0;

        for (int num : hs) {

            if (!hs.contains(num - 1)) {

                int current = num;
                int count = 1;

                while (hs.contains(current + 1)) {
                    current++;
                    count++;
                }

                longest = Math.max(longest, count);
            }
        }

        return longest;
    }
}
```

---

## Dry Run

```java
nums = [100,4,200,1,3,2]
```

HashSet:

```text
{100,4,200,1,3,2}
```

### Number = 100

```text
99 does not exist.
Sequence = [100]
Length = 1
```

### Number = 4

```text
3 exists.
Skip.
```

### Number = 1

```text
0 does not exist.
```

Start sequence:

```text
1 -> 2 -> 3 -> 4
```

Length:

```text
4
```

Answer:

```java
4
```

---

## Why This Works

Without checking `num-1`:

```text
1 -> 2 -> 3 -> 4
2 -> 3 -> 4
3 -> 4
4
```

The same elements would be processed repeatedly.

By checking:

```java
!set.contains(num - 1)
```

Only this happens:

```text
1 -> 2 -> 3 -> 4
```

Thus every element is processed almost once.

---

## Complexity Analysis

### Time Complexity

Insertion into HashSet:

```text
O(n)
```

Traversal:

```text
O(n)
```

Overall:

```text
O(n)
```

### Space Complexity

```text
O(n)
```

because extra HashSet is used.

---

# Comparison

| Approach          | Time Complexity | Space Complexity |
| ----------------- | --------------- | ---------------- |
| Sorting           | O(n log n)      | O(1)             |
| HashSet (Optimal) | O(n)            | O(n)             |

---

# Key Learnings

* Sorting makes consecutive elements come together.
* Duplicates must be skipped.
* HashSet provides O(1) average lookup.
* The `num - 1` trick avoids reprocessing sequences.
* HashSet solution is the optimal solution expected in interviews and on LeetCode.
