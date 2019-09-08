class Solution_reverseVowels {
    public String reverseVowels(String s) {
        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        char[] charArray = s.toCharArray();
        for(int i=0, j= charArray.length-1; i < j; i++, j--) {
            while(!vowels.contains(charArray[i]) && i < j) {
                i++;
            }
            while(!vowels.contains(charArray[j]) && i < j) {
                j--;
            }
            if(i < j) {
                Character temp = charArray[i];
                charArray[i] = charArray[j];
                charArray[j] = temp; 
            }
        }
        return String.valueOf(charArray);
    }
}