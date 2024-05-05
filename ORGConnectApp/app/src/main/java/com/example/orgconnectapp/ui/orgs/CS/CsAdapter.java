package com.example.orgconnectapp.ui.orgs.CS;

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

public class CsAdapter extends RecyclerView.Adapter<CsAdapter.CsViewAdapter>{
    private List<CsData> list;
    private Context context;
    private String post;

    public CsAdapter(List<CsData> list, Context context, String post) {
        this.list = list;
        this.context = context;
        this.post = post;
    }

    @NonNull
    @Override
    public CsAdapter.CsViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cs_item_layout, parent, false);
        return new CsAdapter.CsViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CsAdapter.CsViewAdapter holder, int position) {

        CsData item = list.get(position);
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

    public class CsViewAdapter extends RecyclerView.ViewHolder {

        private TextView name, email;
        private Button update;
        private ImageView imageView;

        public CsViewAdapter(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.CsName);
            email = itemView.findViewById(R.id.CsEmail);
            imageView = itemView.findViewById(R.id.CsImage);
        }
    }
}
