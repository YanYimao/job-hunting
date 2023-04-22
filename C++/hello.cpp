#include<iostream>
#include<vector>
using namespace std;


int getResult(vector<int>& nums1, vector<int>& nums2) {
    int n = nums1.size();
    vector<int> preSum(n);
    for (int i = 0; i < n - 3; i++) {
        if (i == 0) preSum[i] = nums2[i];
        else preSum[i] = preSum[i-1] + nums2[i];

        if (i >= 3 && nums2[i-3] == -1) preSum[i] -= nums2[i-3];

        if (preSum[i] <= nums1[i]) {
            int small = i;
            if (i >= 1 && nums2[small] > nums2[i-1]) small--;
            if (i >= 2 && nums2[small] > nums2[i-2]) small--;

            if (preSum[i] + nums2[small] * 2 > nums1[i]) {
                nums2[small] = -1;
            } else {
                
            }
        }
    }


}