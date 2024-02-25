package com.example.fresh;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.*;


public class MainActivity extends AppCompatActivity {
    String expr = "";
    int num1, num2 = 0;
    int sum = 0;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = findViewById(R.id.txt1);
        Button one = findViewById(R.id.one);
        Button two = findViewById(R.id.two);
        Button three = findViewById(R.id.three);
        Button four = findViewById(R.id.four);
        Button five = findViewById(R.id.five);
        Button six = findViewById(R.id.six);
        Button seven = findViewById(R.id.seven);
        Button eight = findViewById(R.id.eight);
        Button nine = findViewById(R.id.nine);
        Button zero = findViewById(R.id.zero);
        Button clear = findViewById(R.id.clear);
        Button plus = findViewById(R.id.plus);
        Button equal = findViewById(R.id.equal);
        Button multiply = findViewById(R.id.multi);
        Button sub = findViewById(R.id.subt);
        Button divide = findViewById(R.id.divide);
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expr = expr + "0";
                txt.setText(expr);
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expr.length() == 1 && expr.contains("0")) {
                    expr = "";
                }
                expr = expr + "1";
                txt.setText(expr);
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expr = "0";
                txt.setText(expr);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expr.length() == 1 && expr.contains("0")) {
                    expr = "";
                }
                expr = expr + "2";
                txt.setText(expr);
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expr.length() == 1 && expr.contains("0")) {
                    expr = "";
                }
                expr = expr + "3";
                txt.setText(expr);
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expr.length() == 1 && expr.contains("0")) {
                    expr = "";
                }
                expr = expr + "4";
                txt.setText(expr);
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expr.length() == 1 && expr.contains("0")) {
                    expr = "";
                }
                expr = expr + "5";
                txt.setText(expr);
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expr.length() == 1 && expr.contains("0")) {
                    expr = "";
                }
                expr = expr + "6";
                txt.setText(expr);
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expr.length() == 1 && expr.contains("0")) {
                    expr = "";
                }
                expr = expr + "7";
                txt.setText(expr);
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expr.length() == 1 && expr.contains("0")) {
                    expr = "";
                }
                expr = expr + "8";
                txt.setText(expr);
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expr.length() == 1 && expr.contains("0")) {
                    expr = "";
                }
                expr = expr + "9";
                txt.setText(expr);
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expr = expr + "+";
                txt.setText(expr);
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expr = expr + "*";
                txt.setText(expr);
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expr = expr + "-";
                txt.setText(expr);
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                double ans = evaluateExpression(expr);
                txt.setText(Double.toString(ans));
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expr = expr + "/";
                txt.setText(expr);
            }
        });
    }


    public  double evaluateExpression(String expression) {
        Stack<Double> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (Character.isDigit(c)) {
                StringBuilder num = new StringBuilder();
                num.append(c);
                while (i + 1 < expression.length() && (Character.isDigit(expression.charAt(i + 1)) || expression.charAt(i + 1) == '.')) {
                    num.append(expression.charAt(++i));
                }
                operands.push(Double.parseDouble(num.toString()));
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(c)) {
                    processOperator(operands, operators);
                }
                operators.push(c);
            }
        }

        while (!operators.isEmpty()) {
            processOperator(operands, operators);
        }

        return operands.pop();
    }

    private static int precedence(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }

    private static void processOperator(Stack<Double> operands, Stack<Character> operators) {
        char op = operators.pop();
        double b = operands.pop();
        double a = operands.pop();
        double result = 0;
        switch (op) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                result = a / b;
                break;
        }
        operands.push(result);
    }
}







