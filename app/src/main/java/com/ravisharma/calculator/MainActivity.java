package com.ravisharma.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {


    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9,
            btnPercent, btnPlus, btnMinus, btnMultiply, btnDivision, btnEqual,
            btnAllClear, btnClear, btnDot, btnBracket;

    TextView tvInput, tvOutput;

    String process = "";
    boolean checkBracket = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnDivision = findViewById(R.id.btnDivision);
        btnMultiply = findViewById(R.id.btnMultiply);

        btnEqual = findViewById(R.id.btnEqual);

        btnAllClear = findViewById(R.id.btnAllClear);
        btnClear = findViewById(R.id.btnClear);
        btnDot = findViewById(R.id.btnDot);
        btnPercent = findViewById(R.id.btnPercent);
        btnBracket = findViewById(R.id.btnBracket);

        tvInput = findViewById(R.id.tvInput);
        tvOutput = findViewById(R.id.tvOutput);

        btnAllClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvInput.setText("");
                tvOutput.setText("");
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = process.substring(0, process.length() - 1);
                tvInput.setText(process);
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvInput.getText().toString() + "0";
                tvInput.setText(process);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvInput.getText().toString() + "1";
                tvInput.setText(process);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvInput.getText().toString() + "2";
                tvInput.setText(process);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvInput.getText().toString() + "3";
                tvInput.setText(process);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvInput.getText().toString() + "4";
                tvInput.setText(process);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvInput.getText().toString() + "5";
                tvInput.setText(process);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvInput.getText().toString() + "6";
                tvInput.setText(process);
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvInput.getText().toString() + "7";
                tvInput.setText(process);
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvInput.getText().toString() + "8";
                tvInput.setText(process);
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvInput.getText().toString() + "9";
                tvInput.setText(process);
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (process.length() == 0 || process.charAt(process.length() - 1) == '+') {
                    return;
                }
                if (process.charAt(process.length() - 1) == '-' ||
                        process.charAt(process.length() - 1) == '×' ||
                        process.charAt(process.length() - 1) == '/' ||
                        process.charAt(process.length() - 1) == '%') {

                    StringBuilder myName = new StringBuilder(process);
                    myName.setCharAt(process.length() - 1, '+');
                    process = myName.toString();
                    tvInput.setText(process);
                } else {
                    process = tvInput.getText().toString() + "+";
                    tvInput.setText(process);
                }
            }
        });


        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (process.length() == 0 || process.charAt(process.length() - 1) == '-') {
                    return;
                }
                if (process.charAt(process.length() - 1) == '+' ||
                        process.charAt(process.length() - 1) == '×' ||
                        process.charAt(process.length() - 1) == '/' ||
                        process.charAt(process.length() - 1) == '%') {
                    StringBuilder myName = new StringBuilder(process);
                    myName.setCharAt(process.length() - 1, '-');
                    process = myName.toString();
                    tvInput.setText(process);
                } else {
                    process = tvInput.getText().toString() + "-";
                    tvInput.setText(process);
                }
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (process.length() == 0 || process.charAt(process.length() - 1) == '×') {
                    return;
                }
                if (process.charAt(process.length() - 1) == '+' ||
                        process.charAt(process.length() - 1) == '-' ||
                        process.charAt(process.length() - 1) == '/' ||
                        process.charAt(process.length() - 1) == '%') {
                    StringBuilder myName = new StringBuilder(process);
                    myName.setCharAt(process.length() - 1, '×');
                    process = myName.toString();
                    tvInput.setText(process);
                } else {
                    process = tvInput.getText().toString() + "×";
                    tvInput.setText(process);
                }
            }
        });

        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (process.length() == 0 || process.charAt(process.length() - 1) == '/') {
                    return;
                }
                if (process.charAt(process.length() - 1) == '+' ||
                        process.charAt(process.length() - 1) == '×' ||
                        process.charAt(process.length() - 1) == '-' ||
                        process.charAt(process.length() - 1) == '%') {
                    StringBuilder myName = new StringBuilder(process);
                    myName.setCharAt(process.length() - 1, '/');
                    process = myName.toString();
                    tvInput.setText(process);
                } else {
                    process = tvInput.getText().toString() + "/";
                    tvInput.setText(process);
                }
            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (process.length() == 0) {
                    process = "0.";
                } else {
                    process = tvInput.getText().toString() + ".";
                }
                tvInput.setText(process);
            }
        });

        btnPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (process.length() == 0 || process.charAt(process.length() - 1) == '%') {
                    return;
                }
                if (process.charAt(process.length() - 1) == '-' ||
                        process.charAt(process.length() - 1) == '×' ||
                        process.charAt(process.length() - 1) == '/' ||
                        process.charAt(process.length() - 1) == '+') {
                    StringBuilder myName = new StringBuilder(process);
                    myName.setCharAt(process.length() - 1, '%');
                    process = myName.toString();
                    tvInput.setText(process);
                } else {
                    process = tvInput.getText().toString() + "%";
                    tvInput.setText(process);
                    calculateResult();
                }
            }
        });

        btnBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkBracket) {
                    process = tvInput.getText().toString() + ")";
                    tvInput.setText(process);
                    checkBracket = false;
                } else {
                    process = tvInput.getText().toString() + "(";
                    tvInput.setText(process);
                    checkBracket = true;
                }

            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = tvInput.getText().toString();

                calculateResult();
            }
        });


    }

    private void calculateResult() {
        process = process.replaceAll("×", "*");
        process = process.replaceAll("%", "/100");
        process = process.replaceAll("÷", "/");

        Context rhino = Context.enter();

        rhino.setOptimizationLevel(-1);

        String finalResult = "";

        try {
            Scriptable scriptable = rhino.initStandardObjects();
            finalResult = rhino.evaluateString(scriptable, process, "javascript", 1, null).toString();
        } catch (Exception e) {
            finalResult = "0";
        }

        tvOutput.setText(finalResult);
        tvInput.setText("");
    }
}