# 42. Trapping Rain Water 🌧️

## Problem Overview

Given an array of non-negative integers where each value represents the height of a bar, calculate how much rainwater can be trapped between these bars.

Each bar has a width of `1`.

### Example

```text
height = [0,1,0,2,1,0,1,3,2,1,2,1]
```

The goal is to calculate the **total amount of water trapped after raining**.

---

# 🧠 Understanding the Problem

Consider a simple example:

```text
height = [2,0,2]
```

Visualization:

```text
█     █
█     █
█  ~  █
█  ~  █
-------
2  0  2
```

The middle bar has height `0`, while both sides have bars of height `2`.

Therefore, the middle position can trap:

```text
2 - 0 = 2 units
```

So the answer is:

```text
2
```

---

# 💡 Core Concept

For any position `i`, the amount of water that can be trapped depends on:

* The tallest bar on its **left**
* The tallest bar on its **right**

The water level cannot exceed the smaller of these two boundaries.

Therefore:

```text
water[i] = min(leftMax, rightMax) - height[i]
```

Where:

```text
leftMax  = Maximum height on the left side
rightMax = Maximum height on the right side
```

---

# Example

Consider:

```text
[3,1,2]
```

For the middle element:

```text
Left maximum  = 3
Right maximum = 2
Current height = 1
```

The smaller boundary determines the water level:

```text
min(3,2) = 2
```

Therefore:

```text
water = 2 - 1 = 1
```

So the middle position traps:

```text
1 unit of water
```

---

# 🚀 Optimal Approach: Two Pointers

A straightforward approach would be to calculate `leftMax` and `rightMax` for every index.

However, we can optimize this using the **Two Pointer technique**.

We maintain:

```text
l        → Left pointer
r        → Right pointer

l_max    → Maximum height encountered from the left
r_max    → Maximum height encountered from the right

total_water → Total trapped water
```

Initially:

```java
int l = 0;
int r = height.length - 1;

int l_max = 0;
int r_max = 0;

int total_water = 0;
```

---

# 🔑 Main Logic

We compare:

```java
height[l] <= height[r]
```

### If the left bar is smaller or equal

```java
if (height[l] <= height[r])
```

We process the **left side**.

Why?

Because the right side already has a bar that is at least as high as the current left boundary.

Therefore, the left side can safely determine the trapped water using `l_max`.

---

### If the right bar is smaller

```java
else
```

We process the **right side**.

Similarly, the left side provides a sufficiently large boundary, allowing us to calculate water using `r_max`.

---

# 🔍 Processing the Left Side

Suppose:

```text
l_max = 3
height[l] = 1
```

Since the current height is smaller than the maximum height seen from the left:

```text
water = 3 - 1 = 2
```

So:

```java
total_water += l_max - height[l];
```

However, if the current bar is greater than or equal to `l_max`:

```java
height[l] >= l_max
```

Then it becomes the new maximum:

```java
l_max = height[l];
```

No water is trapped at that position because the current bar itself becomes the highest boundary encountered from the left.

---

# 🔍 Processing the Right Side

The same logic applies from the right.

If:

```java
height[r] >= r_max
```

Then:

```java
r_max = height[r];
```

Otherwise:

```java
total_water += r_max - height[r];
```

Then move the pointer:

```java
r--;
```

---

# 💻 Final Java Solution

```java
class Solution {

    public int trap(int[] height) {

        // Left and right pointers
        int l = 0;
        int r = height.length - 1;

        // Maximum heights seen from both sides
        int l_max = 0;
        int r_max = 0;

        // Stores the total trapped water
        int total_water = 0;

        // Continue until both pointers meet
        while (l < r) {

            // Process the side with the smaller height
            if (height[l] <= height[r]) {

                // Update left maximum if a taller bar is found
                if (height[l] >= l_max) {
                    l_max = height[l];
                } 
                
                // Otherwise, water can be trapped
                else {
                    total_water += l_max - height[l];
                }

                // Move left pointer
                l++;

            } else {

                // Update right maximum if a taller bar is found
                if (height[r] >= r_max) {
                    r_max = height[r];
                } 
                
                // Otherwise, water can be trapped
                else {
                    total_water += r_max - height[r];
                }

                // Move right pointer
                r--;
            }
        }

        return total_water;
    }
}
```

---

# 🧪 Dry Run

Consider:

```text
height = [2,1,0,3]
```

Initial state:

```text
[2,1,0,3]
 ↑     ↑
 l     r

l_max = 0
r_max = 0
total_water = 0
```

---

## Step 1

```text
height[l] = 2
height[r] = 3
```

Since:

```text
2 <= 3
```

Process the left side.

```text
2 >= l_max(0)
```

Update:

```text
l_max = 2
```

Move:

```text
l++
```

---

## Step 2

```text
[2,1,0,3]
   ↑   ↑
   l   r
```

Now:

```text
height[l] = 1
l_max = 2
```

Since:

```text
1 < 2
```

Water trapped:

```text
2 - 1 = 1
```

Update:

```text
total_water = 1
```

Move:

```text
l++
```

---

## Step 3

```text
[2,1,0,3]
     ↑ ↑
     l r
```

Now:

```text
height[l] = 0
l_max = 2
```

Water trapped:

```text
2 - 0 = 2
```

Update:

```text
total_water = 1 + 2
```

```text
total_water = 3
```

Move:

```text
l++
```

Now both pointers meet, so the loop ends.

Final answer:

```text
3
```

---

# ⚠️ Important Detail

When calculating trapped water, we must use:

```java
total_water += l_max - height[l];
```

and:

```java
total_water += r_max - height[r];
```

We use `+=` because water trapped at every position must be **added to the existing total**.

Using:

```java
total_water = l_max - height[l];
```

would overwrite the previously calculated water.

For example:

```text
First position → 1 unit
Second position → 2 units
```

Correct:

```text
total_water = 1 + 2 = 3
```

Incorrect with `=`:

```text
total_water = 2
```

The previous `1` unit would be lost.

---

# 📊 Complexity Analysis

### Time Complexity

```text
O(n)
```

Each pointer moves only in one direction.

* `l` moves from left to right.
* `r` moves from right to left.

Each element is processed at most once.

---

### Space Complexity

```text
O(1)
```

We only use a few variables:

```text
l
r
l_max
r_max
total_water
```

No additional array or data structure is required.

---

# 🧠 Key Takeaway

The entire problem is based on one formula:

```text
water[i] = min(leftMax, rightMax) - height[i]
```

The **Two Pointer approach** avoids storing `leftMax` and `rightMax` for every index.

Instead:

* Compare the heights at both pointers.
* Process the smaller side.
* Maintain the maximum height seen from that side.
* Add the difference between the maximum boundary and the current height.

---

# 🎯 Interview Explanation

> For every bar, the trapped water depends on the minimum of the maximum heights on its left and right. Instead of precomputing these values using extra arrays, we use two pointers and track the maximum heights seen from both sides. We always process the side with the smaller current boundary because the opposite side guarantees a boundary large enough to determine the trapped water. This gives an optimal time complexity of `O(n)` and constant extra space `O(1)`.

---

## Final Complexity

| Metric           | Complexity |
| ---------------- | ---------- |
| Time Complexity  | `O(n)`     |
| Space Complexity | `O(1)`     |

