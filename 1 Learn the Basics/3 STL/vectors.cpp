#include <iostream>
#include <vector>
#include <list>
#include <deque>
#include <stack>
#include <queue>
#include <set>
#include <unordered_set>
#include <map>
#include <unordered_map>
#include <algorithm>

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


    void explainStack()
    {
        // Stack is a LIFO data structure...there is no indexing in stack as such because of its LIFO nature...its complexity is O(1)...every operation takes constant time
        stack<int> s;
        s.push(1); // {1}
        s.push(2); // {1, 2}
        s.emplace(3); // {1, 2, 3}

        cout << "Top: " << s.top() << endl; // 3
        cout << "Size: " << s.size() << endl; // 3

        s.pop(); // removes top element (3)
        cout << "New Top: " << s.top() << endl; // 2

        cout << "Is stack empty? " << s.empty() << endl; // 0 (false)
    }

    void explainQueue()
    {
        // Queue is a FIFO data structure...there is no indexing in queue as such because of its FIFO nature...its complexity is O(1)...every operation takes constant time
        queue<int> q;
        q.push(1); // {1}
        q.push(2); // {1, 2}
        q.emplace(3); // {1, 2, 3}

        cout << "Front: " << q.front() << endl; // 1
        cout << "Back: " << q.back() << endl;   // 3
        cout << "Size: " << q.size() << endl;   // 3

        q.pop(); // removes front element (1)
        cout << "New Front: " << q.front() << endl; // 2

        cout << "Is queue empty? " << q.empty() << endl; // 0 (false)
    }


    void explainPriorityQueue()
    {
        // Priority Queue is a special type of queue where elements are ordered based on their priority...by default, it is a max-heap
        priority_queue<int> pq; // Max-Heap
        pq.push(5); // {5}
        pq.push(1); // {5, 1}
        pq.push(10); // {10, 5, 1}

        cout << "Top (Max): " << pq.top() << endl; // 10
        cout << "Size: " << pq.size() << endl; // 3

        pq.pop(); // removes top element (10)
        cout << "New Top (Max): " << pq.top() << endl; // 5

        cout << "Is priority queue empty? " << pq.empty() << endl; // 0 (false)

        // Min-Heap
        priority_queue<int, vector<int>, greater<int>> minHeap;
        minHeap.push(5); // {5}
        minHeap.push(1); // {1, 5}
        minHeap.push(10); // {1, 5, 10}

        cout << "Top (Min): " << minHeap.top() << endl; // 1

        /*
        Time Complexities:
        push(): O(log n)
        pop(): O(log n)
        top(): O(1)
        */
    }


    void explainSet()
    {
        // Set is a collection of unique elements stored in a specific order (by default, ascending order)...just remember two words "unique" and "sorted"
        set<int> st;
        st.insert(5); // {5}
        st.insert(1); // {1, 5}
        st.insert(10); // {1, 5, 10}
        st.insert(5); // {1, 5, 10} (duplicate, will not be added)

        //functionality of insert in vector can be used also,that only increases efficiency

        cout << "Size: " << st.size() << endl; // 3
        cout << "Is 5 present? " << st.count(5) << endl; // 1 (true)
        cout << "Is 7 present? " << st.count(7) << endl; // 0 (false)

        st.erase(5); // {1, 10}
        cout << "New Size after erasing 5: " << st.size() << endl; // 2

        for (auto it : st)
        {
            cout << it << " "; // prints all elements in ascending order
        }

        // Lower Bound and Upper Bound:
        // lower_bound(x) returns an iterator to the first element >= x
        // upper_bound(x) returns an iterator to the first element > x

        // for set, lower_bound() and upper_bound() work like in vectors
        auto it = st.lower_bound(2); // points to first element >= 2 (which is 10)
        if (it != st.end())
            cout << "\nLower Bound of 2: " << *it << endl;

        it = st.upper_bound(1); // points to first element > 1 (which is 10)
        if (it != st.end())
            cout << "Upper Bound of 1: " << *it << endl;

        /*
        Time Complexities:
        insert(): O(log n)
        erase(): O(log n)
        find(): O(log n)
        count(): O(log n)

        PS: All operations are logarithmic in time complexity because sets are typically implemented as balanced binary search trees
        */
    }


    void explainMultiSet()
    {
        // Multiset is similar to set but allows duplicate elements
        multiset<int> ms;
        ms.insert(5); // {5}
        ms.insert(1); // {1, 5}
        ms.insert(10); // {1, 5, 10}
        ms.insert(5); // {1, 5, 5, 10} (duplicate allowed)

        cout << "Size: " << ms.size() << endl; // 4
        cout << "Count of 5: " << ms.count(5) << endl; // 2

        ms.erase(5); // removes all occurrences of 5
        cout << "New Size after erasing 5: " << ms.size() << endl; // 2

        for (auto it : ms)
        {
            cout << it << " "; // prints all elements in ascending order
        }

        /*
        Time Complexities:
        insert(): O(log n)
        erase(): O(log n) for single element, O(n) for all occurrences
        find(): O(log n)
        count(): O(log n)

        PS: All operations are logarithmic in time complexity because multisets are typically implemented as balanced binary search trees*/
    }


    void explainUnorderedSet()
    {
        // Unordered Set is a collection of unique elements stored in no particular order...it provides average O(1) time complexity for insert, erase, and find operations
        unordered_set<int> us;
        us.insert(5); // {5}
        us.insert(1); // {1, 5}
        us.insert(10); // {1, 5, 10}
        us.insert(5); // {1, 5, 10} (duplicate, will not be added)

        cout << "Size: " << us.size() << endl; // 3
        cout << "Is 5 present? " << us.count(5) << endl; // 1 (true)
        cout << "Is 7 present? " << us.count(7) << endl; // 0 (false)

        us.erase(5); // {1, 10}
        cout << "New Size after erasing 5: " << us.size() << endl; // 2

        for (auto it : us)
        {
            cout << it << " "; // prints all elements in no particular order
        }

        /*
        Time Complexities:
        insert(): O(1) on average
        erase(): O(1) on average
        find(): O(1) on average
        count(): O(1) on average

        it happens one in a million times that it takes O(n) time in case of collision but that is very rare

        PS: All operations are constant time on average because unordered sets are typically implemented using hash tables

        NOTE: all functionalities of set can be used here also but upper_bound and lower_bound cannot be used here because there is no specific order in unordered set
        */
    }

    void explainMap()
    {
        // Map is a collection of key-value pairs where keys are unique and sorted by default in ascending order
        map<int, string> m;
        m[1] = "One";
        m[2] = "Two";
        m[3] = "Three";

        m.insert({4, "Four"});
        m.emplace(5, "Five");

        cout << "Size: " << m.size() << endl; // 5
        cout << "Value for key 3: " << m[3] << endl; // Three
        cout << "Value for key 6: " << m[6] << endl; // "" (default value, key 6 is created)

        m.erase(2); // removes key 2

        cout << "Is key 2 present? " << m.count(2) << endl; // 0 (false)
        cout << "Is key 3 present? " << m.count(3) << endl; // 1 (true)

        for (auto it : m)
        {
            cout << it.first << ": " << it.second << endl; // prints all key-value pairs in ascending order of keys
        }

        // Lower Bound and Upper Bound:
        // lower_bound(x) returns an iterator to the first key >= x
        // upper_bound(x) returns an iterator to the first key > x

        auto it = m.lower_bound(3); // points to first key >= 3
        if (it != m.end())
            cout << "Lower Bound of 3: " << it->first << ": " << it->second << endl;

        it = m.upper_bound(3); // points to first key > 3
        if (it != m.end())
            cout << "Upper Bound of 3: " << it->first << ": " << it->second << endl;

        /*
        Time Complexities:
        insert(): O(log n)
        erase(): O(log n)
        find(): O(log n)
        count(): O(log n)

        PS: All operations are logarithmic in time complexity because maps are typically implemented as balanced binary search trees
        */
    }

    void explainMultiMap()
    {
        // Multimap is similar to map but allows duplicate keys
        //here map[key] cannot be used because it will return only one value for that key
        multimap<int, string> mm;
        mm.insert({1, "One"});
        mm.insert({2, "Two"});
        mm.insert({1, "Uno"}); // duplicate key allowed

        cout << "Size: " << mm.size() << endl; // 3

        cout << "Count of key 1: " << mm.count(1) << endl; // 2

        mm.erase(2); // removes all occurrences of key 2

        cout << "Is key 2 present? " << mm.count(2) << endl; // 0 (false)

        for (auto it : mm)
        {
            cout << it.first << ": " << it.second << endl; // prints all key-value pairs in ascending order of keys
        }

        /*
        Time Complexities:
        insert(): O(log n)
        erase(): O(log n) for single key, O(n) for all occurrences
        find(): O(log n)
        count(): O(log n)

        PS: All operations are logarithmic in time complexity because multimaps are typically implemented as balanced binary search trees
        */
    }

    void explainUnorderedMap()
    {
        // Unordered Map is a collection of key-value pairs where keys are unique and stored in no particular order...it provides average O(1) time complexity for insert, erase, and find operations
        unordered_map<int, string> um;
        um[1] = "One";
        um[2] = "Two";
        um[3] = "Three";

        um.insert({4, "Four"});
        um.emplace(5, "Five");

        cout << "Size: " << um.size() << endl; // 5
        cout << "Value for key 3: " << um[3] << endl; // Three
        cout << "Value for key 6: " << um[6] << endl; // "" (default value, key 6 is created)

        um.erase(2); // removes key 2

        cout << "Is key 2 present? " << um.count(2) << endl; // 0 (false)
        cout << "Is key 3 present? " << um.count(3) << endl; // 1 (true)

        for (auto it : um)
        {
            cout << it.first << ": " << it.second << endl; // prints all key-value pairs in no particular order
        }

        /*
        Time Complexities:
        insert(): O(1) on average
        erase(): O(1) on average
        find(): O(1) on average
        count(): O(1) on average

        it happens once in a blue moon that it takes O(n) time in case of collision but that is very rare

        PS: All operations are constant time on average because unordered maps are typically implemented using hash tables

        NOTE: all functionalities of map can be used here also but upper_bound and lower_bound cannot be used here because there is no specific order in unordered map
        */
    }



int main()
{
    explainVector();
    explainList();
    explainDeque();
    explainStack();
    explainQueue();
    explainPriorityQueue();
    explainSet();
    explainMultiSet();
    explainUnorderedSet();
    explainMap();
    explainMultiMap();
    explainUnorderedMap();
    
    return 0;
}