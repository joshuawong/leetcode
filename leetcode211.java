public class WordDictionary {
    Map<Integer, List<String>> map = new HashMap<>();
    
    // Adds a word into the data structure.
    public void addWord(String word) {
        int len = word.length();
        if(!map.containsKey(len)){
            List<String> list = new ArrayList<>();
            list.add(word);
            map.put(len,list);
        }
        else{
            map.get(len).add(word);
        }
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        int len = word.length();
        if(!map.containsKey(len)){
            return false;
        }
        List<String> strings = map.get(len);
        for(String string : strings){
            if(isEquals(string,word)){
                return true;
            }
        }
        return false;
    }
    
    private boolean isEquals(String word, String pattern){
        if(word.length() != pattern.length()){
            return false;
        }
        for(int i = 0; i < word.length(); i++){
            if(pattern.charAt(i) != '.' && pattern.charAt(i) != word.charAt(i)){
                return false;
            }
        }
        return true;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
