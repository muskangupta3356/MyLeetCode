class Solution {
    public double minmaxGasDist(int[] stations, int k) {
        int n = stations.length;
        double start = 0 ; double end = stations[n-1] - stations[0];
        double mid = 0;
        while(start +1e-6 < end){
            mid = (start + end)/2;
            int count = 0;
            for(int i=0;i< n-1;i++){
                count+= Math.ceil((stations[i+1]-stations[i])/mid) -1;
            }
            if(count > k)
                start = mid;
            else
                end = mid;
        }
        return end;
    }
}