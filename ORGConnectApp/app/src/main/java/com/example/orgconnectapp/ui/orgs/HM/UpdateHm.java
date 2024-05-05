package com.example.orgconnectapp.ui.orgs.HM;

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

public class UpdateHm extends AppCompatActivity {


    private RecyclerView hmDepartnment;
    private LinearLayout hmNoData;
    private TeacherAdapter adapter1;
    private List<TeacherData> listT2;
    private DatabaseReference reference1, dbRef1;

    private RecyclerView hmPresData, hmVPresData, hmSecData, hmASecData, hmTresData, hmATresData, hmAuditorData, hmAAuditorData, hmBusData, hmProData, hmTechData, hm4YrData, hm3YrData, hm2YrData, hm1YrData, hmG12Data, hmG11Data;
    private LinearLayout hmPresNoData, hmVPresNoData, hmSecNoData, hmASecNoData, hmTresNoData, hmATresNoData , hmAuditorNoData, hmAAuditorNoData, hmBusNoData, hmProNoData, hmTechNoData, hm4YrNoData, hm3YrNoData, hm2YrNoData, hm1YrNoData, hmG12NoData,   hmG11NoData;
    private List<HmData> list1, list2, list3, list4, list5, list6, list7, list8, list9, list10, list11, list12, list13, list14, list15, list16, list17;
    private HmAdapter adapter;
    private DatabaseReference reference, dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_hm);

        hmDepartnment = findViewById(R.id.hmDepartnment);
        hmNoData = findViewById(R.id.hmNoData);

        hmPresData = findViewById(R.id.hmPresData);
        hmVPresData = findViewById(R.id.hmVPresData);
        hmSecData = findViewById(R.id.hmSecData);
        hmASecData = findViewById(R.id.hmASecData);
        hmTresData = findViewById(R.id.hmTresData);
        hmATresData = findViewById(R.id.hmATresData);
        hmAuditorData = findViewById(R.id.hmAuditorData);
        hmAAuditorData = findViewById(R.id.hmAAuditorData);
        hmBusData = findViewById(R.id.hmBusData);
        hmProData = findViewById(R.id.hmProData);
        hmTechData = findViewById(R.id.hmTechData);
        hm4YrData = findViewById(R.id.hm4YrData);
        hm3YrData = findViewById(R.id.hm3YrData);
        hm2YrData = findViewById(R.id.hm2YrData);
        hm1YrData = findViewById(R.id.hm1YrData);
        hmG12Data = findViewById(R.id.hmG12Data);
        hmG11Data = findViewById(R.id.hmG11Data);


        hmPresNoData = findViewById(R.id.hmPresNoData);
        hmVPresNoData = findViewById(R.id.hmVPresNoData);
        hmSecNoData = findViewById(R.id.hmSecNoData);
        hmASecNoData = findViewById(R.id.hmASecNoData);
        hmTresNoData = findViewById(R.id.hmTresNoData);
        hmATresNoData = findViewById(R.id.hmATresNoData);
        hmAuditorNoData = findViewById(R.id.hmAuditorNoData);
        hmAAuditorNoData = findViewById(R.id.hmAAuditorNoData);
        hmProNoData = findViewById(R.id.hmProNoData);
        hmBusNoData = findViewById(R.id.hmBusNoData);
        hmTechNoData = findViewById(R.id.hmTechNoData);
        hm4YrNoData = findViewById(R.id.hm4YrNoData);
        hm3YrNoData = findViewById(R.id.hm3YrNoData);
        hm2YrNoData = findViewById(R.id.hm2YrNoData);
        hm1YrNoData = findViewById(R.id.hm1YrNoData);
        hmG12NoData = findViewById(R.id.hmG12NoData);
        hmG11NoData = findViewById(R.id.hmG11NoData);


        reference = FirebaseDatabase.getInstance().getReference().child("HM Society Officers");
        reference1 = FirebaseDatabase.getInstance().getReference().child("Teacher");

        hmDepartnment();


        hmPresData();
        hmVPresData();
        hmSecData();
        hmASecData();
        hmTresData();
        hmATresData();
        hmAuditorData();
        hmAAuditorData();
        hmBusData();
        hmProData();
        hmTechData();
        hm4YrData();
        hm3YrData();
        hm2YrData();
        hm1YrData();
        hmG12Data();
        hmG11Data();


    }

    private void hmDepartnment() {
        dbRef1 = reference1.child("HM Society Adviser");
        dbRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listT2 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    hmNoData.setVisibility(View.VISIBLE);
                    hmDepartnment.setVisibility(View.GONE);
                }else{
                    hmNoData.setVisibility(View.GONE);
                    hmDepartnment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        listT2.add(data);
                    }
                    hmDepartnment.setHasFixedSize(true);
                    hmDepartnment.setLayoutManager(new LinearLayoutManager(UpdateHm.this));
                    adapter1 = new TeacherAdapter(listT2, UpdateHm.this,"HM Society Adviser");
                    hmDepartnment.setAdapter(adapter1);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateHm.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void hmPresData() {
        dbRef = reference.child("President");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    hmPresNoData.setVisibility(View.VISIBLE);
                    hmPresData.setVisibility(View.GONE);
                }else{
                    hmPresNoData.setVisibility(View.GONE);
                    hmPresData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        HmData data = snapshot.getValue(HmData.class);
                        list1.add(data);
                    }
                    hmPresData.setHasFixedSize(true);
                    hmPresData.setLayoutManager(new LinearLayoutManager(UpdateHm.this));
                    adapter = new HmAdapter(list1, UpdateHm.this, "President");
                    hmPresData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void hmVPresData() {
        dbRef = reference.child("Vice President");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list2 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    hmVPresNoData.setVisibility(View.VISIBLE);
                    hmVPresData.setVisibility(View.GONE);
                }else{
                    hmVPresNoData.setVisibility(View.GONE);
                    hmVPresData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        HmData data = snapshot.getValue(HmData.class);
                        list2.add(data);
                    }
                    hmVPresData.setHasFixedSize(true);
                    hmVPresData.setLayoutManager(new LinearLayoutManager(UpdateHm.this));
                    adapter = new HmAdapter(list2, UpdateHm.this, "Vice President");
                    hmVPresData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void hmSecData() {
        dbRef = reference.child("Secretary");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list3 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    hmSecNoData.setVisibility(View.VISIBLE);
                    hmSecData.setVisibility(View.GONE);
                }else{
                    hmSecNoData.setVisibility(View.GONE);
                    hmSecData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        HmData data = snapshot.getValue(HmData.class);
                        list3.add(data);
                    }
                    hmSecData.setHasFixedSize(true);
                    hmSecData.setLayoutManager(new LinearLayoutManager(UpdateHm.this));
                    adapter = new HmAdapter(list3, UpdateHm.this, "Secretary");
                    hmSecData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void hmASecData() {
        dbRef = reference.child("Assistant Secretary");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list4 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    hmASecData.setVisibility(View.VISIBLE);
                    hmASecData.setVisibility(View.GONE);
                }else{
                    hmASecNoData.setVisibility(View.GONE);
                    hmASecData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        HmData data = snapshot.getValue(HmData.class);
                        list4.add(data);
                    }
                    hmASecData.setHasFixedSize(true);
                    hmASecData.setLayoutManager(new LinearLayoutManager(UpdateHm.this));
                    adapter = new HmAdapter(list4, UpdateHm.this, "Assistant Secretary");
                    hmASecData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void hmTresData() {
        dbRef = reference.child("Treasurer");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list5 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    hmTresNoData.setVisibility(View.VISIBLE);
                    hmTresData.setVisibility(View.GONE);
                }else{
                    hmTresNoData.setVisibility(View.GONE);
                    hmTresData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        HmData data = snapshot.getValue(HmData.class);
                        list5.add(data);
                    }
                    hmTresData.setHasFixedSize(true);
                    hmTresData.setLayoutManager(new LinearLayoutManager(UpdateHm.this));
                    adapter = new HmAdapter(list5, UpdateHm.this, "Treasurer");
                    hmTresData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void hmATresData() {
        dbRef = reference.child("Assistant Treasurer");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list6 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    hmATresNoData.setVisibility(View.VISIBLE);
                    hmATresData.setVisibility(View.GONE);
                }else{
                    hmATresNoData.setVisibility(View.GONE);
                    hmATresData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        HmData data = snapshot.getValue(HmData.class);
                        list6.add(data);
                    }
                    hmATresData.setHasFixedSize(true);
                    hmATresData.setLayoutManager(new LinearLayoutManager(UpdateHm.this));
                    adapter = new HmAdapter(list6, UpdateHm.this, "Assistant Treasurer");
                    hmATresData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void hmAuditorData() {
        dbRef = reference.child("Auditor");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list7 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    hmAuditorNoData.setVisibility(View.VISIBLE);
                    hmAuditorData.setVisibility(View.GONE);
                }else{
                    hmAuditorNoData.setVisibility(View.GONE);
                    hmAuditorData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        HmData data = snapshot.getValue(HmData.class);
                        list7.add(data);
                    }
                    hmAuditorData.setHasFixedSize(true);
                    hmAuditorData.setLayoutManager(new LinearLayoutManager(UpdateHm.this));
                    adapter = new HmAdapter(list7, UpdateHm.this, "Auditor");
                    hmAuditorData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void hmAAuditorData() {
        dbRef = reference.child("Assistant Auditor");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list8 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    hmAAuditorNoData.setVisibility(View.VISIBLE);
                    hmAAuditorData.setVisibility(View.GONE);
                }else{
                    hmAAuditorNoData.setVisibility(View.GONE);
                    hmAAuditorData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        HmData data = snapshot.getValue(HmData.class);
                        list8.add(data);
                    }
                    hmAAuditorData.setHasFixedSize(true);
                    hmAAuditorData.setLayoutManager(new LinearLayoutManager(UpdateHm.this));
                    adapter = new HmAdapter(list8, UpdateHm.this, "Assistant Auditor");
                    hmAAuditorData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void hmBusData() {
        dbRef = reference.child("Business Manager");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list9 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    hmBusNoData.setVisibility(View.VISIBLE);
                    hmBusData.setVisibility(View.GONE);
                }else{
                    hmBusNoData.setVisibility(View.GONE);
                    hmBusData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        HmData data = snapshot.getValue(HmData.class);
                        list9.add(data);
                    }
                    hmBusData.setHasFixedSize(true);
                    hmBusData.setLayoutManager(new LinearLayoutManager(UpdateHm.this));
                    adapter = new HmAdapter(list9, UpdateHm.this, "Business Manager");
                    hmBusData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void hmProData() {
        dbRef = reference.child("Project Manager");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list10 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    hmProNoData.setVisibility(View.VISIBLE);
                    hmProData.setVisibility(View.GONE);
                }else{
                    hmProNoData.setVisibility(View.GONE);
                    hmProData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        HmData data = snapshot.getValue(HmData.class);
                        list10.add(data);
                    }
                    hmProData.setHasFixedSize(true);
                    hmProData.setLayoutManager(new LinearLayoutManager(UpdateHm.this));
                    adapter = new HmAdapter(list10, UpdateHm.this, "Project Manager");
                    hmProData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void hmTechData() {
        dbRef = reference.child("Tech Officer");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list11 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    hmTechNoData.setVisibility(View.VISIBLE);
                    hmTechData.setVisibility(View.GONE);
                }else{
                    hmTechNoData.setVisibility(View.GONE);
                    hmTechData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        HmData data = snapshot.getValue(HmData.class);
                        list11.add(data);
                    }
                    hmTechData.setHasFixedSize(true);
                    hmTechData.setLayoutManager(new LinearLayoutManager(UpdateHm.this));
                    adapter = new HmAdapter(list11, UpdateHm.this, "Tech Officer");
                    hmTechData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void hm4YrData() {
        dbRef = reference.child("4th Year Representative");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list12 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    hm4YrNoData.setVisibility(View.VISIBLE);
                    hm4YrData.setVisibility(View.GONE);
                }else{
                    hm4YrNoData.setVisibility(View.GONE);
                    hm4YrData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        HmData data = snapshot.getValue(HmData.class);
                        list12.add(data);
                    }
                    hm4YrData.setHasFixedSize(true);
                    hm4YrData.setLayoutManager(new LinearLayoutManager(UpdateHm.this));
                    adapter = new HmAdapter(list12, UpdateHm.this, "4th Year Representative");
                    hm4YrData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void hm3YrData() {
        dbRef = reference.child("3rd Year Representative");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list13 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    hm3YrNoData.setVisibility(View.VISIBLE);
                    hm3YrData.setVisibility(View.GONE);
                }else{
                    hm3YrNoData.setVisibility(View.GONE);
                    hm3YrData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        HmData data = snapshot.getValue(HmData.class);
                        list13.add(data);
                    }
                    hm3YrData.setHasFixedSize(true);
                    hm3YrData.setLayoutManager(new LinearLayoutManager(UpdateHm.this));
                    adapter = new HmAdapter(list13, UpdateHm.this, "3rd Year Representative");
                    hm3YrData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void hm2YrData() {
        dbRef = reference.child("2nd Year Representative");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list14 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    hm2YrNoData.setVisibility(View.VISIBLE);
                    hm2YrData.setVisibility(View.GONE);
                }else{
                    hm2YrNoData.setVisibility(View.GONE);
                    hm2YrData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        HmData data = snapshot.getValue(HmData.class);
                        list14.add(data);
                    }
                    hm2YrData.setHasFixedSize(true);
                    hm2YrData.setLayoutManager(new LinearLayoutManager(UpdateHm.this));
                    adapter = new HmAdapter(list14, UpdateHm.this, "2nd Year Representative");
                    hm2YrData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void hm1YrData() {
        dbRef = reference.child("1st Year Representative");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list15 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    hm1YrNoData.setVisibility(View.VISIBLE);
                    hm1YrData.setVisibility(View.GONE);
                }else{
                    hm1YrNoData.setVisibility(View.GONE);
                    hm1YrData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        HmData data = snapshot.getValue(HmData.class);
                        list15.add(data);
                    }
                    hm1YrData.setHasFixedSize(true);
                    hm1YrData.setLayoutManager(new LinearLayoutManager(UpdateHm.this));
                    adapter = new HmAdapter(list15, UpdateHm.this, "1st Year Representative");
                    hm1YrData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void hmG12Data() {
        dbRef = reference.child("Grade 12 Representative");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list16 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    hmG12NoData.setVisibility(View.VISIBLE);
                    hmG12Data.setVisibility(View.GONE);
                }else{
                    hmG12NoData.setVisibility(View.GONE);
                    hmG12Data.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        HmData data = snapshot.getValue(HmData.class);
                        list16.add(data);
                    }
                    hmG12Data.setHasFixedSize(true);
                    hmG12Data.setLayoutManager(new LinearLayoutManager(UpdateHm.this));
                    adapter = new HmAdapter(list16, UpdateHm.this, "Grade 12 Representative");
                    hmG12Data.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void hmG11Data() {
        dbRef = reference.child("Grade 11 Representative");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list17 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    hmG11NoData.setVisibility(View.VISIBLE);
                    hmG11Data.setVisibility(View.GONE);
                }else{
                    hmG11NoData.setVisibility(View.GONE);
                    hmG11Data.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        HmData data = snapshot.getValue(HmData.class);
                        list17.add(data);
                    }
                    hmG11Data.setHasFixedSize(true);
                    hmG11Data.setLayoutManager(new LinearLayoutManager(UpdateHm.this));
                    adapter = new HmAdapter(list17, UpdateHm.this, "Grade 11 Representative");
                    hmG11Data.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}