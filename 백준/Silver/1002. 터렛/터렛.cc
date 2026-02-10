#include <iostream>
#include <cmath>
using namespace std;

int main() {
	int t;
	int jx, jy;
	int bx, by;
	int r1, r2;
	int R, r;
	double between;
	cin >> t;
	for (int i = 0; i < t; i++) {
		cin >> jx >> jy >> r1 >> bx >> by >> r2;
		between = sqrt(pow(bx-jx,2)+pow(by-jy,2));
		if (r1 >= r2) {
			R = r1;
			r = r2;
		}
		else {
			R = r2;
			r = r1;
		}
		if (between==0 && r==R) {
			cout << -1 << endl;
		}
		else if (R - r < between && between < R + r) {
			cout << 2 << endl;
		}
		else if (r + R == between || R - r == between) {
			cout << 1 << endl;
		}
		else if (r + R<between || R - r>between) {
			cout << 0 << endl;
		}
	}
	
	return 0;
}