class Solution {
public:
    string convert(string s, int numRows) {
        if(numRows <= 1 || numRows >= s.length())
          return s;
        string res;
        for (int i = 1; i <= numRows ; ++i)
        {
          int p = i - 1;
          if(i == 1 || i == numRows) //first row and the last row
          {
            while(p < s.length())
            {
              res.push_back(s[p]);
              p = p + 2 * (numRows - 1);
            }
          }
          else //other rows
          {
            int delta = 2 * (numRows - i);
            while(p < s.length())
            {
              res.push_back(s[p]);
              p = p + delta;
              delta = 2 * (numRows - 1) - delta;
            }
          }
        }
        return res;
    }
};