/*package de.hochschule.trier.taschenrechner;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView anzeige;
    private String eingabe = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

       anzeige=findViewById(R.id.anzeige);


        findViewById(R.id.eins).setOnClickListener(this::onbuttonClick);
        findViewById(R.id.zwei).setOnClickListener(this::onbuttonClick);
        findViewById(R.id.drei).setOnClickListener(this::onbuttonClick);
        findViewById(R.id.vier).setOnClickListener(this::onbuttonClick);
        findViewById(R.id.fuenf).setOnClickListener(this::onbuttonClick);
        findViewById(R.id.sechs).setOnClickListener(this::onbuttonClick);
        findViewById(R.id.sieben).setOnClickListener(this::onbuttonClick);
        findViewById(R.id.acht).setOnClickListener(this::onbuttonClick);
        findViewById(R.id.neun).setOnClickListener(this::onbuttonClick);
        findViewById(R.id.nullzahl).setOnClickListener(this::onbuttonClick);

        findViewById(R.id.komma).setOnClickListener(this::onDurchMalClick);

        findViewById(R.id.minus).setOnClickListener(this::onPlusMinusClick);
        findViewById(R.id.plus).setOnClickListener(this::onPlusMinusClick);
        findViewById(R.id.durch).setOnClickListener(this::onDurchMalClick);
        findViewById(R.id.mal).setOnClickListener(this::onDurchMalClick);

        findViewById(R.id.gleich).setOnClickListener(this::onGleichClick); // noch machen
        findViewById(R.id.plusminus).setOnClickListener(this::onPlusMinusChangeClick);

        findViewById(R.id.loesch).setOnClickListener(this::onLoeschClick);


        anzeige.setText("+");
    }

    private void onbuttonClick(View v) {
        AppCompatButton button = (AppCompatButton) v;
        anzeige.setText(String.format("%s%s", anzeige.getText(),button.getText().toString()));
    }

    private void onDurchMalClick(View v) {
        if (anzeige.getText().toString().length() > 1) {

            AppCompatButton button = (AppCompatButton) v;
            char[] state = new char[2];
            state[0] = anzeige.getText().charAt(anzeige.getText().length() - 1);
            state[1] = anzeige.getText().charAt(anzeige.getText().length() - 2);
            if (state[0] == '-' || state[0] == '+' || state[0] == 'x' || state[0] == '÷') {
                if (state[1] != 'x' && state[1] != '÷') {
                    StringBuilder text = new StringBuilder(anzeige.getText().toString());
                    text.replace(anzeige.getText().length() - 1, anzeige.getText().length(), button.getText().toString());
                    anzeige.setText(text.toString());
                }
            }else {
                anzeige.setText(String.format("%s%s", anzeige.getText(), button.getText().toString()));
            }

        }
    }

    private void onPlusMinusClick(View v){
        AppCompatButton button = (AppCompatButton) v;

        char state = anzeige.getText().charAt(anzeige.getText().length() - 1);
        if (state == 'x' || state == '-' || state == '+' || state == '÷'|| anzeige.getText().toString().length()==1) {

            StringBuilder text = new StringBuilder(anzeige.getText().toString());
            text.replace(anzeige.getText().length() - 1, anzeige.getText().length(), button.getText().toString());
            anzeige.setText(text.toString());

        } else {
            anzeige.setText(String.format("%s%s", anzeige.getText(), button.getText().toString()));
        }


    }

    private void onPlusMinusChangeClick(View v){
        StringBuilder text = new StringBuilder(anzeige.getText().toString());
        for(int i=text.length()-1;i>=0;i--){
            if(text.charAt(i) == '+'){
                text.replace(i,i+1,"-");
                break;
            } else if (text.charAt(i) == 'x'||text.charAt(i) == '÷') {
                text.insert(i+1,"-");
                break;
            } else if (text.charAt(i) == '-') {
                if (i!=0 && (text.charAt(i-1)=='÷' || text.charAt(i-1)=='x')) {
                    text.replace(i,i+1, "");
                }else {
                    text.replace(i,i+1,"+");
                }
                break;
            } else if (i==0) {
                text.insert(0, "-");
            }
        }

        anzeige.setText(text.toString());
    }

    private void onLoeschClick(View v){
        anzeige.setText("+");
    }

    private void onGleichClick(View v){
        AppCompatButton text = (AppCompatButton) v;
        StringBuilder rechnung = new StringBuilder(text.getText().toString());
        ArrayList<Double> zahl = new ArrayList<Double>();
        ArrayList<Character> operator = new ArrayList<Character>();

        for(int i = 0; i < rechnung.length() ; i++){

        }
    }

}*/
package de.hochschule.trier.taschenrechner;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    float textSize;
    private TextView inputScreen;
    private TextView lockedScreen;
    private Double number;
    private char operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        getSupportActionBar().setTitle("Pierrics Taschenrechner");
        getSupportActionBar().setElevation(2f);

        inputScreen = findViewById(R.id.anzeige);
        lockedScreen = findViewById(R.id.ergebnis);

        findViewById(R.id.nullzahl).setOnClickListener(this::insertNumber);
        findViewById(R.id.eins).setOnClickListener(this::insertNumber);
        findViewById(R.id.zwei).setOnClickListener(this::insertNumber);
        findViewById(R.id.drei).setOnClickListener(this::insertNumber);
        findViewById(R.id.vier).setOnClickListener(this::insertNumber);
        findViewById(R.id.fuenf).setOnClickListener(this::insertNumber);
        findViewById(R.id.sechs).setOnClickListener(this::insertNumber);
        findViewById(R.id.sieben).setOnClickListener(this::insertNumber);
        findViewById(R.id.acht).setOnClickListener(this::insertNumber);
        findViewById(R.id.neun).setOnClickListener(this::insertNumber);

        findViewById(R.id.komma).setOnClickListener(this::insertNumber);

        findViewById(R.id.gleich).setOnClickListener(this::result);

        findViewById(R.id.plusminus).setOnClickListener(this::plusMinus);

        findViewById(R.id.plus).setOnClickListener(this::lockNumber);
        findViewById(R.id.minus).setOnClickListener(this::lockNumber);
        findViewById(R.id.durch).setOnClickListener(this::lockNumber);
        findViewById(R.id.mal).setOnClickListener(this::lockNumber);

        findViewById(R.id.loesch).setOnClickListener(this::clear);

        findViewById(R.id.loesch).setOnLongClickListener(this::clearAll);

        //setFontSize(textSize);


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("inputScreen", (inputScreen == null || TextUtils.isEmpty(inputScreen.getText().toString())) ? "" : inputScreen.getText().toString());
        outState.putString("lockedScreen", (lockedScreen == null || TextUtils.isEmpty(lockedScreen.getText().toString())) ? "" : lockedScreen.getText().toString());
        if (textSize == 0) {
            textSize = getResources().getDimension(R.dimen.schriftgroesse) / getResources().getDisplayMetrics().density; //hack weil ich keinen bock mehr hab
        }
        outState.putFloat("textSize", textSize);
        outState.putSerializable("number", number);

        if (operator != 0) {
            outState.putChar("operator", operator);
        } else {
            outState.putChar("operator", '\u0000');
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        inputScreen.setText(savedInstanceState.getString("inputScreen"));
        lockedScreen.setText(savedInstanceState.getString("lockedScreen"));
        number = (Double) savedInstanceState.getSerializable("number");
        textSize = savedInstanceState.getFloat("textSize");
        operator = savedInstanceState.getChar("operator");
        setFontSize(textSize);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.size_small) {
            textSize = getResources().getDimension(R.dimen.schriftgroesse_s) / getResources().getDisplayMetrics().density;
            setFontSize(textSize);
        } else if (item.getItemId() == R.id.size_medium) {
            textSize = getResources().getDimension(R.dimen.schriftgroesse_m) / getResources().getDisplayMetrics().density;
            setFontSize(textSize);
        } else if (item.getItemId() == R.id.size_large) {
            textSize = getResources().getDimension(R.dimen.schriftgroesse) / getResources().getDisplayMetrics().density;
            setFontSize(textSize);
        }

        // Schriftgröße ändern

        return true;
    }

    public void setFontSize(float size) {
        inputScreen.setTextSize(size);
        lockedScreen.setTextSize(size);

        View mainLayout = findViewById(R.id.main);
        setFontSizeForButtons(mainLayout, size);
    }

    private void setFontSizeForButtons(View view, float size) {
        if (view instanceof Button) {
            ((Button) view).setTextSize(size);
        } else if (view instanceof android.view.ViewGroup) {
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View child = viewGroup.getChildAt(i);
                setFontSizeForButtons(child, size);
            }
        }
    }

    private void clear(View view) {
        String currentText = inputScreen.getText().toString();

        if (!currentText.isEmpty()) {
            // Remove the last character
            String newText = currentText.substring(0, currentText.length() - 1);
            inputScreen.setText(newText);
        }
    }

    private boolean clearAll(View view) {
        inputScreen.setText("");
        lockedScreen.setText("");
        number = null;
        return true;
    }

    private void insertNumber(View view) {
        Button insertButton = (Button) view;
        String buttonText = insertButton.getText().toString();
        String currentText = inputScreen.getText().toString();

        if (buttonText.equals("-") && currentText.isEmpty()) {
            inputScreen.setText("-");
            return;
        }

        inputScreen.setText(String.format("%s%s", currentText, buttonText));
    }

    private void lockNumber(View view) {

        Button insertButton = (Button) view;
        String inputText = inputScreen.getText().toString();

        if (inputText.isEmpty() || inputText.equals("-")) {
            if (number != null) {
                operator = insertButton.getText().charAt(0);
                lockedScreen.setText(String.format(Locale.US, "%.2f%s", number, operator));
            }
            return;
        }

        if (number == null) {
            number = Double.parseDouble(inputText);
            operator = insertButton.getText().charAt(0);

            lockedScreen.setText(String.format(Locale.US, "%.2f%s", number, operator));
            inputScreen.setText("");
        } else {
            try {
                result(view);
            } catch (NumberFormatException e) {
                operator = insertButton.getText().charAt(0);
                lockedScreen.setText(String.format(Locale.US, "%.2f%s", number, operator));
            }
        }
    }


    private void result(View view) {
        try {
            String term = number.toString() + operator + inputScreen.getText().toString();
            Expression e = new ExpressionBuilder(term).build();
            inputScreen.setText("");
            number = e.evaluate();
            lockedScreen.setText(String.format(number == number.intValue() ? "=%.0f" : "=%.2f", number));
        } catch (NullPointerException e) {
            System.out.println("NullPointerException");
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException");
        }

    }

    /*private void result(View view) {

        numberTwo = Double.parseDouble(inputScreen.getText().toString());
        Button insertButton = (Button) view;

        switch (operator) {
            case '+':
                numberOne = numberOne + numberTwo;
                break;
            case '-':
                numberOne = numberOne - numberTwo;
                break;
            case '*':
                numberOne = numberOne * numberTwo;
                break;
            case '/':
                if (numberTwo == 0) {
                    lockedScreen.setText("Division durch 0");
                    numberOne = null;
                    numberTwo = null;
                    inputScreen.setText("");
                    return;
                }
                numberOne = numberOne / numberTwo;
                break;
            default:
                numberOne = Double.parseDouble(inputScreen.getText().toString());
                numberTwo = null;
                break;
        }
        if (insertButton.getText().equals("=")) {
            operator = ' ';
        } else {
            operator = insertButton.getText().charAt(0);
        }

        lockedScreen.setText(String.format(Locale.US, "=%.2f%s", numberOne, operator));

        inputScreen.setText("");
    }*/


    private void plusMinus(View view) {
        String currentText = inputScreen.getText().toString();

        if (currentText.isEmpty()) {
            return;
        }

        try {
            double value = Double.parseDouble(currentText);
            value = -value;
            inputScreen.setText(String.format(Locale.US, value == (int) value ? "%.0f" : "%.2f", value));
        } catch (NumberFormatException e) {
            inputScreen.setText("Error");
        }
    }
}

