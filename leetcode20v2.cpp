class Solution {
public:
    bool isValid(string s) {
        stack<char>exp;
        exp.push('$');
        int i=0;
        while(i<=s.length()-1)
        {
            if(s[i]=='(') { exp.push(')'); }
            if(s[i]=='{') { exp.push('}'); }
            if(s[i]=='[') { exp.push(']'); }
            if(s[i]==')') { if(exp.top()!=')') return false; exp.pop(); }
            if(s[i]=='}') { if(exp.top()!='}') return false; exp.pop(); }
            if(s[i]==']') { if(exp.top()!=']') return false; exp.pop(); }
            i++;
        }
        if(exp.top()!='$') return false;
        else return true;
    }
};