class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for (int num : nums) {
        	int i = 0;
        	int j = res;
        	while (i != j){
        		int mid = (i + j) / 2;
        		if (tails[mid] < num){
        			i = mid + 1;
        		}else {
        			j = mid;
        		}
        	}
	        tails[i] = num;
	        if (i == res) ++res;

        }
        return res;
    }
}

