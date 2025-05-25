package com.example.orgconnectapp.ui.orgs.PNS;

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

public class PnsAdapter extends RecyclerView.Adapter<PnsAdapter.PnsViewAdapter>{

    private List<PnsData> list;
    private Context context;
    private String post;

    public PnsAdapter(List<PnsData> list, Context context, String post) {
        this.list = list;
        this.context = context;
        this.post = post;
    }

    @NonNull
    @Override
    public PnsAdapter.PnsViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.pns_item_layout, parent, false);
        return new PnsAdapter.PnsViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PnsAdapter.PnsViewAdapter holder, int position) {

        PnsData item = list.get(position);
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

    public class PnsViewAdapter extends RecyclerView.ViewHolder {

        private TextView name, email;

        private ImageView imageView;

        public PnsViewAdapter(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.PnsName);
            email = itemView.findViewById(R.id.PnsEmail);
            imageView = itemView.findViewById(R.id.PnsImage);
        }
    }
}
