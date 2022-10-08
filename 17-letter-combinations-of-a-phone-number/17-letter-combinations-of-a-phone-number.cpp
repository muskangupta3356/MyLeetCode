class Solution {
public:
      void helper(int index, int n,string digits,vector<string> &res,unordered_map<char,vector<char>> &mp, string temp)
    {
        if(index==n)
        {
            res.push_back(temp);
        }
        char d = digits[index];
        vector<char> values = mp[d];
        for(char c : values)
        {
            
            helper(index+1,n,digits,res,mp,temp+c);
        }
        return;
    }
    vector<string> letterCombinations(string digits) {
        
             vector<string> res;
        int n = digits.length();
        if(n==0)
            return res;
        unordered_map<char,vector<char>>mp;
        vector<char> vect2{ 'a','b','c'};
        mp['2']=vect2;
        vector<char> vect3{ 'd','e','f'};
        mp['3']=vect3;
        vector<char> vect4{'g','h','i'};
        mp['4']=vect4;
        vector<char> vect5{'j','k','l'};
        mp['5']=vect5;
        vector<char> vect6{'m','n','o'};
        mp['6']=vect6;
        vector<char> vect7{'p','q','r','s'};
        mp['7']=vect7;
        vector<char> vect8{'t','u','v'};
        mp['8']=vect8;
        vector<char> vect9{'w','x','y','z'};
        mp['9']=vect9;
        helper(0,n,digits,res,mp,"");
        return res;   
    }
};