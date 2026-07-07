# 169. Majority Element - Brute Force Approach

## Problem Statement

Given an integer array `nums` of size `n`, return the majority element.

The majority element is the element that appears **more than ⌊n / 2⌋ times**.

It is guaranteed that the majority element always exists.

---

# Approach

The simplest way is to count the frequency of every element.

For each element in the array:

- Traverse the entire array.
- Count how many times it appears.
- If its frequency becomes greater than `n / 2`, return it immediately.

This method works correctly but performs many unnecessary comparisons.

---

# Logic

1. Pick one element.
2. Count its occurrences in the entire array.
3. If frequency > `n / 2`, return it.
4. Otherwise, repeat the process for the next element.

---

# Algorithm

```
for every element

    count = 0

    traverse complete array

        if current element matches

            increase count

    if count > n/2

        return element
```

---

# Dry Run

Input

```
[2,2,1,1,1,2,2]
```

### First Element = 2

Count frequency

```
2 appears 4 times
```

Since

```
4 > 7/2
```

Return

```
2
```

---

# Why does this work?

Every element's frequency is checked individually.

Since the problem guarantees that one majority element always exists, the algorithm will eventually find it.

---

# Time Complexity

```
O(n²)
```

Outer loop runs `n` times.

Inner loop also runs `n` times.

---

# Space Complexity

```
O(1)
```

Only a counter variable is used.

---

# Advantages

- Very easy to understand.
- No extra memory required.
- Good for beginners.

---

# Disadvantages

- Very slow for large arrays.
- Recalculates frequencies multiple times.
- May cause Time Limit Exceeded (TLE) on large inputs.

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

### Optimal?

❌ No

---

# Code

```java
class Solution {

    public int majorityElement(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

            int count = 0;

            for (int j = 0; j < nums.length; j++) {

                if (nums[i] == nums[j]) {
                    count++;
                }

                if (count > nums.length / 2) {
                    return nums[i];
                }
            }
        }

        return -1;
    }
}
```
