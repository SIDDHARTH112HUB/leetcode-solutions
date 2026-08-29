class Solution {
    public int secondsBetweenTimes(String st, String et) {
        int start = Integer.parseInt(st.substring(0,2))*60*60+Integer.parseInt(st.substring(3,5))*60+Integer.parseInt(st.substring(6,8));
        int end = Integer.parseInt(et.substring(0,2))*60*60+Integer.parseInt(et.substring(3,5))*60+Integer.parseInt(et.substring(6,8));
        return end - start;
    }
}