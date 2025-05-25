package com.example.orgconnectapp.ui.orgs.SUMS;

import android.content.Context;
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

public class SumsAdapter extends RecyclerView.Adapter<SumsAdapter.SumsViewAdapter> {
    private List<SumsData> list;
    private Context context;
    private String post;

    public SumsAdapter(List<SumsData> list, Context context, String post) {
        this.list = list;
        this.context = context;
        this.post = post;
    }

    @NonNull
    @Override
    public SumsAdapter.SumsViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sums_item_layout, parent, false);
        return new SumsAdapter.SumsViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SumsAdapter.SumsViewAdapter holder, int position) {

        SumsData item = list.get(position);
        holder.name.setText(item.getName());
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

    public class SumsViewAdapter extends RecyclerView.ViewHolder {

        private TextView name, email;
        private Button update;
        private ImageView imageView;

        public SumsViewAdapter(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.SumsName);
            email = itemView.findViewById(R.id.SumsEmail);
            imageView = itemView.findViewById(R.id.SumsImage);
        }
    }
}
