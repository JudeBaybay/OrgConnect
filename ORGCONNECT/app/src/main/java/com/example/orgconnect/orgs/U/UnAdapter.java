package com.example.orgconnect.orgs.U;

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
import com.squareup.picasso.Picasso;

import java.util.List;

public class UnAdapter extends RecyclerView.Adapter<UnAdapter.UnViewAdapter>{

    private List<UnData> list;
    private Context context;
    private String post;

    public UnAdapter(List<UnData> list, Context context, String post) {
        this.list = list;
        this.context = context;
        this.post = post;
    }

    @NonNull
    @Override
    public UnAdapter.UnViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.un_item_layout, parent, false);
        return new UnAdapter.UnViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UnAdapter.UnViewAdapter holder, int position) {

        UnData item = list.get(position);
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
                Intent intent = new Intent(context, UnActivity.class);
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

    public class UnViewAdapter extends RecyclerView.ViewHolder {

        private TextView name, email;
        private Button update;
        private ImageView imageView;

        public UnViewAdapter(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.UnName);
            email = itemView.findViewById(R.id.UnEmail);
            update = itemView.findViewById(R.id.UnUpdate);
            imageView = itemView.findViewById(R.id.UnImage);
        }
    }
}
