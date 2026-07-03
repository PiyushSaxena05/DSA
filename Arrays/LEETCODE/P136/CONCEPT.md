# 136. Single Number

## Problem Statement

Given a **non-empty** array of integers `nums`, every element appears **exactly twice** except for one element. Find and return that single element.

### Examples

#### Example 1

```text
Input:  nums = [2,2,1]
Output: 1
```

#### Example 2

```text
Input:  nums = [4,1,2,1,2]
Output: 4
```

#### Example 3

```text
Input:  nums = [1]
Output: 1
```

---

# Approach 1: Brute Force (Frequency Counting)

## Idea

For every element in the array:

1. Store the current element.
2. Traverse the entire array.
3. Count how many times the current element appears.
4. If its frequency is **1**, return that element.

Since every duplicate appears exactly twice, the element with frequency **1** is the required answer.

---

## Algorithm

1. Traverse every element of the array.
2. For each element:

   * Initialize `count = 0`.
   * Traverse the entire array again.
   * Increase `count` whenever the same element is found.
3. If `count == 1`, return that element.
4. If no such element exists, return `-1`.

---

## Code

```java
public static int singleNumber(int[] nums) {

    if(nums.length == 1){
        return nums[0];
    }

    for(int i = 0; i < nums.length; i++){

        int number = nums[i];
        int count = 0;

        for(int j = 0; j < nums.length; j++){

            if(nums[j] == number){
                count++;
            }

        }

        if(count == 1){
            return number;
        }

    }

    return -1;
}
```

---

## Dry Run

### Input

```text
[4,1,2,1,2]
```

### Iteration 1

Current Number = 4

```text
4 appears 1 time
```

Frequency becomes

```text
count = 1
```

Return

```text
4
```

---

## Dry Run (Worst Case)

Input

```text
[1,1,2,2,5]
```

| Current Number | Frequency |
| -------------- | --------: |
| 1              |         2 |
| 1              |         2 |
| 2              |         2 |
| 2              |         2 |
| 5              |         1 |

Answer

```text
5
```

---

## Complexity Analysis

### Time Complexity

Outer Loop

```text
O(n)
```

Inner Loop

```text
O(n)
```

Overall

```text
O(n²)
```

---

### Space Complexity

Only two extra variables are used.

```text
O(1)
```

---

## Pros

* Very easy to understand.
* No extra data structure required.

## Cons

* Slow for large arrays.
* Nested loops increase execution time.

---

# Approach 2: Optimal Solution (XOR)

## Idea

This problem has a hidden property:

* Every duplicate appears exactly **twice**.
* Only one element appears **once**.

The XOR operator (`^`) has the following properties:

```text
a ^ a = 0
```

```text
a ^ 0 = a
```

```text
XOR is Commutative

a ^ b = b ^ a
```

```text
XOR is Associative

(a ^ b) ^ c = a ^ (b ^ c)
```

Because of these properties, every duplicate number cancels itself.

Only the unique number remains.

---

## Algorithm

1. Initialize `xor = 0`.
2. Traverse the array.
3. XOR every element with `xor`.
4. Return `xor`.

---

## Code

```java
public static int singleNumber(int[] nums){

    int xor = 0;

    for(int num : nums){
        xor ^= num;
    }

    return xor;
}
```

---

## Dry Run

### Input

```text
[4,1,2,1,2]
```

| Iteration | Current Number | XOR Before | Operation | XOR After |
| --------- | -------------: | ---------: | --------- | --------: |
| Start     |              - |          0 | -         |         0 |
| 1         |              4 |          0 | 0 ^ 4     |         4 |
| 2         |              1 |          4 | 4 ^ 1     |         5 |
| 3         |              2 |          5 | 5 ^ 2     |         7 |
| 4         |              1 |          7 | 7 ^ 1     |         6 |
| 5         |              2 |          6 | 6 ^ 2     |         4 |

Final Answer

```text
4
```

---

## Mathematical Explanation

```
0 ^ 4 ^ 1 ^ 2 ^ 1 ^ 2
```

Rearrange using Commutative Property

```
0 ^ 4 ^ (1 ^ 1) ^ (2 ^ 2)
```

Since

```
1 ^ 1 = 0
```

and

```
2 ^ 2 = 0
```

Expression becomes

```
0 ^ 4 ^ 0 ^ 0
```

Finally

```
4
```

---

## Why XOR Works

Every duplicate pair becomes zero.

Example

```
8 ^ 8 = 0
```

```
15 ^ 15 = 0
```

After all duplicate pairs disappear, only the element that appeared once remains.

---

## Complexity Analysis

### Time Complexity

Only one traversal of the array.

```text
O(n)
```

### Space Complexity

Only one variable is used.

```text
O(1)
```

---

# Comparison

| Feature               | Brute Force | XOR   |
| --------------------- | ----------- | ----- |
| Time Complexity       | O(n²)       | O(n)  |
| Space Complexity      | O(1)        | O(1)  |
| Uses Nested Loops     | ✅ Yes       | ❌ No  |
| Interview Preferred   | ❌ No        | ✅ Yes |
| Best for Large Arrays | ❌ No        | ✅ Yes |

---

# Key Takeaways

* Brute Force counts the frequency of every element using nested loops.
* XOR uses the property that identical numbers cancel each other.
* XOR provides the most efficient solution.
* Whenever a problem states **"every element appears twice except one"**, think of **XOR** first.

---

# Final Complexity

### Brute Force

* **Time:** `O(n²)`
* **Space:** `O(1)`

### XOR

* **Time:** `O(n)`
* **Space:** `O(1)`
