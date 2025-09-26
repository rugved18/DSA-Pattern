#include <bits/stdc++.h>
using namespace std;

class solution{
    vector<int> prefix;
    vector<int> arr ={1,0,0,1,0,0,1,1,1,0};
    int n = arr.size();

    void function1 (vector<int>arr){
        prefix[0] = arr[0];
        for(int i=1;i<n;i++){
            prefix[i] = prefix[i-1]+arr[i];
        }
    }

    int ones(int left, int right){
        if(left ==0){
           return prefix[right];
        }
        return prefix[right] - prefix[left-1];
    }

public:
    void run(){
        prefix.resize(n);         
        function1(arr);           
        cout << "Number of ones from index 2 to 7: " << ones(0, 9) << endl;
    }
};

int main() {
    solution obj;
    obj.run();
}
