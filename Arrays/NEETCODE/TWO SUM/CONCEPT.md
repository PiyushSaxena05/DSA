# Two Sum - Brute Force Approach (Java)

## Problem

Given an array of integers and a target value, find the indices of two numbers whose sum equals the target.

---

## Intuition (How to Think)

The easiest way to think about this problem is:

* Pick one element.
* Check it with every element that comes after it.
* If their sum becomes equal to the target, return their indices.
* Otherwise, continue checking the remaining pairs.

Think of it as asking:

> "Can the current number form the target sum with any number ahead of it?"

---

## Approach

1. Start from the first element of the array.
2. For each element, traverse all elements after it.
3. Calculate the sum of the current pair.
4. If the sum matches the target, return the indices.
5. If all pairs are checked and no answer is found, return `[-1, -1]`.

---

## Best Way to Understand

Imagine the array:

```text
[4, 5, 6]
Target = 10
```

* Take `4`

  * Check with `5` → 9 ❌
  * Check with `6` → 10 ✅

Answer found immediately.

The key observation is that every possible pair is checked exactly once, so no valid answer can be missed.

---

## Trick

The important trick is:

* Fix one element using the outer loop.
* Search for its partner using the inner loop.
* Start the inner loop from `i + 1` to avoid:

  * Comparing an element with itself.
  * Checking the same pair twice.

For example:

```text
(4,5) ✔
(5,4) ✘  Already checked
```

---

## Time Complexity

**O(n²)**

Reason:

* For every element, we may need to check all remaining elements.

---

## Space Complexity

**O(1)**

Reason:

* No extra data structure is used.
* Only a few variables are required.

---

## Concepts Used

* Arrays
* Nested Loops
* Brute Force
* Pair Searching
* Index Handling

---

## Learning Outcome

This problem teaches:

* How to generate all possible pairs in an array.
* How nested loops work in array problems.
* The foundation for optimizing solutions using HashMap later.

Brute Force first → HashMap optimization later. 🚀
