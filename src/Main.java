import java.util.Scanner;

public class Main {
    static boolean isRoman;
    String operation = null;

    String result = null;
    public static String calc(String input) {
        int num1 = 0;
        int num2 = 0;
        int result = 0;
        Expression exp = parse(input);
        num1 = exp.getNum1();
        num2 = exp.getNum2();
        if ((num1 < 1 || num2 < 1) || (num1 > 10 || num2 > 10)) throw new RuntimeException("Ошибка: числа должны быть от 1 до 10");
        if (exp.getOperation().equals("+")) {
            result = num1 + num2;
        } else if (exp.getOperation().equals("-")) {
            result = num1 - num2;
        } else if (exp.getOperation().equals("/")) {
            result = num1 / num2;
        } else result = num1 * num2;
        if (isRoman == true) {
            if (result < 1) throw new RuntimeException("Ошибка: Результатом работы калькулятора с римскими числами могут быть только положительные числа");
            return Numbers.toRoman(result);
        }
        else return String.valueOf(result);
    }

    private static Expression parse(String input) {
        Expression exp = new Expression();
        String[] expression = input.split(" ");
        if (expression.length != 3) throw new RuntimeException("Ошибка: должны присутствовать два числа и один арифметический оператор");
        exp.setOperation(defineOperation(expression[1]));
        if (Numbers.isRoman(expression[0]) && Numbers.isRoman(expression[2])) isRoman = true;
        else if (!Numbers.isRoman(expression[0]) && !Numbers.isRoman(expression[2])) isRoman = false;
        else throw new RuntimeException("Ошибка: два числа должны быть одного формата");
        exp.setNum1(Numbers.toInt(expression[0]));
        exp.setNum2(Numbers.toInt(expression[2]));
        return exp;
    }
    private static String defineOperation(String op) {
        if(op.equals("+")) return "+";
        else if(op.equals("-")) return "-";
        else if(op.equals("*")) return "*";
        else if(op.equals("/")) return "/";
        else throw new RuntimeException("Ошибка: введен некорректный оператор");
    }

    private static class Expression {
        private int num1;
        private int num2;
        private String operation;

        public int getNum1() {
            return num1;
        }

        public int getNum2() {
            return num2;
        }

        public void setNum1(int num1) {
            this.num1 = num1;
        }

        public void setNum2(int num2) {
            this.num2 = num2;
        }

        public String getOperation() {
            return operation;
        }

        public void setOperation(String operation) {
            this.operation = operation;
        }
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        while(true) {
            String input = console.nextLine();
            System.out.println(calc(input));
        }
    }

}
