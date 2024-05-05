package com.example.orgconnectapp.ui.orgs.SYMS;

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

public class SymsAdapter extends RecyclerView.Adapter<SymsAdapter.SymsViewAdapter>{
    private List<SymsData> list;
    private Context context;
    private String post;

    public SymsAdapter(List<SymsData> list, Context context, String post) {
        this.list = list;
        this.context = context;
        this.post = post;
    }

    @NonNull
    @Override
    public SymsAdapter.SymsViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.syms_item_layout, parent, false);
        return new SymsAdapter.SymsViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SymsAdapter.SymsViewAdapter holder, int position) {

        SymsData item = list.get(position);
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

    public class SymsViewAdapter extends RecyclerView.ViewHolder {

        private TextView name, email;
        private ImageView imageView;

        public SymsViewAdapter(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.SymsName);
            email = itemView.findViewById(R.id.SymsEmail);
            imageView = itemView.findViewById(R.id.SymsImage);
        }
    }
}
