#include <iostream>
#include <unordered_map>
#include <vector>
#include <climits>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;

    vector<int> arr(n);
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    unordered_map<int, int> freq;
    for (int i = 0; i < n; i++) {
        freq[arr[i]]++;
    }

    for (auto x : freq) {
        cout << x.first << " --> " << x.second << endl;
    }

    // Find highest and lowest frequency elements
    int maxFreq = 0, minFreq = INT_MAX;
    int mostFreqElement = -1, leastFreqElement = -1;

    for (auto &entry : freq) {
        if (entry.second > maxFreq) {
            maxFreq = entry.second;
            mostFreqElement = entry.first;
        }
        if (entry.second < minFreq) {
            minFreq = entry.second;
            leastFreqElement = entry.first;
        }
    }

    cout << "Most frequent element: " << mostFreqElement << " (Frequency: " << maxFreq << ")\n";
    cout << "Least frequent element: " << leastFreqElement << " (Frequency: " << minFreq << ")\n";

    // Query phase: until EOF
    int target;
    while (cin >> target) {
        cout << freq[target] << endl;
    }

    return 0;
}
