class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        func("", ans, 0,0,n);
        return ans;
    }
    public void func(String curr, List<String> ans, int open, int close, int n){
        if(close > open) return;
        if(open == n && close == n){
            ans.add(curr);
            return;
        }
        if(open != n){
            func(curr+"(", ans, open+1, close, n);
        }
        if(close != n){
            func(curr+")",ans, open, close+1, n);
        }
        return;
    }
}
