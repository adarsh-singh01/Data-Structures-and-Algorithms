#include <iostream>
#include <vector>
using namespace std;
//#include <vector> //for vector

void explainVector()//a vector is a dynamic array...it can grow and shrink in size
{
    vector<int> v; //vector of zero length..its a empty container
    v.push_back(1); //{1}
    v.emplace_back(2); //{1,2}

    cout << "Vector at 1: " << v[1] << endl; //2
    cout << "Vector at 0: " << v.at(0) << endl; //1

    cout << "Front: " << v.front() << endl; //1
    cout << "Back: " << v.back() << endl; //2

    cout << "Size: " << v.size() << endl; //2

    v.pop_back(); //removes last element {1}
    cout << "Size after pop: " << v.size() << endl; //1

    //Iterating over the vector
    cout << "Vector elements: ";
    for (int i = 0; i < v.size(); i++)
    {
        cout << v[i] << " ";
    }
    cout << endl;

    //Using iterators
    cout << "Using iterators: ";
    for (auto it = v.begin(); it != v.end(); it++)
    {
        cout << *it << " ";
    }
    cout << endl;

    //Using for each loop
    cout << "Using for each loop: ";
    for (int value : v)
    {
        cout << value << " ";
    }
    cout << endl;

    //2D Vector
    vector<vector<int>> vec2d;
    vec2d.push_back({1, 2});
    vec2d.emplace_back(vector<int>{3, 4});

    cout << "2D Vector elements: ";
    for (const auto &row : vec2d)
    {
        for (int elem : row)
        {
            cout << elem << " ";
        }
        cout << "| ";
    }
    cout << endl;
}

int main()
{
    explainVector();
    return 0;
}