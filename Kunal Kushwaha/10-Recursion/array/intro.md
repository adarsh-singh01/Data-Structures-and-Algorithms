
### **“Arguments are preserved across recursive calls, but variables inside the function body are NOT preserved.”**

This is an extremely important recursion concept.
Here is the full explanation you can copy:

---

# ⭐ **DETAILED EXPLANATION**

In recursion, every time you call a function again, a **new copy** of the function is created.
This new copy of the function has **its own separate variables**, unless those variables were passed **as arguments**.

So:

---

# 🔵 1. **Arguments stay alive across recursive calls**

When you write a function like:

```
function myFun(a, b, c)
```

and you call:

```
myFun(a, b+1, c)
```

You are **passing the values into the next call**.

This means:

### ✔ The next call receives the updated values

### ✔ These values travel down every level of recursion

### ✔ They continue until you hit the base case

### ✔ They are remembered at every call because they live in the function’s parameter list

So **parameters = memory carried to the next call**.

---

# 🔵 2. **Variables inside the function body DO NOT carry over**

Example:

```
void fun(int n){
    int x = 5;   // local variable
    fun(n-1);
}
```

Here:

* `x = 5` exists **only for the current call**
* When the function calls itself again, the new call creates a **new and separate x**
* The previous x does **not** continue
* The next call does **not** remember or reuse x
* After the call ends, that x disappears

So:

### ❌ Local variables inside the function body DO NOT travel to the next call

### ❌ They are NOT remembered

### ❌ Each recursive call gets a FRESH new copy

---

# ⭐ **Simple Rule:**

### ✔ **If you want a value to be carried through recursion, you MUST pass it as a function argument.**

### ❌ **If you declare a variable inside the function, recursion will NOT remember it between calls.**

---

# ⭐ **3. Why arguments are preserved but local variables are not**

Every recursive call has:

### ✔ its own stack frame

This stack frame includes:

* the function arguments (the values passed to it)
* the local variables (declared inside it)

But:

### ✔ Arguments come from the *previous* call

So they are intentionally passed forward and preserved.

### ❌ Local variables are created fresh inside that stack frame

They are NOT passed into the next call unless you include them in the argument list.

---

# ⭐ **4. SIMPLE EXAMPLES**

## Example A — Passed as argument (value continues)

```
void count(int n){
    System.out.println(n);
    count(n+1);
}
```

Here:

* `n` changes
* the new value is passed to the next call
* recursion remembers it

You get: 1, 2, 3, 4, …

---

## Example B — Declared inside the function (value resets every time)

```
void count(){
    int n = 1;
    System.out.println(n);
    count();
}
```

Here:

* n is always reset to 1
* recursion DOES NOT remember previous n
* output: 1, 1, 1, 1, 1, …

Because the variable is **not passed forward**.

---

# ⭐ **5. REAL-WORLD ANALOGY**

Imagine recursion is like climbing stairs.

### Argument variables = things you carry in your backpack

You bring them up every step.
If you change them, the next step gets the new updated value.

### Local variables inside the function = objects placed on the current step

When you go to the next step:

* those objects stay behind
* you do NOT carry them with you
* they disappear for the next call

So:

### ✔ Only what you carry (arguments) moves forward

### ❌ What you leave on the floor (local variables) does not

---

# ⭐ **FINAL SUMMARY**

In recursion, any value that must continue into the next call must be passed as a function argument. Arguments are preserved in each recursive call because each call receives them as input. But any variable declared inside the function body exists only inside the current call’s stack frame and is lost when the function calls itself again. Therefore, arguments survive through recursion, but local variables do not.

---

