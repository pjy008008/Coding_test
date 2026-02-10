#include <iostream>
using namespace std;

void swap(int& x, int& y) {
	int temp;
	temp = x;
	x = y;
	y = temp;
}

int Euclidean(int a, int b)
{
	int r = a % b;
	if (r == 0) {
		return b;
	}
	return Euclidean(b, r);
}

int main() {
	int fa2,count = 1;
	int a1, a2, b1, b2,c1,c2;
	int result;
	int x;
	cin >> a1 >> a2 >> b1 >> b2;
	if (a2 < b2) {
		swap(a1, b1);
		swap(a2, b2);
	}
	fa2 = a2;
	while (a2%b2!=0)
	{
		a2 = fa2 * count;
		count += 1;
	}
	result = a2 / b2;
	b1 *= result;
	b2 *= result;
	if (count == 1) {
		a1 = a1 * count;
	}
	else {
		a1 *= (count - 1);
	}
	c1 = a1 + b1;
	c2 = a2;
	x=Euclidean(c1, c2);
	c1 /= x;
	c2 /= x;
	cout << c1 << ' ' << c2;
	return 0;
}