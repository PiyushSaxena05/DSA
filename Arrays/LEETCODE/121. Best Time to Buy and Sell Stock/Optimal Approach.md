# Best Time to Buy and Sell Stock (Optimal Approach)

## Problem Statement

You are given an integer array `prices` where `prices[i]` is the stock price on the `i-th` day.

You can:

* Buy only once
* Sell only once
* Buy before selling

Return the maximum possible profit.

If no profit is possible, return **0**.

---

# Intuition

Instead of checking every future price for every day, we only need two pieces of information while traversing the array:

1. **Minimum buying price seen so far**
2. **Maximum profit earned so far**

Whenever we visit a new day:

* If today's price is smaller than the minimum price, update the minimum.
* Otherwise, assume we sell today and calculate the profit.
* Update the maximum profit if today's profit is better.

This allows us to solve the problem in just **one traversal**.

---

# Algorithm

Initialize

```java
minPrice = Integer.MAX_VALUE
maxProfit = 0
```

Traverse the array.

For every price:

### Case 1

If

```java
price < minPrice
```

Update

```java
minPrice = price
```

because this becomes the best day to buy.

---

### Case 2

Otherwise

Calculate

```java
profit = price - minPrice
```

Update

```java
maxProfit = Math.max(maxProfit, profit);
```

Finally return

```java
maxProfit
```

---

# Code

```java
class Solution {

    public int maxProfit(int[] prices) {

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {

            if (prices[i] < minPrice) {

                minPrice = prices[i];

            } else {

                maxProfit = Math.max(maxProfit, prices[i] - minPrice);

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

Initially

```
minPrice = MAX_VALUE
maxProfit = 0
```

---

Day 1

```
Price = 7

7 < MAX_VALUE

minPrice = 7
```

---

Day 2

```
Price = 1

1 < 7

minPrice = 1
```

---

Day 3

```
Price = 5

Profit = 5 - 1 = 4

maxProfit = 4
```

---

Day 4

```
Price = 3

Profit = 3 - 1 = 2

maxProfit = 4
```

---

Day 5

```
Price = 6

Profit = 6 - 1 = 5

maxProfit = 5
```

---

Day 6

```
Price = 4

Profit = 4 - 1 = 3

maxProfit = 5
```

---

Final Answer

```
5
```

---

# Visualization

```
Prices

7   1   5   3   6   4
    ↑           ↑
  Buy Here   Sell Here

Profit = 6 - 1 = 5
```

---

# Why does this work?

At every step we remember:

* the cheapest buying price available **before today**
* the best profit achieved so far

So whenever we reach a new day, we immediately know the best profit if we sell today.

There is no need to compare today's price with every previous day because `minPrice` already stores the best buying opportunity.

---

# Trick to Remember

Whenever you see

> **Buy once and sell once**

Think:

```
Minimum Price So Far
+
Current Selling Price
=
Current Profit
```

Update only these two variables:

```
minPrice
maxProfit
```

That's all.

---

# Complexity Analysis

### Time Complexity

Only one traversal.

```
O(n)
```

---

### Space Complexity

Only two integer variables are used.

```
O(1)
```

---

# Advantages

* Extremely fast.
* One traversal only.
* No nested loops.
* Accepted for all constraints.
* Interview-friendly solution.

---

# Why `Integer.MAX_VALUE`?

We are searching for the **minimum** value.

So we initialize with the largest possible integer.

```java
int minPrice = Integer.MAX_VALUE;
```

Then the first array element automatically becomes the minimum.

Example

```
MAX_VALUE

↓

2147483647

↓

7

↓

1
```

If we used

```java
Integer.MIN_VALUE
```

the condition

```java
prices[i] < minPrice
```

would never become true because stock prices are never smaller than `-2147483648`.

---

# Key Learning

The biggest optimization comes from realizing that we **do not need to compare every pair of days**.

By maintaining the **minimum buying price so far** and the **maximum profit so far**, we reduce the solution from **O(n²)** to **O(n)** while using only constant extra space.
