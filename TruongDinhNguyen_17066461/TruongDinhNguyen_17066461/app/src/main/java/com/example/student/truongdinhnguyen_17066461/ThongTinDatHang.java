package com.example.student.truongdinhnguyen_17066461;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.nio.file.Files;

public class ThongTinDatHang extends AppCompatActivity {

    EditText edtTenKH, edtSDT;
    Button btnChonSP;
    String[] sanphams = {"coca", "pepsi", "fanta", "number 1", "sting", "aquafina", "dasani"};
    boolean[] checks = {false, false, false, false, true, true, false};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_dat_hang);
        Dec();
        btnChonSP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert = new AlertDialog.Builder(ThongTinDatHang.this);
                alert.setTitle("Chọn sản phẩm");
                alert.setMultiChoiceItems(sanphams, checks, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {

                    }
                });
                alert.setPositiveButton("Lưu", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                        String str = "Tên khách hàng: " + edtTenKH.getText().toString()
                                    +"\nSố điện thoại: " +edtSDT.getText().toString()
                                    +"\nSản phẩm: ";
                        for(int k=0; k<sanphams.length; k++){
                            if(checks[k])
                                str+="\n" + sanphams[k].toString();
                        }
                        Intent intent = new Intent();
                        intent.putExtra("kq", str);
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                });
                AlertDialog al = alert.create();
                al.show();
            }
        });

    }

    void Dec(){
        btnChonSP = (Button) findViewById(R.id.btnChonSp);
        edtTenKH = (EditText) findViewById(R.id.edtTenKH);
        edtSDT = (EditText) findViewById(R.id.edtSDT);
    }
}
