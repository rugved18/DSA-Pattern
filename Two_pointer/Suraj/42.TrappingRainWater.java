class Solution {
    public int trap(int[] height) {
        int left=0,right=height.length-1,result=0,leftmax=height[0],rightmax=height[height.length-1];
        while(left<right){
            if(height[left]<height[right]){
                left++;
                leftmax=Math.max(leftmax,height[left]);
                result+=(leftmax-height[left]<0)?0:leftmax-height[left];
            }
            else{
                right--;
                rightmax=Math.max(rightmax,height[right]);
                result+=(rightmax-height[right]<0)?0:rightmax-height[right];
            }
        }
        return result;
    }
}
