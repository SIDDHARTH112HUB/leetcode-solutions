class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> path = new ArrayList<>();
        
        // Step 1: Find the level of the given label.
        // In a normal binary tree, level 0 has [1],
        // level 1 has [2,3], level 2 has [4,5,6,7], etc.
        // We keep doubling nodeCount until we reach the level containing 'label'.
        int level = 0;
        int nodeCount = 1;
        while (label >= nodeCount * 2) {
            nodeCount *= 2;
            level++;
        }
        
        // Step 2: Traverse upwards from the label to the root.
        // In a normal binary tree, we would just keep dividing by 2 (label /= 2).
        // But because this tree is zigzag labelled, we need to "mirror" the label
        // at each level to convert it back to its normal binary tree position.
        while (label > 0) {
            // Add current label to path
            path.add(label);
            
            // Step 3: Calculate the range of values at this level.
            // For example:
            // level 2 → nodes [4..7]
            // level 3 → nodes [8..15]
            int start = (int) Math.pow(2, level);
            int end = (int) Math.pow(2, level + 1) - 1;
            
            // Step 4: Mirror the label.
            // In zigzag labelling, odd levels are reversed.
            // To find the "true" position of the node in a normal binary tree,
            // we flip it across the range using: mirrored = start + end - label.
            label = start + end - label;
            
            // Step 5: Move to parent.
            // Once mirrored, divide by 2 to go up one level.
            label /= 2;
            level--;
        }
        
        // Step 6: Reverse the path.
        // We collected nodes from bottom to top, so reverse to get root → label.
        Collections.reverse(path);
        return path;
    }
}
