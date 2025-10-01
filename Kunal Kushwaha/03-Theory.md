

## 🧠 What is a Flowchart?

A **flowchart** is a visual diagram that represents the **step-by-step flow of a process or algorithm**. It's widely used in software design, systems analysis, and process modeling to describe **logic before coding**.

---

## 🔣 Common Flowchart Symbols

| Symbol              | Meaning                        | Description                              |
| ------------------- | ------------------------------ | ---------------------------------------- |
| 🔷 **Terminator**   | Start / End                    | Marks the entry or exit of the flowchart |
| 🔺 **Input/Output** | Input / Output Operations      | Like `Read a` or `Display result`        |
| ◼ **Process**       | Processing Step (Action)       | e.g., `sum = a + b`                      |
| 🔁 **Decision**     | Yes/No or True/False condition | e.g., `Is x divisible by y?`             |
| ➡️ **Arrow**        | Flowline                       | Shows the direction of flow              |

---

## 📝 Pseudocode — What is it?

**Pseudocode** is a way to write **logic in plain English** (or near-code style) that’s easy to read. It’s not executed by computers but helps you structure code before writing real syntax.

Example:

```plaintext
START
SET sum = 0
FOR i = 1 to 5
    sum = sum + i
END FOR
PRINT sum
END
```

---

## 🔍 Prime Number Finder — Explained

### 🔸 What is a prime number?

A number is **prime** if:

* It is greater than 1
* It is **only divisible by 1 and itself**
* Example: 2, 3, 5, 7, 11...

---

## 📘 Pseudocode for Prime Number Checker

We'll write a simple version:
👉 Given a number `n`, check if it's prime.

```plaintext
START
INPUT n
IF n <= 1 THEN
    PRINT "Not Prime"
    EXIT
END IF

SET isPrime = true

FOR i = 2 TO n - 1
    IF n MOD i == 0 THEN
        SET isPrime = false
        BREAK
    END IF
END FOR

IF isPrime == true THEN
    PRINT "Prime"
ELSE
    PRINT "Not Prime"
END IF
END
```

---

## 🔁 Flowchart for Prime Number Checker

Here's the structure:

1. Start
2. Input number `n`
3. Check if `n <= 1` → Not Prime
4. Loop from `i = 2` to `n-1`:

   * Check if `n % i == 0`
   * If true → Not Prime
5. If loop ends without finding any divisor → Prime
6. End

---

### 🔽 Flowchart Description (Text-Based Format)

```
[Start]
   |
[Input n]
   |
[Is n <= 1?] --Yes--> [Print "Not Prime"] --> [End]
        |
       No
        |
[Set isPrime = true, i = 2]
        |
[Is i < n?] --No--> [Print "Prime"] --> [End]
       |
      Yes
        |
[Is n % i == 0?] --Yes--> [Print "Not Prime"] --> [End]
       |
      No
       |
[Increment i by 1]
       |
[Back to Is i < n?]
```

---

## 🧩 Optional: Optimization (Math Fact)

Instead of checking all numbers from `2` to `n-1`, you can optimize by looping up to `sqrt(n)`:

```plaintext
START
INPUT n

IF n <= 1 THEN
    PRINT "Not Prime"
    END
END IF

SET isPrime = true
SET i = 2

WHILE i <= √n DO
    IF n MOD i == 0 THEN
        SET isPrime = false
        BREAK
    END IF
    INCREMENT i by 1
END WHILE

IF isPrime == true THEN
    PRINT "Prime"
ELSE
    PRINT "Not Prime"
END IF

END
```

Because any non-prime number must have a factor less than or equal to its square root.

---

## ✅ Summary

| Concept         | Key Info                                         |
| --------------- | ------------------------------------------------ |
| **Flowchart**   | Visual step-by-step process diagram              |
| **Symbols**     | Start/End, Process, Decision, Input/Output       |
| **Pseudocode**  | Structured, human-readable steps                 |
| **Prime logic** | Loop to check divisibility from 2 to n-1 (or √n) |

---
