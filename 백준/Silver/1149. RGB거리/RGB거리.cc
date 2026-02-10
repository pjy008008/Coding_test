#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	int n;
	int a, b, c;
	int mini;
	int d[1000][3];
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> a >> b >> c;
		if (i == 0) {
			d[i][0] = a; d[i][1] = b; d[i][2] = c;
		}
		else {
			d[i][0] = min(d[i - 1][1], d[i - 1][2])+a;
			d[i][1] = min(d[i - 1][0], d[i - 1][2])+b;
			d[i][2] = min(d[i - 1][0], d[i - 1][1])+c;
		}
	}
	mini = 0;
	for (int i = 1; i < 3; i++) {
		if (d[n - 1][mini] > d[n - 1][i]) {
			mini = i;
		}
	}
	cout << d[n - 1][mini];
	return 0;
}