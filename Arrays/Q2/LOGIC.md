# Second Smallest and Second Largest Element in an Array (Java)

## Problem Statement

Given an integer array, find the **second smallest** and **second largest** distinct elements.

If either does not exist, return `-1`.

---

## Approach

This solution uses **two traversals** of the array without sorting.

### Step 1: Find the Smallest and Largest Elements

Initialize:

```java
int s = Integer.MAX_VALUE;
int l = Integer.MIN_VALUE;
```

Traverse the array and update:

```java
s = Math.min(s, arr[i]);
l = Math.max(l, arr[i]);
```

After this traversal:

* `s` contains the smallest element.
* `l` contains the largest element.

---

### Step 2: Find the Second Smallest and Second Largest Elements

Initialize:

```java
int second_s = Integer.MAX_VALUE;
int second_l = Integer.MIN_VALUE;
```

Traverse the array again.

#### Second Smallest

```java
if(arr[i] < second_s && arr[i] != s)
```

* Ignore the smallest element.
* Keep track of the smallest value greater than `s`.

#### Second Largest

```java
if(arr[i] > second_l && arr[i] != l)
```

* Ignore the largest element.
* Keep track of the largest value smaller than `l`.

---

### Edge Cases

#### Array Size Less Than 2

```java
if(arr.length < 2){
    System.out.println(-1 + " " + -1);
    return;
}
```

A second smallest or second largest element cannot exist.

---

#### All Elements Are Equal

Example:

```java
{7, 7, 7, 7}
```

Since no distinct second smallest or second largest element exists:

```java
if(second_s == Integer.MAX_VALUE){
    second_s = -1;
}

if(second_l == Integer.MIN_VALUE){
    second_l = -1;
}
```

---

## Dry Run

### Input

```java
{1, 2, 4, 7, 7, 5}
```

### First Traversal

| Element | Smallest | Largest |
| ------- | -------- | ------- |
| 1       | 1        | 1       |
| 2       | 1        | 2       |
| 4       | 1        | 4       |
| 7       | 1        | 7       |
| 7       | 1        | 7       |
| 5       | 1        | 7       |

Result:

```java
s = 1;
l = 7;
```

### Second Traversal

Second Smallest:

```java
2
```

Second Largest:

```java
5
```

### Output

```text
Second smallest is: 2
Second Largest is: 5
```

---

## Complexity Analysis

### Time Complexity

First traversal:

```text
O(n)
```

Second traversal:

```text
O(n)
```

Total:

```text
O(n) + O(n) = O(2n)
```

Ignoring constants:

```text
O(n)
```

### Space Complexity

```text
O(1)
```

Only a few variables are used regardless of input size.

---

## Why This Approach?

* No sorting is required.
* Better than sorting-based solutions (`O(n log n)`).
* Handles duplicate elements correctly.
* Uses constant extra space.

### Final Complexity

| Complexity | Value |
| ---------- | ----- |
| Time       | O(n)  |
| Space      | O(1)  |
