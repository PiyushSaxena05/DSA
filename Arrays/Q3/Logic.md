# Check if an Array is Sorted

## Problem Statement

Given an integer array, check whether the array is sorted in **ascending (non-decreasing)** order.

Return `true` if the array is sorted; otherwise return `false`.

---

## Examples

### Example 1

**Input:**

```java
[1, 2, 3, 4, 5]
```

**Output:**

```java
true
```

### Example 2

**Input:**

```java
[1, 3, 2, 4, 5]
```

**Output:**

```java
false
```

---

## Approach

Traverse the array and compare every element with its next element.

* If `arr[i] > arr[i + 1]`, the array is not sorted.
* Return `false` immediately.
* If no such pair is found, return `true`.

---

## Java Code

```java
public static boolean isSorted(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
        if (arr[i] > arr[i + 1]) {
            return false;
        }
    }
    return true;
}
```

---

## Dry Run

Array:

```java
[1, 2, 3, 4, 5]
```

Comparisons:

```java
1 <= 2 ✓
2 <= 3 ✓
3 <= 4 ✓
4 <= 5 ✓
```

No violation found, therefore the array is sorted.

**Output:** `true`

---

## Complexity Analysis

* **Time Complexity:** O(n)
* **Space Complexity:** O(1)

---

## Key Takeaway

An array is sorted in ascending order if:

```java
arr[i] <= arr[i + 1]
```

for every valid index `i`.
