/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
// public class NestedIterator1 implements Iterator<Integer> {
//     int n =0;
//     Queue<Integer> q;
//     public NestedIterator1(List<NestedInteger> nestedList) {
//         q = new LinkedList<>();
//         for(NestedInteger s:nestedList){
//             if(s.isInteger()){
//                 q.add(s.getInteger());
//             }
//             else{
//                 List<Integer> l = getIntegers(s);
//                 q.addAll(l);
//             }
//         }
//     }
//     List<Integer> getIntegers(NestedInteger sl){
//         List<NestedInteger> list = sl.getList();
//         List<Integer> ls= new ArrayList<>(); 
//         for(NestedInteger s:list){
//             if(s.isInteger()){
//                 ls.add(s.getInteger());
//             }
//             else{
//                 List<Integer> lt = getIntegers(s);
//                 ls.addAll(lt);
//             }
//         }
//         return ls;
//     }
//     @Override
//     public Integer next() {
//         return q.poll();   
//     }

//     @Override
//     public boolean hasNext() {
//         return !q.isEmpty();
//     }
// }

public class NestedIterator implements Iterator<Integer> {
    private List<Integer> integers = new ArrayList<>();
    private int index;

    public NestedIterator(List<NestedInteger> nestedList) {
        flatternList(nestedList);
        index = 0;
    }

    private void flatternList (List<NestedInteger> nestedList) {
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                integers.add(ni.getInteger());
            } else {
                flatternList(ni.getList());
            }
        }
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            int ans = integers.get(index);
            index++;
            return ans;
        } else {
            throw new RuntimeException("no next");
        }
    }

    @Override
    public boolean hasNext() {
        if (index >= integers.size()) {
            return false;
        } else {
            return true;
        }
    }
}
/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */