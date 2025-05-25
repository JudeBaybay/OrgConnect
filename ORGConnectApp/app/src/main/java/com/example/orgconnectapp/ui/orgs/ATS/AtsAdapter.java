package com.example.orgconnectapp.ui.orgs.ATS;

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

public class AtsAdapter extends RecyclerView.Adapter<AtsAdapter.AtsViewAdapter> {

    private List<AtsData> list;
    private Context context;
    private String post;

    public AtsAdapter(List<AtsData> list, Context context, String post) {
        this.list = list;
        this.context = context;
        this.post = post;
    }

    @NonNull
    @Override
    public AtsAdapter.AtsViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.ats_item_layout, parent, false);
        return new AtsAdapter.AtsViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AtsAdapter.AtsViewAdapter holder, int position) {

        AtsData item = list.get(position);
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

    public class AtsViewAdapter extends RecyclerView.ViewHolder {

        private TextView name, email;
        private Button update;
        private ImageView imageView;

        public AtsViewAdapter(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.AtsName);
            email = itemView.findViewById(R.id.AtsEmail);
            imageView = itemView.findViewById(R.id.AtsImage);
        }
    }
}