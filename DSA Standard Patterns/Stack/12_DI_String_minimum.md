# Intuition

To construct the **smallest possible number**, we should assign the smallest available digits (`1, 2, 3, ...`) in order.

The only challenge is handling consecutive `'D'` (decreasing) characters. If we append digits immediately, the decreasing pattern cannot be satisfied. Instead, we temporarily store the digits in a stack.

Whenever we encounter an `'I'` (or reach the end of the pattern), we pop all elements from the stack. Since a stack is LIFO, the stored digits are reversed automatically, producing the smallest valid decreasing sequence.

---

# Approach

1. Initialize an empty stack and a `StringBuilder` for the answer.
2. Traverse the pattern from `0` to `pattern.length()` (inclusive).
3. At each position:
   - Push the next smallest digit (`i + 1`) onto the stack.
4. If:
   - we've reached the end of the pattern, or
   - the current character is `'I'`,
   
   pop all elements from the stack and append them to the answer.
5. Return the constructed string.

The stack naturally reverses every consecutive `'D'` segment, while `'I'` segments are appended immediately.

---

# Dry Run

Pattern:

```text
"IIIDIDDD"
```

| Step | Action | Stack | Answer |
|------|--------|-------|--------|
| Push 1 | [1] | |
| I → Pop | [] | 1 |
| Push 2 | [2] | 1 |
| I → Pop | [] | 12 |
| Push 3 | [3] | 12 |
| I → Pop | [] | 123 |
| Push 4 | [4] | 123 |
| D | [4] | 123 |
| Push 5 | [4,5] | 123 |
| I → Pop All | [] | 12354 |
| Push 6 | [6] | 12354 |
| D | [6] | 12354 |
| Push 7 | [6,7] | 12354 |
| D | [6,7] | 12354 |
| Push 8 | [6,7,8] | 12354 |
| D | [6,7,8] | 12354 |
| Push 9 | [6,7,8,9] | 12354 |
| End → Pop All | [] | **123549876** |

Final Answer:

```text
123549876
```

---

# Complexity

- **Time complexity:** `O(n)`
  - Every digit is pushed and popped exactly once.

- **Space complexity:** `O(n)`
  - The stack may contain up to `n + 1` digits.

---

# Key Observation 💡

A consecutive sequence of `'D'` characters simply means the corresponding digits must appear in reverse order.

Instead of explicitly reversing substrings, we can:
- Push digits while traversing.
- Pop everything whenever we encounter an `'I'` (or reach the end).

The stack performs the reversal automatically.

---

# Interview Tip 🚀

The trick is to iterate **one extra time** (`i <= pattern.length()`).

This ensures the last group of digits is flushed from the stack. Without this extra iteration, the final decreasing sequence would never be appended.

---

# Similar Problems

- **2375. Construct Smallest Number From DI String** ⭐ (This problem)
- **402. Remove K Digits**
- **456. 132 Pattern**
- **316. Remove Duplicate Letters**

These problems also use stacks to construct lexicographically optimal answers.

---

# Code

```java
class Solution {
    public String smallestNumber(String p) {
        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        // Traverse one extra step to flush the remaining stack
        for (int i = 0; i <= p.length(); i++) {

            // Push the next smallest available digit
            st.push(i + 1);

            // If current pattern is 'I' or we've reached the end,
            // pop everything to reverse the previous 'D' sequence.
            while (!st.isEmpty() && (i == p.length() || p.charAt(i) == 'I')) {
                sb.append(st.pop());
            }
        }

        return sb.toString();
    }

}
```


# BruteForce Code

```java
class Solution {
    public String smallestNumber(String pattern) {
        int n = pattern.length();

        int[] nums = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            nums[i] = i + 1;
        }

        do {
            if (isValid(nums, pattern)) {
                StringBuilder sb = new StringBuilder();
                for (int num : nums) {
                    sb.append(num);
                }
                return sb.toString();
            }
        } while (nextPermutation(nums));

        return "";
    }

    private boolean isValid(int[] nums, String pattern) {
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == 'I' && nums[i] >= nums[i + 1]) {
                return false;
            }
            if (pattern.charAt(i) == 'D' && nums[i] <= nums[i + 1]) {
                return false;
            }
        }
        return true;
    }

    // Generates the next lexicographical permutation
    private boolean nextPermutation(int[] nums) {
        int i = nums.length - 2;

        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i < 0) {
            return false;
        }

        int j = nums.length - 1;
        while (nums[j] <= nums[i]) {
            j--;
        }

        swap(nums, i, j);

        reverse(nums, i + 1, nums.length - 1);

        return true;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left++, right--);
        }
    }
}
```