class Solution {
	vector<string> res;
public:
	void generate(int n, int i, int j, string str)
	{
		if(i == n && j == n)
			res.push_back(str);
		if(i < n)
			generate(n,i+1,j,str+'(');
		if(j < n && j < i)
			generate(n,i,j+1,str+')');
	}

    vector<string> generateParenthesis(int n) {
        string str;
        generate(n,0,0,str);
        return res;
    }
};
