# Union of Two Arrays

## Approach 1: Using HashSet

### Logic

1. Create a `HashSet`.
2. Insert all elements of the first array into the set.
3. Insert all elements of the second array into the set.
4. Since a set does not allow duplicates, only unique elements remain.
5. Print or return the set.

### Code Idea

```java
HashSet<Integer> set = new HashSet<>();

for(int i = 0; i < n; i++){
    set.add(arr1[i]);
}

for(int i = 0; i < m; i++){
    set.add(arr2[i]);
}
```

### Time Complexity

* Inserting `n` elements → O(n)
* Inserting `m` elements → O(m)

**Total: O(n + m)**

### Space Complexity

* Set stores unique elements.

**O(n + m)**

### Trick to Remember

**"Add everything into a HashSet → duplicates disappear automatically."**

### When to Use

* Need only unique elements.
* Sorted order is not required.
* Fastest and simplest solution.

---

# Approach 2: Using TreeSet

### Logic

1. Create a `TreeSet`.
2. Insert all elements from the first array.
3. Insert all elements from the second array.
4. TreeSet removes duplicates and keeps elements sorted.
5. Print or return the set.

### Code Idea

```java
TreeSet<Integer> set = new TreeSet<>();

for(int num : arr1){
    set.add(num);
}

for(int num : arr2){
    set.add(num);
}
```

### Time Complexity

* Each insertion in TreeSet → O(log n)
* Total insertions → (n + m)

**Total: O((n + m) log(n + m))**

### Space Complexity

**O(n + m)**

### Trick to Remember

**"TreeSet = HashSet + Automatic Sorting."**

### When to Use

* Need unique elements.
* Need sorted output.
* Order matters.

---

# Quick Comparison

| Feature            | HashSet      | TreeSet               |
| ------------------ | ------------ | --------------------- |
| Duplicates Removed | ✅            | ✅                     |
| Sorted Output      | ❌            | ✅                     |
| Insertion Time     | O(1) Average | O(log n)              |
| Overall Complexity | O(n + m)     | O((n + m) log(n + m)) |
| Best Use Case      | Fast Union   | Sorted Union          |

---

# One-Liner

### HashSet

**"Store all elements in a HashSet. Since sets do not allow duplicates, the resulting set represents the union of both arrays."**

### TreeSet

**"Store all elements in a TreeSet. It removes duplicates and maintains elements in sorted order, giving a sorted union of the arrays."**
