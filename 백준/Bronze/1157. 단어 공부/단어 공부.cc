#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main()
{
    int arr[130] = {
        0,
    };
    string s;
    char result;
    int max = 0;

    cin >> s;
    int length = s.length();
    for (int i = 0; i < length; i++)
    {
        if (s[i] >= 97 && s[i] <= 122)
        {
            arr[s[i] - 32]++;
        }
        else
        {
            arr[s[i]]++;
        }
    }
    for (int i = 0; i < 130; i++)
    {
        if (arr[i] > arr[max])
        {
            max = i;
        }
    }
    result = max;
    sort(arr, arr + 130);
    if (arr[129] == arr[128])
    {
        result = '?';
    }
    cout << result;

    return 0;
}