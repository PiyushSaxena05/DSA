# Union of Two Sorted Arrays (Two Pointer Approach)

## Intuition

Since both arrays are **already sorted**, we don't need a `HashSet` or `TreeSet`.

We can traverse both arrays simultaneously using **two pointers** and always choose the smaller element.

This is similar to the **Merge step of Merge Sort**.

---

# Algorithm

1. Create an empty list `Union`.
2. Initialize two pointers:

   * `i = 0` (points to `arr1`)
   * `j = 0` (points to `arr2`)
3. Traverse both arrays until one of them ends.
4. Compare `arr1[i]` and `arr2[j]`.

   * If `arr1[i] < arr2[j]`

     * Add `arr1[i]` (only if it is not already the last element in `Union`).
     * Move `i`.
   * If `arr2[j] < arr1[i]`

     * Add `arr2[j]` (only if it is not already the last element in `Union`).
     * Move `j`.
   * If both are equal

     * Add the element only once.
     * Move both pointers.
5. After the main loop, one array may still contain remaining elements.
6. Add the remaining elements while avoiding duplicates.
7. Return the `Union` list.

---

# Why Two Pointers?

Both arrays are sorted.

Instead of checking every element with every other element (**O(n × m)**), we compare only the current elements of both arrays.

At every step, at least one pointer moves forward.

Therefore, every element is visited only once.

---

# Dry Run

### Input

```text
arr1 = [1,2,3,4,5]
arr2 = [2,3,4,4,5]
```

| i | j | Compare      | Action                | Union       |
| - | - | ------------ | --------------------- | ----------- |
| 1 | 2 | 1 < 2        | Add 1, i++            | [1]         |
| 2 | 2 | Equal        | Add 2, i++, j++       | [1,2]       |
| 3 | 3 | Equal        | Add 3, i++, j++       | [1,2,3]     |
| 4 | 4 | Equal        | Add 4, i++, j++       | [1,2,3,4]   |
| 5 | 4 | 4 is smaller | Skip (duplicate), j++ | [1,2,3,4]   |
| 5 | 5 | Equal        | Add 5, i++, j++       | [1,2,3,4,5] |

Output:

```text
[1,2,3,4,5]
```

---

# Why Check the Last Element?

```java
if (Union.isEmpty() || Union.get(Union.size() - 1) != currentElement)
```

Purpose:

* Prevent duplicate elements.
* Add an element only if it is different from the last inserted element.

Example:

```text
Union = [1,2,3,4]

Current = 4
```

Last element:

```text
4
```

Since both are equal,

```text
Do NOT add 4 again.
```

---

# Why Move Only One Pointer?

### Case 1

```text
arr1[i] < arr2[j]
```

Example:

```text
1 < 2
```

The smaller element must appear first in the union.

```text
Add 1
Move i
```

Only `i` moves because `arr2[j]` has not been processed yet.

---

### Case 2

```text
arr2[j] < arr1[i]
```

Example:

```text
4 < 5
```

```text
Add 4
Move j
```

Only `j` moves because `arr1[i]` still needs to be compared.

---

### Case 3

```text
arr1[i] == arr2[j]
```

Example:

```text
3 == 3
```

```text
Add 3 only once.
Move both pointers.
```

Reason:

Both arrays contain the same value, so it should appear only once in the union.

---

# Why Remaining Loops?

Main loop:

```java
while(i < n && j < m)
```

This loop stops as soon as **one array finishes**.

It does **not** guarantee that both arrays have been fully processed.

Example:

```text
arr1 = [1,2,3,4,5,6]
arr2 = [2,3]
```

After the main loop:

```text
Union = [1,2,3]

arr1 still contains:
4 5 6
```

Therefore,

```java
while(i < n)
```

adds the remaining elements from `arr1`.

Similarly,

```java
while(j < m)
```

adds the remaining elements from `arr2`.

---

# Complexity Analysis

### Time Complexity

Main loop:

```text
O(n + m)
```

Remaining loops:

```text
O(n + m)
```

Overall:

```text
O(n + m)
```

Every pointer moves only forward.

No element is processed more than once.

---

### Space Complexity

Auxiliary Space:

```text
O(1)
```

Output Space:

```text
O(n + m)
```

(The returned union list is the required output and is usually not counted as extra space.)

---

# Why Is This Better Than HashSet/TreeSet?

| Approach    | Time              | Extra Space | Sorted Output |
| ----------- | ----------------- | ----------- | ------------- |
| HashSet     | O(n+m)            | O(n+m)      | ❌             |
| TreeSet     | O((n+m) log(n+m)) | O(n+m)      | ✅             |
| Two Pointer | O(n+m)            | O(1)        | ✅             |

---

# Interview Tricks

### Trick 1

```text
Smaller element → Add it → Move its pointer.
```

---

### Trick 2

```text
Equal elements → Add once → Move both pointers.
```

---

### Trick 3

```text
Never add duplicates.

Always compare with the last inserted element.
```

---

### Trick 4

```text
Main loop compares.

Remaining loops finish the leftover elements.
```

---

# Key Observation

This approach works **only because both arrays are sorted**.

If the arrays are not sorted, use:

* HashSet (simple solution)
* Sort first, then apply Two Pointers

---

# Revision in 30 Seconds

```text
1. Take two pointers i and j.

2. Compare current elements.

3. Smaller element -> Add -> Move its pointer.

4. Equal elements -> Add once -> Move both pointers.

5. Skip duplicates using the last element of the answer.

6. Add remaining elements after one array finishes.

7. Time: O(n+m)
   Space: O(1)

8. Think of it as the Merge step of Merge Sort.
```
