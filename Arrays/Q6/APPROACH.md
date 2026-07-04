# Longest Subarray with Given Sum K (Brute Force)

## Problem Statement

Given an array of **positive integers** and an integer **K**, find the **longest contiguous subarray** whose sum is equal to **K**.

### Example

**Input**

```text
Array = [1, 2, 3, 4, 5, 6]
K = 15
```

**Output**

```text
Start Index = 0
End Index = 4
```

**Explanation**

```text
Subarray = [1, 2, 3, 4, 5]
Sum = 15
Length = 5
```

---

# Brute Force Approach

The idea is to generate every possible subarray and calculate its sum.

For every starting index `i`, we keep extending the ending index `j` one element at a time while maintaining the current sum.

Whenever the sum becomes equal to `K`, we calculate the current subarray length. If its length is greater than the maximum length found so far, we update the answer.

Finally, return the indices (or length) of the longest subarray.

---

# Algorithm

1. Initialize:

   - `maxLength = 0`
   - `start = -1`
   - `end = -1`

2. Traverse every index `i` as the starting point.

3. Reset `sum = 0`.

4. Traverse every index `j` from `i` to `n-1`.

5. Add the current element to the running sum.

   ```java
   sum += arr[j];
   ```

6. If

   ```text
   sum == K
   ```

   then

   - Calculate current length

     ```text
     length = j - i + 1
     ```

   - If current length is greater than the maximum length found so far,

     - Update maximum length.
     - Store starting and ending indices.

7. Continue checking all possible subarrays.

8. Return the answer.

---

# Dry Run

Array

```text
[1,2,3,4,5]
```

K = 9

### i = 0

```text
1
1+2 = 3
1+2+3 = 6
1+2+3+4 = 10
1+2+3+4+5 = 15
```

No subarray found.

---

### i = 1

```text
2
2+3 = 5
2+3+4 = 9 ✅
```

Length

```text
3
```

Store

```text
Start = 1
End = 3
```

---

### i = 2

```text
3
3+4 = 7
3+4+5 = 12
```

No longer subarray found.

Final Answer

```text
Start = 1
End = 3
Length = 3
```

---

# Logic

The outer loop fixes the starting index of every possible subarray.

The inner loop keeps extending the ending index while maintaining the running sum.

Whenever the running sum becomes equal to `K`, we compare its length with the maximum length found so far.

If the current subarray is longer, we update the answer.

---

# Visualization

```text
Array

1 2 3 4 5

i
↓

1 2 3 4 5
↑
j

↓

1 2 3 4 5
  ↑
  j

↓

1 2 3 4 5
    ↑
    j

↓

1 2 3 4 5
      ↑
      j
```

Then move `i` to the next position and repeat the process.

---

# Why do we reset sum?

For every new starting index, a completely new subarray begins.

Example

```text
Array

1 2 3 4
```

For

```text
i = 0
```

Possible sums

```text
1
3
6
10
```

Now

```text
i = 1
```

We should start with

```text
2
```

not

```text
10 + 2
```

Therefore,

```java
sum = 0;
```

must be initialized inside the outer loop.

---

# Why do we start j from i?

A subarray always starts from its starting index.

Example

```text
Array

[5]
```

This single element itself is a valid subarray.

If we start

```java
j = i + 1;
```

then this subarray will never be checked.

Hence,

```java
j = i;
```

is the correct choice.

---

# Why do we use

```java
sum += arr[j];
```

Instead of

```java
sum += arr[i] + arr[j];
```

A subarray grows by only one new element at every iteration.

Example

```text
1 2 3
```

Correct calculation

```text
sum = 1

sum = 1 + 2

sum = 1 + 2 + 3
```

Using

```java
sum += arr[i] + arr[j];
```

adds the starting element repeatedly, producing an incorrect sum.

---

# Time Complexity

Outer Loop

```text
O(n)
```

Inner Loop

```text
O(n)
```

Overall

```text
O(n²)
```

---

# Space Complexity

```text
O(1)
```

No extra data structure is used.

---

# Key Learning

- Generate every possible subarray.
- Fix the starting index using the outer loop.
- Extend the ending index using the inner loop.
- Maintain a running sum instead of recalculating it.
- Update the answer only when a longer valid subarray is found.
- This brute-force approach works correctly but is not optimal.

---

# Interview Tip

This solution is useful for understanding the problem and works well for small inputs.

However, since all elements are **positive**, this problem can be solved in **O(n)** using the **Sliding Window (Two Pointers)** technique, which is the optimal approach.
