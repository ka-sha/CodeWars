public class Runes {
    
    static int operation;
    static int eq;
    static Operator operator;
    static int i;

    public static int solveExpression(final String expression) {
        int missingDigit = -1;
        operation = eq = i =0;
        operator = null;

        init(expression);

        String firstNumber = expression.substring(0, operation);
        String secondNumber = expression.substring(operation + 1, eq);
        String result = expression.substring(eq + 1);

        i = (questionMarkFirst(firstNumber, secondNumber, result)) ? 1 : 0;
        while (i <= 9) {
            int first, second, res;
            if (uniqueNumber(firstNumber, secondNumber, result, String.valueOf(i))) {
                first = Integer.parseInt(firstNumber.replaceAll("\\?", String.valueOf(i)));
                second = Integer.parseInt(secondNumber.replaceAll("\\?", String.valueOf(i)));
                res = Integer.parseInt(result.replaceAll("\\?", String.valueOf(i)));
            } else {
                i++;
                continue;
            }

            if (operator.operation(first, second) == res) {
                missingDigit = i;
                break;
            }
            i++;
        }

        return missingDigit;
    }

    private static void init(String expression) {
        for (; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (i != 0 && (c == '+' || c == '-' || c == '*')) {
                operation = i;
                operator = implementation(c);
                break;
            }
        }
        for (; i < expression.length(); i++)
            if (expression.charAt(i) == '=') {
                eq = i;
                break;
            }
    }

    private static boolean questionMarkFirst(String s1, String s2, String s3) {
        return questionMarkFirstLittle(s1) || questionMarkFirstLittle(s2) || questionMarkFirstLittle(s3);
    }

    private static boolean questionMarkFirstLittle(String s) {
        return s.length() >= 2 && (s.startsWith("?") || s.startsWith("-?"));
    }

    private static Operator implementation(char symbol) {
        if (symbol == '+')
            return Integer::sum;
        else if (symbol == '-')
            return  (x1, x2) -> x1 - x2;
        else
            return (x1, x2) -> x1 * x2;
    }

    private static boolean uniqueNumber(String s1, String s2, String s3, String symbol) {
        return !(s1.contains(symbol)
                || s2.contains(symbol)
                || s3.contains(symbol));
    }
}

interface Operator {
    int operation(int x1, int x2);
}
