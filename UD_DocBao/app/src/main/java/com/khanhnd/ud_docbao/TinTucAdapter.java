package com.khanhnd.ud_docbao;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class TinTucAdapter extends RecyclerView.Adapter<TinTucAdapter.TinViewHolder> {
    Context context;
    List<TinTuc> listTin;

    public TinTucAdapter(Context context, List<TinTuc> listTin) {
        this.context = context;
        this.listTin = listTin;
    }

    @NonNull
    @Override
    public TinViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    LayoutInflater cai_bom = LayoutInflater.from(context);
    View view = cai_bom.inflate(R.layout.layout_item_tin, parent, false);
    TinViewHolder viewHolderCreated = new TinViewHolder(view);
    return  viewHolderCreated;

    }

    @Override
    public void onBindViewHolder(@NonNull TinViewHolder holder, int position) {
    TinTuc tinHienThi = listTin.get(position);
    String title =tinHienThi.getTitle();
    String pubDate = tinHienThi.getPubDate();

        holder.txtTieuDe.setText(tinHienThi.getTitle());
        holder.txtNgayDang.setText(tinHienThi.getPubDate());

        //ảnh
        Glide.with(context)
                .load(tinHienThi.getImageUrl())
                .error(R.mipmap.ic_launcher)
                .into(holder.imgTin);
    }

    @Override
    public int getItemCount() {
        return listTin.size();
    }

    class TinViewHolder extends RecyclerView.ViewHolder{
        ImageView imgTin;
        TextView txtTieuDe, txtNgayDang;

        public TinViewHolder(@NonNull View itemView) {
            super(itemView);
            imgTin = itemView.findViewById(R.id.imgTin);
            txtTieuDe = itemView.findViewById(R.id.txtTieuDe);
            txtNgayDang = itemView.findViewById(R.id.txtNgayDang);
        }
    }
}
