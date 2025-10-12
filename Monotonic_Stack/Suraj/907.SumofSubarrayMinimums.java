class Solution {
    public int sumSubarrayMins(int[] arr) {
        int MOD=1_000_000_007;
        int n=arr.length;
        long result=0;
        Stack<Integer> st=new Stack<>();
        int[] ple=new int[n];
        int[] nle=new int[n];

        //to find ple
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }
            ple[i]=st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        st.clear();

        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            nle[i]=st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        for(int i=0;i<n;i++){
            long left=i-ple[i];
            long right=nle[i]-i;
            result=(result + (arr[i] * left * right)%MOD) % MOD;
        }
        return (int)result;
    }
}
