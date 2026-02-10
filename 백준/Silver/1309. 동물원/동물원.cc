#include <iostream>
using namespace std;

int main() {
	int n;
	int a = 2, b = 6;
	int previous = 7;
	unsigned long long int result;
	cin >> n;
	if (n == 1) {
		cout << 3;
	}
	else if (n == 2) {
		cout << 7;
	}
	else {
		for (int i = 2; i < n; i++) {
			result = (previous + a + b + 2)%9901;
			previous = result;
			a = b;
			b = previous - 1;
		}
		cout << result;
	}
	return 0;
}