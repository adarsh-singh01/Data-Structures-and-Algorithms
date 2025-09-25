#include <iostream>
#include <vector>
#include <list>
#include <deque>

using namespace std;

void explainVector()//a vector is a dynamic array that can resize itself automatically when an element is added or removed.
{
    vector<int> v; // empty vector
    v.push_back(1); // {1}
    v.emplace_back(2); // {1, 2}

    vector<pair<int, int>> vec; // vector of pairs
    vec.push_back({1, 2});
    vec.emplace_back(3, 4);

    vector<int> v1(5, 100); // {100, 100, 100, 100, 100}
    vector<int> v2(v1);     // copy of v1
    vector<int> v3(5);      // {0, 0, 0, 0, 0}

    cout << "Vector at 1: " << v[1] << endl;       // 2
    cout << "Vector at 0: " << v.at(0) << endl;    // 1
    cout << "Front: " << v.front() << endl;        // 1
    cout << "Back: " << v.back() << endl;          // 2
    cout << "Size: " << v.size() << endl;          // 2

    v.pop_back(); // removes 2
    cout << "Size after pop: " << v.size() << endl; // 1

    // -----------------------------
    // ITERATORS :iterators are used to point to the memory addresses of STL containers.
    // -----------------------------

    vector<int> w = {10, 20, 30, 40, 50};

    // 'it' is a normal iterator to the first element
    auto it = w.begin(); // same as: vector<int>::iterator it = w.begin();
    cout << "First element: " << *it << endl; // 10
    it++; // moves to second element

    // 'it2' points to one-past-the-last element (should not be dereferenced)
    auto it2 = w.end(); // same as: vector<int>::iterator

    // 'it3' is a reverse iterator pointing BEFORE the first element
    auto it3 = w.rend(); // same as: vector<int>::reverse_iterator

    // 'it4' is a reverse iterator pointing to the LAST element
    auto it4 = w.rbegin(); // same as: vector<int>::reverse_iterator

    cout << "Last element using reverse iterator: " << *it4 << endl; // 50


    cout<<w.back()<<endl; // 10
    cout<<w.front()<<endl; // 50

    for (vector<int>::iterator it = w.begin(); it != w.end(); it++)
    {
        cout << *it << " "; // prints all elements
    }

    for (auto it = w.begin(); it != w.end(); it++)//auto is used to automatically deduce the type of the iterator
    {
        cout << *it << " "; // prints all elements
    }

    for (auto it : w) // range-based for loop
    {
        cout << it << " "; // prints all elements
    }

    //ERASE
    w.erase(w.begin() + 1); // removes second element (20)

    w.erase(w.begin() + 2, w.begin() + 4); // removes elements at index 2 and 3 (30, 40)

    //INSERT
    vector<int> x(2, 100); // {100, 100}
    x.insert(x.begin(), 300); // {300, 100, 100}
    x.insert(x.begin() + 1, 2, 10); // {300, 10, 10, 100, 100}
    vector<int> copy(2, 50); // {50, 50}
    x.insert(x.begin(), copy.begin(), copy.end()); // {50, 50, 300, 10, 10, 100, 100}

    vector<int> z1 = {10,20};
    cout <<z1.size(); // 2

    //z1.pop_back(); // removes last element

    //z1-->{10,20}
    //z2-->{30,40}

    /*
    z1.swap(z2); // swaps contents of z1 and z2
    z1.clear(); // clears all elements from z1

    cout << z1.empty(); // checks if z1 is empty
    */
    
}


void explainList(){//a list is a doubly linked list that allows efficient insertion and deletion of elements from both ends and from the middle.
 // LIST
    list <int> l;
    l.push_back(1); // {1}
    l.push_front(2); // {2, 1}
    l.emplace_back(3); // {2, 1, 3}
    l.emplace_front(4); // {4, 2, 1, 3}
    l.pop_back(); // {4, 2, 1}

    //Rest of the operations are same as vector
    //begin(), end(), rbegin(), rend(), insert(), erase(), size(), clear(), empty()
}

void explainDeque()
    {
        deque<int> d;
        d.push_back(1); // {1}
        d.push_front(2); // {2, 1}
        d.emplace_back(3); // {2, 1, 3}
        d.emplace_front(4); // {4, 2, 1, 3}
        d.pop_back(); // {4, 2, 1}
        d.pop_front(); // {2, 1}

        cout << "Front: " << d.front() << endl; // 2
        cout << "Back: " << d.back() << endl;   // 1
        cout << "Size: " << d.size() << endl;   // 2

       // Rest of the operations are same as vector
       // begin(), end(), rbegin(), rend(), insert(), erase(), size(), clear(), empty()
    }

int main()
{
    explainVector();
    explainList();
    explainDeque();
    return 0;
}