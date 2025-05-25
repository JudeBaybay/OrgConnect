package com.example.orgconnectapp.ui.orgs.ATS;

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

public class UpdateAts extends AppCompatActivity {


    private RecyclerView atcDepartnment;
    private LinearLayout atcNoData;
    private List<TeacherData> listT7;
    private TeacherAdapter adapter1;
    private DatabaseReference reference1, dbRef1;
    private RecyclerView atsPresData, atsVPresData, atsSecData, atsASecData, atsTresData, atsATresData, atsAuditorData, atsAAuditorData, atsBusData, atsProData, atsTechData, ats4YrData, ats3YrData, ats2YrData, ats1YrData, atsG12Data, atsG11Data;
    private LinearLayout atsPresNoData, atsVPresNoData, atsSecNoData, atsASecNoData, atsTresNoData, atsATresNoData , atsAuditorNoData, atsAAuditorNoData, atsBusNoData, atsProNoData, atsTechNoData, ats4YrNoData, ats3YrNoData, ats2YrNoData, ats1YrNoData, atsG12NoData,   atsG11NoData;
    private List<AtsData> list1, list2, list3, list4, list5, list6, list7, list8, list9, list10, list11, list12, list13, list14, list15, list16, list17;
    private AtsAdapter adapter;
    private DatabaseReference reference, dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_ats);

        atcDepartnment = findViewById(R.id.atcDepartnment);
        atcNoData = findViewById(R.id.atcNoData);

        atsPresData = findViewById(R.id.atsPresData);
        atsVPresData = findViewById(R.id.atsVPresData);
        atsSecData = findViewById(R.id.atsSecData);
        atsASecData = findViewById(R.id.atsASecData);
        atsTresData = findViewById(R.id.atsTresData);
        atsATresData = findViewById(R.id.atsATresData);
        atsAuditorData = findViewById(R.id.atsAuditorData);
        atsAAuditorData = findViewById(R.id.atsAAuditorData);
        atsBusData = findViewById(R.id.atsBusData);
        atsProData = findViewById(R.id.atsProData);
        atsTechData = findViewById(R.id.atsTechData);
        ats4YrData = findViewById(R.id.ats4YrData);
        ats3YrData = findViewById(R.id.ats3YrData);
        ats2YrData = findViewById(R.id.ats2YrData);
        ats1YrData = findViewById(R.id.ats1YrData);
        atsG12Data = findViewById(R.id.atsG12Data);
        atsG11Data = findViewById(R.id.atsG11Data);


        atsPresNoData = findViewById(R.id.atsPresNoData);
        atsVPresNoData = findViewById(R.id.atsVPresNoData);
        atsSecNoData = findViewById(R.id.atsSecNoData);
        atsASecNoData = findViewById(R.id.atsASecNoData);
        atsTresNoData = findViewById(R.id.atsTresNoData);
        atsATresNoData = findViewById(R.id.atsATresNoData);
        atsAuditorNoData = findViewById(R.id.atsAuditorNoData);
        atsAAuditorNoData = findViewById(R.id.atsAAuditorNoData);
        atsProNoData = findViewById(R.id.atsProNoData);
        atsBusNoData = findViewById(R.id.atsBusNoData);
        atsTechNoData = findViewById(R.id.atsTechNoData);
        ats4YrNoData = findViewById(R.id.ats4YrNoData);
        ats3YrNoData = findViewById(R.id.ats3YrNoData);
        ats2YrNoData = findViewById(R.id.ats2YrNoData);
        ats1YrNoData = findViewById(R.id.ats1YrNoData);
        atsG12NoData = findViewById(R.id.atsG12NoData);
        atsG11NoData = findViewById(R.id.atsG11NoData);

        reference = FirebaseDatabase.getInstance().getReference().child("Athlos Club Officers");
        reference1 = FirebaseDatabase.getInstance().getReference().child("Teacher");

        atcDepartnment();

        atsPresData();
        atsVPresData();
        atsSecData();
        atsASecData();
        atsTresData();
        atsATresData();
        atsAuditorData();
        atsAAuditorData();
        atsBusData();
        atsProData();
        atsTechData();
        ats4YrData();
        ats3YrData();
        ats2YrData();
        ats1YrData();
        atsG12Data();
        atsG11Data();

    }

    private void atcDepartnment() {
        dbRef1 = reference1.child("Athlos Club Adviser");
        dbRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listT7 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    atcNoData.setVisibility(View.VISIBLE);
                    atcDepartnment.setVisibility(View.GONE);
                }else{
                    atcNoData.setVisibility(View.GONE);
                    atcDepartnment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        listT7.add(data);
                    }
                    atcDepartnment.setHasFixedSize(true);
                    atcDepartnment.setLayoutManager(new LinearLayoutManager(UpdateAts.this));
                    adapter1 = new TeacherAdapter(listT7, UpdateAts.this, "Athlos Club Adviser");
                    atcDepartnment.setAdapter(adapter1);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateAts.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void atsPresData() {
        dbRef = reference.child("President");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    atsPresNoData.setVisibility(View.VISIBLE);
                    atsPresData.setVisibility(View.GONE);
                }else{
                    atsPresNoData.setVisibility(View.GONE);
                    atsPresData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        AtsData data = snapshot.getValue(AtsData.class);
                        list1.add(data);
                    }
                    atsPresData.setHasFixedSize(true);
                    atsPresData.setLayoutManager(new LinearLayoutManager(UpdateAts.this));
                    adapter = new AtsAdapter(list1, UpdateAts.this, "President");
                    atsPresData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void atsVPresData() {
        dbRef = reference.child("Vice President");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list2 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    atsVPresNoData.setVisibility(View.VISIBLE);
                    atsVPresData.setVisibility(View.GONE);
                }else{
                    atsVPresNoData.setVisibility(View.GONE);
                    atsVPresData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        AtsData data = snapshot.getValue(AtsData.class);
                        list2.add(data);
                    }
                    atsVPresData.setHasFixedSize(true);
                    atsVPresData.setLayoutManager(new LinearLayoutManager(UpdateAts.this));
                    adapter = new AtsAdapter(list2, UpdateAts.this, "Vice President");
                    atsVPresData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void atsSecData() {
        dbRef = reference.child("Secretary");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list3 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    atsSecNoData.setVisibility(View.VISIBLE);
                    atsSecData.setVisibility(View.GONE);
                }else{
                    atsSecNoData.setVisibility(View.GONE);
                    atsSecData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        AtsData data = snapshot.getValue(AtsData.class);
                        list3.add(data);
                    }
                    atsSecData.setHasFixedSize(true);
                    atsSecData.setLayoutManager(new LinearLayoutManager(UpdateAts.this));
                    adapter = new AtsAdapter(list3, UpdateAts.this, "Secretary");
                    atsSecData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void atsASecData() {
        dbRef = reference.child("Assistant Secretary");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list4 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    atsASecData.setVisibility(View.VISIBLE);
                    atsASecData.setVisibility(View.GONE);
                }else{
                    atsASecNoData.setVisibility(View.GONE);
                    atsASecData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        AtsData data = snapshot.getValue(AtsData.class);
                        list4.add(data);
                    }
                    atsASecData.setHasFixedSize(true);
                    atsASecData.setLayoutManager(new LinearLayoutManager(UpdateAts.this));
                    adapter = new AtsAdapter(list4, UpdateAts.this, "Assistant Secretary");
                    atsASecData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void atsTresData() {
        dbRef = reference.child("Treasurer");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list5 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    atsTresNoData.setVisibility(View.VISIBLE);
                    atsTresData.setVisibility(View.GONE);
                }else{
                    atsTresNoData.setVisibility(View.GONE);
                    atsTresData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        AtsData data = snapshot.getValue(AtsData.class);
                        list5.add(data);
                    }
                    atsTresData.setHasFixedSize(true);
                    atsTresData.setLayoutManager(new LinearLayoutManager(UpdateAts.this));
                    adapter = new AtsAdapter(list5, UpdateAts.this, "Treasurer");
                    atsTresData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void atsATresData() {
        dbRef = reference.child("Assistant Treasurer");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list6 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    atsATresNoData.setVisibility(View.VISIBLE);
                    atsATresData.setVisibility(View.GONE);
                }else{
                    atsATresNoData.setVisibility(View.GONE);
                    atsATresData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        AtsData data = snapshot.getValue(AtsData.class);
                        list6.add(data);
                    }
                    atsATresData.setHasFixedSize(true);
                    atsATresData.setLayoutManager(new LinearLayoutManager(UpdateAts.this));
                    adapter = new AtsAdapter(list6, UpdateAts.this, "Assistant Treasurer");
                    atsATresData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void atsAuditorData() {
        dbRef = reference.child("Auditor");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list7 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    atsAuditorNoData.setVisibility(View.VISIBLE);
                    atsAuditorData.setVisibility(View.GONE);
                }else{
                    atsAuditorNoData.setVisibility(View.GONE);
                    atsAuditorData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        AtsData data = snapshot.getValue(AtsData.class);
                        list7.add(data);
                    }
                    atsAuditorData.setHasFixedSize(true);
                    atsAuditorData.setLayoutManager(new LinearLayoutManager(UpdateAts.this));
                    adapter = new AtsAdapter(list7, UpdateAts.this, "Auditor");
                    atsAuditorData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void atsAAuditorData() {
        dbRef = reference.child("Assistant Auditor");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list8 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    atsAAuditorNoData.setVisibility(View.VISIBLE);
                    atsAAuditorData.setVisibility(View.GONE);
                }else{
                    atsAAuditorNoData.setVisibility(View.GONE);
                    atsAAuditorData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        AtsData data = snapshot.getValue(AtsData.class);
                        list8.add(data);
                    }
                    atsAAuditorData.setHasFixedSize(true);
                    atsAAuditorData.setLayoutManager(new LinearLayoutManager(UpdateAts.this));
                    adapter = new AtsAdapter(list8, UpdateAts.this, "Assistant Auditor");
                    atsAAuditorData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void atsBusData() {
        dbRef = reference.child("Business Manager");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list9 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    atsBusNoData.setVisibility(View.VISIBLE);
                    atsBusData.setVisibility(View.GONE);
                }else{
                    atsBusNoData.setVisibility(View.GONE);
                    atsBusData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        AtsData data = snapshot.getValue(AtsData.class);
                        list9.add(data);
                    }
                    atsBusData.setHasFixedSize(true);
                    atsBusData.setLayoutManager(new LinearLayoutManager(UpdateAts.this));
                    adapter = new AtsAdapter(list9, UpdateAts.this, "Business Manager");
                    atsBusData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void atsProData() {
        dbRef = reference.child("Project Manager");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list10 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    atsProNoData.setVisibility(View.VISIBLE);
                    atsProData.setVisibility(View.GONE);
                }else{
                    atsProNoData.setVisibility(View.GONE);
                    atsProData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        AtsData data = snapshot.getValue(AtsData.class);
                        list10.add(data);
                    }
                    atsProData.setHasFixedSize(true);
                    atsProData.setLayoutManager(new LinearLayoutManager(UpdateAts.this));
                    adapter = new AtsAdapter(list10, UpdateAts.this, "Project Manager");
                    atsProData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void atsTechData() {
        dbRef = reference.child("Tech Officer");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list11 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    atsTechNoData.setVisibility(View.VISIBLE);
                    atsTechData.setVisibility(View.GONE);
                }else{
                    atsTechNoData.setVisibility(View.GONE);
                    atsTechData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        AtsData data = snapshot.getValue(AtsData.class);
                        list11.add(data);
                    }
                    atsTechData.setHasFixedSize(true);
                    atsTechData.setLayoutManager(new LinearLayoutManager(UpdateAts.this));
                    adapter = new AtsAdapter(list11, UpdateAts.this, "Tech Officer");
                    atsTechData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void ats4YrData() {
        dbRef = reference.child("4th Year Representative");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list12 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    ats4YrNoData.setVisibility(View.VISIBLE);
                    ats4YrData.setVisibility(View.GONE);
                }else{
                    ats4YrNoData.setVisibility(View.GONE);
                    ats4YrData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        AtsData data = snapshot.getValue(AtsData.class);
                        list12.add(data);
                    }
                    ats4YrData.setHasFixedSize(true);
                    ats4YrData.setLayoutManager(new LinearLayoutManager(UpdateAts.this));
                    adapter = new AtsAdapter(list12, UpdateAts.this, "4th Year Representative");
                    ats4YrData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void ats3YrData() {
        dbRef = reference.child("3rd Year Representative");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list13 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    ats3YrNoData.setVisibility(View.VISIBLE);
                    ats3YrData.setVisibility(View.GONE);
                }else{
                    ats3YrNoData.setVisibility(View.GONE);
                    ats3YrData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        AtsData data = snapshot.getValue(AtsData.class);
                        list13.add(data);
                    }
                    ats3YrData.setHasFixedSize(true);
                    ats3YrData.setLayoutManager(new LinearLayoutManager(UpdateAts.this));
                    adapter = new AtsAdapter(list13, UpdateAts.this, "3rd Year Representative");
                    ats3YrData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void ats2YrData() {
        dbRef = reference.child("2nd Year Representative");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list14 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    ats2YrNoData.setVisibility(View.VISIBLE);
                    ats2YrData.setVisibility(View.GONE);
                }else{
                    ats2YrNoData.setVisibility(View.GONE);
                    ats2YrData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        AtsData data = snapshot.getValue(AtsData.class);
                        list14.add(data);
                    }
                    ats2YrData.setHasFixedSize(true);
                    ats2YrData.setLayoutManager(new LinearLayoutManager(UpdateAts.this));
                    adapter = new AtsAdapter(list14, UpdateAts.this, "2nd Year Representative");
                    ats2YrData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void ats1YrData() {
        dbRef = reference.child("1st Year Representative");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list15 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    ats1YrNoData.setVisibility(View.VISIBLE);
                    ats1YrData.setVisibility(View.GONE);
                }else{
                    ats1YrNoData.setVisibility(View.GONE);
                    ats1YrData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        AtsData data = snapshot.getValue(AtsData.class);
                        list15.add(data);
                    }
                    ats1YrData.setHasFixedSize(true);
                    ats1YrData.setLayoutManager(new LinearLayoutManager(UpdateAts.this));
                    adapter = new AtsAdapter(list15, UpdateAts.this, "1st Year Representative");
                    ats1YrData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void atsG12Data() {
        dbRef = reference.child("Grade 12 Representative");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list16 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    atsG12NoData.setVisibility(View.VISIBLE);
                    atsG12Data.setVisibility(View.GONE);
                }else{
                    atsG12NoData.setVisibility(View.GONE);
                    atsG12Data.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        AtsData data = snapshot.getValue(AtsData.class);
                        list16.add(data);
                    }
                    atsG12Data.setHasFixedSize(true);
                    atsG12Data.setLayoutManager(new LinearLayoutManager(UpdateAts.this));
                    adapter = new AtsAdapter(list16, UpdateAts.this, "Grade 12 Representative");
                    atsG12Data.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void atsG11Data() {
        dbRef = reference.child("Grade 11 Representative");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list17 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    atsG11NoData.setVisibility(View.VISIBLE);
                    atsG11Data.setVisibility(View.GONE);
                }else{
                    atsG11NoData.setVisibility(View.GONE);
                    atsG11Data.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        AtsData data = snapshot.getValue(AtsData.class);
                        list17.add(data);
                    }
                    atsG11Data.setHasFixedSize(true);
                    atsG11Data.setLayoutManager(new LinearLayoutManager(UpdateAts.this));
                    adapter = new AtsAdapter(list17, UpdateAts.this, "Grade 11 Representative");
                    atsG11Data.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}