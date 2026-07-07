# 169. Majority Element - HashMap Approach

## Problem Statement

Given an integer array `nums`, return the majority element.

The majority element appears more than `⌊n / 2⌋` times.

The majority element is guaranteed to exist.

---

# Approach

Use a HashMap to store the frequency of every number.

The key of the map stores the number.

The value stores its frequency.

While traversing the array:

- Increase the frequency of the current number.
- If its frequency becomes greater than `n / 2`, return it immediately.

---

# Logic

HashMap stores data in the form

```
Key -> Frequency
```

Example

```
2 -> 4

1 -> 3
```

As soon as any frequency becomes greater than `n / 2`, that element is the majority element.

---

# Algorithm

```
Create HashMap

Traverse array

Increase frequency

If frequency > n/2

Return current element
```

---

# Dry Run

Input

```
[2,2,1,1,1,2,2]
```

Initially

```
{}
```

After first 2

```
{2=1}
```

After second 2

```
{2=2}
```

After first 1

```
{2=2,1=1}
```

After second 1

```
{2=2,1=2}
```

After third 1

```
{2=2,1=3}
```

After next 2

```
{2=3,1=3}
```

After last 2

```
{2=4,1=3}
```

```
4 > 3
```

Return

```
2
```

---

# Why does this work?

HashMap keeps track of the frequency of every element.

Instead of counting the same element multiple times, its frequency is updated only once per occurrence.

---

# Time Complexity

```
O(n)
```

Single traversal.

HashMap operations take O(1) on average.

---

# Space Complexity

```
O(n)
```

In the worst case, every element is different.

---

# Advantages

- Much faster than brute force.
- Easy to understand.
- Common interview solution.

---

# Disadvantages

- Uses extra memory.

---

# Interview Notes

### Time Complexity

```
O(n)
```

### Space Complexity

```
O(n)
```

### Optimal?

❌ Uses extra space.

---

# Code

```java
class Solution {

    public int majorityElement(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {

            map.put(num, map.getOrDefault(num, 0) + 1);

            if (map.get(num) > nums.length / 2) {
                return num;
            }
        }

        return -1;
    }
}
```
