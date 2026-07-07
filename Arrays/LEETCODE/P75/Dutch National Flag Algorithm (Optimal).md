# 75. Sort Colors - Dutch National Flag Algorithm

## Problem Statement

Given an array containing only `0`, `1`, and `2`, sort the array **in-place** without using the library's sort function.

Order should be:

```
0 → 1 → 2
```

The expected solution should run in **O(n)** time using **O(1)** extra space.

---

# Intuition

Since there are only three distinct numbers (`0`, `1`, and `2`), we do not need a general sorting algorithm.

Instead of comparing every element with every other element, we directly place:

- every `0` on the left
- every `2` on the right
- every `1` automatically stays in the middle

This idea is called the **Dutch National Flag Algorithm**.

---

# Approach

Use three pointers:

```
low
mid
high
```

Initially

```
low = 0
mid = 0
high = n - 1
```

These pointers divide the array into four regions.

```
0 -------- low-1      -> All 0's

low ------ mid-1      -> All 1's

mid ------ high       -> Unknown

high+1 --- end        -> All 2's
```

Initially, the entire array is unknown.

As we scan from left to right, the unknown region keeps shrinking.

---

# Logic

### Case 1

If

```
nums[mid] == 0
```

Swap with `low`.

```
swap(low, mid)

low++
mid++
```

Reason:

The zero reaches its correct position.

---

### Case 2

If

```
nums[mid] == 1
```

Do nothing.

```
mid++
```

Reason:

One already belongs in the middle.

---

### Case 3

If

```
nums[mid] == 2
```

Swap with `high`.

```
swap(mid, high)

high--
```

Do **NOT** increment `mid`.

Reason:

The new element coming from the right side has not been checked yet.

---

# Dry Run

Input

```
[2,0,2,1,1,0]
```

Initially

```
L
M
          H

2 0 2 1 1 0
```

---

### Step 1

```
nums[mid] = 2
```

Swap with high.

```
0 0 2 1 1 2
```

```
high--
```

---

### Step 2

```
nums[mid]=0
```

Swap with low.

```
0 0 2 1 1 2
```

```
low++
mid++
```

---

### Step 3

Again

```
nums[mid]=0
```

Swap.

```
0 0 2 1 1 2
```

```
low++
mid++
```

---

### Step 4

```
nums[mid]=2
```

Swap with high.

```
0 0 1 1 2 2
```

```
high--
```

---

### Step 5

```
nums[mid]=1
```

```
mid++
```

---

### Step 6

```
nums[mid]=1
```

```
mid++
```

Now

```
mid > high
```

Loop stops.

Final Answer

```
0 0 1 1 2 2
```

---

# Why don't we increment `mid` after swapping with `high`?

Suppose

```
2 1 0
```

Swap

```
0 1 2
```

The new value at `mid` is `0`.

It has never been processed before.

If we increment `mid`, this `0` would be skipped and may remain in the wrong position.

Therefore, after swapping with `high`, only decrement `high` and check the new `mid` value again.

---

# Memory Trick

Remember these three rules:

```
0
↓

Swap(low, mid)

low++
mid++
```

```
1
↓

mid++
```

```
2
↓

Swap(mid, high)

high--

(mid stays)
```

A simple way to remember:

- `0` → Move Left
- `1` → Stay in Middle
- `2` → Move Right

---

# Algorithm

```
low = 0
mid = 0
high = n-1

while(mid <= high)

    if nums[mid] == 0

        swap(low, mid)
        low++
        mid++

    else if nums[mid] == 1

        mid++

    else

        swap(mid, high)
        high--
```

---

# Time Complexity

```
O(n)
```

Each element is processed at most once.

---

# Space Complexity

```
O(1)
```

Only three pointers are used.

---

# Advantages

- Optimal solution.
- One-pass algorithm.
- Constant extra space.
- Very common interview question.
- Better than any comparison-based sorting for this specific problem.

---

# Interview Notes

### Time Complexity

```
O(n)
```

### Space Complexity

```
O(1)
```

### In-place?

✅ Yes

### One Pass?

✅ Yes

### Optimal?

✅ Yes

---

