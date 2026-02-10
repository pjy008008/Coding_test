#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main() {
	int n;
	int x;
	vector<int> v1;
	vector<int> v2;
	int count = 0;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> x;
		v1.push_back(x);
	}
	if (next_permutation(v1.begin(), v1.end())) {
		for (int i = 0; i < n; i++) {
			cout << v1[i] << " ";
		}
	}
	else
		cout << "-1";
	return 0;
}