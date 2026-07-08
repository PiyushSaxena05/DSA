# Maximum Subarray - Kadane's Algorithm (Optimal Solution)

## Problem Statement

Given an integer array `nums`, find the **contiguous subarray** (containing at least one element) that has the largest sum and return its sum.

A **subarray** is a contiguous part of an array.

---

## Example

### Input

```java
nums = [-2,1,-3,4,-1,2,1,-5,4]
```

### Output

```java
6
```

### Explanation

The subarray

```
[4,-1,2,1]
```

has the maximum sum.

```
4 + (-1) + 2 + 1 = 6
```

---

# Optimal Approach - Kadane's Algorithm

## Intuition

The main idea behind Kadane's Algorithm is very simple.

Suppose our current subarray sum becomes negative.

Example

```
Current Sum = -8
```

Now the next element is

```
10
```

There are two choices.

### Choice 1

Continue the previous subarray.

```
-8 + 10 = 2
```

### Choice 2

Start a brand new subarray.

```
10
```

Obviously,

```
10 > 2
```

So carrying a negative sum only decreases our future answer.

Instead of carrying a negative sum, we should discard it and start a new subarray.

This is the entire idea behind Kadane's Algorithm.

---

# Key Observation

A **negative running sum can never help us create a larger subarray sum in the future.**

Whenever

```
sum < 0
```

we simply do

```java
sum = 0;
```

and start fresh.

---

# Algorithm

1. Initialize

```java
sum = 0
```

2. Initialize

```java
max = Integer.MIN_VALUE
```

3. Traverse the array.

4. Add the current element to the running sum.

```java
sum += nums[i];
```

5. Update the maximum sum.

```java
max = Math.max(max, sum);
```

6. If the running sum becomes negative,

reset it.

```java
sum = 0;
```

7. Return the maximum sum.

---

# Code

```java
class Solution {

    public int maxSubArray(int[] nums) {

        int sum = 0;
        int max = Integer.MIN_VALUE;

        for(int num : nums){

            sum += num;

            max = Math.max(max, sum);

            if(sum < 0){
                sum = 0;
            }

        }

        return max;
    }
}
```

---

# Ternary Operator Version

The same solution can also be written using the ternary operator.

```java
int sum = 0;
int max = Integer.MIN_VALUE;

for(int i = 0; i < nums.length; i++){

    sum += nums[i];

    max = max < sum ? sum : max;

    sum = sum < 0 ? 0 : sum;
}

return max;
```

Both solutions have exactly the same logic.

---

# Dry Run

Array

```
[-2,1,-3,4,-1,2,1,-5,4]
```

Initially

```
sum = 0

max = -∞
```

---

### Element = -2

```
sum = -2

max = -2
```

Since

```
sum < 0
```

Reset

```
sum = 0
```

---

### Element = 1

```
sum = 1

max = 1
```

---

### Element = -3

```
sum = -2

max = 1
```

Negative

Reset

```
sum = 0
```

---

### Element = 4

```
sum = 4

max = 4
```

---

### Element = -1

```
sum = 3

max = 4
```

---

### Element = 2

```
sum = 5

max = 5
```

---

### Element = 1

```
sum = 6

max = 6
```

---

### Element = -5

```
sum = 1

max = 6
```

No reset because

```
sum > 0
```

---

### Element = 4

```
sum = 5

max = 6
```

Final Answer

```
6
```

---

# Dry Run Table

| Current Element | Running Sum | Maximum Sum |
|----------------|------------:|------------:|
| -2 | -2 | -2 |
| Reset | 0 | -2 |
| 1 | 1 | 1 |
| -3 | -2 | 1 |
| Reset | 0 | 1 |
| 4 | 4 | 4 |
| -1 | 3 | 4 |
| 2 | 5 | 5 |
| 1 | 6 | 6 |
| -5 | 1 | 6 |
| 4 | 5 | 6 |

---

# Visualization

```
sum = 0

↓

-2

↓

sum = -2

↓

Reset

↓

0

↓

+1

↓

1

↓

-3

↓

-2

↓

Reset

↓

0

↓

+4

↓

4

↓

-1

↓

3

↓

+2

↓

5

↓

+1

↓

6

↓

-5

↓

1

↓

+4

↓

5
```

Maximum

```
6
```

---

# Why Do We Reset the Sum?

Suppose

```
Current Sum = -10
```

Next number

```
15
```

Continuing

```
-10 + 15 = 5
```

Starting fresh

```
15
```

Clearly

```
15 > 5
```

The negative sum only decreases our answer.

Therefore

```java
if(sum < 0){
    sum = 0;
}
```

---

# Why Update max Before Resetting?

Consider

```
[-5]
```

If we reset first,

```
sum = 0
```

then

```
max = 0
```

which is wrong.

Correct answer should be

```
-5
```

Therefore

Always

```
Update max

↓

Then reset
```

Correct order

```java
sum += num;

max = Math.max(max, sum);

if(sum < 0){
    sum = 0;
}
```

---

# Edge Cases

## Case 1

Single element

```
[5]
```

Answer

```
5
```

---

## Case 2

All positive

```
[1,2,3,4]
```

Answer

```
10
```

Entire array is the answer.

---

## Case 3

All negative

```
[-5,-2,-9]
```

Answer

```
-2
```

Largest element is the answer.

---

## Case 4

Mixed numbers

```
[-2,1,-3,4,-1,2,1,-5,4]
```

Answer

```
6
```

---

# Time Complexity

Only one traversal.

```
O(n)
```

---

# Space Complexity

No extra array is used.

```
O(1)
```

---

# Complexity Comparison

| Approach | Time | Space |
|----------|------|-------|
| Brute Force | O(n³) | O(1) |
| Better Approach | O(n²) | O(1) |
| Kadane's Algorithm | **O(n)** | O(1) |

---

# Advantages

- Optimal solution.
- Very fast.
- Uses only one traversal.
- Constant extra space.
- Accepted by all coding platforms.
- Frequently asked in coding interviews.

---

# Disadvantages

- Intuition is slightly difficult for beginners.
- Understanding why negative sums are discarded takes practice.

---

# Interview Explanation

If an interviewer asks you to explain Kadane's Algorithm, you can say:

> "I maintain a running sum while traversing the array. At every step, I update the maximum sum seen so far. If the running sum becomes negative, I reset it to zero because a negative prefix can never increase the sum of any future subarray. This allows me to find the maximum subarray in a single traversal."

---

# Common Mistakes

### ❌ Mistake 1

Initializing

```java
max = 0;
```

Wrong for

```
[-5,-2]
```

Always use

```java
Integer.MIN_VALUE
```

---

### ❌ Mistake 2

Resetting before updating max.

Wrong order.

---

### ❌ Mistake 3

Using nested loops.

Kadane requires only one loop.

---

# Key Takeaways

✅ Running Sum stores the current subarray sum.

✅ Maximum Sum stores the best answer found so far.

✅ Reset the running sum whenever it becomes negative.

✅ Update the maximum before resetting.

✅ Kadane's Algorithm solves the problem in one traversal.

---

# Trick to Remember

```
Add Current Element

↓

Update Maximum

↓

If Sum < 0

↓

Reset Sum
```

Remember this sequence:

```
ADD

↓

UPDATE

↓

RESET
```

---

# Conclusion

Kadane's Algorithm is the most efficient solution for the Maximum Subarray problem.

Instead of checking every possible subarray, it intelligently maintains a running sum and discards any negative prefix because it cannot contribute to a larger future sum.

This reduces the time complexity from **O(n³)** and **O(n²)** to **O(n)** while using only **O(1)** extra space, making it the optimal solution for this problem.
