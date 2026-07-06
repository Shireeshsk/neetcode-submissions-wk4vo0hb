class Solution:
    def insert(self, arr: List[List[int]], n: List[int]) -> List[List[int]]:
        arr.append(n)
        arr.sort(key=lambda x: x[0])
        res = []
        res.append(arr[0])
        for i in range(1,len(arr)):
            if arr[i][0] <= res[len(res)-1][1]:
                res[len(res)-1][1] = max(res[len(res)-1][1],arr[i][1])
            else:
                res.append(arr[i])
        return res


        