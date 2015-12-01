class Solution {
public:
    string getHint(string secret, string guess) {
    int countA, countB;
		countA = 0;
		countB = 0;
		int secret1[10] = {0};
		int guess1[10] = {0};
		for (int i = 0; i < secret.length(); ++i)
		{
			if (secret[i] == guess[i])
			{
				countA++;
			}
			else
			{
				secret1[secret[i]-'0']++;
				guess1[guess[i]-'0']++;
			}
		}
		for (int i = 0; i < 10; ++i)
		{
			countB += min(secret1[i],guess1[i]);
		}
		return to_string(countA) + 'A' + to_string(countB) + 'B';

    }
};
