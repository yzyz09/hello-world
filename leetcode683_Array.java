class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        int len = flowers.length;
        int[] days = new int[len];
        for(int i = 0; i < len; i++){
            days[flowers[i] - 1] = i + 1;
        }
        int left = 0, right = k + 1, res = Integer.MAX_VALUE;
        for(int i = 0; right < len; i++){
            if(days[i] < days[left] || days[i] <= days[right]){
                if(i == right)
                    res = Math.min(res, Math.max(days[left], days[right]));
                left = i;
                right = i + k + 1;
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
