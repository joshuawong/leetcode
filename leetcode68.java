public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
      List<String> lines = new ArrayList<>();
      int index = 0;
      while(index < words.length){
        int count = words[index].length();
        int last = index + 1;
        while(last < words.length){
          if(words[last].length() + count + 1 > maxWidth)
            break;
          count += words[last].length() + 1;
          last++;
        }

        StringBuilder sb = new StringBuilder();
        int difference = last - index - 1;
        // if last line or number of words in the line is 1, left-justified
        if(last == words.length || difference == 0){
          for(int i = index; i < last; i++){
            sb.append(words[i] + " ");
          }
          sb.deleteCharAt(sb.length() - 1);
          for(int i = sb.length(); i < maxWidth; i++){
            sb.append(" ");
          }
        }
        else{
          // middle justified
          int spaces = (maxWidth - count) / difference;
          int r = (maxWidth - count) % difference;
          for(int i = index; i < last; i++){
            sb.append(words[i]);
            if(i < last - 1){
              for(int j = 0; j <= (spaces+((i-index) < r ? 1 : 0)); j++)
                sb.append(" ");
            }
          }
        }
        lines.add(sb.toString());
        index = last;
      }
      return lines;
    }
}
