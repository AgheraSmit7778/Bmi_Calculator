package com.example.bmicalculatorpro;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Connect Widgets to JAVA file

        EditText edtweight = findViewById(R.id.edtweight);
        EditText edtheightft = findViewById(R.id.edtheightft);
        EditText edtheightin = findViewById(R.id.edtheightin);

        Button btncalculate = findViewById(R.id.btncalculate);

        TextView txtResult = findViewById(R.id.txtresult);
        ImageView imgview = findViewById(R.id.imgview);

        btncalculate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if ((edtweight.getText().toString().equals("")) || (edtheightft.getText().toString().equals("")))
                {
                    Toast.makeText(MainActivity.this, "Enter Info", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (edtheightin.getText().toString().equals("")) {
                        edtheightin.setText("0");
                    }
                    int wt = Integer.parseInt(edtweight.getText().toString());
                    int htf = Integer.parseInt(edtheightft.getText().toString());
                    int hti = Integer.parseInt(edtheightin.getText().toString());


                    if ((wt >= 400) || (htf >= 20) || (hti >= 12)) {
                        Toast.makeText(MainActivity.this, "Enter Valid Info", Toast.LENGTH_SHORT).show();
                    } else {


                        int totalinch = htf * 12 + hti;  // total height in inches
                        double totalcm = totalinch * 2.53;  //total height in cm
                        double totalm = totalcm / 100;  // total height in meter
                        double bmi = wt / (totalm * totalm); //formula of BMI

                        // BMI FORMULA = WEIGHT / SQUARE OF HEIGHT in meter
                        if (bmi > 25) {
                            txtResult.setText("You're OverWeight");
                            imgview.setImageResource(R.drawable.ow);
                            txtResult.setTextColor(Color.parseColor("#ECAF00"));
                        } else if (bmi < 18) {
                            txtResult.setText("You're UnderWeight");
                            imgview.setImageResource(R.drawable.uw);
                            txtResult.setTextColor(Color.parseColor("#01A5A9"));
                        } else {
                            txtResult.setText("You're Normal");
                            imgview.setImageResource(R.drawable.he);
                            txtResult.setTextColor(Color.parseColor("#1B9A00"));
                        }
                    }
                }

            }
        });
    }
}

// MADE BY AGHERA SMIT.....