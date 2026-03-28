package com.khanhnd.baith8_tuychinhlv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MonAnAdapter extends BaseAdapter {

    //

    private ArrayList<MonAn> dsMonAn;
    private LayoutInflater layoutInflater;
    private Context context;

    //Hàm Tạo


    public MonAnAdapter(Context _context, ArrayList<MonAn> dsMonAn) {
        this.dsMonAn = dsMonAn;
        this.context = _context;
        this.layoutInflater = LayoutInflater.from(_context);
    }

    @Override
    public int getCount() {
        return dsMonAn.size();
    }

    @Override
    public Object getItem(int position) {
        return dsMonAn.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //view item hiện hành
        View viewHienHanh = convertView;
        //kiểm tra
        if (viewHienHanh == null){
            viewHienHanh = layoutInflater.inflate(R.layout.iten_monan, null);
        }
        //lấy dữ liệu
        MonAn monAnHienTai = dsMonAn.get(position);
        //gán các điều khiển

        //tiềm điều khiển
        TextView textView_TenMon = (TextView) viewHienHanh.findViewById(R.id.tvSanPham);
        TextView textView_DonGia = (TextView) viewHienHanh.findViewById(R.id.tvDonGia);
        TextView textView_MoTa = (TextView) viewHienHanh.findViewById(R.id.tvMoTa);
        ImageView imageView_AnhDaiDien = (ImageView) viewHienHanh.findViewById(R.id.imDaiDien);

        //Set lên
        textView_TenMon.setText(monAnHienTai.getTenMonAn());
        textView_DonGia.setText(String.valueOf(monAnHienTai.getDonGia()));
        textView_MoTa.setText(monAnHienTai.getMoTa());
        imageView_AnhDaiDien.setImageResource(monAnHienTai.getIdAnhMinhHoa());


        return viewHienHanh;
    }
}
