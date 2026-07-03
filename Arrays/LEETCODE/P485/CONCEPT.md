# Max Consecutive Ones

## 📝 Problem Statement

Given a binary array `nums` consisting of only `0`s and `1`s, return the maximum number of consecutive `1`s in the array.

### Example 1

```text
Input: nums = [1,1,0,1,1,1]
Output: 3
```

**Explanation:**

- The first consecutive sequence of `1`s is `2`.
- The second consecutive sequence of `1`s is `3`.
- Therefore, the maximum consecutive `1`s is `3`.

---

### Example 2

```text
Input: nums = [1,0,1,1,0,1]
Output: 2
```

---

## 💡 Intuition

We only need to count how many `1`s appear continuously.

- Every time we encounter a `1`, we increase our current streak.
- When we encounter a `0`, the current streak ends.
- Before resetting the streak, we compare it with the maximum streak found so far.
- At the end of the loop, we compare one last time because the array may end with `1`s.

---

# 🔍 Observation

A `0` acts like a **separator** between groups of consecutive `1`s.

Example:

```text
1 1 1 |0| 1 1 |0| 1 1 1 1
```

There are three groups:

- Group 1 → 3 ones
- Group 2 → 2 ones
- Group 3 → 4 ones

We simply need to find the largest group.

---

# 🚀 Approach

### Step 1

Create two variables.

```java
count = 0
```

Stores the current consecutive count of `1`s.

```java
newcount = 0
```

Stores the maximum consecutive count found so far.

---

### Step 2

Traverse the array from left to right.

```text
for every element
```

---

### Step 3

If the current element is `1`

Increase the current streak.

```java
count++;
```

Example

```text
1 1 1

count

1
2
3
```

---

### Step 4

If the current element is `0`

The streak ends.

Before resetting, compare it with the maximum.

```java
newcount = Math.max(newcount, count);
count = 0;
```

Example

```text
1 1 1 0

count = 3

newcount = max(0,3)
          = 3

count = 0
```

---

### Step 5

After the loop finishes

The array may end with `1`s.

Example

```text
1 0 1 1 1
```

Notice that no `0` appears after the last three `1`s.

So `newcount` never gets updated inside the loop.

Therefore compare one last time.

```java
return Math.max(newcount, count);
```

---

# 🧠 Dry Run

Input

```text
nums = [1,1,0,1,1,1]
```

| Element | count | newcount |
|---------:|------:|---------:|
|1|1|0|
|1|2|0|
|0|0|2|
|1|1|2|
|1|2|2|
|1|3|2|

Loop ends

```text
return max(2,3)

Answer = 3
```

---

## Another Dry Run

```text
nums = [1,1,1,0,1,0]
```

| Element | count | newcount |
|---------:|------:|---------:|
|1|1|0|
|1|2|0|
|1|3|0|
|0|0|3|
|1|1|3|
|0|0|3|

Return

```text
max(3,0) = 3
```

---

## Edge Cases

### Array starts with 0

```text
[0,1,1]
```

Answer = 2 ✅

---

### Array ends with 1

```text
[0,1,1,1]
```

Final comparison returns `3`.

---

### All zeros

```text
[0,0,0]
```

Answer = 0

---

### All ones

```text
[1,1,1,1]
```

No reset happens.

Final comparison returns `4`.

---

## 🔑 Trick to Remember

Whenever a sequence ends:

1. Save the answer.
2. Reset the counter.

```text
Sequence Ends
      ↓
Save Maximum
      ↓
Reset Counter
```

Or simply remember:

> **"Count while the sequence continues. Update the answer when the sequence breaks."**

---

# ✅ Algorithm

1. Initialize `count = 0`.
2. Initialize `newcount = 0`.
3. Traverse the array.
4. If the element is `1`, increment `count`.
5. Otherwise:
   - Update `newcount`.
   - Reset `count` to `0`.
6. After traversal, compare `newcount` and `count`.
7. Return the larger value.

---

# Correct Java Solution

```java
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int newcount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                newcount = Math.max(newcount, count);
                count = 0;
            }
        }

        return Math.max(newcount, count);
    }
}
```

---

# ⏱️ Time Complexity

```
O(n)
```

We visit each element exactly once.

---

# 📦 Space Complexity

```
O(1)
```

Only two integer variables are used regardless of input size.

---

# 🎯 Key Learning

- Learn how to count a continuous sequence.
- Know when to update the answer.
- Always perform a final comparison if the sequence may continue until the end.
- `Math.max()` helps preserve the largest streak instead of overwriting it.
- This pattern is commonly used in array problems involving **continuous segments**, **streaks**, and **sliding sequences**.
