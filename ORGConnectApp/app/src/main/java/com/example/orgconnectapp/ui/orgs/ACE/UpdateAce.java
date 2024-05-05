package com.example.orgconnectapp.ui.orgs.ACE;

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

public class UpdateAce extends AppCompatActivity {


    private RecyclerView aceDepartnment;
    private LinearLayout aceNoData;
    private List<TeacherData> listT11;
    private TeacherAdapter adapter1;
    private DatabaseReference reference1, dbRef1;
    private RecyclerView acePresData, aceVPresData, aceSecData, aceASecData, aceTresData, aceATresData, aceAuditorData, aceAAuditorData, aceBusData, aceProData, aceTechData, ace4YrData, ace3YrData, ace2YrData, ace1YrData, aceG12Data, aceG11Data;
    private LinearLayout acePresNoData, aceVPresNoData, aceSecNoData, aceASecNoData, aceTresNoData, aceATresNoData , aceAuditorNoData, aceAAuditorNoData, aceBusNoData, aceProNoData, aceTechNoData, ace4YrNoData, ace3YrNoData, ace2YrNoData, ace1YrNoData, aceG12NoData,   aceG11NoData;
    private List<AceData> list1, list2, list3, list4, list5, list6, list7, list8, list9, list10, list11, list12, list13, list14, list15, list16, list17;
    private AceAdapter adapter;
    private DatabaseReference reference, dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_ace);

        aceDepartnment = findViewById(R.id.aceDepartnment);
        aceNoData = findViewById(R.id.aceNoData);

        acePresData = findViewById(R.id.acePresData);
        aceVPresData = findViewById(R.id.aceVPresData);
        aceSecData = findViewById(R.id.aceSecData);
        aceASecData = findViewById(R.id.aceASecData);
        aceTresData = findViewById(R.id.aceTresData);
        aceATresData = findViewById(R.id.aceATresData);
        aceAuditorData = findViewById(R.id.aceAuditorData);
        aceAAuditorData = findViewById(R.id.aceAAuditorData);
        aceBusData = findViewById(R.id.aceBusData);
        aceProData = findViewById(R.id.aceProData);
        aceTechData = findViewById(R.id.aceTechData);
        ace4YrData = findViewById(R.id.ace4YrData);
        ace3YrData = findViewById(R.id.ace3YrData);
        ace2YrData = findViewById(R.id.ace2YrData);
        ace1YrData = findViewById(R.id.ace1YrData);
        aceG12Data = findViewById(R.id.aceG12Data);
        aceG11Data = findViewById(R.id.aceG11Data);


        acePresNoData = findViewById(R.id.acePresNoData);
        aceVPresNoData = findViewById(R.id.aceVPresNoData);
        aceSecNoData = findViewById(R.id.aceSecNoData);
        aceASecNoData = findViewById(R.id.aceASecNoData);
        aceTresNoData = findViewById(R.id.aceTresNoData);
        aceATresNoData = findViewById(R.id.aceATresNoData);
        aceAuditorNoData = findViewById(R.id.aceAuditorNoData);
        aceAAuditorNoData = findViewById(R.id.aceAAuditorNoData);
        aceProNoData = findViewById(R.id.aceProNoData);
        aceBusNoData = findViewById(R.id.aceBusNoData);
        aceTechNoData = findViewById(R.id.aceTechNoData);
        ace4YrNoData = findViewById(R.id.ace4YrNoData);
        ace3YrNoData = findViewById(R.id.ace3YrNoData);
        ace2YrNoData = findViewById(R.id.ace2YrNoData);
        ace1YrNoData = findViewById(R.id.ace1YrNoData);
        aceG12NoData = findViewById(R.id.aceG12NoData);
        aceG11NoData = findViewById(R.id.aceG11NoData);

        reference = FirebaseDatabase.getInstance().getReference().child("Ace Club Officers");
        reference1 = FirebaseDatabase.getInstance().getReference().child("Teacher");

        aceDepartnment();

        acePresData();
        aceVPresData();
        aceSecData();
        aceASecData();
        aceTresData();
        aceATresData();
        aceAuditorData();
        aceAAuditorData();
        aceBusData();
        aceProData();
        aceTechData();
        ace4YrData();
        ace3YrData();
        ace2YrData();
        ace1YrData();
        aceG12Data();
        aceG11Data();


    }

    private void aceDepartnment() {
        dbRef1 = reference1.child("Ace Club Adviser");
        dbRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listT11 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    aceNoData.setVisibility(View.VISIBLE);
                    aceDepartnment.setVisibility(View.GONE);
                }else{
                    aceNoData.setVisibility(View.GONE);
                    aceDepartnment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        listT11.add(data);
                    }
                    aceDepartnment.setHasFixedSize(true);
                    aceDepartnment.setLayoutManager(new LinearLayoutManager(UpdateAce.this));
                    adapter1 = new TeacherAdapter(listT11, UpdateAce.this, "Ace Club Adviser");
                    aceDepartnment.setAdapter(adapter1);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateAce.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void acePresData() {
        dbRef = reference.child("President");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    acePresNoData.setVisibility(View.VISIBLE);
                    acePresData.setVisibility(View.GONE);
                }else{
                    acePresNoData.setVisibility(View.GONE);
                    acePresData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        AceData data = snapshot.getValue(AceData.class);
                        list1.add(data);
                    }
                    acePresData.setHasFixedSize(true);
                    acePresData.setLayoutManager(new LinearLayoutManager(UpdateAce.this));
                    adapter = new AceAdapter(list1, UpdateAce.this, "President");
                    acePresData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void aceVPresData() {
        dbRef = reference.child("Vice President");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list2 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    aceVPresNoData.setVisibility(View.VISIBLE);
                    aceVPresData.setVisibility(View.GONE);
                }else{
                    aceVPresNoData.setVisibility(View.GONE);
                    aceVPresData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        AceData data = snapshot.getValue(AceData.class);
                        list2.add(data);
                    }
                    aceVPresData.setHasFixedSize(true);
                    aceVPresData.setLayoutManager(new LinearLayoutManager(UpdateAce.this));
                    adapter = new AceAdapter(list2, UpdateAce.this, "Vice President");
                    aceVPresData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void aceSecData() {
        dbRef = reference.child("Secretary");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list3 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    aceSecNoData.setVisibility(View.VISIBLE);
                    aceSecData.setVisibility(View.GONE);
                }else{
                    aceSecNoData.setVisibility(View.GONE);
                    aceSecData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        AceData data = snapshot.getValue(AceData.class);
                        list3.add(data);
                    }
                    aceSecData.setHasFixedSize(true);
                    aceSecData.setLayoutManager(new LinearLayoutManager(UpdateAce.this));
                    adapter = new AceAdapter(list3, UpdateAce.this, "Secretary");
                    aceSecData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void aceASecData() {
        dbRef = reference.child("Assistant Secretary");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list4 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    aceASecData.setVisibility(View.VISIBLE);
                    aceASecData.setVisibility(View.GONE);
                }else{
                    aceASecNoData.setVisibility(View.GONE);
                    aceASecData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        AceData data = snapshot.getValue(AceData.class);
                        list4.add(data);
                    }
                    aceASecData.setHasFixedSize(true);
                    aceASecData.setLayoutManager(new LinearLayoutManager(UpdateAce.this));
                    adapter = new AceAdapter(list4, UpdateAce.this, "Assistant Secretary");
                    aceASecData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void aceTresData() {
        dbRef = reference.child("Treasurer");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list5 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    aceTresNoData.setVisibility(View.VISIBLE);
                    aceTresData.setVisibility(View.GONE);
                }else{
                    aceTresNoData.setVisibility(View.GONE);
                    aceTresData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        AceData data = snapshot.getValue(AceData.class);
                        list5.add(data);
                    }
                    aceTresData.setHasFixedSize(true);
                    aceTresData.setLayoutManager(new LinearLayoutManager(UpdateAce.this));
                    adapter = new AceAdapter(list5, UpdateAce.this, "Treasurer");
                    aceTresData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void aceATresData() {
        dbRef = reference.child("Assistant Treasurer");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list6 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    aceATresNoData.setVisibility(View.VISIBLE);
                    aceATresData.setVisibility(View.GONE);
                }else{
                    aceATresNoData.setVisibility(View.GONE);
                    aceATresData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        AceData data = snapshot.getValue(AceData.class);
                        list6.add(data);
                    }
                    aceATresData.setHasFixedSize(true);
                    aceATresData.setLayoutManager(new LinearLayoutManager(UpdateAce.this));
                    adapter = new AceAdapter(list6, UpdateAce.this, "Assistant Treasurer");
                    aceATresData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void aceAuditorData() {
        dbRef = reference.child("Auditor");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list7 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    aceAuditorNoData.setVisibility(View.VISIBLE);
                    aceAuditorData.setVisibility(View.GONE);
                }else{
                    aceAuditorNoData.setVisibility(View.GONE);
                    aceAuditorData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        AceData data = snapshot.getValue(AceData.class);
                        list7.add(data);
                    }
                    aceAuditorData.setHasFixedSize(true);
                    aceAuditorData.setLayoutManager(new LinearLayoutManager(UpdateAce.this));
                    adapter = new AceAdapter(list7, UpdateAce.this, "Auditor");
                    aceAuditorData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void aceAAuditorData() {
        dbRef = reference.child("Assistant Auditor");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list8 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    aceAAuditorNoData.setVisibility(View.VISIBLE);
                    aceAAuditorData.setVisibility(View.GONE);
                }else{
                    aceAAuditorNoData.setVisibility(View.GONE);
                    aceAAuditorData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        AceData data = snapshot.getValue(AceData.class);
                        list8.add(data);
                    }
                    aceAAuditorData.setHasFixedSize(true);
                    aceAAuditorData.setLayoutManager(new LinearLayoutManager(UpdateAce.this));
                    adapter = new AceAdapter(list8, UpdateAce.this, "Assistant Auditor");
                    aceAAuditorData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void aceBusData() {
        dbRef = reference.child("Business Manager");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list9 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    aceBusNoData.setVisibility(View.VISIBLE);
                    aceBusData.setVisibility(View.GONE);
                }else{
                    aceBusNoData.setVisibility(View.GONE);
                    aceBusData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        AceData data = snapshot.getValue(AceData.class);
                        list9.add(data);
                    }
                    aceBusData.setHasFixedSize(true);
                    aceBusData.setLayoutManager(new LinearLayoutManager(UpdateAce.this));
                    adapter = new AceAdapter(list9, UpdateAce.this, "Business Manager");
                    aceBusData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void aceProData() {
        dbRef = reference.child("Project Manager");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list10 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    aceProNoData.setVisibility(View.VISIBLE);
                    aceProData.setVisibility(View.GONE);
                }else{
                    aceProNoData.setVisibility(View.GONE);
                    aceProData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        AceData data = snapshot.getValue(AceData.class);
                        list10.add(data);
                    }
                    aceProData.setHasFixedSize(true);
                    aceProData.setLayoutManager(new LinearLayoutManager(UpdateAce.this));
                    adapter = new AceAdapter(list10, UpdateAce.this, "Project Manager");
                    aceProData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void aceTechData() {
        dbRef = reference.child("Tech Officer");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list11 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    aceTechNoData.setVisibility(View.VISIBLE);
                    aceTechData.setVisibility(View.GONE);
                }else{
                    aceTechNoData.setVisibility(View.GONE);
                    aceTechData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        AceData data = snapshot.getValue(AceData.class);
                        list11.add(data);
                    }
                    aceTechData.setHasFixedSize(true);
                    aceTechData.setLayoutManager(new LinearLayoutManager(UpdateAce.this));
                    adapter = new AceAdapter(list11, UpdateAce.this, "Tech Officer");
                    aceTechData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void ace4YrData() {
        dbRef = reference.child("4th Year Representative");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list12 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    ace4YrNoData.setVisibility(View.VISIBLE);
                    ace4YrData.setVisibility(View.GONE);
                }else{
                    ace4YrNoData.setVisibility(View.GONE);
                    ace4YrData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        AceData data = snapshot.getValue(AceData.class);
                        list12.add(data);
                    }
                    ace4YrData.setHasFixedSize(true);
                    ace4YrData.setLayoutManager(new LinearLayoutManager(UpdateAce.this));
                    adapter = new AceAdapter(list12, UpdateAce.this, "4th Year Representative");
                    ace4YrData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void ace3YrData() {
        dbRef = reference.child("3rd Year Representative");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list13 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    ace3YrNoData.setVisibility(View.VISIBLE);
                    ace3YrData.setVisibility(View.GONE);
                }else{
                    ace3YrNoData.setVisibility(View.GONE);
                    ace3YrData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        AceData data = snapshot.getValue(AceData.class);
                        list13.add(data);
                    }
                    ace3YrData.setHasFixedSize(true);
                    ace3YrData.setLayoutManager(new LinearLayoutManager(UpdateAce.this));
                    adapter = new AceAdapter(list13, UpdateAce.this, "3rd Year Representative");
                    ace3YrData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void ace2YrData() {
        dbRef = reference.child("2nd Year Representative");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list14 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    ace2YrNoData.setVisibility(View.VISIBLE);
                    ace2YrData.setVisibility(View.GONE);
                }else{
                    ace2YrNoData.setVisibility(View.GONE);
                    ace2YrData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        AceData data = snapshot.getValue(AceData.class);
                        list14.add(data);
                    }
                    ace2YrData.setHasFixedSize(true);
                    ace2YrData.setLayoutManager(new LinearLayoutManager(UpdateAce.this));
                    adapter = new AceAdapter(list14, UpdateAce.this, "2nd Year Representative");
                    ace2YrData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void ace1YrData() {
        dbRef = reference.child("1st Year Representative");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list15 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    ace1YrNoData.setVisibility(View.VISIBLE);
                    ace1YrData.setVisibility(View.GONE);
                }else{
                    ace1YrNoData.setVisibility(View.GONE);
                    ace1YrData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        AceData data = snapshot.getValue(AceData.class);
                        list15.add(data);
                    }
                    ace1YrData.setHasFixedSize(true);
                    ace1YrData.setLayoutManager(new LinearLayoutManager(UpdateAce.this));
                    adapter = new AceAdapter(list15, UpdateAce.this, "1st Year Representative");
                    ace1YrData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void aceG12Data() {
        dbRef = reference.child("Grade 12 Representative");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list16 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    aceG12NoData.setVisibility(View.VISIBLE);
                    aceG12Data.setVisibility(View.GONE);
                }else{
                    aceG12NoData.setVisibility(View.GONE);
                    aceG12Data.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        AceData data = snapshot.getValue(AceData.class);
                        list16.add(data);
                    }
                    aceG12Data.setHasFixedSize(true);
                    aceG12Data.setLayoutManager(new LinearLayoutManager(UpdateAce.this));
                    adapter = new AceAdapter(list16, UpdateAce.this, "Grade 12 Representative");
                    aceG12Data.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void aceG11Data() {
        dbRef = reference.child("Grade 11 Representative");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list17 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    aceG11NoData.setVisibility(View.VISIBLE);
                    aceG11Data.setVisibility(View.GONE);
                }else{
                    aceG11NoData.setVisibility(View.GONE);
                    aceG11Data.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        AceData data = snapshot.getValue(AceData.class);
                        list17.add(data);
                    }
                    aceG11Data.setHasFixedSize(true);
                    aceG11Data.setLayoutManager(new LinearLayoutManager(UpdateAce.this));
                    adapter = new AceAdapter(list17, UpdateAce.this, "Grade 11 Representative");
                    aceG11Data.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}