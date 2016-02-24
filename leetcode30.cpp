class Solution {
public:
    vector<int> findSubstring(string s, vector<string>& words) {
        map<string, int> m;
        int nums = words.size();
        int size = words[0].size();
        int len = s.size() - nums*size;
        for(string word : words){
        	m[word]++;
        }

        map<string, int> count;
        vector<int> res;
        for(int i = 0; i <= len;i++){
        	count.clear();
        	for(int j = 0; j < nums; j++){
        		string cur = s.substr(i + j * size, size);
        		if(m.find(cur) == m.end() || ++count[cur] > m[cur]){
        			goto next;
        		}
        	}
        	res.push_back(i);
        	next:;
        }
        return res;
    }
};
