class Solution:
    def twoSum(self, arr: List[int], target: int) -> List[int]:
        m = {}
        for i in range(len(arr)):
            l = target-arr[i]
            if m.get(l) is not None:
                return [m.get(l),i]
            m[arr[i]] = i
        return [-1,-1]

        