package com.example.syamiyer.calculator.Controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.syamiyer.calculator.R;

public class MainActivity extends AppCompatActivity {

    private int currentOperation;
    //0 = no current operation
    //1 = +
    //2 = -
    //3 = *
    //4 = /

    private EditText newNumber;
    private EditText result;
    private TextView operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newNumber = findViewById(R.id.newNumber);
        result = findViewById(R.id.result);
        operation = findViewById(R.id.operation);

    }

    public void clickedNumber(View view) {
        Button btnClicked = (Button) view;
        if (newNumber.getText().toString().isEmpty()) {
            //empty
            newNumber.setText(btnClicked.getText());
        }
        else {
            newNumber.append(btnClicked.getText());
        }
    }

    public void clickedPlus(View view) {
        moveNewNumToResult();

        //change the operation TextView to +
        operation.setText("+");
        currentOperation = 1;
    }

    public void clickedMinus(View view) {
        moveNewNumToResult();

        //change the operation TextView to -
        operation.setText("-");
        currentOperation = 2;
    }

    public void clickedMultiply(View view) {
        moveNewNumToResult();

        //change the operation TextView to *
        operation.setText("*");
        currentOperation = 3;
    }

    public void clickedDivide(View view) {
        moveNewNumToResult();

        //change the operation TextView to /
        operation.setText("/");
        currentOperation = 4;
    }

    public void clickedEquals(View view) {

        //change the operation TextView to =
        operation.setText("=");
        performCalculation();

    }

    public void moveNewNumToResult() {

        if (newNumber.getText().toString().isEmpty() == false) {
            //move newNumber to result
            result.setText(newNumber.getText());
            newNumber.getText().clear();
        }

    }

    public void performCalculation() {

        if (result.getText().toString().isEmpty() == false) {
            double firstNumber = Double.parseDouble(result.getText().toString());
            double secondNumber = Double.parseDouble(newNumber.getText().toString());
            String res = "";
            //get the operand and perform operation
            switch (currentOperation) {
                case 0:
                    System.out.println("No operation selected");
                    break;
                case 1:
                    res = Double.toString(performPlus(firstNumber, secondNumber));
                    break;
                case 2:
                    res = Double.toString(performMinus(firstNumber, secondNumber));
                    break;
                case 3:
                    res = Double.toString(performMultiply(firstNumber, secondNumber));
                    break;
                case 4:
                    res = Double.toString(performDivide(firstNumber, secondNumber));
                    break;
            }
            result.setText(res);
            newNumber.getText().clear();
            currentOperation = 0;
            operation.setText("");
        }
    }

    public double performPlus(double num1, double num2) {
        return num1 + num2;
    }
    public double performMinus(double num1, double num2) {
        return num1 - num2;
    }
    public double performMultiply(double num1, double num2) {
        return num1 * num2;
    }
    public double performDivide(double num1, double num2) {
        return num1 / num2;
    }
}
