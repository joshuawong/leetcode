public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] verArr1 = version1.split("\\.");
        String[] verArr2 = version2.split("\\.");
        int index1 = 0;
        int index2 = 0;
        while (index1 < verArr1.length || index2 < verArr2.length) {
            int val1 = 0;
            int val2 = 0;
            if (index1 < verArr1.length) {
                val1 = Integer.parseInt(verArr1[index1++]);
            }
            if (index2 < verArr2.length) {
                val2 = Integer.parseInt(verArr2[index2++]);
            }
            if (val1 < val2) {
                return -1;
            }
            if (val1 > val2) {
                return 1;
            }
        }

        return 0;
    }
}