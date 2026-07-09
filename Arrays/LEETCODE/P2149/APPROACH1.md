# Rearrange Array Elements by Sign (Using Two Lists)

## Problem Statement

Given an integer array `nums` containing an equal number of positive and negative integers, rearrange the array so that:

- Every positive number appears at an even index.
- Every negative number appears at an odd index.
- The relative order of positive numbers remains the same.
- The relative order of negative numbers remains the same.

---

## Approach

This approach uses two extra lists.

1. Traverse the array once.
2. Store all positive numbers in one list.
3. Store all negative numbers in another list.
4. Traverse both lists simultaneously.
5. Place:
   - Positive numbers at even indices (`0, 2, 4...`)
   - Negative numbers at odd indices (`1, 3, 5...`)

---

## Logic

### Step 1 : Separate the Elements

```
nums = [3,1,-2,-5,2,-4]

positive = [3,1,2]
negative = [-2,-5,-4]
```

---

### Step 2 : Merge Them

```
nums[0] = positive[0] = 3
nums[1] = negative[0] = -2

nums[2] = positive[1] = 1
nums[3] = negative[1] = -5

nums[4] = positive[2] = 2
nums[5] = negative[2] = -4
```

Result

```
[3,-2,1,-5,2,-4]
```

---

## Dry Run

Input

```
nums = [3,1,-2,-5,2,-4]
```

### First Loop

```
positive = [3,1,2]

negative = [-2,-5,-4]
```

### Second Loop

```
i = 0

nums[0] = 3
nums[1] = -2

Array
[3,-2,_,_,_,_]
```

```
i = 1

nums[2] = 1
nums[3] = -5

Array
[3,-2,1,-5,_,_]
```

```
i = 2

nums[4] = 2
nums[5] = -4

Array
[3,-2,1,-5,2,-4]
```

---

## Why do we run the second loop only till `n/2`?

Each iteration places **two elements**:

- One positive
- One negative

```
Iteration 1 → 2 elements
Iteration 2 → 2 elements
Iteration 3 → 2 elements
```

If the array size is `n`, then

```
Total iterations = n / 2
```

Example

```
n = 6

Need only 3 iterations.

3 × 2 = 6 elements
```

---

## Time Complexity

### First Loop

Separates positives and negatives.

```
O(n)
```

### Second Loop

Runs `n/2` times.

```
O(n/2)
```

Overall

```
O(n)
```

---

## Space Complexity

Two extra lists are used.

Positive List → n/2 elements

Negative List → n/2 elements

Total Extra Space

```
O(n)
```

---

## Advantages

- Very easy to understand.
- Preserves the relative order.
- Excellent for beginners.

---

## Disadvantages

- Uses two extra ArrayLists.
- Requires additional memory.

---

## Key Trick

Always remember

```
Even Index  → Positive

Odd Index   → Negative
```

So the placement is always

```java
nums[2 * i] = positive.get(i);
nums[2 * i + 1] = negative.get(i);
```

---

## Code

```java
class Solution {
    public int[] rearrangeArray(int[] nums) {

        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                positive.add(nums[i]);
            } else {
                negative.add(nums[i]);
            }
        }

        for (int i = 0; i < nums.length / 2; i++) {
            nums[2 * i] = positive.get(i);
            nums[2 * i + 1] = negative.get(i);
        }

        return nums;
    }
}
```
