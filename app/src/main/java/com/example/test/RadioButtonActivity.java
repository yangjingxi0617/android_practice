package com.example.test;

import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RadioButtonActivity extends AppCompatActivity {

    private RadioGroup rg;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_radio_button);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rg = findViewById(R.id.rg);
        tv = findViewById(R.id.radioButton_tv);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            String s= "";
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId) {
                    case R.id.rg_shanghai:
                        s="shanghai";
                        break;
                    case R.id.rg_beijing:
                        s="beijing";
                        break;
                    case R.id.rg_shenzhen:
                        s="shenzhen";
                        break;
                }
                tv.setText(s);
            }
        });
    }
}