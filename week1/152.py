class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        if not nums :
        	return 0
        ma, mi, res = nums[0], nums[0], nums[0]
        for i in range(1,len(nums)):
        	temp = ma
        	ma = max(max(ma * nums[i], mi * nums[i] ), nums[i])
        	mi = min(min(temp * nums[i], mi * nums[i] ), nums[i])
        	res = max(ma, res)
        return res