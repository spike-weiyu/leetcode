class Solution:
    def containsNearbyAlmostDuplicate(self, nums: List[int], k: int, t: int) -> bool:
        if t>=0:
            bs,w = {}, t+1
            for i, v in enumerate(nums):
                b = v // w
                if b in bs:
                    return True
                else:
                    bs[b] = v
                    if (b-1 in bs and v-bs[b-1] <= t) or (b+1 in bs and bs[b+1]-v <= t):
                        return True
                    if i >= k:
                        del bs[nums[i-k] // w]
        return False 