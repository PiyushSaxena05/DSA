# Dungeon Game — LeetCode 174

Teen alag Dynamic Programming approaches ka detailed comparison, jo LeetCode 174 (Dungeon Game) solve karte hain.

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

Ek knight dungeon ke top-left corner se start karta hai aur usse bottom-right corner tak pahunchna hai, jahan princess hai.

Har cell mein ek integer hota hai:

- **Positive value** → health badhati hai
- **Negative value** → health ghataati hai
- **0** → koi change nahi

Knight sirf do directions mein move kar sakta hai:

- Right →
- Down ↓

Knight ki health har waqt kam se kam **1** honi chahiye.

### Objective

Minimum initial health pata karo jisse knight princess tak zinda pahunch sake.

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

Is problem ki sabse important idea hai **backwards** kaam karna.

Yeh poochne ke bajaye:

> "Abhi mere paas kitni health hai?"

Hum poochte hain:

> "Agar main is cell mein enter karu, toh princess tak safely pahunchne ke liye minimum health kitni chahiye?"

Define karo:

```
dp[i][j]
```

as:

> Minimum health jo cell (i, j) mein enter karne ke liye chahiye taaki safely princess tak pahuncha ja sake.

Har cell ke liye knight ke paas max do choices hoti hain:

```
Right → dp[i][j + 1]
Down  → dp[i + 1][j]
```

Hum wo path choose karte hain jisme kam health chahiye:

```
next = min(right, down)
```

Fir current cell ke liye adjust karte hain:

```
dp[i][j] = max(1, next - dungeon[i][j])
```

`max(1, ...)` isliye zaroori hai kyunki knight ki health kabhi 1 se neeche nahi ja sakti.

---

## Approach 1 — Bottom-Up 2D DP

### Idea

Dungeon ke jaise hi dimensions ka ek 2D DP table banao.

Bottom-right cell se start karke top-left ki taraf move karo.

### State

```
dp[i][j]
```

means:

> Minimum health jo (i, j) mein enter karke princess tak zinda pahunchne ke liye chahiye.

### Transition

```java
next = min(
    dp[i + 1][j],
    dp[i][j + 1]
)
```

Fir:

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

Is dungeon ke liye:

```
-2   -3    3
-5  -10    1
10   30   -5
```

Final DP table yeh banta hai:

```
7    5    2
6   11    5
1    1    6
```

Isliye:

```
dp[0][0] = 7
```

### Complexity

Maan lo:

```
m = rows ki sankhya
n = columns ki sankhya
```

- **Time Complexity:** `O(m × n)` — har cell exactly ek baar process hoti hai.
- **Space Complexity:** `O(m × n)` — pura DP table store hota hai.

### Advantages

- Samajhna bahut aasan hai.
- Debug karna aasan hai.
- DP table directly solution represent karta hai.
- Recursion ka koi overhead nahi.
- Interviews mein DP explain karne ke liye acha starting approach.

### Disadvantages

- `O(m × n)` extra memory use hoti hai.

---

## Approach 2 — Space Optimized 1D DP

### Idea

Pichle approach mein humne `dp[i][j]` use kiya. Lekin notice karo ki kisi cell ko calculate karte waqt sirf yeh chahiye:

- Down
- Right

Poora DP table store karne ki zaroorat nahi. Isliye hum space ko `O(m × n)` se `O(n)` tak reduce kar sakte hain, sirf ek single array use karke.

### Important Trick

`dp[i][j]` ke bajaye hum `dp[j]` use karte hain.

Current row process karte waqt:

- `dp[j]` → **down** value represent karta hai
- `dp[j + 1]` → **right** value represent karta hai

Isliye:

```java
int next = Math.min(dp[j], dp[j + 1]);
```

### Hum Right → Left kyu traverse karte hain?

Yeh sabse important part hai.

Maan lo `dp[j]` mein neeche wali row ki value hai. Usse overwrite karne se pehle preserve karna zaroori hai.

Saath hi `dp[j + 1]` already current row ke liye calculate ho chuka hota hai.

Isliye hum **right → left** process karte hain — isse ek hi array dono required directions represent kar leta hai.

### Integer.MAX_VALUE / Sentinel

```java
int[] dp = new int[n + 1];
```

Extra position ek boundary ka kaam karta hai.

```java
Arrays.fill(dp, Integer.MAX_VALUE);
```

Yeh iske equivalent hai:

```java
for (int i = 0; i <= n; i++) {
    dp[i] = Integer.MAX_VALUE;
}
```

`Integer.MAX_VALUE` infinity jaisa kaam karta hai — yeh invalid boundary ko `Math.min()` mein select hone se rokta hai.

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

Conceptual final DP table wahi rehta hai:

```
7    5    2
6   11    5
1    1    6
```

Lekin teeno rows store karne ke bajaye, hum continuously ek hi array reuse karte hain.

### Complexity

- **Time Complexity:** `O(m × n)` — har cell ek baar process hoti hai.
- **Space Complexity:** `O(n)` — sirf ek DP array maintain hota hai.

