class Solution {
    static int answer;
    static String checkWord;
    static int cnt;
    static boolean found;
    
    public int solution(String word) {
        String[] alphabet = {"A", "E", "I", "O", "U"};
        answer = 0;
        checkWord = word;
        cnt = 0;
        found = false;
        
        makeWord(alphabet, "");
        
        return answer;
    }
    
    public void makeWord(String[] alphabet, String word) {
        if (word.equals(checkWord)) {
            answer = cnt;
            found=true;
            return;
        }
        
        for (int i = 0; i < alphabet.length; i++) {
            if (word.length() < 5) {
                cnt++;
                //System.out.println(word+alphabet[i]);
                makeWord(alphabet, word + alphabet[i]);
                if(found){
                   return;
                }
            }
        }
    }
}