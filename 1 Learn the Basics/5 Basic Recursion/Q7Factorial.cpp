#include <iostream>

using namespace std;

int fact(int n){
    if (n==0) return 1;
    return n*fact(n-1);
}

int main(){
    cout<<fact(4);
}

/*
fact(4)
= 4 * fact(3)
        ↓
    fact(3)
    = 3 * fact(2)
            ↓
        fact(2)
        = 2 * fact(1)
                ↓
            fact(1)
            = 1 * fact(0)
                    ↓
                fact(0)
                = 1   ← base case

fact(0) = 1
→ fact(1) = 1 * 1 = 1
→ fact(2) = 2 * 1 = 2
→ fact(3) = 3 * 2 = 6
→ fact(4) = 4 * 6 = 24


*/