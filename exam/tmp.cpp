// // #include<iostream>
// // #include<vector>
// // using namespace std;

// // void help(vector<int>& count, int n) {
// //     int index = 0;
// //     while (n > 0) {
// //         if (n % 2 == 1) count[index] += 1;
// //         n /= 2;
// //         index++;
// //     }
// // }

// // int getNum(vector<int>& count) {
// //     int maxValue = -1;
// //     int index = -1;
// //     for (int i = 0; i < 32; i++) {
// //         if (count[i] > maxValue) {
// //             maxValue = count[i];
// //             index = i;
// //         }
// //     }
// //     if (maxValue == 0) return 0;

// //     return 1 << index;
// // }

// // vector<int> deleteNums(vector<int>& nums, int curNum) {
// //     vector<int> result;
// //     for (int n : nums) {
// //         if ((n & curNum) != curNum) result.emplace_back(n);
// //     }
// //     return result;
// // }

// // int main() {
// //     int T;
// //     cin >> T;
// //     while (T > 0) {
// //         int n;
// //         cin >> n;
// //         vector<int> nums(n);
// //         for (int i = 0; i < n; i++) {
// //             cin >> nums[i];
// //         }

// //         vector<int> result;

// //         while (nums.size() != 0) {

// //             vector<int> count(32);
// //             for (int i = 0; i < n; i++) {
// //                 help(count, nums[i]);
// //             }

// //             int cur = getNum(count);
// //             result.emplace_back(cur);

// //             nums = deleteNums(nums, cur);
// //         }
        
// //         cout << result.size() << endl;
// //         for (int n : result) cout << n << ' ';
// //         cout << endl;
// //         T--;
// //     }
// // }

// #include<iostream>
// using namespace std;

// long long help(int n, int m) {
//   long long result = 1;
//   for (int i = 0; i < n; i++) {
//     result = result * (m - i) / (i + 1);
//   }
//   return result;
// }

// int main() {
//   int n;
//   while (cin >> n) {
//     for (int j = 0; j < n; j++) {
//       int L, R, X, Y;
//       cin >> L >> R >> X >> Y;
//       int oneNum = 0;
//       int count = 0;
//       while (Y > 0) {
//         int bit1 = X % 2;
//         int bit2 = Y % 2;
//         if (bit1 == 1) {
//           oneNum++;
//         }
//         if (bit1 == 0 && bit2 == 1) {
//           count++;
//         }
//         X /= 2;
//         Y /= 2;
//       }
//       if (oneNum + count < L || oneNum > R) cout << 0 << endl;
//       else {
//         int left = oneNum >= L ? 0 : (L - oneNum);
//         int right = min(R - oneNum, count);
//         long long ans = 0;
//         for (int i = left; i <= right; i++) {
//           ans += help(i, count);
//         }
//         cout << ans << endl;
//       }
//     }
//   }
// }

#include<iostream>
#include<vector>
using namespace std;

int main() {
  int n;
  while (cin >> n) {
    int tmp;
    vector<int> nums(n);
    vector<vector<int>> dp(n, vector<int>(3));
    int minValue = 100001;
    int minCount = 100001;
    for (int i = 0; i < n; i++) {
      cin >> tmp;
      nums[i] = tmp;
      if (i == 0) {
        dp[i][0] = dp[i][1] = dp[i][2] = tmp;
      }
      else dp[i][0] = dp[i-1][0] + tmp;
      
      minCount = min(tmp, minCount + tmp);
      minValue = min(minValue, minCount);
      if (i > 0) {
        dp[i][1] = max(dp[i-1][1], dp[i-1][0] - minValue);
      
        for (int j = 0; j < i; j++) {
            int minValue2 = 100001;
            int minCount2 = 100001;
            int sum = 0;
            for (int k = j + 1; k <= i; k++) {
            minCount2 = min(nums[k], minCount2 + nums[k]);
            minValue2 = min(minValue2, minCount2);
            sum += nums[k];
            }
            int tmpMax = max(sum, sum - minValue2);
            dp[i][2] = max(dp[i][2], dp[j][1] + tmpMax);
        }
      }
    }
    cout << dp[n-1][2] << endl;
  }
}