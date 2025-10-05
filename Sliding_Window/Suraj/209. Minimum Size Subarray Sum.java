class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left=0,total=0;
        int result=Integer.MAX_VALUE;
        for(int right=0;right<nums.length;right++){
            total+=nums[right];
            while (total>=target){
                result=Math.min(result,right-left+1);
                total-=nums[left];
                left++;
            }
        }
        return (result == Integer.MAX_VALUE) ? 0 : result;
    }
}
