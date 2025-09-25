#include<bits/stdc++.h>
using namespace std;

vector<int> Prefix(vector<int>& arr,int n){
    vector<int> prefix(n);
    prefix[0] = arr[0];

    for(int i=1;i<n;i++){
        prefix[i] = prefix[i-1]+arr[i];
    }
    return prefix;
}

int main(){

   vector<int> arr ={1,2,3,4,5};
   int n=5;
   vector<int> result = Prefix(arr,5);

   for(int i=0;i<n;i++){
    cout<<result[i]<<" ";
   }
}