# Rearrange Array Elements by Sign (Direct Index Placement)

## Problem Statement

Given an integer array containing equal positive and negative numbers, rearrange the array such that:

- Positive numbers occupy even indices.
- Negative numbers occupy odd indices.
- Relative order remains unchanged.

---

## Approach

Instead of creating two separate lists,

Create only one answer array.

Maintain two pointers:

```
Positive Index = 0

Negative Index = 1
```

Traverse the original array once.

- If the current number is positive, place it at the current positive index.
- Move the positive index by 2.
- If the current number is negative, place it at the current negative index.
- Move the negative index by 2.

---

## Visualization

Initially

```
ans = [_,_,_,_,_,_]

Positive Index = 0

Negative Index = 1
```

Input

```
[3,1,-2,-5,2,-4]
```

---

### Read 3

Positive

```
ans[0] = 3

Positive Index = 2
```

```
[3,_,_,_,_,_]
```

---

### Read 1

Positive

```
ans[2] = 1

Positive Index = 4
```

```
[3,_,1,_,_,_]
```

---

### Read -2

Negative

```
ans[1] = -2

Negative Index = 3
```

```
[3,-2,1,_,_,_]
```

---

### Read -5

Negative

```
ans[3] = -5

Negative Index = 5
```

```
[3,-2,1,-5,_,_]
```

---

### Read 2

Positive

```
ans[4] = 2

Positive Index = 6
```

```
[3,-2,1,-5,2,_]
```

---

### Read -4

Negative

```
ans[5] = -4
```

Final

```
[3,-2,1,-5,2,-4]
```

---

## Dry Run

```
Input

[3,1,-2,-5,2,-4]
```

| Element | Action | Position |
|---------|--------|----------|
|3|Positive|0|
|1|Positive|2|
|-2|Negative|1|
|-5|Negative|3|
|2|Positive|4|
|-4|Negative|5|

Result

```
[3,-2,1,-5,2,-4]
```

---

## Why do we increase by 2?

Positive numbers should occupy

```
0
2
4
6
...
```

Negative numbers should occupy

```
1
3
5
7
...
```

Therefore

```java
posIndex += 2;

negIndex += 2;
```

---

## Time Complexity

Only one traversal of the array.

```
O(n)
```

---

## Space Complexity

Only one extra answer array is used.

```
O(n)
```

---

## Advantages

- Only one traversal.
- No separate positive and negative lists.
- Cleaner and more efficient than the two-list approach.
- Preserves the relative order automatically.

---

## Disadvantages

- Still requires an extra answer array.
- Cannot be done in-place with this logic.

---

## Key Trick

Maintain two pointers.

```
Positive Pointer

0 → 2 → 4 → 6
```

```
Negative Pointer

1 → 3 → 5 → 7
```

Whenever a number is encountered,

```
Positive → Place at posIndex

Negative → Place at negIndex
```

Move the corresponding pointer by **2**.

---

## Code

```java
class Solution {
    public int[] rearrangeArray(int[] nums) {

        int[] ans = new int[nums.length];

        int posIndex = 0;
        int negIndex = 1;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > 0) {
                ans[posIndex] = nums[i];
                posIndex += 2;
            } else {
                ans[negIndex] = nums[i];
                negIndex += 2;
            }
        }

        return ans;
    }
}
```
