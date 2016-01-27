class Solution(object):
    def firstMissingPositive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
      	count = 1
      	newnums = sorted(list(set(nums)))
      	for i in newnums:
      		if i <= 0:
      			continue
      		if i != count:
      			return count
      		else:
      			count += 1
      	return count
