# Dungeon Game — LeetCode 174

A detailed comparison of three Dynamic Programming approaches for solving LeetCode 174: Dungeon Game.

## Table of Contents

- [Problem Overview](#problem-overview)
- [Core DP Idea](#core-dp-idea)
- [Approach 1 — Bottom-Up 2D DP](#approach-1--bottom-up-2d-dp)
- [Approach 2 — Space Optimized 1D DP](#approach-2--space-optimized-1d-dp)
- [Approach 3 — Top-Down DP with Memoization](#approach-3--top-down-dp-with-memoization)
- [Comparison of All Three Approaches](#comparison-of-all-three-approaches)
- [Which Approach Should You Use?](#which-approach-should-you-use)
- [The Core Formula](#the-core-formula)
- [Why Do We Work Backwards?](#why-do-we-work-backwards)
- [Key Takeaways](#key-takeaways)

---

## Problem Overview

A knight starts at the top-left corner of a dungeon and needs to reach the bottom-right corner where the princess is located.

Each cell contains an integer:

- **Positive value** → increases health
- **Negative value** → decreases health
- **0** → no change

The knight can only move:

- Right →
- Down ↓

The knight must have at least **1** health point at all times.

### Objective

Find the minimum initial health required for the knight to reach the princess alive.

### Example

Dungeon:

```
-2   -3    3
-5  -10    1
10   30   -5
```

**Answer:** `7`

---

## Core DP Idea

The most important idea in this problem is to work **backwards**.

Instead of asking:

> "How much health do I currently have?"

we ask:

> "If I enter this cell, what is the minimum health I need to eventually reach the princess?"

Define:

```
dp[i][j]
```

as:

> Minimum health required when entering cell (i, j) to safely reach the princess.

For every cell, the knight has at most two choices:

```
Right → dp[i][j + 1]
Down  → dp[i + 1][j]
```

We choose the path requiring less health:

```
next = min(right, down)
```

Then account for the current cell:

```
dp[i][j] = max(1, next - dungeon[i][j])
```

The `max(1, ...)` is necessary because the knight must never have health below 1.

---

## Approach 1 — Bottom-Up 2D DP

### Idea

Create a 2D DP table having the same dimensions as the dungeon.

Start from the bottom-right cell and move towards the top-left.

### State

```
dp[i][j]
```

means:

> Minimum health required to enter (i, j) and still reach the princess alive.

### Transition

```java
next = min(
    dp[i + 1][j],
    dp[i][j + 1]
)
```

Then:

```java
dp[i][j] = max(1, next - dungeon[i][j])
```

### Java Implementation

```java
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {

        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] dp = new int[m][n];

        // Last cell
        dp[m - 1][n - 1] =
                Math.max(1, 1 - dungeon[m - 1][n - 1]);

        // Last row
        for (int j = n - 2; j >= 0; j--) {
            dp[m - 1][j] =
                    Math.max(
                            1,
                            dp[m - 1][j + 1] - dungeon[m - 1][j]
                    );
        }

        // Last column
        for (int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] =
                    Math.max(
                            1,
                            dp[i + 1][n - 1] - dungeon[i][n - 1]
                    );
        }

        // Remaining cells
        for (int i = m - 2; i >= 0; i--) {

            for (int j = n - 2; j >= 0; j--) {

                int next = Math.min(
                        dp[i + 1][j],
                        dp[i][j + 1]
                );

                dp[i][j] =
                        Math.max(
                                1,
                                next - dungeon[i][j]
                        );
            }
        }

        return dp[0][0];
    }
}
```

### DP Table Example

For:

```
-2   -3    3
-5  -10    1
10   30   -5
```

The final DP table becomes:

```
7    5    2
6   11    5
1    1    6
```

Therefore:

```
dp[0][0] = 7
```

### Complexity

Let:

```
m = number of rows
n = number of columns
```

- **Time Complexity:** `O(m × n)` — every cell is processed exactly once.
- **Space Complexity:** `O(m × n)` — the complete DP table is stored.

### Advantages

- Very easy to understand.
- Easy to debug.
- DP table directly represents the solution.
- No recursion overhead.
- Good approach for interviews when explaining DP for the first time.

### Disadvantages

- Uses `O(m × n)` extra memory.

---

## Approach 2 — Space Optimized 1D DP

### Idea

In the previous approach, we used `dp[i][j]`. But notice that when calculating a cell, we only need:

- Down
- Right

We don't actually need the entire DP table. So we can reduce space from `O(m × n)` to `O(n)` using a single array.

### Important Trick

Instead of `dp[i][j]`, we use `dp[j]`.

While processing the current row:

- `dp[j]` represents the **down** value.
- `dp[j + 1]` represents the **right** value.

Therefore:

```java
int next = Math.min(dp[j], dp[j + 1]);
```

### Why Do We Traverse Right → Left?

This is the key part.

Suppose `dp[j]` contains the value from the row below. We need to preserve that value before overwriting it.

At the same time, `dp[j + 1]` has already been calculated for the current row.

Therefore we process **right → left**. This allows the same array to represent both required directions.

### Integer.MAX_VALUE / Sentinel

```java
int[] dp = new int[n + 1];
```

The extra position acts as a boundary.

```java
Arrays.fill(dp, Integer.MAX_VALUE);
```

This is equivalent to:

```java
for (int i = 0; i <= n; i++) {
    dp[i] = Integer.MAX_VALUE;
}
```

`Integer.MAX_VALUE` acts like infinity. It prevents an invalid boundary from being selected by `Math.min()`.

### Java Implementation

```java
import java.util.Arrays;

class Solution {

    public int calculateMinimumHP(int[][] dungeon) {

        int m = dungeon.length;
        int n = dungeon[0].length;

        int[] dp = new int[n + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[n - 1] = 1;

        for (int i = m - 1; i >= 0; i--) {

            dp[n] = Integer.MAX_VALUE;

            for (int j = n - 1; j >= 0; j--) {

                int next = Math.min(
                        dp[j],
                        dp[j + 1]
                );

                dp[j] = Math.max(
                        1,
                        next - dungeon[i][j]
                );
            }
        }

        return dp[0];
    }
}
```

### Example

Original:

```
-2   -3    3
-5  -10    1
10   30   -5
```

Final conceptual DP table is still:

```
7    5    2
6   11    5
1    1    6
```

But instead of storing all three rows, we continuously reuse one array.

### Complexity

- **Time Complexity:** `O(m × n)` — every cell is processed once.
- **Space Complexity:** `O(n)` — only one DP array is maintained.

### Advantages

- Same optimal time complexity as 2D DP.
- Uses significantly less memory.
- Good production/interview optimization.

### Disadvantages

- Harder to understand.
- In-place overwriting makes debugging harder.
- Requires understanding how old and new DP states are represented.

---

## Approach 3 — Top-Down DP with Memoization

### Idea

Instead of iterating manually from bottom-right to top-left, we can define a recursive function:

```
solve(r, c)
```

meaning:

> Minimum health required when entering (r, c) to reach the princess.

From every cell, we recursively explore:

- Right
- Down

But without memoization, the same cells would be calculated repeatedly. Therefore we store the result in `dp[r][c]`. This is called **Memoization**.

### Base Cases

**Outside the dungeon**

```java
if (r >= n || c >= m)
    return Integer.MAX_VALUE;
```

An invalid path should never be selected as the minimum. Therefore we return infinity.

**Princess cell**

```java
if (r == n - 1 && c == m - 1) {
    return Math.max(1, 1 - a[r][c]);
}
```

For the final cell, the knight must leave the cell with at least 1 health.

**Memoization Check**

```java
if (dp[r][c] != -1)
    return dp[r][c];
```

If we have already solved this cell, return the stored answer instead of calculating it again.

### Java Implementation

```java
import java.util.Arrays;

class Solution {

    int n, m;

    private int solve(int r, int c, int[][] a, int[][] dp) {

        if (r >= n || c >= m)
            return Integer.MAX_VALUE;

        if (r == n - 1 && c == m - 1) {
            return Math.max(1, 1 - a[r][c]);
        }

        if (dp[r][c] != -1)
            return dp[r][c];

        int right = solve(r, c + 1, a, dp);

        int down = solve(r + 1, c, a, dp);

        int next = Math.min(right, down);

        int h = Math.max(
                1,
                next - a[r][c]
        );

        dp[r][c] = h;

        return h;
    }

    public int calculateMinimumHP(int[][] dungeon) {

        n = dungeon.length;
        m = dungeon[0].length;

        int[][] dp = new int[n][m];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return solve(0, 0, dungeon, dp);
    }
}
```

### How Memoization Works

Without memoization, the same cell could be reached through multiple paths. For example, `solve(1,1)` might be called multiple times.

Memoization makes sure that after the first calculation — say `dp[1][1] = 11` — any future call simply returns `11` instead of recalculating the entire subtree.

### Complexity

- **Time Complexity:** `O(m × n)` — there are `m × n` unique states, and because of memoization, each state is calculated only once.
- **Space Complexity:** `O(m × n)` for the memoization table. Additionally, recursion uses `O(m + n)` stack space in the worst case. So the total auxiliary space can be described as `O(m × n + m + n)`, which simplifies to `O(m × n)`.

---

## Comparison of All Three Approaches

| Approach | Time | DP Space | Recursion | Difficulty |
|---|---|---|---|---|
| Top-Down Memoization | O(m×n) | O(m×n) | Yes | Medium |
| Bottom-Up 2D | O(m×n) | O(m×n) | No | Easy |
| Bottom-Up 1D | O(m×n) | O(n) | No | Hard |

---

## Which Approach Should You Use?

**For learning DP:** Bottom-Up 2D DP

Best for understanding, because the entire table is visible:

```
7    5    2
6   11    5
1    1    6
```

**For understanding recursion + DP:** Top-Down Memoization

This teaches the important concept:

```
Recursion
    +
Memoization
    =
Top-Down DP
```

**For best space optimization:** 1D Bottom-Up DP

```
Time  = O(m × n)
Space = O(n)
```

This is the most memory-efficient of the three.

---

## The Core Formula

Regardless of the implementation, the actual DP logic remains the same:

```
                current cell
                     ↓
              dungeon[i][j]
                     |
              ┌──────┴──────┐
              ↓             ↓
           RIGHT           DOWN
              ↓             ↓
         dp[i][j+1]    dp[i+1][j]
              \             /
               \           /
                ↓         ↓
                 minimum
                    ↓
                  next
                    ↓
       max(1, next - dungeon[i][j])
```

So the fundamental recurrence is:

```
next = min(right, down)

dp[i][j] = max(1, next - dungeon[i][j])
```

---

## Why Do We Work Backwards?

Forward calculation is difficult because we don't know the starting health.

For example:

```
Starting Health = ?
       ↓
     -2
       ↓
     -3
       ↓
     +3
       ↓
    Princess
```

Instead, work backwards:

```
Princess
   ↑
How much health is needed here?
   ↑
How much health is needed in previous cell?
   ↑
How much health is needed before that?
```

This transforms the problem into a collection of smaller subproblems. That is exactly where Dynamic Programming becomes useful.

---

## Key Takeaways

1. Start from the destination.
2. `dp[i][j]` means: minimum health required when entering cell (i,j).
3. There are at most two choices: Right or Down.
4. Choose the path requiring less health.
5. Adjust for the current cell.
6. Health can never become less than 1.
7. Recurrence:

```
next = min(right, down)

dp[i][j] =
    max(1, next - dungeon[i][j])
```

---

## Final Answer

For the example:

```
-2   -3    3
-5  -10    1
10   30   -5
```

all three approaches produce:

```
7
```

The algorithmic idea is the same; only the way we store and calculate the DP states changes.
