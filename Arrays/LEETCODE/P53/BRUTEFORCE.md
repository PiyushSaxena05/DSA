# Maximum Subarray - Brute Force Approach (O(n³))

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

The subarray `[4, -1, 2, 1]` has the largest sum.

```
4 + (-1) + 2 + 1 = 6
```

---

# Brute Force Approach

## Intuition

The simplest way to solve this problem is to check **every possible subarray**.

For every subarray:

1. Calculate its sum.
2. Compare it with the maximum sum found so far.
3. Update the answer if required.

Since we don't know which subarray has the maximum sum, we simply generate all of them.

---

# Algorithm

### Step 1

Choose the starting index of the subarray.

```
i = 0
```

---

### Step 2

Choose every possible ending index.

```
j = i
```

to

```
n-1
```

---

### Step 3

Traverse from `i` to `j` and calculate the sum.

```
sum += nums[x]
```

---

### Step 4

Update the maximum sum.

```
max = Math.max(max, sum)
```

---

# Code

```java
int max = Integer.MIN_VALUE;

for(int i = 0; i < nums.length; i++){

    for(int j = i; j < nums.length; j++){

        int sum = 0;

        for(int x = i; x <= j; x++){
            sum += nums[x];
        }

        max = Math.max(max, sum);
    }
}

return max;
```

---

# Understanding Each Loop

## First Loop (i)

Chooses the **starting index**.

```
i = 0
```

Possible subarrays start from index 0.

```
[5]

[5,4]

[5,4,-1]

[5,4,-1,7]
```

---

## Second Loop (j)

Chooses the **ending index**.

For every starting point, it extends the subarray.

```
j = 0

[5]

------------------

j = 1

[5,4]

------------------

j = 2

[5,4,-1]

------------------

j = 3

[5,4,-1,7]
```

---

## Third Loop (x)

Calculates the sum of the selected subarray.

Example

```
Subarray

[5,4,-1]
```

Calculation

```
sum = 0

↓

sum = 5

↓

sum = 9

↓

sum = 8
```

Now compare

```
max = Math.max(max, sum)
```

---

# Dry Run

Array

```
nums = [5,4,-1]
```

Initially

```
max = -∞
```

---

## i = 0

### j = 0

Subarray

```
[5]
```

Sum

```
5
```

Maximum

```
max = 5
```

---

### j = 1

Subarray

```
[5,4]
```

Sum

```
9
```

Maximum

```
max = 9
```

---

### j = 2

Subarray

```
[5,4,-1]
```

Sum

```
8
```

Maximum

```
max = 9
```

---

## i = 1

Subarrays

```
[4]

[4,-1]
```

Their sums are checked one by one.

---

## i = 2

Subarray

```
[-1]
```

Sum is checked.

Finally

```
Answer = 9
```

---

# Visualization

```
i = 0

|

|---- j = 0

|      [5]

|

|---- j = 1

|      [5,4]

|

|---- j = 2

|      [5,4,-1]

|

|---- j = 3

|      [5,4,-1,7]



i = 1

|

|---- j = 1

|      [4]

|

|---- j = 2

|      [4,-1]

|

|---- j = 3

|      [4,-1,7]



i = 2

|

|---- j = 2

|      [-1]

|

|---- j = 3

|      [-1,7]
```

---

# Why Three Loops?

First loop

```
Choose starting index.
```

Second loop

```
Choose ending index.
```

Third loop

```
Calculate the sum.
```

Without the third loop we cannot calculate the sum of every subarray.

---

# Time Complexity

### Outer Loop

```
O(n)
```

### Middle Loop

```
O(n)
```

### Inner Loop

```
O(n)
```

Total

```
O(n × n × n)

=

O(n³)
```

---

# Space Complexity

```
O(1)
```

Only two integer variables are used.

---

# Advantages

- Very easy to understand.
- Good for beginners.
- Demonstrates how subarrays are generated.
- Helpful for learning nested loops.

---

# Disadvantages

- Very slow.
- Recalculates the same sums multiple times.
- Fails on large inputs.
- Gives **Time Limit Exceeded (TLE)** on LeetCode.

---

# Interview Explanation

If the interviewer asks for the brute force solution, explain:

> "I generate every possible subarray using two loops. Then I use another loop to calculate the sum of that subarray. While calculating, I continuously maintain the maximum sum found so far."

---

# Key Learning

This approach teaches us:

- How to generate all subarrays.
- Difference between starting index and ending index.
- Why repeated calculations make an algorithm slow.

---

# Trick

Think of the loops like this:

```
i

↓

Starting Index

-------------------

j

↓

Ending Index

-------------------

x

↓

Calculate Sum
```

Remember:

```
i selects

j extends

x calculates
```

---

# Complexity Summary

| Approach | Time | Space |
|----------|------|-------|
| Brute Force | O(n³) | O(1) |

---

# Conclusion

This approach checks every possible subarray and guarantees the correct answer.

Although it is easy to understand, it performs many unnecessary calculations, making it inefficient for large inputs.

It serves as the foundation for learning the optimized **O(n²)** and **Kadane's Algorithm (O(n))** approaches.
