class FindMinimumInRoatedSortedArray{
    public int findMin(int[] nums) {
        int left=0,right=nums.length-1;
        int mid=0;
        while(left<=right){
            mid=left+(right-left)/2;
            if(nums[mid]>nums[left]){
                right=mid-1;
            }else {
                left=mid+1;
            }
        }
        return mid;
    }
    public static void main(String[] args){
        FindMinimumInRoatedSortedArray ob=new FindMinimumInRoatedSortedArray();
        int[] testcase1={3,4,5,1,2};
        int[] testcase2={4,5,6,7,0,1,2};
        int[] testcase3={11,13,15,17};
        System.out.println(ob.findMin(testcase1));
        System.out.println(ob.findMin(testcase2));
        System.out.println(ob.findMin(testcase3));
        return;
    }
}