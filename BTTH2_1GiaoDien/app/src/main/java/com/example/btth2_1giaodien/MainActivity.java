package com.example.btth2_1giaodien;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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
    }

    //bộ lắng nghe và xử lý
    public void XuLyCong(View view  ){
        EditText XuLyA = findViewById(R.id.edita);
        EditText XuLyB = findViewById(R.id.editb);
        EditText XuLyKq = findViewById(R.id.editKQ);
    //lấy dữ liệu
       String strA = XuLyA.getText().toString();
       String strB = XuLyB.getText().toString();

       //chuyển dũ liệu sang dạng số
        int soA = Integer.parseInt(strA);
        int soB= Integer.parseInt(strB);

       int tong = soA + soB;
        String StrTong = String.valueOf(tong);
        XuLyKq.setText(StrTong);
    }
}