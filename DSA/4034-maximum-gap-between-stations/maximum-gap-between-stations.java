class Solution {
    public int maximumGap(String skill, String station) {
        int n = skill.length();
        int m = station.length();

        int[] right = new int[n];
        int[] left = new int[n];

        int j = 0;
        for(int i = 0; i < n; i++) {
            while(skill.charAt(i) != station.charAt(j)) {
                j++;
            }
            left[i] = j;
            j++;
        }

        j = m - 1;
        for(int i = n - 1; i >= 0; i--) {
            while(skill.charAt(i) != station.charAt(j)) {
                j--;
            }
            right[i] = j;
            j--; 
        }

        int res = 0;
        for(int i = 0; i < n - 1; i++) {
            res = Math.max(res, right[i + 1] - left[i]);
        }

        return res;
    }
}