package com.example.orgconnectapp.ui.orgs.CC;

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

public class CcAdapter extends RecyclerView.Adapter<CcAdapter.CcViewAdapter>{

    private List<CcData> list;
    private Context context;
    private String post;

    public CcAdapter(List<CcData> list, Context context, String post) {
        this.list = list;
        this.context = context;
        this.post = post;
    }

    @NonNull
    @Override
    public CcAdapter.CcViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cc_item_layout, parent, false);
        return new CcAdapter.CcViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CcAdapter.CcViewAdapter holder, int position) {

        CcData item = list.get(position);
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

    public class CcViewAdapter extends RecyclerView.ViewHolder {

        private TextView name, email;
        private Button update;
        private ImageView imageView;

        public CcViewAdapter(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.CcName);
            email = itemView.findViewById(R.id.CcEmail);
            imageView = itemView.findViewById(R.id.CcImage);
        }
    }
}