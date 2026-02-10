#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main() {
	int n;
	string s;
	string s1;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> s;
		s1 = s;
		if (next_permutation(s.begin(), s.end())) {
			cout << s << endl;
		}
		else {
			cout << s1 << endl;
		}
	}
	
	return 0;
}