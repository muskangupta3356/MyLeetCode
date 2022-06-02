class Solution {
public:
    int kthFactor(int n, int k) {
//        set<int>v; int count=0;
//         int s=sqrt(n);
//         for(int i=1;i<=s;i++)
//         {
//             if(n%i==0)
//             {
//                int t =n/i;
//                 v.insert(i);
//                 v.insert(t);
//             }
            
//         }
      
//         if(v.size()<k)
//             return -1;
//         else
//         {
//             for (auto it = v.begin(); it != v.end(); it++)
//             {
//                 count++;
//                 if(count==k)
//                     return (*it);
//             }
//         }
//         return -1;
         float root = sqrt(n);

    for (int i=1; i<root; i++) {
        if (n % i == 0 && --k == 0) return i;
    }

    for (int i=root; i>0; i--) {
        if (n % i == 0 && --k == 0) return n/i;
    }

    return -1;
    }
};