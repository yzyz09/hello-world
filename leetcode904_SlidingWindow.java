class Solution {
    public int totalFruit(int[] tree) {
        int[] map = new int[tree.length];
        int count = 0;
        int left = 0, right = 0;
        int res = 0;
        for(; right < tree.length; right++){
            map[tree[right]]++;
            if(map[tree[right]] ==1 )
                count++;
            while(count > 2){
                map[tree[left]]--;
                if(map[tree[left]] == 0)
                    count--;
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
