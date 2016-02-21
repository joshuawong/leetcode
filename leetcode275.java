public class Solution {
    public int hIndex(int[] citations) {
        if(citations.length == 0)
        	return 0;
        //Arrays.sort(citations);
        int count = 0;
        for (int i = citations.length - 1;i >= 0  ;i-- ) 
        {
        	count++;
        	if(count > citations[i])
        	{
        		count--;
        		break;
        	}
        }
        return count;
    }
}
