class MedianFinder {
    List<Integer> list;
    public MedianFinder() {
        list=new ArrayList<>();
    }
    
    public void addNum(int num) {
        int index=Collections.binarySearch(list,num);
        if(index<0) index=-index-1;
        list.add(index,num);
    }
    
    public double findMedian() {
        int n=list.size();
        if(n%2==1)
        return list.get(n/2);

        return (list.get(n/2-1)+list.get(n/2))/2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