### Advantages

- 2D DP jaisi hi optimal time complexity.
- Kaafi kam memory use hoti hai.
- Production/interview ke liye acha optimization.

### Disadvantages

- Samajhna mushkil hai.
- In-place overwriting se debugging mushkil hoti hai.
- Old aur new DP states kaise represent hote hain, yeh samajhna zaroori hai.

---

## Approach 3 — Top-Down DP with Memoization

### Idea

Bottom-right se top-left tak manually iterate karne ke bajaye, hum ek recursive function define kar sakte hain:

```
solve(r, c)
```

meaning:

> Minimum health jo (r, c) mein enter karke princess tak pahunchne ke liye chahiye.

Har cell se hum recursively explore karte hain:

- Right
- Down

Lekin memoization ke bina, same cells baar baar calculate hongi. Isliye result ko `dp[r][c]` mein store karte hain. Ise **Memoization** kehte hain.

### Base Cases

**Outside the dungeon**

```java
if (r >= n || c >= m)
    return Integer.MAX_VALUE;
```

Ek invalid path kabhi bhi minimum ke roop mein select nahi honi chahiye, isliye infinity return karte hain.

**Princess cell**

```java
if (r == n - 1 && c == m - 1) {
    return Math.max(1, 1 - a[r][c]);
}
```

Final cell ke liye knight ko kam se kam 1 health ke saath cell chodni chahiye.

**Memoization Check**

```java
if (dp[r][c] != -1)
    return dp[r][c];
```

Agar yeh cell pehle se solve ho chuki hai, toh dobara calculate karne ke bajaye stored answer return karo.

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

### Memoization Kaise Kaam Karta Hai

Bina memoization ke, same cell multiple paths se reach ho sakti hai — jaise `solve(1,1)` multiple baar call ho sakta hai.

Memoization yeh ensure karta hai ki pehli calculation ke baad — jaise `dp[1][1] = 11` — koi bhi future call poore subtree ko recalculate karne ke bajaye seedha `11` return kare.

### Complexity

- **Time Complexity:** `O(m × n)` — kyunki `m × n` unique states hain, aur memoization ki wajah se har state sirf ek baar calculate hoti hai.
- **Space Complexity:** `O(m × n)` memoization table ke liye. Iske alawa recursion worst case mein `O(m + n)` stack space use karta hai. Toh total auxiliary space `O(m × n + m + n)` hota hai, jo simplify hoke `O(m × n)` ban jaata hai.

---

## Comparison of All Three Approaches

| Approach | Time | DP Space | Recursion | Difficulty |
|---|---|---|---|---|
| Top-Down Memoization | O(m×n) | O(m×n) | Yes | Medium |
| Bottom-Up 2D | O(m×n) | O(m×n) | No | Easy |
| Bottom-Up 1D | O(m×n) | O(n) | No | Hard |

---

## Which Approach Should You Use?

**Learning ke liye:** Bottom-Up 2D DP

Sabse acha samajhne ke liye, kyunki poora table visible hota hai:

```
7    5    2
6   11    5
1    1    6
```

**Recursion + DP samajhne ke liye:** Top-Down Memoization

Yeh important concept sikhata hai:

```
Recursion
    +
Memoization
    =
Top-Down DP
```

**Best space optimization ke liye:** 1D Bottom-Up DP

```
Time  = O(m × n)
Space = O(n)
```

Yeh teeno mein sabse memory-efficient hai.

---

## The Core Formula

Implementation chahe koi bhi ho, actual DP logic hamesha same rehta hai:

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

Fundamental recurrence:

```
next = min(right, down)

dp[i][j] = max(1, next - dungeon[i][j])
```

---

## Why Do We Work Backwards?

Forward calculation mushkil hai kyunki hume nahi pata starting health kya hai.

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

Iske bajaye, backwards work karo:

```
Princess
   ↑
Yahan kitni health chahiye?
   ↑
Pichli cell mein kitni health chahiye?
   ↑
Uske pehle kitni health chahiye?
```

Yeh problem ko chote subproblems ke collection mein transform kar deta hai — aur yahin Dynamic Programming useful ban jaati hai.

---

## Key Takeaways

1. Destination se start karo.
2. `dp[i][j]` matlab: minimum health jo cell (i,j) mein enter karne ke liye chahiye.
3. Max do choices hoti hain: Right ya Down.
4. Wo path choose karo jisme kam health chahiye.
5. Current cell ke liye adjust karo.
6. Health kabhi bhi 1 se kam nahi ho sakti.
7. Recurrence:

```
next = min(right, down)

dp[i][j] =
    max(1, next - dungeon[i][j])
```

---

## Final Answer

Example ke liye:

```
-2   -3    3
-5  -10    1
10   30   -5
```

Teeno approaches ka answer aata hai:

```
7
```

Algorithmic idea same rehta hai — sirf DP states ko store aur calculate karne ka tareeka change hota hai.
