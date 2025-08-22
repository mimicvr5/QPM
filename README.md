# Q+-

Welcome to **Q+-** – a custom programming language built entirely in Java.  
Q+- uses a familiar syntax inspired by Java and Python, with its own unique twists.  
All source files use the `.qpm` extension.

<img src="./qpmlogo.png" width="200" alt="Q+- Logo">

---

## Features (so far)

- **Simple Syntax** – easy to read and write.
- **Object-Oriented** – supports classes, functions, variables, and loops.
- **Custom File Extension** – `.qpm` for all Q+- programs.
- **Made for Fun** – lightweight, experimental, and open for future expansion.

---

## Syntax Guide

### Entry Point
Every Q+- program begins in a `main` function with return type `none`:

```qpm
public none main() {
    print("Hello, Q+-!");
}
```

---

#### Variables
```qpm
public final int maxCount = 10;
private change string message = "Hello, Q+-!";
```

#### Functions
```qpm
public int add(int a, int b) {
    return a + b;
}

private void greet(string name) {
    print("Hello, " + name);
}
```

#### Loops

**Array Iteration**
```qpm
for (i, fruit) in pairs(fruits) {
    print("Index: " + i);
}
```

**Range Iteration**
```qpm
for (i) in range(5) {
    print("i = " + i);
}
```

**While Loop**
```qpm
int counter = 0;

while (counter < 5) {
    print("Counter = " + counter);
    counter = counter + 1;
}
```

#### Classes
```qpm
public class Person {
    private final string name;
    private change int age;

    public Person(string name, int age) {
        this.name = name;
        this.age = age;
    }

    public void birthday() {
        age = age + 1;
        print(name + " is now " + age);
    }
}
```

#### Imports & Packages
```qpm
package com.example;

import utils.MathHelper;

public none main() {
    int result = MathHelper.square(5);
    print("Result = " + result);
}
```

---

## Projects Goals

Q+- is just a personal side project - made for fun, experimentation, and learning. <br>
That said, here are some possible future plans:

- A dedicated IDE for `.qpm` files
- A build-in graphics library
- More built-in libraries for math, I/O, and beyond
- Improved tooling (compiler, interpreter, VS Code / IntelliJ support)

---

## Why?

Because why not? <br>
Programming languages are fun to make, and Q+- is my playground for trying new ideas.