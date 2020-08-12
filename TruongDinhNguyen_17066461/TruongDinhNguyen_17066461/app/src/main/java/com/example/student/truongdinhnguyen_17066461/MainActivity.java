package com.example.student.truongdinhnguyen_17066461;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnDatHang;
    TextView tvKQ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Dec();

        final Intent i = new Intent(MainActivity.this, ThongTinDatHang.class);
        btnDatHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(i,99);
            }
        });

    }

    void Dec(){
        btnDatHang = (Button) findViewById(R.id.btnDatHang);
        tvKQ = (TextView) findViewById(R.id.tvKQ);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==99){
            if(resultCode==RESULT_OK){
                tvKQ.setText(data.getStringExtra("kq"));
            }
        }
    }
}
