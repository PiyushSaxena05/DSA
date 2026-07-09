# Next Permutation - Optimal Approach (Java)

## Problem Statement

Given an integer array `nums`, rearrange the numbers into the **lexicographically next greater permutation**.

If such a permutation is not possible (i.e., the array is already in the largest possible order), rearrange it into the **lowest possible order (ascending order)**.

---

# Intuition

The goal is **not** to generate all permutations.

Instead, we need to create **only the immediate next greater arrangement**.

For example,

```
1 2 3
```

All permutations are:

```
1 2 3
1 3 2   <-- Next
2 1 3
2 3 1
3 1 2
3 2 1
```

The next permutation of `1 2 3` is **1 3 2**, not `2 1 3`.

So we need to make the **smallest possible increase** in the current arrangement.

---

# Key Observation

While traversing from the right side,

we are looking for the **first position where the order starts increasing.**

Example:

```
1 2 7 4 3 1
```

From right:

```
3 > 1
4 > 3
7 > 4
2 < 7   <-- Pivot Found
```

Everything after the pivot is already in **descending order**.

```
7 4 3 1
```

This observation is the foundation of the entire algorithm.

---

# Step 1 : Find the Pivot

```java
int pivot = -1;

for(int i = nums.length - 2; i >= 0; i--){
    if(nums[i] < nums[i + 1]){
        pivot = i;
        break;
    }
}
```

## Why start from `length - 2`?

Because we compare

```
nums[i]
nums[i+1]
```

The last element has no next element.

---

## What is Pivot?

Pivot is the first index from the right where

```
nums[i] < nums[i+1]
```

Example

```
1 2 7 4 3 1
```

```
2 < 7
```

Pivot Index

```
1
```

Pivot Value

```
2
```

---

# Why Search From Right?

The suffix after the pivot is always in descending order.

```
7 4 3 1
```

Searching from the right guarantees that the first element greater than the pivot is also the **smallest possible greater element**.

This ensures we create the **next** permutation instead of jumping to a much larger one.

---

# Step 2 : Handle the Last Permutation

```java
if(pivot == -1){
    reverse(nums,0,nums.length-1);
    return;
}
```

If no pivot exists,

the array is already in descending order.

Example

```
5 4 3 2 1
```

There is no next permutation.

So we simply reverse the whole array.

```
1 2 3 4 5
```

which is the smallest permutation.

---

# Step 3 : Find the Next Greater Element

```java
for(int i = nums.length-1; i > pivot; i--){
    if(nums[i] > nums[pivot]){
        int temp = nums[i];
        nums[i] = nums[pivot];
        nums[pivot] = temp;
        break;
    }
}
```

We search **from right to left**.

We stop at the first element greater than the pivot.

Example

```
1 2 7 4 3 1
```

Pivot

```
2
```

Right Side

```
7 4 3 1
```

Searching from right

```
1 > 2 ❌
3 > 2 ✅
```

Swap

```
1 3 7 4 2 1
```

---

# Why First Greater Element From Right?

Because the suffix is descending.

```
7 4 3 1
```

The first greater element from the right is automatically the **smallest greater element**.

Choosing any larger value would skip the immediate next permutation.

---

# Step 4 : Reverse the Suffix

```java
reverse(nums,pivot+1,nums.length-1);
```

Current Array

```
1 3 7 4 2 1
```

Suffix

```
7 4 2 1
```

Reverse

```
1 2 4 7
```

Final Array

```
1 3 1 2 4 7
```

---

# Why Reverse Instead of Sorting?

The suffix is already in descending order.

```
7 4 2 1
```

Reversing it immediately converts it into ascending order.

```
1 2 4 7
```

Ascending order is the **smallest possible arrangement**.

This gives us the immediate next permutation.

Reverse takes **O(n)** time and **O(1)** extra space.

Sorting would take **O(n log n)** and is unnecessary.

---

# Reverse Function

```java
static void reverse(int[] arr, int s, int e){
    while(s < e){
        int temp = arr[s];
        arr[s] = arr[e];
        arr[e] = temp;
        s++;
        e--;
    }
}
```

This reverses only the required part of the array.

---

# Dry Run

Input

```
1 2 7 4 3 1
```

### Find Pivot

```
Pivot = 2
```

Array

```
1 2 7 4 3 1
```

---

### Find Next Greater

```
3
```

Swap

```
1 3 7 4 2 1
```

---

### Reverse Suffix

Reverse

```
7 4 2 1
```

Result

```
1 2 4 7
```

Final Answer

```
1 3 1 2 4 7
```

---

# Edge Cases

### Case 1

```
Input

1 2 3

Output

1 3 2
```

---

### Case 2

```
Input

3 2 1

Output

1 2 3
```

---

### Case 3

```
Input

1 1 5

Output

1 5 1
```

---

### Case 4

```
Input

1

Output

1
```

---

# Complexity Analysis

### Time Complexity

Finding Pivot

```
O(n)
```

Finding Next Greater Element

```
O(n)
```

Reversing Suffix

```
O(n)
```

Overall

```
O(n)
```

---

### Space Complexity

Only a few variables are used.

```
O(1)
```

---

# Important Interview Tricks

* Never generate all permutations.
* Always search the pivot from the right.
* Store the **pivot index**, not the pivot value.
* Search the swap element from the right.
* The suffix after the pivot is always in descending order.
* Reverse only the suffix after swapping.
* If no pivot exists, reverse the entire array.
* Reversing is faster than sorting because the suffix is already descending.
* This algorithm is completely **in-place**, requiring constant extra space.

---

# Algorithm Summary

1. Traverse from right and find the first index where `nums[i] < nums[i+1]`.
2. If no such index exists, reverse the entire array.
3. Traverse from the right again and find the first element greater than the pivot.
4. Swap the pivot with that element.
5. Reverse the subarray from `pivot + 1` to the end.
6. The array now represents the **lexicographically next permutation**.

---

# Final Complexity

| Operation         | Complexity |
| ----------------- | ---------- |
| Find Pivot        | O(n)       |
| Find Swap Element | O(n)       |
| Reverse Suffix    | O(n)       |
| Overall Time      | **O(n)**   |
| Extra Space       | **O(1)**   |
