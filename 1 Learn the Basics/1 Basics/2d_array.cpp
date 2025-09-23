#include <iostream>
using namespace std;
int main() {
    //2D array declaration
    int arr[3][5]; //3 rows and 5 columns

    arr[1][2] = 10; //assigning value to 2nd row and 3rd column
    cout << arr[1][2] << endl; //printing value at 2nd row and 3rd column

    cout <<arr[2][3]; //printing garbage value because we have not assigned any value to it
    return 0;
}