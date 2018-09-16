package com.comscisau.sang.americanshareapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.function.DoublePredicate;

public class MainActivity extends AppCompatActivity {
    //ประกาศชื่อ Object
    private EditText et_Money, et_Person, et_Tip;
    private Button bt_Cal;
    private TextView tv_Sum;
    private CheckBox cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //เอาชื่อ Object ที่ประกาศมาสร้งเป็น Object
        final EditText et_Money = (EditText) findViewById(R.id.etMoney);
        final EditText et_Person = (EditText) findViewById(R.id.etPerson);
        final EditText et_Tip = (EditText) findViewById(R.id.etTip);

        final CheckBox cb = (CheckBox) findViewById(R.id.cb);

        Button bt_Cal = (Button) findViewById(R.id.btCal);

        final TextView tv_Sum = (TextView) findViewById(R.id.tvSum);

        //เมื่อนคลิกปุ่ม bt_Cal ให้....?
        bt_Cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (et_Money.getText().toString().trim().equals("")) {
                    Toast.makeText(MainActivity.this, "ยังไม่ได้กรอกจำนวนเงิน",
                            Toast.LENGTH_SHORT).show();
                } else if (et_Person.getText().toString().trim().equals("")) {
                    Toast.makeText(MainActivity.this, "ยังไม่ได้กรอกจำนวนคน",
                            Toast.LENGTH_SHORT).show();
                }

                double m = Double.parseDouble(et_Money.getText().toString().trim());
                double p = Double.parseDouble(et_Person.getText().toString().trim());
                double sum = m / p;

                DecimalFormat df = new DecimalFormat("#,##0.00");
                tv_Sum.setText(df.format(sum));

                if (cb.isChecked()) {
                    if (et_Tip.getText().toString().trim().equals("")) {
                        Toast.makeText(MainActivity.this, "กรอกจำนวนทิป",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}
