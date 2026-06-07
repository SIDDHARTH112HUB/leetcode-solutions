public class 34_ceil_in_BST {

    public static int ceil(Node root, int key) {
        int ceil = -1;  // default if no ceil exists
        while (root != null) {
            if (root.val == key) {
                return root.val;  // exact match
            } else if (root.val < key) {
                root = root.right;  // move right
            } else {
                ceil = root.val;    // possible ceil
                root = root.left;   // move left to find smaller ceil
            }
        }
        return ceil;
    }
    public static int floor(Node root, int key) {
        int floor = -1;  // default if no floor exists
        while (root != null) {
            if (root.val == key) {
                return root.val;  // exact match
            } else if (root.val > key) {
                root = root.left;  // move left
            } else {
                floor = root.val;  // possible floor
                root = root.right; // move right to find larger floor
            }
        }
        return floor;
    }
}
