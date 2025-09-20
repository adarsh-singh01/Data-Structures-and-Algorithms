
/*
WHAT IS TIME COMPLEXITY?

First of all,it is not the time taken by the program to execute. bcoz time taken by the program to execute depends on various factors like processor speed,ram etc.
it is the rate of increase in time taken by the program to execute with respect to increase in input size.
it is commonly denoted by big Oh notation.
eg: O(n),O(log n),O(n^2) etc.

find the time complexity of the following code:

for{i=1;i<=5;i++}
    cout<<"hello";
    }
    here the first step is assigning,second step is comparison,third step is incrementing and fourth step is printing.
    so total 4 steps are there and these steps are constant and do not depend on the input size.
    we always find the time complexity for the worst case scenario,and we avoid constant factors,and also we avoid lower order terms.

    we can say that for every 5 iterations it does incrementing and comparison 5 times each and printing 5 times.
    which is 5*3=15 steps. we say that its time complexity is O(15) which is a number and we generally do not represent time complexity in terms of numbers.
    so we avoid constant factors and say that the time complexity is O(1) or constant

    now consider the following code:
for(i=1;i<=n;i++)
    cout<<"hello";
}

    we can say that for every n iterations it does incrementing and comparison n times each and printing n times.
    which is n*3=3n steps. we say that its time complexity is O(3n) which is a number multiplied by a variable and we generally do not represent time complexity in terms of numbers.
    so we avoid constant factors and say that the time complexity is O(n) or linear

    Apart from Big O notation[Upper Bound] there are other notations like Big Omega and Big Theta.
    Big Omega is used to represent the best case scenario.[Lower Bound]
    Big Theta is used to represent the average case scenario.

    NOW consider the following code:
for(i=1;i<=n;i++){
    for(j=1;j<=n;j++){
        cout<<"hello";
    }
}
    here we have nested loops. so we can say that for every n iterations of outer loop it does n iterations of inner loop.
    so total number of iterations will be n*n=n^2. so the time complexity will be O(n^2) or quadratic.

    NOW consider the following code:
for(i=0;i<=n;i++){
    for(j=0;j<=i;j++){
       cout<<"hello";
    }
}
    here we have nested loops. so we can say that for every n iterations of outer loop it does i iterations of inner loop.
    so total number of iterations will be 1+2+3+...+n=n(n+1)/2 which is O(n^2/2) which can be simplified to O(n^2).



    WHAT IS SPACE COMPLEXITY?
    it is the amount of memory space required by the program to execute with respect to increase in input size.
    it is commonly denoted by big Oh notation.

    SPACE COMPLEXITY = AUXILIARY SPACE + INPUT SPACE
    AUXILIARY SPACE: it is the extra space or temporary space used by the algorithm.
    INPUT SPACE: it is the space used by the input.

    A lamen example of space complexity is c=a+b;
    c is the auxiliary space used by the algorithm. a and b are the input space used by the algorithm.
    so the space complexity of this code is O(1) or constant.


    One thing to highlight is that if u say someone to do add of some two numbers. they'll say b=a+b; i will not be using any third variable.
    but if u say this to a interviewer. they'll not find it good answer. because in this case u are overwriting the value of b.
*/ 