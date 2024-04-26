class Solution {
    public int countTime(String time) {
        int answer = 0; int first =1; int second =1;int flag=0;
        if(time.charAt(0) == '?'){
            if(time.charAt(1) == '?' || time.charAt(1) <='3'){
                first*= 2;
            }
            else if(time.charAt(1) >= '4')
            {
                first*=2;
                second*=0;
            }
            flag=1;
        }
        System.out.print(first+" ");
        System.out.print(second);
        System.out.println();
        if(time.charAt(1) == '?')
        {
            if(time.charAt(0) == '?')
            {
                first*=10;
                second*=4;
            }
            else
            {
                if(time.charAt(0) == '0' || time.charAt(0) == '1'){
                    first*=10;
                    second*=0;
                }
                else{
                    first*=0;
                    second*=4;
                }
            }
            flag=1;
        }
         System.out.print(first+" ");
        System.out.print(second);
        System.out.println();
        if(time.charAt(3) == '?'){
            if(time.charAt(0)=='?' || time.charAt(1)=='?'){
            first*=6;
            second*=6;
            }
            else{
                first*=0;
            second*=6;
            }
            flag=1;
        }
        System.out.print(first+" ");
        System.out.print(second);
        System.out.println();
         if(time.charAt(4) == '?'){
             if(time.charAt(0)=='?' || time.charAt(1)=='?'){
            first*=10;
            second*=10;
            }
            else{
                first*=0;
            second*=10;
            }
             flag=1;
        }
         System.out.print(first+" ");
        System.out.print(second);
        System.out.println();
        if(flag==1)
        answer= first + second;
        else
            return 1;
        return answer;
    }
}