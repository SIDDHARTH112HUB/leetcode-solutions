# Intuition

Since multiplication (`*`) and division (`/`) have higher precedence than addition (`+`) and subtraction (`-`), we evaluate them immediately while traversing the expression.

We maintain:
- A **number stack** to store values that will eventually be added together.
- An **operator stack** to temporarily store `*` and `/`.

Whenever we read a number:
- If the previous pending operator is `*` or `/`, compute the result immediately with the top of the number stack.
- Otherwise, push the number (with its sign) onto the number stack.

Finally, sum all numbers in the stack to get the answer.

---

# Approach

1. Traverse the string from left to right.
2. Parse complete numbers (handles multiple digits).
3. Maintain a `sign` variable for handling subtraction.
4. If a pending `*` or `/` exists:
   - Pop the previous number.
   - Perform the operation.
   - Push the result back.
5. Otherwise, push the signed number onto the stack.
6. Store only `*` and `/` in the operator stack because `+` and `-` are handled using the sign.
7. After processing the entire string, sum all elements in the number stack.

---

# Dry Run

Input:

```text
3+2*2
```

| Character | Number Stack | Operator Stack |
|-----------|--------------|----------------|
| 3 | [3] | [] |
| + | [3] | [] |
| 2 | [3,2] | [] |
| * | [3,2] | [*] |
| 2 | [3,4] | [] |

Final Answer = **3 + 4 = 7**

---

# Complexity

- **Time complexity:** `O(n)`
  - Each character is processed once.

- **Space complexity:** `O(n)`
  - In the worst case, all numbers may be stored in the stack.

---

# Key Observation 💡

Instead of storing every operator, only `*` and `/` need special treatment because of their higher precedence.

Addition and subtraction can be converted into **signed numbers**, making the final computation simply the sum of all values in the stack.

---

# Interview Tip 🚀

A common optimization is to use **only one stack** by keeping track of the previous operator (`+`, `-`, `*`, `/`) instead of maintaining a separate operator stack.

Your solution uses **two stacks**, which still runs in **O(n)** time and is easy to understand because it explicitly separates numbers from operators.

---

# Similar Problems

- **224. Basic Calculator**
- **227. Basic Calculator II** ⭐ (This problem)
- **772. Basic Calculator III**

These three problems are excellent practice for mastering stack-based expression evaluation.

---

# Code

```java
class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        Stack<Character> sts = new Stack<>();

        int sign = 1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // Parse complete number
            if (Character.isDigit(c)) {
                int value = 0;

                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    value = value * 10 + (s.charAt(i) - '0');
                    i++;
                }

                // If multiplication/division is pending, evaluate immediately
                if (!sts.isEmpty() && (sts.peek() == '*' || sts.peek() == '/')) {
                    int previous = st.pop();
                    char op = sts.pop();

                    if (op == '*') {
                        st.push(previous * value);
                    } else {
                        st.push(previous / value);
                    }
                } else {
                    // Push signed number
                    st.push(sign * value);
                    sign = 1;
                }

                i--;
            }

            // Next number should be negative
            else if (c == '-') {
                sign = -1;
            }

            // Store multiplication/division operators
            else if (c == '*' || c == '/') {
                sts.push(c);
                sign = 1;
            }

            // '+' and spaces require no processing
        }

        // Sum all remaining numbers
        int ans = 0;
        while (!st.isEmpty()) {
            ans += st.pop();
        }

        return ans;
    }
}
```