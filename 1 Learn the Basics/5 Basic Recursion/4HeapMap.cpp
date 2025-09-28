#include <iostream>
#include <map>  // For using std::map to store frequency

using namespace std;

int main() {
    int n;
    cin >> n;  // Read the number of elements

    int arr[n];  // ⚠️ Variable Length Array (VLA) — not standard in C++

    // Read array elements
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    /*
        PRE-COMPUTE PHASE:
        Use a map to count frequency of each number.
        map<int, int> mpp;
        - Key: number from the array
        - Value: frequency of that number
        Maps store keys in sorted order by default.
    */
    map<int, int> mpp;//u can also use unordered_map for better performance...worst case rarely happens.

    for (int i = 0; i < n; i++) {
        mpp[arr[i]]++;  // Increment frequency of arr[i]
    }

    /*
        Display the frequency map.
        This will print all unique elements and their frequency,
        in ascending order of the element (because std::map is ordered).
    */
    for (auto x : mpp) {
        cout << x.first << " --> " << x.second << endl;
    }

    int q;
    cin >> q;  // Number of queries

    while (q--) {
        int target;
        cin >> target;  // Number to query

        // FETCH: Print how many times 'target' appeared in the array
        // If target not found, map returns 0 by default
        cout << mpp[target] << endl;
    }

    return 0;
}


/*
hashing  using division method,folding method,mid square method etc.

if someone says that max array size is 10 or something like that then 
we'll learn divison method
linear chaining
whats collision?
why its rare in unordered_map?

*/
