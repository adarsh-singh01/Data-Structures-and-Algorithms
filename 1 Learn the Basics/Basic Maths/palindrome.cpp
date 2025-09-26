#include <iostream>

using namespace std;

int main() {
    int n;
    cout << "Enter the number: ";
    cin >> n;
    int duplicate = n;//is used to save the original input because the while loop destroys n by dividing it down to 0.

    int revNumber = 0;
    while(n>0){
        int ld=n%10;
        revNumber = (revNumber*10) +ld;
        n = n/10;   
    }
    if (revNumber == duplicate) cout << "The number is a palindrome." << endl;
    else cout << "The number is not a palindrome." << endl;
    return 0;
}

