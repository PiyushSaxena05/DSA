# Count Pairs With Given Sum

## 📌 Problem

Given an integer array `arr` and an integer `target`, count the number of **index pairs** `(i, j)` such that:

```text
i < j
arr[i] + arr[j] == target
```

### Example

```text
arr = [1, 5, 7, -1, 5]
target = 6
```

Valid pairs:

```text
1 + 5 = 6
1 + 5 = 6
7 + (-1) = 6
```

### Output

```text
3
```

---

# 1️⃣ Brute Force Approach

## 💡 Idea

Check every possible pair using two loops.

For every `i`, start `j` from `i + 1` and check:

```text
arr[i] + arr[j] == target
```

If true:

```text
count++
```

## Code

```java
public static int countPairs(int[] arr, int target) {

    int count = 0;

    for (int i = 0; i < arr.length; i++) {

        for (int j = i + 1; j < arr.length; j++) {

            if (arr[i] + arr[j] == target) {
                count++;
            }
        }
    }

    return count;
}
```

## Why `j = i + 1`?

We don't want:

```text
i == j
```

because an element cannot pair with itself.

We also don't want to count the same pair twice:

```text
(i, j)
(j, i)
```

So we only consider:

```text
i < j
```

## Complexity

```text
Time  : O(n²)
Space : O(1)
```

---

# 2️⃣ Optimized HashMap Approach

## 💡 Idea

Instead of checking every pair, use a `HashMap` to store the **frequency of previously seen elements**.

The map stores:

```text
number → frequency
```

For every current element:

```text
need = target - currentElement
```

Then check whether `need` has appeared before.

If it has appeared `k` times, then the current element forms **k valid pairs**.

So:

```text
count += frequency of need
```

After checking, increase the frequency of the current element.

---

# 🧠 Important Pattern

For Two Sum, we stored:

```text
number → index
```

For Count Pairs, we store:

```text
number → frequency
```

This is the key difference.

---

# Code

```java
public static int countPairs2(int[] arr, int target) {

    HashMap<Integer, Integer> hs = new HashMap<>();

    int count = 0;

    for (int i = 0; i < arr.length; i++) {

        int currentElement = arr[i];

        int need = target - currentElement;

        if (hs.containsKey(need)) {
            count += hs.get(need);
        }

        hs.put(
            currentElement,
            hs.getOrDefault(currentElement, 0) + 1
        );
    }

    return count;
}
```

---

# 🔍 Dry Run

Given:

```text
arr = [1, 5, 7, -1, 5]
target = 6
```

Initially:

```text
map = {}
count = 0
```

### i = 0

```text
current = 1
need = 6 - 1 = 5
```

`5` doesn't exist.

Store:

```text
1 → 1
```

---

### i = 1

```text
current = 5
need = 6 - 5 = 1
```

Map:

```text
1 → 1
```

So:

```text
count += 1
count = 1
```

Then store:

```text
5 → 1
```

Map:

```text
1 → 1
5 → 1
```

---

### i = 2

```text
current = 7
need = -1
```

`-1` doesn't exist.

Store:

```text
7 → 1
```

---

### i = 3

```text
current = -1
need = 7
```

Map contains:

```text
7 → 1
```

Therefore:

```text
count += 1
count = 2
```

Store:

```text
-1 → 1
```

---

### i = 4

```text
current = 5
need = 1
```

Map contains:

```text
1 → 1
```

Therefore:

```text
count += 1
count = 3
```

Then update frequency:

```text
5 → 2
```

Final:

```text
count = 3
```

---

# ⭐ Why Do We Add Frequency?

Consider:

```text
arr = [1, 5, 5]
target = 6
```

When we reach the second `5`:

```text
need = 1
```

If:

```text
1 → 1
```

then one pair exists.

But consider:

```text
arr = [1, 5, 5, 5]
target = 6
```

When each `5` arrives, it can pair with the previously seen `1`.

More importantly, if:

```text
need = 5
5 → 2
```

then the current element can form **2 different index-pairs**.

Therefore we use:

```java
count += hs.get(need);
```

instead of:

```java
count++;
```

---

# ⚠️ Common Mistakes

### Mistake 1 — Storing index instead of frequency

Wrong:

```java
map.put(currentElement, i);
```

Correct:

```java
map.put(
    currentElement,
    map.getOrDefault(currentElement, 0) + 1
);
```

---

### Mistake 2 — Only doing `count++`

Wrong:

```java
if (map.containsKey(need)) {
    count++;
}
```

Correct:

```java
if (map.containsKey(need)) {
    count += map.get(need);
}
```

Because `need` might have appeared multiple times.

---

### Mistake 3 — Updating frequency before checking

The current element should **not pair with itself**.

Correct order:

```text
1. Calculate need
2. Check previous frequency
3. Add frequency to count
4. Store/update current element
```

---

# 🚀 Complexity Comparison

| Approach    |     Time | Space |
| ----------- | -------: | ----: |
| Brute Force |    O(n²) |  O(1) |
| HashMap     | **O(n)** |  O(n) |

---

# 🧠 Placement Pattern

When you see:

```text
"Count pairs whose sum is target"
```

Think:

```text
Pair Sum
    ↓
Need / Complement
    ↓
HashMap
    ↓
number → frequency
```

### Quick Recognition

```text
Two Sum → number → index

Count Pairs → number → frequency
```

This **frequency HashMap pattern** is extremely useful in placement questions involving:

* Pair counting
* Frequency counting
* Duplicate elements
* Complement problems
* Subarray/prefix-sum problems
* Character/string frequency
