#include <iostream>
#include <string>
using namespace std;
inline bool check(int x,int y) {
	if (x > 0 && x < 9) {
		if (y > 0 && y < 9) {
			return true;
		}
		else {
			return false;
		}
	}
	else {
		return false;
	}
}
bool same(int a, int b, int c, int d) {
	if (a == c && b == d) {
		return true;
	}
	else {
		return false;
	}
}

int main() {
	string king;
	int kx, ky;
	string stone;
	string move;
	int sx, sy;
	int mx = 0, my = 0;
	int n;
	char a, b, c, d;
	cin >> king >> stone >> n;
	kx = int(king[0] - 64);
	ky = int(king[1]-48);
	sx = int(stone[0] - 64);
	sy = int(stone[1]-48);
	for (int i = 0; i < n; i++) {
		cin >> move;
		if (move == "R") {
			mx = 1;
		}
		else if (move == "L") {
			mx = -1;
		}
		else if (move == "B") {
			my = -1;
		}	
		else if (move == "T") {
			my = 1;
		}
		else if (move == "RT") {
			mx = 1;
			my = 1;
		}
		else if (move == "LT") {
			mx = -1;
			my = 1;
		}
		else if (move == "RB") {
			mx = 1;
			my = -1;
		}
		else {
			mx = -1;
			my = -1;
		}
		if (check(kx+mx, ky+my)) {
			if (same(kx+mx, ky+my, sx, sy)) {
				if (check(sx + mx, sy + my)) {
					kx += mx;
					ky += my;
					sx += mx;
					sy += my;
					mx = 0;
					my = 0;
				}
				else {
					mx = 0;
					my = 0;
					continue;
				}
			}
			else {
				kx += mx;
				ky += my;
				mx = 0;
				my = 0;
			}
		}
		else {
			mx = 0;
			my = 0;
			continue;
		}
	}
	a = kx + 64;
	b = sx + 64;
	c = ky + 48;
	d = sy + 48;
	king[0] = a;
	king[1] = c;
	stone[0] = b;
	stone[1] = d;
	cout << king << endl << stone;
	return 0;
}