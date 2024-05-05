package com.example.orgconnectapp.ui.orgs.SYMS;

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

public class UpdateSyms extends AppCompatActivity {



    private RecyclerView symsDepartnment;
    private LinearLayout symsNoData;
    private List<TeacherData> listT3;
    private TeacherAdapter adapter1;
    private DatabaseReference reference1, dbRef1;
    private RecyclerView symsPresData, symsVPresData, symsSecData, symsASecData, symsTresData, symsATresData, symsAuditorData, symsAAuditorData, symsBusData, symsProData, symsTechData, syms4YrData, syms3YrData, syms2YrData, syms1YrData, symsG12Data, symsG11Data;
    private LinearLayout symsPresNoData, symsVPresNoData, symsSecNoData, symsASecNoData, symsTresNoData, symsATresNoData , symsAuditorNoData, symsAAuditorNoData, symsBusNoData, symsProNoData, symsTechNoData, syms4YrNoData, syms3YrNoData, syms2YrNoData, syms1YrNoData, symsG12NoData,   symsG11NoData;
    private List<SymsData> list1, list2, list3, list4, list5, list6, list7, list8, list9, list10, list11, list12, list13, list14, list15, list16, list17;
    private SymsAdapter adapter;
    private DatabaseReference reference, dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_syms);

        symsDepartnment = findViewById(R.id.symsDepartnment);
        symsNoData = findViewById(R.id.symsNoData);

        symsPresData = findViewById(R.id.symsPresData);
        symsVPresData = findViewById(R.id.symsVPresData);
        symsSecData = findViewById(R.id.symsSecData);
        symsASecData = findViewById(R.id.symsASecData);
        symsTresData = findViewById(R.id.symsTresData);
        symsATresData = findViewById(R.id.symsATresData);
        symsAuditorData = findViewById(R.id.symsAuditorData);
        symsAAuditorData = findViewById(R.id.symsAAuditorData);
        symsBusData = findViewById(R.id.symsBusData);
        symsProData = findViewById(R.id.symsProData);
        symsTechData = findViewById(R.id.symsTechData);
        syms4YrData = findViewById(R.id.syms4YrData);
        syms3YrData = findViewById(R.id.syms3YrData);
        syms2YrData = findViewById(R.id.syms2YrData);
        syms1YrData = findViewById(R.id.syms1YrData);
        symsG12Data = findViewById(R.id.symsG12Data);
        symsG11Data = findViewById(R.id.symsG11Data);


        symsPresNoData = findViewById(R.id.symsPresNoData);
        symsVPresNoData = findViewById(R.id.symsVPresNoData);
        symsSecNoData = findViewById(R.id.symsSecNoData);
        symsASecNoData = findViewById(R.id.symsASecNoData);
        symsTresNoData = findViewById(R.id.symsTresNoData);
        symsATresNoData = findViewById(R.id.symsATresNoData);
        symsAuditorNoData = findViewById(R.id.symsAuditorNoData);
        symsAAuditorNoData = findViewById(R.id.symsAAuditorNoData);
        symsProNoData = findViewById(R.id.symsProNoData);
        symsBusNoData = findViewById(R.id.symsBusNoData);
        symsTechNoData = findViewById(R.id.symsTechNoData);
        syms4YrNoData = findViewById(R.id.syms4YrNoData);
        syms3YrNoData = findViewById(R.id.syms3YrNoData);
        syms2YrNoData = findViewById(R.id.syms2YrNoData);
        syms1YrNoData = findViewById(R.id.syms1YrNoData);
        symsG12NoData = findViewById(R.id.symsG12NoData);
        symsG11NoData = findViewById(R.id.symsG11NoData);

        reference = FirebaseDatabase.getInstance().getReference().child("SYMS Officers");
        reference1 = FirebaseDatabase.getInstance().getReference().child("Teacher");

        symsDepartnment();

        symsPresData();
        symsVPresData();
        symsSecData();
        symsASecData();
        symsTresData();
        symsATresData();
        symsAuditorData();
        symsAAuditorData();
        symsBusData();
        symsProData();
        symsTechData();
        syms4YrData();
        syms3YrData();
        syms2YrData();
        syms1YrData();
        symsG12Data();
        symsG11Data();

    }

    private void symsDepartnment() {
        dbRef1 = reference1.child("SYMS Adviser");
        dbRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listT3 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    symsNoData.setVisibility(View.VISIBLE);
                    symsDepartnment.setVisibility(View.GONE);
                }else{
                    symsNoData.setVisibility(View.GONE);
                    symsDepartnment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        listT3.add(data);
                    }
                    symsDepartnment.setHasFixedSize(true);
                    symsDepartnment.setLayoutManager(new LinearLayoutManager(UpdateSyms.this));
                    adapter1 = new TeacherAdapter(listT3, UpdateSyms.this, "SYMS Adviser");
                    symsDepartnment.setAdapter(adapter1);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateSyms.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void symsPresData() {
        dbRef = reference.child("President");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    symsPresNoData.setVisibility(View.VISIBLE);
                    symsPresData.setVisibility(View.GONE);
                }else{
                    symsPresNoData.setVisibility(View.GONE);
                    symsPresData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        SymsData data = snapshot.getValue(SymsData.class);
                        list1.add(data);
                    }
                    symsPresData.setHasFixedSize(true);
                    symsPresData.setLayoutManager(new LinearLayoutManager(UpdateSyms.this));
                    adapter = new SymsAdapter(list1, UpdateSyms.this, "President");
                    symsPresData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void symsVPresData() {
        dbRef = reference.child("Vice President");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list2 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    symsVPresNoData.setVisibility(View.VISIBLE);
                    symsVPresData.setVisibility(View.GONE);
                }else{
                    symsVPresNoData.setVisibility(View.GONE);
                    symsVPresData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        SymsData data = snapshot.getValue(SymsData.class);
                        list2.add(data);
                    }
                    symsVPresData.setHasFixedSize(true);
                    symsVPresData.setLayoutManager(new LinearLayoutManager(UpdateSyms.this));
                    adapter = new SymsAdapter(list2, UpdateSyms.this, "Vice President");
                    symsVPresData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void symsSecData() {
        dbRef = reference.child("Secretary");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list3 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    symsSecNoData.setVisibility(View.VISIBLE);
                    symsSecData.setVisibility(View.GONE);
                }else{
                    symsSecNoData.setVisibility(View.GONE);
                    symsSecData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        SymsData data = snapshot.getValue(SymsData.class);
                        list3.add(data);
                    }
                    symsSecData.setHasFixedSize(true);
                    symsSecData.setLayoutManager(new LinearLayoutManager(UpdateSyms.this));
                    adapter = new SymsAdapter(list3, UpdateSyms.this, "Secretary");
                    symsSecData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void symsASecData() {
        dbRef = reference.child("Assistant Secretary");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list4 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    symsASecData.setVisibility(View.VISIBLE);
                    symsASecData.setVisibility(View.GONE);
                }else{
                    symsASecNoData.setVisibility(View.GONE);
                    symsASecData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        SymsData data = snapshot.getValue(SymsData.class);
                        list4.add(data);
                    }
                    symsASecData.setHasFixedSize(true);
                    symsASecData.setLayoutManager(new LinearLayoutManager(UpdateSyms.this));
                    adapter = new SymsAdapter(list4, UpdateSyms.this, "Assistant Secretary");
                    symsASecData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void symsTresData() {
        dbRef = reference.child("Treasurer");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list5 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    symsTresNoData.setVisibility(View.VISIBLE);
                    symsTresData.setVisibility(View.GONE);
                }else{
                    symsTresNoData.setVisibility(View.GONE);
                    symsTresData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        SymsData data = snapshot.getValue(SymsData.class);
                        list5.add(data);
                    }
                    symsTresData.setHasFixedSize(true);
                    symsTresData.setLayoutManager(new LinearLayoutManager(UpdateSyms.this));
                    adapter = new SymsAdapter(list5, UpdateSyms.this, "Treasurer");
                    symsTresData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void symsATresData() {
        dbRef = reference.child("Assistant Treasurer");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list6 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    symsATresNoData.setVisibility(View.VISIBLE);
                    symsATresData.setVisibility(View.GONE);
                }else{
                    symsATresNoData.setVisibility(View.GONE);
                    symsATresData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        SymsData data = snapshot.getValue(SymsData.class);
                        list6.add(data);
                    }
                    symsATresData.setHasFixedSize(true);
                    symsATresData.setLayoutManager(new LinearLayoutManager(UpdateSyms.this));
                    adapter = new SymsAdapter(list6, UpdateSyms.this, "Assistant Treasurer");
                    symsATresData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void symsAuditorData() {
        dbRef = reference.child("Auditor");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list7 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    symsAuditorNoData.setVisibility(View.VISIBLE);
                    symsAuditorData.setVisibility(View.GONE);
                }else{
                    symsAuditorNoData.setVisibility(View.GONE);
                    symsAuditorData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        SymsData data = snapshot.getValue(SymsData.class);
                        list7.add(data);
                    }
                    symsAuditorData.setHasFixedSize(true);
                    symsAuditorData.setLayoutManager(new LinearLayoutManager(UpdateSyms.this));
                    adapter = new SymsAdapter(list7, UpdateSyms.this, "Auditor");
                    symsAuditorData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void symsAAuditorData() {
        dbRef = reference.child("Assistant Auditor");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list8 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    symsAAuditorNoData.setVisibility(View.VISIBLE);
                    symsAAuditorData.setVisibility(View.GONE);
                }else{
                    symsAAuditorNoData.setVisibility(View.GONE);
                    symsAAuditorData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        SymsData data = snapshot.getValue(SymsData.class);
                        list8.add(data);
                    }
                    symsAAuditorData.setHasFixedSize(true);
                    symsAAuditorData.setLayoutManager(new LinearLayoutManager(UpdateSyms.this));
                    adapter = new SymsAdapter(list8, UpdateSyms.this, "Assistant Auditor");
                    symsAAuditorData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void symsBusData() {
        dbRef = reference.child("Business Manager");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list9 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    symsBusNoData.setVisibility(View.VISIBLE);
                    symsBusData.setVisibility(View.GONE);
                }else{
                    symsBusNoData.setVisibility(View.GONE);
                    symsBusData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        SymsData data = snapshot.getValue(SymsData.class);
                        list9.add(data);
                    }
                    symsBusData.setHasFixedSize(true);
                    symsBusData.setLayoutManager(new LinearLayoutManager(UpdateSyms.this));
                    adapter = new SymsAdapter(list9, UpdateSyms.this, "Business Manager");
                    symsBusData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void symsProData() {
        dbRef = reference.child("Project Manager");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list10 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    symsProNoData.setVisibility(View.VISIBLE);
                    symsProData.setVisibility(View.GONE);
                }else{
                    symsProNoData.setVisibility(View.GONE);
                    symsProData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        SymsData data = snapshot.getValue(SymsData.class);
                        list10.add(data);
                    }
                    symsProData.setHasFixedSize(true);
                    symsProData.setLayoutManager(new LinearLayoutManager(UpdateSyms.this));
                    adapter = new SymsAdapter(list10, UpdateSyms.this, "Project Manager");
                    symsProData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void symsTechData() {
        dbRef = reference.child("Tech Officer");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list11 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    symsTechNoData.setVisibility(View.VISIBLE);
                    symsTechData.setVisibility(View.GONE);
                }else{
                    symsTechNoData.setVisibility(View.GONE);
                    symsTechData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        SymsData data = snapshot.getValue(SymsData.class);
                        list11.add(data);
                    }
                    symsTechData.setHasFixedSize(true);
                    symsTechData.setLayoutManager(new LinearLayoutManager(UpdateSyms.this));
                    adapter = new SymsAdapter(list11, UpdateSyms.this, "Tech Officer");
                    symsTechData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void syms4YrData() {
        dbRef = reference.child("4th Year Representative");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list12 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    syms4YrNoData.setVisibility(View.VISIBLE);
                    syms4YrData.setVisibility(View.GONE);
                }else{
                    syms4YrNoData.setVisibility(View.GONE);
                    syms4YrData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        SymsData data = snapshot.getValue(SymsData.class);
                        list12.add(data);
                    }
                    syms4YrData.setHasFixedSize(true);
                    syms4YrData.setLayoutManager(new LinearLayoutManager(UpdateSyms.this));
                    adapter = new SymsAdapter(list12, UpdateSyms.this, "4th Year Representative");
                    syms4YrData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void syms3YrData() {
        dbRef = reference.child("3rd Year Representative");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list13 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    syms3YrNoData.setVisibility(View.VISIBLE);
                    syms3YrData.setVisibility(View.GONE);
                }else{
                    syms3YrNoData.setVisibility(View.GONE);
                    syms3YrData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        SymsData data = snapshot.getValue(SymsData.class);
                        list13.add(data);
                    }
                    syms3YrData.setHasFixedSize(true);
                    syms3YrData.setLayoutManager(new LinearLayoutManager(UpdateSyms.this));
                    adapter = new SymsAdapter(list13, UpdateSyms.this, "3rd Year Representative");
                    syms3YrData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void syms2YrData() {
        dbRef = reference.child("2nd Year Representative");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list14 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    syms2YrNoData.setVisibility(View.VISIBLE);
                    syms2YrData.setVisibility(View.GONE);
                }else{
                    syms2YrNoData.setVisibility(View.GONE);
                    syms2YrData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        SymsData data = snapshot.getValue(SymsData.class);
                        list14.add(data);
                    }
                    syms2YrData.setHasFixedSize(true);
                    syms2YrData.setLayoutManager(new LinearLayoutManager(UpdateSyms.this));
                    adapter = new SymsAdapter(list14, UpdateSyms.this, "2nd Year Representative");
                    syms2YrData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void syms1YrData() {
        dbRef = reference.child("1st Year Representative");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list15 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    syms1YrNoData.setVisibility(View.VISIBLE);
                    syms1YrData.setVisibility(View.GONE);
                }else{
                    syms1YrNoData.setVisibility(View.GONE);
                    syms1YrData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        SymsData data = snapshot.getValue(SymsData.class);
                        list15.add(data);
                    }
                    syms1YrData.setHasFixedSize(true);
                    syms1YrData.setLayoutManager(new LinearLayoutManager(UpdateSyms.this));
                    adapter = new SymsAdapter(list15, UpdateSyms.this, "1st Year Representative");
                    syms1YrData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void symsG12Data() {
        dbRef = reference.child("Grade 12 Representative");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list16 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    symsG12NoData.setVisibility(View.VISIBLE);
                    symsG12Data.setVisibility(View.GONE);
                }else{
                    symsG12NoData.setVisibility(View.GONE);
                    symsG12Data.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        SymsData data = snapshot.getValue(SymsData.class);
                        list16.add(data);
                    }
                    symsG12Data.setHasFixedSize(true);
                    symsG12Data.setLayoutManager(new LinearLayoutManager(UpdateSyms.this));
                    adapter = new SymsAdapter(list16, UpdateSyms.this, "Grade 12 Representative");
                    symsG12Data.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void symsG11Data() {
        dbRef = reference.child("Grade 11 Representative");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list17 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    symsG11NoData.setVisibility(View.VISIBLE);
                    symsG11Data.setVisibility(View.GONE);
                }else{
                    symsG11NoData.setVisibility(View.GONE);
                    symsG11Data.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        SymsData data = snapshot.getValue(SymsData.class);
                        list17.add(data);
                    }
                    symsG11Data.setHasFixedSize(true);
                    symsG11Data.setLayoutManager(new LinearLayoutManager(UpdateSyms.this));
                    adapter = new SymsAdapter(list17, UpdateSyms.this, "Grade 11 Representative");
                    symsG11Data.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}