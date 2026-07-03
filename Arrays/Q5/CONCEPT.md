# Missing Number in Array (Sorting Approach)

## Problem Statement

Given an **unsorted array** containing numbers from **1 to n**, where **exactly one number is missing**, find the missing number.

### Example 1

**Input:**
```text
[1, 2, 4, 5]
```

**Output:**
```text
3
```

### Example 2

**Input:**
```text
[2, 3, 4, 5]
```

**Output:**
```text
1
```

### Example 3

**Input:**
```text
[1, 2, 3, 4]
```

**Output:**
```text
5
```

---

# Approach

This solution uses the **Sorting** technique.

### Steps

1. Sort the array.
2. Check if the first element is `1`.
   - If not, then `1` is the missing number.
3. Traverse the sorted array.
4. Compare every element with its next element.
5. If a gap is found, return the missing number.
6. If no gap is found, the missing number is after the last element.

---

# Algorithm

1. Sort the array using `Arrays.sort()`.
2. If `arr[0] != 1`, return `1`.
3. Traverse from index `0` to `arr.length - 2`.
4. Check:

```java
arr[i + 1] != arr[i] + 1
```

5. If true, return:

```java
arr[i] + 1
```

6. If the loop completes, return:

```java
arr[arr.length - 1] + 1
```

---

# Dry Run

### Input

```text
[5, 2, 1, 4]
```

### Step 1 : Sort

```text
[1, 2, 4, 5]
```

### Iteration 1

```text
2 == 1 + 1 ✔
```

Continue.

### Iteration 2

```text
4 != 2 + 1 ✔
```

Missing number is:

```text
3
```

Return `3`.

---

# Logic

Suppose the sorted array is:

```text
1 2 4 5
```

Compare adjacent elements.

```
1 → 2 ✔
2 → 4 ✖
```

Since `4` is not equal to `2 + 1`, the missing number is:

```java
2 + 1 = 3
```

---

# Why `arr[i + 1] != arr[i] + 1`?

In a continuous sequence,

```text
1 2 3 4 5
```

Every next element should be exactly **1 greater** than the current element.

Example:

```text
2 → 3
```

```java
3 == 2 + 1
```

If instead we get

```text
2 → 4
```

then

```java
4 != 2 + 1
```

This means `3` is missing.

---

# Why `return arr[arr.length - 1] + 1`?

This statement executes only when **no gap is found** inside the array.

Example:

```text
1 2 3 4
```

Loop checks:

```
2 == 1 + 1 ✔
3 == 2 + 1 ✔
4 == 3 + 1 ✔
```

No missing number exists in between.

Therefore, the missing number must be after the last element.

Last element:

```text
4
```

Missing number:

```text
5
```

Hence,

```java
return arr[arr.length - 1] + 1;
```

---

# Code

```java
import java.util.Arrays;

public class Q7 {

    public static int missingNumber(int[] arr) {

        Arrays.sort(arr);

        if (arr.length == 0) {
            return 1;
        }

        if (arr[0] != 1) {
            return 1;
        }

        for (int i = 0; i < arr.length - 1; i++) {

            if (arr[i + 1] != arr[i] + 1) {
                return arr[i] + 1;
            }

        }

        return arr[arr.length - 1] + 1;
    }

    public static void main(String[] args) {

        int[] arr = {5, 2, 1, 4};

        System.out.println(missingNumber(arr));
    }
}
```

---

# Time Complexity

| Operation | Complexity |
|-----------|------------|
| Sorting | **O(n log n)** |
| Traversing | **O(n)** |
| **Overall** | **O(n log n)** |

---

# Space Complexity

| Type | Complexity |
|------|------------|
| Average | **O(log n)** |
| Worst | **O(n)** |

---

# Edge Cases

### Missing First Number

**Input**

```text
2 3 4 5
```

**Output**

```text
1
```

---

### Missing Middle Number

**Input**

```text
1 2 4 5
```

**Output**

```text
3
```

---

### Missing Last Number

**Input**

```text
1 2 3 4
```

**Output**

```text
5
```

---

### Empty Array

**Input**

```text
[]
```

**Output**

```text
1
```

---

# Key Points

- Sort the array first.
- Compare every element with its next element.
- A gap indicates the missing number.
- If the first element is not `1`, return `1`.
- If no gap is found, return the last element + 1.
- Traverse only until `arr.length - 2` because `arr[i + 1]` is used.

---

# Complexity Summary

| Metric | Value |
|--------|-------|
| **Approach** | Sorting |
| **Time Complexity** | **O(n log n)** |
| **Space Complexity** | **O(log n)** (Average) |
| **Works For** | Arrays containing numbers from **1 to n** with exactly one missing number and no duplicates. |
