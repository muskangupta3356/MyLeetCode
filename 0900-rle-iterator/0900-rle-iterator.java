class RLEIterator {
    int[] arr;
    int idx;
    public RLEIterator(int[] A) {
        this.arr = A;
        idx = 0;
    }
    
    public int next(int n) {
        while (idx < arr.length) {
            if (n > arr[idx]) {
                n -= arr[idx];
                idx += 2;
            } else {
                arr[idx] -= n;
                return arr[idx + 1];
            }
        }
        return -1;
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(encoding);
 * int param_1 = obj.next(n);
 */