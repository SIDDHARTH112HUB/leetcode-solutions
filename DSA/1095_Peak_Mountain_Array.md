# 1095. Find in Mountain Array

## 📝 Problem

An array is called a **Mountain Array** if:

- `arr.length >= 3`
- There exists an index `i` such that:
  - Increasing: `arr[0] < arr[1] < ... < arr[i]`
  - Decreasing: `arr[i] > arr[i+1] > ... > arr[n-1]`

You cannot access the array directly. Instead, use:

- `mountainArr.get(index)`
- `mountainArr.length()`

---

## 🎯 Task

- Find the **minimum index** such that:
  ```
  mountainArr.get(index) == target
  ```
- If not found, return `-1`
- Must minimize number of `get()` calls (<= 100)

---

# 💡 Intuition

Since the array is:

- Increasing → then → Decreasing

We can:

1. Find the **peak element**
2. Apply **binary search on left (ascending part)**
3. If not found → apply **binary search on right (descending part)**

---

# 🚀 Approach

1. Find peak index using binary search
2. Search in left half (ascending order)
3. If found → return index
4. Else search in right half (descending order)

---

# ⏱ Complexity

- **Time Complexity:** `O(log n)`
- **Space Complexity:** `O(1)`

---

# 💻 Code

```java
/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int mid = findPeakElement(mountainArr);
        int left = searchasc(mountainArr, 0, mid, target);
        return left != -1 ? left : searchdesc(mountainArr, mid, mountainArr.length() - 1, target);
    }

    public int findPeakElement(MountainArray nums) {
        int s = 0;
        int h = nums.length() - 1;

        while (s < h) {
            int mid = (s + h) / 2;
            int midele = nums.get(mid);

            if (mid == 0) {
                if (midele > nums.get(mid + 1)) {
                    return 0;
                }
                return 1;
            } else if (mid == nums.length() - 1) {
                if (midele > nums.get(mid - 1)) {
                    return mid;
                }
                return mid - 1;
            } else {
                int mid1 = nums.get(mid + 1);

                if (midele > nums.get(mid - 1) && midele > mid1) {
                    return mid;
                }

                if (mid1 > midele) {
                    s = mid + 1;
                } else {
                    h = mid - 1;
                }
            }
        }
        return s;
    }

    public int searchasc(MountainArray nums, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midele = nums.get(mid);

            if (midele == target)
                return mid;
            else if (midele > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public int searchdesc(MountainArray nums, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midele = nums.get(mid);

            if (midele == target)
                return mid;
            else if (midele > target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
```

---

## 🔥 Key Takeaways

- Split problem into 3 parts:
  - Peak finding
  - Ascending binary search
  - Descending binary search
- Efficient due to `O(log n)`
- Important to minimize `get()` calls

---

✔ Ready to push to GitHub 🚀