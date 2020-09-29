class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int res = 0;
        while (res < citations.length && citations[citations.length - 1 - res] > res){
        	res ++;
        }
        return res;
    }
}

class Solution {
    public int hIndex(int[] citations) {
    	int [] helper = new int[citations.length + 1];
    	for (int i = 0; i < citations.length; i++){
    		helper[citations[i] <= citations.length ? citations[i] : citations.length] += 1;
    	}
    	int sum = 0;
    	for (int i = citations.length; i > 0; i--) {
    		sum += helper[i];
    		if (sum >= i) {
    			return i;
    		}
    	}
    	return 0;


	}
}