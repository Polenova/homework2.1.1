package ru.AndroidPolenova;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText inputSumm;
    private EditText info;
    private Button btnOk;
    private CheckBox cardChkBx;
    private CheckBox phoneChkBx;
    private CheckBox addressChkBx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Toast.makeText(MainActivity.this, String.format(getString(R.string.text), inputSumm.getText().toString(), info.getText().toString()),
                            Toast.LENGTH_LONG).show();
            }
        });
    }
    private void resetCheckBoxes() {
        cardChkBx.setChecked(false);
        phoneChkBx.setChecked(false);
        addressChkBx.setChecked(false);
    }
    private void initViews() {
        inputSumm = findViewById(R.id.editSumm);
        info = findViewById(R.id.editInfo);
        btnOk = findViewById(R.id.btnOK);
        cardChkBx = findViewById(R.id.checkBoxCard);
        phoneChkBx = findViewById(R.id.checkBoxPhone);
        addressChkBx = findViewById(R.id.checkBoxAddress);
        cardChkBx.setOnCheckedChangeListener(checkedChangeListener);
        phoneChkBx.setOnCheckedChangeListener(checkedChangeListener);
        addressChkBx.setOnCheckedChangeListener(checkedChangeListener);
    }
    CompoundButton.OnCheckedChangeListener checkedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if (b) {
                switch (compoundButton.getId()) {
                    case R.id.checkBoxCard:
                        resetCheckBoxes();
                        cardChkBx.setChecked(true);
                        info.setInputType(InputType.TYPE_CLASS_NUMBER);
                        break;
                    case R.id.checkBoxPhone:
                        resetCheckBoxes();
                        phoneChkBx.setChecked(true);
                        info.setInputType(InputType.TYPE_CLASS_PHONE);
                        break;
                    case R.id.checkBoxAddress:
                        resetCheckBoxes();
                        addressChkBx.setChecked(true);
                        info.setInputType(InputType.TYPE_CLASS_TEXT);
                        break;
                    default:
                }
            }
        }
    };



}
