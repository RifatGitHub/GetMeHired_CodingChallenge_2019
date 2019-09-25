class Solution_permuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums)
            map.put(n, map.getOrDefault(n, 0) + 1);
        int[] digits = new int[map.size()];
        int[] count = new int[map.size()];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            digits[i] = entry.getKey();
            count[i++] = entry.getValue();
        }
        List<List<Integer>> permutations = new ArrayList<>();
        permute(digits, count, new int[nums.length], 0, permutations);
        return permutations;
    }

    private void permute(int[] digits, int[] count, int[] permutation, int level, List<List<Integer>> permutations) {
        if (level == permutation.length) {
            List<Integer> perm = new ArrayList<>();
            for (int i : permutation)
                perm.add(i);
            permutations.add(perm);
            return;
        }
        for (int i = 0; i < count.length; i++) 
            if (count[i] != 0) {
                permutation[level] = digits[i];
                count[i]--;
                permute(digits, count, permutation, level + 1, permutations);
                count[i]++;
            }
    }
}
