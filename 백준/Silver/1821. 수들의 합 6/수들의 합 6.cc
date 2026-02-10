#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main() {
	int n, f;
	vector<int> v,v1;
	cin >> n >> f;
	for (int i = 0; i < n; i++) {
		v.push_back(i + 1);
	}
	do
	{
		v1 = v;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < v1.size() - 1; j++) {
				v1[j] = v1[j] + v1[j + 1];
			}
			v1.pop_back();
		}
		if (v1[0] == f) {
			for (int i = 0; i < v.size(); i++) {
				cout << v[i] << " ";
			}
			break;
		}
	} while (next_permutation(v.begin(), v.end()));

	return 0;
}