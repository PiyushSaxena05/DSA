# Container With Most Water

Do pointers ka use karke ek array me diye gaye heights se maximum water container area nikalne wala classic problem.

## Problem Statement

Ek integer array `height` diya gaya hai, jisme har element ek vertical line ki height represent karta hai. Do lines choose karni hain jo x-axis ke sath milkar sabse zyada paani store kar sakein.

```
Index:    0 1 2 3 4 5 6 7 8
Height:  [1,8,6,2,5,4,8,3,7]
```

## Formula

```
Width  = right - left
Height = min(height[left], height[right])
Area   = Width × Height
```

**Chhoti height kyun use hoti hai?**
Paani sirf chhoti wall tak hi tik sakta hai — us se zyada height wale side se paani overflow ho jayega. Isliye container ki effective height hamesha `min(left, right)` hoti hai.

### Example

```
left = 1, right = 8
height[left] = 8, height[right] = 7

Width  = 8 - 1 = 7
Height = min(8, 7) = 7
Area   = 7 × 7 = 49
```

## Approach 1: Standard Two Pointer

- `left = 0`, `right = n - 1` se start karo (max possible width).
- Har step par area calculate karo aur `maxArea` update karo.
- Jis pointer ki height chhoti hai, usi ko move karo — kyunki wahi wall limiting factor hai.

```java
class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int width = right - left;
            int containerHeight = Math.min(height[left], height[right]);
            int area = width * containerHeight;
            maxArea = Math.max(maxArea, area);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
```

**Complexity:** Time `O(n)`, Space `O(1)`

## Approach 2: Two Pointer with Skipping Optimization

Same idea, lekin ek pointer ko ek se zyada steps skip karne diya jata hai.

**Key insight:** Ek baar `minH` limiting height calculate ho jane ke baad, us side ki koi bhi height jo `minH` se chhoti ya barabar hai, usse behtar area kabhi nahi de sakti (width bhi ghat rahi hai). Isliye unhe safely skip kar sakte hain.

```java
class Solution {
    public int maxArea(int[] h) {
        int srt = 0;
        int end = h.length - 1;
        int maxWater = 0;

        while (srt < end) {
            int minH = Math.min(h[srt], h[end]);
            int area = minH * (end - srt);
            maxWater = Math.max(maxWater, area);

            while (srt < end && h[srt] <= minH) {
                srt++;
            }
            while (srt < end && h[end] <= minH) {
                end--;
            }
        }
        return maxWater;
    }
}
```

**Complexity:** Time `O(n)`, Space `O(1)` — pointers sirf ek hi direction me move karte hain, isliye nested loop hone ke bawajood total work linear hi rehta hai.

## Comparison

| Feature | Standard Two Pointer | Two Pointer + Skipping |
|---|---|---|
| Pointer Movement | Ek step at a time | Multiple positions skip |
| Time Complexity | O(n) | O(n) |
| Space Complexity | O(1) | O(1) |
| Main Idea | Chhoti height wala pointer move karo | `minH` se chhoti/equal heights skip karo |

## Key Takeaways

1. **Width** indices ka difference hai, heights ka nahi.
2. **Container height** hamesha do walls me se chhoti wali hoti hai.
3. **Chhota pointer move karo** — taller wall move karne se sirf width ghatega, limiting wall wahi rahegi.
4. Dono approaches optimal hain: `O(n)` time, `O(1)` space.
