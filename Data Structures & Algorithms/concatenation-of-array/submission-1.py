class Solution:
    def getConcatenation(self, nums: List[int]) -> List[int]:
        arr = [0]*len(nums)*2
        idx = len(nums)
        for i in range(len(nums)):
            arr[i] = arr[idx] = nums[i]
            idx += 1
        return arr
        