package com.example.exampleapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorController {
    @FXML
    private TextField result;
    private long number1;
    private String operator = "";
    private boolean start = true;
   // private Model model = new Model();

    @FXML
    public void processNumbers(ActionEvent event) {
        if (start) {
            result.setText("");
            start = false;
        }
        String value = ((Button) event.getSource()).getText();
        result.setText(result.getText() + value);

    }

    @FXML
    public void processOperators(ActionEvent event) {
        String value = ((Button) event.getSource()).getText();
        if (!value.equals("=")) {
            if (!operator.isEmpty())
                return;
            operator = value;
            number1 = Long.parseLong(result.getText());
            result.setText("");
        } else {
            if (operator.isEmpty())
                return;
            long number2 = Long.parseLong(result.getText());
            calculate(number1, number2, operator);
            operator = "";
            start = true;
        }

    }

    public void calculate(long n1, long n2, String op) {
        switch (op) {
            case "+":
                result.setText(n1 + n2 + "");
                break;
            case "-":
                result.setText(n1 - n2 + "");
                break;
            case "*":
                result.setText(n1 * n2 + "");
                break;
            case "/":
                if (n2 == 0) {
                    result.setText("0");
                    break;
                }
                result.setText(n1 / n2 + "");
                break;

        }
    }
}