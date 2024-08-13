class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        return diffWaysToCompute(expression, new HashMap<>());
    }

    private List<Integer> diffWaysToCompute(String expression, Map<String, List<Integer>> memo) {
        if (memo.containsKey(expression))
            return memo.get(expression);
        var values = new ArrayList<Integer>();

        if (!hasOperator(expression))
            values.add(Integer.parseInt(expression));
        else
            for (var i = 0; i < expression.length(); i++) {
                var symbol = expression.charAt(i);
                if (!Character.isDigit(symbol)) {
                    var leftParts = diffWaysToCompute(expression.substring(0, i), memo);
                    var rightParts = diffWaysToCompute(expression.substring(i + 1), memo);

                    for (var l : leftParts)
                        for (var r : rightParts)
                            switch (symbol) {
                                case '+' : values.add(l + r); break;
                                case '-' : values.add(l - r); break;
                                case '*' : values.add(l * r); break;
                            }
                }
            }

        return memo.compute(expression, (k, v) -> values);
    }

    private boolean hasOperator(String expression) {
        for (var i = 0; i < expression.length(); i++)
            switch (expression.charAt(i)) {
                case '+', '-', '*' :
                    return true;
                    // break;
            }
        return false;
    }
}
