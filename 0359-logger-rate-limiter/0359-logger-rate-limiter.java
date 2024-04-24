class Logger {
    Map<String, Integer> nextTimeStamp;
    public Logger() {
      nextTimeStamp = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
         
        return shouldPrintMessage(timestamp,message,nextTimeStamp);
    }
    public boolean shouldPrintMessage(int timestamp, String message,Map<String, Integer> nextTimeStamp){
        if(!nextTimeStamp.containsKey(message))
        { 
            nextTimeStamp.put(message,timestamp+10);
            return true;
        }
        else
        {
            if(timestamp<nextTimeStamp.get(message))
                return false;
            else
            {
                nextTimeStamp.put(message,timestamp+10);
                return true;
            }
                
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */