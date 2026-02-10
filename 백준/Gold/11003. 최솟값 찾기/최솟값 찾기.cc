#include <iostream>
#include <deque>

using namespace std;

struct Node {
    int index, value;
    Node(int idx, int val) : index(idx), value(val) {}
};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    
    int n, l;
    cin >> n >> l;
    deque<Node> dq;
    
    for (int i = 0; i < n; i++) {
        int x;
        cin >> x;
        
        while (!dq.empty() && dq.back().value > x) {
            dq.pop_back();
        }
        
        dq.emplace_back(i, x);
        
        if (dq.front().index < i - l + 1) {
            dq.pop_front();
        }
        
        cout << dq.front().value << " ";
    }
    
    return 0;
}
