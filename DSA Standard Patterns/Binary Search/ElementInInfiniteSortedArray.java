import java.util.ArrayList;
import java.util.List;

// Java program to demonstrate working of an algorithm that finds
// an element in an array of infinite size
public class ElementInInfiniteSortedArray {

    // Binary search function to find the element 
    // in a given range
    public static int binarySearch(List<Integer> arr, int l, int r, int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;
            if (arr.get(mid) == x)
                return mid;
            if (arr.get(mid) > x)
                return binarySearch(arr, l, mid - 1, x);
            return binarySearch(arr, mid + 1, r, x);
        }
        return -1;
    }

    // Function to find the position of the key in the 
    // infinite-size array (represented as a list)
    public static int findPos(List<Integer> arr, int key) {
        int l = 0, h = 1;

        // Find high to do binary search
        while (h < arr.size() && arr.get(h) < key) {
            // Store previous high
            l = h;
            // Double high index
            h = 2 * h;
        }

        // Clamp high if it goes out of array bounds
        if (h >= arr.size())
            h = arr.size() - 1;

        // At this point, we have updated low and high
        // indices, thus use binary search between them
        return binarySearch(arr, l, h, key);
    }

    public static void main(String[] args) {
        List<Integer> arr = List.of(3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170);
        int k = 170;
        int ans = findPos(arr, k);
        System.out.println(ans);
    }
}