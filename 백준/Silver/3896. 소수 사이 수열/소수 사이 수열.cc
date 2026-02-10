#include <iostream>
#include <math.h>
using namespace std;
char arr[1299710];
int main() {
	int num;
	int n;
	int count = 0;
	cin >> n;
	arr[1] = 1;
	for (int i = 2; i < 1299710; i++) {
		arr[i] = 1;
	}
	for (int n = 2; n <= floor(sqrt(1299710)); n++)
	{
		if (!arr[n])
		{
			continue;
		}
		for (int mult = 2; n * mult <= 1299710; mult++) {
			arr[n * mult] = 0;
		}
	}
	
	for (int i = 0; i < n ; i++)
	{
		cin >> num;
		int temp = num;
		if (arr[num]) {
			cout << "0" << endl;
		}
		else {
			while (arr[num]==0)
			{
				num -= 1;
				count += 1;
			}
			while (arr[temp] == 0)
			{
				temp += 1;
				count += 1;
			}
			cout << count << endl;
		}
		count = 0;
	}
	return 0;
}