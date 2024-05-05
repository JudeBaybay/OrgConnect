package com.example.orgconnect.event;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.orgconnect.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DeleteEventActivity extends AppCompatActivity {

    RecyclerView deleteEventRecycler;
    private ProgressBar progressBar;
    private ArrayList<EventData> list;
    private EventAdapter adapter;
    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_event);

        deleteEventRecycler = findViewById(R.id.deleteEventRecycler);
        progressBar = findViewById(R.id.progressBar);

        reference = FirebaseDatabase.getInstance().getReference().child("Event");

        deleteEventRecycler.setLayoutManager(new LinearLayoutManager(this));
        deleteEventRecycler.setHasFixedSize(true);

        getEvent();
        

    }

    private void getEvent() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list = new ArrayList<>();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    EventData data = snapshot.getValue(EventData.class);
                    list.add(data);
                }
                adapter = new EventAdapter(DeleteEventActivity.this, list);
                adapter.notifyDataSetChanged();
                progressBar.setVisibility(View.GONE);
                deleteEventRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                progressBar.setVisibility(View.GONE);

                Toast.makeText(DeleteEventActivity.this,databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}