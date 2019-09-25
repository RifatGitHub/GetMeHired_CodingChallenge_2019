public class Solution_combine 
{
    List<List<Integer>> toRet;
    public List<List<Integer>> combine(int n, int k) 
    {
        toRet = new ArrayList<List<Integer>>();
        if(n == 0 || k == 0 || k > n)
            return toRet;
        dfs(n, k, 0, 0, new ArrayList<Integer>());
        return toRet;
    }
    void dfs(int n, int k, int rem, int ind, List<Integer> currList)
    {
        if(rem == k)
        {
            List<Integer> trex = new ArrayList<Integer>(currList);
            toRet.add(trex);
            return;
        }
        for(int i = ind + 1; i <= n; i++)
        {
            currList.add(i);
            dfs(n, k, rem + 1, i, currList);
            currList.remove(currList.size() - 1);
        }
    }
}
