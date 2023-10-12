/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
    int peak = findPeak(mountainArr, 0, n - 1);

    // Search in the left subarray (increasing order)
    int leftResult = binarySearchLeft(mountainArr, target, 0, peak);

    // If found on the left subarray, return the result
    if (leftResult != -1) {
        return leftResult;
    }

    // Search in the right subarray (decreasing order)
    int rightResult = binarySearchRight(mountainArr, target, peak, n - 1);

    return rightResult;
    }
    private int findPeak(MountainArray mountainArr, int left, int right) {
    while (left < right) {
        int mid = left + (right - left) / 2;
        int midValue = mountainArr.get(mid);
        int nextValue = mountainArr.get(mid + 1);
        if (midValue < nextValue) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }
    return left;
}
private int binarySearchLeft(MountainArray mountainArr, int target, int left, int right) {
    while (left <= right) {
        int mid = left + (right - left) / 2;
        int midValue = mountainArr.get(mid);
        if (midValue == target) {
            return mid;
        } else if (midValue < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return -1;
}
private int binarySearchRight(MountainArray mountainArr, int target, int left, int right) {
    while (left <= right) {
        int mid = left + (right - left) / 2;
        int midValue = mountainArr.get(mid);
        if (midValue == target) {
            return mid;
        } else if (midValue < target) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }
    return -1;
}
}