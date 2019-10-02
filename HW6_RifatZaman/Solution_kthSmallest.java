class Solution_kthSmallest {
    public static int kthSmallest(int[][] matrix, int k) {
        
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                heap.add(matrix[i][j]);
            }
        }

        for(int i =0; i < k -1; i++){
            heap.poll();
        }
        return heap.poll();
    }
}
