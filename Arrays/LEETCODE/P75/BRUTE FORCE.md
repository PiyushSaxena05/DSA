# 75. Sort Colors - Brute Force Approach

## Problem Statement

Given an array `nums` containing only `0`, `1`, and `2`, sort the array **in-place** so that:

- `0` (Red) comes first
- `1` (White) comes second
- `2` (Blue) comes last

**Note:** Do not use the library's sorting function.

---

# Approach

This approach uses two nested loops to compare every element with the remaining elements.

Whenever a smaller element is found, both elements are swapped.

Although this is not the optimal solution, it correctly sorts the array without using Java's built-in sorting methods.

---

# Logic

1. Start from the first element.
2. Compare it with every element after it.
3. If a smaller element is found, swap them.
4. Continue this process until the array becomes sorted.

---

# Algorithm

```
for every index i
    for every index j after i

        if nums[i] > nums[j]
            swap(nums[i], nums[j])
```

---

# Dry Run

### Input

```
[2, 0, 2, 1, 1, 0]
```

### Pass 1

Compare `2` with every element.

```
2 > 0
Swap

[0,2,2,1,1,0]
```

Again compare

```
2 > 0

Swap

[0,0,2,1,1,2]
```

---

### Pass 2

Current array

```
[0,0,2,1,1,2]
```

Compare third element

```
2 > 1

Swap

[0,0,1,2,1,2]
```

Again

```
2 > 1

Swap

[0,0,1,1,2,2]
```

Array becomes sorted.

---

# Why does this work?

At every iteration, the current position gets the smallest possible element from the remaining unsorted portion.

Eventually, every position contains the correct element, resulting in a fully sorted array.

---

# Time Complexity

### Best Case

```
O(n²)
```

Even if the array is already sorted, both loops still execute.

---

### Average Case

```
O(n²)
```

---

### Worst Case

```
O(n²)
```

---

# Space Complexity

```
O(1)
```

No extra array is used.

Sorting is performed in-place.

---

# Advantages

- Very easy to understand.
- No extra memory required.
- Does not use Java's built-in sort function.

---

# Disadvantages

- Too slow for large arrays.
- Performs unnecessary comparisons.
- Does not satisfy the optimal one-pass requirement expected in interviews.

---

# Key Observation

Although the array contains only three distinct values (`0`, `1`, and `2`), this algorithm still compares every element with every other element.

It ignores the special property of the input and behaves like a general sorting algorithm.

---

# Interview Notes

### Time Complexity

```
O(n²)
```

### Space Complexity

```
O(1)
```

### In-place?

✅ Yes

### Stable?

❌ No

### One Pass?

❌ No

### Optimal?

❌ No

---

