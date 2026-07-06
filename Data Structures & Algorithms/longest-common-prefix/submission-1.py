class Solution:
    def helper(self,s,strs):
        for i in range(len(s)):
            if s[i] != strs[i]:
                return s[:i]
        return s
    def longestCommonPrefix(self, strs: List[str]) -> str:
        m = float('inf')
        s = ''
        for sk in strs:
            if len(sk)<m:
                s = sk
                m = len(s)
        for sk in strs:
            s = self.helper(s,sk)
        return s