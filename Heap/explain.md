# Heap — PriorityQueue

Java provides `PriorityQueue` to implement a Heap.

## Min Heap

        new PriorityQueue<>(Collections.reverseOrder());
```

```text
peek() → largest
poll() → largest + removes it
```

## Important Pattern

### Kth Largest

Use **Min Heap** of size `k`.

```text
Kth Largest → Min Heap
```

### Kth Smallest

Use **Max Heap** of size `k`.

```text
Kth Smallest → Max Heap
```

### Logic

```java
pq.offer(num);

if (pq.size() > k) {
    pq.poll();
}

return pq.peek();
```

## Complexity

* `offer()` → O(log n)
* `poll()` → O(log n)
* `peek()` → O(1)
* Space → O(n)

### Key Difference

```text
Queue    → FIFO → first added
Stack    → LIFO → last added
Min Heap → smallest on top
Max Heap → largest on top
```
