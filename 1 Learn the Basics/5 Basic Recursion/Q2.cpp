//PRINT LINEARLY FROM 1 TO N

#include <iostream>

using namespace std;

void Count(int n){
    if(n>0){
        Count(n-1);
        cout<<n <<endl;//So by moving the cout to after the recursive call, you're telling it: "Wait until you're at the bottom of the stack — then start printing on the way back."
    }
}

int main(){
    int c;
    cout<<"Upto which no. should i count : ";
    cin >> c;
    Count(c);
}

/*

Count(3)
└── Count(2)
     └── Count(1)
          └── Count(0)
               └── base case: stops
          └── prints: 1
     └── prints: 2
└── prints: 3


*/

/*

void Count(int i, int N) {
    if (i > N) return;        // base condition
    cout << i << endl;        // print before going deeper
    Count(i + 1, N);          // move to next number
}

int main() {
    int N;
    cout << "Enter N: ";
    cin >> N;
    Count(1, N);  // start from 1
    return 0;
}


Count(1, 3)
├── prints: 1
└── Count(2, 3)
     ├── prints: 2
     └── Count(3, 3)
          ├── prints: 3
          └── Count(4, 3)
               └── Base case hit → return


*/