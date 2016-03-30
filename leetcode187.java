<<<<<<< HEAD
=======
//HashSet
>>>>>>> c05fb885d956522cebfc262181ea1369380b1c3b
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();
<<<<<<< HEAD
        for(int i = 0; i + 9 < s.length;i++){
=======
        for(int i = 0; i + 9 < s.length();i++){
>>>>>>> c05fb885d956522cebfc262181ea1369380b1c3b
        	String sub = s.substring(i,i+10);
        	if(seen.add(sub) != true){
        		repeated.add(sub);
        	}
        }
        return new ArrayList(repeated);
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> c05fb885d956522cebfc262181ea1369380b1c3b
