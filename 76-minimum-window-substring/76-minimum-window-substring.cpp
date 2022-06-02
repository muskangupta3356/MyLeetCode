class Solution {
public:
     string minWindow(string s, string t) {
        if(t.length() > s.length())
            return "";
        
        unordered_map<char,int>sm; 
        unordered_map<char,int>tm;
        
        for(char c : t){
            tm[c]++;
        }

        int need = tm.size(); int start;int end;
        int have = 0;
        int left = 0,right = 0; int ans = s.length()+1;char c;int f = 0;
        
        while(right < s.length()){
             c = s[right];
            if(tm.count(c) == 1){
            
                if(tm[c] > sm[c]) 
                {
                    sm[c]++;
                    if(tm[c]== sm[c])
                    have++;
                } 
                else
                {
                    sm[c]++;
                }
            }
            
            while(need == have){   
                if(ans > (right - left + 1)){
                    ans = right - left + 1;
                    start = left;
                    end = right;
                    f = 1;
                }
                           
                c = s[left];
                left++;
                if(sm.count(c) == 1){
                    sm[c]--;
                    if(tm[c] > sm[c])   have--;           
                }
            }   
            right++;
            // cout<<start<<"-"<<end<<endl;
        }
        string x = "";
        if(f == 1)
         x = s.substr(start,ans);
        return x;
    }
};