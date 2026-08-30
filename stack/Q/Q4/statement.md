### Largest Rectangle in Histogram

You are given an array `heights` where `heights[i]` represents the height of a bar in a histogram, and each bar has a width of `1`.

Return the **largest rectangular area** that can be formed using one or more consecutive bars.

#### Example 1

```text
Input:
heights = [2,1,5,6,2,3]

Output:
10
```

Explanation:

The largest rectangle uses the bars with heights `5` and `6`.

```text
height = 5
width = 2

area = 5 × 2 = 10
```

#### Example 2

```text
Input:
heights = [2,4]

Output:
4
```

You need to solve this using a **Stack** with `O(n)` time complexity.
