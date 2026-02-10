#include <iostream>
#include <cmath>
using namespace std;

int main()
{
    int arr[1000001] = {
        0,
    };
    int m, n;
    int num = 2;
    cin >> m >> n;
    arr[0] = 1;
    arr[1] = 1;
    while (num <= sqrt(n))
    {
        for (int i = 2; i * num <= n; i++)
        {
            arr[num * i] = 1;
        }
        num++;
    }
    for (int i = m; i <= n; i++)
    {
        if (arr[i] == 0)
        {
            printf("%d\n", i);
        }
    }
    return 0;
}