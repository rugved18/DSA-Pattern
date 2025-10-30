class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int[] mat:matrix){
            int left=0,right=mat.length-1;
            if(mat[left]<= target && target<=mat[right]){
                int mid=0;
                while(left<=right){
                    mid=left+(right-left)/2;
                    if(mat[mid]==target){
                        return true;
                    }
                    if(mat[mid]<target){
                        left=mid+1;
                    }
                    else{
                        right=mid-1;
                    }
                }
            }
        }
        return false;
    }
}
