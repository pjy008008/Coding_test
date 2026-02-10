#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>
using namespace std;

int main() {
	int n,x;
	int a, b, c, d;
	double sum = 0;
	int count = 0;
	int temp = 0;
	int z;
	int max = 0;
	int k = 0;
	
	vector<int> v;
	cin >> n;
	vector<int> v1(n, 0);
	for (int i = 0; i < n; i++) {
		cin >> x;
		v.push_back(x);
	}
	sort(v.begin(), v.end());
	for (int i = 0; i < n; i++) {
		sum += v[i];
	}
	a = round(sum / n);
	b = v[(n / 2)];
	d = v[n-1] - v[0];
	z = 0;
	for (int i = 1; i < n; i++) {
		if (v[z] == v[i]) {
			k += 1;
			v1[i] = k;
		}
		else {
			z = i;
			k = 0;
			continue;
		}
	}
	for (int i = 0; i < n; i++) {
		if (v1[i] > max) {
			max = v1[i];
		}
	}
	for (int i = 0; i < n; i++) {
		if (v1[i] == max) {
			count += 1;
		}
	}
	c = v[0];
	if (count > 1) {
		for (int i = 0; i < n; i++) {
			if (v1[i] == max) {
				temp += 1;
				if (temp == 2) {
					c = v[i];
					break;
				}
			}
		}
	}
	else {
		for (int i = 0; i < n; i++) {
			if (v1[i] == max) {
				c = v[i];
				break;
			}
		}
	}
	cout << a << '\n' << b << '\n' << c << '\n' << d;
	return 0;
}