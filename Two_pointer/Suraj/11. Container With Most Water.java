class Solution {
    public int maxArea(int[] height) {
        int left=0,right=height.length-1;
        int result=0;
        while(left<right){
            int curMin=Math.min(height[left],height[right]);
            int curArea=curMin*(right-left);
            result=Math.max(result,curArea);
            if(height[left]<height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return result;
    }
}