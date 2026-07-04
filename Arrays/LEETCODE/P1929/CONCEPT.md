# Concatenation of Array

## 📝 Problem Statement

Given an integer array `nums` of length `n`, create a new array `ans` of length `2n` where:

- `ans[i] = nums[i]`
- `ans[i + n] = nums[i]`

Return the concatenated array.

### Example

Input:
```text
nums = [1,2,3]
```

Output:
```text
[1,2,3,1,2,3]
```

---

# 💡 Approach

The idea is very simple.

Instead of creating two separate loops, we can fill both halves of the new array in a single iteration.

### Step 1

Create a new array whose size is twice the original array.

```java
int n = 2 * nums.length;
int[] ans = new int[n];
```

If

```text
nums.length = 3
```

then

```text
ans.length = 6
```

---

### Step 2

Traverse the original array only once.

```java
for(int i = 0; i < nums.length; i++)
```

During every iteration we copy the current element into **two different positions**.

---

### Step 3

Copy element into the first half.

```java
ans[i] = nums[i];
```

Example

```
nums = [1,2,3]

i = 0

ans = [1,_,_,_,_,_]
```

---

### Step 4

Copy the same element into the second half.

```java
ans[i + nums.length] = nums[i];
```

For

```
nums.length = 3
```

Indexes become

| i | i + nums.length |
|---|-----------------|
|0|3|
|1|4|
|2|5|

So

```
ans[3] = nums[0]
ans[4] = nums[1]
ans[5] = nums[2]
```

Final array

```
[1,2,3,1,2,3]
```

---

# 🔄 Dry Run

Input

```text
nums = [4,5,6]
```

Initial

```
ans = [_,_,_,_,_,_]
```

### Iteration 1

```
i = 0

ans[0] = 4
ans[3] = 4
```

```
[4,_,_,4,_,_]
```

---

### Iteration 2

```
i = 1

ans[1] = 5
ans[4] = 5
```

```
[4,5,_,4,5,_]
```

---

### Iteration 3

```
i = 2

ans[2] = 6
ans[5] = 6
```

```
[4,5,6,4,5,6]
```

Return

```text
[4,5,6,4,5,6]
```

---

# 🧠 Logic Behind the Solution

The concatenated array is simply:

```
Original Array + Original Array
```

Instead of:

- copying the first array completely
- then running another loop to copy it again

we place both copies simultaneously.

For every element:

```
First Copy  → ans[i]

Second Copy → ans[i + nums.length]
```

This eliminates the need for a second traversal.

---

# 🎯 Trick

The entire solution depends on one formula:

```java
i + nums.length
```

Why?

Suppose

```
nums.length = 5
```

Original indexes

```
0 1 2 3 4
```

Second copy should begin immediately after index 4.

So second copy starts from

```
index = 5
```

which is

```
0 + 5
```

Similarly

```
1 + 5 = 6
2 + 5 = 7
3 + 5 = 8
4 + 5 = 9
```

Hence,

```java
i + nums.length
```

always points to the correct position in the second half.

---

# ✅ Why This Works

Each element is copied exactly twice:

1. Once into its original position.
2. Once into the corresponding position in the second half.

Since every index is filled correctly, the final array becomes

```
nums + nums
```

which satisfies the problem requirement.

---

# ⏱ Time Complexity

We traverse the original array only once.

```
Time Complexity = O(n)
```

where `n` is the size of the input array.

---

# 💾 Space Complexity

A new array of size `2n` is created.

```
Space Complexity = O(n)
```

(The output array itself requires additional memory.)

---

# 📊 Complexity Summary

| Operation | Complexity |
|-----------|------------|
| Traversing array | O(n) |
| Filling answer array | O(n) |
| Overall Time | **O(n)** |
| Extra Space | **O(n)** |

---

# ✅ Java Code

```java
public int[] getConcatenation(int[] nums) {

    int n = 2 * nums.length;
    int[] ans = new int[n];

    for (int i = 0; i < nums.length; i++) {
        ans[i] = nums[i];
        ans[i + nums.length] = nums[i];
    }

    return ans;
}
```

---

# 🚀 Key Takeaways

- Create an output array of size `2 × n`.
- Traverse the input array only once.
- Copy each element into both halves simultaneously.
- Use `i + nums.length` to calculate the correct index for the second copy.
- Single loop makes the solution simple, efficient, and optimal.

```
Formula to Remember

First Copy  → ans[i]

Second Copy → ans[i + nums.length]
```

This single formula is the core trick behind solving the problem efficiently.
