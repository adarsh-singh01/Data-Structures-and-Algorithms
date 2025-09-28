#include <iostream>  // For input and output operations

using namespace std;

int main(){
    string s;
    cin >> s;  // Read a string from user input

    /*
        Step 1: Precompute frequency of each character in the string.
        We use a fixed-size integer array 'hash' of size 256 to represent
        all possible ASCII characters (0 to 255). This allows us to count
        how many times each character appears in the string.
        
        For example:
        If the input string is "apple", then:
        hash['a'] = 1
        hash['p'] = 2
        hash['l'] = 1
        hash['e'] = 1
    */

    int hash[256] = {0};  // Initialize all elements to 0

    // Loop through each character of the input string
    for (int i = 0; i < s.size(); i++){
        hash[s[i]]++;  // Increment the count of the current character
    }

    /*
        Step 2: Process queries.
        The user provides a number of queries (q), and for each query,
        a character is given. For each character, we print how many
        times it appeared in the original string using our precomputed 'hash' array.
        
        This is efficient because instead of counting each time from the string,
        we directly access the stored frequency in constant time O(1).
    */

    int q;
    cin >> q;  // Read the number of queries

    while(q--){  // Loop q times
        char ch;
        cin >> ch;  // Read the character to be queried

        cout << hash[ch] << endl;  // Output the frequency of the queried character
    }
}



/*

#include <iostream>
using namespace std;

int main() {
    string s = "apple";
    int hash[26] = {0};

    for (char ch : s) {
        hash[ch - 'a']++;  // Map 'a'-'z' to 0-25
    }

    cout << "Count of 'p': " << hash['p' - 'a'] << endl;  // Output: 2
    cout << "Count of 'a': " << hash['a' - 'a'] << endl;  // Output: 1
}


there is no upperlimit for charcters as atmost there are 256...not crazy nums like 10^7

*/