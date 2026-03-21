package com.khanhnd.baith5_xulysukien1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText editTexso1;
    EditText editTexso2;
    EditText editTextKQ;
    Button nutCong, nutTru, nutNhan, nutChia;
    void TimKiem() {
        editTexso1 = (EditText) findViewById(R.id.edt1);
        editTexso2 = (EditText) findViewById(R.id.edt2);
        editTextKQ = (EditText) findViewById(R.id.edtKQ);
        nutCong =(Button) findViewById(R.id.btnCong);
        nutTru =(Button) findViewById(R.id.btnTru);
        nutNhan =(Button) findViewById(R.id.btnNhan);
        nutChia =(Button) findViewById(R.id.btnChia);
    }
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
        //tiem dieu khien
        TimKiem();
        //gắn bộ lắng nghe sự kiện
        View.OnClickListener boLangNgheCong = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XuLyCong();
            }
        };
        nutCong.setOnClickListener(boLangNgheCong);

        nutTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XuLyTru();
            }
        });

        nutNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XuLyNhan();
            }
        });

        nutChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XuLyChia();
            }
        });
    }


    //xử lý cộng
    void XuLyCong(){
        String So1 = editTexso1.getText().toString();
        String So2 = editTexso2.getText().toString();
        float soA = Float.parseFloat(So1);
        float soB = Float.parseFloat(So2);
        float Tong = soA + soB;
        String chuoiKq = String.valueOf(Tong);
        editTextKQ.setText(chuoiKq);

    }
    void XuLyTru(){
        String So1 = editTexso1.getText().toString();
        String So2 = editTexso2.getText().toString();
        float soA = Float.parseFloat(So1);
        float soB = Float.parseFloat(So2);
        float Hieu = soA - soB;
        String chuoiKq = String.valueOf(Hieu);
        editTextKQ.setText(chuoiKq);

    }
     void XuLyNhan(){
        String So1 = editTexso1.getText().toString();
        String So2 = editTexso2.getText().toString();
        float soA = Float.parseFloat(So1);
        float soB = Float.parseFloat(So2);
        float Tich = soA * soB;
        String chuoiKq = String.valueOf(Tich);
        editTextKQ.setText(chuoiKq);
    }
     void XuLyChia(){
        String So1 = editTexso1.getText().toString();
        String So2 = editTexso2.getText().toString();
        float soA = Float.parseFloat(So1);
        float soB = Float.parseFloat(So2);
        float Thuong = soA / soB;
        String chuoiKq = String.valueOf(Thuong);
        editTextKQ.setText(chuoiKq);

    }
}
