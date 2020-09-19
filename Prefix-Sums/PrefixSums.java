class PrefixSums {
    public static void main(String[] args) {
	    int [] nums = new int[]; 
        int [] prefix = new int[nums.length + 1]; prefix[0] = 0; 
        for(int i = 1; i < nums.length + 1; i++){
                prefix[i] = nums[i - 1] + prefix[i - 1]; 
        }
        System.out.println(Arrays.toString(prefix)); 
        
        for(int i = 0; i < nums.length; i++){
            int index = i + 1; 
            int leftSum = prefix[index];  
            int rightSum = prefix[prefix.length - 1] - prefix[index - 1];
            if(leftSum == rightSum){
                return i; 
            }
        }
        
        return -1; 
    }
}
