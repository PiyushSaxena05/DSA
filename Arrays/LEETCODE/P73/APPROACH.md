# LeetCode 73 - Set Matrix Zeroes (Optimal Approach)

## Problem Statement

Given an `m x n` integer matrix, if an element is `0`, set its entire row and column to `0`.

You must do it **in-place**, meaning no extra matrix should be created.

---

## Example

### Input

```java
matrix = [
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
```

### Output

```java
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
```

---

# Intuition

A straightforward idea is:

1. Store all rows containing `0`.
2. Store all columns containing `0`.
3. Traverse again and make those rows and columns `0`.

However, this requires extra space.

To optimize space, we can use:

* **First Row** → Store column markers.
* **First Column** → Store row markers.

This allows us to achieve **O(1)** extra space.

---

# Key Observation

If `matrix[i][j] == 0`, then:

```java
matrix[i][0] = 0; // Mark entire row i
matrix[0][j] = 0; // Mark entire column j
```

The first row and first column act like marker arrays.

---

# Why do we need two boolean variables?

Since the first row and first column are being used as markers, we may lose information about whether they originally contained a `0`.

Therefore, we store their original state separately.

```java
boolean firstRowZero;
boolean firstColZero;
```

---

# Algorithm

## Step 1: Check whether the first row contains any `0`.

```java
for (int j = 0; j < col; j++)
```

If yes:

```java
firstRowZero = true;
```

---

## Step 2: Check whether the first column contains any `0`.

```java
for (int i = 0; i < rows; i++)
```

If yes:

```java
firstColZero = true;
```

---

## Step 3: Traverse the remaining matrix.

Start from index `1` because:

* First row is reserved for column markers.
* First column is reserved for row markers.

```java
for(int i = 1; i < rows; i++)
{
    for(int j = 1; j < col; j++)
    {
        if(matrix[i][j] == 0)
        {
            matrix[i][0] = 0;
            matrix[0][j] = 0;
        }
    }
}
```

---

## Step 4: Update the matrix using markers.

If:

```java
matrix[i][0] == 0
```

or

```java
matrix[0][j] == 0
```

then:

```java
matrix[i][j] = 0;
```

---

## Step 5: Handle first row and first column separately.

Because they were used as marker storage.

---

# Dry Run

### Initial Matrix

```text
1 1 1
1 0 1
1 1 1
```

---

### After Marking

Since `matrix[1][1] == 0`

```java
matrix[1][0] = 0;
matrix[0][1] = 0;
```

Matrix becomes:

```text
1 0 1
0 0 1
1 1 1
```

These are **markers**, not final answers.

---

### Apply Markers

* Row 1 is marked.
* Column 1 is marked.

Final matrix:

```text
1 0 1
0 0 0
1 0 1
```

---

# Visualization

```text
First Row      → Column Markers
First Column   → Row Markers
```

```text
      0  1  2
    ------------
0 |  1  0  1
1 |  0  0  1
2 |  1  1  1
```

Meaning:

```text
matrix[1][0] = 0 → Row 1 should become zero.
matrix[0][1] = 0 → Column 1 should become zero.
```

---

# Why do loops start from `1`?

Because index `0` is reserved for markers.

```java
for(int i = 1; i < rows; i++)
for(int j = 1; j < col; j++)
```

If we start from `0`, we may overwrite marker information.

---

# Complexity Analysis

### Time Complexity

```text
O(m × n)
```

We traverse the matrix a constant number of times.

---

### Space Complexity

```text
O(1)
```

No extra arrays are used.

Only two boolean variables are required.

---

# Java Code

```java
class Solution {
    public void setZeroes(int[][] matrix) {

        int rows = matrix.length;
        int col = matrix[0].length;

        boolean f_Row = false;
        boolean f_col = false;

        for (int j = 0; j < col; j++) {
            if (matrix[0][j] == 0) {
                f_Row = true;
                break;
            }
        }

        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                f_col = true;
                break;
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (f_Row) {
            for (int j = 0; j < col; j++) {
                matrix[0][j] = 0;
            }
        }

        if (f_col) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
```

---

# Key Interview Points

✅ In-place modification.

✅ First row and first column are used as marker arrays.

✅ Extra arrays are avoided.

✅ Space optimized from `O(m + n)` to `O(1)`.

✅ Two boolean variables are necessary because `matrix[0][0]` cannot independently represent both first row and first column states.
