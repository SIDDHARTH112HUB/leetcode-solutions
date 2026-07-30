# Intuition

The expression contains only `+`, `-`, parentheses, and integers. Instead of evaluating each parenthesized expression separately, we can process the string from left to right while maintaining the current result and sign.

Whenever we enter a new pair of parentheses, we save the current state (`sum` and `sign`) on a stack. After evaluating the inner expression, we restore the previous state and merge the result. This allows us to evaluate nested expressions in a single traversal.

---

# Approach

1. Initialize:
   - `sum` to store the current evaluated result.
   - `sign` to represent whether the next number should be added or subtracted.
   - A stack to store the previous result and sign before entering parentheses.

2. Traverse the string character by character:
   - If the character is a digit, parse the complete number (to handle multiple digits), multiply it by the current sign, and add it to `sum`.
   - If the character is `'('`:
     - Push the current `sum` onto the stack.
     - Push the current `sign` onto the stack.
     - Reset `sum = 0` and `sign = 1` to evaluate the new sub-expression.
   - If the character is `')'`:
     - Pop the stored sign and multiply it with the current result.
     - Pop the previous accumulated result and add it.
   - If the character is `'-'`, flip the sign for the next number.
   - Ignore `'+'` and spaces since they do not require any special handling.

At the end of the traversal, `sum` contains the final evaluated expression.

---

# Dry Run

For:

```
s = "1 + (2 - (3 + 4))"
```

| Character | Action | Sum | Sign | Stack |
|-----------|--------|-----|------|-------|
| 1 | Add number | 1 | 1 | [] |
| ( | Save state | 0 | 1 | [1,1] |
| 2 | Add number | 2 | 1 | [1,1] |
| - | Next number negative | 2 | -1 | [1,1] |
| ( | Save state | 0 | 1 | [1,1,2,-1] |
| 3 | Add number | 3 | 1 | ... |
| + | Ignore | 3 | 1 | ... |
| 4 | Add number | 7 | 1 | ... |
| ) | Restore previous state | -5 | 1 | [1,1] |
| ) | Restore previous state | -4 | 1 | [] |

Answer = **-4**

---

# Complexity

- **Time complexity:** `O(n)`
  - Every character is processed at most once.

- **Space complexity:** `O(n)`
  - In the worst case (deeply nested parentheses), the stack stores all intermediate states.

---

# Key Observation 💡

Whenever we encounter `'('`, we **start a fresh calculation** but **remember**:
- the result calculated so far, and
- the sign before the parenthesis.

When we encounter `')'`, we simply compute:

```
currentResult = previousResult + previousSign × currentResult
```

This lets us evaluate arbitrarily nested expressions without recursion.

---

# Interview Tip 🚀

A common mistake is trying to evaluate the expression using operator precedence. Since this problem contains only `+`, `-`, and parentheses, precedence isn't an issue.

The stack only needs to store:
- Previous accumulated result.
- Previous sign.

No operator stack is required.

---

# Similar Problems

- **224. Basic Calculator** ⭐ (This problem)
- **227. Basic Calculator II** (Adds `*` and `/`)
- **772. Basic Calculator III** (Adds `*`, `/`, and parentheses)

These three problems are commonly asked together in interviews.

---

# Code

```java
class Solution {
    public int calculate(String s) {
        int sum = 0;      // Current evaluated result
        int sign = 1;     // Sign of the next number (1 or -1)

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // Parse a complete number
            if (Character.isDigit(c)) {
                int value = 0;

                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    value = value * 10 + (s.charAt(i) - '0');
                    i++;
                }

                i--; // Step back because the for-loop will increment i

                // Apply the current sign and add to the result
                sum += value * sign;

                // Reset sign for the next number
                sign = 1;
            }

            // Beginning of a new sub-expression
            else if (c == '(') {
                // Save current result and sign
                st.push(sum);
                st.push(sign);

                // Reset for evaluating the expression inside parentheses
                sum = 0;
                sign = 1;
            }

            // End of current sub-expression
            else if (c == ')') {
                // Apply the sign before '('
                sum *= st.pop();

                // Add the result before '('
                sum += st.pop();
            }

            // The next number should be negative
            else if (c == '-') {
                sign *= -1;
            }

            // '+' and spaces require no action
        }

        return sum;
    }
}
```