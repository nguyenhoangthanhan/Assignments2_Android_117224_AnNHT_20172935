package com.andeptrai.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    Button ce, c, bs, divide, multi, substract, add, equal, point, zero
            , one, two, three, four, five, six, seven, eight, nine, convert;
    TextView textView;

    public ArrayList<String> arrOperations;

    public ArrayList<Double> arrNumbers;

    public boolean check = false;

    public int addOperation(String input){
        arrOperations = new ArrayList<>();

        char[] cArray = input.toCharArray();
        for (int i = 0; i < cArray.length; i++) {
            switch (cArray[i]) {
                case '+':
                    arrOperations.add(cArray[i] + "");
                    break;
                case '-':
                    arrOperations.add(cArray[i] + "");
                    break;
                case '*':
                    arrOperations.add(cArray[i] + "");
                    break;
                case '/':
                    arrOperations.add(cArray[i] + "");
                    break;
                default:

            }
        }
        return  0;
    }

    public void addNumber(String stringInput){
        arrNumbers = new ArrayList<>();
        Pattern regex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
        Matcher matcher = regex.matcher(stringInput);
        while (matcher.find()){
            arrNumbers.add(Double.valueOf(matcher.group(1)));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        addListenner();

    }

    private void init() {
        textView = findViewById(R.id.textView);


        ce = findViewById(R.id.ce);
        c = findViewById(R.id.c);
        bs = findViewById(R.id.bs);
        divide = findViewById(R.id.divide);
        multi = findViewById(R.id.multi);
        substract = findViewById(R.id.substract);
        add = findViewById(R.id.add);
        equal = findViewById(R.id.equal);
        point = findViewById(R.id.point);
        zero = findViewById(R.id.zero);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        convert = findViewById(R.id.convert);

    }

    private void addListenner() {

        textView.setText("");

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(textView.getText().toString() + "/");
            }
        });

        multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(textView.getText().toString() + "*");
            }
        });

        substract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(textView.getText().toString() + "-");
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(textView.getText().toString() + "+");
            }
        });

        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(textView.getText().toString() + ".");
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(textView.getText().toString() + "0");
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(textView.getText().toString() + "1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(textView.getText().toString() + "2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(textView.getText().toString() + "3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(textView.getText().toString() + "4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(textView.getText().toString() + "5");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(textView.getText().toString() + "6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(textView.getText().toString() + "7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(textView.getText().toString() + "8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(textView.getText().toString() + "9");
            }
        });

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = textView.getText().toString();
                try {
                    Float.parseFloat(s);
                    textView.setText(s+"");
                    if (textView.getText().toString().substring(0, 1).equals("-")){
                        textView.setText(textView.getText().toString().substring(1));
                    }
                    else{
                        textView.setText("-" + textView.getText().toString());
                    }
                } catch (Exception e) {

                    double result = 0;
                    addOperation(s);
                    addNumber(s);

                    for (int i = 0; i < arrNumbers.size() - 1; i ++){
                        switch (arrOperations.get(i)){
                            case "+":
                                if (i == 0){
                                    result = arrNumbers.get(i) + arrNumbers.get(i + 1);
                                }
                                else{
                                    result = result + arrNumbers.get(i + 1);
                                }
                                break;
                            case "-":
                                if (i == 0){
                                    result = arrNumbers.get(i) - arrNumbers.get(i + 1);
                                }
                                else{
                                    result = result - arrNumbers.get(i + 1);
                                }
                                break;
                            case "*":
                                if (i == 0){
                                    result = arrNumbers.get(i) * arrNumbers.get(i + 1);
                                }
                                else{
                                    result = result * arrNumbers.get(i + 1);
                                }
                                break;
                            case "/":
                                if (i == 0){
                                    result = arrNumbers.get(i) / arrNumbers.get(i + 1);
                                }
                                else{
                                    result = result / arrNumbers.get(i + 1);
                                }
                                break;
                            default:
                                break;
                        }
                    }

                    textView.setText(result+"");
                    if (textView.getText().toString().substring(0, 1).equals("-")){
                        textView.setText(textView.getText().toString().substring(1));
                    }
                    else{
                        textView.setText("-" + textView.getText().toString());
                    }
                }


            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = textView.getText().toString();

                try {
                    Float.parseFloat(s);
                    textView.setText(s+"");
                } catch (Exception e) {

                    double result = 0;
                    addOperation(s);
                    addNumber(s);

                    for (int i = 0; i < arrNumbers.size() - 1; i ++){
                        switch (arrOperations.get(i)){
                            case "+":
                                if (i == 0){
                                    result = arrNumbers.get(i) + arrNumbers.get(i + 1);
                                }
                                else{
                                    result = result + arrNumbers.get(i + 1);
                                }
                                break;
                            case "-":
                                if (i == 0){
                                    result = arrNumbers.get(i) - arrNumbers.get(i + 1);
                                }
                                else{
                                    result = result - arrNumbers.get(i + 1);
                                }
                                break;
                            case "*":
                                if (i == 0){
                                    result = arrNumbers.get(i) * arrNumbers.get(i + 1);
                                }
                                else{
                                    result = result * arrNumbers.get(i + 1);
                                }
                                break;
                            case "/":
                                if (i == 0){
                                    result = arrNumbers.get(i) / arrNumbers.get(i + 1);
                                }
                                else{
                                    result = result / arrNumbers.get(i + 1);
                                }
                                break;
                            default:
                                break;
                        }
                    }

                    textView.setText(result+"");
                }


            }
        });

        ce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("");
            }
        });

        bs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!textView.getText().toString().equals("")){
                    textView.setText(textView.getText().toString().substring(0, textView.getText().toString().length() - 1));
                }
            }
        });

    }


}
