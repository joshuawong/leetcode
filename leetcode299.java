public class Solution {
    public String getHint(String secret, String guess) {
        int bull = 0, cow = 0;
        int[] arr1 = new int[10];
        int[] arr2 = new int[10];
        for(int i = 0; i < secret.length(); i++){
            if(secret.charAt(i) == guess.charAt(i)){
                bull++;
            }
            else{
                arr1[secret.charAt(i) - '0']++;
                arr2[guess.charAt(i) - '0']++;
            }
        }
        for(int i = 0; i < 10; i++){
            cow += Math.min(arr1[i],arr2[i]);
        }
        return (bull+"A"+cow+"B");
    }
}
