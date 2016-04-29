public class Solution {
    Map<String, List<String>> map;
    List<List<String>> res;
    public List<List<String>> findLadders(String start, String end, Set<String> wordList) {
        res = new ArrayList<>();
        if(wordList.size() == 0)
            return res;
            
        int min = Integer.MAX_VALUE;
        
        Queue<String> queue = new ArrayDeque<>();
        queue.add(start);
        
        map = new HashMap<String,List<String>>();
        
        Map<String, Integer> ladder = new HashMap<>();
        for(String string : wordList){
            ladder.put(string, Integer.MAX_VALUE);
        }
        
        ladder.put(start,0);
        
        wordList.add(end);
        while(!queue.isEmpty()){
            String word = queue.poll();
            int step = ladder.get(word)+1;
            
            if(step > min)
                break;
            
            for(int i = 0; i < word.length(); i++){
                StringBuilder sb = new StringBuilder(word);
                for(char ch = 'a' ; ch <= 'z' ; ch++){
                    sb.setCharAt(i, ch);
                    String newWord = sb.toString();
                    if(ladder.containsKey(newWord)){
                        if(step > ladder.get(newWord)){
                            continue;
                        }
                        else if(step < ladder.get(newWord)){
                            queue.add(newWord);
                            ladder.put(newWord, step);
                        }
                        else; // important!!!!!!!
                        
                        if(map.containsKey(newWord))
                            map.get(newWord).add(word);
                        else{
                            List<String> list = new LinkedList<>();
                            list.add(word);
                            map.put(newWord,list);
                        }
                        
                        if(newWord.equals(end))
                            min = step;
                    }
                }
            }
        }
        
        LinkedList<String> res1 = new LinkedList<>();
        backTracking(start, end, res1);
        
        return res;
    }
    
    private void backTracking(String start, String end, List<String> list){
        if(end.equals(start)){
            list.add(0, start);
            res.add(new ArrayList<String>(list));
            list.remove(0);
            return;
        }
        list.add(0, end);
        if(map.get(end) != null){
            for(String string : map.get(end))
                backTracking(start, string, list);
        }
        list.remove(0);
    }
}
