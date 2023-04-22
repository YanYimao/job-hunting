# include<iostream>
# include<vector>
#include<algorithm>
using namespace std;

// 冒泡
void sortVec0(vector<int>& vec) {
    int size = vec.size();
    for (int i = size - 1; i > 0; i--) {
        bool isSorted = true;
        for (int j = 0; j < i; j++) {
            if (vec[j] > vec[j + 1]) {
                swap(vec[j], vec[j + 1]);
                isSorted = false;
            }
        }
        if (isSorted) return;
    }
}

// 选择
void sortVec1(vector<int>& vec) {
    int size = vec.size();
    for (int i = 0; i < size - 1; i++) {
        int index = i;
        for (int j = i + 1; j < size; j++) {
            if (vec[j] < vec[index]) {
                index = j;
            }
        }
        swap(vec[i], vec[index]);
    }
}

// 插入
void sortVec2(vector<int>& vec) {
    int size = vec.size();
    for (int i = 1; i < size; i++) {
        int j = i;
        int tmp = vec[i];
        while (j > 0 && vec[j-1] > tmp) {
            vec[j] = vec[j-1];
            j--;
        }
        vec[j] = tmp;
    }
}

// 希尔排序
void sortVec3(vector<int>& nums) {
    int size = nums.size();
    int gap = 1;
    while (gap < size / 3) {
        gap = gap * 3 + 1;
    }

    while (gap > 0) {
        for (int i = gap; i < size; i++) {
            int j = i;
            int tmp = nums[i];
            while (j >= gap && nums[j-gap] > tmp) {
                nums[j] = nums[j-gap];
                j -= gap;
            }
            nums[j] = tmp;
        }
        gap /= 3;
    }
}

// 快速排序
void quickSort(vector<int>& nums, int left, int right) {
    if (left >= right) return;
    int random = rand() % (right - left + 1) + left;
    swap(nums[right], nums[random]);
    int index = left;
    for (int i = left; i < right; i++) {
        if (nums[i] < nums[right]) {
            swap(nums[index], nums[i]);
            index++;
        }
    }
    swap(nums[right], nums[index]);
    quickSort(nums, left, index - 1);
    quickSort(nums, index + 1, right);
}

// 归并排序
void mergeSort(vector<int>& nums) {
    int size = nums.size();
    vector<int> result(size);
    for (int seg = 1; seg < size; seg += seg) {
        for (int i = 0; i < size; i += seg * 2) {
            int start1 = i, end1 = min(start1 + seg, size);
            int start2 = end1, end2 = min(start2 + seg, size);
            for (int j = i; j < end2; j++) {
                if (start2 == end2 || (start1 != end1 && nums[start1] < nums[start2])) {
                    result[j] = nums[start1];
                    start1++;
                }
                else {
                    result[j] = nums[start2];
                    start2++;
                }
            }
        }
        nums = result;
    }
}

// 堆排序
void shiftDown(vector<int>& nums, int start, int end) {
    while (start * 2 + 1 <= end) {
        int large = start * 2 + 1;
        if (large + 1 <= end && nums[large + 1] > nums[large]) {
            large++;
        }
        if (nums[start] < nums[large]) {
            swap(nums[start], nums[large]);
            start = large;
        } else {
            return;
        }
    }
}
void heapSort(vector<int>& nums) {
    int size = nums.size();
    for (int i = (size - 1) / 2; i >= 0; i--) {
        shiftDown(nums, i, size - 1);
    }
    for (int i = size - 1; i > 0; i--) {
        swap(nums[0], nums[i]);
        shiftDown(nums, 0, i - 1);
    }
} 

// 需要预处理所有数据大于等于0
// 计数排序
void countSort(vector<int>& nums) {
    int maxValue = nums[0];
    for (int n : nums) maxValue = max(n, maxValue);

    int bucket[maxValue + 1] = {0};
    for (int n : nums) {
        bucket[n]++;
    }

    int index = 0;
    for (int i = 0; i <= maxValue; i++) {
        while (bucket[i] > 0) {
            nums[index] = i;
            index++;
            bucket[i]--;
        }
    }
}

// 桶排序
void bucketSort(vector<int>& nums) {

} 

// 基排序
void radixSort(vector<int>& nums) {
    int size = nums.size();
    if (size == 0) return;

    int maxValue = nums[0];
    for (int n : nums) maxValue = max(n, maxValue);
    int bitNum = 0;
    while (maxValue > 0) {
        bitNum++;
        maxValue /= 10;
    }

    vector<int> tmp(size);
    int count[10] = {0};
    int radix = 1;
    for (int i = 0; i < bitNum; i++) {
        for (int j = 0; j < 10; j++) {
            count[j] = 0;
        }
        for (int n : nums) {
            count[(n / radix) % 10]++;
        }
        for (int j = 1; j < 10; j++) {
            count[j] += count[j-1];
        }
        for (int j = size - 1; j >= 0; j--) {
            int index = (nums[j] / radix) % 10;
            tmp[count[index] - 1] = nums[j];
            count[index]--;
        }
        nums = tmp;
        radix *= 10;
    }

}

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};
class Solution {
public:
    void inorder(TreeNode* root, vector<int>& res) {
        if (!root) {
            return;
        }
        inorder(root->left, res);
        res.push_back(root->val);
        inorder(root->right, res);
    }
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> res;
        inorder(root, res);
        return res;
    }
};

void test (char str[100]) {
    cout << sizeof(str) << endl;
}



int main() {
    int a = 8;
    int b = 12;
    cout << __gcd(a, b) << endl;
    cout << a * b / __gcd(a, b) << endl;
    // Solution solution;
    // TreeNode* root = new TreeNode(0);
    // root->left = new TreeNode(1);
    // root->right = new TreeNode(2);
    // vector<int> result = solution.inorderTraversal(root);
    // for (int n : result) cout << n << ' ';


    // int tmp;
    // while (cin >> tmp) {
    //     vector<int> vec;
    //     int n = 0;
    //     do {
    //         cin >> n;
    //         vec.emplace_back(n);
    //     } while (getchar() != '\n');
    //     radixSort(vec);
    //     for (int i = 0; i < vec.size(); i++) {
    //         cout << vec[i] << ' ';
    //     }
    //     cout << endl;
    // }
    

    // int n = 6;
    // cout << (n & -n) << endl;

}