#include <iostream>
using namespace std;

int main() {
	int n;
	int t;
	int a = 0;
	int b = 1;
	int c = 1;
	int d = 1;
	int sum1, sum2;
	int count;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> t;
		if (t == 0) {
			cout << "1 0" << endl;
			continue;
		}
		else if (t == 1) {
			cout << "0 1" << endl;
			continue;
		}
		else if (t == 2) {
			cout << "1 1" << endl;
			continue;
		}
		for (int j = 2; j < t; j++) {
			sum1 = a + c;
			sum2 = b + d;
			a = c;
			b = d;
			c = sum1;
			d = sum2;
		}
		cout << sum1 << " " << sum2 << endl;
		a = 0;
		b = c = d = 1;
	}
	return 0;
}