//Pairs

#include <iostream>

using namespace std;
//#include <utility> //for pair

void explainPair()
{
    pair<int, int> p = {1, 3};//or pair<int,int> p(1,3);
    cout << p.first << " " << p.second << endl;

    pair<int, pair<int, int>> p1 = {1, {3, 4}};
    cout << p1.first << " " << p1.second.first << " " << p1.second.second << endl;

    pair<int, int> arr[] = {{1, 2}, {3, 4}, {5, 6}};
    cout << arr[1].second << endl;
}

int main()
{
    explainPair();
    return 0;
}