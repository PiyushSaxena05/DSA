Container With Most Water
Problem

You are given an integer array height of length n.

Each element in the array represents the height of a vertical line at that particular index.

The goal is to select two lines such that, together with the x-axis, they form a container that can hold the maximum amount of water.

Example
height = [1,8,6,2,5,4,8,3,7]

Visual representation:

Index:    0 1 2 3 4 5 6 7 8
Height:  [1,8,6,2,5,4,8,3,7]

We need to find two indices that produce the maximum possible area.

Understanding the Formula

The amount of water stored depends on two things:

Width between the two selected lines.
Height of the shorter line.

The formula is:

Area = Width × Height

Where:

Width = rightIndex - leftIndex

and:

Height = min(height[left], height[right])

Therefore:

Area = min(height[left], height[right]) × (right - left)
Why Do We Use the Smaller Height?

Consider two walls:

Height = 8                Height = 7
    |                         |
    |                         |
    |                         |
    |                         |
    |                         |
    |                         |
    |                         |
    |_________________________|

Even though the left wall has height 8, water can only rise to height 7.

Why?

Because the wall with height 7 will limit the water. Anything above height 7 would overflow from that side.

Therefore:

Container Height = min(8, 7) = 7
Example Calculation

Consider:

height = [1,8,6,2,5,4,8,3,7]

Choose:

left = 1
right = 8

The heights are:

height[left] = 8
height[right] = 7
Width

The indices are:

left = 1
right = 8

Therefore:

Width = right - left
      = 8 - 1
      = 7
Height
Height = min(8, 7)
       = 7
Area
Area = Width × Height

     = 7 × 7

     = 49

So the maximum water stored is:

49
Approach 1: Standard Two Pointer
Intuition

Instead of checking every possible pair of lines, we use two pointers.

Initially:

left = 0
right = height.length - 1

This gives us the maximum possible width.

left                                      right
 ↓                                          ↓

[1,8,6,2,5,4,8,3,7]

For every pair:

Calculate the width.
Find the smaller height.
Calculate the area.
Update the maximum area.
Move the pointer with the smaller height.
Why Move the Smaller Pointer?

Suppose:

left height = 3
right height = 8

The current container height is:

min(3, 8) = 3

The left wall is limiting the amount of water.

If we move the right pointer:

Width decreases

But the left wall with height 3 still remains.

Therefore, there is no guarantee that moving the taller wall will improve the result.

Instead, we move the smaller wall and hope to find a taller wall.

if (height[left] < height[right]) {
    left++;
} else {
    right--;
}

This is the main idea behind the Two Pointer solution.

Standard Two Pointer Code
class Solution {

    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int maxArea = 0;

