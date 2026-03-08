package com.example.calculater;

import static com.example.calculater.R.id.equal;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;


public class MainActivity extends AppCompatActivity {

    TextView input,output;
    Button all_clear,clear;
    Button equal;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.datain);
        output = findViewById(R.id.result);
        all_clear = findViewById(R.id.ac);
        clear = findViewById(R.id.c);
        equal = findViewById(R.id.equal);

        equal.setOnClickListener(v -> {
            String data = input.getText().toString();

                Context context = Context.enter();
                context.setOptimizationLevel(-1);
                Scriptable scriptable = context.initSafeStandardObjects();
                String result = context.evaluateString(scriptable, data, "Javascript", 1, null).toString();
                output.setText(result);

        });

        all_clear.setOnClickListener(v -> {
            input.setText("");
            output.setText("");
        });

        clear.setOnClickListener(v -> {
            String text = input.getText().toString();
            if (text.length() > 0) {
                input.setText(text.substring(0, text.length() - 1));
            }
        });
    }
    public void getvalue(View view) {
        Button btn = (Button) view;
        input.setText(input.getText().toString() + btn.getText().toString());
    }


}

