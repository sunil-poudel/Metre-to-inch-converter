package com.example.unit_converter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button convertButton;
    private EditText enterNumber;
    private TextView resultDisplay;

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
        convertButton = findViewById(R.id.convert_button);
        enterNumber = findViewById(R.id.enter_number);
        resultDisplay = findViewById(R.id.result_display);

        convertButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String numbers = enterNumber.getText().toString();
                float number = Float.parseFloat(numbers);
                float toInch = number * (float)39.3701;
                String resultInInch = String.format("%.2f",toInch);
                String displayInInch = numbers + " metres = " + resultInInch + " inches. ";
                resultDisplay.setText(displayInInch);
                resultDisplay.setVisibility(View.VISIBLE);
            }
        });
    }

}