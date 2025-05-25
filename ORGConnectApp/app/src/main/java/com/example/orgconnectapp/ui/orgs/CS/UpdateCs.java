package com.example.orgconnectapp.ui.orgs.CS;

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
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class UpdateCs extends AppCompatActivity {
    FloatingActionButton csfabm;
    private RecyclerView csDepartnment;
    private LinearLayout csNoData;
    private List<TeacherData> listT4;
    private TeacherAdapter adapter1;
    private DatabaseReference reference1, dbRef1;
    private RecyclerView csPresData, csVPresData, csSecData, csASecData, csTresData, csATresData, csAuditorData, csAAuditorData, csBusData, csProData, csTechData, cs4YrData, cs3YrData, cs2YrData, cs1YrData, csG12Data, csG11Data;
    private LinearLayout csPresNoData, csVPresNoData, csSecNoData, csASecNoData, csTresNoData, csATresNoData , csAuditorNoData, csAAuditorNoData, csBusNoData, csProNoData, csTechNoData, cs4YrNoData, cs3YrNoData, cs2YrNoData, cs1YrNoData, csG12NoData,   csG11NoData;
    private List<CsData> list1, list2, list3, list4, list5, list6, list7, list8, list9, list10, list11, list12, list13, list14, list15, list16, list17;
    private CsAdapter adapter;
    private DatabaseReference reference, dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_cs);

        csDepartnment = findViewById(R.id.csDepartnment);
        csNoData = findViewById(R.id.csNoData);

        csPresData = findViewById(R.id.csPresData);
        csVPresData = findViewById(R.id.csVPresData);
        csSecData = findViewById(R.id.csSecData);
        csASecData = findViewById(R.id.csASecData);
        csTresData = findViewById(R.id.csTresData);
        csATresData = findViewById(R.id.csATresData);
        csAuditorData = findViewById(R.id.csAuditorData);
        csAAuditorData = findViewById(R.id.csAAuditorData);
        csBusData = findViewById(R.id.csBusData);
        csProData = findViewById(R.id.csProData);
        csTechData = findViewById(R.id.csTechData);
        cs4YrData = findViewById(R.id.cs4YrData);
        cs3YrData = findViewById(R.id.cs3YrData);
        cs2YrData = findViewById(R.id.cs2YrData);
        cs1YrData = findViewById(R.id.cs1YrData);
        csG12Data = findViewById(R.id.csG12Data);
        csG11Data = findViewById(R.id.csG11Data);


        csPresNoData = findViewById(R.id.csPresNoData);
        csVPresNoData = findViewById(R.id.csVPresNoData);
        csSecNoData = findViewById(R.id.csSecNoData);
        csASecNoData = findViewById(R.id.csASecNoData);
        csTresNoData = findViewById(R.id.csTresNoData);
        csATresNoData = findViewById(R.id.csATresNoData);
        csAuditorNoData = findViewById(R.id.csAuditorNoData);
        csAAuditorNoData = findViewById(R.id.csAAuditorNoData);
        csProNoData = findViewById(R.id.csProNoData);
        csBusNoData = findViewById(R.id.csBusNoData);
        csTechNoData = findViewById(R.id.csTechNoData);
        cs4YrNoData = findViewById(R.id.cs4YrNoData);
        cs3YrNoData = findViewById(R.id.cs3YrNoData);
        cs2YrNoData = findViewById(R.id.cs2YrNoData);
        cs1YrNoData = findViewById(R.id.cs1YrNoData);
        csG12NoData = findViewById(R.id.csG12NoData);
        csG11NoData = findViewById(R.id.csG11NoData);

        reference = FirebaseDatabase.getInstance().getReference().child("Computer Society Officers");
        reference1 = FirebaseDatabase.getInstance().getReference().child("Teacher");

        csDepartnment();

        csPresData();
        csVPresData();
        csSecData();
        csASecData();
        csTresData();
        csATresData();
        csAuditorData();
        csAAuditorData();
        csBusData();
        csProData();
        csTechData();
        cs4YrData();
        cs3YrData();
        cs2YrData();
        cs1YrData();
        csG12Data();
        csG11Data();

    }

    private void csDepartnment() {
        dbRef1 = reference1.child("Computer Society Adviser");
        dbRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listT4 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    csNoData.setVisibility(View.VISIBLE);
                    csDepartnment.setVisibility(View.GONE);
                }else{
                    csNoData.setVisibility(View.GONE);
                    csDepartnment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        listT4.add(data);
                    }
                    csDepartnment.setHasFixedSize(true);
                    csDepartnment.setLayoutManager(new LinearLayoutManager(UpdateCs.this));
                    adapter1 = new TeacherAdapter(listT4, UpdateCs.this, "Computer Society Adviser");
                    csDepartnment.setAdapter(adapter1);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateCs.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void csPresData() {
        dbRef = reference.child("President");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    csPresNoData.setVisibility(View.VISIBLE);
                    csPresData.setVisibility(View.GONE);
                }else{
                    csPresNoData.setVisibility(View.GONE);
                    csPresData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        CsData data = snapshot.getValue(CsData.class);
                        list1.add(data);
                    }
                    csPresData.setHasFixedSize(true);
                    csPresData.setLayoutManager(new LinearLayoutManager(UpdateCs.this));
                    adapter = new CsAdapter(list1, UpdateCs.this, "President");
                    csPresData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void csVPresData() {
        dbRef = reference.child("Vice President");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list2 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    csVPresNoData.setVisibility(View.VISIBLE);
                    csVPresData.setVisibility(View.GONE);
                }else{
                    csVPresNoData.setVisibility(View.GONE);
                    csVPresData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        CsData data = snapshot.getValue(CsData.class);
                        list2.add(data);
                    }
                    csVPresData.setHasFixedSize(true);
                    csVPresData.setLayoutManager(new LinearLayoutManager(UpdateCs.this));
                    adapter = new CsAdapter(list2, UpdateCs.this, "Vice President");
                    csVPresData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void csSecData() {
        dbRef = reference.child("Secretary");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list3 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    csSecNoData.setVisibility(View.VISIBLE);
                    csSecData.setVisibility(View.GONE);
                }else{
                    csSecNoData.setVisibility(View.GONE);
                    csSecData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        CsData data = snapshot.getValue(CsData.class);
                        list3.add(data);
                    }
                    csSecData.setHasFixedSize(true);
                    csSecData.setLayoutManager(new LinearLayoutManager(UpdateCs.this));
                    adapter = new CsAdapter(list3, UpdateCs.this, "Secretary");
                    csSecData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void csASecData() {
        dbRef = reference.child("Assistant Secretary");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list4 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    csASecData.setVisibility(View.VISIBLE);
                    csASecData.setVisibility(View.GONE);
                }else{
                    csASecNoData.setVisibility(View.GONE);
                    csASecData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        CsData data = snapshot.getValue(CsData.class);
                        list4.add(data);
                    }
                    csASecData.setHasFixedSize(true);
                    csASecData.setLayoutManager(new LinearLayoutManager(UpdateCs.this));
                    adapter = new CsAdapter(list4, UpdateCs.this, "Assistant Secretary");
                    csASecData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void csTresData() {
        dbRef = reference.child("Treasurer");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list5 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    csTresNoData.setVisibility(View.VISIBLE);
                    csTresData.setVisibility(View.GONE);
                }else{
                    csTresNoData.setVisibility(View.GONE);
                    csTresData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        CsData data = snapshot.getValue(CsData.class);
                        list5.add(data);
                    }
                    csTresData.setHasFixedSize(true);
                    csTresData.setLayoutManager(new LinearLayoutManager(UpdateCs.this));
                    adapter = new CsAdapter(list5, UpdateCs.this, "Treasurer");
                    csTresData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void csATresData() {
        dbRef = reference.child("Assistant Treasurer");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list6 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    csATresNoData.setVisibility(View.VISIBLE);
                    csATresData.setVisibility(View.GONE);
                }else{
                    csATresNoData.setVisibility(View.GONE);
                    csATresData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        CsData data = snapshot.getValue(CsData.class);
                        list6.add(data);
                    }
                    csATresData.setHasFixedSize(true);
                    csATresData.setLayoutManager(new LinearLayoutManager(UpdateCs.this));
                    adapter = new CsAdapter(list6, UpdateCs.this, "Assistant Treasurer");
                    csATresData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void csAuditorData() {
        dbRef = reference.child("Auditor");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list7 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    csAuditorNoData.setVisibility(View.VISIBLE);
                    csAuditorData.setVisibility(View.GONE);
                }else{
                    csAuditorNoData.setVisibility(View.GONE);
                    csAuditorData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        CsData data = snapshot.getValue(CsData.class);
                        list7.add(data);
                    }
                    csAuditorData.setHasFixedSize(true);
                    csAuditorData.setLayoutManager(new LinearLayoutManager(UpdateCs.this));
                    adapter = new CsAdapter(list7, UpdateCs.this, "Auditor");
                    csAuditorData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void csAAuditorData() {
        dbRef = reference.child("Assistant Auditor");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list8 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    csAAuditorNoData.setVisibility(View.VISIBLE);
                    csAAuditorData.setVisibility(View.GONE);
                }else{
                    csAAuditorNoData.setVisibility(View.GONE);
                    csAAuditorData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        CsData data = snapshot.getValue(CsData.class);
                        list8.add(data);
                    }
                    csAAuditorData.setHasFixedSize(true);
                    csAAuditorData.setLayoutManager(new LinearLayoutManager(UpdateCs.this));
                    adapter = new CsAdapter(list8, UpdateCs.this, "Assistant Auditor");
                    csAAuditorData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void csBusData() {
        dbRef = reference.child("Business Manager");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list9 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    csBusNoData.setVisibility(View.VISIBLE);
                    csBusData.setVisibility(View.GONE);
                }else{
                    csBusNoData.setVisibility(View.GONE);
                    csBusData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        CsData data = snapshot.getValue(CsData.class);
                        list9.add(data);
                    }
                    csBusData.setHasFixedSize(true);
                    csBusData.setLayoutManager(new LinearLayoutManager(UpdateCs.this));
                    adapter = new CsAdapter(list9, UpdateCs.this, "Business Manager");
                    csBusData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void csProData() {
        dbRef = reference.child("Project Manager");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list10 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    csProNoData.setVisibility(View.VISIBLE);
                    csProData.setVisibility(View.GONE);
                }else{
                    csProNoData.setVisibility(View.GONE);
                    csProData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        CsData data = snapshot.getValue(CsData.class);
                        list10.add(data);
                    }
                    csProData.setHasFixedSize(true);
                    csProData.setLayoutManager(new LinearLayoutManager(UpdateCs.this));
                    adapter = new CsAdapter(list10, UpdateCs.this, "Project Manager");
                    csProData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void csTechData() {
        dbRef = reference.child("Tech Officer");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list11 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    csTechNoData.setVisibility(View.VISIBLE);
                    csTechData.setVisibility(View.GONE);
                }else{
                    csTechNoData.setVisibility(View.GONE);
                    csTechData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        CsData data = snapshot.getValue(CsData.class);
                        list11.add(data);
                    }
                    csTechData.setHasFixedSize(true);
                    csTechData.setLayoutManager(new LinearLayoutManager(UpdateCs.this));
                    adapter = new CsAdapter(list11, UpdateCs.this, "Tech Officer");
                    csTechData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void cs4YrData() {
        dbRef = reference.child("4th Year Representative");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list12 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    cs4YrNoData.setVisibility(View.VISIBLE);
                    cs4YrData.setVisibility(View.GONE);
                }else{
                    cs4YrNoData.setVisibility(View.GONE);
                    cs4YrData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        CsData data = snapshot.getValue(CsData.class);
                        list12.add(data);
                    }
                    cs4YrData.setHasFixedSize(true);
                    cs4YrData.setLayoutManager(new LinearLayoutManager(UpdateCs.this));
                    adapter = new CsAdapter(list12, UpdateCs.this, "4th Year Representative");
                    cs4YrData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void cs3YrData() {
        dbRef = reference.child("3rd Year Representative");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list13 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    cs3YrNoData.setVisibility(View.VISIBLE);
                    cs3YrData.setVisibility(View.GONE);
                }else{
                    cs3YrNoData.setVisibility(View.GONE);
                    cs3YrData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        CsData data = snapshot.getValue(CsData.class);
                        list13.add(data);
                    }
                    cs3YrData.setHasFixedSize(true);
                    cs3YrData.setLayoutManager(new LinearLayoutManager(UpdateCs.this));
                    adapter = new CsAdapter(list13, UpdateCs.this, "3rd Year Representative");
                    cs3YrData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void cs2YrData() {
        dbRef = reference.child("2nd Year Representative");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list14 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    cs2YrNoData.setVisibility(View.VISIBLE);
                    cs2YrData.setVisibility(View.GONE);
                }else{
                    cs2YrNoData.setVisibility(View.GONE);
                    cs2YrData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        CsData data = snapshot.getValue(CsData.class);
                        list14.add(data);
                    }
                    cs2YrData.setHasFixedSize(true);
                    cs2YrData.setLayoutManager(new LinearLayoutManager(UpdateCs.this));
                    adapter = new CsAdapter(list14, UpdateCs.this, "2nd Year Representative");
                    cs2YrData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void cs1YrData() {
        dbRef = reference.child("1st Year Representative");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list15 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    cs1YrNoData.setVisibility(View.VISIBLE);
                    cs1YrData.setVisibility(View.GONE);
                }else{
                    cs1YrNoData.setVisibility(View.GONE);
                    cs1YrData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        CsData data = snapshot.getValue(CsData.class);
                        list15.add(data);
                    }
                    cs1YrData.setHasFixedSize(true);
                    cs1YrData.setLayoutManager(new LinearLayoutManager(UpdateCs.this));
                    adapter = new CsAdapter(list15, UpdateCs.this, "1st Year Representative");
                    cs1YrData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void csG12Data() {
        dbRef = reference.child("Grade 12 Representative");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list16 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    csG12NoData.setVisibility(View.VISIBLE);
                    csG12Data.setVisibility(View.GONE);
                }else{
                    csG12NoData.setVisibility(View.GONE);
                    csG12Data.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        CsData data = snapshot.getValue(CsData.class);
                        list16.add(data);
                    }
                    csG12Data.setHasFixedSize(true);
                    csG12Data.setLayoutManager(new LinearLayoutManager(UpdateCs.this));
                    adapter = new CsAdapter(list16, UpdateCs.this, "Grade 12 Representative");
                    csG12Data.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void csG11Data() {
        dbRef = reference.child("Grade 11 Representative");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list17 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    csG11NoData.setVisibility(View.VISIBLE);
                    csG11Data.setVisibility(View.GONE);
                }else{
                    csG11NoData.setVisibility(View.GONE);
                    csG11Data.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        CsData data = snapshot.getValue(CsData.class);
                        list17.add(data);
                    }
                    csG11Data.setHasFixedSize(true);
                    csG11Data.setLayoutManager(new LinearLayoutManager(UpdateCs.this));
                    adapter = new CsAdapter(list17, UpdateCs.this, "Grade 11 Representative");
                    csG11Data.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}