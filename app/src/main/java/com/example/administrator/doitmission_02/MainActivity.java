package com.example.administrator.doitmission_02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements TextWatcher{

    EditText mEditText1;
    TextView mText1;

    Button mBtn1;

    int lengthOfEditText = 0;
//
//    InputFilter inputFilter = new InputFilter() {
//        @Override
//        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
//            return null;
//        }
//    };

    TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            lengthOfEditText = s.toString().getBytes().length;
            mText1.setText(lengthOfEditText + " / 80 바이트");
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        mEditText1 = (EditText) findViewById(R.id.editText);
        mEditText1.addTextChangedListener(watcher);

        mText1 = (TextView) findViewById(R.id.textView);
        mText1.setText(lengthOfEditText + " / 80 바이트");

        mBtn1 = (Button) findViewById(R.id.btn_transfer);
        mBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), lengthOfEditText + " 바이트 입력 됨", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

        mText1.setText(lengthOfEditText + " / 80 바이트");
    }

}
