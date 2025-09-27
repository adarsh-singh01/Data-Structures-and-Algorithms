//PRINT LINEARLY FROM n TO 1

#include <iostream>

using namespace std;

void Count(int n){
    if(n>0){

        cout<<n<<endl;
        Count(n-1);
        
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
├── prints: 3
└── Count(2)
     ├── prints: 2
     └── Count(1)
          ├── prints: 1
          └── Count(0)
               └── base case: stops

*/