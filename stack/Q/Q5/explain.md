# Queue Using Two Stacks

Implemented a **Queue using two Stacks** (`stack1` and `stack2`).

### Concept

Queue follows **FIFO** (First In, First Out), while Stack follows **LIFO** (Last In, First Out).

To achieve FIFO using two stacks:

* `stack1` → stores newly added elements.
* `stack2` → provides the front element.
* When `stack2` is empty, transfer all elements from `stack1` to `stack2`.

### Operations

```text
enqueue(x) → stack1.push(x)

dequeue():
    if stack2 is empty:
        transfer stack1 → stack2
    return stack2.pop()

peek():
    if stack2 is empty:
        transfer stack1 → stack2
    return stack2.peek()
```

### Complexity

| Operation | Complexity     |
| --------- | -------------- |
| Enqueue   | O(1)           |
| Dequeue   | Amortized O(1) |
| Peek      | Amortized O(1) |
| Space     | O(n)           |

### Key Idea

**Transfer only when `stack2` is empty.**

This ensures that the oldest element remains at the top of `stack2`, giving us **FIFO behavior using LIFO stacks**.
