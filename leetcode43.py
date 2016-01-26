class Solution(object):
    def multiply(self, num1, num2):
        """
        :type num1: str
        :type num2: str
        :rtype: str
        """
        len1 = len(num1)
        len2 = len(num2)
        res = 0
        for i in range(len1):
            a = int(num1[len1-1-i]) * (10 ** i)
            for j in range(len2):
                b = int(num2[len2-1-j]) * (10 ** j)
                res += a * b
        return str(res)
