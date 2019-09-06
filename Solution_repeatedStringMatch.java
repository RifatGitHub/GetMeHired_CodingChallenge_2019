class Solution_repeatedStringMatch {
    public int repeatedStringMatch(String A, String B) {
        int a = 1;
        StringBuilder S = new StringBuilder(A);
        for (; S.length() < B.length(); a++) 
		    S.append(A);
        if (S.indexOf(B) >= 0) 
		    return a;
        if (S.append(A).indexOf(B) >= 0) 
		    return a+1;
        return -1;
    }
}