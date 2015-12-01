class Solution(object):
    def isIsomorphic(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        dicS = {}
        dicT = {}

        for i in range(len(s)):
        	if s[i] in dicS and dicS[s[i]] != t[i]:
        		return False
        	dicS[s[i]] = t[i]

        for i in range(len(t)):
        	if t[i] in disT and disT[t[i]] != s[i]:
        		return False
        	disT[t[i]] = s[i]

        return True