class Solution_findKthLargest {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for(int i = 0; i < len; i++){
            heap.add(nums[i]);
        }

        for(int i =0; i < len-k; i++){
            heap.poll();
        }
        return heap.poll();
    }
}
