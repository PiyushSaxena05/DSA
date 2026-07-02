# Valid Anagram (Java)

## Problem Statement

Given two strings `s` and `t`, return `true` if `t` is an anagram of `s`, otherwise return `false`.

An anagram contains the same characters with the same frequency, but the order of characters can be different.

### Example

```text
s = "racecar"
t = "carrace"

Output: true
```

---

# Approach 1: Sorting

## Logic

1. Convert both strings into character arrays.
2. Sort both arrays.
3. Compare the sorted arrays.
4. If they are equal, the strings are anagrams.

## Intuition

Anagrams contain the same characters.

After sorting:

```text
racecar -> aaccerr
carrace -> aaccerr
```

Since both sorted strings become identical, they are anagrams.

## Trick

Order does not matter in an anagram.

Sorting places the same characters in the same positions, making comparison easy.

## Time Complexity

```text
O(n log n)
```

Sorting dominates the complexity.

## Space Complexity

```text
O(n)
```

Character arrays are created for both strings.

---

# Approach 2: Frequency Array (Optimal)

## Logic

1. If lengths are different, return `false`.
2. Create a frequency array of size 26 for lowercase English letters.
3. Traverse both strings simultaneously:

   * Add (+1) for characters from `s`.
   * Subtract (-1) for characters from `t`.
4. If all frequencies become zero, the strings are anagrams.

## Intuition

Think of the frequency array as a balance sheet.

```text
Character from s  -> +1
Character from t  -> -1
```

If both strings contain exactly the same characters with the same frequency, all additions and subtractions cancel out.

Final balance:

```text
0 0 0 0 0 ...
```

which means the strings are anagrams.

---

## Important Concept

### Why do we use?

```java
count[s.charAt(i) - 'a']
```

Characters are converted into array indices.

```text
'a' - 'a' = 0
'b' - 'a' = 1
'c' - 'a' = 2
'd' - 'a' = 3
...
'z' - 'a' = 25
```

This mapping allows each letter to have its own position in the frequency array.

Example:

```text
count['c' - 'a']
count[2]
```

So index 2 stores the frequency of character 'c'.

---

## Frequency Cancellation Concept

Example:

```text
s = "ab"
t = "ba"
```

Processing:

```text
a -> +1
b -> -1

b -> +1
a -> -1
```

Final frequencies:

```text
a = 0
b = 0
```

Everything cancels out.

Therefore:

```text
Anagram = true
```

### Non-Anagram Example

```text
s = "ab"
t = "ac"
```

Final frequencies:

```text
a = 0
b = 1
c = -1
```

Not all values are zero.

Therefore:

```text
Anagram = false
```

---

## Trick

Instead of sorting:

```text
Count characters from first string.
Remove characters from second string.
```

If every count returns to zero, the strings are anagrams.

Think:

```text
+1 = Deposit
-1 = Withdrawal
```

If deposits and withdrawals are equal, the balance becomes zero.

---

## Time Complexity

```text
O(n)
```

Only one traversal of the strings is required.

## Space Complexity

```text
O(1)
```

The frequency array size is fixed at 26 and does not grow with input size.

---

# Learning Outcome

This problem teaches:

* Character frequency counting
* ASCII character mapping
* Array indexing using characters
* Brute Force vs Optimal thinking
* Frequency Array technique

This frequency-counting pattern is commonly used in:

* Anagrams
* Character Frequency Problems
* Hashing Problems
* Sliding Window Questions
* String Matching Problems

---

## Key Takeaway

### Sorting Approach

```text
Easy to understand
Time: O(n log n)
```

### Frequency Array Approach

```text
Optimal Solution
Time: O(n)
Space: O(1)
```

A good interview approach is:

```text
Sorting Solution
        ↓
Frequency Array Optimization
        ↓
Optimal Solution
```
