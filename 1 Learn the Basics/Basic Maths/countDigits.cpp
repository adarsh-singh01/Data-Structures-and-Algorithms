#include <iostream>
#include <cmath>

using namespace std;

int count(int n){
/*    int count=0;
    while(n>0){
        //int intDigit=n%10;
        count++;
        n=n/10; 
    }
    return count;

    //Time Complexity: O(log10n)

*/

int cnt=(int)log10(n)+1;
return cnt;


}

int main(){
    int n;
    cout<<"Enter a number: ";
    cin>>n;
    cout<<"Number of digits: "<<count(n);
    return 0;
}