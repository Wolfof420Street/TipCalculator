package com.wolf.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText enteredAmount;
    private SeekBar seekBar;
    private Button calculateButton;
    private TextView resultTextView;
    private TextView percentageTextView;
    private int seekBarPercentage;
    private float enteredBillFloat;
    private TextView totalBill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enteredAmount = (EditText) findViewById(R.id.billAmountId);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        calculateButton = (Button) findViewById(R.id.calculateButton);
        resultTextView = (TextView) findViewById(R.id.resultId);
        percentageTextView = (TextView) findViewById(R.id.percentageTextView);
        totalBill = (TextView) findViewById(R.id.totalTextView);

        calculateButton.setOnClickListener(this);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                percentageTextView.setText(String.valueOf(seekBar.getProgress()) +"%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {


            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                seekBarPercentage = seekBar.getProgress();

            }
        });
    }

    @Override
    public void onClick(View view) {
        calculate();

    }

    public void calculate () {

        float result = 0.0f;

        if (!enteredAmount.getText().toString().equals("")) {
            enteredBillFloat = Float.parseFloat(enteredAmount.getText().toString());
            result = enteredBillFloat*seekBarPercentage/ 100;
            resultTextView.setText("Your tip will be " +"" + "ksh" + " " + String.valueOf(result));
            totalBill.setText("Total BIll:" + (enteredBillFloat + result));
        } else {
            Toast.makeText(MainActivity.this, "Please Enter A valid amount", Toast.LENGTH_LONG).show();
        }


    }
}