        while (left < right) {

            // Calculate width
            int width = right - left;

            // Find the limiting height
            int containerHeight =
                    Math.min(height[left], height[right]);

            // Calculate the current area
            int area = width * containerHeight;

            // Store the maximum area found so far
            maxArea = Math.max(maxArea, area);

            // Move the pointer with the smaller height
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
Dry Run of Standard Two Pointer

Input:

[1,8,6,2,5,4,8,3,7]

With indices:

Index:    0 1 2 3 4 5 6 7 8
Height:  [1,8,6,2,5,4,8,3,7]
Iteration 1
left = 0
right = 8

Heights:

height[0] = 1
height[8] = 7
Width
8 - 0 = 8
Container Height
min(1, 7) = 1
Area
8 × 1 = 8
maxArea = 8

Since:

1 < 7

Move the left pointer:

left++

Now:

left = 1
right = 8
Iteration 2

Heights:

height[1] = 8
height[8] = 7
Width
8 - 1 = 7
Height
min(8, 7) = 7
Area
7 × 7 = 49

Update:

maxArea = max(8, 49)

maxArea = 49

Since:

8 > 7

Move the right pointer:

right--

The algorithm continues until:

left >= right

The final result remains:

49
Complexity Analysis
Time Complexity
O(n)

Both pointers move only toward each other.

The left pointer can move at most n times.

The right pointer can also move at most n times.

Therefore, the total complexity is:

O(n)
Space Complexity
O(1)

We only use a few variables:

left
right
width
height
area
maxArea

No extra array or data structure is used.

Approach 2: Two Pointer with Skipping Optimization
Intuition

The second approach uses the same Two Pointer concept.

However, instead of moving only one pointer by one position, it can skip multiple heights at once.

The key observation is:

After calculating an area with a limiting height minH, any next height less than or equal to minH on either side cannot produce a better area than the current pair.

Why?

Because after moving inward:

New Width < Current Width

If the new height is also:

New Height <= minH

Then both conditions are worse or equal.

Therefore, the new area cannot be greater than the current area for that side.

So we can safely skip those heights.

Example of Skipping

Suppose the current situation is:

Left Height = 5
Right Height = 10

Current limiting height = 5

Current area:

Area = 5 × width

Now imagine moving the left pointer gives:

5 → 2 → 3 → 5 → 8

The values:

2
3
5

can be skipped.

Why?

Because:

Their height <= 5

At the same time, moving inward reduces the width.

So:

Smaller Width
+
Height <= Current Limiting Height

cannot produce a better area than the one already calculated.

The first potentially useful height is:

8

because:

8 > 5

Now there is a possibility that the limiting height can increase.

Optimized Two Pointer Code
class Solution {

    public int maxArea(int[] h) {

        int srt = 0;
        int end = h.length - 1;

        int maxWater = 0;

        while (srt < end) {

            // Find the smaller height between both pointers
            int minH = Math.min(h[srt], h[end]);

            // Calculate area
            // Width = end - srt
            // Height = minH
            int area = minH * (end - srt);

            // Update maximum area
            maxWater = Math.max(maxWater, area);

            // Skip all heights from the left
            // that are less than or equal to minH
            while (srt < end && h[srt] <= minH) {
                srt++;
            }

            // Skip all heights from the right
            // that are less than or equal to minH
            while (srt < end && h[end] <= minH) {
                end--;
            }
        }

        return maxWater;
    }
}
Dry Run of Skipping Optimization

Input:

h = [1,8,6,2,5,4,8,3,7]

Indices:

       0 1 2 3 4 5 6 7 8
h =   [1,8,6,2,5,4,8,3,7]
Initial State
srt = 0
end = 8
maxWater = 0

Current heights:

h[0] = 1
h[8] = 7
Iteration 1
Find Minimum Height
minH = min(1, 7)

minH = 1
Calculate Width
end - srt

8 - 0 = 8
Calculate Area
area = 1 × 8

area = 8

Update maximum:

maxWater = max(0, 8)

maxWater = 8
Skip from Left

Check:

h[0] <= minH

1 <= 1

True.

Move:

srt = 1

Check again:

h[1] <= 1

8 <= 1

False.

Stop.

The left pointer is now:

srt = 1
Skip from Right

Check:

h[8] <= minH

7 <= 1

False.

The right pointer remains:

end = 8
Iteration 2

Current pointers:

srt = 1
end = 8

Current heights:

h[1] = 8
h[8] = 7
Minimum Height
minH = min(8, 7)

minH = 7
Width
8 - 1 = 7
Area
7 × 7 = 49

Update:

maxWater = max(8, 49)

maxWater = 49
Left Skipping
h[1] = 8

8 <= 7

False.

So:

srt = 1
Right Skipping

First:

h[8] = 7

7 <= 7

True.

Move:

end = 7

Now:

h[7] = 3

3 <= 7

True.

Move:

end = 6

Now:

h[6] = 8

8 <= 7

False.

Stop.

Current pointers:

srt = 1
end = 6
Iteration 3

Current heights:

h[1] = 8
h[6] = 8
Minimum Height
minH = min(8, 8)

minH = 8
Width
6 - 1 = 5
Area
8 × 5 = 40

Update:

maxWater = max(49, 40)

maxWater = 49
Left Skipping

Current limiting height:

minH = 8

Now the algorithm skips:

h[1] = 8
h[2] = 6
h[3] = 2
h[4] = 5
h[5] = 4

Because all are:

<= 8

Eventually:

srt = 6
end = 6

The condition:

srt < end

becomes false.

The loop stops.

Final Result
maxWater = 49
Comparison Between Both Approaches
Feature	Standard Two Pointer	Two Pointer + Skipping
Technique	Two Pointers	Two Pointers
Pointer Movement	One step at a time	Can skip multiple positions
Time Complexity	O(n)	O(n)
Space Complexity	O(1)	O(1)
Main Idea	Move smaller height	Skip heights <= current minH
Optimal	Yes	Yes
Why Is the Skipping Approach Still O(n)?

At first, it might look like nested loops mean:

O(n²)

But that is not the case.

Consider:

while (srt < end && h[srt] <= minH) {
    srt++;
}

Even though this is inside another while loop, the pointer:

srt

only moves forward.

It never moves backward.

Similarly:

end

only moves backward.

Every array index is visited at most a limited number of times.

Therefore, the total work done by both pointers is linear:

O(n)
Key Observations
1. Width is Based on Indices
Width = right - left

Example:

left = 1
right = 8

Width = 8 - 1 = 7

We do not calculate:

height[right] - height[left]

because that is the difference between heights, not the distance between the lines.

2. The Smaller Wall Determines the Water Level
Container Height = min(height[left], height[right])

Example:

Heights = 8 and 7

Container Height = 7
3. Area Formula
Area = Width × Smaller Height

Therefore:

Area = (right - left)
       ×
       min(height[left], height[right])
4. Moving the Smaller Pointer Is the Key

The smaller wall limits the current container.

Moving the taller wall only reduces the width and does not remove the current limiting wall.

Therefore:

if (height[left] < height[right]) {
    left++;
} else {
    right--;
}
Complexity Summary
Standard Two Pointer
Time Complexity:  O(n)
Space Complexity: O(1)
Two Pointer with Skipping Optimization
Time Complexity:  O(n)
Space Complexity: O(1)
Final Takeaway

The main formula to remember is:

Width = right - left

Height = min(height[left], height[right])

Area = Width × Height

The standard solution uses:

Two Pointers
+
Move the Smaller Height

The optimized solution uses:

Two Pointers
+
Skip Heights <= Current Limiting Height

Both approaches are optimal, run in O(n) time, and use O(1) extra space.
