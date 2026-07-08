# Maximum Subarray - Better Approach (O(n²))

## Problem Statement

Given an integer array `nums`, find the **contiguous subarray** (containing at least one number) which has the largest sum and return its sum.

### Example

```java
Input:
nums = [-2,1,-3,4,-1,2,1,-5,4]

Output:
6
```

**Explanation**

The subarray `[4,-1,2,1]` has the maximum sum.

```
4 + (-1) + 2 + 1 = 6
```

---

# Better Approach (Running Sum)

## Intuition

In the Brute Force approach, we calculate the sum of every subarray from scratch.

Example:

```
[5]        = 5

[5,4]      = 5 + 4

[5,4,-1]   = 5 + 4 + (-1)

[5,4,-1,7] = 5 + 4 + (-1) + 7
```

Notice something?

The value `5` is calculated again and again.

Similarly,

```
5 + 4
```

is also calculated multiple times.

This creates unnecessary work.

Instead of recalculating the entire subarray every time, we can **reuse the previous sum**.

Whenever we extend the subarray, we simply add the next element.

```
sum += nums[j]
```

This removes one loop and improves the time complexity.

---

# Algorithm

### Step 1

Choose the starting index.

```
i = 0
```

---

### Step 2

Initialize

```java
sum = 0;
```

---

### Step 3

Extend the subarray using `j`.

```
j = i
```

to

```
n-1
```

---

### Step 4

Instead of recalculating,

simply do

```java
sum += nums[j];
```

---

### Step 5

Update the maximum sum.

```java
max = Math.max(max, sum);
```

---

# Code

```java
int max = Integer.MIN_VALUE;

for(int i = 0; i < nums.length; i++){

    int sum = 0;

    for(int j = i; j < nums.length; j++){

        sum += nums[j];

        max = Math.max(max, sum);
    }
}

return max;
```

---

# Understanding the Loops

## Outer Loop (i)

Chooses the starting index.

```
i = 0
```

Possible subarrays

```
[5]

[5,4]

[5,4,-1]

[5,4,-1,7]
```

---

## Inner Loop (j)

Keeps extending the current subarray.

Instead of recalculating,

we simply add the next element.

```
sum += nums[j]
```

---

# Dry Run

Array

```
nums = [5,4,-1,7]
```

Initially

```
max = -∞
```

---

## i = 0

Initially

```
sum = 0
```

---

### j = 0

```
sum = 0 + 5

sum = 5
```

```
max = 5
```

---

### j = 1

```
sum = 5 + 4

sum = 9
```

```
max = 9
```

---

### j = 2

```
sum = 9 + (-1)

sum = 8
```

```
max = 9
```

---

### j = 3

```
sum = 8 + 7

sum = 15
```

```
max = 15
```

Notice that we never calculate

```
5

5+4

5+4-1
```

again from the beginning.

We simply continue adding the next element.

---

## i = 1

Again,

```
sum = 0
```

Subarrays

```
[4]

[4,-1]

[4,-1,7]
```

Running sums

```
4

3

10
```

---

## i = 2

```
sum = 0
```

Subarrays

```
[-1]

[-1,7]
```

Running sums

```
-1

6
```

---

## i = 3

```
[7]
```

Running sum

```
7
```

---

# Visualization

```
i = 0

sum = 0

↓

j = 0

sum = 5

↓

j = 1

sum = 9

↓

j = 2

sum = 8

↓

j = 3

sum = 15



i = 1

sum = 0

↓

j = 1

sum = 4

↓

j = 2

sum = 3

↓

j = 3

sum = 10
```

Instead of using another loop,

the sum keeps growing.

---

# Why is this Faster?

Brute Force

```
Every subarray

↓

Traverse again

↓

Calculate sum
```

Better Approach

```
Previous Sum

+

Next Element

=

New Sum
```

No need to calculate from scratch.

---

# Trick

Always remember

```
Previous Sum

+

Current Element

=

New Sum
```

One line performs the optimization.

```java
sum += nums[j];
```

This single line removes the third loop.

---

# Time Complexity

Outer Loop

```
O(n)
```

Inner Loop

```
O(n)
```

Total

```
O(n²)
```

---

# Space Complexity

```
O(1)
```

Only two variables are used.

---

# Advantages

- Faster than Brute Force.
- Eliminates unnecessary calculations.
- Easy to understand.
- Good transition towards Kadane's Algorithm.

---

# Disadvantages

- Still checks every possible subarray.
- Still slow for very large arrays.
- LeetCode accepts it only for small constraints.

---

# Interview Explanation

You can explain it like this:

> Instead of calculating every subarray sum from scratch, I maintain a running sum. Whenever I extend the subarray, I simply add the next element to the existing sum. This removes one nested loop and improves the complexity from **O(n³)** to **O(n²)**.

---

# Key Learning

This approach teaches:

- Running Sum
- Eliminating repeated work
- Basic optimization
- Prefix-like thinking

This optimization prepares us for Kadane's Algorithm.

---

# Complexity Summary

| Approach | Time | Space |
|----------|------|-------|
| Better Approach | O(n²) | O(1) |

---

# Conclusion

This approach improves upon the Brute Force solution by reusing the previous subarray sum instead of recalculating it every time.

Although it is significantly faster than the O(n³) solution, it still checks every possible subarray.

The next optimization is **Kadane's Algorithm**, which solves the problem in **O(n)** time.
