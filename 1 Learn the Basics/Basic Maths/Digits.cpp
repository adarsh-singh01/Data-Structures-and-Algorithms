/*

Extraction of Digits:

if we are given n=7789 then

WE KNOW that  % gives us the remainder

n % 10 gives us the last digit which is 9

n = n / 10 gives us the number without the last digit which is 778

n % 10 gives us the second last digit which is 8

n = n / 10 gives us the number without the second last digit which is 77

n % 10 gives us the third last digit which is 7

n = n / 10 gives us the number without the third last digit which is 7

n % 10 gives us the fourth last digit which is 0

PSEUDOCODE:
WHILE n > 0
    digit = n % 10
    n = n / 10
    print digit



*/