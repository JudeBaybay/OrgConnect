package com.example.orgconnectapp.ui.orgs.HM;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.orgconnectapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HmAdapter extends RecyclerView.Adapter<HmAdapter.HmViewAdapter>{
    private List<HmData> list;
    private Context context;
    private String post;

    public HmAdapter(List<HmData> list, Context context, String post) {
        this.list = list;
        this.context = context;
        this.post = post;
    }

    @NonNull
    @Override
    public HmAdapter.HmViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.hm_item_layout, parent, false);
        return new HmAdapter.HmViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HmAdapter.HmViewAdapter holder, int position) {

        HmData item = list.get(position);
        holder.name.setText(item.getName());
        holder.email.setText(item.getEmail());
        try {
            Picasso.get().load(item.getImage()).into(holder.imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class HmViewAdapter extends RecyclerView.ViewHolder {

        private TextView name, email;
        private Button update;
        private ImageView imageView;

        public HmViewAdapter(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.HmName);
            email = itemView.findViewById(R.id.HmEmail);
            imageView = itemView.findViewById(R.id.HmImage);
        }
    }
}