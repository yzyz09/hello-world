class Solution {
    public int totalFruit(int[] tree) {
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int res = 0;
        for(;right < tree.length; right++){
            map.put(tree[right], map.getOrDefault(tree[right], 0) + 1);
            if(map.size() > 2){
                map.put(tree[left], map.get(tree[left]) - 1);
                if(map.get(tree[left]) == 0)
                    map.remove(tree[left]);
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
