class Solution{
	public int distictSubstring(String s,int k){
		if(s == null || s.length() == 0 || k == 0) return 0;
		
		int result=0;
		int[] count=new int[26];
		int countD=0;
		int left=0;
		for(int right=0;right < s.length(); right++){
			if(count[s.charAt(right)] == 0){
				countD++
			}
			count[s.charAt(right)]++;
			
			while(countD > k){
				count[s.chat(left)]--;
				if(count[s.charAt(left)] == 0){
					countD--;
				}
				left++;
			}
			
			result = Math.max(result, right - left + 1);
		}
		return result;
	}
}


