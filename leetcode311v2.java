public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
      int rowA = A.length;
      int colA = A[0].length;
      int colB = B[0].length;
      // rowB = colA

      int[][] res = new int[rowA][colB];

      Map<Integer, List<Integer>> indexA = new HashMap<>();
      for(int i = 0; i < rowA; i++){
        List<Integer> numA = new ArrayList<>();
        for(int j = 0; j < colA; j++){
          if(A[i][j] != 0){
            numA.add(j);
          }
        }
        indexA.put(i, numA);
      }

      for(int i = 0; i < rowA; i++){
        List<Integer> numA = indexA.get(i);
        for(int k = 0; k < numA.size(); k++){
          int col = numA.get(k);
          int valA = A[i][col];
          for(int j = 0; j < colB; j++){
            int valB = B[col][j];
            res[i][j] += valA * valB;
          }
        }
      }
      return res;
    }
}
