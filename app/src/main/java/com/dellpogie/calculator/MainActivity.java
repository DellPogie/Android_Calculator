package com.dellpogie.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnDot;
    Button btnNegate;
    Button btnPercent;
    Button btn0;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btnClear;
    Button btnAdd;
    Button btnSubtract;
    Button btnMultiply;
    Button btnDivide;
    Button btnEqual;
    String strResult;
    String strFirstNo;
    String strOperator;
    String strMathLog = "";
    TextView txvResult;
    TextView txtMathLog;
    Boolean bolEqual = true;
    Boolean bolActivateNumber = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        setListeners();
    }

    private void initialize() {
        btn0 = (Button)findViewById(R.id.btn0);
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        btn4 = (Button)findViewById(R.id.btn4);
        btn5 = (Button)findViewById(R.id.btn5);
        btn6 = (Button)findViewById(R.id.btn6);
        btn7 = (Button)findViewById(R.id.btn7);
        btn8 = (Button)findViewById(R.id.btn8);
        btn9 = (Button)findViewById(R.id.btn9);
        btnClear = (Button)findViewById(R.id.btnClear);
        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnSubtract = (Button)findViewById(R.id.btnSubtract);
        btnMultiply = (Button)findViewById(R.id.btnMultiply);
        btnDivide = (Button)findViewById(R.id.btnDivide);
        btnEqual = (Button)findViewById(R.id.btnEqual);
        btnDot = (Button)findViewById(R.id.btnDot);
        btnNegate = (Button)findViewById(R.id.btnNegate);
        btnPercent = (Button)findViewById(R.id.btnPercent);
        txvResult = (TextView)findViewById(R.id.txvResult);
        txtMathLog = (TextView) findViewById(R.id.txtMathLog);
    }

    // set on click listeners
    private void setListeners() {
        // number buttons
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClicked("1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClicked("2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClicked("3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClicked("4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClicked("5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClicked("6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClicked("7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClicked("8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClicked("9");
            }
        });
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClicked("0");
            }
        });
        // operator buttons
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operatorClicked("+");
            }
        });
        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operatorClicked("-");
            }
        });
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operatorClicked("*");
            }
        });
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operatorClicked("/");
            }
        });
        // equal button
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equalClicked();
            }
        });
        // clear button
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearClicked();
            }
        });
        btnNegate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operatorClicked("+/-");
            }
        });
        btnPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operatorClicked("%");
            }
        });
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { numberClicked("."); }
        });
    }

    private void equalClicked() {
        if (bolEqual) {
            bolEqual = false;
            bolActivateNumber = false;
            double intResult = 0;
            try {
                double intNo1 = Double.valueOf(strFirstNo);
                double intNo2 = Double.valueOf(txvResult.getText().toString());
                switch (strOperator) {
                    case "+":
                        intResult = intNo1 + intNo2;
                        break;
                    case "-":
                        intResult = intNo1 - intNo2;
                        break;
                    case "*":
                        intResult = intNo1 * intNo2;
                        break;
                    case "/":
                        intResult = intNo1 / intNo2;
                        break;
                }
                strResult = String.valueOf(intResult);
                txvResult.setText(strResult);
                strMathLog = strMathLog + " = " + strResult;
                txtMathLog.setText(strMathLog);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void operatorClicked(String strOperator) {
        strMathLog = strMathLog + " " + strOperator + " ";
        txtMathLog.setText(strMathLog);
        strFirstNo = txvResult.getText().toString();
        this.strOperator = strOperator;
        txvResult.setText("");
    }

    private void clearClicked() {
        strResult = "";
        txvResult.setText("");
        strMathLog = "";
        txtMathLog.setText(strMathLog);
        bolActivateNumber = true;
    }

    private void numberClicked(String tmpResult) {
        if (bolActivateNumber) {
            strMathLog = strMathLog + tmpResult;
            txtMathLog.setText(strMathLog);
            bolEqual = true;
            strResult = txvResult.getText().toString();
            strResult = strResult + tmpResult;
            txvResult.setText(strResult);
        }
    }

}