package com.example.btth4_linearlayout_tong2so;

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
        TimKiem();
    }

    void TimKiem() {
        editTexso1 = (EditText) findViewById(R.id.edt1);
        editTexso2 = (EditText) findViewById(R.id.edt2);
        editTextKQ = (EditText) findViewById(R.id.edtKQ);
        nutCong =(Button) findViewById(R.id.btnCong);
        nutTru =(Button) findViewById(R.id.btnTru);
        nutNhan =(Button) findViewById(R.id.btnNhan);
        nutChia =(Button) findViewById(R.id.btnChia);
    }

    //xử lý cộng
   public void XuLyCong(View v){
        //code xử lý cộng
        //b1 lấy dữ liệu ở hai ô edit tex
        //b1.1 tìm 2 ô edit text
//        EditText editTexso1 = (EditText) findViewById(R.id.edt1);
//        EditText editTexso2 =  (EditText) findViewById(R.id.edt2);
        //b1.2 lấy dữ liệu hai ô đó
        String So1 = editTexso1.getText().toString();
        String So2 = editTexso2.getText().toString();
        //b1.3 chuyển dữ liệu chuỗi sang dữ liệu số
        float soA = Float.parseFloat(So1);
        float soB = Float.parseFloat(So2);
        //tính toán
        float Tong = soA + soB;
        //hiện kết quả
//       EditText editTextKQ = (EditText) findViewById(R.id.edtKQ);
        //chuẩn bị dữ liệu xuất
        String chuoiKq = String.valueOf(Tong);
        //gắn kết quả lên điều khiển
        editTextKQ.setText(chuoiKq);

    }
   public void XuLyTru(View v){
        //code xử lý trừ
        //b1 lấy dữ liệu ở hai ô edit tex
        //b1.1 tìm 2 ô edit text
//        EditText editTexso1 = (EditText) findViewById(R.id.edt1);
//        EditText editTexso2 = (EditText) findViewById(R.id.edt2);
        //b1.2 lấy dữ liệu hai ô đó
        String So1 = editTexso1.getText().toString();
        String So2 = editTexso2.getText().toString();
        //b1.3 chuyển dữ liệu chuỗi sang dữ liệu số
        float soA = Float.parseFloat(So1);
        float soB = Float.parseFloat(So2);
        //tính toán
        float Hieu = soA - soB;
        //hiện kết quả
//        EditText editTextKQ = (EditText) findViewById(R.id.edtKQ);
        //chuẩn bị dữ liệu xuất
        String chuoiKq = String.valueOf(Hieu);
        //gắn kết quả lên điều khiển
        editTextKQ.setText(chuoiKq);

    }
    public void XuLyNhan(View v){
        //code xử lý nhân
        //b1 lấy dữ liệu ở hai ô edit tex
        //b1.1 tìm 2 ô edit text
//        EditText editTexso1 = (EditText) findViewById(R.id.edt1);
//        EditText editTexso2 = (EditText) findViewById(R.id.edt2);
        //b1.2 lấy dữ liệu hai ô đó
        String So1 = editTexso1.getText().toString();
        String So2 = editTexso2.getText().toString();
        //b1.3 chuyển dữ liệu chuỗi sang dữ liệu số
        float soA = Float.parseFloat(So1);
        float soB = Float.parseFloat(So2);
        //tính toán
        float Tich = soA * soB;
        //hiện kết quả
//        EditText editTextKQ = (EditText) findViewById(R.id.edtKQ);
        //chuẩn bị dữ liệu xuất
        String chuoiKq = String.valueOf(Tich);
        //gắn kết quả lên điều khiển
        editTextKQ.setText(chuoiKq);
    }
    public void XuLyChia(View v){
        //code xử lý chia
        //b1 lấy dữ liệu ở hai ô edit tex
        //b1.1 tìm 2 ô edit text
//        EditText editTexso1 = (EditText) findViewById(R.id.edt1);
//        EditText editTexso2 = (EditText) findViewById(R.id.edt2);
        //b1.2 lấy dữ liệu hai ô đó
        String So1 = editTexso1.getText().toString();
        String So2 = editTexso2.getText().toString();
        //b1.3 chuyển dữ liệu chuỗi sang dữ liệu số
        float soA = Float.parseFloat(So1);
        float soB = Float.parseFloat(So2);
        //tính toán
        float Thuong = soA / soB;
        //hiện kết quả
//        EditText editTextKQ = (EditText) findViewById(R.id.edtKQ);
        //chuẩn bị dữ liệu xuất
        String chuoiKq = String.valueOf(Thuong);
        //gắn kết quả lên điều khiển
        editTextKQ.setText(chuoiKq);

    }
}