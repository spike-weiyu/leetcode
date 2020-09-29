class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Hashset<Integer> set = new Hashset<>();
        int res =0;
        for (int num : nums) {
        	set.add(num);
        }
        for (int i = 0; i < nums.length; i++) {
        	int down = nums[i] - 1;
        	while (set.countains(down)){
        		set.remove(down);
        		down--;
        	}
        	int up = nums[i] + 1;
        	while (se.countains(up)) {
        		set.remove(up);
        		up++;
        	}
        	res = Math.max(res, up - down - 1);
        }
        return res;
    }
}