package com.khanhnd.baith7_listview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> dsTenMonAn;
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


        dsTenMonAn = new ArrayList<String>();

        dsTenMonAn.add("Phở bò Hà Nội");
        dsTenMonAn.add("Bún chả Hương Liên");
        dsTenMonAn.add("Cơm tấm sườn bì chả");
        dsTenMonAn.add("Bánh mì xíu mại");
        dsTenMonAn.add("Bún bò Huế");
        dsTenMonAn.add("Gỏi cuốn tôm thịt");

        ArrayAdapter<String> adapterMonAn;
        adapterMonAn = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dsTenMonAn);

        ListView lvTenMonAn = findViewById(R.id.lvDanhSachMA);

        lvTenMonAn.setAdapter(adapterMonAn);


        lvTenMonAn.setOnItemClickListener(BoLangNgheXL);
    }

    AdapterView.OnItemClickListener  BoLangNgheXL = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
          String strTenMonAn = dsTenMonAn.get(position);

          Toast.makeText(MainActivity.this, "Bạn vừa chọn: " + strTenMonAn, Toast.LENGTH_LONG).show();
        }
    };
}