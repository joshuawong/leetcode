class Solution {
public:
	bool DFS(vector<vector<char> > &board, int r, int c, string word) 
	{
  		int row = board.size();
  		int col = board[0].size();
  		int dir[4][2] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  		if (word.empty())
    		return true;

  		if (r >= 0 && r < row && c >= 0 && c < col && board[r][c] == word[0]) 
  		{
    		for (int i = 0; i < 4; i++) 
    		{
      			char tmp = board[r][c];
      			board[r][c] = 0;
      			if (DFS(board, r + dir[i][0], c + dir[i][1], word.substr(1)))
        			return true;
      			board[r][c] = tmp;
    		}
  		}

  	return false;
}


    bool exist(vector<vector<char>>& board, string word) {
        int row = board.size();
        int col = board[0].size();
        if(row == 0 || col == 0)
        	return false;

        // do DFS from each node
        for (int i = 0; i < row; ++i)
        {
        	for(int j = 0; j < col; ++j)
        	{
        		if(DFS(board, i, j, word) == true)
        			return true;
        	}
        }
        return false;

    }
};
