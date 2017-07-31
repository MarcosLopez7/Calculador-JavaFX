package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.awt.event.ActionEvent;


public class Controller {

    private String expression = "";
    @FXML
    private Label label;


    public void addNine(ActionEvent event) {
        expression += "9";
        label.setText(expression);
    }

    public void addEight(ActionEvent event) {
        expression += "8";
        label.setText(expression);
    }

    public void addSeven(ActionEvent event) {
        expression += "7";
        label.setText(expression);
    }

    public void addSix(ActionEvent event) {
        expression += "6";
        label.setText(expression);
    }

    public void addFive(ActionEvent event) {
        expression += "5";
        label.setText(expression);
    }

    public void addFour(ActionEvent event) {
        expression += "4";
        label.setText(expression);
    }

    public void addThree(ActionEvent event) {
        expression += "3";
        label.setText(expression);
    }

    public void addTwo(ActionEvent event) {
        expression += "2";
        label.setText(expression);
    }

    public void addOne(ActionEvent event) {
        expression += "1";
        label.setText(expression);
    }

    public void addDivition(ActionEvent event) {
        expression += "/";
        label.setText(expression);
    }

    public void addMultiplication(ActionEvent event) {
        expression += "*";
        label.setText(expression);
    }

    public void addSubtration(ActionEvent event) {
        expression += "-";
        label.setText(expression);
    }

    public void addSum(ActionEvent event) {
        expression += "+";
        label.setText(expression);
    }
}
