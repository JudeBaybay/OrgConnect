package com.example.orgconnect.orgs.SYMS;

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

import com.example.orgconnect.R;
import com.example.orgconnect.orgs.SYMS.SymsActivity;
import com.example.orgconnect.orgs.SYMS.SymsAdapter;
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

        holder.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SymsActivity.class);
                intent.putExtra("name", item.getName());
                intent.putExtra("email", item.getEmail());
                intent.putExtra("image", item.getImage());
                intent.putExtra("key", item.getKey());
                intent.putExtra("post", post);
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class SymsViewAdapter extends RecyclerView.ViewHolder {

        private TextView name, email;
        private Button update;
        private ImageView imageView;

        public SymsViewAdapter(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.SymsName);
            email = itemView.findViewById(R.id.SymsEmail);
            update = itemView.findViewById(R.id.SymsUpdate);
            imageView = itemView.findViewById(R.id.SymsImage);
        }
    }
}
