# 169. Majority Element - Boyer-Moore Voting Algorithm

## Problem Statement

Given an integer array `nums`, return the majority element.

The majority element appears more than `⌊n / 2⌋` times.

The majority element is guaranteed to exist.

---

# Intuition

The majority element occurs more than half of the total elements.

Therefore, every non-majority element can cancel one occurrence of the majority element.

After all cancellations, only the majority element remains.

This idea is known as the Boyer-Moore Voting Algorithm.

---

# Approach

Maintain two variables.

```
candidate
count
```

Initially

```
candidate = 0

count = 0
```

Traverse the array once.

---

# Logic

### Case 1

If

```
count == 0
```

Choose the current element as the new candidate.

---

### Case 2

If

```
candidate == current element
```

Increase count.

```
count++
```

---

### Case 3

Otherwise

Decrease count.

```
count--
```

Whenever count becomes zero, all previous votes have been cancelled.

The next element becomes the new candidate.

---

# Dry Run

Input

```
[2,2,1,1,1,2,2]
```

| Current | Candidate | Count |
|---------|----------|------|
|2|2|1|
|2|2|2|
|1|2|1|
|1|2|0|
|1|1|1|
|2|1|0|
|2|2|1|

Final Candidate

```
2
```

---

# Why does this work?

The majority element appears more than all remaining elements combined.

Whenever different elements are encountered, one vote is cancelled.

Since the majority element has more occurrences than every other element together, it can never be completely cancelled.

Therefore, the final candidate is always the majority element.

---

# Memory Trick

Remember only three rules.

```
count == 0

↓

candidate = current element
```

```
candidate == current

↓

count++
```

```
candidate != current

↓

count--
```

---

# Algorithm

```
candidate = 0

count = 0

Traverse array

If count becomes zero

Choose current element as candidate

If candidate equals current element

Increase count

Else

Decrease count

Return candidate
```

---

# Time Complexity

```
O(n)
```

Single traversal.

---

# Space Complexity

```
O(1)
```

Only two variables are used.

---

# Advantages

- Optimal solution.
- One-pass algorithm.
- Constant extra space.
- Frequently asked in coding interviews.

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

### One Pass?

✅ Yes

### Optimal?

✅ Yes

---

# Important Note

This solution works because the problem guarantees that the majority element always exists.

If the majority element is **not guaranteed**, perform another pass after finding the candidate to verify that its frequency is greater than `n / 2`.

---

# Code

```java
class Solution {

    public int majorityElement(int[] nums) {

        int candidate = 0;
        int count = 0;

        for (int num : nums) {

            if (count == 0) {
                candidate = num;
            }

            if (candidate == num) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }
}
```
