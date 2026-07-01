# Linear Search in Java

## Problem

Find the index of a target element in an array using the Linear Search algorithm.

## Algorithm

1. Start from the first element of the array.
2. Compare each element with the target value.
3. If the target is found, return its index.
4. If the loop finishes without finding the target, return `-1`.

## Code

```java
package Arrays;

import java.util.Scanner;

public class Q5 {

    static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Please enter target number: ");
        int target = input.nextInt();

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        int ans = linearSearch(arr, target);

        System.out.println("Target at index: " + ans);
    }
}
```

## Example

### Input

```
7
```

### Output

```
Target at index: 6
```

## Time Complexity

* Best Case: **O(1)**
* Worst Case: **O(n)**

## Space Complexity

* **O(1)**

## Explanation

Linear Search checks each element one by one until the target element is found. If the target exists in the array, its index is returned. Otherwise, `-1` is returned to indicate that the element is not present.
