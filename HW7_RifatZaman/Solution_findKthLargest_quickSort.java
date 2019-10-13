class Solution_findKthLargest_quickSort {
    public int findKthLargest(int[] nums, int k) {
        quicksort(nums, 0, nums.length-1, k);
        
        for(int i=0; i<nums.length; i++){
            System.out.println(nums[i]);
        }
        return nums[k-1];
    }
    
    private void quicksort(int[] arr, int low, int high, int k){
        if(low<high){
            int pi = partition(arr, low, high);
            
            //quicksort(arr, low, pi-1, k);
            //quicksort(arr, pi+1, high, k);
            
            if (pi>=k-1){
                quicksort(arr, low, pi-1, k);
            }
            else{
                quicksort(arr, pi+1, high, k);
            }
        }
    }
    
    private int partition(int[] nums, int lo, int hi){
        int pivot = nums[lo];
        int i = lo;
        int j = hi+1;
                
        while (true) {
            while (nums[++i] >= pivot) {
                if (i == hi)
                    break;
            }
            
            while (nums[--j] <= pivot) {
                if (j == lo)
                    break;
            }
            
            if (i >= j) break;
            //exch
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        nums[lo] = nums[j];
        nums[j] = pivot;
        
        return j;
    }
}
