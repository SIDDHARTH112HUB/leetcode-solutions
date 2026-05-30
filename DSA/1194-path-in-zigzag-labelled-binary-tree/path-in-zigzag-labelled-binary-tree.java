class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> path = new ArrayList<>();
        
        // Find the level of the given label
        int level = 0;
        int nodeCount = 1;
        while (label >= nodeCount * 2) {
            nodeCount *= 2;
            level++;
        }
        
        // Traverse upwards from the label to the root
        while (label > 0) {
            path.add(label);
            
            // Calculate the range of values at this level
            int start = (int) Math.pow(2, level);
            int end = (int) Math.pow(2, level + 1) - 1;
            
            // Mirror the label to get its "normal" binary tree position
            label = start + end - label;
            
            // Move to parent
            label /= 2;
            level--;
        }
        
        // Reverse to get root-to-label path
        Collections.reverse(path);
        return path;
    }
}