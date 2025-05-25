package com.example.orgconnectapp.ui.event;



import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.orgconnectapp.FullImageView;
import com.example.orgconnectapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewAdapter> {

    private Context context;
    private ArrayList<EventData> list;

    public EventAdapter(Context context, ArrayList<EventData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public EventViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.newsfeed_item_layout, parent, false);
        return new EventViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewAdapter holder, int position) {

        EventData currentItem = list.get(position);
        holder.deleteEventTitle.setText(currentItem.getTitle());
        holder.date.setText(currentItem.getDate());
        holder.time.setText(currentItem.getTime());


        try {
            if (currentItem.getImage() != null)
                Picasso.get().load(currentItem.getImage()).into(holder.deleteEventImage);
        } catch (Exception e) {
            e.printStackTrace();
        }

        holder.deleteEventImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, FullImageView.class);
                intent.putExtra("image", currentItem.getImage());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class EventViewAdapter extends RecyclerView.ViewHolder{


        private TextView deleteEventTitle, date, time;
        private ImageView deleteEventImage;

        public EventViewAdapter(@NonNull View itemView) {
            super(itemView);

            deleteEventTitle = itemView.findViewById(R.id.deleteEventTitle);
            deleteEventImage = itemView.findViewById(R.id.deleteEventImage);
            date = itemView.findViewById(R.id.date);
            time = itemView.findViewById(R.id.time);

        }
    }
}
