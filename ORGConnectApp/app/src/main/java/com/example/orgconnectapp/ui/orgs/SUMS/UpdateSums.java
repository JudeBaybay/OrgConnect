package com.example.orgconnectapp.ui.orgs.SUMS;

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

public class UpdateSums extends AppCompatActivity {


    private RecyclerView sumsDepartment;
    private LinearLayout sumsNoData;
    private List<TeacherData> listT5;
    private TeacherAdapter adapter1;
    private DatabaseReference reference1, dbRef1;

    private RecyclerView sumsPresData, sumsVPresData, sumsSecData, sumsASecData, sumsTresData, sumsATresData, sumsAuditorData, sumsAAuditorData, sumsBusData, sumsProData, sumsTechData, sums4YrData, sums3YrData, sums2YrData, sums1YrData, sumsG12Data, sumsG11Data;
    private LinearLayout sumsPresNoData, sumsVPresNoData, sumsSecNoData, sumsASecNoData, sumsTresNoData, sumsATresNoData , sumsAuditorNoData, sumsAAuditorNoData, sumsBusNoData, sumsProNoData, sumsTechNoData, sums4YrNoData, sums3YrNoData, sums2YrNoData, sums1YrNoData, sumsG12NoData,   sumsG11NoData;
    private List<SumsData> list1, list2, list3, list4, list5, list6, list7, list8, list9, list10, list11, list12, list13, list14, list15, list16, list17;
    private SumsAdapter adapter;
    private DatabaseReference reference, dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_sums);

        sumsDepartment = findViewById(R.id.sumsDepartnment);
        sumsNoData = findViewById(R.id.sumsNoData);

        sumsPresData = findViewById(R.id.sumsPresData);
        sumsVPresData = findViewById(R.id.sumsVPresData);
        sumsSecData = findViewById(R.id.sumsSecData);
        sumsASecData = findViewById(R.id.sumsASecData);
        sumsTresData = findViewById(R.id.sumsTresData);
        sumsATresData = findViewById(R.id.sumsATresData);
        sumsAuditorData = findViewById(R.id.sumsAuditorData);
        sumsAAuditorData = findViewById(R.id.sumsAAuditorData);
        sumsBusData = findViewById(R.id.sumsBusData);
        sumsProData = findViewById(R.id.sumsProData);
        sumsTechData = findViewById(R.id.sumsTechData);
        sums4YrData = findViewById(R.id.sums4YrData);
        sums3YrData = findViewById(R.id.sums3YrData);
        sums2YrData = findViewById(R.id.sums2YrData);
        sums1YrData = findViewById(R.id.sums1YrData);
        sumsG12Data = findViewById(R.id.sumsG12Data);
        sumsG11Data = findViewById(R.id.sumsG11Data);


        sumsPresNoData = findViewById(R.id.sumsPresNoData);
        sumsVPresNoData = findViewById(R.id.sumsVPresNoData);
        sumsSecNoData = findViewById(R.id.sumsSecNoData);
        sumsASecNoData = findViewById(R.id.sumsASecNoData);
        sumsTresNoData = findViewById(R.id.sumsTresNoData);
        sumsATresNoData = findViewById(R.id.sumsATresNoData);
        sumsAuditorNoData = findViewById(R.id.sumsAuditorNoData);
        sumsAAuditorNoData = findViewById(R.id.sumsAAuditorNoData);
        sumsProNoData = findViewById(R.id.sumsProNoData);
        sumsBusNoData = findViewById(R.id.sumsBusNoData);
        sumsTechNoData = findViewById(R.id.sumsTechNoData);
        sums4YrNoData = findViewById(R.id.sums4YrNoData);
        sums3YrNoData = findViewById(R.id.sums3YrNoData);
        sums2YrNoData = findViewById(R.id.sums2YrNoData);
        sums1YrNoData = findViewById(R.id.sums1YrNoData);
        sumsG12NoData = findViewById(R.id.sumsG12NoData);
        sumsG11NoData = findViewById(R.id.sumsG11NoData);

        reference = FirebaseDatabase.getInstance().getReference().child("SUMS Officers");
        reference1 = FirebaseDatabase.getInstance().getReference().child("Teacher");

        sumsDepartnment();

        sumsPresData();
        sumsVPresData();
        sumsSecData();
        sumsASecData();
        sumsTresData();
        sumsATresData();
        sumsAuditorData();
        sumsAAuditorData();
        sumsBusData();
        sumsProData();
        sumsTechData();
        sums4YrData();
        sums3YrData();
        sums2YrData();
        sums1YrData();
        sumsG12Data();
        sumsG11Data();

    }

    private void sumsDepartnment() {
        dbRef1 = reference1.child("SUMS Adviser");
        dbRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listT5 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    sumsNoData.setVisibility(View.VISIBLE);
                    sumsDepartment.setVisibility(View.GONE);
                }else{
                    sumsNoData.setVisibility(View.GONE);
                    sumsDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        listT5.add(data);
                    }
                    sumsDepartment.setHasFixedSize(true);
                    sumsDepartment.setLayoutManager(new LinearLayoutManager(UpdateSums.this));
                    adapter1 = new TeacherAdapter(listT5, UpdateSums.this, "SUMS Adviser");
                    sumsDepartment.setAdapter(adapter1);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateSums.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void sumsPresData() {
        dbRef = reference.child("President");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    sumsPresNoData.setVisibility(View.VISIBLE);
                    sumsPresData.setVisibility(View.GONE);
                }else{
                    sumsPresNoData.setVisibility(View.GONE);
                    sumsPresData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        SumsData data = snapshot.getValue(SumsData.class);
                        list1.add(data);
                    }
                    sumsPresData.setHasFixedSize(true);
                    sumsPresData.setLayoutManager(new LinearLayoutManager(UpdateSums.this));
                    adapter = new SumsAdapter(list1, UpdateSums.this, "President");
                    sumsPresData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void sumsVPresData() {
        dbRef = reference.child("Vice President");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list2 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    sumsVPresNoData.setVisibility(View.VISIBLE);
                    sumsVPresData.setVisibility(View.GONE);
                }else{
                    sumsVPresNoData.setVisibility(View.GONE);
                    sumsVPresData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        SumsData data = snapshot.getValue(SumsData.class);
                        list2.add(data);
                    }
                    sumsVPresData.setHasFixedSize(true);
                    sumsVPresData.setLayoutManager(new LinearLayoutManager(UpdateSums.this));
                    adapter = new SumsAdapter(list2, UpdateSums.this, "Vice President");
                    sumsVPresData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void sumsSecData() {
        dbRef = reference.child("Secretary");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list3 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    sumsSecNoData.setVisibility(View.VISIBLE);
                    sumsSecData.setVisibility(View.GONE);
                }else{
                    sumsSecNoData.setVisibility(View.GONE);
                    sumsSecData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        SumsData data = snapshot.getValue(SumsData.class);
                        list3.add(data);
                    }
                    sumsSecData.setHasFixedSize(true);
                    sumsSecData.setLayoutManager(new LinearLayoutManager(UpdateSums.this));
                    adapter = new SumsAdapter(list3, UpdateSums.this, "Secretary");
                    sumsSecData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void sumsASecData() {
        dbRef = reference.child("Assistant Secretary");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list4 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    sumsASecData.setVisibility(View.VISIBLE);
                    sumsASecData.setVisibility(View.GONE);
                }else{
                    sumsASecNoData.setVisibility(View.GONE);
                    sumsASecData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        SumsData data = snapshot.getValue(SumsData.class);
                        list4.add(data);
                    }
                    sumsASecData.setHasFixedSize(true);
                    sumsASecData.setLayoutManager(new LinearLayoutManager(UpdateSums.this));
                    adapter = new SumsAdapter(list4, UpdateSums.this, "Assistant Secretary");
                    sumsASecData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void sumsTresData() {
        dbRef = reference.child("Treasurer");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list5 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    sumsTresNoData.setVisibility(View.VISIBLE);
                    sumsTresData.setVisibility(View.GONE);
                }else{
                    sumsTresNoData.setVisibility(View.GONE);
                    sumsTresData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        SumsData data = snapshot.getValue(SumsData.class);
                        list5.add(data);
                    }
                    sumsTresData.setHasFixedSize(true);
                    sumsTresData.setLayoutManager(new LinearLayoutManager(UpdateSums.this));
                    adapter = new SumsAdapter(list5, UpdateSums.this, "Treasurer");
                    sumsTresData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void sumsATresData() {
        dbRef = reference.child("Assistant Treasurer");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list6 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    sumsATresNoData.setVisibility(View.VISIBLE);
                    sumsATresData.setVisibility(View.GONE);
                }else{
                    sumsATresNoData.setVisibility(View.GONE);
                    sumsATresData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        SumsData data = snapshot.getValue(SumsData.class);
                        list6.add(data);
                    }
                    sumsATresData.setHasFixedSize(true);
                    sumsATresData.setLayoutManager(new LinearLayoutManager(UpdateSums.this));
                    adapter = new SumsAdapter(list6, UpdateSums.this, "Assistant Treasurer");
                    sumsATresData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void sumsAuditorData() {
        dbRef = reference.child("Auditor");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list7 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    sumsAuditorNoData.setVisibility(View.VISIBLE);
                    sumsAuditorData.setVisibility(View.GONE);
                }else{
                    sumsAuditorNoData.setVisibility(View.GONE);
                    sumsAuditorData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        SumsData data = snapshot.getValue(SumsData.class);
                        list7.add(data);
                    }
                    sumsAuditorData.setHasFixedSize(true);
                    sumsAuditorData.setLayoutManager(new LinearLayoutManager(UpdateSums.this));
                    adapter = new SumsAdapter(list7, UpdateSums.this, "Auditor");
                    sumsAuditorData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void sumsAAuditorData() {
        dbRef = reference.child("Assistant Auditor");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list8 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    sumsAAuditorNoData.setVisibility(View.VISIBLE);
                    sumsAAuditorData.setVisibility(View.GONE);
                }else{
                    sumsAAuditorNoData.setVisibility(View.GONE);
                    sumsAAuditorData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        SumsData data = snapshot.getValue(SumsData.class);
                        list8.add(data);
                    }
                    sumsAAuditorData.setHasFixedSize(true);
                    sumsAAuditorData.setLayoutManager(new LinearLayoutManager(UpdateSums.this));
                    adapter = new SumsAdapter(list8, UpdateSums.this, "Assistant Auditor");
                    sumsAAuditorData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void sumsBusData() {
        dbRef = reference.child("Business Manager");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list9 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    sumsBusNoData.setVisibility(View.VISIBLE);
                    sumsBusData.setVisibility(View.GONE);
                }else{
                    sumsBusNoData.setVisibility(View.GONE);
                    sumsBusData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        SumsData data = snapshot.getValue(SumsData.class);
                        list9.add(data);
                    }
                    sumsBusData.setHasFixedSize(true);
                    sumsBusData.setLayoutManager(new LinearLayoutManager(UpdateSums.this));
                    adapter = new SumsAdapter(list9, UpdateSums.this, "Business Manager");
                    sumsBusData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void sumsProData() {
        dbRef = reference.child("Project Manager");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list10 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    sumsProNoData.setVisibility(View.VISIBLE);
                    sumsProData.setVisibility(View.GONE);
                }else{
                    sumsProNoData.setVisibility(View.GONE);
                    sumsProData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        SumsData data = snapshot.getValue(SumsData.class);
                        list10.add(data);
                    }
                    sumsProData.setHasFixedSize(true);
                    sumsProData.setLayoutManager(new LinearLayoutManager(UpdateSums.this));
                    adapter = new SumsAdapter(list10, UpdateSums.this, "Project Manager");
                    sumsProData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void sumsTechData() {
        dbRef = reference.child("Tech Officer");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list11 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    sumsTechNoData.setVisibility(View.VISIBLE);
                    sumsTechData.setVisibility(View.GONE);
                }else{
                    sumsTechNoData.setVisibility(View.GONE);
                    sumsTechData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        SumsData data = snapshot.getValue(SumsData.class);
                        list11.add(data);
                    }
                    sumsTechData.setHasFixedSize(true);
                    sumsTechData.setLayoutManager(new LinearLayoutManager(UpdateSums.this));
                    adapter = new SumsAdapter(list11, UpdateSums.this, "Tech Officer");
                    sumsTechData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void sums4YrData() {
        dbRef = reference.child("4th Year Representative");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list12 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    sums4YrNoData.setVisibility(View.VISIBLE);
                    sums4YrData.setVisibility(View.GONE);
                }else{
                    sums4YrNoData.setVisibility(View.GONE);
                    sums4YrData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        SumsData data = snapshot.getValue(SumsData.class);
                        list12.add(data);
                    }
                    sums4YrData.setHasFixedSize(true);
                    sums4YrData.setLayoutManager(new LinearLayoutManager(UpdateSums.this));
                    adapter = new SumsAdapter(list12, UpdateSums.this, "4th Year Representative");
                    sums4YrData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void sums3YrData() {
        dbRef = reference.child("3rd Year Representative");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list13 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    sums3YrNoData.setVisibility(View.VISIBLE);
                    sums3YrData.setVisibility(View.GONE);
                }else{
                    sums3YrNoData.setVisibility(View.GONE);
                    sums3YrData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        SumsData data = snapshot.getValue(SumsData.class);
                        list13.add(data);
                    }
                    sums3YrData.setHasFixedSize(true);
                    sums3YrData.setLayoutManager(new LinearLayoutManager(UpdateSums.this));
                    adapter = new SumsAdapter(list13, UpdateSums.this, "3rd Year Representative");
                    sums3YrData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void sums2YrData() {
        dbRef = reference.child("2nd Year Representative");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list14 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    sums2YrNoData.setVisibility(View.VISIBLE);
                    sums2YrData.setVisibility(View.GONE);
                }else{
                    sums2YrNoData.setVisibility(View.GONE);
                    sums2YrData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        SumsData data = snapshot.getValue(SumsData.class);
                        list14.add(data);
                    }
                    sums2YrData.setHasFixedSize(true);
                    sums2YrData.setLayoutManager(new LinearLayoutManager(UpdateSums.this));
                    adapter = new SumsAdapter(list14, UpdateSums.this, "2nd Year Representative");
                    sums2YrData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void sums1YrData() {
        dbRef = reference.child("1st Year Representative");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list15 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    sums1YrNoData.setVisibility(View.VISIBLE);
                    sums1YrData.setVisibility(View.GONE);
                }else{
                    sums1YrNoData.setVisibility(View.GONE);
                    sums1YrData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        SumsData data = snapshot.getValue(SumsData.class);
                        list15.add(data);
                    }
                    sums1YrData.setHasFixedSize(true);
                    sums1YrData.setLayoutManager(new LinearLayoutManager(UpdateSums.this));
                    adapter = new SumsAdapter(list15, UpdateSums.this, "1st Year Representative");
                    sums1YrData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void sumsG12Data() {
        dbRef = reference.child("Grade 12 Representative");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list16 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    sumsG12NoData.setVisibility(View.VISIBLE);
                    sumsG12Data.setVisibility(View.GONE);
                }else{
                    sumsG12NoData.setVisibility(View.GONE);
                    sumsG12Data.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        SumsData data = snapshot.getValue(SumsData.class);
                        list16.add(data);
                    }
                    sumsG12Data.setHasFixedSize(true);
                    sumsG12Data.setLayoutManager(new LinearLayoutManager(UpdateSums.this));
                    adapter = new SumsAdapter(list16, UpdateSums.this, "Grade 12 Representative");
                    sumsG12Data.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void sumsG11Data() {
        dbRef = reference.child("Grade 11 Representative");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list17 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    sumsG11NoData.setVisibility(View.VISIBLE);
                    sumsG11Data.setVisibility(View.GONE);
                }else{
                    sumsG11NoData.setVisibility(View.GONE);
                    sumsG11Data.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        SumsData data = snapshot.getValue(SumsData.class);
                        list17.add(data);
                    }
                    sumsG11Data.setHasFixedSize(true);
                    sumsG11Data.setLayoutManager(new LinearLayoutManager(UpdateSums.this));
                    adapter = new SumsAdapter(list17, UpdateSums.this, "Grade 11 Representative");
                    sumsG11Data.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}