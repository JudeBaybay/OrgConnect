package com.example.orgconnectapp.ui.orgs.U;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.orgconnectapp.R;
import com.example.orgconnectapp.ui.faculty.TeacherAdapter;
import com.example.orgconnectapp.ui.faculty.TeacherData;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class UpdateUn extends AppCompatActivity{


    private RecyclerView uDepartnment;
    private LinearLayout uNoData;
    private List<TeacherData> listT8;
    private TeacherAdapter adapter1;
    private DatabaseReference reference1, dbRef1;
    private RecyclerView unPresData, unVPresData, unSecData, unASecData, unTresData, unATresData, unAuditorData, unAAuditorData, unBusData, unProData, unTechData, un4YrData, un3YrData, un2YrData, un1YrData, unG12Data, unG11Data;
    private LinearLayout unPresNoData, unVPresNoData, unSecNoData, unASecNoData, unTresNoData, unATresNoData , unAuditorNoData, unAAuditorNoData, unBusNoData, unProNoData, unTechNoData, un4YrNoData, un3YrNoData, un2YrNoData, un1YrNoData, unG12NoData,   unG11NoData;
    private List<UnData> list1, list2, list3, list4, list5, list6, list7, list8, list9, list10, list11, list12, list13, list14, list15, list16, list17;
    private UnAdapter adapter;
    private DatabaseReference reference, dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_un);

        uDepartnment = findViewById(R.id.uDepartnment);
        uNoData = findViewById(R.id.uNoData);

        unPresData = findViewById(R.id.unPresData);
        unVPresData = findViewById(R.id.unVPresData);
        unSecData = findViewById(R.id.unSecData);
        unASecData = findViewById(R.id.unASecData);
        unTresData = findViewById(R.id.unTresData);
        unATresData = findViewById(R.id.unATresData);
        unAuditorData = findViewById(R.id.unAuditorData);
        unAAuditorData = findViewById(R.id.unAAuditorData);
        unBusData = findViewById(R.id.unBusData);
        unProData = findViewById(R.id.unProData);
        unTechData = findViewById(R.id.unTechData);
        un4YrData = findViewById(R.id.un4YrData);
        un3YrData = findViewById(R.id.un3YrData);
        un2YrData = findViewById(R.id.un2YrData);
        un1YrData = findViewById(R.id.un1YrData);
        unG12Data = findViewById(R.id.unG12Data);
        unG11Data = findViewById(R.id.unG11Data);


        unPresNoData = findViewById(R.id.unPresNoData);
        unVPresNoData = findViewById(R.id.unVPresNoData);
        unSecNoData = findViewById(R.id.unSecNoData);
        unASecNoData = findViewById(R.id.unASecNoData);
        unTresNoData = findViewById(R.id.unTresNoData);
        unATresNoData = findViewById(R.id.unATresNoData);
        unAuditorNoData = findViewById(R.id.unAuditorNoData);
        unAAuditorNoData = findViewById(R.id.unAAuditorNoData);
        unProNoData = findViewById(R.id.unProNoData);
        unBusNoData = findViewById(R.id.unBusNoData);
        unTechNoData = findViewById(R.id.unTechNoData);
        un4YrNoData = findViewById(R.id.un4YrNoData);
        un3YrNoData = findViewById(R.id.un3YrNoData);
        un2YrNoData = findViewById(R.id.un2YrNoData);
        un1YrNoData = findViewById(R.id.un1YrNoData);
        unG12NoData = findViewById(R.id.unG12NoData);
        unG11NoData = findViewById(R.id.unG11NoData);

        reference = FirebaseDatabase.getInstance().getReference().child("Unleashed Officers");
        reference1 = FirebaseDatabase.getInstance().getReference().child("Teacher");

        uDepartnment();

        unPresData();
        unVPresData();
        unSecData();
        unASecData();
        unTresData();
        unATresData();
        unAuditorData();
        unAAuditorData();
        unBusData();
        unProData();
        unTechData();
        un4YrData();
        un3YrData();
        un2YrData();
        un1YrData();
        unG12Data();
        unG11Data();

    }

    private void uDepartnment() {
        dbRef1 = reference1.child("Unleashed Adviser");
        dbRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listT8 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    uNoData.setVisibility(View.VISIBLE);
                    uDepartnment.setVisibility(View.GONE);
                }else{
                    uNoData.setVisibility(View.GONE);
                    uDepartnment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        listT8.add(data);
                    }
                    uDepartnment.setHasFixedSize(true);
                    uDepartnment.setLayoutManager(new LinearLayoutManager(UpdateUn.this));
                    adapter1 = new TeacherAdapter(listT8, UpdateUn.this, "Unleased Adviser");
                    uDepartnment.setAdapter(adapter1);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateUn.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void unPresData() {
        dbRef = reference.child("President");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    unPresNoData.setVisibility(View.VISIBLE);
                    unPresData.setVisibility(View.GONE);
                }else{
                    unPresNoData.setVisibility(View.GONE);
                    unPresData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        UnData data = snapshot.getValue(UnData.class);
                        list1.add(data);
                    }
                    unPresData.setHasFixedSize(true);
                    unPresData.setLayoutManager(new LinearLayoutManager(UpdateUn.this));
                    adapter = new UnAdapter(list1, UpdateUn.this, "President");
                    unPresData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void unVPresData() {
        dbRef = reference.child("Vice President");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list2 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    unVPresNoData.setVisibility(View.VISIBLE);
                    unVPresData.setVisibility(View.GONE);
                }else{
                    unVPresNoData.setVisibility(View.GONE);
                    unVPresData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        UnData data = snapshot.getValue(UnData.class);
                        list2.add(data);
                    }
                    unVPresData.setHasFixedSize(true);
                    unVPresData.setLayoutManager(new LinearLayoutManager(UpdateUn.this));
                    adapter = new UnAdapter(list2, UpdateUn.this, "Vice President");
                    unVPresData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void unSecData() {
        dbRef = reference.child("Secretary");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list3 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    unSecNoData.setVisibility(View.VISIBLE);
                    unSecData.setVisibility(View.GONE);
                }else{
                    unSecNoData.setVisibility(View.GONE);
                    unSecData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        UnData data = snapshot.getValue(UnData.class);
                        list3.add(data);
                    }
                    unSecData.setHasFixedSize(true);
                    unSecData.setLayoutManager(new LinearLayoutManager(UpdateUn.this));
                    adapter = new UnAdapter(list3, UpdateUn.this, "Secretary");
                    unSecData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void unASecData() {
        dbRef = reference.child("Assistant Secretary");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list4 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    unASecData.setVisibility(View.VISIBLE);
                    unASecData.setVisibility(View.GONE);
                }else{
                    unASecNoData.setVisibility(View.GONE);
                    unASecData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        UnData data = snapshot.getValue(UnData.class);
                        list4.add(data);
                    }
                    unASecData.setHasFixedSize(true);
                    unASecData.setLayoutManager(new LinearLayoutManager(UpdateUn.this));
                    adapter = new UnAdapter(list4, UpdateUn.this, "Assistant Secretary");
                    unASecData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void unTresData() {
        dbRef = reference.child("Treasurer");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list5 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    unTresNoData.setVisibility(View.VISIBLE);
                    unTresData.setVisibility(View.GONE);
                }else{
                    unTresNoData.setVisibility(View.GONE);
                    unTresData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        UnData data = snapshot.getValue(UnData.class);
                        list5.add(data);
                    }
                    unTresData.setHasFixedSize(true);
                    unTresData.setLayoutManager(new LinearLayoutManager(UpdateUn.this));
                    adapter = new UnAdapter(list5, UpdateUn.this, "Treasurer");
                    unTresData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void unATresData() {
        dbRef = reference.child("Assistant Treasurer");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list6 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    unATresNoData.setVisibility(View.VISIBLE);
                    unATresData.setVisibility(View.GONE);
                }else{
                    unATresNoData.setVisibility(View.GONE);
                    unATresData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        UnData data = snapshot.getValue(UnData.class);
                        list6.add(data);
                    }
                    unATresData.setHasFixedSize(true);
                    unATresData.setLayoutManager(new LinearLayoutManager(UpdateUn.this));
                    adapter = new UnAdapter(list6, UpdateUn.this, "Assistant Treasurer");
                    unATresData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void unAuditorData() {
        dbRef = reference.child("Auditor");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list7 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    unAuditorNoData.setVisibility(View.VISIBLE);
                    unAuditorData.setVisibility(View.GONE);
                }else{
                    unAuditorNoData.setVisibility(View.GONE);
                    unAuditorData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        UnData data = snapshot.getValue(UnData.class);
                        list7.add(data);
                    }
                    unAuditorData.setHasFixedSize(true);
                    unAuditorData.setLayoutManager(new LinearLayoutManager(UpdateUn.this));
                    adapter = new UnAdapter(list7, UpdateUn.this, "Auditor");
                    unAuditorData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void unAAuditorData() {
        dbRef = reference.child("Assistant Auditor");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list8 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    unAAuditorNoData.setVisibility(View.VISIBLE);
                    unAAuditorData.setVisibility(View.GONE);
                }else{
                    unAAuditorNoData.setVisibility(View.GONE);
                    unAAuditorData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        UnData data = snapshot.getValue(UnData.class);
                        list8.add(data);
                    }
                    unAAuditorData.setHasFixedSize(true);
                    unAAuditorData.setLayoutManager(new LinearLayoutManager(UpdateUn.this));
                    adapter = new UnAdapter(list8, UpdateUn.this, "Assistant Auditor");
                    unAAuditorData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void unBusData() {
        dbRef = reference.child("Business Manager");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list9 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    unBusNoData.setVisibility(View.VISIBLE);
                    unBusData.setVisibility(View.GONE);
                }else{
                    unBusNoData.setVisibility(View.GONE);
                    unBusData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        UnData data = snapshot.getValue(UnData.class);
                        list9.add(data);
                    }
                    unBusData.setHasFixedSize(true);
                    unBusData.setLayoutManager(new LinearLayoutManager(UpdateUn.this));
                    adapter = new UnAdapter(list9, UpdateUn.this, "Business Manager");
                    unBusData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void unProData() {
        dbRef = reference.child("Project Manager");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list10 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    unProNoData.setVisibility(View.VISIBLE);
                    unProData.setVisibility(View.GONE);
                }else{
                    unProNoData.setVisibility(View.GONE);
                    unProData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        UnData data = snapshot.getValue(UnData.class);
                        list10.add(data);
                    }
                    unProData.setHasFixedSize(true);
                    unProData.setLayoutManager(new LinearLayoutManager(UpdateUn.this));
                    adapter = new UnAdapter(list10, UpdateUn.this, "Project Manager");
                    unProData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void unTechData() {
        dbRef = reference.child("Tech Officer");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list11 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    unTechNoData.setVisibility(View.VISIBLE);
                    unTechData.setVisibility(View.GONE);
                }else{
                    unTechNoData.setVisibility(View.GONE);
                    unTechData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        UnData data = snapshot.getValue(UnData.class);
                        list11.add(data);
                    }
                    unTechData.setHasFixedSize(true);
                    unTechData.setLayoutManager(new LinearLayoutManager(UpdateUn.this));
                    adapter = new UnAdapter(list11, UpdateUn.this, "Tech Officer");
                    unTechData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void un4YrData() {
        dbRef = reference.child("4th Year Representative");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list12 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    un4YrNoData.setVisibility(View.VISIBLE);
                    un4YrData.setVisibility(View.GONE);
                }else{
                    un4YrNoData.setVisibility(View.GONE);
                    un4YrData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        UnData data = snapshot.getValue(UnData.class);
                        list12.add(data);
                    }
                    un4YrData.setHasFixedSize(true);
                    un4YrData.setLayoutManager(new LinearLayoutManager(UpdateUn.this));
                    adapter = new UnAdapter(list12, UpdateUn.this, "4th Year Representative");
                    un4YrData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void un3YrData() {
        dbRef = reference.child("3rd Year Representative");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list13 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    un3YrNoData.setVisibility(View.VISIBLE);
                    un3YrData.setVisibility(View.GONE);
                }else{
                    un3YrNoData.setVisibility(View.GONE);
                    un3YrData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        UnData data = snapshot.getValue(UnData.class);
                        list13.add(data);
                    }
                    un3YrData.setHasFixedSize(true);
                    un3YrData.setLayoutManager(new LinearLayoutManager(UpdateUn.this));
                    adapter = new UnAdapter(list13, UpdateUn.this, "3rd Year Representative");
                    un3YrData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void un2YrData() {
        dbRef = reference.child("2nd Year Representative");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list14 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    un2YrNoData.setVisibility(View.VISIBLE);
                    un2YrData.setVisibility(View.GONE);
                }else{
                    un2YrNoData.setVisibility(View.GONE);
                    un2YrData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        UnData data = snapshot.getValue(UnData.class);
                        list14.add(data);
                    }
                    un2YrData.setHasFixedSize(true);
                    un2YrData.setLayoutManager(new LinearLayoutManager(UpdateUn.this));
                    adapter = new UnAdapter(list14, UpdateUn.this, "2nd Year Representative");
                    un2YrData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void un1YrData() {
        dbRef = reference.child("1st Year Representative");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list15 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    un1YrNoData.setVisibility(View.VISIBLE);
                    un1YrData.setVisibility(View.GONE);
                }else{
                    un1YrNoData.setVisibility(View.GONE);
                    un1YrData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        UnData data = snapshot.getValue(UnData.class);
                        list15.add(data);
                    }
                    un1YrData.setHasFixedSize(true);
                    un1YrData.setLayoutManager(new LinearLayoutManager(UpdateUn.this));
                    adapter = new UnAdapter(list15, UpdateUn.this, "1st Year Representative");
                    un1YrData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void unG12Data() {
        dbRef = reference.child("Grade 12 Representative");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list16 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    unG12NoData.setVisibility(View.VISIBLE);
                    unG12Data.setVisibility(View.GONE);
                }else{
                    unG12NoData.setVisibility(View.GONE);
                    unG12Data.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        UnData data = snapshot.getValue(UnData.class);
                        list16.add(data);
                    }
                    unG12Data.setHasFixedSize(true);
                    unG12Data.setLayoutManager(new LinearLayoutManager(UpdateUn.this));
                    adapter = new UnAdapter(list16, UpdateUn.this, "Grade 12 Representative");
                    unG12Data.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void unG11Data() {
        dbRef = reference.child("Grade 11 Representative");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list17 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    unG11NoData.setVisibility(View.VISIBLE);
                    unG11Data.setVisibility(View.GONE);
                }else{
                    unG11NoData.setVisibility(View.GONE);
                    unG11Data.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        UnData data = snapshot.getValue(UnData.class);
                        list17.add(data);
                    }
                    unG11Data.setHasFixedSize(true);
                    unG11Data.setLayoutManager(new LinearLayoutManager(UpdateUn.this));
                    adapter = new UnAdapter(list17, UpdateUn.this, "Grade 11 Representative");
                    unG11Data.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}