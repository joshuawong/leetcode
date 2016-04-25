/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private final String delimiter = ",";
    private final String emptyNode = "#";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }
    
    private void serializeHelper(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append(emptyNode).append(delimiter);
        }
        else{
            sb.append(root.val).append(delimiter);
            serializeHelper(root.left, sb);
            serializeHelper(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> res = new LinkedList<>();
        res.addAll(Arrays.asList(data.split(delimiter)));
        return deserializeHelper(res);
    }
    
    private TreeNode deserializeHelper(Deque<String> nodes){
        String nodeVal = nodes.pollFirst();
        if(nodeVal.equals(emptyNode)){
            return null;
        }
        else{
            TreeNode node = new TreeNode(Integer.parseInt(nodeVal));
            node.left = deserializeHelper(nodes);
            node.right = deserializeHelper(nodes);
            return node;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
