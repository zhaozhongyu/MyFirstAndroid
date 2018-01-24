package com.zzy.calculater1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView infoView;
    TextView resultView;
    TextView memorymark;
    double memory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        infoView = (TextView) findViewById(R.id.infoText);
        resultView = (TextView) findViewById(R.id.resultText) ;
        memorymark = (TextView) findViewById(R.id.memorymark);
        resultView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "click result view", Toast.LENGTH_SHORT).show();
            }
        });
        infoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, String.valueOf(infoView.getLineHeight())+" "+String.valueOf(infoView.getHeight()), Toast.LENGTH_SHORT).show();
            }
        });
        Button bt0 = (Button) findViewById(R.id.zero);
        Button bt1 = (Button) findViewById(R.id.one);
        Button bt2 = (Button) findViewById(R.id.two);
        Button bt3 = (Button) findViewById(R.id.three);
        Button bt4 = (Button) findViewById(R.id.four);
        Button bt5 = (Button) findViewById(R.id.five);
        Button bt6 = (Button) findViewById(R.id.six);
        Button bt7 = (Button) findViewById(R.id.seven);
        Button bt8 = (Button) findViewById(R.id.eight);
        Button bt9 = (Button) findViewById(R.id.nine);

        Button mc = (Button) findViewById(R.id.mc);
        Button mplus = (Button) findViewById(R.id.mplus);
        Button mminus = (Button) findViewById(R.id.mminus);
        Button mr = (Button) findViewById(R.id.mr);
        Button c = (Button) findViewById(R.id.c);
        Button devide = (Button) findViewById(R.id.devide);
        Button times = (Button) findViewById(R.id.times);
        Button del = (Button) findViewById(R.id.del);
        Button minus = (Button) findViewById(R.id.minus);
        Button plus = (Button) findViewById(R.id.plus);
        Button equal = (Button) findViewById(R.id.equal);
        Button percent = (Button) findViewById(R.id.percent);
        Button point = (Button) findViewById(R.id.point);

        bt0.setOnClickListener(this);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        bt5.setOnClickListener(this);
        bt6.setOnClickListener(this);
        bt7.setOnClickListener(this);
        bt8.setOnClickListener(this);
        bt9.setOnClickListener(this);
        mc.setOnClickListener(this);
        mplus.setOnClickListener(this);
        mminus.setOnClickListener(this);
        mr.setOnClickListener(this);
        c.setOnClickListener(this);
        devide.setOnClickListener(this);
        del.setOnClickListener(this);
        times.setOnClickListener(this);
        minus.setOnClickListener(this);
        plus.setOnClickListener(this);
        equal.setOnClickListener(this);
        percent.setOnClickListener(this);
        point.setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return true;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.zero:
                infoView.append("0");
                resultView.setText(calculate());
                break;
            case R.id.one:
                infoView.append("1");
                resultView.setText(calculate());
                break;
            case R.id.two:
                infoView.append("2");
                resultView.setText(calculate());
                break;
            case R.id.three:
                infoView.append("3");
                resultView.setText(calculate());
                break;
            case R.id.four:
                infoView.append("4");
                resultView.setText(calculate());
                break;
            case R.id.five:
                infoView.append("5");
                resultView.setText(calculate());
                break;
            case R.id.six:
                infoView.append("6");
                resultView.setText(calculate());
                break;
            case R.id.seven:
                infoView.append("7");
                resultView.setText(calculate());
                break;
            case R.id.eight:
                infoView.append("8");
                resultView.setText(calculate());
                break;
            case R.id.nine:
                infoView.append("9");
                resultView.setText(calculate());
                break;
            case R.id.c:
                infoView.setText("");
                resultView.setText("");
                break;
            case R.id.devide:
                if(!TextUtils.isEmpty(infoView.getText())){
                    String cs = infoView.getText().toString();
                    char c = cs.charAt(cs.length() - 1) ;
                    if(Character.isDigit(c)){
                        infoView.append("÷");
                    } else {
                        cs = cs.substring(0, cs.length() -1);
                        cs += "÷";
                        infoView.setText(cs);
                    }
                }
                break;
            case R.id.minus:
                if(!TextUtils.isEmpty(infoView.getText())){
                    String cs = infoView.getText().toString();
                    char c = cs.charAt(cs.length() - 1) ;
                    if(c != '+' && c != '-'){
                        infoView.append("-");
                    } else {
                        cs = cs.substring(0, cs.length() -1);
                        cs += "-";
                        infoView.setText(cs);
                    }
                }
                break;
            case R.id.del:
                if(!TextUtils.isEmpty(infoView.getText())) {
                    String text = infoView.getText().toString();
                    text = text.substring(0,text.length()-1);
                    infoView.setText(text);
                    resultView.setText(calculate());
                }
                break;
            case R.id.plus:
                if(!TextUtils.isEmpty(infoView.getText())){
                    String cs = infoView.getText().toString();
                    char c = cs.charAt(cs.length() - 1) ;
                    if(c != '+' && c != '-' && c != '×' && c != '÷'){
                        infoView.append("+");
                    }else {
                        cs = cs.substring(0, cs.length() -1);
                        cs += "+";
                        infoView.setText(cs);
                    }

                }
                break;
            case R.id.times:
                if(!TextUtils.isEmpty(infoView.getText())){
                    String cs = infoView.getText().toString();
                    char c = cs.charAt(cs.length() - 1) ;
                    if(c != '+' && c != '-' && c != '×' && c != '÷'){
                        infoView.append("×");
                    }else {
                        cs = cs.substring(0, cs.length() -1);
                        cs += "×";
                        infoView.setText(cs);
                    }
                }
                break;

            case R.id.equal:
                final String result = calculate();
                ObjectAnimator animator = ObjectAnimator.ofFloat(infoView, "translationY", 0f, -300f);
                float infoY = infoView.getHeight() / 2 + infoView.getBottom();
                float resultY = resultView.getHeight() / 2 + resultView.getBottom() ;
                AnimatorSet set = new AnimatorSet();
                set.play(animator);
                float moveY = infoY - resultY ;
                ObjectAnimator animator2 = ObjectAnimator.ofFloat(resultView, "translationY", 0f,moveY);
                ObjectAnimator scaleX = ObjectAnimator.ofFloat(resultView, "scaleX", 1f, 1.5f);
                ObjectAnimator scaleY = ObjectAnimator.ofFloat(resultView, "scaleY", 1f, 1.5f);
                resultView.setPivotX(resultView.getWidth());
                resultView.setPivotY(resultView.getHeight());
                AnimatorSet set1 = new AnimatorSet();
                set1.play(animator2).with(scaleX).with(scaleY);
                set.setDuration(1000);
                set1.setDuration(1000);
                set1.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        resultView.setText("");
                        infoView.setText(result);
                        infoView.setTranslationY(0f);
                        resultView.setTranslationY(0f);
                        resultView.setScaleX(1f);
                        resultView.setScaleY(1f);
                    }
                });
                set.start();
                set1.start();
                break;
            case R.id.mc:
                memory = 0;
                memorymark.setText("");
                break;
            case R.id.mminus:
                try{
                    double num = Double.parseDouble(infoView.getText().toString());
                    memory = memory - num;
                    memorymark.setText("M");
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "Wrong work", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.mplus:
                try{
                    double num = Double.parseDouble(infoView.getText().toString());
                    memory = memory + num;
                    memorymark.setText("M");
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "Wrong work", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.mr:
                if((int)memory == memory){
                    infoView.setText(String.valueOf((int)memory));
                } else {
                    infoView.setText(String.valueOf(memory));
                }
                break;
            default:
                break;
        }

    }

    public String calculate(){
        String str = infoView.getText().toString();
        if(TextUtils.isEmpty(str)){
            return "";
        }
        str = str.replace('×', '*');
        str = str.replace('÷','/');

        if(! Character.isDigit(str.charAt(str.length()-1))){
            str = str.substring(0, str.length()-1);
        }
        double result = eval(str);
        if((int)result == result){
            return String.valueOf((int)result);
        }
        return String.valueOf(result);
    }

    public double eval(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }

            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor
            // factor = `+` factor | `-` factor | `(` expression `)`
            //        | number | functionName factor | factor `^` factor

            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if      (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if      (eat('*')) x *= parseFactor(); // multiplication
                    else if (eat('/')) x /= parseFactor(); // division
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus

                double x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    if (func.equals("sqrt")) x = Math.sqrt(x);
                    else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
                    else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
                    else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
                    else throw new RuntimeException("Unknown function: " + func);
                } else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }

                if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation

                return x;
            }
        }.parse();
    }
}
