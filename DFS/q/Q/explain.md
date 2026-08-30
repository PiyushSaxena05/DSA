# DFS — Count Nodes in Binary Tree

Implemented **DFS using recursion** to count the total number of nodes in a binary tree.

### Example

```text
       1
      / \
     2   3
    / \
   4   5
```

Output:

```text
5
```

### Approach

For every node:

1. If `root == null`, return `0`.
2. Count the current node → `1`.
3. Recursively count nodes in the left subtree.
4. Recursively count nodes in the right subtree.

### Code

```java
public static int nodecount(M root) {

    if (root == null) {
        return 0;
    }

    return 1 + nodecount(root.left) + nodecount(root.right);
}
```

### Key Concept

```text
count = current node
       + left subtree count
       + right subtree count
```

So:

```text
nodecount(root)
= 1 + nodecount(root.left) + nodecount(root.right)
```

### Complexity

* Time: **O(n)** — every node is visited once.
* Space: **O(h)** — recursion stack, where `h` is tree height.

### Important DFS Pattern

```text
DFS → Recursion / Stack
```

For this problem:

```text
Base Case → root == null → 0
Current Node → 1
Recursive Calls → left + right
```
