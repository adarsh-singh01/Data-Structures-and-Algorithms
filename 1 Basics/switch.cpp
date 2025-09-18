#include <iostream>
using namespace std;
int main(){
    int day;
    cout << "Enter day (1-7): ";
    cin >> day;

    switch(day)//switch case is used when we have multiple conditions based on single variable
    {
        case 1:
            cout << "Monday";
            break;//break is used to exit the switch case otherwise it will continue to next case
        case 2:
            cout << "Tuesday";
            break;
        case 3:
            cout << "Wednesday";
            break;
        case 4:
            cout << "Thursday";
            break;
        case 5:
            cout << "Friday";
            break;
        case 6:
            cout << "Saturday";
            break;
        case 7:
            cout << "Sunday";
            break;
        default:
            cout << "Invalid day!";
            break;
            cout<<"hello"; //this will never execute because its after break
    }
    cout<<"check kr rha hu"; //this will execute because its outside switch case
    return 0;
}