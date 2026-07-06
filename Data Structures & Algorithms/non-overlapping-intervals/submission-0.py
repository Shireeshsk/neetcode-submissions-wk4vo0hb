class Solution:
    def eraseOverlapIntervals(self, arr: List[List[int]]) -> int:
        arr.sort(key=lambda x: x[0])
        c = 0
        prev = arr[0]
        for i in range(1,len(arr)):
            if arr[i][0] < prev[1]:
                c += 1
                prev[1] = min(prev[1],arr[i][1])
            else:
                prev = arr[i]
        return c