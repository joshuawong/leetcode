public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
      StringBuilder sb = new StringBuilder();
      for(String str : strs){
        sb.append(str.length()).append(':').append(str);
      }
      return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
      List<String> res = new ArrayList<>();
      int index = 0;
      while(index < s.length()){
        int separator = s.indexOf(':',index);
        int size = Integer.valueOf(s.substring(index, separator));
        res.add(s.substring(separator + 1, separator + size + 1));
        index = separator + size + 1;
      }
      return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
