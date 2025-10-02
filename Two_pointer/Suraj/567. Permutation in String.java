class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;

        int[] s1C=new int[26];
        int[] s2C=new int[26];

        for(char c:s1.toCharArray()){
            s1C[c-'a']++;
        }
        int windowSize=s1.length();
        for(int i=0;i<s2.length();i++){
            s2C[s2.charAt(i)-'a']++;

            //once window exceeds size, shrink it from  the left
            if(i>=windowSize){
                s2C[s2.charAt(i-windowSize) - 'a']--;
            }
            if(matches(s1C,s2C))    return true;
        }
        return false;
    }
    private boolean matches(int[] a,int[] b){
        for(int i=0;i<26;i++){
            if(a[i]!=b[i])  return false;
        }
        return true;
    }
}