//print name n times using recursion

#include <iostream>

using namespace std;

void printName(string name, int n) {
    if (n > 0) {
        cout << name << endl;
        printName(name, n - 1);
    }
}

int main() {
    int n;
    string name;
    cout << "Enter the name: ";
    cin >> name;
    cout << "Enter the number of times to print the name: ";
    cin >> n;
    printName(name, n);
    return 0;
}


/*

printName("Alice", 3)
│
├── prints: Alice
└── calls → printName("Alice", 2)
     │
     ├── prints: Alice
     └── calls → printName("Alice", 1)
          │
          ├── prints: Alice
          └── calls → printName("Alice", 0)
               └── terminates (n == 0)


Time Complexity	O(n)
Space Complexity O(n)

*/