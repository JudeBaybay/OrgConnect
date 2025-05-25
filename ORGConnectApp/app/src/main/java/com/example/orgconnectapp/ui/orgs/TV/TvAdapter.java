package com.example.orgconnectapp.ui.orgs.TV;

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

import com.squareup.picasso.Picasso;
import com.example.orgconnectapp.R;

import java.util.List;

public class TvAdapter extends RecyclerView.Adapter<TvAdapter.TvViewAdapter>{

    private List<TvData> list;
    private Context context;
    private String post;

    public TvAdapter(List<TvData> list, Context context, String post) {
        this.list = list;
        this.context = context;
        this.post = post;
    }

    @NonNull
    @Override
    public TvAdapter.TvViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.tv_item_layout, parent, false);
        return new TvAdapter.TvViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TvAdapter.TvViewAdapter holder, int position) {

        TvData item = list.get(position);
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

    public class TvViewAdapter extends RecyclerView.ViewHolder {

        private TextView name, email;
        private ImageView imageView;

        public TvViewAdapter(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.TvName);
            email = itemView.findViewById(R.id.TvEmail);
            imageView = itemView.findViewById(R.id.TvImage);
        }
    }
}