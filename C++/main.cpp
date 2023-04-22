#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main() {
    // string str = " 01234567 ";
    // int n = stoi(str);
    // string str2 = to_string(n);
    // string str3 = str2.substr(3, 2);
    // int index = str2.find(str3, 0);
    // bool flag = isdigit('2');
    // bool flag2 = isalpha('a');

    vector<int> vec{5, 4, 3, 2, 1};
    vector<int> sortVec{0, 1, 2, 3, 4};
    sort(sortVec.begin(), sortVec.end(), [&](auto& a, auto& b) {
        return vec[a] < vec[b];
    });
    for (int& n : sortVec) cout << n << ' ';

}