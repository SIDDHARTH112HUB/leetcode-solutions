/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public NestedInteger deserialize(String s) {
        NestedInteger ns = new NestedInteger();
        int n = s.length();
        int i =0;
        boolean isList =false;
        int t =n;
        if(s.charAt(i)=='[')
        {
            isList =true;
            i++;
            t--;
        }    
        StringBuilder sb = new StringBuilder();
        while(i<t){
            char c  = s.charAt(i);
            if(Character.isDigit(c) || c=='-'){
                sb.append(c);
                i++;
            }
            else if(c==','){
                isList = true;
                if (sb.length() != 0)
                ns.add(new NestedInteger(Integer.parseInt(sb.toString())));
                sb = new StringBuilder();
                i++;
            }
            else if(c=='['){
                isList = true;
                int count =1;
                sb.append(c);
                i++;
                while(count!=0 && i<t){
                    c = s.charAt(i);
                    sb.append(c);
                    if(c=='[')
                    count++;
                    else if(c==']')
                    count--;
                    i++;
                }
                ns.add(deserialize(sb.toString()));
                sb = new StringBuilder();
            }
        }
        if (sb.length() != 0)
        {
            if(isList==true)
            ns.add(new NestedInteger(Integer.parseInt(sb.toString())));
            else
            ns.setInteger(Integer.parseInt(sb.toString()));
        }
        return ns;
    }
}