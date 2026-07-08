# Best Time to Buy and Sell Stock (Brute Force Approach)

## Problem Statement

You are given an integer array `prices` where `prices[i]` represents the price of a stock on the `i-th` day.

You are allowed to:

* Buy the stock **only once**
* Sell the stock **only once**
* You must buy before you sell.

Return the **maximum profit** you can achieve. If no profit is possible, return **0**.

---

# Intuition

The most straightforward approach is to check **every possible buy day** with **every possible sell day**.

For each day:

* Assume that day is the buying day.
* Compare it with every future day.
* Calculate the profit.
* Store the maximum profit found.

This guarantees that every possible transaction is checked.

---

# Algorithm

1. Initialize `maxProfit = 0`.
2. Traverse the array using the first loop (`i`).
3. Consider `prices[i]` as the buying price.
4. Start another loop from `i + 1`.
5. Consider `prices[j]` as the selling price.
6. Calculate:

```java
profit = prices[j] - prices[i];
```

7. Update

```java
maxProfit = Math.max(maxProfit, profit);
```

8. Return `maxProfit`.

---

# Code

```java
class Solution {
    public int maxProfit(int[] prices) {

        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {

            for (int j = i + 1; j < prices.length; j++) {

                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);

            }
        }

        return maxProfit;
    }
}
```

---

# Dry Run

Input

```
prices = [7,1,5,3,6,4]
```

Checking every pair

```
Buy at 7
Sell at 1 = -6
Sell at 5 = -2
Sell at 3 = -4
Sell at 6 = -1
Sell at 4 = -3

Maximum = 0
```

---

```
Buy at 1
Sell at 5 = 4
Sell at 3 = 2
Sell at 6 = 5
Sell at 4 = 3

Maximum = 5
```

---

```
Buy at 5
Sell at 3 = -2
Sell at 6 = 1
Sell at 4 = -1
```

---

```
Buy at 3
Sell at 6 = 3
Sell at 4 = 1
```

---

```
Buy at 6
Sell at 4 = -2
```

Maximum Profit = **5**

---

# Visualization

```
           Buy
            ↓

Prices = [7,1,5,3,6,4]

            ↑
         Compare with every future price

Profit = Sell Price - Buy Price

Keep maximum profit.
```

---

# Why does this work?

The algorithm checks **every possible buying day** with **every possible selling day**.

Since no pair is skipped, the largest profit will definitely be found.

This is called an **Exhaustive Search (Brute Force)** approach.

---

# Complexity Analysis

### Time Complexity

Outer loop = O(n)

Inner loop = O(n)

Overall

```
O(n²)
```

---

### Space Complexity

Only one variable is used.

```
O(1)
```

---

# Advantages

* Very easy to understand.
* Checks every possible transaction.
* Good for learning nested loops.

---

# Disadvantages

* Very slow for large inputs.
* Performs many unnecessary comparisons.
* Results in **Time Limit Exceeded (TLE)** on large test cases.

---

# Key Learning

This solution is useful for understanding the problem, but it is **not optimal**.

Instead of comparing every pair, we can remember the **minimum buying price seen so far** and calculate the profit in a single traversal, reducing the complexity from **O(n²)** to **O(n)**.
