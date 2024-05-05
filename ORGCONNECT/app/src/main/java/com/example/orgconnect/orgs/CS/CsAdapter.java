package com.example.orgconnect.orgs.CS;

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
import com.example.orgconnect.orgs.CS.CsActivity;
import com.example.orgconnect.orgs.CS.CsAdapter;
import com.example.orgconnect.orgs.CS.CsData;
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

        holder.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CsActivity.class);
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

    public class CsViewAdapter extends RecyclerView.ViewHolder {

        private TextView name, email;
        private Button update;
        private ImageView imageView;

        public CsViewAdapter(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.CsName);
            email = itemView.findViewById(R.id.CsEmail);
            update = itemView.findViewById(R.id.CsUpdate);
            imageView = itemView.findViewById(R.id.CsImage);
        }
    }
}
