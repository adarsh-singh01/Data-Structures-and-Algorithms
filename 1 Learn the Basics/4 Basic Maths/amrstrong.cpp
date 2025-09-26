// ARMSTRONG Numbers are numbers that equal the sum of the cubes of their digits. EX:391=3^3 + 9^3 + 1^3
#include <iostream>

using namespace std;

int main() {
    int n;
    cout << "Enter the number: ";
    cin >> n;
    int duplicate = n;//is used to save the original input because the while loop destroys n by dividing it down to 0.

    int sum = 0;
    while(n>0){
        int ld=n%10;
        sum = sum + ld*ld*ld;
        n = n/10;   
    }
    if (sum == duplicate) cout << "The number is a amrstrong." << endl;
    else cout << "The number is not a armstrong." << endl;
    return 0;
}


