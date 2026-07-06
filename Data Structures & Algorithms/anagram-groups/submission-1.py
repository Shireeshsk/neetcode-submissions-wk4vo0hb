class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        m = {}
        for sk in strs:
            temp = ''.join(sorted(sk))
            if m.get(temp) is None:
                m[temp] = [sk]
            else:
                m.get(temp).append(sk)
        res = []
        for sk in m.values():
            res.append(sk)
        return res
            
        