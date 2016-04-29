public class ValidWordAbbr {
    Map<String, String> map = new HashMap<>();

    public ValidWordAbbr(String[] dictionary) {
      for(String word : dictionary){
        String  wordAbbr = getAbbreviation(word);

        if(map.containsKey(wordAbbr) && !map.get(wordAbbr).equals(word))
          map.put(wordAbbr,"");
        else
          map.put(wordAbbr, word);
      }
    }

    public boolean isUnique(String word) {
      return !map.containsKey(getAbbreviation(word))||map.get(getAbbreviation(word)).equals(word);
    }

    private String getAbbreviation(String s){
      if(s.length() <= 2)
        return s;
      String abbr = s.charAt(0) + Integer.toString(s.length()-2) + s.charAt(s.length()-1);
      return abbr;
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");
