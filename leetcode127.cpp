class Solution {
public:
    int ladderLength(string beginWord, string endWord, unordered_set<string>& wordList) {
        return bfs(beginWord,endWord,wordList);
    }

    int bfs(string beginWord, string endWord, unordered_set<string> wordList)
    {
    	queue<pair<string,int> > q;
    	q.push(make_pair(beginWord,1));
    	unordered_set<string> visited;
    	visited.insert(beginWord);
    	bool found = false;
    	while(!q.empty())
    	{
    		pair<string,int> cur = q.front();
    		q.pop();
    		string word = cur.first;
    		int len = word.size();
    		for (int i = 0; i < len; ++i)
    		{
    			string newWord(word);
    			for(int j = 0; j < 26;++j)
    			{
    				newWord[i] = 'a' + j;
    				if(newWord == endWord)
    				{
    					found = true;
    					return cur.second+1;
    				}
    				if(wordList.count(newWord) > 0 && visited.count(newWord) == 0)
    				{
    					visited.insert(newWord);
    					q.push(make_pair(newWord,cur.second+1));
    				}
    			}
    		}
    	}
    	if(found == false)
    		return 0;
    }
};
