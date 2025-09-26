#include <iostream>
using namespace std;
#include <vector>
#include <math.h>
#include <algorithm>

void allDivisors(int n) {
    /*
    
    for (int i=1; i<=n; i++) {
        if (n % i == 0) {
            cout << i << ", ";
        }
    }
    cout << endl;
    //time complexity : O(n)
    
    */

    vector<int> list;
    for(int i=1; i<=sqrt(n); i++) {//or write i*i<=n for efficiency as sqrt is a stl function which will take time
        if(n % i == 0) {
            list.push_back(i);
            if(i!=n/i) {
                list.push_back(n/i);
            }
        }
    }
    sort(list.begin(), list.end());
    for(auto it : list) cout << it << ", ";


    /*
Time complexity:
O(√n) - to find the divisors
O(k log k) - to sort the divisors, where k ≈ number of divisors = O(√n)
O(k) - to print them
⇒ Total = O(√n log n)

    */
}
int main(){
    int num;
    cout << "Enter a number: ";
    cin >> num;
    allDivisors(num);
}