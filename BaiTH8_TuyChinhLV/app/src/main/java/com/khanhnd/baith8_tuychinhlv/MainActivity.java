package com.khanhnd.baith8_tuychinhlv;

import static android.widget.Toast.LENGTH_SHORT;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

        // tim list view
        ListView lvDanhSachMonAn = (ListView) findViewById(R.id.lvDsMonAn);

        // chuẩn bị dữ liệu
        ArrayList<MonAn> dsMonAn = new ArrayList<MonAn>();
        MonAn m1 =new MonAn("Bún Bò", 50_000, "Phở truyền thống.", R.drawable.bunbo);
        MonAn m2 =new MonAn("Bún Chả", 45_000, "Chả thịt nướng.", R.drawable.buncha);
        MonAn m3 =new MonAn("Cơm Tấm Sường", 55_000, "Sườn cốt lết nướng mật ong.", R.drawable.comsuong);
        MonAn m4 =new MonAn("Bánh Mỳ Thập Cẩm", 25_000, "Pa-tê, chả lụa, thịt nguội.", R.drawable.banhmi);
        MonAn m5 =new MonAn("Gỏi Cuốn", 30_000, "Tôm, thịt lợn, bún và rau thơm.", R.drawable.goicuon);
        dsMonAn.add(m1);
        dsMonAn.add(m2);
        dsMonAn.add(m3);
        dsMonAn.add(m4);
        dsMonAn.add(m5);

        MonAnAdapter adapter = new MonAnAdapter(this,dsMonAn);
        lvDanhSachMonAn.setAdapter(adapter);

        //bắt sử lý sự kiện
        lvDanhSachMonAn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //lấy phần được chạm
                MonAn monAnChon = dsMonAn.get(position);
                //làm gì đó
                Toast.makeText(MainActivity.this, monAnChon.getTenMonAn(), LENGTH_SHORT).show();
            }
        });
    }
}